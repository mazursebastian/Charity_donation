package pl.coderslab.charity.dto;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DonationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "quantity", nullable = false, length = 50)
    private Integer quantity;
    @NotEmpty
    @ManyToMany
    private List<Category> categories;
    @NotNull
    @ManyToOne
    private Institution institution;
    @NotBlank

    private String street;
    @NotBlank

    private String city;
    @NotBlank
    // @Pattern("00-000")//wyrazenie regularne
    @Pattern(message = "Proszę podać prawidłowy kod", regexp = "^[0-9]{2}-[0-9]{3}$")
    private String zipCode;
    @Pattern(message = "Proszę wpisać prawidłowy numer telefonu", regexp = "^[0-9]{9}")
    @NotNull

    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull

    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;
    //Walidacja do sprawdzania czy nei jest za dlugi string

    private String pickUpComment;

    public DonationDto(Long id, @NotNull Integer quantity, @NotEmpty List<Category> categories, @NotNull Institution institution, @NotBlank String street, @NotBlank String city, @NotBlank @Pattern(message = "Proszę podać prawidłowy kod", regexp = "^[0-9]{2}-[0-9]{3}$") String zipCode, @Pattern(message = "Proszę wpisać prawidłowy numer telefonu", regexp = "^[0-9]{9}") @NotNull String phoneNumber, @NotNull LocalDate pickUpDate, @NotNull LocalTime pickUpTime, String pickUpComment) {
        this.id = id;
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    public DonationDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
