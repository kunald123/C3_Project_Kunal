package org.example.restaurant;
public class RestaurantNotFoundException extends Throwable {
    public RestaurantNotFoundException(String restaurantName) {
        super(restaurantName);
    }
}
