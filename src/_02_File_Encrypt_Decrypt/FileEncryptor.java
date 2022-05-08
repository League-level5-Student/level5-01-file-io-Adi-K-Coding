package _02_File_Encrypt_Decrypt;

import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {

		String userInput = JOptionPane.showInputDialog("Enter a message");
		String numInput = JOptionPane.showInputDialog("Enter your key to encrypt the message");
		String toLower = userInput.toLowerCase();
		String finalInput = "";
		int key = Integer.parseInt(numInput);
		if (key > 26) {
			key = key - 26;
		}
		for (int i = 0; i < userInput.length(); i++) {
			if (toLower.charAt(i) == ' ') {
				finalInput = finalInput + ' ';
			} else {
				if ((toLower.charAt(i) + key) > 122) {
					int dif = (toLower.charAt(i) + key) - 122;
					finalInput = finalInput + (char) (96 + dif);
				} else {
					finalInput = finalInput + (char) (toLower.charAt(i) + key);
				}
			}
		}
		System.out.println(finalInput);
		try {
			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");

			fw.write(finalInput + "\n" + key);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//Copyright © 2019 Adi Khandelwal