package dru.poc.pdf.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

import dru.poc.pdf.bean.pdfBean;

@Service
public class pdfService {

	private static final String PDF_BOLD_FONT_TYPE = null;
	private static final String PDF_FONT_SIZE_FOR_TABLE_HEADING = null;
	
	
	

	public void export(pdfBean pd, HttpServletResponse response) throws DocumentException, IOException {
		
		Document document = new Document(PageSize.A4, 10f, 10f, 10f, 30f);
		PdfWriter	writer = PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		 PdfPTable header = new PdfPTable(2);
	       
	            // set defaults
	            header.setWidths(new int[]{8, 24});
	            header.setTotalWidth(527);
	            header.setLockedWidth(true);
	            header.getDefaultCell().setMinimumHeight(40);
	            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
	            Image logo = Image.getInstance("C:\\test\\tets.png");
	            header.addCell(logo);
	            PdfPCell text = new PdfPCell();
	            text.setPaddingBottom(15);
	            text.setPaddingLeft(10);
	            text.setBorder(Rectangle.BOTTOM);
	           // text.setBorderColor(BaseColor.LIGHT_GRAY);
	           
	            text.addElement(new Phrase("SRIKARA HOSPITALS"));
	            text.addElement(new Phrase("https://srikarahospitals.com"));
	            text.addElement(new Phrase("Alwyn x road Miyapur"));
	            text.addElement(new Phrase("Hyderabad 545454"));
	            header.addCell(text);
                
	            // write content
	            header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
	
	            
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		
		document.add(new Paragraph(" "));
		
		
		Paragraph paragraph = new Paragraph(
				null, FontFactory.getFont(PDF_BOLD_FONT_TYPE, PDF_FONT_SIZE_FOR_TABLE_HEADING));
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		document.add(new Paragraph(" "));
		PdfPTable filterTable = new PdfPTable(2);
	
		
		filterTable.setWidthPercentage(100);
		
		filterTable.setWidths(new float[] { 3.5f, 2.1f });
		
		filterTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		
		PdfPCell pcell2 = new  PdfPCell(new Paragraph("Name: BRUCE WAYNE",new Font(Font.HELVETICA, 12, Font.BOLD)));
		pcell2.setBorder(Rectangle.LEFT | Rectangle.TOP);
		filterTable.addCell(pcell2);
		PdfPCell pcell = new  PdfPCell(new Paragraph("Patient id: 12121"));
		pcell.setBorder(Rectangle.RIGHT | Rectangle.TOP);
		
		filterTable.addCell(pcell);
		/*
		 * filterTable.addCell(pd.getOrgName());
		 * 
		 * filterTable.addCell(pd.getCity()); filterTable.addCell(pd.getVentilators());
		 */
		PdfPCell pcell3 = new  PdfPCell(new Paragraph("City: Hyderabad"));
		pcell3.setBorder(Rectangle.LEFT );
		filterTable.addCell(pcell3);
		
		PdfPCell pcell4 = new  PdfPCell(new Paragraph("Test id: 4343"));
		pcell4.setBorder(Rectangle.RIGHT );
		filterTable.addCell(pcell4);
		
		PdfPCell pcell5 = new  PdfPCell(new Paragraph("Sex: MALE"));
		pcell5.setBorder(Rectangle.LEFT );
		filterTable.addCell(pcell5);
		
		PdfPCell pcell6 = new  PdfPCell(new Paragraph("AGE: 45"));
		pcell6.setBorder(Rectangle.RIGHT );
		filterTable.addCell(pcell6);
		PdfPCell pcell7 = new  PdfPCell(new Paragraph("BLOOD GROUP: O+VE"));
		pcell7.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		filterTable.addCell(pcell7);
		PdfPCell pcell8 = new  PdfPCell(new Paragraph("WEIGHT: 76KGS"));
		pcell8.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		filterTable.addCell(pcell8);
		document.add(filterTable);
		//filterTable.setTableEvent(new MyTableEvent());
		document.add(new Paragraph(" "));
		PdfPTable body = new PdfPTable(1);
		body.setWidthPercentage(100);
		PdfPCell p = new  PdfPCell(new Paragraph("LAB RESULT" ,new Font(Font.HELVETICA, 12, Font.BOLD)));
		p.setBorder(Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
		p.setFixedHeight(20);
		p.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		body.setWidthPercentage(100);
		body.addCell(p);
		document.add(body);
		document.add(new Paragraph(" "));
		//--------------------------------
		
		PdfPTable bodyContent = new PdfPTable(4);
		bodyContent.setWidthPercentage(100);
		bodyContent.setWidths(new float[] { 3.5f, 2.1f, 1.4f, 1.3f});
		bodyContent.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		PdfPCell pc1 = new  PdfPCell(new Paragraph("TEST NAME",new Font(Font.HELVETICA, 9, Font.UNDERLINE)));
		pc1.setBorder(Rectangle.NO_BORDER);
		
		bodyContent.addCell(pc1);
		PdfPCell pc2 = new  PdfPCell(new Paragraph("OBSERVED VALUE",new Font(Font.HELVETICA, 9, Font.UNDERLINE)));
		pc2.setBorder(Rectangle.NO_BORDER);
		bodyContent.addCell(pc2);
		PdfPCell pc3 = new  PdfPCell(new Paragraph("UNITS",new Font(Font.HELVETICA, 9, Font.UNDERLINE)));
		pc3.setBorder(Rectangle.NO_BORDER);
		bodyContent.addCell(pc3);
		PdfPCell pc4 = new  PdfPCell(new Paragraph("REF.RANGES",new Font(Font.HELVETICA, 9, Font.UNDERLINE)));
		pc4.setBorder(Rectangle.NO_BORDER);
		bodyContent.addCell(pc4);
		
		
		bodyContent.setHeaderRows(1);
		
		for (int i = 1; i < 6; i++) {
			bodyContent.addCell(new Phrase("Blood test", new Font(Font.HELVETICA, 12, Font.BOLD)));
			bodyContent.addCell("13 ");
			bodyContent.addCell(" ");
			bodyContent.addCell("32");
		}
		
		document.add(bodyContent);
		Paragraph pn = new Paragraph("**END OF REPORT**",new Font(Font.HELVETICA, 12, Font.BOLD));
		pn.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pn);
		//--------------------
		
	    	PdfPTable footer = new PdfPTable(3); // set defaults
            footer.setWidths(new int[]{24, 2, 1});
            footer.setTotalWidth(527);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(40);
            footer.getDefaultCell().setBorder(Rectangle.TOP);
            //footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add copyright
            footer.addCell(new Phrase("\u00A9 Srikara Hospitals", new Font(Font.HELVETICA, 12, Font.BOLD)));

            // add current page count
            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.HELVETICA, 8)));

            // add placeholder for total page count
            PdfPCell totalPageCount = new PdfPCell();
            totalPageCount.setBorder(Rectangle.TOP);
           // totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
            footer.addCell(totalPageCount);
		
            PdfContentByte canvas = writer.getDirectContent();
           
            footer.writeSelectedRows(0, -1, 34, 50, canvas);
	
		
		
		document.close();
		
		
	}
	
	
	

}
