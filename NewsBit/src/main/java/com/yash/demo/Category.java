package com.yash.demo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {
      @Id
      @Column(name = "id")
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int id;

      @Column(name = "name")
      private String name;

      @Column(name = "word")
      private String word;

      public Category(String name, String word) {
            this.name = name;
            this.word = word;
      }

      public Category() {}

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getWord() {
            return word;
      }

      public void setWord(String word) {
            this.word = word;
      }

      @Override
      public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Category category = (Category) o;
            return id == category.id &&
                    Objects.equals(name, category.name) &&
                    Objects.equals(word, category.word);
      }

      @Override
      public int hashCode() {
            return Objects.hash(id, name, word);
      }

      @Override
      public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", word='" + word + '\'' +
                    '}';
      }
}
