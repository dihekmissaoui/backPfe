package Sbchalet.demo.controllers;

import java.net.InetAddress;
import java.util.List;
import java.util.Optional;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.constants.EmailConstants;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.models.User;
import Sbchalet.demo.payload.request.ReservationRequest;
import Sbchalet.demo.payload.response.ReservationResponse;
import Sbchalet.demo.services.IChaletService;
import Sbchalet.demo.services.IEmailSenderService;
import Sbchalet.demo.services.IReservationService;
import Sbchalet.demo.services.IUserservice;
import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservation")
public class ReservationController {

	private IReservationService reservationService;
	private IChaletService chaletService;
	private IUserservice userService;
	private IEmailSenderService emailSenderService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	Environment environment;

	@Autowired
	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@Autowired
	public void setChaletService(IChaletService chaletService) {
		this.chaletService = chaletService;
	}

	@Autowired
	public void setUserService(IUserservice userService) {
		this.userService = userService;
	}

	@Autowired
	public void setEmailSenderService(IEmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@GetMapping("")
	public List<Reservation> getAllPost() {
		return this.reservationService.list();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ReservationResponse getById(@PathVariable("id") int idResarvation) {
		Optional<Reservation> optional = this.reservationService.getById(idResarvation);
		ReservationResponse resp = new ReservationResponse();
		if (optional.isPresent()) {
			Reservation r = optional.get();
			resp = mapToReservationResponse(r);
		}

		return resp;
	}

	@PatchMapping("/{id}")
	@ResponseBody
	public Reservation updateReservation(@PathVariable int id, @RequestParam("changeStatus") boolean changeStatus,
			@RequestBody Reservation reservation) {
		if (changeStatus) {
			return reservationService.changeStatus(id, reservation);
		} else {
			return reservationService.updateReservation(id, reservation);
		}
	}

	@PostMapping("")
	@ResponseBody
	public Reservation addReservation(@RequestBody ReservationRequest reservationRequest) throws Exception {
		Optional<Chalet> optionalData = this.chaletService.getById(reservationRequest.getChaletId());
		Reservation reservation = null;
		if (!optionalData.isPresent()) {
			throw new NotFound("Veuillez reéssayer ultérieurement", null, null);
		} else {
			Chalet chalet = optionalData.get();
			User user = this.generateUser(reservationRequest);

			reservation = new Reservation();
			Reservation payload = new Reservation(reservationRequest.getDateDeDebut(),
					reservationRequest.getDateDeDefin(), reservationRequest.getNbNuites(),
					reservationRequest.getTotalPrix(), reservationRequest.getNbAdultes(),
					reservationRequest.getNbEnfant(), reservationRequest.getNbAnimal(), "PENDING", user, chalet);
			
			reservation = reservationService.save(payload);
			
			String Url = "http://localhost:4200/app/reservation/"+reservation.getId();
			
			String emailBody = EmailConstants.EMAIL_RESERVATION_BODY+" \n "+ Url + " \n "
//					+"Vous pouvez utiliser l\' email/mot de passe suivants pour vous authentifier \n "
//					+ "email: "+user.getEmail() + " \n "
//					+ "mdp: "+reservationRequest.getUser().getPassword()
			; 
			
								
					;
			this.emailSenderService.sendEmail(user.getEmail(), EmailConstants.EMAIL_RESERVATION_SUBJECT,
					emailBody);
		}
		return reservation;
	}

	private User generateUser(ReservationRequest reservationRequest) {
		String userName = reservationRequest.getUser().getUsername();
		String nom = reservationRequest.getUser().getNom();
		String prenom = reservationRequest.getUser().getPrenom();
		String email = reservationRequest.getUser().getEmail();
		String password = encoder.encode(reservationRequest.getUser().getPassword());

		User user = new User(userName, nom, prenom, email, password);

		return this.userService.saveUser(user);
	}

	@DeleteMapping("/{idResarvation}")
	@ResponseBody
	public void removeReservation(@PathVariable("idResarvation") int idResarvation) {
		reservationService.remove(idResarvation);
	}

	private ReservationResponse mapToReservationResponse(Reservation reservation) {
		ReservationResponse resp = new ReservationResponse();
		resp.setId(reservation.getId());
		resp.setDateDeDebut(reservation.getDateDeDebut());
		resp.setDateDeDefin(reservation.getDateDeDefin());
		resp.setNbNuites(reservation.getNbNuites());
		resp.setTotalPrix(reservation.getTotalPrix());
		resp.setNbAdultes(reservation.getNbAdultes());
		resp.setNbEnfant(reservation.getNbEnfant());
		resp.setNbAnimal(reservation.getNbAnimal());
		resp.setStatus(reservation.getStatus());
		resp.setChalet(reservation.getChalet());
		resp.setUser(reservation.getUser());
		resp.setFiles(reservation.getFiles());
		resp.setFactures(reservation.getFactures());
		return resp;
	}
}
