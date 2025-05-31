package ru.voroncov.cloudcomputing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "kpi_metrics")
public class KpiMetric {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    private Product products;

    @Column(name = "avg_rating")
    private Double avgRating;

    @Column(name = "satisfaction_index")
    private Double satisfactionIndex;

    @Column(name = "attractiveness_index")
    private Double attractivenessIndex;

}