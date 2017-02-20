package ua.nure.rakova;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FrequencyStatisticsCounter {
	

	public static Map<Character, Integer> countFrequencies(String rawText) {
		Map<Character, Integer> frequencyTable = new TreeMap<Character, Integer>();
		
		Integer length = rawText.length();
		for (int i = 0; i < length; i++) {
			char key = rawText.charAt(i);
			if (!frequencyTable.containsKey(key)) {
				frequencyTable.put(key, 1);
			} else {
				frequencyTable.put(key, frequencyTable.get(key) + 1);
			}
		}
		
		return frequencyTable;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter the name of text file");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		String fileName = "samples/"+name+".txt";
		StringBuilder sb = new StringBuilder();
		File file = new File(fileName);
		
		if (file.exists()) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				try {
					String s;
					while ((s = in.readLine()) != null) {
						sb.append(s);
						sb.append("\n");
					}
				} 
				finally {
					in.close();
					scan.close();
				}
			} 
			catch(IOException e) {
				throw new RuntimeException(e);
			}
		}

		String rawText = sb.toString();

		Map<Character,Integer> result = countFrequencies(rawText);

		System.out.println(result.toString());

	}
}
