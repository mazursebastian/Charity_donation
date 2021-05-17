package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRep;

@Service
public class DonationService {
    private final DonationRep donationRep;

    public DonationService(DonationRep donationRep) {
        this.donationRep = donationRep;

    }

    public void add(Donation donation) {
        donationRep.save(donation);
    }
}
