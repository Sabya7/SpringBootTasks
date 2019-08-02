package com.stackroute.boot.muzix.service;

import com.stackroute.boot.muzix.model.Track;
import com.stackroute.boot.muzix.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceImplTest1 {
    Track track;

    //Create a mock for TrackRepository
    @Mock
    TrackRepository TrackRepository;

    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setName("John");
        track.setId(101);
        track.setComment("Jenny");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTestSuccess() {

        when(TrackRepository.save((Track)any())).thenReturn(track);
//        Track savedTrack = trackService.save(track);
//        Assert.assertEquals(track,savedTrack);

        //verify here verifies that trackRepository save method is only called once
        verify(TrackRepository,times(1)).save(track);

    }

    @Test
    public void saveTrackTestFailure()  {
        when(TrackRepository.save((Track)any())).thenReturn(null);
//        Track savedTrack = trackService.save(track);
//        System.out.println("savedTrack" + savedTrack);
        //Assert.assertEquals(track,savedTrack);

       /*doThrow(new TrackAlreadyExistException()).when(trackRepository).findById(eq(101));
       trackService.saveTrack(track);*/


    }

    @Test
    public void getAllTrack(){

        TrackRepository.save(track);
        //stubbing the mock to return specific data
        when(TrackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.findAll();
        Assert.assertEquals(list,tracklist);
    }

   @Test
    public void deleteById()
    {
        //doReturn(true).when(trackRepository).deleteById(anyInt());
        trackService.deleteById(101);
       verify(TrackRepository).deleteById(anyInt());
    }






}