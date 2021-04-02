package com.feedback.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private FeedbackCategory parentCategory;

    @OneToMany(mappedBy="parentCategory", cascade = CascadeType.ALL)
    private List<FeedbackCategory> subCategories;
}
