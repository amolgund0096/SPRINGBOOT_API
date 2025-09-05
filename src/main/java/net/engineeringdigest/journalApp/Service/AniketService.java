package net.engineeringdigest.journalApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.engineeringdigest.journalApp.Entity.Aniket;
import net.engineeringdigest.journalApp.Repository.AniketRepository;

@Service
public class AniketService {
	@Autowired
	private AniketRepository anRepo;
	
	public List<Aniket> getAll(){
		return (List<Aniket>) anRepo.findAll();
	}
	
	public Aniket getById(Long id) {
		return (Aniket) anRepo.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		anRepo.deleteById(id);
	}
	
	public Aniket updateRecord(Aniket updateRecord , Long id) {
		return (Aniket) anRepo.findById(id).map(aniket->{
			((Aniket) aniket).setContact(updateRecord.getContact());
			((Aniket) aniket).setEmail(updateRecord.getEmail());
			((Aniket) aniket).setFirst_name(updateRecord.getFirst_name());
			((Aniket) aniket).setLast_name(updateRecord.getLast_name());
			return anRepo.save(aniket);
		}).orElse(null);
	}
	
	public Aniket  createData(Aniket aniket) {
		return anRepo.save(aniket);
	}

}
