package com.threadTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FileExistUsingThread {
	static ScheduledExecutorService thread;
	public static String FilePath = "D:\\TML_EV\\V3_6.2.0\\EasyTestingForV3\\outputFiles\\File.xls";

	public static void main(String[] args) {	
		Path path = Paths.get(FilePath);
		  try {
				Files.deleteIfExists(path);
				System.out.println("File Delete Completed");
				System.out.println("Start the download now");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		startThread();
		
	}

	private static void startThread() {
		
		ScheduledExecutorService ses;
//		FileMonitor f = new FileMonitor();
		ses = Executors.newSingleThreadScheduledExecutor();
		
		ses.scheduleAtFixedRate(new FM(), 0, 5, TimeUnit.SECONDS);
		setThread(ses);
		
		
		}
	
	private static void setThread(ScheduledExecutorService ses) {
		thread=ses;
		
	}
	
	private static ScheduledExecutorService getThread() {
		return thread;
	}

	static class FM implements Runnable{

		@Override
		public void run() {
			System.out.println("Running now " + Instant.now() );
			Path path = Paths.get(FilePath);
			if (Files.exists(path)) {
				System.out.println("File Downloaded");
				  getThread().shutdown();
				  System.out.println("Got the file continue now");
				  continueProcess();
				  
				}
		}

		private void continueProcess() {
		
			
		}
		
	}
		
	}


