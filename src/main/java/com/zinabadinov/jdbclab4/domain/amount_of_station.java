package com.zinabadinov.jdbclab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class amount_of_station {
    private Integer id;
    private Integer amount;
    private Integer owner_s_id;
}
