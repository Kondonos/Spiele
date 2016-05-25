package simpleParser;

import java.util.HashMap;

public class Regeln {
	public HashMap<String, String[][]>regel;
	
	public Regeln() {
		regel.put("s", new String[][]{{"np","vp"}});
		regel.put("np", new String[][]{{"det","n"}});
		regel.put("vp", new String[][]{{"v","np"}});
	}
}
