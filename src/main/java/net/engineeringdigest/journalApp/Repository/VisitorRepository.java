package net.engineeringdigest.journalApp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.engineeringdigest.journalApp.Entity.Visitor;

import java.time.LocalDate;
import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    List<Visitor> findByVisitDate(LocalDate visitDate);
    int countByVisitDate(LocalDate visitDate);
}

