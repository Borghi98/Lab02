package it.polito.tdp.alien.model;

public class Parola {
	
	private String parolaAliena;
	private String parolaTradotta;
	
	public Parola(String parolaAliena) {
		this.parolaAliena=parolaAliena;
	}

	public Parola(String parolaAliena, String parolaTradotta) {
		super();
		this.parolaAliena = parolaAliena;
		this.parolaTradotta = parolaTradotta;
	}

	public String getParolaAliena() {
		return parolaAliena;
	}

	public void setParolaAliena(String parolaAliena) {
		this.parolaAliena = parolaAliena;
	}

	public String getParolaTradotta() {
		return parolaTradotta;
	}

	public void setParolaTradotta(String parolaTradotta) {
		this.parolaTradotta = parolaTradotta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parolaAliena == null) ? 0 : parolaAliena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (parolaAliena == null) {
			if (other.parolaAliena != null)
				return false;
		} else if (!parolaAliena.equals(other.parolaAliena))
			return false;
		return true;
	}

	

}
