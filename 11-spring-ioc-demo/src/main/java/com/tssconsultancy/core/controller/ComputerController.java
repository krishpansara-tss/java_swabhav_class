package com.tssconsultancy.core.controller;

import com.tssconsultancy.core.entity.Computer;
import com.tssconsultancy.core.entity.Harddisk;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ComputerController {

    private Computer computer;
    private Harddisk harddisk;

    public ComputerController(Computer computer, Harddisk harddisk) {
        this.computer = computer;
        this.harddisk = harddisk;
    }

    @RequestMapping("/computers")
    public Computer getComputer(){
        return computer;
    }

    @RequestMapping("/harddisk")
    public Harddisk getHarddisk(){
        return harddisk;
    }
}
