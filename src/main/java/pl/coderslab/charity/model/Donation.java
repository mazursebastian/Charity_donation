package pl.coderslab.charity.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "quantity", nullable = false, length = 50)
    private Integer quantity;
    @ManyToOne

    private Category categories;
    @ManyToOne

    private Institution institution;
    @Column(name = "name_street", nullable = false, length = 100)
    private String street;
    @Column(name = "name_city", nullable = false, length = 100)
    private String city;
    @Column(name = "name_zipCode", nullable = false, length = 100)
    private String zipCode;
    @NotNull
    @Column(name = "pickUp_date", nullable = false, length = 100)
    private LocalDate pickUpDate;
    @NotNull
    @Column(name = "pickUp_time", nullable = false, length = 100)
    private LocalTime pickUpTime;
    @NotBlank
    @Column(name = "pickUp_comment", nullable = false, length = 100)
    private String pickUpComment;

    public Donation(Integer quantity, Category categories, Institution institution, String street, String city, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public Donation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}





