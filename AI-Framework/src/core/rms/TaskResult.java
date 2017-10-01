package core.rms;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskResult {
	
	public int id;
	public UUID uuid;
	
	private Lnode parent;
	private Future<ArrayList<Object>> futuretask;

	public TaskResult(Lnode parent, Future<ArrayList<Object>> task, int id, UUID uuid) {
		this.parent = parent;
		this.id = id;
		this.uuid = uuid;
		futuretask = task;
	}
	
	public Future<ArrayList<Object>> getFuturetask() {
		return futuretask;
	}
	
	public ArrayList<Object> getResult() {
		try {
			if(uuid.equals(null)) {
				return futuretask.get();
			} else {
				ArrayList<Object> group = new ArrayList<Object>();
				for(TaskResult i : parent.unfinishedResults) {
					if(i.uuid.equals(uuid)) group.add(i.getFuturetask().get());
				}
				return group;
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
