/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

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
}
