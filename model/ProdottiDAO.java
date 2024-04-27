package modello;
import beans.*;
import java.util.*;
import java.sql.*;

public class ProdottiDAO implements Prodotti
{	
	public synchronized int getQuantità (copiaBean copia) throws SQLException{
		String sql = "SELECT count(*) as quantità, nomeConsole, titoloVideogioco FROM copia WHERE stato = 0 "
				+ "AND titoloVideogioco = ?"
				+ "AND nomeConsole = ?"
				+ "GROUP BY nomeConsole,titoloVideogioco";
		Connection conn = null;
		PreparedStatement ps = null;
		int quantità = 0;
		try {
			conn = connessionePool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, copia.getNomeConsole());
			ps.setString(2, copia.getTitoloVideogioco());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				quantità = rs.getInt("quantità");
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
		return quantità;
	}
    public synchronized void inserisciProd(videogiocoBean v) throws SQLException
        {
            Connection c = null;
            PreparedStatement PrepareStatement = null;
            String query = "INSERT INTO videogioco(titolo, descrizione, pegi) VALUE(?, ?, ?)";
            try{
                    c = connessionePool.getConnection();
                    PreparedStatement ps= c.prepareStatement(query);
                    ps.setString(1, v.getTitolo());
                    ps.setString(2, v.getDescrizione());
                    ps.setInt(3, v.getPegi());
                    ps.executeUpdate();
                    c.commit();
               } finally {
                            try {
                                    if (PrepareStatement != null)
                                        {
                                            PrepareStatement.close();
                                        }
                                } finally {
                                            connessionePool.rilasciaConnessione(c);
                                          }
                         }
        }



     
    public synchronized void inscopia(copiaBean copia) throws SQLException
        {
            Connection c = null;
            PreparedStatement ps = null;
            String query = "INSERT INTO copia(stato, partitaiva, prezzo, codiceCopia, codiceAcquisto, titoloVideogioco, nomeConsole) VALUE(?, ?, ?, ?, ?, ?, ?)";
                    c = connessionePool.getConnection();
                    ps= c.prepareStatement(query);
                    ps.setBoolean(1, copia.getStato());
                    ps.setFloat(2, copia.getPercIva());
                    ps.setFloat(3, copia.getPrezzo());
                    ps.setInt(4, copia.getCodiceCopia());
                    ps.setInt(5, copia.getCodiceAcquisto());
                    ps.setString(6, copia.getTitoloVideogioco());
                    ps.setString(7, copia.getNomeConsole());
                    ps.executeUpdate();
                    ps.close();
                    
        }
     
    public  synchronized boolean cancellaprod(String titolo) throws SQLException
        {
            Connection c = null;
            PreparedStatement ps = null;
            int risultato = 0;
            String query ="DELETE FROM videogioco WHERE titolo = ? ";
                    c = connessionePool.getConnection();
                    ps = c.prepareStatement(query);
                    ps.setString(1, titolo);
                    ps.executeUpdate();   
                    ps.close();
                    connessionePool.rilasciaConnessione(c);
                    return risultato != 0;
            }



     
    public  synchronized boolean cancellacopia(String titolovideogioco) throws SQLException
        {
                    Connection c = null;
                    PreparedStatement ps = null;
                    int risultato = 0;
                    String query ="DELETE FROM copia WHERE stato = 0 && titolovideogioco = ? ";
                            c = connessionePool.getConnection();
                            ps = c.prepareStatement(query);
                            ps.setString(1, titolovideogioco);
                            risultato = ps.executeUpdate();      
                            ps.close();
                            connessionePool.rilasciaConnessione(c);
                            return risultato != 0;
        }
    


    
     
