package com.demo.pdfwebapp.controllers;

import com.demo.pdfwebapp.models.Pdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PagesController {
    private final PdfController pdfController;

    @Autowired
    PagesController(PdfController pdfController) {
        this.pdfController = pdfController;

    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("pdfs", pdfController.getAllPdfs());
        return "index";
    }

    @GetMapping("/nameError")
    public String showNameErrorPage(Model model) {
        return "nameIsUsed";
    }

    @PostMapping("/addPdf")
    public RedirectView addPdf(Pdf pdf) {

        pdf.setTodaysData();
        pdf.setSize(String.valueOf(pdf.getFile().length));

        if (pdfController.addPdf(pdf) == true) return new RedirectView("/home");

        return new RedirectView("/nameError");
    }

    @PostMapping("/deletePdf")
    public RedirectView deletePdf(Pdf pdf) {
        pdfController.deletePdf(pdf.getId());
        return new RedirectView("/home");
    }

}
