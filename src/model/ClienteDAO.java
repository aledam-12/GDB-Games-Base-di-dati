package model;
import model.beans.clienteBean;
import java.sql.*;

public class ClienteDAO implements Cliente
{
    public synchronized void inserisciCliente(clienteBean c) throws SQLException
        {
            Connection conn = null;
            PreparedStatement PrepareStatement = null;
            String query = "INSERT INTO cliente(email, nome, cognome, pw, via, civico, città, provincia, cap, stato) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try{
                    conn = connessionePool.getConnection();
                    PreparedStatement ps= conn.prepareStatement(query);
                    ps.setString(1, c.getEmail());
                    ps.setString(2, c.getNome());
                    ps.setString(3, c.getCognome());
                    ps.setString(4, c.getPw());
                    ps.setString(5, c.getVia());
                    ps.setInt(6, c.getCivico());
                    ps.setString(7, c.getCitta());
		            ps.setString(8, c.getProvincia());
                    ps.setInt(9, c.getCap());
		            ps.setString(10, c.getStato());
                    ps.executeUpdate();
                    conn.commit();
               } finally {
                            try {
                                    if (PrepareStatement != null)
                                        {
                                            PrepareStatement.close();
                                        }
                                } finally {
                                            connessionePool.rilasciaConnessione(conn);
                                          }
                         }
        }
    
    public synchronized clienteBean leggiCliente(String e) throws SQLException 
        {
		    clienteBean cliente = new clienteBean();
		    Connection conn = null;
		    PreparedStatement ps = null;
		    String SQL = "SELECT * FROM cliente WHERE email = ?";
		    try { 
                    conn = connessionePool.getConnection();
		            ps = conn.prepareStatement(SQL);
		            ps.setString(1, e);
		            ResultSet rs = ps.executeQuery();
			        if(rs.next()) 
                        {
			    cliente.setEmail(e);
			    cliente.setNome(rs.getString("nome"));
                            cliente.setCognome(rs.getString("cognome"));
                            cliente.setPw(rs.getString("pw"));
                            cliente.setVia(rs.getString("via"));
                            cliente.setCivico(rs.getInt("civico"));
                            cliente.setCitta(rs.getString("città"));
                            cliente.setProvincia(rs.getString("provincia"));
                            cliente.setCap(rs.getInt("cap"));
			    cliente.setStato(rs.getString("stato"));
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
		return cliente;
	    }

public synchronized void modifiCliente(String e, String pass) throws SQLException
        {
            Connection c = null;
	        PreparedStatement ps = null;
            String query = "UPDATE 'gdbgames'.'cliente' SET pw = ? WHERE email = ?";
            try{
                c = connessionePool.getConnection();
                ps = c.prepareStatement(query);
                ps.setString(1, pass);
                ps.setString(2, e);
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

    public synchronized void modifiCliente(String e, String v, int c) throws SQLException
        {
            Connection conn = null;
            PreparedStatement ps = null;
            String query = "UPDATE 'gdbgames'.'cliente' SET via = ?, civico = ? WHERE email = ?";
            try{
                conn = connessionePool.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, v);
                ps.setInt(2, c);
                ps.setString(3, e);
                }finally {
                            try {
                                    if (ps != null)
                                        {
                                            ps.close();
                                        }
                                } finally {
                                            connessionePool.rilasciaConnessione(conn);
                                          }
                         }
        }

    public synchronized void modifiCliente(String e, String c, String p, int cap) throws SQLException
        {
            Connection conn = null;
            PreparedStatement ps = null;
            String query = "UPDATE 'gdbgames'.'cliente' SET città = ?, provincia = ?, cap = ? WHERE email = ?";
            try{
                conn = connessionePool.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, c);
                ps.setString(2, p);
                ps.setInt(3, cap);
                ps.setString(4, e);
                }finally {
                            try {
                                    if (ps != null)
                                        {
                                            ps.close();
                                        }
                                } finally {
                                            connessionePool.rilasciaConnessione(conn);
                                          }
                         }
        }

public synchronized void modifiStato(String e, String stato) throws SQLException
        {
            Connection c = null;
	        PreparedStatement ps = null;
            String query = "UPDATE 'gdbgames'.'cliente' SET stato = ? WHERE email = ?";
            try{
                c = connessionePool.getConnection();
                ps = c.prepareStatement(query);
                ps.setString(1, stato);
                ps.setString(2, e);
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



    public synchronized boolean isRegistrato (clienteBean cliente) throws SQLException {
    	boolean status = false;
    	String SQL = "SELECT email FROM cliente WHERE email = ?";
    	Connection conn = null;
    	PreparedStatement ps = null;
    	try {
    		conn = connessionePool.getConnection();
    		ps = conn.prepareStatement(SQL);
    		ps.setString(1, cliente.getEmail());
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {
    		status = true;
    		} 
    		else status = false;
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
    	return status;
    }
}