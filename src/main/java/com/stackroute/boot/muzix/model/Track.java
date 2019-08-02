package com.stackroute.boot.muzix.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "track")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    private int id;

    private String name;

    private String comment;
}
