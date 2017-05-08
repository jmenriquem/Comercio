/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String description;
    private float price;
    private Date inputDate;

    public Product(String name, String description, float price, Date inputDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inputDate = inputDate;
    }

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * Convierte un ArrayList de Object a uno de Product
     *
     * @param objects ArrayList<Object> - El ArrayList a convertir
     * @return ArrayList<Product> - El ArrayList convertido
     */
    public static ArrayList<Product> ObjectToProduct(ArrayList<Object> objects) {
        ArrayList<Product> listado = new ArrayList<>();
        objects.forEach((object) -> {
            listado.add((Product) object);
        });
        return listado;
    }

    public static List ObjectToProduct(List objects) {
        List listado = new ArrayList();
        objects.forEach((object) -> {
            listado.add((Product) object);
        });
        return listado;
    }

    public static ArrayList<Object> ProductToObject(ArrayList<Product> products) {
        ArrayList<Object> listado = new ArrayList<>();
        products.forEach((product) -> {
            listado.add((Object) product);
        });
        return listado;
    }

    public static List ProductToObject(List<Product> products) {
        List listado = new ArrayList();
        products.forEach((product) -> {
            listado.add((Object) product);
        });
        return listado;
    }
}
