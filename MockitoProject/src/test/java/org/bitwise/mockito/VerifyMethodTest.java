package org.bitwise.mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
 
@RunWith(MockitoJUnitRunner.class)
public class VerifyMethodTest {
 
    @Mock
    private List<String> mockList;
 
    @Test
    public void testMockListAdd() {
        String addString = "some string";
        mockList.add(addString);
 
        //verify that the add method was called with argument 'some string'
        verify(mockList).add(addString);
    }
 
    @Test
    public void testMockListAddMultiple() {
        String addString = "some string multiple";
        mockList.add(addString);
        mockList.add(addString);
        mockList.add(addString);
 
        //verify that the add method was called with argument 'some string'
        verify(mockList, times(3)).add(addString);
    }
}