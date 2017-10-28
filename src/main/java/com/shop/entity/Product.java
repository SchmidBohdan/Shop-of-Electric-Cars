package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String name;
    private String price;
    private String currency;

    private String pathImg;


    @ManyToOne
    private Guarantee guarantees;


    @ManyToMany
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Orders> orders = new ArrayList<>();


//    @ManyToOne
//    private Country country;
//
//    @ManyToOne
//    private City city;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "product_user",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users = new ArrayList<>();

    @ManyToOne
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "product")
    private List<Specefication> specefications ;

    public Product() {
    }

    public Product(String description, String name, String price, String currency) {
        super();
        this.description = description;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public Guarantee getGuarantees() {
        return guarantees;
    }

    public void setGuarantees(Guarantee guarantees) {
        this.guarantees = guarantees;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setSpecefications(List<Specefication> specefications) {
        this.specefications = specefications;
    }
    public List<User> getUsers() {
        return users;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public List<Specefication> getSpecefications() {
        return specefications;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
//    public Country getCountry() {
//        return country;
//    }
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//    public City getCity() {
//        return city;
//    }
//    public void setCity(City city) {
//        this.city = city;
//    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", guarantees=" + guarantees +
                ", orders=" + orders +
                ", users=" + users +
                ", manufacturer=" + manufacturer +
                ", specefications=" + specefications +
                '}';
    }
}


