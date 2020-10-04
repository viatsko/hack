import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by XingyangChen on 10/19/16.
 */
public class TestGuava {
    Multimap<String, String> map;
    @Before
    public void setUp(){
        //AbstractMapBasedMultimap mapBasedMultimap;
        map =  ArrayListMultimap.create();
        //map.clear();
    }
    @After
    public void tearDown(){

    }

    @Test
    public void testPut(){
        map.put("A", "1");
        map.put("B", "2");
        assertEquals(2,map.size());
        assertTrue(map.get("A").contains("1"));
        assertTrue(map.get("B").contains("2"));
    }
    @Test
    public void testClearAll(){
        map.put("A", "1");
        assertEquals(1,map.size());
        map.clear();
        assertEquals(0,map.size());
    }
    @Test
    public void testGet(){
        map.put("A", "1");
        map.put("A", "1");
        List<String> l1 = (List<String>)map.get("A");
        List<String> l2 = new ArrayList<String>();
        l2.add("1");
        l2.add("1");
        assertTrue(l1.equals(l2));
    }
    @Test
    public void testContainsEntry(){

    }

}
