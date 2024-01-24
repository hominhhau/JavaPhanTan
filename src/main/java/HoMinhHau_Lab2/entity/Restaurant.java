package HoMinhHau_Lab2.entity;


import java.util.List;

public class Restaurant {
    private String restaurantId;
    private boolean isClosed;
    private String name;
    private Address address;
    private String borough;
    private String cuisine;
    private List<Grade> grades;

    public Restaurant(String restaurantId, boolean isClosed, String name, Address address, String borough, String cuisine, List<Grade> grades) {
        this.restaurantId = restaurantId;
        this.isClosed = isClosed;
        this.name = name;
        this.address = address;
        this.borough = borough;
        this.cuisine = cuisine;
        this.grades = grades;
    }

    public Restaurant() {
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId='" + restaurantId + '\'' +
                ", isClosed=" + isClosed +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", borough='" + borough + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", grades=" + grades +
                '}';
    }
}
