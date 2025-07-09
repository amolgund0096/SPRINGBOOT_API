package net.engineeringdigest.journalApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Entity.Amol;
import net.engineeringdigest.journalApp.Service.AmolService;

@RestController
@RequestMapping("/api/amol")
public class AmolController {

	@Autowired
	private AmolService amolService;
	
		@GetMapping
		public List<Amol> getAllAmol(){
			return amolService.getAllAmol();
		}
		
		@GetMapping("/{id}")
		public Amol getAmolById(@PathVariable Long id) {
			return amolService.getAmolById(id);
		}
		
		@PostMapping
		public Amol createAmol(@RequestBody Amol amol) {
			return amolService.createAmol(amol);
		}
		
		@PutMapping("/{id}")
		public Amol updateAmol(@PathVariable Long id , @RequestBody Amol amol) {
			return updateAmol(id, amol);
		}
		
		@DeleteMapping("/{id}")
		public void deleteAmol(@PathVariable Long id) {
			 amolService.deleteAmol(id);
		}
}
