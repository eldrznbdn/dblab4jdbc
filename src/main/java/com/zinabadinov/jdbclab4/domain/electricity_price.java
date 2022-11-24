package com.zinabadinov.jdbclab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class electricity_price {
    private Integer id;
    private Integer price;
    private Integer solar_station_id;

}
