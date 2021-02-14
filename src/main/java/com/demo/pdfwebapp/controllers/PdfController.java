package com.demo.pdfwebapp.controllers;

import com.demo.pdfwebapp.repositories.PdfRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pdfs")
public class PdfController {
    private final PdfRepo pdfRepo;

    public PdfController(PdfRepo pdfRepo) {
        this.pdfRepo = pdfRepo;
    }

    @GetMapping("/pdfs")
    public String getAllPdfs (Model model){
        Iterable pdfs = pdfRepo.findAll();
        model.addAttribute("pdfs", pdfs);

        return "AllMovies";
    }

    @GetMapping
    public ResponseEntity listPdfs(){
        return new ResponseEntity(pdfRepo.findAll(), HttpStatus.ACCEPTED);
    }
}
