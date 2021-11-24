package pl.piocom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piocom.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
