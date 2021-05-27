package pl.coderslab.charity;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @GetMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutionList = institutionService.showAll();
        model.addAttribute("institutions", institutionList);

        Long quantity = donationService.showQuantityDonation();
        model.addAttribute("quantity", quantity);

        Long NumberDonation = donationService.DonationNumbers();
        model.addAttribute("donationsNumber", NumberDonation);

        return "index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.showAll();
    }


}
