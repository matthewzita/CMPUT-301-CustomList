import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void testHasCity() {
        City city = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(city));

        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        int listSize = list.getCount();

        City city = new City("Vancouver", "British Columbia");
        list.addCity(city);

        assertEquals(list.getCount(), listSize+1);
        assertTrue(list.hasCity(city));

        list.deleteCity(city);

        assertEquals(list.getCount(), listSize);
        assertFalse(list.hasCity(city));
    }
}
