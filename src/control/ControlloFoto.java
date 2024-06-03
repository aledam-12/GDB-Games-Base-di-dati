package control;
import java.sql.*;

import model.connessionePool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ControlloFoto
{
    public synchronized static byte[] caricamento(String t)
        {
            Connection c = null;
            PreparedStatement st = null;
            byte b[] = null;
            try{
                    c = connessionePool.getConnection();
                    String query = "SELECT img FROM videogioco WHERE titolo = ?";
                    st = c.prepareStatement(query);
                    st.setString(1, t);
                    ResultSet risultato = st.executeQuery();
                    if (risultato.next()) 
                    {	
                        b = risultato.getBytes("img");
                    }
               } catch (SQLException sqlException) 
                    {
                        System.out.println(sqlException);
                    }
                    finally {
                            try {
                                if (st != null)
                                    {
                                        st.close();
                                    }
                                } catch (SQLException sqlException) 
                                    {
                                        System.out.println(sqlException);
                                    } finally {
                                            if (c != null)
                                                { 
                                                    connessionePool.rilasciaConnessione(c);
                                                }
                                              }
                            }
                    return b;
        }
    
    public synchronized static void updateImg(String t, String url) throws SQLException 
        {
            Connection c = null;
            PreparedStatement st = null;
            try {
                    c = connessionePool.getConnection();
                    String query = "UPDATE videogioco SET img = ? WHERE titolo = ?";
                    st = c.prepareStatement(query);
                    File file = new File(url);
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        st.setBinaryStream(1, fis, fis.available());
                        st.setString(2, t);
                        st.executeUpdate();
                        c.commit();
                        } catch (FileNotFoundException e) 
                            {
                                System.out.println(e);
                            } catch (IOException e) 
                                {
                                    System.out.println(e);
                                }
                } finally {
                        try {
                            if (st != null)
                                {
                                    st.close();
                                }
                            } catch (SQLException sqlException) 
                                {
                                    System.out.println(sqlException);
                                } finally {
                                    if (c != null)
                                        {
                                            connessionePool.rilasciaConnessione(c);
                                        }
                                          }
                          }
        }
}
