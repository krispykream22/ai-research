package core.rms;

import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONObject;

public class Lcontroller {

	private ArrayList<Lnode> nodes;
	private ArrayList<Group> groups;
	private ArrayList<JSONObject> permisions;
	
	public Lcontroller() {
		nodes = new ArrayList<Lnode>();
		groups = new ArrayList<Group>();
		permisions = new ArrayList<JSONObject>();
	}
	
	/*
	 * Utilities
	 */
	
	/*
	 * Node interaction
	 */
	
	//NEEDS WORK
	public int newLnode(Lnodetype type, int threads) {
		int id = nodes.size();
		switch(type) {
		case cached:
			nodes.add(new Lnode(Lnodetype.cached, id, threads));
			break;
		case fixed:
			nodes.add(new Lnode(Lnodetype.fixed, id, threads)); 
		}
		return id;
	}
	
	/*
	 * Group interaction
	 */
	public boolean createGroup(String groupName) {
		for(Group i : groups) {
			if(i.groupName.equals(groupName)) {
				System.out.println("Group exists, use a different groupName");
				return false;
			}
		}
		int id = groups.size();
		groups.add(new Group(groupName, id));
		return true;
	}
	
	//NEEDS WORK
	public boolean addToGroup(int id, String groupName) {
		for(Group i : groups) {
			if(i.groupName.equals(groupName)) {
				Lnode temp = nodes.get(id);
				i.addNode(temp);
			}
		}
		return false;
	}
	
	//NEEDS WORK
	public boolean createPermission() {
		
		return false;
	}
	
	public void setPermission() {
		
	}
}
