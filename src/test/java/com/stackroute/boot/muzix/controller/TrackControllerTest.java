package com.stackroute.boot.muzix.controller;

import com.stackroute.boot.muzix.model.Track;
import com.stackroute.boot.muzix.service.TrackService;
import com.stackroute.boot.muzix.service.TrackServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
public class TrackControllerTest {

   TrackService trackServiceMock=Mockito.mock(TrackServiceImpl.class);
   TrackController controller=new TrackController(trackServiceMock);
    @Test
    public void testFindAll() {
        List<Track> t=new ArrayList<>();
        t.add(new Track(1,"a","b"));
     when(trackServiceMock.findAll()).thenReturn(t);
     assertEquals(t,controller.findAll());
    }

}