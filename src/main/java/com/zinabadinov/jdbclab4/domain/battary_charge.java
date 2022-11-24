package com.zinabadinov.jdbclab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class battary_charge {
    private Integer id;
    private String type_of_charge;
    private Integer solar_station_id;
}
