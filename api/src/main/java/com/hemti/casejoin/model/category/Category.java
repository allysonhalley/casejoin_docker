package com.hemti.casejoin.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hemti.casejoin.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categories")
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

    public Category(CategoryDTO categoryDTO) {
        this.name = categoryDTO.name();
        this.description = categoryDTO.description();
    }

}
