package it.polito.tdo.spellchecker.model;

import java.util.LinkedList;

public class Model {
	
	public String checkItalian (String text) {
		LinkedList <String> paroleSbagliate=new LinkedList <String>();
        String textDef=text.replaceAll ("[.,\\/#!?$%\\^&\\*;:{}=\\-_'~()\\[\\]\"]", "");
        String campi[]=textDef.split(" ");
        for (int i=0; i<campi.length; i++)
        {
             boolean presente=false;
             for (String s:Dictionaries.getItalian())
             {
            	 if (s.toLowerCase().equals(campi[i].toLowerCase()))
            		 presente=true;
             }
             if (presente==false)
            	 paroleSbagliate.add(campi[i]);
        }
        if (paroleSbagliate.size()==0)
        	return "Non ci sono errori";
        else
        {
        	String s="";
        	for (String ss:paroleSbagliate)
        	{
        		s+=ss+"\n";
        	}
        	return s;
        }
	}
	
	public String checkEnglish (String text) {
		LinkedList <String> paroleSbagliate=new LinkedList <String>();
        String textDef=text.replaceAll ("[.,\\/#?!$%\\^&\\*;:{}=\\-_'~()\\[\\]\"]", "");
        String campi[]=textDef.split(" ");
        for (int i=0; i<campi.length; i++)
        {
             boolean presente=false;
             for (String s:Dictionaries.getEnglish())
             {
            	 if (s.toLowerCase().equals(campi[i].toLowerCase()))
            		 presente=true;
             }
             if (presente==false)
            	 paroleSbagliate.add(campi[i]);
        }
        if (paroleSbagliate.size()==0)
        	return "Non ci sono errori";
        else
        {
        	String s="";
        	for (String ss:paroleSbagliate)
        	{
        		s+=ss+"\n";
        	}
        	return s;
        }
	}	
}
