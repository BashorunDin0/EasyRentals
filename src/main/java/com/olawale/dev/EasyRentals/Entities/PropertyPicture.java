package com.olawale.dev.EasyRentals.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PropertyPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
