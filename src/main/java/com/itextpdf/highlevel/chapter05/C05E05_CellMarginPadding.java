/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2017 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/*
 * This example was written by Bruno Lowagie
 * in the context of the book: iText 7 building blocks
 */
package com.itextpdf.highlevel.chapter05;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.test.annotations.WrapToTest;
import java.io.File;
import java.io.IOException;

/**
 * @author Bruno Lowagie (iText Software)
 */
@WrapToTest
public class C05E05_CellMarginPadding {
    
    public static final String DEST = "results/chapter05/cell_margin_padding.pdf";
       
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C05E05_CellMarginPadding().createPdf(DEST);
    }
    
    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        
        // Initialize document
        Document document = new Document(pdf);
        Table table = new Table(UnitValue.createPercentArray(new float[]{40, 20, 20}));
        table.setBackgroundColor(Color.ORANGE);
        table.setWidthPercent(80);
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);
        table.addCell(
            new Cell(1, 3).add("Cell with colspan 3")
                .setPadding(10).setMargin(5).setBackgroundColor(Color.GREEN));
        table.addCell(new Cell(2, 1).add("Cell with rowspan 2")
            .setMarginTop(5).setMarginBottom(5).setPaddingLeft(30)
            .setFontColor(Color.WHITE).setBackgroundColor(Color.BLUE));
        table.addCell(new Cell().add("row 1; cell 1")
            .setFontColor(Color.WHITE).setBackgroundColor(Color.RED));
        table.addCell(new Cell().add("row 1; cell 2"));
        table.addCell(new Cell().add("row 2; cell 1").setMargin(10)
            .setFontColor(Color.WHITE).setBackgroundColor(Color.RED));
        table.addCell(new Cell().add("row 2; cell 2").setPadding(10)
            .setFontColor(Color.WHITE).setBackgroundColor(Color.RED));
        document.add(table);
        document.close();
    }
}
