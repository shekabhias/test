package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountFrowneys {

	public static int countFrowneys(String[] arr){
		int min = 0;
		String regex = "[>((;|:|8){1})](\\')?(-|o|~)?(\\(|C|<|\\[|\\{|@)$";
		for(String s : arr){
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(s);
			if(m.find()) min++;
		}
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      System.out.println(countFrowneys(line.split("\\s")));
	    }
	}
}
