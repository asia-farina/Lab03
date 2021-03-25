package it.polito.tdo.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Dictionaries {
	private static LinkedList <String> italian=new LinkedList <String>();
	private static LinkedList <String> english=new LinkedList <String>();
	public static LinkedList<String> getItalian () {
		try {
			FileReader fr=new FileReader ("src/main/resources/Italian.txt");
			BufferedReader br=new BufferedReader (fr);
			String riga;
			while ((riga=br.readLine())!=null)
			{
				italian.add(riga);
			}
			br.close();
			fr.close();
			return italian;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<String> getEnglish () {
		try {
			FileReader fr=new FileReader ("src/main/resources/English.txt");
			BufferedReader br=new BufferedReader (fr);
			String riga;
			while ((riga=br.readLine())!=null)
			{
				english.add(riga);
			}
			br.close();
			fr.close();
			return english;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
