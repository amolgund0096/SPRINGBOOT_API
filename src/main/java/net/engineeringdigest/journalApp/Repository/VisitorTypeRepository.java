package net.engineeringdigest.journalApp.Repository;


import net.engineeringdigest.journalApp.Entity.VisitorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorTypeRepository extends JpaRepository<VisitorType, Integer> {
	
}
