package pl.piocom.location;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.piocom.enums.CountryCode;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class LocationController {

    private LocationService locationService;

    @GetMapping("/location-list")
    public String locationList(ModelMap modelMap) {
        List<Location> locations = locationService.getAll();
        modelMap.addAttribute("locations", locations);
        return "/location-list";
    }

    @GetMapping("/location-add")
    public String getForm(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Set<CountryCode> allCodes = EnumSet.allOf(CountryCode.class);
        modelMap.addAttribute("allCodes", allCodes);
        return "location-add";
    }

    @PostMapping("/location-add")
    public String createLocation(Location location) {
        locationService.create(location);
        return "redirect:/location-list";
    }

}
