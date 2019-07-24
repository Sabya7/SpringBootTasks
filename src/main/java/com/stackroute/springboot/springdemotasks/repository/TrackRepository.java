package com.stackroute.springboot.springdemotasks.repository;

import com.stackroute.springboot.springdemotasks.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
    @Query("SELECT a FROM Track a WHERE name = ?1")
    List<Track> searchByName(String s);

    @Query(value = "select * from Track",nativeQuery = true)
    Collection<Track> findAllActiveUsers(String name);
}
