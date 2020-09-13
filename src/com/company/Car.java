package com.company;

import java.awt.*;

public class Car {
    private int CarId;
    private String CarName;
    private String Model;
    private Color color;
    private int year;
    private String description;
    private double engine;
    private String ImageSrc;

    public Car(){
        this.CarId = 0;
        this.CarName = "No value";
        this.Model = "No value";
        this.color = null;
        this.year = 0;
        this.description = "No value";
        this.engine = 0;
        this.ImageSrc = "NoImage";
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getImageSrc() {
        return ImageSrc;
    }

    public void setImageSrc(String imageSrc) {
        ImageSrc = imageSrc;
    }

    public Car(CarBuilder item){
        this.CarId = item.CarId;
        this.CarName = item.CarName;
        this.Model = item.Model;
        this.color = item.color;
        this.year = item.year;
        this.description = item.description;
        this.engine = item.engine;
        this.ImageSrc = item.ImageSrc;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int carId) {
        this.CarId = carId;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public static class CarBuilder{
        private int CarId;
        private String CarName;
        private String Model;
        private int year;
        private Color color;
        private String description;
        private double engine;
        private String ImageSrc;

        public CarBuilder(int CarId, String carName, String Model){
            this.CarId = CarId;
            this.CarName = carName;
            this.Model = Model;
        }

        public CarBuilder withYear(int year){
            this.year = year;
            return this;
        }

        public CarBuilder withColor(Color color){
            this.color = color;
            return this;
        }

        public CarBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public CarBuilder withEngine(double engine){
            this.engine = engine;
            return this;
        }
        public CarBuilder withImage(String ImageSrc){
            this.ImageSrc = ImageSrc;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
