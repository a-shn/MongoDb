package ru.itis.jpa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.itis.jpa.models.Bachelor;

import java.util.List;

public interface BachelorRepository extends MongoRepository<Bachelor, String> {
    @Query(value = "{$and: [{'college': ?0}, {'name': ?1}]}")
    List<Bachelor> find(String college, String name);
}
