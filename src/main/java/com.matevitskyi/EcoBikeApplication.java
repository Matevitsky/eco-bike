package com.matevitskyi;


import com.matevitskyi.ui.MainConsole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoBikeApplication implements CommandLineRunner {

    private MainConsole mainConsole;

    public EcoBikeApplication(MainConsole mainConsole) {
        this.mainConsole = mainConsole;
    }

    public static void main(String[] args) {
        SpringApplication.run(EcoBikeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        mainConsole.startApp();
    }
}
