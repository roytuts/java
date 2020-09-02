package com.roytuts.java.callable.future;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<Job> {
	private Job job;

	public CustomCallable(Job job) {
		this.job = job;
	}

	@Override
	public Job call() throws Exception {
		try {
			System.out.println("inside call() => Job Id : " + job.getId());
			System.out.println("inside call() => Job Status : " + job.getStatus());
		} catch (Exception e) {
			throw new Exception("Runtime Exception", e);
		}
		return job;
	}

}
