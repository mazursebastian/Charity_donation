package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRep;

import java.util.List;

@Service
public class CategoryService implements GenerateService<Category> {
    private  final CategoryRep categoryRep;

    public CategoryService(CategoryRep categoryRep) {
        this.categoryRep = categoryRep;
    }
     @Override
    public void add(Category category) {
        categoryRep.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRep.save(category);
    }

    @Override
    public void delete(long id) {
     categoryRep.deleteById(id);
    }

    @Override
    public Category showById(long id) {
        return  categoryRep.findById(id).orElseThrow(ExceptionInInitializerError::new);
    }

    @Override
    public List<Category> showAll() {
        return categoryRep.findAll();
    }
}
