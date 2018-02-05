package task1005;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HappyScore {
	public static void main(String[] args) {
		HashMap<String, Double> anew = new HashMap<String, Double>();
		File f = new File("src/ANEW.txt");
		Scanner sc;
		try {
			sc = new Scanner(f,"UTF-8");
			while (sc.hasNext()) {
				anew.put(sc.next(), sc.nextDouble());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Encountered a problem when opening file 'ANEW.txt'");
			e.printStackTrace();
		}
		Set<String> fileSet = new TreeSet<String>();
		for(String file : args) {
			fileSet.add(file);
		}
		for(String file : fileSet) {
			int wordSum = 0;
			Double value = new Double(0);
			double sum = 0;
			File ff = new File("src/" +file);
			try {
				sc = new Scanner(ff,"UTF-8");
				while(sc.hasNext()) {
					value = anew.get(sc.next());
					if(value != null){
					sum  += value;
					wordSum ++;
					}
				}
				System.out.println("Happiness Index for '" + file + "': " + String.format("%.6f", sum/wordSum));
			} catch (FileNotFoundException e) {
				System.out.println("Encountered a problem when opening file '"+ file +"'");
				e.printStackTrace();
			}	
			
		}
	}
}
