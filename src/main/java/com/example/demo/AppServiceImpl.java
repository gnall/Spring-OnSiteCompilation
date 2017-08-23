package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

	// private AccountDao accountDao;

	@Override
	public String testCode(String userResponse) {
		String result = "blank";
		result = testTheCode(userResponse);
		return result;
	}

	public String testTheCode(String userResponse) {
		String result = "Didn't work";
		try {
			File usersFile = new File("test/testpack/HelloWorld.java");
			//Create the file
			if (usersFile.createNewFile()){
			System.out.println("File is created!");
			}else{
			System.out.println("File already exists.");
			}
			 
			//Write Content
			FileWriter writer = new FileWriter(usersFile);
			writer.write(userResponse);
			writer.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		// try {
		// PrintWriter writer = new
		// PrintWriter("test/testpack/HelloWorld-username.java", "UTF-8");
		// writer.println(userResponse);
		// writer.close();
		// } catch (IOException e) {
		// System.out.println("Can't create the file");
		// }
		try {
			runProcess("javac test/testpack/HelloWorld.java");
			result = runProcess("java -cp test/ testpack.HelloWorld");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't run the file");
		}
		return result;
	}

	private String runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		String result = printLines(command + " stdout:", pro.getInputStream());
		result = result + printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
		return result;
	}

	private static String printLines(String name, InputStream ins) throws Exception {
		String line = null;
		String result = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
			result = result + line;
		}
		return result;
	}
	
}
