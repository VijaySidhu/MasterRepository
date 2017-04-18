package com.google.interview.questions.core.java;

/**
 * wait
 * 
 * 
 * Object wait methods has three
 * variance, one which waits
 * indefinitely for any other thread to
 * call notify or notifyAll method on
 * the object to wake up the current
 * thread. Other two variances puts the
 * current thread in wait for specific
 * amount of time before they wake up.
 * 
 * notify
 * 
 * notify method wakes up only one
 * thread waiting on the object and that
 * thread starts execution. So if there
 * are multiple threads waiting for an
 * object, this method will wake up only
 * one of them. The choice of the thread
 * to wake depends on the OS
 * implementation of thread management.
 * 
 * notifyAll
 * 
 * notifyAll method wakes up all the
 * threads waiting on the object,
 * although which one will process first
 * depends on the OS implementation.
 * 
 * @author VijaySidhu
 *
 */
public class WaitNotifyProducerConsumer {
	public static void main(String[] args) {
		Message msg = new Message("process it");
		Waiter waiter = new Waiter(msg);
		new Thread(waiter, "waiter").start();

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		System.out.println("All the threads are started");
	}
}

/**
 * A java bean class on which threads
 * will work and call wait and notify
 * methods.
 * 
 * @author VijaySidhu
 *
 */
class Message {

	String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

class Waiter implements Runnable {

	private Message message;

	public Waiter(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (message) {
			try {
				System.out.println(name + " waiting to get notified at time:" + System.currentTimeMillis());
				message.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " waiter thread got notified at time:" + System.currentTimeMillis());
			//process the message now
			System.out.println(name + " processed: " + message.getMessage());
		}
	}
}

class Notifier implements Runnable {

	private Message message;

	public Notifier(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			Thread.sleep(1000);
			synchronized (message) {
				message.setMessage(name + " Notifier work done");
				message.notify();
				// msg.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
