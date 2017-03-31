package com.google.interview.questions.core.java;

/**
 * States :
 * New,Runnable,Running,Blocked/Waiting,
 * Dead
 * 
 * @author VijaySidhu
 *
 */
public class ThreadCreation {

	public static void main(String[] args) {
		ThreadWithRunnable t1 = new ThreadWithRunnable();
		ThreadWithRunnable t2 = new ThreadWithRunnable();

		Thread thread1 = new Thread(t1, "t1");
		Thread thread2 = new Thread(t2, "t2");
		Thread thread3 = new Thread(t2, "t2");
		// Starting runnable thread
		thread1.start();
		try {
			// Start second after 2 seconds or  only after this thread is done
			thread1.join(2000);
		} catch (InterruptedException e) {

		}
		thread2.start();
		try {
			// Start second after  this thread is done
			thread1.join();
		} catch (InterruptedException e) {
		}
		thread3.start();
		System.out.println(thread1.getName());
		System.out.println(thread2.getName());
	}
}

class ThreadWithRunnable implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
	}
}
