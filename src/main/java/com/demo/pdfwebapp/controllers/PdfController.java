package com.demo.pdfwebapp.controllers;

import com.demo.pdfwebapp.models.Pdf;
import com.demo.pdfwebapp.repositories.PdfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfController {
    private final PdfRepo pdfRepo;

    public PdfController(PdfRepo pdfRepo){

        this.pdfRepo = pdfRepo;
    }

    public void addPdf(Pdf pdf){

        pdfRepo.save(pdf);
    }

    public void deletePdf(long id){
        pdfRepo.deleteById(id);
    }

    public List<Pdf> getAllPdfs(){
        return pdfRepo.findAll();
    }
}
