package com.olawale.dev.EasyRentals.Dtos;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PropertyPictureDto {
    private Long id;
    private String url;
    private  Long propertyId;
}
