package com.company.weatherservice.model;

import com.sun.tools.javac.Main;
import lombok.Data;

import java.util.List;
@Data
public class WeatherData {
    private Coord coord;
    private List<Weather> weather;
    private String base;
   // private Main main;
    private long visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private long timezone;
    private long id;
    private String name;
    private long cod;
}
