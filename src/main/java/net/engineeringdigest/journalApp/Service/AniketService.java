package net.engineeringdigest.journalApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.engineeringdigest.journalApp.Entity.Aniket;
import net.engineeringdigest.journalApp.Repository.AniketRepository;

@Service
public class AniketService {
	@Autowired
    private	AniketRepository anRepo;
	
	public List<Aniket> getAllRecords(){
		return (List<Aniket>) anRepo.findAll();
	}
	
	public Aniket getRecordById(Long id) {
		return (Aniket) anRepo.findById(id).orElse(null);
	}
	
	public Aniket createRecord(Aniket aniket) {
		return anRepo.save(aniket);
	}
	
	public void deleteRecord(Long id) {
		 anRepo.deleteById(id); 
	}
	
	public Aniket updateRecord(Long id , Aniket updateRecord) {
		return (Aniket) anRepo.findById(id).map(aniket->{
			((Aniket) aniket).setName(updateRecord.getName());
			((Aniket) aniket).setEmail(updateRecord.getEmail());
			((Aniket) aniket).setContact(updateRecord.getContact());
			return anRepo.save(aniket);
		}).orElse(null);
	}

}
