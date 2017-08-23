package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class QController {

	@Autowired
	private AppService appService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndexPage(Response response, Model model) {
		response.setResponseText("prefilled code");
		response.setResponseOutput("");
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String submitCode(Response response, BindingResult bindingResult, Model model) {
		//System.out.println(response.getResponseText());
		String userTestResult = appService.testCode(response.getResponseText());
		// testCode(response.getResponseText());
		response.setResponseOutput(userTestResult);
		return "index";
	}


}
