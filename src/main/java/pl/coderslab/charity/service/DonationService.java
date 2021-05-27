package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRep;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class DonationService {
    private final DonationRep donationRep;

    public DonationService(DonationRep donationRep) {
        this.donationRep = donationRep;

    }


    public void add(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setQuantity(donationDto.getQuantity());
        donation.setCategories(donationDto.getCategories());
        donation.setInstitution(donationDto.getInstitution());
        donation.setStreet(donationDto.getStreet());
        donation.setCity(donationDto.getStreet());
        donation.setZipCode(donationDto.getStreet());
        donation.setPhoneNumber(donationDto.getPhoneNumber());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());
        donation.setPickUpComment(donationDto.getPickUpComment());
        donationRep.save(donation);
    }


    public void update(Donation donation) {
        donationRep.save(donation);
    }


    public void delete(long id) {
        donationRep.deleteById(id);

    }


    public Donation showById(long id) {

        return donationRep.findById(id).orElseThrow(EntityExistsException::new);
    }


    public List<Donation> showAll() {
        return donationRep.findAll();
    }

    public Long showQuantityDonation() {

        return donationRep.countBagsQuantity().orElse(0L);


    }

    public long DonationNumbers() {

        return donationRep.count();
    }
}
