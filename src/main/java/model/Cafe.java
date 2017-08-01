package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Cafe {
    private int id;
    private String address;
    private String name;
    private Director director;
    private List<Drink> drinkList = new ArrayList<Drink>();
    private Double rating;


    public Cafe(String address, String name, Director director, Double rating) {
        this.address = address;
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    public Cafe() {
    }

    @OneToMany(mappedBy = "cafe")
    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @ManyToOne
    @JoinColumn(name="dir_id")
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director dirId) {
        this.director = dirId;
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

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Basic
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cafe cafe = (Cafe) o;

        if (id != cafe.id) return false;
        if (address != null ? !address.equals(cafe.address) : cafe.address != null) return false;
        if (name != null ? !name.equals(cafe.name) : cafe.name != null) return false;
        if (director != null ? !director.equals(cafe.director) : cafe.director != null) return false;
        if (rating != null ? !rating.equals(cafe.rating) : cafe.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", director=" + director +
                ", rating=" + rating +
                '}';
    }
}
