package ru.voroncov.cloudcomputing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Size(max = 6)
    @NotNull
    @Column(name = "gender", nullable = false, length = 6)
    private String gender;

    @Column(name = "discount_card_number", columnDefinition = "char(5)")
    private String discountCardNumber;

    @ColumnDefault("false")
    @Column(name = "have_children")
    private Boolean haveChildren;

    @ColumnDefault("false")
    @Column(name = "married")
    private Boolean married;

    @Size(max = 255)
    @Column(name = "education")
    private String education;

    @Size(max = 255)
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "user")
    private Set<ProductReview> productReviews = new LinkedHashSet<>();

}