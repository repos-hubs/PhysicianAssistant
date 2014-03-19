package com.jibo.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table hospital_city.
 * 
 * 城市信息表
 * 
 */
public class HospitalCity {

    private String provinceName;
    private String cityName;

    public HospitalCity() {
    }

    public HospitalCity(String provinceName, String cityName) {
        this.provinceName = provinceName;
        this.cityName = cityName;
    }

    public HospitalCity(String cityName) {
        this.cityName = cityName;
    }
    
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    @Override
    public String toString() {
    	return cityName;
    }
    @Override
 	public boolean equals(Object o) {
 		return o.toString().equals(cityName);
 	}

}
