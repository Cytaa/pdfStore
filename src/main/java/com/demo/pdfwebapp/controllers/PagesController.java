package com.demo.pdfwebapp.controllers;

import com.demo.pdfwebapp.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {
    private PdfService pdfService;

    @Autowired
    PagesController(PdfService pdfService){
        this.pdfService = pdfService;

    }

    @GetMapping("/home")
    public String showHomePage(Model model){
        model.addAttribute("pdfs",pdfService.getAllPdfs());
        return "index";
    }


}
