package com.stackroute.springboot.springdemotasks.dao;

import com.stackroute.springboot.springdemotasks.model.Track;
import java.util.List;

public interface TrackDAO {

	public boolean saveTrack(Track track);

	public boolean deleteTrack(int id);

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public boolean UpdateTrack(Track track);


   
}