package com.example.taskmgrspring;

import com.example.taskmgrspring.common.ModelMapperList;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class TaskmgrSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskmgrSpringApplication.class, args);
    }
    @Bean
    @Scope("singleton")
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    @Scope("singleton")
    public ModelMapperList modelMapperList()
    {
        return new ModelMapperList(modelMapper());
    }
}
