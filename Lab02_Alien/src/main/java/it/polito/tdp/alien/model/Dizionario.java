package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class Dizionario {
	
	private List<Parola> dizionario;
	
	public Dizionario() {
		dizionario = new ArrayList<Parola>();
	}
	
	public void resetDizionario() {
		dizionario.clear();
	}

	public void addParola(String alieno, String traduzione) {
		Parola p = new Parola(alieno,traduzione);
		if (dizionario.contains(p)) {
			dizionario.get(dizionario.indexOf(p)).setParolaTradotta(traduzione);
			return;
		}
		dizionario.add(p);
	}
	
	public String traduzioneParola(String alieno) {
		Parola p = new Parola(alieno);
		if (dizionario.contains(p)) {
			return dizionario.get(dizionario.indexOf(p)).getParolaTradotta();
		}
		return null;
	}
	
	
}
