package com.demo.pdfwebapp.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "pdf")
@Data
public class Pdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Date uploadDate;

    private String size;

    @Basic
    private byte[] file;

    public Pdf(){

    }

    public Pdf(String name, String description, Date uploadDate, String size, byte[] file) {
        this.name = name;
        this.description = description;
        this.uploadDate = uploadDate;
        this.size = size;
        this.file = file;
    }

    public void setTodaysData(){
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.setUploadDate(date);

    }

}
