package: model;
import model.beans.videogiocobean.java;
import model.beans.copiabean.java;
import java.util.Collection;
import java.util.LinkedList;;
import java.sql.*;

public class implementazioni implements Prodotti
{
    @Override
    public synchronized void inserisciprod(videogiocobean v) throws SQLException
        {
            Connection c = null;
            PrepareStatement PrepareStatement = null;
            String query = "INSERT INTO videogioco(titolo, descrizione, pegi)
                            VALUE(?, ?, ?)";
            try{
                    c = DriverMenagerConecctionPool.getConnection();
                    PrepareStatement = c.PrepareStatement(query);
                    PrepareStatement.setString(1, v.gettitolo());
                    PrepareStatement.setString(2, v.getdescrizione());
                    PrepareStatement.setInt(3, v.getpegi());
                    PrepareStatement.executeUpdate();
                    c.commit();
               } finally {
                            try {
                                    if (PrepareStatement != null)
                                        {
                                            PrepareStatement.close();
                                        }
                                } finally {
                                            DriverManagerConnectionPool.releaseConnection(c);
                                          }
                         }
        }



    @Override
    public synchronized void inscopia(copiacobean copia) throws SQLException
        {
            Connection c = null;
            PrepareStatement PrepareStatement = null;
            String query = "INSERT INTO copia(stato, partitaiva, prezzo, codiceCopia, codiceAcquisto, titoloVideogioco, nomeConsole)
                            VALUE(?, ?, ?, ?, ?, ?, ?)";
            try{
                    c = DriverMenagerConecctionPool.getConnection();
                    PrepareStatement = c.PrepareStatement(query);
                    PrepareStatement.setBoolean(1, copia.getstato());
                    PrepareStatement.setFloat(2, copia.getpartitaiva());
                    PrepareStatement.setFloat(3, copia.getprezzo());
                    PrepareStatement.setInt(4, copia.getcodiceCopia());
                    PrepareStatement.setInt(5, copia.getcodiceAcquisto());
                    PrepareStatement.setString(6, copia.gettitolovideogioco());
                    PrepareStatement.setString(7, copia.getnomeconsole());
                    PrepareStatement.executeUpdate();
                    c.commit();
               } finally {
                            try {
                                    if (PrepareStatement != null)
                                        {
                                            PrepareStatement.close();
                                        }
                                } finally {
                                            DriverManagerConnectionPool.releaseConnection(c);
                                          }
                         }
        }

    

    @Override
    public  synchronized boolean cancellaprod(String titolo) throws SQLException
        {
            Connection c = null;
            PrepareStatement PrepareStatement = null;
            int resultato = 0;
            String query ="DELETE FROM videogioco WHERE titolo = ? ";
            try{
                    c = DriverMenagerConecctionPool.getConnection();
                    PrepareStatement = c.PrepareStatement(query);
                    PrepareStatement.setString(1, titolo);
                    risultato = PrepareStatement.executeUpdate();   
               } finally{
                            try {
                                    if (PrepareStatement != null)
                                        {
                                            PrepareStatement.close();
                                        }
                                } finally {
                                            DriverManagerConnectionPool.releaseConnection(c);
                                          }
                        }
            return (risultato != 0);
        }



    @Override
    public  synchronized boolean cancellacopia(String titolovideogioco) throws SQLException
        {
                    Connection c = null;
                    PrepareStatement PrepareStatement = null;
                    int resultato = 0;
                    String query ="DELETE FROM copia WHERE stato = 0 && titolovideogioco = ? ";
                    try{
                            c = DriverMenagerConecctionPool.getConnection();
                            PrepareStatement = c.PrepareStatement(query);
                            PrepareStatement.setString(1, titolovideogioco);
                            risultato = PrepareStatement.executeUpdate();   
                        } finally{
                                    try {
                                            if (PrepareStatement != null)
                                                {       
                                                    PrepareStatement.close();
                                                }
                                        } finally {
                                                    DriverManagerConnectionPool.releaseConnection(c);
                                                  }
                                 }
            return (risultato != 0);
        }
    


    
    @Override
    public synchronized copiabean trovaprod(String videogioco) throws SQLException;
        {
            Connection c = null;
            PrepareStatement PrepareStatement = null;
            copiabean copia = new copiabean();
            String query = "SELECT * FROM copia WHERE stato = 0 && titolovideogioco = ?";
            try{
                    c = DriverManagerConnectionPool.getConnection();
                    PrepareStatement = c.PrepareStatement(query);
                    PrepareStatement.setString(1, videogioco);
                    ResultSet risultato = PrepareStatement.executeQuery();
                    while(risultato.next())
                        {
                            copia.setstato(risultato.getInt("stato"));
                            copia.setpartitaiva(risultato.getFloat("perciva"));
                            copia.setprezzo(risultato.getFloat("prezzo"));
                            copia.setcodiceCopia(risultato.getInt("codiceCopia"));
                            copia.setcodiceAcquisto(risultato.getInt("codiceAcquisto"));
                            copia.settitolovideogioco(risultato.getString("titoloVideogioco"));
                            copia.setnomeconsole(risultato.getString("nomeConsole"));
                        }
               } finally{
                            try {
                                    if (PrepareStatement != null)
                                        {       
                                            PrepareStatement.close();
                                        }
                                } finally {
                                            DriverManagerConnectionPool.releaseConnection(c);
                                          }
                        }   
            return copia;       
        }



