package ru.itis.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bachelor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bachelor {
    @Id
    private String _id;
    private String college;
    private String name;
    private String surname;
}
