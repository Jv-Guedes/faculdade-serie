package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import Model.Serie;

public class SerieDAO {
	
	private Connection myConn;
	
	public SerieDAO() throws SQLException, ClassNotFoundException {
		
		String user = "root";
		String password = "root";
		String dburl = "jdbc:mysql://localhost:3306/medina?autoReconnect=true&useSSL=false";
		Class.forName("com.mysql.jdbc.Driver");
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.print("Conectado!");
	}
	
	public List<Serie> getAllSerie() throws SQLException {
		
		List<Serie> list = new ArrayList<>();
		
		Statement myStat = null;
		ResultSet myResult = null;
		
		myStat = myConn.createStatement();
		myResult = myStat.executeQuery("SELECT * FROM series");
		
		while (myResult.next()) {
			Serie tmpSerie = new Serie(
					myResult.getString("serie"),
					myResult.getString("episodio"),
                                        myResult.getString("temporada"),
					myResult.getInt("ano"),
					myResult.getBoolean("jaAssistido"),
					myResult.getString("nota")
					);
                        list.add(tmpSerie);
		}
		
		myStat.close();
		return list;
	}
        
        public void insertSerie(String serie,String episodio, String temporada, int ano, boolean jaAssistido, String nota) throws SQLException {
		System.out.println( serie);    		System.out.println( episodio);    
		System.out.println( temporada);    
		System.out.println( ano);    
		System.out.println( jaAssistido);   		System.out.println( nota);    
 

		List<Serie> list = new ArrayList<>();
		
		Statement myStat = null;
		ResultSet myResult = null;
		
		myStat = myConn.createStatement();
                myStat.executeUpdate("INSERT INTO series (serie,episodio,temporada,ano,jaAssistido,nota) VALUES (' " + serie + " ', '"+episodio+"', '" +temporada +"', '" +ano+ " ',"+jaAssistido+",'"+nota+"')");      
		myStat.close();
	}

}