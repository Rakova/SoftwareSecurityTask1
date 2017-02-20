package ua.nure.rakova;

import java.security.SecureRandom;
import java.util.Scanner;


public class VerrnamCipher {

	public static String[] encrypt(String message) {
		String[] result = new String[message.length()];
		SecureRandom r = new SecureRandom();
		// key creation
		StringBuilder key = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			key.append((char) (r.nextInt() % 57 + 65));
		}
		// encryption
		StringBuilder encryptedMessage = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			encryptedMessage.append((char) (message.charAt(i)^key.charAt(i)));
		}
		result[0] = encryptedMessage.toString();
		result[1] = key.toString();
		return result;
	}

	public static String decrypt(String message, String key) {
		StringBuilder decryptedMessage = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			decryptedMessage.append((char) (message.charAt(i)^key.charAt(i)));
		}
		return decryptedMessage.toString();
	}
	public static void main(String[] args){
		while (true) {
			System.out.println("Enter message to encrypt(or print exit)");
			Scanner scan = new Scanner(System.in);
			String message = scan.nextLine();
			if (message.equals("exit"))
				break;
			try{
			String[] result = encrypt(message);
			System.out.println("encrypted message : " + result[0] + " key : " + result[1]);
			System.out.println("decrypted message : " + decrypt(result[0], result[1]));
			} catch (Exception e) {
				System.out.println("wrong arguments");
				continue;
			}
		}
	}
}
