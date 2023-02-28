package cm.cti.entreprise.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cm.cti.entreprise.Service.Impl.EntrepriseService;
import cm.cti.entreprise.models.Entreprise;


@RestController
@RequestMapping("api/entreprise")
public class EntrepriseControleur {
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@GetMapping("/{id}")
	public Entreprise findBYId(
			@PathVariable("id") Long id) {
		
			return entrepriseService.find(id);
			}
	

	@PostMapping
	public Entreprise create(
			@RequestBody Entreprise entreprise
			) {
			entreprise.setId(null);
	
			entrepriseService.add(entreprise);
			return entreprise;
			}
	
	@PutMapping
	public Entreprise update(
			@RequestBody Entreprise entreprise
			) {	
			entrepriseService.add(entreprise);
			return entreprise;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
			entrepriseService.delete(id);
			return "Ok";
	}
	
	
	
	

}
