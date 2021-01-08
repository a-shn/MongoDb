package ru.itis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import ru.itis.spring.config.MongoTemplateConfiguration;
import ru.itis.spring.models.Bachelor;
import ru.itis.spring.models.Master;

import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoTemplateConfiguration.class);
        MongoTemplate template = context.getBean(MongoTemplate.class);

//        Bachelor bachelor = Bachelor.builder().name("Vladimir").surname("Lenin").college("KFU").build();
//        Master master = Master.builder().name("Nikolay").surname("Lobachevsky").college("KFU").build();
//
//        template.save(bachelor, "bachelor");
//        template.save(master, "master");

        List<Bachelor> bachelors = template.find(new Query(
                        where("name").is("Max")),
                Bachelor.class, "bachelor");
        for (Bachelor bachelor: bachelors) {
            System.out.println(bachelor.getName() + " " + bachelor.getSurname());
        }

    }
}
