package core.rms;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Logical nodes manage tasks among threads, storing results in the format of a TaskResult class

public class Lnode {
	
	public ArrayList<TaskResult> unfinishedResults;
	
	private ExecutorService executor;
	private int id;
	
	public Lnode(Lnodetype type, int id, int threads) {

		unfinishedResults = new ArrayList<TaskResult>();
		this.id = id;
		
		switch(type) {
		case cached: executor = Executors.newCachedThreadPool();
			break;
		case fixed: executor = Executors.newFixedThreadPool(threads);
		}
	}
	
	/*
	 * Task functionality
	 */
	
	public int submitTask(Callable<ArrayList<Object>> task, int hash) {
		int id = unfinishedResults.size();
		unfinishedResults.add(new TaskResult(this, executor.submit(task), id, hash));
		return unfinishedResults.size();
	}
	
	public void submitTask(Thread task, int hash) {
		
	}
	
	public ArrayList<Object> getResults(int id) {
		ArrayList<Object> temp = unfinishedResults.get(id).getResult();
		removeTask(id);
		return temp;
	}
	
	public void removeTask(int id) {
		unfinishedResults.remove(id);
	}
	
	public void changeID(int id) {
		this.id = id;
	}
}
