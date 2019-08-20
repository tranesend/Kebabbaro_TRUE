package data_repository;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;


public class Place {

    public long id;

    public String address = null;
    public double lat;
    public double lng;
    public String VideoAddress = null;
    public String price;
    public String nome;
    public Integer ore;
    public Integer minuti;
    public String priceM;
    public String priceB;


    public Place(long id, String videoAddress, String address, double lat, double lng, String price, String priceM, String priceB, String nome, Integer ore, Integer minuti){


            this.id = id;
            this.address = address;
            this.lat = lat;
            this.lng = lng;
            this.price = price;
            this.nome = nome;
            this.ore = ore;
            this.minuti = minuti;
            this.priceM = priceM;
            this.priceB = priceB;
            this.VideoAddress = videoAddress;
    }





}

