package com.roytuts.java.batch.file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BatchFile {

	public static void main(String[] args) {
		try {
			final String fileName = "sample.bat";
			final String filePath = "C:/eclipse-workspace";
			
			// create new file called sample.bat
			File file = new File(filePath + File.separator + fileName);
			
			FileOutputStream fos = new FileOutputStream(file);

			// write some commands to the file
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeBytes("cd \\");
			dos.writeBytes("\n");
			dos.writeBytes("%path%");
			dos.writeBytes("\n");
			dos.close();

			// execute the batch file
			//Process p = Runtime.getRuntime().exec("cmd /c start sample.bat"); // The method exec(String) from the type
																				// Runtime is deprecated since version
																				// 18
			
			//Java 19 fix
			//String[] command = {"cmd.exe", "/c", "Start", filePath+File.separator+fileName};
            //Process p =  Runtime.getRuntime().exec(command);
            
			//Helps in debugging if any issue occurs
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", fileName);
			pb.directory(new File(filePath));
			Process p = pb.start();
			
			// wait for termination
			p.waitFor();			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
