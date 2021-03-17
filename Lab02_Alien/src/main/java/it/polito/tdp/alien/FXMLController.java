package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario dizionario = new Dizionario();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtTesto.clear();
    	txtResult.clear();
    	dizionario.resetDizionario();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	String riga = txtTesto.getText().toLowerCase();
    	
    	//controlli input
    	
    	if(riga == null || riga.length()==0) {
    		txtResult.setText("inserire una o due parole");
    		return;
    	}
    	
    	StringTokenizer st = new StringTokenizer(riga," ");
    	String parolaAliena = st.nextToken();
    	
    	if (st.hasMoreElements()) {
    		String traduzione = st.nextToken();
    		 
    		if(!parolaAliena.matches("[a-zA-Z]*") || !traduzione.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		dizionario.addParola(parolaAliena, traduzione);
    		txtResult.setText("la parola: " + parolaAliena + " con traduzione " + traduzione + " inserita nel dizionario.");
    	}
    	else {
    		if(!parolaAliena.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		String traduzione = dizionario.traduzioneParola(parolaAliena);
    		if (traduzione != null) {
    			txtResult.setText(traduzione);
    		}
    		else {
    			txtResult.setText("la parola cercata non esiste nel dizionario");
    		}
    	}
    	txtTesto.clear();

    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
