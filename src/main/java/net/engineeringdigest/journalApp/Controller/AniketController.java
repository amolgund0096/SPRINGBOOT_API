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

import net.engineeringdigest.journalApp.Entity.Aniket;
import net.engineeringdigest.journalApp.Service.AniketService;

@RestController
@RequestMapping("api/testing/info")
public class AniketController {
	@Autowired
	private AniketService anService;
	
	@GetMapping
	public List<Aniket> getAll(){
		return (List<Aniket>) anService.getAll();
	}

	@GetMapping("/{id}")
	public Aniket getById(@PathVariable Long id) {
		return anService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Aniket updateById(@RequestBody Aniket aniket , @PathVariable Long id) {
		return anService.updateRecord(aniket, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		anService.deleteById(id);
	}
	
	@PostMapping
	public Aniket createData(@RequestBody Aniket aniket) {
		return anService.createData(aniket);
	}
	
}
