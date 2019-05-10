package com.yash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
      @Autowired
      private CategoryRepository categoryRepository;

      public Category store(String name, String word) {
            if(name == null) {
                  throw new IllegalArgumentException("Name cannot be null");
            }
            if(word == null) {
                  throw new IllegalArgumentException("Word cannot be null");
            }

            Category category = new Category(name, word);
            return this.categoryRepository.save(category);
      }

      public List<Category> getAll() {
            return this.categoryRepository.findAll();
      }

      public List<Category> getAllByCategory(List<String> categories) {
            return this.categoryRepository.findAllByNameIn(categories);
      }

      public Set<String> getAllNames() {
            Set<String> categories = new HashSet<>();
            for(Category category : this.getAll()) {
                  categories.add(category.getName());
            }

            return categories;
      }
}
