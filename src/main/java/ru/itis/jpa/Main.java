package ru.itis.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.jpa.config.MongoConfiguration;
import ru.itis.jpa.repositories.BachelorRepository;
import ru.itis.jpa.models.Bachelor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfiguration.class);
        BachelorRepository bachelorRepository = context.getBean(BachelorRepository.class);

        Bachelor bachelor = Bachelor.builder().name("Java").surname("Persistence").college("Oracle").build();

//        bachelorRepository.save(bachelor);

        System.out.println(bachelorRepository.find("KFU", "Vladimir"));
    }
}
