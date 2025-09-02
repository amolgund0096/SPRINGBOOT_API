package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entity.Visitor;
import net.engineeringdigest.journalApp.Repository.VisitorRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VisitorService {
    private final VisitorRepository repo;

    @Value("${vis.upload.dir}")
    private String uploadDir;

    public VisitorService(VisitorRepository repo) {
        this.repo = repo;
    }

    public Visitor saveVisitor(Visitor v, MultipartFile photoFile) throws IOException {
        if (photoFile != null && !photoFile.isEmpty()) {
            String filename = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
            Path filePath = uploadPath.resolve(filename);
            photoFile.transferTo(filePath);
            v.setPhotoPath(filename);
        }
        return repo.save(v);
    }

    public List<Visitor> getByDate(LocalDate date) {
        return repo.findByVisitDate(date);
    }

    public int countByDate(LocalDate date) {
        return repo.countByVisitDate(date);
    }

    public Visitor updateVisitor(Visitor v) {
        return repo.save(v);
    }

    public Visitor recordExitTime(Long id) {
        return repo.findById(id).map(v -> {
            v.setExitTime(LocalTime.now());
            return repo.save(v);
        }).orElse(null);
    }

    public Visitor getVisitor(Long id) {
        return repo.findById(id).orElse(null);
    }
}
