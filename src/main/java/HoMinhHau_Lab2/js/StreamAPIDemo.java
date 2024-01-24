package HoMinhHau_Lab2.js;

import entity.Restaurant;

public class StreamAPIDemo {
    public static void main(String[] args) {
        Restaurant r = JsonHandlerStream.readFromFile("data/restaurants.json");
        System.out.println(r);
    }
}
