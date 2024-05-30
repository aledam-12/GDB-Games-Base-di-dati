package model;


import model.beans.acquistoBean;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
	
    public class AcquistoDAO {
        private static final String TABLE_NAME = "acquisto";
        private static final List<String> ORDERS = new ArrayList<>(Arrays.asList("username", "dataOrdine")); 
        
        public synchronized ArrayList<acquistoBean> cercaOrdini (LocalDate inizio, LocalDate fine, String email) throws SQLException {
        	String SQL = "SELECT * FROM acquisto WHERE dataAcquisto <= ? AND dataAcquisto >= ? ";
        	if (email != null && !email.contentEquals("")) SQL += "AND emailCliente = ?";
        	Connection connection = null;
        	PreparedStatement ps = null;
        	ArrayList <acquistoBean> acquisti = new ArrayList <>();
        	try {
        		connection = connessionePool.getConnection();
        		ps = connection.prepareStatement(SQL);
        		ps.setString(1, fine.toString());
        		ps.setString(2, inizio.toString());
        		if(email != null && !email.contentEquals("")) ps.setString(3, email);		
        		ResultSet rs = ps.executeQuery();
        		while (rs.next()) {
        			acquistoBean temp = new acquistoBean();
        			temp.setemailcliente(rs.getString("emailCliente"));
        			temp.setnCarta(rs.getInt("ncarta"));
        			temp.setnFattura(rs.getInt("nFattura"));
        			temp.setdataAcquisto(rs.getDate("dataAcquisto").toLocalDate());
        			temp.setPrezzoTotale(rs.getFloat("prezzoTotale"));
        			temp.setVia(rs.getString("via"));
        			temp.setCap(rs.getInt("cap"));
        			temp.setCitta(rs.getString("città"));
        			acquisti.add(temp);
        		}
        	}
        	catch (Exception e) {
        		e.printStackTrace();
        	}
        	return acquisti;
        }

        public synchronized acquistoBean leggiDaId(int id) throws SQLException {
            Connection connection = null;
            acquistoBean acquistoBean = new acquistoBean();
            PreparedStatement preparedStatement = null;
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE nFattura = ?";
        	try { connection = connessionePool.getConnection(); 
        	preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                setOrders(resultSet, acquistoBean);
            }
        }
		finally {
        	try {
                if (preparedStatement!= null)
                    {
                        preparedStatement.close();
                    }
            } finally {
                        connessionePool.rilasciaConnessione(connection);
                      }
     }
        	return acquistoBean;
   }
        
        public synchronized Collection<acquistoBean> leggiPerEmail(String code) throws SQLException {
            Collection<acquistoBean> ordini = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE emailCliente = ?";

            try { connection = connessionePool.getConnection(); 
            	preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, code);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    acquistoBean acquistoBean = new acquistoBean();
                    setOrders(resultSet, acquistoBean);
                    ordini.add(acquistoBean);
                }
            }
    		finally {
            	try {
                    if (preparedStatement!= null)
                        {
                            preparedStatement.close();
                        }
                } finally {
                            connessionePool.rilasciaConnessione(connection);
                          }
         }
            return ordini;
        }


        public Collection<acquistoBean> leggiTuttiOrdini(String order) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            Collection<acquistoBean> ordini = new ArrayList<>();

            StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE_NAME);

            try {
                connection = connessionePool.getConnection();

                for (String s: ORDERS)
                    if (s.equals(order))
                        query.append(" ORDER BY ").append(s);

                preparedStatement = connection.prepareStatement(query.toString());

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    acquistoBean acquistoBean = new acquistoBean();

                    setOrders(resultSet,acquistoBean);

                    ordini.add(acquistoBean);
                }

            } finally {
                if (preparedStatement!= null)
                    preparedStatement.close();
                if (connection != null)
                    connessionePool.rilasciaConnessione(connection);
            }

            return ordini;
        }


        public synchronized void  inserisciOrdine(acquistoBean acquistoBean) throws SQLException {
            String query = "INSERT INTO " + TABLE_NAME + " (emailCliente, prezzoTotale, dataAcquisto, cap, via, città, nCarta, nFattura) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        	Connection connection = null;
        	PreparedStatement preparedStatement = null;
   
            try  {
            	connection = connessionePool.getConnection(); 
            	preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, acquistoBean.getemailcliente());
                preparedStatement.setFloat(2, acquistoBean.getPrezzoTotale());
                preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
                preparedStatement.setInt(4, acquistoBean.getCap());
                preparedStatement.setString(5, acquistoBean.getVia()); //non li ottiene
                preparedStatement.setString(6, acquistoBean.getCitta()); 	//non li ottiene
                preparedStatement.setInt(7, acquistoBean.getnCarta());
                preparedStatement.setInt(8, acquistoBean.getnFattura());
                preparedStatement.executeUpdate();
                connection.commit();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                	int idInserito = generatedKeys.getInt(1);
                	acquistoBean.setnFattura(idInserito);
            }	
           
           }
    		finally {
    			try {
    				if (preparedStatement != null)
    					preparedStatement.close();
    			} finally {
    				connessionePool.rilasciaConnessione(connection);
    			}
    		}
        }
        public void aggiornaOrdine(acquistoBean product) {

        }


        public boolean eliminaOrdine(int code) {
            return false;
        }

        private void setOrders(ResultSet resultSet, acquistoBean acquistoBean) throws SQLException {
            acquistoBean.setnFattura(resultSet.getInt("nFattura"));
            acquistoBean.setemailcliente(resultSet.getString("emailCliente"));
            acquistoBean.setPrezzoTotale(resultSet.getFloat("prezzoTotale"));
            acquistoBean.setdataAcquisto(resultSet.getDate("dataAcquisto").toLocalDate());
            acquistoBean.setCap(Integer.parseInt(resultSet.getString("cap")));
            acquistoBean.setVia(resultSet.getString("via"));
            acquistoBean.setCitta(resultSet.getString("città")); 
            acquistoBean.setnCarta(resultSet.getInt("nCarta")); 
        }
    }
