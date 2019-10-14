package project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ConsumeReport {
	public static String setFileName() {
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine(); 
		return fileName;
	}
	
	public static void createReport(String fileName) {
		File file = new File(fileName);
		
		String path = file.getAbsolutePath();
		System.out.println("파일 경로: " + path);
		
		long fileSize = file.length();
		System.out.println("파일 크기: "+ fileSize);
		
		try {
			FileOutputStream outstream = new FileOutputStream(file);
			
			OutputStreamWriter writer = new OutputStreamWriter(outstream);
			
			writer.write("test");
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
