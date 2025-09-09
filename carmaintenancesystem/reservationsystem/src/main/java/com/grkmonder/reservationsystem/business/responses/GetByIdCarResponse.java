package com.grkmonder.reservationsystem.business.responses;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {
    private int id;
    private String name;
    private String plate;
    private int modelYear;
    private String carOwner;
    private String description;
    private String imageUrl;
    private String taxNum;
    private List<String> reservationTimes;

}
