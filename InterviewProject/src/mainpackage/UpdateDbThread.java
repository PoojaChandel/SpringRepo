package mainpackage;

public class UpdateDbThread implements Runnable {
	public UpdateDbThread() {
		// TODO Auto-generated constructor stub
	}
	
	StringBuffer s= new StringBuffer("hello");
	public void run(){
	System.out.println("_______________________");
		if(!Thread.currentThread().isDaemon()){
			System.out.println( "thread: "+ Thread.currentThread().getName());
			for(int i=0;i<=5;i++){
			
			if(!Thread.currentThread().getThreadGroup().getName().equalsIgnoreCase(null)){
				if(!Thread.currentThread().getThreadGroup().getName().equalsIgnoreCase("main") || i<=2){
					System.out.println(Thread.currentThread().getThreadGroup().getName() + i);
				}
			}else{
				System.out.println(i);
			}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
		}else{
			System.out.println( "Daemon thread: "+ Thread.currentThread().getName());
		}
	}
	
}
