package com.stackroute.springboot.springdemotasks.repository;

import com.stackroute.springboot.springdemotasks.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
}
