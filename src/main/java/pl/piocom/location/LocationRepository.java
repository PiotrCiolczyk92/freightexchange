package pl.piocom.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piocom.location.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
