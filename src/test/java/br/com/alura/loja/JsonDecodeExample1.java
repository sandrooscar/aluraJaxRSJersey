package br.com.alura.loja;

import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDecodeExample1 {

	public static void main(String[] args) throws ParseException {
		String s = "[{\"name\":\"Alex\",\"marks\":648.50,\"roll\":12},"
				+ "{\"name\":\"bernardo\",\"marks\":648.50,\"roll\":12},"
				+ "{\"name\":\"xixi\",\"marks\":648.50,\"roll\":12}]";
//		  Object o1 = JSONValue.parse(s);
//		  JSONObject jsonObj = (JSONObject) o1;
//		  String name = (String) jsonObj.get("name");
//		  double marks = (Double) jsonObj.get("marks");
//		  Integer roll = (Integer) jsonObj.get("roll");
//		  System.out.println(name + " " + marks + " " + roll);

		final JSONParser parser = new JSONParser();
		final JSONArray parsedArray = (JSONArray) parser.parse(s);
		System.out.println(parsedArray.size());
		for (Object object : parsedArray) {
			System.out.println(((JSONObject) object).get("name"));
		}
	}

}
