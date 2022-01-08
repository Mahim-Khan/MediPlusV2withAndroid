package com.example.myapplicationdemo;

public class itemModel {
    private String id;
    private String name;
    private String medicine_name;
    private String dose;
    private String prize;
    private String doctorDetails;



    public itemModel(String id, String name,String medicine_name,String dose,String prize,String doctorDetails) {
      this.id = id;
      this.name = name;
        this.medicine_name = medicine_name;
        this.dose = dose;
        this.prize = prize;
        this.doctorDetails = doctorDetails;
   }


//    @Override
//    public String toString() {
//        return "itemModel{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", medicine_name='" + medicine_name + '\'' +
//                ", dose='" + dose + '\'' +
//                ", prize='" + prize + '\'' +
//                ", doctorDetails='" + doctorDetails + '\'' +
//                '}';
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
    public String getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(String doctorDetails) {
        this.doctorDetails = doctorDetails;
    }






}
