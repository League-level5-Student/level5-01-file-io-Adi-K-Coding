package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/test2.txt"));
			String finalOutput = " ";
			String line = br.readLine();
			String keyLine = br.readLine();
			int key1 = Integer.parseInt(keyLine);
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == ' ') {
					finalOutput = finalOutput + ' ';
				} else {
					if ((line.charAt(i) - key1) < 97) {
						int dif = (line.charAt(i) - key1) - 97;
						finalOutput = finalOutput + (char) (123 + dif);
					} else {
						finalOutput = finalOutput + (char) (line.charAt(i) - key1);
					}
				}
			}

			System.out.println(finalOutput);
			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);

			fw.write("\nDecrypted: " + finalOutput);

			fw.close();

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//Copyright © 2019 Adi Khandelwal