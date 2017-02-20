package ua.nure.rakova;


import java.util.Scanner;

public class CesarCipher {
	//only for Latin letters(ASCII)
	public static String encrypt(String message, int offset) {

		StringBuilder encryptedMessage = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			encryptedMessage.append((char) ((message.charAt(i)-32+offset)%94+32));
		}
		return encryptedMessage.toString();
	}
	
	
	
	public static String decrypt(String message, int offset) {

		StringBuilder decryptedMessage = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			decryptedMessage.append((char) ((message.charAt(i)-32-offset+94)%94+32));
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
			System.out.println("Enter offset(or print exit)");
			String scaned = scan.nextLine();
			if (scaned.equals("exit"))
				break;
			try {
				int offset = Integer.parseInt(scaned);
				String result = encrypt(message, offset);
			System.out.println("encrypted message : " + result);
			System.out.println("decrypted message : " + decrypt(result, offset));
			} catch (Exception e) {
				System.out.println("wrong arguments");
				continue;
			}
		}
	}
}
