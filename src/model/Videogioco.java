package model;

import java.sql.SQLException;

import model.beans.videogiocoBean;

public interface Videogioco {
	public videogiocoBean leggiVideogioco(String titolo) throws SQLException;
}
