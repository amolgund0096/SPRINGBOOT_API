package net.engineeringdigest.journalApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.engineeringdigest.journalApp.Entity.Amol;
import net.engineeringdigest.journalApp.Entity.Sample;
import net.engineeringdigest.journalApp.Repository.AmolRepository;

@Service
public class AmolService {
	@Autowired
	private AmolRepository amolRepository;
	
	public List<Amol>getAllAmol(){
		return (List<Amol>) amolRepository.findAll();
	}
	
	public Amol getAmolById(Long id) {
		return (Amol) amolRepository.findById(id).orElse(null);
	}
	
	public Amol createAmol(Amol amol) {
		return (Amol) amolRepository.save(amol);
	}
	
	public Amol updateAmol(Long id , Amol updateAmol) {
		return(Amol) amolRepository.findById(id).map(amol->{
			((Amol) amol).setName(updateAmol.getName());
			((Amol) amol).setEmail(updateAmol.getEmail());
			((Amol) amol).setContact(updateAmol.getContact());
			return amolRepository.save(amol);
		}).orElse(null);
	}
	
	  public void deleteAmol(Long id) {
	      amolRepository.deleteById(id);
	  }	

}
