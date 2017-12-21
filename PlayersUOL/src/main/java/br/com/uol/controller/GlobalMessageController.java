package br.com.uol.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class GlobalMessageController {
	
	@ExceptionHandler(Exception.class)
	protected ModelAndView handleAllException(Exception ex, String urlGoBack) {
		ModelAndView model = new ModelAndView("util/message");
		model.addObject("errMsg", ex.getMessage());
		model.addObject("url", urlGoBack);

		return model;
	}
	
	protected ModelAndView handleAllWarn(String message, String urlGoBack) {
		ModelAndView model = new ModelAndView("util/message");
		model.addObject("warnMsg", message);
		model.addObject("url", urlGoBack);

		return model;
	}
	
	protected ModelAndView handleAllSuccess(String message, String urlGoBack) {
		ModelAndView model = new ModelAndView("util/message");
		model.addObject("successMsg", message);
		model.addObject("url", urlGoBack);

		return model;
	}

}
