package com.example.recuprimerparciallabovfinal1;
import java.io.Serializable;
import java.util.Objects;

public class AutoModel implements Serializable {
    private int id;
    private String make;
    private String model;
    private int year;

    public AutoModel(){}

    public AutoModel(int id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoModel autoModel = (AutoModel) o;
        return id == autoModel.id &&
                model == autoModel.model &&
                year == autoModel.year &&
                Objects.equals(make, autoModel.make) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, year);
    }

    @Override
    public String toString() {
        return "AutoModel{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model=" + model +
                ", year=" + year +
                '}';
    }
}