package com;

public class Data {
    private String name;
    private String points;

    public Data() {
    }

    public Data(String name, String points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
