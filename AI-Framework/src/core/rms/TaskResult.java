package core.rms;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskResult {
	
	public int id;
	public int hash;
	
	private Lnode parent;
	private Future<ArrayList<Object>> futuretask;

	public TaskResult(Lnode parent, Future<ArrayList<Object>> task, int id, int hash) {
		this.parent = parent;
		futuretask = task;
		this.id = id;
		this.hash = hash;
	}
	
	public Future<ArrayList<Object>> getFuturetask() {
		return futuretask;
	}
	
	public ArrayList<Object> getResult() {
		try {
			if(hash == 0) {
				return futuretask.get();
			} else {
				ArrayList<Object> group = new ArrayList<Object>();
				for(TaskResult i : parent.unfinishedResults) {
					if(i.hash == hash) group.add(i.getFuturetask().get());
				}
				return group;
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
