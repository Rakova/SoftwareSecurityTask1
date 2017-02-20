package ua.nure.rakova;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Ñryptanalysis {
	
	//offset can be changed
	public static final int OFFSET = 5;

	public static void analyse(String rawFile){

		Map<Character, Integer> referenceStatistics = FrequencyStatisticsCounter.countFrequencies(rawFile);
		String encrypted = CesarCipher.encrypt(rawFile, OFFSET);
		Map<Character, Integer> testStatistics = FrequencyStatisticsCounter.countFrequencies(encrypted);
		HashSet<Character> mostFrequentChars = new HashSet<Character>();
		HashSet<Character> mostFrequentChars2 = new HashSet<Character>();

		// searching for the most frequent characters in reference text
		for (int i = 0; i < 10; i++) {
			Integer temp = (Collections.max(referenceStatistics.values()));
			for (Entry<Character, Integer> entry : referenceStatistics.entrySet()) {
				if (entry.getValue() == temp) {
					mostFrequentChars.add(entry.getKey());
				}
			}
			for (Character x : mostFrequentChars) {
				referenceStatistics.remove(x);
			}
		}

		// searching for the most frequent characters in encoded text
		for (int i = 0; i < 10; i++) {
			Integer temp = (Collections.max(testStatistics.values()));
			for (Entry<Character, Integer> entry : testStatistics.entrySet()) {
				if (entry.getValue() == temp) {
					mostFrequentChars2.add(entry.getKey());
				}
			}
			for (Character x : mostFrequentChars2) {
				testStatistics.remove(x);
			}
		}
		String result = CesarCipher.decrypt(encrypted, Collections.max(mostFrequentChars2)-Collections.max(mostFrequentChars));

		
		System.out.println("Raw file: "+rawFile);
		System.out.println("Decrypted file file: "+result.toString());
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the name of text file");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		String fileName = "samples/" + name + ".txt";
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
				} finally {
					in.close();
					scan.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		String rawText = sb.toString();

		analyse(rawText);


	}
	
}
