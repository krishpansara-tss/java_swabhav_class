package com.tssconsultancy.core.test;

import com.tssconsultancy.core.config.AutoConfig;
import com.tssconsultancy.core.entity.Computer;
import com.tssconsultancy.core.entity.HardDisk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        HardDisk hardDisk = new HardDisk(1024);
//        Computer computer = new Computer("Gigabyte", hardDisk);
//        System.out.println(computer);

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoConfig.class);

        HardDisk hardDisk = applicationContext.getBean(HardDisk.class);
        System.out.println(hardDisk);

        Computer computer = applicationContext.getBean(Computer.class);
        System.out.println(computer);

    }
}
