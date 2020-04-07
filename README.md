# String Matching with percentage
The string matching algorithm and java codes.

	Example:
		You want to check if the word matches a="John" in b="Johnny".
		So what you need to do:<br>
			Set the values to lowercase.
			Get values length from b.(6)
			c = Check which letters match.(3)
			Calculate the percentage.( (100 / b) * c)
			
		Congratulations! You got the match percentage!

```
JAVA CODES:

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

How to use:
	int percentage = match("Johnny", "John", 100);
	System.out.println("The match percentage for 'John' in 'Johnny' is " + percentage);
	//The output is 75.
```

# String correction
The string correction codes. (Maybe i may add algorithm.)

	What does this code do ? Let me explain with example:
		Our string is "bbbllaaa   bbbbblllaaaa".
		The output is "bla bla".
		Cool right ?
		
```
NOTE: My friend helped(Him nickname is MegaCrafter.) while writing this code.
JAVA CODES:

public static String correct(String str) {
	String s = str + "\0";
	char temp = '\0';
	short count = 0;
	for (short i = 0; i < s.length(); i++) {
		char c = s.toCharArray()[i];
		if (temp == '\0') {
			temp = c;
			continue;
		}
		if (Character.toLowerCase(c) != Character.toLowerCase(temp)) {
			s = s.substring(0, count++) + temp + s.substring(i);
			i = count;
			temp = c;
			if (c == '\0') {
				s = s.replaceAll("\0", "");
				break;
			}
		}
	}
	return s;
}

How to use:
	String corrected = correct("HEEEYYY");
	System.out.println("Output: " + corrected);
	//The output is "HEY".
   
```

# Continuation of The String correction
The string correction codes. (Maybe i may add algorithm.)

	What does this code do ? Let me explain with example:
		Our string is "bbbllaaa".
		And we believe, it's should be "bla".
		We check it and if code turn null, cant be but turn any, it can be!
		Cool right ?
		
```
JAVA CODES:

public static String correct(String str, String str2) {
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

How to use:
	String corrected = correct("HEEEUUYYY", "hey");
	if(corrected != null) System.out.println("Output: " + corrected);
	else System.out.println("it couldnt fixed!");
	//The output is "hey".
   
```
# Some String variable get/set value codes.
```
JAVA CODES:

public static String getVariableValue(String like, String format, String variable) {
		if(format.length() <= like.length() || format.length() <= like.length() - variable.length()) {
			String end = "";
			String value = "";
			
			int headi = format.indexOf(variable);
			end = format.substring(headi + 3, format.length());
			value = like.substring(headi);
			value = value.substring(0, value.lastIndexOf(end));
			return value;
		} else return "Formats doesnt matched.";
	}

public static String setVariableValue(String like, String format, String variable, String set_value) {
		if(format.length() <= like.length() || format.length() <= like.length() - variable.length()) {
			String head = "";
			String end = "";
			String value = "";
			
			int headi = format.indexOf(variable);
			head = format.substring(0, format.indexOf(variable));
			end = format.substring(headi + 3, format.length());
			value = head + set_value + end;
			return value;
		} else return "Formats doesnt matched.";
	}
	
How to use:
	String variable_name = "%x%";
	String getted_value = getVariableValue("set time to day now", "set time to "+variable_name+" now", variable_name);
	System.out.println("Output: " + getted_value);
	//The output is "day".
	
	String setted_text = setVariableValue("set time to "+variable_name+" now", variable_name, "day");
	System.out.println("Output: " + setted_value);
	//The output is "set time to day now".
```
