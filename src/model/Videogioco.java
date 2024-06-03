package model;

import java.sql.SQLException;

import model.beans.VideogiocoBean;

public interface Videogioco {
	public VideogiocoBean leggiVideogioco(String titolo) throws SQLException;
}
