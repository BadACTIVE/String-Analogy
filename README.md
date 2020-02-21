# String Matching with percentage
The string matching algorithm and java codes.

	Example:
		You want to check if the word matches a="John" in b="J0hnny".
		So what you need to do:<br>
			Set the values to lowercase.
			Get values length from a.(4)
			c = Check which letters match.(3)
			Calculate the percentage.( (100 / a) * c)
			
		Congratulations! You got the match percentage!

```
JAVA CODES:

public static int match(String word, String inword, int default_percentage) {
	int matched = 0;
	word = word.toLowerCase();
	inword = inword.toLowerCase();
	for(int i = 0; i < word.length(); i++) {
		if(i < inword.length()) {
			if(word.charAt(i) == inword.charAt(i)) {
				matched++;
			}
		}
	}
	return (default_percentage / inword.length()) * matched;
}

How to use:
	int percentage = match("John", "J0hnny", 100);
	System.out.println("The match percentage for 'John' in 'J0hnny' is " + percentage);
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
```
