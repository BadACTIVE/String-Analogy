package tr.badactive.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

	public static int match(String word, String inword, int default_percentage) {
		int matched = 0;
		word = word.toLowerCase();
		inword = inword.toLowerCase();
		
		for(int i = 0; i < word.length(); i++) {
			if(matched < inword.length()) {
				if(word.charAt(i) == inword.charAt(matched)) {
					matched++;
				}
			}
		}
		return (default_percentage / word.length()) * matched;
	}
	
	public static String shorten(String str, String str2) {
		String temp = "";
		int tempi = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(tempi < str2.length()) {
				while(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str2.charAt(tempi)) ) {
					if(tempi + 1 < str2.length() && i - 1 > 0) {					
						if(Character.toLowerCase(str.charAt(i - 1)) == Character.toLowerCase(str2.charAt(tempi))) {
							i--;
							break;
						}
						else if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str2.charAt(tempi + 1))) {
							i = i - 2;
							break;
						}
					}
					i++;
				}
				temp += str.charAt(i);
				tempi++;
			} else break;
		}
        return temp;
    }

	public static void main(String[] args) {
		while(true) {
			System.out.print("Please enter word: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String word = "";
			try {
				word = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.print("Please enter inword: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			String inword = "";
			try {
				inword = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			double percentage = match(word, inword, 100);
			String get = shorten(word, inword);
			if(get != null) {
				System.out.println("The result can be '"+get+"' on percentage "+percentage+"%");
			} else {
				System.out.println("Couldnt matched!");
			}
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("--------------------------------------");
		}
	}
	
}
