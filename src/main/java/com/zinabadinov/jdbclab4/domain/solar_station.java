package com.zinabadinov.jdbclab4.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //разрешает создават get set...
public class solar_station {
    private Integer id;
    private String country;
    private String type_station;
    private Integer capacity;
}
