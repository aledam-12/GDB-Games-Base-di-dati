package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.beans.VideogiocoBean;

public class VideogiocoDAO implements Videogioco{
	public synchronized VideogiocoBean leggiVideogioco(String titolo) throws SQLException {
		VideogiocoBean videogioco = new VideogiocoBean();
		Connection conn = null;
		PreparedStatement ps = null;
		String SQL = "SELECT * FROM videogioco WHERE titolo = ?";
		try { conn = connessionePool.getConnection();
		ps = conn.prepareStatement(SQL);
		ps.setString(1, titolo);
		ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				videogioco.setDescrizione(rs.getString("descrizione"));
				videogioco.setPegi(rs.getInt("pegi"));
				videogioco.setTitolo(titolo);
			}
		}
		finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				connessionePool.rilasciaConnessione(conn);
			}
		} 
		return videogioco;
	}
	public synchronized void inserisciVideogioco(VideogiocoBean videogioco) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String SQL = "INSERT INTO videogioco (pegi, descrizione, titolo) VALUES (?, ?, ?)";
		try {
			conn = connessionePool.getConnection();
			ps = conn.prepareStatement(SQL);
			ps.setInt (1, videogioco.getPegi());
			ps.setString(2,videogioco.getDescrizione());
			ps.setString(3,videogioco.getTitolo());
			ps.executeUpdate();
			conn.commit();
		}
		finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				connessionePool.rilasciaConnessione(conn);
			}
		} 
	}
}
