
package HoMinhHau_Lab2.jom;

import entity.Address;
import entity.Date;
import entity.Grade;
import entity.Restaurant;
import jakarta.json.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {



    // read all restaurants from file = JsonObject
    public static List<Restaurant> readFromFile(String fileName) throws FileNotFoundException {

        List<Restaurant> restaurants = new ArrayList<>();

        try (
                JsonReader reader = Json.createReader(new FileReader(fileName));
        ) {

            JsonArray ja = reader.readArray();

            for (JsonValue jv : ja) {
                JsonObject jo = (JsonObject) jv;
                String restaurantId = jo.getString("restaurant_id");
                String name = jo.getString("name");
                String borough = jo.getString("borough");
                String cuisine = jo.getString("cuisine");
                JsonObject joAddress = jo.getJsonObject("address");
                String building = joAddress.getString("building");
                JsonArray jaCoord = joAddress.getJsonArray("coord");
                List<Double> coord = new ArrayList<>();
                for (JsonValue jvCoord : jaCoord) {
                    coord.add(Double.parseDouble(jvCoord.toString()));
                }
                String street = joAddress.getString("street");
                String zipcode = joAddress.getString("zipcode");
                Address address = new Address(building, coord, street, zipcode);
                JsonArray jaGrades = jo.getJsonArray("grades");
                List<Grade> grades = new ArrayList<>();
                for (JsonValue jvGrade : jaGrades) {
                    JsonObject joGrade = (JsonObject) jvGrade;
                    JsonObject joDate = joGrade.getJsonObject("date");
                    Date date = new Date(joDate.getInt("year"), joDate.getInt("month"), joDate.getInt("day"));
                    String grade = joGrade.getString("grade");
                    int score = joGrade.getInt("score");
                    grades.add(new Grade(date, grade, score));
                }
                boolean isClosed = jo.getBoolean("is_closed");
                restaurants.add(new Restaurant(restaurantId, isClosed, name, address, borough, cuisine, grades));
            }
        }
        return restaurants;
    }
  

    public static void toFile(List<Restaurant> restaurants, String fileName) throws IOException {

        try (
                JsonWriter writer = Json.createWriter(new FileWriter(fileName)
                );
        ) {

            JsonArrayBuilder aBuilder = Json.createArrayBuilder();
            JsonObjectBuilder job = Json.createObjectBuilder();

            for (Restaurant r : restaurants) {
                Address add = r.getAddress();
                JsonArrayBuilder aCoord = Json.createArrayBuilder();
                List<Double> coord = add.getCoord();
                for (Double d : coord) {
                    aCoord.add(d);
                }
                JsonArrayBuilder aGrades = Json.createArrayBuilder();
                for (Grade g : r.getGrades()) {
                    JsonObjectBuilder jobGr = Json.createObjectBuilder();
                    jobGr.add("date", Json.createObjectBuilder()
                            .add("year", g.getDate().getYear())
                            .add("month", g.getDate().getMonth())
                            .add("day", g.getDate().getDay())
                            .build());
                    jobGr.add("grade", g.getGrade());
                    jobGr.add("score", g.getScore());
                    aGrades.add(jobGr.build());
                }
                JsonObject jo = job.add("restaurant_id", r.getRestaurantId())
                        .add("name", r.getName())
                        .add("borough", r.getBorough())
                        .add("cuisine", r.getCuisine())
                        .add("address", Json.createObjectBuilder()
                                .add("building", add.getBuilding())
                                .add("coord", aCoord.build())
                                .add("street", add.getStreet())
                                .add("zipcode", add.getZipcode())
                                .build())
                        .add("grades", aGrades.build())
                        .add("is_closed", r.isClosed())
                        .build();
                aBuilder.add(jo);
            }
            JsonArray ja = aBuilder.build();
            writer.write(ja);


        }
    }
}
