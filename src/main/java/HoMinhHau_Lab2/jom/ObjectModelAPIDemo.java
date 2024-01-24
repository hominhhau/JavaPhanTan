package HoMinhHau_Lab2.jom;

import entity.Address;
import entity.Restaurant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ObjectModelAPIDemo {

    public static void main(String[] args) {

     List<Restaurant> list = List.of(
                new Restaurant("1", false, "A", new Address("1", List.of(1.0, 2.0), "1", "1"), "1", "1", List.of()),
                new Restaurant("2", false, "B", new Address("2", List.of(1.0, 2.0), "2", "2"), "2", "2", List.of()),
                new Restaurant("3", true, "C", new Address("3", List.of(1.0, 2.0), "3", "3"), "3", "3", List.of())
     );
        try {
            JsonHandler.toFile(list, "data/restaurants.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       
        List<Restaurant> rs = null;
        try {
            rs = JsonHandler.readFromFile("data/restaurants.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
// System.out.println(rs);

        // lấy ra isClose = false

        rs.stream().filter(r -> !r.isClosed()).forEach(System.out::println);


        

        // dùng JsonHandler để ghi ra file data/restaurants.json
        // dùng JsonHandler để đọc từ file data/restaurants.json
        // in ra màn hình


       






    }
}
