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
@RequestMapping("/api/connect")
public class AniketController {
	@Autowired 
	
	private AniketService aniService;
	
	@GetMapping
	public List<Aniket> getAllRecords(){
		return (List<Aniket>) aniService.getAllRecords();
	}
	
	@GetMapping("/{id}")
	public Aniket getRecordById(@PathVariable Long id) {
		return (Aniket) aniService.getRecordById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecordById(@PathVariable Long id) {
		aniService.deleteRecord(id);
	}
	
	@PutMapping("/{id}")
	public Aniket updateRecord(@RequestBody Aniket aniket,@PathVariable Long id) {
		return aniService.updateRecord(id, aniket);
	}
	
	@PostMapping
	public Aniket createRecord(@RequestBody Aniket aniket) {
		return aniService.createRecord(aniket);
	}

}
