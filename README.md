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
```

# String correction
