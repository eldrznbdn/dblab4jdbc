package com.zinabadinov.jdbclab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class sold_energy {
    private Integer id;
    private Integer amount_of_sold_energy;
    private Integer solar_station_id;
}
