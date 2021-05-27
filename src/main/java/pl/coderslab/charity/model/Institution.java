package pl.coderslab.charity.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//CTRL + ALT + O czysci niepotrzebne importy


@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "name_institution", nullable = false, length = 100)
    private String name;
    @NotBlank
    @Column(name = "institution_description", nullable = false, length = 1000)
    private String description;

    public Institution(String name) {
        this.name = name;
    }

    public Institution() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
