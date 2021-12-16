package pl.piocom.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.piocom.entity.Location;
import pl.piocom.repositories.LocationRepository;

import java.util.List;

@Slf4j
@Service
public class LocationService {
    private LocationRepository locationRepository;

    private LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location getById(Integer id) {
        return locationRepository.getById(id);
    }

    public void create(Location location) {
        if (location.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Created location shall not have existing ID");
            log.error("Location has not been saved", exception);
            throw exception;
        }
        location.setCountry(location.getCountryCode().label);
        locationRepository.save(location);
    }

    public void deleteByUsingId(Location location) {
        locationRepository.delete(location);
    }
}
