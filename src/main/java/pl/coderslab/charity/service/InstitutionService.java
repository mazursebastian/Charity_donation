package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRep;

@Service

public class InstitutionService {
    private final InstitutionRep institutionRep;

    public InstitutionService(InstitutionRep institutionRep) {
        this.institutionRep = institutionRep;
    }

    public void add(Institution institution) {
        institutionRep.save(institution);
    }
}
