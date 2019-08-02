package com.stackroute.boot.muzix.controller;

import com.stackroute.boot.muzix.exception.TrackNotFound;
import com.stackroute.boot.muzix.model.Track;
import com.stackroute.boot.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/")
    public String welcome() throws Exception {
        throw new Exception();
    }

    @GetMapping("/tracks")
    public List<Track> findAll() {
        return trackService.findAll();
    }

    @GetMapping("/tracks/id/{trackId}")
    public Track getTrack(@PathVariable int trackId) {

        Track track = trackService.findById(trackId);

        if (track == null) {
            throw new RuntimeException("Track id not found - " + trackId);
        }

        return track;
    }

    @GetMapping("/tracks/name/{trackName}")
    public Track getTrackbyName(@PathVariable String trackName) {

        Track track = trackService.findByName(trackName);

        if (track == null) {
            throw new RuntimeException("Track name not found - " + trackName);
        }

        return track;
    }
    @GetMapping("/tracks/comment/{trackComment}")
    public List<Track> getTrackbyComment(@PathVariable String trackComment) {

        List<Track> tracks = trackService.findBycomment(trackComment);

        if (tracks == null) {
            throw new RuntimeException("Track comment not found - " + trackComment);
        }

        return tracks;
    }


    @PostMapping("/tracks")
    public Track addTrack(@RequestBody Track track)  {
        track.setId(0);

        trackService.save(track);

        return track;
    }


    @PutMapping("/tracks")
    public Track updateTrack(@RequestBody Track track)  {

        trackService.save(track);

        return track;
    }
    @PutMapping("/tracklist")
    public ResponseEntity<?> updateTracks(@RequestBody List<Track> tracks)  {
     for(Track t:tracks)
      trackService.save(t);

        return new ResponseEntity<List<?>>(tracks, HttpStatus.CREATED);

    }


    @DeleteMapping("/tracks/{trackId}")
    public String deleteTrack(@PathVariable int trackId) {

//        Track tempTrack = trackService.findById(trackId);
//
//
//        if (tempTrack == null) {
//            throw new RuntimeException("Track id not found - " + trackId);
//        }

        trackService.deleteById(trackId);

        return "Deleted track id - " + trackId;
    }
}