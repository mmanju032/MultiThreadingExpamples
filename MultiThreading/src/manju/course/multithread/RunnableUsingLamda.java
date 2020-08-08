package manju.course.multithread;

public class RunnableUsingLamda {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("In main method: ");
		Long startTime = System.currentTimeMillis();


//Advanced way2 without creating class , by use of Anonymous inner class	
// using Java 7		
		Thread t1 = new Thread (new Runnable(){
			@Override
			public void run() {
				for ( int k=0; k<10; k++){
					
					System.out.println("Printed items from task k is:"+ k);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}			
			}		
		});
		
		t1.start();
		
		Thread t2 = new Thread (()-> {
				for ( int k=0; k<10; k++){
					
					System.out.println("Printed items from task l is:"+ k);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}			
			});
		
		t2.start();
		
		Long endTime = System.currentTimeMillis();
		System.out.println("Main method processing time: "+ (endTime-startTime));
	}
}

