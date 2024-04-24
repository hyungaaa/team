package com.spring.lee;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.lee.FileDownload;
import com.spring.lee.QR;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QrController {
	
	private static final Logger logger = LoggerFactory.getLogger(QrController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/qr", method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			@RequestParam("qrNum") String qrNum) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		System.out.println("qrNum : " + qrNum);
		QR qr = new QR();
		qr.create(qrNum, "qr_test", "png");
		model.addAttribute("qr", "qr_test.png");
		model.addAttribute("qrNum", qrNum);

		return "qrpage";
	}
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response, 
			@RequestParam("fileName") String fileName) {
		FileDownload fileDownload = new FileDownload();
		try {
			fileDownload.download(response, fileName);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
