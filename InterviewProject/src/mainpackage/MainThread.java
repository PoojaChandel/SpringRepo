package mainpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

	public static void main(String[] args) {
		try {
			processThreads();
			System.gc();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	public static void processThreads() throws InterruptedException{
		UpdateDbThread run = new UpdateDbThread();
		Thread thread1 = new Thread(run);
		Thread t3 = new Thread(run);
		
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(thread1);
		
		ThreadGroup tg1 = new ThreadGroup("Group A");
		Thread thread2 = new Thread(tg1,run,"one");
		Thread thread3 = new Thread(tg1,run,"two");
		
		thread1.start();
		thread1.join();
		
		t3.setDaemon(true);
		t3.setName("Thread2 is daemon");
		t3.start();
		
		thread2.start();
		thread3.start();
		
		ExecutorService executor= Executors.newFixedThreadPool(3);
		for(int i=0;i<=8;i++){
			Runnable runthread = new UpdateDbThread();
				executor.execute(runthread);
			};
		}
		
}
