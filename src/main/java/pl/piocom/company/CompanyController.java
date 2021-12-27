package pl.piocom.company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.piocom.entity.Location;
import pl.piocom.enums.CountryCode;
import pl.piocom.services.LocationService;

import java.util.EnumSet;
import java.util.Set;

@Controller
public class CompanyController {

    private final CompanyService companyService;
    private final LocationService locationService;

    public CompanyController(CompanyService companyService, LocationService locationService) {
        this.companyService = companyService;
        this.locationService = locationService;
    }

    @GetMapping("/company-list")
    public String getAll() {
        companyService.getAll();
        return "/company-list";
    }

    //This maping using company and location attributes so we can use them in one html form.
    @GetMapping("/company-add")
    public String getForm(@ModelAttribute("company") Company company, @ModelAttribute("location") Location location, ModelMap modelMap) {
        Set<CountryCode> allCodes = EnumSet.allOf(CountryCode.class);
        modelMap.addAttribute("allCodes", allCodes);
        return "/company-add";
    }

    //This mapping creating location and then using this location to create company that has location field in it.
    @PostMapping("/company-add")
    public String addCompany(Company company, Location location) {
        companyService.create(company, location);
        return "redirect:/";
    }
}
