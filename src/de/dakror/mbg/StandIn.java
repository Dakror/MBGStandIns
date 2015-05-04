package de.dakror.mbg;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Maximilian Stark | Dakror
 */
public class StandIn {
	String[] courses;
	int[] lessons;
	boolean free;
	String replacer;
	String subject;
	String room;
	String text;
	
	JSONObject cache;
	
	public static StandIn create(JSONObject o) throws JSONException {
		StandIn s = new StandIn();
		
		s.cache = o;
		
		JSONArray c = o.getJSONArray("courses");
		s.courses = new String[c.length()];
		for (int i = 0; i < c.length(); i++)
			s.courses[i] = c.getString(i);
		
		JSONArray l = o.getJSONArray("lessons");
		s.lessons = new int[l.length()];
		for (int i = 0; i < l.length(); i++)
			s.lessons[i] = l.getInt(i);
		
		s.free = o.optBoolean("free");
		s.replacer = o.optString("replacer");
		s.subject = o.optString("subject");
		s.room = o.optString("room");
		s.text = o.optString("text");
		
		return s;
	}
	
	
}