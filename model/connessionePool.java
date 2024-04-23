package model;

import java.sql.*;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

public class connessionePool
{
    private static List<Connection> connDB; //variabile lista di coneesione

    static  
        {
            connDB = new LinkedList<Connection>(); //costruttore lista linkata di connessioni
            try{
                    Class.forName("com.mysql.cj.jdbc.Driver"); //connessione driver del database
               }
           catch(Exception e) //errore sul driver
                {
                    System.out.println("ERRORE:" + "e" + ". Driver di database non trovato!" ); 
                }}
    
    private static Connection connessioneDB() //metodo statico che restituisce la connessione col database
        {
            Connection c = null;
            String url = "jdbc:mysql://localhost:3306/gdbgames";
            String username = "root";
            String pass = "Alex2003";
            try {
            c = DriverManager.getConnection(url, username, pass);
            c.setAutoCommit(false); 
            return c; }
            catch(Exception e) //errore sul driver
            {
                System.out.println("ERRORE:" + "e" + ". Driver di database non trovato!" ); 
                return null;
            }
            
        }

    public static synchronized Connection getConnection() throws SQLException //sovrascrizione metodo getConnection   
        {                                                                     //che può sollevare errori
            Connection conn;

            if(!connDB.isEmpty()) //lista di connessioni non vuota
                {
                    conn = (Connection) connDB.get(0); //casting a connessione dell'elemtno 0 della lista di connessioni
                    connessionePool.connDB.remove(0); //rimuovr l'elemento in posizione 0 nella lista di connnessioni
                    try{
                            if(conn.isClosed()) //connessione chiusa
                                {
                                    conn = connessionePool.getConnection(); //prende la connessione se essa è chiusa
                                }   
                       }
                    catch(SQLException e)
                        {
                            conn = connessionePool.getConnection(); //prende la connessione se si solleva un errore
                        }
                }
            else
                {
                    conn = connessionePool.connessioneDB(); //richiama il metodo per creare la connessione 
                }
            return conn;
        }

    public static synchronized void rilasciaConnessione(Connection c) //aggiunge un istanza di connessione alla lista di connessioni
        {
    	connessionePool.connDB.add(c);
        }
}