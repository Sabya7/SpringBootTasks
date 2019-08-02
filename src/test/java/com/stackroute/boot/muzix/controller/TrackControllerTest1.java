package com.stackroute.boot.muzix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.boot.muzix.exception.TrackNotFound;
import com.stackroute.boot.muzix.model.Track;
import com.stackroute.boot.muzix.service.TrackService;
import com.stackroute.boot.muzix.service.TrackServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

public class TrackControllerTest1 {
    boolean setUpIsDone;
    private MockMvc mockMvc;
    private Track track;
    private TrackService trackService=Mockito.mock(TrackServiceImpl.class);
    //private TrackService trackService=Mockito.spy(TrackServiceImpl.class);
    @InjectMocks
    private TrackController trackController;

    private List<Track> tracks =null;
    @Before
    public void setUp() throws Exception
    {   if(setUpIsDone)
        return;
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(trackController).build();
        track =new Track(1,"agha","amit");
        tracks=new ArrayList<>();
        tracks.add(track);
         setUpIsDone=true;

    }


    @Test
    public void addTrack() throws Exception {
        System.out.println(track);
       Mockito.doAnswer(new Answer() {
           @Override
           public Object answer(InvocationOnMock invocation) throws Throwable {
               return track;
           }
       }).when(trackService).save(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/tracks")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateTrack() throws Exception {
        Mockito.doReturn(track).when(trackService).save(any());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/tracks")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteTrack() throws Exception {
      // Track track=new Track(1,"a","b");
        Mockito.doReturn(true).when(trackService).deleteById(anyInt());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/tracks/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    public TrackService getTrackService() {
        return trackService;
    }
}