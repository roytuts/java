package com.roytuts.java.callable.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomFuture {

	public static void main(String[] args) {
		List<Future<Job>> futures = new ArrayList<Future<Job>>();

		ExecutorService taskExecutor = Executors.newFixedThreadPool(5);

		Job job1 = new Job();
		job1.setId("01");
		job1.setStatus("In Progress");
		Future<Job> future1 = taskExecutor.submit(new CustomCallable(job1));
		futures.add(future1);

		Future<Job> futureNull = taskExecutor.submit(new CustomCallable(null));
		futures.add(futureNull);

		Job job2 = new Job();
		job2.setId("02");
		job2.setStatus("Sending");
		Future<Job> future2 = taskExecutor.submit(new CustomCallable(job2));
		futures.add(future2);

		Job job3 = new Job();
		job3.setId("03");
		job3.setStatus("Sent");
		Future<Job> future3 = taskExecutor.submit(new CustomCallable(job3));
		futures.add(future3);

		Job job4 = new Job();
		job4.setId("04");
		job4.setStatus("Complete");
		Future<Job> future4 = taskExecutor.submit(new CustomCallable(job4));
		futures.add(future4);

		// After all tasks have started, now wait for all of them to complete (they run
		// in parallel)
		// and check if there were any exceptions
		for (Future<Job> future : futures) {
			try {
				System.out.println("returned : " + future.get().toString());
			} catch (ExecutionException e) {
				e.getCause().printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// shut down the executor service now
		taskExecutor.shutdown();
	}

}
