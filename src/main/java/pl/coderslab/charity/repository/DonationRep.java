package pl.coderslab.charity.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

import java.util.Optional;

public interface DonationRep  extends JpaRepository<Donation,Long> {

    @Query("select sum (d.quantity) from Donation d")
    Optional<Long> countBagsQuantity();

}
