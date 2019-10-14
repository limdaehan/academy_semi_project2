package lx.edu.semi.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/selectParking.do", method=RequestMethod.GET)
	public String getForm() {
		// jsp 파일 이름을 리턴한다.
		return "selectParking";
	}
	
	@RequestMapping("lendPage.do")
	public String getLend(Model model) {
		
		return "lendPage";
	}
	
	@RequestMapping("borrowPage.do")
	public String getBorrow(Model model) {
	
		return "borrowPage";
	}
	
	@RequestMapping("infoPage.do")
	public String getInfo(Model model) {
		
		return "infoPage";
	}
	
	@RequestMapping("mapsearch.do")
	public String getMap(Model model) {
		
		return "mapsearch";
	}
	
	@RequestMapping("jsp.do")
	public String jsp(Model model) {
		
		return "jsp";
	}
	
}
