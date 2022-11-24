package com.zinabadinov.jdbclab4;

import com.zinabadinov.jdbclab4.view.MyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jdbclab4Application implements CommandLineRunner {
    //CommandLineRunner значает что это спрингбут для консоли

    @Autowired
    private MyView view;

    public static void main(String[] args) {
        SpringApplication.run(Jdbclab4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}
