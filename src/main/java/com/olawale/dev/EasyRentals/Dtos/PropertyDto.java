package com.olawale.dev.EasyRentals.Dtos;

import com.olawale.dev.EasyRentals.Entities.ElectricityBillStatus;
import com.olawale.dev.EasyRentals.Entities.GatedStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PropertyDto {
    private Long id;
    private String address;
    private Integer numberOfRooms;
    private Double rent;
    private GatedStatus gated;
    private ElectricityBillStatus prepaid;
    private Boolean pop;
    private Boolean newlyConstructed;
    private Boolean isAvailable;
}
