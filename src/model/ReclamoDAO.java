package model;
import model.beans.reclamoBean;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
public class ReclamoDAO
{
    public synchronized void inseriscireclamo(reclamoBean r) throws SQLException
        {
            Connection c = null;
            PreparedStatement PrepareStatement = null;
            String query = "INSERT INTO reclamo(dataReclamo, nReclamo, titolo, contenuto, emailCliente ) VALUE(?, ?, ?, ?, ?)";
            try{
                    c = connessionePool.getConnection();
                    PreparedStatement ps= c.prepareStatement(query);
                    ps.setDate(1, Date.valueOf(LocalDate.now()));
                    ps.setInt(2, r.getnReclamo());
                    ps.setString(3, r.getTitolo());
                    ps.setString(4, r.getContenuto());
                    ps.setString(5, r.getEmailCliente());
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

    public synchronized ArrayList<reclamoBean> leggiReclami (int num) throws SQLException
        {
		    String sql = "SELECT * FROM reclamo";
		    ArrayList <reclamoBean> r = new ArrayList <>();
		    Connection conn = null;
		    PreparedStatement ps = null;
		    try { 
                    conn = connessionePool.getConnection(); 
		            ps = conn.prepareStatement(sql); 
	            	ResultSet rs = ps.executeQuery();
		            while (rs.next()) 
                        {
			                reclamoBean reclamo = new reclamoBean();
			                reclamo.setdatareclamo(rs.getDate("dataReclamo").toLocalDate());
			                reclamo.setnReclamo(rs.getInt("nReclamo"));
			                reclamo.settitolo(rs.getString("titolo"));
			                reclamo.setcontenuto(rs.getString("contenuto"));
			                reclamo.setEmailCliente(rs.getString("emailCliente"));
			                r.add(reclamo);
		                }
		        }
		    finally {
			    try {
				    if (ps != null)
                        {
					        ps.close();
                        }
			        } finally {
				        connessionePool.rilasciaConnessione(conn);
			                  }
		            }
		    return r;
        }

    public synchronized boolean cancellareclamo(int n) throws SQLException
        {
            Connection c = null;
            PreparedStatement ps = null;
            int risultato = 0;
            String query ="DELETE FROM reclamo WHERE nReclamo = ? ";
                    c = connessionePool.getConnection();
                    ps = c.prepareStatement(query);
                    ps.setInt(1, n);
                    ps.executeUpdate();   
                    ps.close();
                    connessionePool.rilasciaConnessione(c);
                    return risultato != 0;
        }
}