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

import net.engineeringdigest.journalApp.Service.StandardService;
import net.engineeringdigest.journalApp.Entity.Standard;

@RestController
@RequestMapping("/api/standards")
public class StandardController {
	@Autowired
	private StandardService standardService;
	
	@GetMapping
	public List<Standard> getAllStandards(){
		return standardService.getAllStandards();
	}
	
	@GetMapping("/{id}")
	public Standard getStandardById(@PathVariable Long id) {
		return standardService.getStandardById(id);
	}
	
	@PostMapping
	public Standard createStandard(@RequestBody Standard standard) {
		return standardService.createStandard(standard);
	}
	
	@PutMapping("/{id}")
	public Standard updateStandard(@PathVariable Long id ,@RequestBody Standard standard) {
		return standardService.updateStandard(id , standard);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStandard(@PathVariable Long id) {
		standardService.deleteStandard(id);
	}
	
}
