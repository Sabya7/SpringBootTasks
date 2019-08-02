package com.stackroute.boot.muzix.service;

import com.stackroute.boot.muzix.model.Track;
import com.stackroute.boot.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track findById(int id) {
        Optional<Track> result = trackRepository.findById(id);

        Track track = null;

        if (result.isPresent()) {
            track = result.get();
        }
        else {

            throw new RuntimeException("Did not find Track id - " + id);
        }

        return track;
    }

    @Override
    public void save(Track track)  {
        trackRepository.save(track);
    }

    @Override
    public boolean deleteById(int theId) {
        trackRepository.deleteById(theId);
        return true;
    }

    @Override
    public Track findByName(String name) {
        return trackRepository.findByname(name);
    }

    @Override
    public List<Track> findBycomment(String comment) {
        return trackRepository.findBycomment(comment);
    }
}
