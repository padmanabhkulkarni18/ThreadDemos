package thread.Join.examples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JoinDemo1 {
	
	static ScheduledExecutorService ses;
		
	
	public static void main(String args[]) throws InterruptedException {
		
	ThreadJoin threadJoin1 = new ThreadJoin("First Thread");
	ThreadJoin threadJoin2 = new ThreadJoin("Second Thread");
	ThreadJoin threadJoin3 = new ThreadJoin("Third Thread");
	Thread thread1 = new Thread(threadJoin1, "First thread with Join");
	Thread thread2 = new Thread(threadJoin2, "Second thread");
	Thread thread3 = new Thread(threadJoin3, "Third thread");
//	thread1.run();
		
//	thread1.join();
	
//	thread2.run();
//	thread3.run();
//	
	ses = Executors.newSingleThreadScheduledExecutor();
	ses.scheduleAtFixedRate(new ThreadJoin("new instance"), 0, 1, TimeUnit.SECONDS);
	
	}

}

class ThreadJoin implements Runnable {
	String threadName;
	
	public ThreadJoin(String threadName) {
		this.threadName= threadName;
		
	}
	
	@Override
	public void run() {
	
		for(int i=1;i<=3 ;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread is : "+ threadName);
			System.out.println("Value of i is :" + i);
		}
		
	}
	
	
}