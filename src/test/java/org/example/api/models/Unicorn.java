package org.example.api.models;

public class Unicorn {
    private String name;
    private String tailColor;

    public Unicorn(String name, String tailColor) {
        this.name = name;
        this.tailColor = tailColor;
    }

    public String getName() {
        return name;
    }

    public String getTailColor() {
        return tailColor;
    }

    @Override
    public String toString() {
        return "Unicorn{" +
                "name='" + name + '\'' +
                ", tailColor='" + tailColor + '\'' +
                '}';
    }

    public String toJson() {
        return "{\"name\":\"" +name+"\",\"tailColor\":\"" +tailColor+"\"}";
    }
}
