package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this function will get the size of list
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * this function will add a city object into the list
     * @param city
     */
    public void addCity(City city) {
        cities.add(city);
        return;
    }

    /**
     * This returns true if city is in cities, false if not
     * @param city
     *      This is a city to look for in cities array list
     * @return
     *      Returns true if city is in cities array list, false if not
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes city from cities array list
     * Throws exception if city is not in cities array list
     * @param city
     *      This is a candidate city to delete
     */
    public void deleteCity(City city) {

        if(!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);

    }

    /**
     * This returns how many cities are in the cities array list
     * @return
     *      Returns the number of cities in cities array list
     */
    public int countCities() {
        return cities.size();
    }

}
