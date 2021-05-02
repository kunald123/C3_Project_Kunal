package org.example.restaurant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String name) throws RestaurantNotFoundException{
       Restaurant restaurant=null;
    	for(Restaurant item: restaurants){
    		if(item.getName().equalsIgnoreCase(name))
    		{
    			restaurant=item;
    			break;
    			
    		 }
    		
    	}
    	if(restaurant==null)
    	{
    		throw new RestaurantNotFoundException("No restaurant with that name");
    	}
    	
        return restaurant;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String name) throws RestaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(name);
        boolean flag=restaurants.remove(restaurantToBeRemoved);
        if (flag==false)
        {
        	throw new  RestaurantNotFoundException("No restaurant with that name");
        }
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
