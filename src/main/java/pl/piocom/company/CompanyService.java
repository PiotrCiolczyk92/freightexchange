package pl.piocom.company;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.piocom.company.Company;
import pl.piocom.company.CompanyRepository;
import pl.piocom.entity.Location;
import pl.piocom.repositories.LocationRepository;

import java.util.List;

@Service
@Slf4j
public class CompanyService {
    CompanyRepository companyRepository;
    LocationRepository locationRepository;

    public CompanyService(CompanyRepository companyRepository, LocationRepository locationRepository) {
        this.companyRepository = companyRepository;
        this.locationRepository = locationRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getById(int id) {
        return companyRepository.getById(id);
    }

    //This method creating location and then adding it to company that we want to create.
    public void create(Company company, Location location) {
        if (company.getId() != null && location.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Created company/location shall not have existing ID");
            log.error("Company/Location has not been created", exception);
        }
        location.setCountry(location.getCountryCode().label);
        locationRepository.save(location);
        company.setLocation(location);
        companyRepository.save(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }
}
