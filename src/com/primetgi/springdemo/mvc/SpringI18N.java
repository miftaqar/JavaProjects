package com.primetgi.springdemo.mvc;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/SpringMvcInternationalization")
public class SpringI18N {

	@RequestMapping("/init")
	public String showWelcomePage(Model model) {
		model.addAttribute("welcome_msg", "Spring MVC Internationalization Example");
		return "spring-internationalization";
	}
}
