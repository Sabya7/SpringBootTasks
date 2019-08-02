package com.stackroute.boot.muzix;

import com.stackroute.boot.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class MyBean implements CommandLineRunner {
    @Autowired
    private TrackRepository trackRepository;
    public void run(String... args) {
        System.out.println("In the command line runner"+args[0]+trackRepository.toString());
    }

}