    @Override
    public synchronized Collection<ProductBean> seltutti(String ordine) throws SQLException 
        {
		    Connection c = null;
		    PreparedStatement preparedStatement = null;
		    Collection<copiabean> copia = new LinkedList<copiabean>();
		    String query = "SELECT * FROM copia WHERE stato = 0";
		    if (ordine != null && !ordine.equals("")) 
                {
			        query += " ORDER BY " + ordine;
		        }
		    try {
			    c = DriverManagerConnectionPool.getConnection();
			    preparedStatement = c.prepareStatement(query);
			    ResultSet risultato = preparedStatement.executeQuery();
			    while (risultato.next()) 
                    {
				        copiabean co = new copiabean();
                        co.setstato(risultato.getInt("stato"));
                        co.setpartitaiva(risultato.getFloat("perciva"));
                        co.setprezzo(risultato.getFloat("prezzo"));
                        co.setcodiceCopia(risultato.getInt("codiceCopia"));
                        co.setcodiceAcquisto(risultato.getInt("codiceAcquisto"));
                        co.settitolovideogioco(risultato.getString("titoloVideogioco"));
                        co.setnomeconsole(risultato.getString("nomeConsole"));
				        copia.add(co);
			        }
                } finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }
		return copia;
	    }



    @Override
    public synchronized void modificaprod(String m, Int p) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'videogioco' SET pegi = ? WHERE titolo = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setInt(1, p);
                PrepareStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificaprod(String m, String d) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'videogioco' SET descrizione = ? WHERE titolo = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setString(1, d);
                PrepareStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificaprod(String m, String d, Int p) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'videogioco' SET pegi = ?, descrizione = ? WHERE titolo = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setInt(1, p);
                PrepareStatement.setString(2, d);
                PrepareStatement.setString(3, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }



    @Override
    public synchronized void modificacopia(String m, Int s) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setInt(1, s);
                PrepareStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificacopia(String m, Float iva) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET percIva = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setFloat(1, iva);
                PrepareStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificacopia(String m, Float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setFloat(1, pre);
                PrepareStatement.setString(2, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificacopia(String m, Int s, Float iva) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ?, percIva = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setInt(1, s);
                PrepareStatement.setFloat(2, iva);
                PrepareStatement.setString(3, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificacopia(String m, Int s, Float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ?, prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setInt(1, s);
                PrepareStatement.setFloat(2, pre);
                PrepareStatement.setString(3, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificacopia(String m, Float iva, Float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET percIva = ?, prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setFloat(1, iva);
                PrepareStatement.setFloat(2, pre);
                PrepareStatement.setString(3, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
    @Override
    public synchronized void modificacopia(String m, Int s, Float iva, Float pre) throws SQLException
        {
            Connection c = null;
		    PreparedStatement preparedStatement = null;
            String query = "UPDATE 'gdbgames'.'copia' SET stato = ?, percIva = ?, prezzo = ? WHERE titoloVideogioco = ?";
            try{
                c = DriverMenagerConecctionPool.getConnection();
                PrepareStatement = c.PrepareStatement(query);
                PrepareStatement.setInt(1, s);
                PrepareStatement.setFloat(2, iva);
                PrepareStatement.setFloat(3, pre);
                PrepareStatement.setString(4, m);
                }finally {
			                try {
				                if (preparedStatement != null)
                                    {
					                    preparedStatement.close();
                                    }
			                    } finally {
				                        DriverManagerConnectionPool.releaseConnection(c);
			                              }
		                  }

        }
}