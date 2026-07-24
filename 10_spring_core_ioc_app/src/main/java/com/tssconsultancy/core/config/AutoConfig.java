package com.tssconsultancy.core.config;

import com.tssconsultancy.core.entity.HardDisk;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages = "com.tssconsultancy.core")
public class AutoConfig {
//
//    @Bean
//    public HardDisk hardDisk(){
//        return new HardDisk(1024);
//    }
}
