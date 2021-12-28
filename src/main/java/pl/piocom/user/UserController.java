package pl.piocom.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.piocom.company.Company;
import pl.piocom.company.CompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    public UserController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping("/user-list")
    public String userList() {
        userService.getAll();
        return "/user-list";
    }

    @GetMapping("/user-add")
    public String getForm(@ModelAttribute("user") User user, ModelMap modelMap) {
        List<Company> allCompanies = companyService.getAll();
        modelMap.addAttribute("allCompanies", allCompanies);
        return "/user-add";
    }

    @PostMapping("/user-add")
    public String createUser(User user) {
        userService.create(user);
        return "redirect:/";
    }
}
