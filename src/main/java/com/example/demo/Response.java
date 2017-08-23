package com.example.demo;
//Joe Gnall
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

//Product Class
public class Response {
	
	
	@NotEmpty
	@Size(min=8,max=2000)
	public String responseText;

	@NotEmpty
	@Size(min=8,max=2000)
	public String responseOutput="";
	
	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public String getResponseOutput() {
		return responseOutput;
	}

	public void setResponseOutput(String responseOutput) {
		this.responseOutput = responseOutput;
	}
	
	
}
