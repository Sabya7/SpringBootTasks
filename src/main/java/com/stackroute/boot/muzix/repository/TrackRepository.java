package com.stackroute.boot.muzix.repository;

import com.stackroute.boot.muzix.model.Track;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track,Integer> {
   // @Query(value = "SELECT * FROM Track WHERE name = ?1", nativeQuery = true)
    Track findByname(String name);
    List<Track> findBycomment(String comment);
}
