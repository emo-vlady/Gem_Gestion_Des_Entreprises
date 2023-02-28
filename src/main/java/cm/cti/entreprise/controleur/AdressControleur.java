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

import cm.cti.entreprise.Service.Impl.AdressService;
import cm.cti.entreprise.models.Adress;

@RestController
@RequestMapping("api/adress")
public class AdressControleur {
	
	@Autowired
	private AdressService adressService;
	
	@GetMapping("/{id}")
	public Adress findBYId(
			@PathVariable("id") Long id) {
		
			return adressService.find(id);
			}
	

	@PostMapping
	public Adress create(
			@RequestBody Adress adress
			) {
			adress.setId(null);
	
			adressService.add(adress);
			return adress;
			}
	
	@PutMapping
	public Adress update(
			@RequestBody Adress adress
			) {	
			adressService.add(adress);
			return adress;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
			adressService.delete(id);
			return "Ok";
	}
	
	
	
	

}
