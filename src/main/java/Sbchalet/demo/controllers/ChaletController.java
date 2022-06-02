package Sbchalet.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.payload.request.ChaletRequest;
import Sbchalet.demo.repository.ChaletRepository;
import Sbchalet.demo.services.ChaletServiceImpl;
import Sbchalet.demo.services.DatabaseFileService;

@RestController
@CrossOrigin
@RequestMapping("/api/chalet")

public class ChaletController {
	
	@Autowired
	private ChaletServiceImpl chaletservice ;	
	@Autowired 
	private ChaletRepository chaletRepository;
	@Autowired 
	private DatabaseFileService dbService;
	
	//Paging&Sorting
	@GetMapping("/page-and-sort")
	  public Page<Chalet> getAllTutorialsPage(
			  Pageable pageable) {

		return chaletRepository.findAll(pageable);
	}

	@GetMapping("")
	public List<Chalet> getAllPost() {
		return this.chaletservice.list();
	}

	@GetMapping("/{chalet-id}")
	@ResponseBody
	public Optional<Chalet> retrieveChalet(@PathVariable("chalet-id") int chalet_id) {
		return this.chaletservice.getById(chalet_id);
	}

	@PostMapping("")
	@ResponseBody
	public Chalet addChalet(@RequestBody ChaletRequest ch) {
		Chalet chalet = new Chalet(ch.getDescription(), ch.getPrix(), ch.getAdresse(), ch.getEtat(), ch.getVille(), ch.getCodeZip(), ch.getMaxAdulte(), ch.getMaxEnfant(), ch.getMaxBebe(), ch.getMaxAnimal());
		Chalet savedChalet = this.chaletservice.save(chalet);
		if(ch.getImages().size() >0) {
			
			ch.getImages().stream().forEach(img->{
				
				this.dbService.updateFileChalet(img.getId(), savedChalet);
			});
		}
		
		return savedChalet;
	}

	@DeleteMapping("/{id_chalet}")
	@ResponseBody
	public void removeChalet(@PathVariable("id_chalet") int id_chalet) {
		chaletservice.remove(id_chalet);
	}

	@PutMapping("/{id_chalet}")
	@ResponseBody
	public Chalet modifyChalet(@PathVariable int id_chalet, @RequestBody Chalet chalet) {
		return chaletservice.updateChalet(id_chalet, chalet);
	}
	
	@PatchMapping("/{id}")
	@ResponseBody
	public Chalet modifyChalet(@PathVariable int id, @RequestBody ChaletRequest chaletRequest) {
		Chalet chalet = this.chaletservice.getChaletById(id);
		chalet.setDescription(chaletRequest.getDescription());
		chalet.setPrix(chaletRequest.getPrix());
		chalet.setAdresse(chaletRequest.getAdresse());
		chalet.setEtat(chaletRequest.getEtat());
		chalet.setVille(chaletRequest.getVille());
		chalet.setCodeZip(chaletRequest.getCodeZip());
		chalet.setMaxAdulte(chaletRequest.getMaxAdulte());
		chalet.setMaxEnfant(chaletRequest.getMaxEnfant());
		chalet.setMaxBebe(chaletRequest.getMaxBebe());
		chalet.setMaxAnimal(chaletRequest.getMaxAnimal());
		return this.chaletservice.updateChalet(id, chalet);
	}
}
