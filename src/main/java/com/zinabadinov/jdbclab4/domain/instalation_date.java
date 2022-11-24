package com.zinabadinov.jdbclab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class instalation_date {
    private Integer id;
    private String ins_date;
    private Integer solar_station_id;
}
