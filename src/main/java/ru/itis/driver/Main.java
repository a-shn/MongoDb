package ru.itis.driver;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;


public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("bachelor_db");
        MongoCollection<Document> bachelors = database.getCollection("bachelor");
        bachelors.find().forEach(document -> System.out.println(document.get("name", "")));

        Document searchQuery = new Document();
        searchQuery
                .append("surname", "Planck");
        FindIterable<Document> resultDocuments = bachelors.find(searchQuery)
                .projection(fields(include("name", "surname"), excludeId()));
        for (Document document : resultDocuments) {
            System.out.println(document.toJson());
        }
    }
}