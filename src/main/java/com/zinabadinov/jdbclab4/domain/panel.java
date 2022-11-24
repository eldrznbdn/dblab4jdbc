package com.zinabadinov.jdbclab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class panel {
    private Integer id;
    private Integer amount_of_panel;
    private Integer solar_station_id;
}
