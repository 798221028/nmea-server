package dataguru.java.server.nmea.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPool {
	private static final int MAX_THREAD_NUM = 5;
	private Executor executor = null;
	
	private ThreadPool(){
		executor = Executors.newFixedThreadPool(MAX_THREAD_NUM);
	}
	
	public void executeTask(Runnable task){
		executor.execute(task);
	}
	
	public static ThreadPool get(){
		return ThreadPoolHolder.instance;
	}
	
	private static class ThreadPoolHolder{
		private static final ThreadPool instance = new ThreadPool();
	}

}
