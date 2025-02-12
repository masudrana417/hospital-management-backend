//package com.example.HMS.hospital_management.controller;
//
//
//import com.example.HMS.hospital_management.repository.PatientRepository;
//
//import net.sf.jasperreports.engine.JRException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.*;
//
//@Controller
//public class InvoiceController {
//
//    @Autowired
//    PatientRepository patientRepository;
//
//
//    @GetMapping(value = "/download/{format}")
//    public ResponseEntity<byte[]> downloadReport(@PathVariable String format) throws JRException, IOException {
//
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(patientRepository.findAll(), false);
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("total", "7000");
//
//        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/hms.jrxml"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
//
//        byte[] data;
//        HttpHeaders headers = new HttpHeaders();
//
//        switch (format.toLowerCase()) {
//            case "pdf":
//                data = JasperExportManager.exportReportToPdf(jasperPrint);
//                headers.setContentType(MediaType.APPLICATION_PDF);
//                headers.add("Content-Disposition", "inline; filename=report.pdf");
//                break;
//
//            case "html":
//                ByteArrayOutputStream htmlOutput = new ByteArrayOutputStream();
//                HtmlExporter htmlExporter = new HtmlExporter();
//                htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(htmlOutput));
//                htmlExporter.exportReport();
//
//                data = htmlOutput.toByteArray();
//                headers.setContentType(MediaType.TEXT_HTML);
//                headers.add("Content-Disposition", "inline; filename=report.html");
//                break;
//
//
//            case "xlsx":
//                ByteArrayOutputStream xlsxOutput = new ByteArrayOutputStream();
//                JRXlsxExporter exporter = new JRXlsxExporter();
//                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsxOutput));
//                SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
//                configuration.setOnePagePerSheet(true);
//                configuration.setDetectCellType(true);
//                exporter.setConfiguration(configuration);
//                exporter.exportReport();
//                data = xlsxOutput.toByteArray();
//                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                headers.add("Content-Disposition", "attachment; filename=report.xlsx");
//                break;
//
//            case "csv":
//                ByteArrayOutputStream csvOutput = new ByteArrayOutputStream();
//                JRCsvExporter csvExporter = new JRCsvExporter();
//                csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                csvExporter.setExporterOutput(new SimpleWriterExporterOutput(csvOutput));
//                SimpleCsvExporterConfiguration csvConfig = new SimpleCsvExporterConfiguration();
//                csvExporter.setConfiguration(csvConfig);
//                csvExporter.exportReport();
//                data = csvOutput.toByteArray();
//                headers.setContentType(MediaType.TEXT_PLAIN);
//                headers.add("Content-Disposition", "attachment; filename=report.csv");
//                break;
//
//            case "docx":
//                ByteArrayOutputStream docxOutput = new ByteArrayOutputStream();
//                JRDocxExporter docxExporter = new JRDocxExporter();
//                docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxOutput));
//                docxExporter.exportReport();
//                data = docxOutput.toByteArray();
//                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                headers.add("Content-Disposition", "attachment; filename=report.docx");
//                break;
//            default:
//                return ResponseEntity.badRequest().body(null);
//        }
//
//        return ResponseEntity.ok().headers(headers).body(data);
//
//    }
//
//}