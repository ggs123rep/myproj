package dru.poc.pdf.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

import dru.poc.pdf.bean.pdfBean;
import dru.poc.pdf.service.pdfService;

@Controller
@RequestMapping("/test")
public class pdfController  {
	
	@Autowired
	pdfService ps;

	@GetMapping(value = "/pdfgen")
	public void fetchServiceWiseTax(HttpServletResponse response) throws IOException, DocumentException {
		 response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
		pdfBean pd = new pdfBean();
		pd.setOrgid("1211");
		pd.setOrgName("Appolo Hospitals");
		pd.setCity("Hyderabad");
		pd.setVentilators("45");

		ps.export( pd,response);
	}

}
