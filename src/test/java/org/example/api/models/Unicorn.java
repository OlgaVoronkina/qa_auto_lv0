package org.example.api.models;

import com.google.gson.annotations.SerializedName;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Unicorn {

    private String name;
    private String tailColor;
    @SerializedName("_id")
    private String id;

//    public Unicorn(String name, String tailColor) {
//        this.name = name;
//        this.tailColor = tailColor;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getTailColor() {
//        return tailColor;
//    }
//
//    @Override
//    public String toString() {
//        return "Unicorn{" +
//                "name='" + name + '\'' +
//                ", tailColor='" + tailColor + '\'' +
//                '}';
//    }
//
//    public String toJson() {
//        return "{\"name\":\"" +name+"\",\"tailColor\":\"" +tailColor+"\"}";
//    }
}
