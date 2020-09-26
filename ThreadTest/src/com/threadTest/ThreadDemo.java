package com.threadTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadDemo {
	private static Queue<Integer> events_list  = new LinkedList<>();
	public static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(5);
	AtomicBoolean processThread = new AtomicBoolean(false);
	
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo td= new ThreadDemo();
	System.out.println("adding list to list begin");
		events_list.add(1);
		events_list.add(2);
		events_list.add(3);
		System.out.println("adding list to list end");
		System.out.println("starting thread");
		EXECUTOR_SERVICE.execute(td.new ThreadDemoInner());
		
	}
	class ThreadDemoInner implements Runnable{

		@Override
		public void run() {
//			System.out.println("inside thread");
//			if(events_list.size()==0) {
//				System.out.println("shutting down the thread");
			while(!events_list.isEmpty()) {
				System.out.println("polling thread");
				events_list.poll();
				System.out.println(events_list.size());
			}
			processThread.set(false);
			System.out.println("process thread value after shutting down " +  processThread);
			EXECUTOR_SERVICE.shutdown();
		}
		
	}

}
