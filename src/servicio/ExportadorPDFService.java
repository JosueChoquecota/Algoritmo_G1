/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import src.model.Curso;
import src.model.Estudiante;
import src.model.EstudianteCurso;


public class ExportadorPDFService {
     public void exportarTabla(List<EstudianteCurso> estudiantes, File destino) {
            if (!destino.getName().toLowerCase().endsWith(".pdf")) {
                destino = new File(destino.getAbsolutePath() + ".pdf");
            }
         Document document = new Document();

        try {
            PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(destino));
            document.open();

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("Lista de Estudiantes", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            // Crear tabla
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            // Encabezados
            tabla.addCell("CodEst");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Curso");
            tabla.addCell("Estado");
            tabla.addCell("Puntos");

            // Filass
            for (EstudianteCurso ec : estudiantes) {
                Estudiante e = ec.getEstudiante();
                Curso c = ec.getCurso();

                tabla.addCell(e.getCodEst());
                tabla.addCell(e.getNombre());
                tabla.addCell(e.getApellido());
                tabla.addCell(c.getCursoNombre());
                tabla.addCell(ec.getEstado());
                tabla.addCell(String.valueOf(ec.getParticipacionTotal()));
            }

            document.add(tabla);
            document.close();

            System.out.println("✅ PDF generado correctamente en: " + destino.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al generar PDF: " + e.getMessage());
        }
    }    
}
