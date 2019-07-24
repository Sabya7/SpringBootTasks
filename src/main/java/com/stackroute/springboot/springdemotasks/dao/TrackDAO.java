package com.stackroute.springboot.springdemotasks.dao;

import com.stackroute.springboot.springdemotasks.exceptions.TrackAlreadyExistsException;
import com.stackroute.springboot.springdemotasks.exceptions.TrackNotFoundException;
import com.stackroute.springboot.springdemotasks.model.Track;
import java.util.List;

public interface TrackDAO {

	public boolean saveTrack(Track track) throws TrackAlreadyExistsException;

	public boolean deleteTrack(int id) throws TrackNotFoundException;

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public boolean UpdateTrack(Track track);

	public List<Track>searchByName(String s);
   
}