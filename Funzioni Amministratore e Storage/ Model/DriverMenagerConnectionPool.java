packeage: model;
import java.sql.*;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

pubblic class connessionePool
{
    private static List<Connection> connDB; //variabile lista di coneesione

    static  
        {
            connDB = new LinkedList<Connection>(); //costruttore lista linkata di connessioni
            try{
                    Class.ForName("com.mysql.cj.jdbc.Driver"); //connessione driver del database
               }
            catch(ClassNotFoundException e) //errore sul driver
                {
                    System.out.println("ERRORE:" + "e" + ". Driver di database non trovato!" ); 
                }
            catch(IOException e) //errore di conessione 
                {
                    System.out.println("ERRORE:" + "e" + ". Connessione non trovata");
                }
        }
    
    private static Connection connessioneDB() //metodo statico che resstituisce la connessione col database
        {
            Connection c = null;
            String url = "jdbc:mysql://localhost:3306/gdbgames";
            String username = "username";
            String pass = "password";
            c = DriverMenager.getConnection(url, username, pass);
            c.setAutoCommit(false); 
            return c;
        }

    public static synchronized Connection getConnection() throws SQLException //sovrascrizione metodo getConnection   
        {                                                                     //che può sollevare errori
            Connection conn;

            if(!connDB.isEmpty()) //lista di connessioni non vuota
                {
                    conn = (Connection) connDB.get(0); //casting a connessione dell'elemtno 0 della lista di connessioni
                    DriverMenagerConnectionPool.connDB.remove(0); //rimuovr l'elemento in posizione 0 nella lista di connnessioni
                    try{
                            if(conn.isClosed()) //connessione chiusa
                                {
                                    conn = DriverMenagerConnectionPool.getConnection(); //prende la connessione se essa è chiusa
                                }   
                       }
                    catch(SQLException e)
                        {
                            conn = DriverMenagerConnectionPool.getConnection(); //prende la connessione se si solleva un errore
                        }
                }
            else
                {
                    conn = DriverMenagerConnectionPool.connessioneDB(); //richiama il metodo per creare la connessione 
                }
            return conn;
        }

    public static synchronized void aggiungiconn(Connection c) //aggiunge un istanza di connessione alla lista di connessioni
        {
            DriverMenagerConnectionPool.connDB.add(c);
        }

}