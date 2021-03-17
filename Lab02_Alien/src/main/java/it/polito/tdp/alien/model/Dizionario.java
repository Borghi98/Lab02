package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class Dizionario {
	
	private List<ParolaMigliorata> dictionary;

	public Dizionario() {
		dictionary = new ArrayList<ParolaMigliorata>();
	}
	
	public void resetDictionary(){
		dictionary.clear();
	}
	
	public void addParola(String alien, String trans) {
		ParolaMigliorata w = new ParolaMigliorata(alien);
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		w.setTranslation(trans);
		dictionary.add(w);
	}

	public String translateWord(String alien) {
		ParolaMigliorata we = new ParolaMigliorata(alien);
		if (dictionary.contains(we))
			return dictionary.get(dictionary.indexOf(we)).getTranslation();
		return null;
	}

	public String translateWordWildCard(String alienWildCard) {

		// Utilizzo le regual expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere
		alienWildCard = alienWildCard.replaceAll("\\?", ".");

		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (ParolaMigliorata w : dictionary) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslation() + "\n");
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;
	}	
}
