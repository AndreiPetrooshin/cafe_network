package com.andreipetrooshin.model;

import javax.persistence.*;

@Entity
public class Drink {

    private int id;
    private String name;
    private Double price;
    private Integer capacity;
    private Cafe cafe;

    public Drink(int id,String name, Double price, Integer capacity, Cafe cafe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.cafe = cafe;
    }

    public Drink(String name, Double price, Integer capacity, Cafe cafe) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.cafe = cafe;
    }

    public Drink() {
    }

    @ManyToOne()
    @JoinColumn(name = "cafe_id", nullable = false)
    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (id != drink.id) return false;
        if (cafe != drink.cafe) return false;
        if (name != null ? !name.equals(drink.name) : drink.name != null) return false;
        if (price != null ? !price.equals(drink.price) : drink.price != null) return false;
        if (capacity != null ? !capacity.equals(drink.capacity) : drink.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", cafe=" + cafe +
                '}';
    }
}