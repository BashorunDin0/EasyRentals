package com.olawale.dev.EasyRentals.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Address is mandatory")
    private String address;

    @Column(nullable = false)
    @NotNull(message = "Number of rooms is mandatory")
    @Min(value = 1, message = "Number of rooms must be at least 1")
    private Integer numberOfRooms;

    @Column(nullable = false)
    @NotNull(message = "Rent is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Rent must be greater than 0")
    private Double rent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GatedStatus gatedStatus = GatedStatus.GATED;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
    private ElectricityBillStatus billStatus = ElectricityBillStatus.PREPAID;

    @Column(nullable = false)
    @NotNull(message = "POP status is mandatory")
    private Boolean pop;

    @Column(nullable = false)
    @NotNull(message = "Newly constructed status is mandatory")
    private Boolean newlyConstructed;

    @Column(nullable = false)
    private Boolean isAvailable = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyPicture> pictures = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Utility Method
    public void toggleAvailability() {
        this.isAvailable = !this.isAvailable;
    }
}
