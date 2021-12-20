package pl.piocom.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getAll() {
        companyService.getAll();
        return "/company-list";
    }

    @PostMapping
    public String getForm(@ModelAttribute("company") Company company) {
        return "/add-company";
    }

    @PostMapping
    public String addCompany(Company company) {
        companyService.creat(company);
        return "redirect:/";
    }
}
