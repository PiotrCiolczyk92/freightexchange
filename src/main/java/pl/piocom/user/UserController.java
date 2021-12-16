package pl.piocom.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-list")
    public String userList() {
        userService.getAll();
        return "/user-list";
    }

    @PostMapping("/user-add")
    public String getForm(@ModelAttribute("user") User user) {
        return "/user-add";
    }

    @PostMapping("/user-add")
    public String createUser(User user) {
        userService.create(user);
        return "/";
    }
}
