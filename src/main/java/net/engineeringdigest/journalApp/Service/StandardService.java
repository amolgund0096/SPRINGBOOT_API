package net.engineeringdigest.journalApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.engineeringdigest.journalApp.Entity.Sample;
import net.engineeringdigest.journalApp.Entity.Standard;
import net.engineeringdigest.journalApp.Repository.StandardRepositiry;

@Service
public class StandardService {
	@Autowired
	private StandardRepositiry standardRepository;
	
	public List<Standard> getAllStandards(){
		return (List<Standard>) standardRepository.findAll();
	}
	
	public Standard getStandardById (Long id) {
		return standardRepository.findById(id).orElse(null);
	}
	
	public Standard createStandard(Standard standard) {
		return (Standard) standardRepository.save(standard);
	}
	
	public Standard updateStandard (Long id ,  Standard updateStandard) {
		  return (Standard) standardRepository.findById(id).map(standard -> {
	          ((Standard) standard).setStandard_desc(updateStandard.getStandard_desc());
	          ((Standard) standard).setStatus(updateStandard.getStatus());
	          ((Standard) standard).setStandard_order(updateStandard.getStandard_order());
	          return standardRepository.save(standard);
	      }).orElse(null);
	}
	

	public void deleteStandard(Long id) {
		 standardRepository.deleteById(id);
	}

}
