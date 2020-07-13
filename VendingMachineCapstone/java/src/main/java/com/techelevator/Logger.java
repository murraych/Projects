package com.techelevator;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger implements Closeable{

	private File loggerFile;
	private PrintWriter writer;
	
	public Logger(String logFile) throws Exception {
		
		this.loggerFile = new File(logFile);
		
		if( this.loggerFile.exists()) {
			try {
				writer = new PrintWriter(new FileWriter(this.loggerFile,true));
			} catch (Exception e) {
				throw new IOException(e.toString());
			}
		}else {
			writer = new PrintWriter(this.loggerFile);
		}
			
	}

	public void Write(String logMessage) {

		try{
			writer.println(logMessage);
			writer.flush();
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	@Override
	public void close() throws IOException {

		try{
			writer.close();
		}
		catch(Exception e) {
			throw new IOException(e.getMessage());
		}
		finally {}
		
	}
	
}
