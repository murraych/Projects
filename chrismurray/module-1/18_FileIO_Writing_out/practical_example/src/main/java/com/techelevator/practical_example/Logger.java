package com.techelevator.practical_example;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger implements Closeable{

	private File logFile;
	private PrintWriter writer;
	
	public Logger(String logFile) throws Exception {
		
		this.logFile = new File(logFile);
		
		if( this.logFile.exists()) {
			try {
				writer = new PrintWriter(new FileWriter(this.logFile,true));
			} catch (Exception ex) {
				throw new IOException(ex.toString());
			}
		}else {
			writer = new PrintWriter(this.logFile);
		}
			
	}

	public void Write(String logMessage) {

		try{
			writer.println(logMessage);
			writer.flush();
		}
		catch(Exception ex)
		{
			throw ex;
		}

	}

	@Override
	public void close() throws IOException {

		try{
			writer.close();
		}
		catch(Exception ex) {
			throw new IOException(ex.getMessage());
		}
		finally {}
		
	}
	
}
