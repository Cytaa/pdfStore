package com.demo.pdfwebapp.controllers;

import com.demo.pdfwebapp.models.Pdf;
import com.demo.pdfwebapp.repositories.PdfRepo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class PdfController {
    private final PdfRepo pdfRepo;

    public PdfController(PdfRepo pdfRepo) {

        this.pdfRepo = pdfRepo;
    }

    public boolean addPdf(Pdf pdf) {

        if (!pdfNameIsUsed(pdf)) {

            if(!pdfAlreadyInDB(pdf)){
                pdfRepo.save(pdf);
                return true;
            }

        }
        return false;
    }

    public boolean pdfAlreadyInDB(Pdf pdf){
        long counter = 0;

        counter = pdfRepo.findAll().stream().filter(record -> record.getFile().length == pdf.getFile().length).count();

        if(counter == 0) return false;

        return true;
    }

    public boolean pdfNameIsUsed(Pdf pdf){
        long counter = 0;

        counter = pdfRepo.findAll()
                .stream()
                .filter(record -> record.getName()
                        .equals(pdf.getName()))
                .count();
        if(counter == 0) return false;

        return true;
    }

    public void deletePdf(long id) {
        pdfRepo.deleteById(id);

    }

    public List<Pdf> getAllPdfs() {
        return pdfRepo.findAll();
    }
}
