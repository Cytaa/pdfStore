package com.demo.pdfwebapp.controllers;

import com.demo.pdfwebapp.models.Pdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PagesController {
    private PdfController pdfController;

    @Autowired
    PagesController(PdfController pdfController){
        this.pdfController = pdfController;

    }

    @GetMapping("/home")
    public String showHomePage(Model model){
        model.addAttribute("pdfs", pdfController.getAllPdfs());
        return "index";
    }
    @PostMapping("/addPdf")
    public String addPdf(Pdf pdf){
        pdf.setTodaysData();
        pdf.setSize(String.valueOf(pdf.getFile().length));
        pdfController.addPdf(pdf);

        return "index";
    }

}
