/*
 * All GTAS code is Copyright 2016, The Department of Homeland Security (DHS), U.S. Customs and Border Protection (CBP).
 *
 * Please see LICENSE.txt for details.
 */
package gov.gtas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class KibanaDashboardController {

	private static final String KIBANA_HOST = "http://localhost";
	private static final String KIBANA_PORT = "5601";

	@GetMapping(path = "/defaultDashboard", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String defaultDashboard(HttpServletResponse res) {

		RestTemplate rest = new RestTemplate();

		String result = rest.getForObject(KIBANA_HOST + ":" + KIBANA_PORT
				+ "/app/kibana#/dashboard/7cfbbdc0-2e13-11e9-81a3-0f5bd8b0a7ac?embed=true&_g=(refreshInterval%3A(pause%3A!t%2Cvalue%3A0)%2Ctime%3A(from%3Anow-4d%2Fd%2Cmode%3Arelative%2Cto%3Anow%2B4d%2Fd))",
				String.class);
		
		result  = result.replaceAll("/bundles", "/gtas/bundles");
		result  = result.replaceAll("/plugins", "/gtas/plugins");

		return result;

	}
	
	@GetMapping(path =  {"/bundles/**", "/plugins/**","/app/kibana/**"})
	@ResponseBody
	public String bundles(HttpServletRequest req, HttpServletResponse res) {
		
		RestTemplate rest = new RestTemplate();
		
		String url = KIBANA_HOST + ":" + KIBANA_PORT
				 + req.getRequestURI();
		
		url = url.replace("/gtas", "");
		System.out.println(url);		
		String result =  rest.getForObject(url,
				String.class);
		result  = result.replaceAll("/bundles", "/gtas/bundles");
		result  = result.replaceAll("/plugins", "/gtas/plugins");
		
		return result;
	}
}
