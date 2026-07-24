package com.tssconsultancy.core.config;

import com.tssconsultancy.core.entity.Computer;
import com.tssconsultancy.core.entity.Harddisk;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {

    @Bean
    public Computer computer(Harddisk harddisk1){
        return new Computer("Apple", harddisk1);
    }

    @Bean(name = "harddisk1")
    public Harddisk harddisk(){
        return new Harddisk(2014);
    }

    @Bean
    public Harddisk harddisk1(@Value("100") int capacity){
        return new Harddisk(capacity);
    }

}
