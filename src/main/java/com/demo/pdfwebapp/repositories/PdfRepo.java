package com.demo.pdfwebapp.repositories;

import com.demo.pdfwebapp.models.Pdf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfRepo extends JpaRepository<Pdf, Long> {
}
