package pl.piocom.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.piocom.entity.Company;
import pl.piocom.repositories.CompanyRepository;

import java.util.List;

@Service
@Slf4j
public class CompanyService {
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getById(int id) {
       return companyRepository.getById(id);
    }

    public void creat(Company company) {
        if (company.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Created company shall not have existing ID");
            log.error("Company has not been created", exception);
        }
        companyRepository.save(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }
}
