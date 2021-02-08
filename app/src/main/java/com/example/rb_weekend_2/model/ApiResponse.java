package com.example.rb_weekend_2.model;


import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {

    private final Integer total_results;
    private final Integer page;
    private final Integer per_page;
    private final List<Photo> photos;


    public ApiResponse(Integer total_results, Integer page, Integer per_page, List<Photo> photos ) {
        this.total_results = total_results;
        this.page = page;
        this.per_page = per_page;
        this.photos = photos;
    }

    public int getTotal_results() {
        return total_results;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}


//    private Time time;
//    private String disclaimer;
//    private String chartName;
//    private Bpi bpi;

//    public ApiResponse(Time time, String disclaimer, String chartName, Bpi bpi) {
//        this.time = time;
//        this.disclaimer = disclaimer;
//        this.chartName = chartName;
//        this.bpi = bpi;
//    }
//
//    public Time getTime() {
//        return time;
//    }
//
//    public void setTime(Time time) {
//        this.time = time;
//    }

//    public String getDisclaimer() {
//        return disclaimer;
//    }
//
//    public void setDisclaimer(String disclaimer) {
//        this.disclaimer = disclaimer;
//    }
//
//    public String getChartName() {
//        return chartName;
//    }
//
//    public void setChartName(String chartName) {
//        this.chartName = chartName;
//    }
//
//    public Bpi getBpi() {
//        return bpi;
//    }
//
//    public void setBpi(Bpi bpi) {
//        this.bpi = bpi;
//    }


