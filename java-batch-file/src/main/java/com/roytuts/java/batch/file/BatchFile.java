package com.roytuts.java.batch.file;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BatchFile {

	public static void main(String[] args) {
		try {
			// create new file called sample in "d" drive
			File file = new File("sample.bat");
			FileOutputStream fos = new FileOutputStream(file);

			// write some commands to the file
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeBytes("cd \\");
			dos.writeBytes("\n");
			dos.writeBytes("echo %path%");
			dos.writeBytes("\n");

			// execute the batch file
			Process p = Runtime.getRuntime().exec("cmd /c start sample.bat");

			// wait for termination
			p.waitFor();

			dos.close();
		} catch (Exception ex) {
		}
	}

}
