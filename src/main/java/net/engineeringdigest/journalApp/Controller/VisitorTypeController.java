package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.VisitorType;
import net.engineeringdigest.journalApp.Repository.VisitorTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/visitortypes")
public class VisitorTypeController {
    private final VisitorTypeRepository repo;

    public VisitorTypeController(VisitorTypeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<VisitorType> getAll() {
        return repo.findAll();
    }
}

