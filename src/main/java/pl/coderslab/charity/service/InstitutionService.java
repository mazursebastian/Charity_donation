package pl.coderslab.charity.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRep;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service

public class InstitutionService implements GenerateService<Institution> {
    private final InstitutionRep institutionRep;

    public InstitutionService(InstitutionRep institutionRep) {
        this.institutionRep = institutionRep;
    }

    public void add(Institution institution) {
        institutionRep.save(institution);
    }

    @Override
    public void update(Institution institution) {
        institutionRep.save(institution);
    }

    @Override
    public void delete(long id) {
institutionRep.deleteById(id);
    }

    @Override
    public Institution showById(long id) {
       return institutionRep.findById(id).orElseThrow(EntityExistsException::new);
    }


    public List<Institution> showAll() {
      return institutionRep.findAll(PageRequest.of(0,4)).getContent();
    }

    //druga metoda show

    /*
    public List<Institution> show() {
        Page<Institution> all = institutionRep.findAll(PageRequest.of(0, 4));
        List<Institution> content = all.getContent();
        return content;
    }
     */


}
