package com.stackroute.springboot.springdemotasks.controller;


import com.stackroute.springboot.springdemotasks.dao.TrackDAO;
import com.stackroute.springboot.springdemotasks.exceptions.TrackAlreadyExistsException;
import com.stackroute.springboot.springdemotasks.exceptions.TrackNotFoundException;
import com.stackroute.springboot.springdemotasks.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrackController {

	TrackDAO trackDAO;
	//update all the methods with code

	@Autowired
	public TrackController(TrackDAO trackDAO){
		this.trackDAO=trackDAO;
	}

	@RequestMapping("/")
	public List<Track> indexPage(Model model) {
		List<Track> list = trackDAO.getAllTracks();
		model.addAttribute("tracks", list);
		return list;
	}

	@RequestMapping("/addTrack")
	public String addTrack(Model model) {
		Track track = new Track();
		model.addAttribute("track", track);
		return "addTrack";
	}

	@RequestMapping("/saveTrack")
	public List<Track> saveTrack(Model model, @RequestBody Track track) throws TrackAlreadyExistsException {
		trackDAO.saveTrack(track);
		List<Track> list = trackDAO.getAllTracks();
		model.addAttribute("tracks", list);
		return list;
	}

	@RequestMapping("/updateTrack")
	public Track updateTrack(@RequestBody Track track, Model model) {
		//trackDAO.deleteTrack(track.getId());
		Track track1=new Track();
		track1.setId(track.getId());
		track1.setName(track.getName());
		track1.setComment(track.getComment());
		try {
			trackDAO.deleteTrack(track.getId());
		} catch (TrackNotFoundException e) {
			e.printStackTrace();
		}
		try {
			trackDAO.saveTrack(track1);
		} catch (TrackAlreadyExistsException e) {
			e.printStackTrace();
		}
		//model.addAttribute("track", track);
		return track1;
	}
//    @RequestMapping(value = "/deleteTrack/{id}",method = RequestMethod.POST)
//	public String deleteTrack(@RequestParam("id")int id) {
//         trackDAO.deleteTrack(id);
//		return id+ "deleted";
//	}
	@RequestMapping("/deleteTrack")
	public List<Track> deleteTrack(Model model, @RequestBody Track track)throws TrackNotFoundException {
		trackDAO.deleteTrack(track.getId());
		List<Track> list = trackDAO.getAllTracks();
		model.addAttribute("tracks", list);
		return list;
	}
	@RequestMapping("/search")
	List<Track> searchByName(@RequestBody String name)
	{
		System.out.println(trackDAO.searchByName("Rohit").toString());
       return trackDAO.searchByName(name);
	}


}