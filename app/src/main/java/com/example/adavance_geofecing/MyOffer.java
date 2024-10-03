package com.example.adavance_geofecing;

public class MyOffer {

String Shopname,Mobileno,Address,Product1,Product2,Offer1,Offer2,imageurl,lati,longi;

    public MyOffer() {
    }

    public MyOffer(String shopname, String mobileno, String address, String product1, String product2, String offer1, String offer2, String imageurl, String lati, String longi) {
        Shopname = shopname;
        Mobileno = mobileno;
        Address = address;
        Product1 = product1;
        Product2 = product2;
        Offer1 = offer1;
        Offer2 = offer2;
        this.imageurl = imageurl;
        this.lati = lati;
        this.longi = longi;
    }

    public String getShopname() {
        return Shopname;
    }

    public void setShopname(String shopname) {
        Shopname = shopname;
    }

    public String getMobileno() {
        return Mobileno;
    }

    public void setMobileno(String mobileno) {
        Mobileno = mobileno;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProduct1() {
        return Product1;
    }

    public void setProduct1(String product1) {
        Product1 = product1;
    }

    public String getProduct2() {
        return Product2;
    }

    public void setProduct2(String product2) {
        Product2 = product2;
    }

    public String getOffer1() {
        return Offer1;
    }

    public void setOffer1(String offer1) {
        Offer1 = offer1;
    }

    public String getOffer2() {
        return Offer2;
    }

    public void setOffer2(String offer2) {
        Offer2 = offer2;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }
}
