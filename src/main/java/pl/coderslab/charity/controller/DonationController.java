package pl.coderslab.charity.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;

@Controller

public class DonationController {
    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    public DonationController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.showAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.showAll();
    }
   /*
    @GetMapping("/add")
    public String donationForm(Model model) {
        model.addAttribute("donationToAdd", new Donation());

        return "form";
    }
*/
    @GetMapping("form_confirmation")
    public String confirmation(){
        return "form_confirmation";
    }



    @GetMapping("/add")
    public ModelAndView donationForm() {
        return  new ModelAndView("form", Map.of("donationToAdd",new DonationDto()));



    }


    @PostMapping("/add")
    public String addDonationForm(@ModelAttribute("donationToAdd") @Valid DonationDto donationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "form";
        } else {
            donationService.add(donationDto);
            return "redirect:form_confirmation";
        }
    }
}
