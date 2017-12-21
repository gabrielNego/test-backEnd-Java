package br.com.uol.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import org.springframework.web.servlet.ModelAndView;

public class BaseController extends GlobalMessageController{

	protected ModelAndView redirecti(String viewName, Map<String, Object> params) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName(viewName);
		if(params != null && params.size() > 0) {
			Set<String>keys = params.keySet();
			for (String key : keys) {
				MV.addObject(key, params.get(key));
			}
		}
		return MV;

	}
	
	protected ModelAndView redirecti(String viewName) {	
		return this.redirecti(viewName, null);
	}

	protected String sendGet(String url) throws Exception {
		URL tempURL = new URL(url);
		HttpURLConnection con = (HttpURLConnection) tempURL.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		// System.out.println(response.toString());

		return response.toString();
	}

}