    public synchronized copiaBean trovaprod(String videogioco) throws SQLException
        {
            Connection c = null;
            PreparedStatement ps = null;
            copiaBean copia = new copiaBean();
            String query = "SELECT * FROM copia WHERE stato = 0 && titolovideogioco = ?";
                    c = connessionePool.getConnection();
                    ps = c.prepareStatement(query);
                    ps.setString(1, videogioco);
                    ResultSet risultato = ps.executeQuery();
                    while(risultato.next())
                        {
                            copia.setStato(risultato.getBoolean("stato"));
                            copia.setPercIva(risultato.getFloat("perciva"));
                            copia.setPrezzo(risultato.getFloat("prezzo"));
                            copia.setCodiceCopia(risultato.getInt("codiceCopia"));
                            copia.setCodiceAcquisto(risultato.getInt("codiceAcquisto"));
                            copia.setTitoloVideogioco(risultato.getString("titoloVideogioco"));
                            copia.setNomeConsole(risultato.getString("nomeConsole"));
                        }

                        ps.close();
                        connessionePool.rilasciaConnessione(c);
            return copia;       
        }



     
public synchronized ArrayList<copiaBean> leggiTutteCopie (String sort) throws SQLException{
		String sql = "SELECT * FROM copia WHERE stato = 0";
		ArrayList <copiaBean> copie = new ArrayList <>();
		Connection conn = null;
		PreparedStatement ps = null;
		if (sort != null && !sort.equals("")) {
			sql += " ORDER BY " + sort;
		}	
		try { conn = connessionePool.getConnection(); 
		ps = conn.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			copiaBean copia = new copiaBean();
			copia.setCodiceCopia(rs.getInt("codiceCopia"));
			copia.setTitoloVideogioco(rs.getString("titoloVideogioco"));
			copia.setPercIva(rs.getFloat("percIva"));
			copia.setPrezzo(rs.getFloat("prezzo"));
			copia.setNomeConsole(rs.getNString("nomeConsole"));
			copie.add(copia);
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
		return copie;
}


     
    public synchronized void modificaprod(String m, int p) throws SQLException
        {
            Connection c = null;
		    PreparedStatement ps = null;
            String query = "UPDATE 'gdbgames'.'videogioco' SET pegi = ? WHERE titolo = ?";
            try{
                c = connessionePool.getConnection();
                ps = c.prepareStatement(query);
                ps.setInt(1, p);
                ps.setString(2, m);
                }finally {
			                try {
				                if (ps != null)
                                    {
					                    ps.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
    public synchronized void modificaProd(String m, String d) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'videogioco' SET descrizione = ? WHERE titolo = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setString(1, d);
                preparedStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
     
    public synchronized void modificaprod(String m, String d, int p) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'videogioco' SET pegi = ?, descrizione = ? WHERE titolo = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setInt(1, p);
                preparedStatement.setString(2, d);
                preparedStatement.setString(3, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }



     
    public synchronized void modificacopia(String m, int s) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ? WHERE titoloVideogioco = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setInt(1, s);
                preparedStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
     
    public synchronized void modificaCopia(String m, Float iva) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET percIva = ? WHERE titoloVideogioco = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setFloat(1, iva);
                preparedStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
     
    public synchronized void modificaCopia(String m, float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setFloat(1, pre);
                preparedStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                       connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
     
    public synchronized void modificacopia(String m, int s, float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement ps = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ?, prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = connessionePool.getConnection();
                ps = c.prepareStatement(query);
                ps.setInt(1, s);
                ps.setFloat(2, pre);
                ps.setString(3, m);
                }finally {
			                try {
				                if (ps != null)
                                    {
					                    ps.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
     
    public synchronized void modificacopia(String m, float iva, float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET percIva = ?, prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setFloat(1, iva);
                preparedStatement.setFloat(2, pre);
                preparedStatement.setString(3, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }
     
    public synchronized void modificaCopia(String m, int s, Float iva, Float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ?, percIva = ?, prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = connessionePool.getConnection();
                preparedStatement = c.prepareStatement(query);
                preparedStatement.setInt(1, s);
                preparedStatement.setFloat(2, iva);
                preparedStatement.setFloat(3, pre);
                preparedStatement.setString(4, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        connessionePool.rilasciaConnessione(c);
			                              }
		                  }

        }




	@Override
	public void modificaprod(String m, String d) throws SQLException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void modificaCopia(String m, int s) throws SQLException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void modificaCopia(String m, int s, Float iva) throws SQLException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void modificaCopia(String m, Float iva, Float pre) throws SQLException {
		// TODO Auto-generated method stub
		
	}
    }
