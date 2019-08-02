package com.stackroute.boot.muzix.service;

import com.stackroute.boot.muzix.controller.TrackController;
import com.stackroute.boot.muzix.model.Track;
import com.stackroute.boot.muzix.repository.TrackRepository;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TrackServiceImplTest {

    TrackRepository trackRepository=Mockito.mock(TrackRepository.class);
    TrackServiceImpl trackService=new TrackServiceImpl(trackRepository);
    @Test
    public void testFindAll(){
        List<Track> t=new ArrayList<>();
        t.add(new Track(1,"a","b"));
        when(trackRepository.findAll()).thenReturn(t);
        assertEquals(t,trackService.findAll());
        verify(trackRepository,times(1)).findAll();
    }

}