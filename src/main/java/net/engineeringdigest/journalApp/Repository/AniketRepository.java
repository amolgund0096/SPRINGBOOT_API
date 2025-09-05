package net.engineeringdigest.journalApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.engineeringdigest.journalApp.Entity.Aniket;

@Repository
public interface AniketRepository extends JpaRepository<Aniket, Long>{

}
