package com.stackroute.boot.muzix.repository;

import com.stackroute.boot.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,Integer> {
   // @Query(value = "SELECT * FROM Track WHERE name = ?1", nativeQuery = true)
    Track findByname(String name);
    List<Track> findBycomment(String comment);
}
