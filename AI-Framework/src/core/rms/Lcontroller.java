package core.rms;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Lcontroller {

	private ArrayList<Lnode> nodes;
	private ArrayList<Group> groups;
	private ArrayList<JSONObject> permisions;
	private ArrayList<String> permision_types;
	
	public Lcontroller() {
		nodes = new ArrayList<Lnode>();
		groups = new ArrayList<Group>();
		permisions = new ArrayList<JSONObject>();
		permision_types = new ArrayList<String>();
	}
	
	//NEEDS WORK
	public int newLnode(Lnodetype type, int threads) {
		int id = nodes.size();
		switch(type) {
		case cached:
			nodes.add(new Lnode(Lnodetype.cached, id, threads));
			break;
		}
		return id;
	}
	
	public boolean createGroup(String groupName) {
		for(Group i : groups) {
			if(i.groupName.equals(groupName)) {
				System.out.println("Group exists, use a different groupName");
				return false;
			}
		}
		groups.add(new Group(groupName));
		return true;
	}
	
	//NEEDS WORK
	public boolean addToGroup(int id, String groupName) {
		for(Group i : groups) {
			if(i.groupName.equals(groupName)) {
				Lnode temp = nodes.get(id);
				
			}
		}
		return false;
	}
	
	public boolean createPermission() {
		
		return false;
	}
	
	public void setPermission() {
		
	}
}
