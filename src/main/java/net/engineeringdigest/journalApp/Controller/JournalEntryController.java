package net.engineeringdigest.journalApp.Controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.Entity.JournalEntry;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
	
	private Map<Long,JournalEntry>journalEntries = new HashMap<Long, JournalEntry>();
	
	@GetMapping("/lmn")
	public List<JournalEntry> getAll(){
		return new ArrayList<JournalEntry>(journalEntries.values());
		
	}
	
	@PostMapping("/opr")
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
		journalEntries.put(myEntry.getId(), myEntry);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public JournalEntry getJournalEntryById(@PathVariable Long myId) {
		return journalEntries.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public JournalEntry deleteJournalEntry(@PathVariable Long myId) {
		return journalEntries.remove(myId);
	}
	
	
	
	@PutMapping("/id{id}")
	public JournalEntry updateJournalEntry(@PathVariable Long id  , @RequestBody JournalEntry myEntry) {
		return journalEntries.put(id, myEntry);
	}
	
	
	
}
