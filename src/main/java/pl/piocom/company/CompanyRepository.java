package pl.piocom.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piocom.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
