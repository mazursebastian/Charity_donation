package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRep;

@Service
public class CategoryService {
    private  final CategoryRep categoryRep;

    public CategoryService(CategoryRep categoryRep) {
        this.categoryRep = categoryRep;
    }

    public void add(Category category) {
        categoryRep.save(category);
    }
}
