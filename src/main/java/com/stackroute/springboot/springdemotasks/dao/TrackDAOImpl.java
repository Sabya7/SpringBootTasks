package com.stackroute.springboot.springdemotasks.dao;


import com.stackroute.springboot.springdemotasks.model.Track;
import com.stackroute.springboot.springdemotasks.repository.TrackRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO {


	private TrackRepository sessionFactory;

	@Autowired
	public TrackDAOImpl(TrackRepository sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	//implement all the methods
	@Override
	public boolean saveTrack(Track track) {
		sessionFactory.save(track);
        //session.beginTransaction();

		//session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteTrack(int id) {
		//Session session=sessionFactory.unwrap(Session.class);
      //  session.beginTransaction();
        sessionFactory.deleteById(id);
       // session.getTransaction().commit();
		return true;
	}

	@Override
	public List<Track> getAllTracks() {
    	//Session session=sessionFactory.unwrap(Session.class);
	//session.beginTransaction();
	List<Track>tracks=sessionFactory.findAll();
	//session.getTransaction().commit();
	return tracks;
	}

	@Override
	public Track getTrackById(int id) {
		//Session session=sessionFactory.unwrap(Session.class);
	 //   session.beginTransaction();
	    Track track=sessionFactory.getOne(id);
       // session.getTransaction().commit();
		return track;
	}

	@Override
	public boolean UpdateTrack(Track track) {
		//Session session=sessionFactory.unwrap(Session.class);
		//session.beginTransaction();
		sessionFactory.saveAndFlush(track);
		//session.getTransaction().commit();
		return false;
	}

}
