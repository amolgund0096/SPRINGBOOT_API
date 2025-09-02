package net.engineeringdigest.journalApp.Controller;


import net.engineeringdigest.journalApp.Entity.Visitor;
import net.engineeringdigest.journalApp.Service.VisitorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/visitors")
public class VisitorController {
    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Visitor> list(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return service.getByDate(date);
    }

    @GetMapping("/count")
    public int count(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return service.countByDate(date);
    }

    @PostMapping
    public ResponseEntity<Visitor> add(
            @RequestPart("visitor") Visitor v,
            @RequestPart(value = "photo", required = false) MultipartFile photo
    ) throws IOException {
        Visitor saved = service.saveVisitor(v, photo);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitor> update(@PathVariable Long id, @RequestBody Visitor v) {
        v.setId(id);
        return ResponseEntity.ok(service.updateVisitor(v));
    }

    @PatchMapping("/{id}/exit")
    public ResponseEntity<Visitor> exit(@PathVariable Long id) {
        Visitor updated = service.recordExitTime(id);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getOne(@PathVariable Long id) {
        Visitor v = service.getVisitor(id);
        return v != null ? ResponseEntity.ok(v) : ResponseEntity.notFound().build();
    }
}

