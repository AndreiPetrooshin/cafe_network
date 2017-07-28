package model;

import java.util.List;

public class CoffeeHouse {
    private int id;
    private String address;
    private String name;
    private Director director;
    private List<Beverage> beverageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Beverage> getBeverageList() {
        return beverageList;
    }

    public void setBeverageList(List<Beverage> beverageList) {
        this.beverageList = beverageList;
    }
}
