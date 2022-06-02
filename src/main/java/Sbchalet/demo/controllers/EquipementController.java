package Sbchalet.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.Equipement;
import Sbchalet.demo.services.IEquipementService;

@RestController
@CrossOrigin
@RequestMapping("/api/equipement")
public class EquipementController {

	@Autowired
	private IEquipementService equipementService;

	@GetMapping("")
	public List<Equipement> list(){
		return this.equipementService.find();
	}

	@PostMapping("")
	public Equipement save(@RequestBody Equipement equipement) {
		return this.equipementService.save(equipement);
	}
	
	@PatchMapping("{id}")
	public Equipement patch(@PathVariable int id, @RequestBody Equipement equipement) {
		return this.equipementService.patch(id, equipement);
	}
	
	@DeleteMapping("{id}")
	public String remove(@PathVariable int id) {
		this.equipementService.delete(id);
		return "deleted";
	}
}
