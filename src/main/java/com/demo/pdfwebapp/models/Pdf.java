package com.demo.pdfwebapp.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pdf")
@Data
public class Pdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorId;

    private String name;

    private String description;

    private Date uploadDate;

    private String size;

    @Basic
    private byte[] file;

    public Pdf(){

    }



}
