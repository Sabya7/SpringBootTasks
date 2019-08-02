package com.stackroute.boot.muzix.service;

import com.stackroute.boot.muzix.model.Track;

import java.util.List;

public interface TrackService {

        public List<Track> findAll();

        public Track findById(int id);

        public void save(Track track) ;

        public boolean deleteById(int id);

        Track findByName(String name);

        List<Track> findBycomment(String comment);

}
