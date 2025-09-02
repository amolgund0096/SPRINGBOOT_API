package net.engineeringdigest.journalApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.engineeringdigest.journalApp.Entity.Standard;

public interface StandardRepositiry extends JpaRepository<Standard, Long>{

}
