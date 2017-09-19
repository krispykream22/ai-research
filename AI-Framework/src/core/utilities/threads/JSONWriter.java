package core.utilities.threads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.json.simple.JSONObject;

public class JSONWriter implements Callable<Boolean> {

	private int flag = 0;
	
	public JSONWriter(JSONObject obj, String dir) {
		try {
			FileWriter writer = new FileWriter(dir);
			writer.write(obj.toJSONString());
			writer.close();
			flag = 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean call() throws Exception {
		return true;
	}
}
