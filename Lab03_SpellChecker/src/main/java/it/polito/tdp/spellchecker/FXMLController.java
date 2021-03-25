package it.polito.tdp.spellchecker;

import java.util.LinkedList;

import it.polito.tdo.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model;
	long start,end;

    @FXML
    private ComboBox<String> boxLanguage;

    @FXML
    private TextArea txtParoleInserite;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Label txtNumeroErrori;
    
    @FXML
    private Label txtTime;

    @FXML
    void doClearAll(ActionEvent event) {
    	txtParoleInserite.setText("");
    	txtRisultato.setText("");
    	txtNumeroErrori.setText("");
    	txtTime.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	start=System.currentTimeMillis();
    	String lingua="";
    	String text=txtParoleInserite.getText();
    	try {
    		lingua=boxLanguage.getValue();
    	} catch (Exception e) {
    		txtRisultato.setText("Attenzione: non hai inserito la lingua");
    		return ;
    	}
    	if (text.equals(""))	
    	{
    		txtRisultato.setText("ERRORE: inserisci testo");
    		return ;
    	}
    	if (text.matches("[0-9]+"))
    	{
    		txtRisultato.setText("ERRORE: non sono ammessi caratteri numerici");
    		return ;
    	}
    	if (lingua.equals("Italian"))
    	{
    		String parole=model.checkItalian(text);
    		if (parole.equals("Non ci sono errori"))
    		{
    			txtNumeroErrori.setText("Numero errori: 0");
    			return ;
    		}
    		String campi[]=parole.split("\n");
    		txtRisultato.setText(parole);
    		txtNumeroErrori.setText("Numero errori: "+campi.length);
    	}
    	else
    	{
    		String parole=model.checkEnglish(text);
    		if (parole.equals("Non ci sono errori"))
    		{
    			txtNumeroErrori.setText("Numero errori: 0");
    			return ;
    		}
    		String campi[]=parole.split("\n");
    		txtRisultato.setText(parole);
    		txtNumeroErrori.setText("Numero errori: "+campi.length);
    	}
    	end=System.currentTimeMillis();
    	int tempoInt=(int) (end-start);
    	String tempoStr=String.valueOf(tempoInt);
    	txtTime.setText(tempoStr+" ms");
    }

	public void setModel(Model model) {
		String languages []= {"English","Italian"};
		boxLanguage.getItems().addAll(languages);
		this.model=model;
	}

}
