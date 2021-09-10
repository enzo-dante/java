package io.learningjava.covid19.controllers;

import io.learningjava.covid19.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spring controller that renders an html
 */
@Controller
public class HomeController {

    @Autowired // automatically update data from CovidDataService class.
    CovidDataService covidDataService;

    /**
     * a controller that is mapped to a home html.
     * @return home
     */
    @GetMapping("/")
    public String home(Model model) {

        // add an attribute to the model that can be accessed in the respective template
        model.addAttribute("dataset", covidDataService.getDataset());
        model.addAttribute("currentTotalCases", covidDataService.getCurrentTotalCases());
        model.addAttribute("totalNewCases", covidDataService.getTotalNewCases());
        return "home";
    }
}
