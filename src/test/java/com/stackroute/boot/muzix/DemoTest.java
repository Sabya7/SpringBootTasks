package com.stackroute.boot.muzix;

import com.stackroute.boot.muzix.model.Track;
import org.junit.Test;
import org.mockito.Spy;

import java.util.List;

import static org.mockito.Mockito.*;

public class DemoTest {
    @Test
    public void test1()
    {
        List mockedList = mock(List.class);
        List spiedList=spy(List.class);
        Track t1=mock(Track.class);
        t1.setId(1);
        Track track=spy(Track.class);
        System.out.println(t1.getId());
        //track.setId(1);
        //System.out.println(track.getId());

        //using mock object
        mockedList.add("one");
        spiedList.add("three");
        when(mockedList.get(0)).thenReturn("agha");
        System.out.println("hi");
        System.out.println(mockedList.get(0));
        System.out.println("hello");
        System.out.println(spiedList.get(0));
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
        when(mockedList.get(0)).thenReturn("first");
        //when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
      //  when(mockedList.contains(argThat(isValid()))).thenReturn("element");

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList,times(5)).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
        //verify(mockedList).add(argThat(someString -> someString.length() > 5));

    }
}
