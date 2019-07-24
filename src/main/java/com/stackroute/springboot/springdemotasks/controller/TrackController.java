package com.stackroute.springboot.springdemotasks.controller;


import com.stackroute.springboot.springdemotasks.dao.TrackDAO;
import com.stackroute.springboot.springdemotasks.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
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
	public List<Track> saveTrack(Model model, @RequestBody Track track) {
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
		trackDAO.deleteTrack(track.getId());
		trackDAO.saveTrack(track1);
		//model.addAttribute("track", track);
		return track1;
	}
//    @RequestMapping(value = "/deleteTrack/{id}",method = RequestMethod.POST)
//	public String deleteTrack(@RequestParam("id")int id) {
//         trackDAO.deleteTrack(id);
//		return id+ "deleted";
//	}
	@RequestMapping("/deleteTrack")
	public List<Track> deleteTrack(Model model, @RequestBody Track track) {
		trackDAO.deleteTrack(track.getId());
		List<Track> list = trackDAO.getAllTracks();
		model.addAttribute("tracks", list);
		return list;
	}


}