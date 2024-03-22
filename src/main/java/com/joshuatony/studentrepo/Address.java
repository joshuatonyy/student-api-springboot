package com.joshuatony.studentrepo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String province;
    private String city;
    private String subdistrict;
}
