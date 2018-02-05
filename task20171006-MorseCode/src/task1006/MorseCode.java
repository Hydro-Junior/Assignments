package task1006;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class MorseCode {
	public static void main(String[] args) {
		HashMap<String, Character> morseTable = new HashMap<String,Character>();
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		//read the morse table into the HashMap
		File f = new File("src/morse.txt");
		Scanner sc;
		try {
			sc = new Scanner(f,"UTF-8");
			while (sc.hasNext()) {		
				Character value = sc.next().charAt(0);
				String key = sc.next();
				morseTable.put(key,value);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Encountered a problem when opening file 'morse.txt'");
			e.printStackTrace();
		}
		for(String s : args) {
			File ff = new File("src/" + s);
			String testCode = new String();
			try {
				try {
					InputStreamReader reader = new InputStreamReader(new FileInputStream(ff), "UTF-8");
					char[] res = new char[(int) ff.length()];
					try {
						reader.read(res);
						testCode = String.valueOf(res);
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					String[] words = testCode.split("  ");
					for(int i = 0 ; i< words.length;i++) {
						StringBuilder sbd = new StringBuilder();
						String[] letters = words[i].split(" ");
						for(int j = 0 ; j < letters.length; j++) {
							sbd.append(morseTable.get(letters[j].trim()));
						}
						String theWord = sbd.toString();
						if(result.containsKey(theWord)) {
							int value = result.get(theWord);
							value ++;
							result.put(theWord, value);
						}else {
							result.put(theWord, 1);
						}
					}
					Iterator<Entry<String, Integer>> iterator = result.entrySet().iterator();
					System.out.print("{");
					while(iterator.hasNext()) {
						Entry<String, Integer> entry = (Entry<String, Integer>)iterator.next();
						System.out.print(entry.getKey() + "=" + entry.getValue());
						if(iterator.hasNext()) {
							System.out.print(", ");
						}else {
							System.out.print("}");
						}
					}
					
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("Encountered a problem when opening file '"+ s +"'");
				e.printStackTrace();
			}	
		}
		
		
	}
}
