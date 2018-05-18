package br.com.curso_caleum.BD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_BD {

	private static String url = "jdbc:postgresql://localhost:5432/jozivan";
	private static String user = "postgres";
	private static String senha = "postgres";
	//Class.forName("com.postgresql.jdbc.Driver");
	public java.sql.Connection get_Connection() {
		try {
			System.out.println("Conexao Realizada com sucesso");
			return (java.sql.Connection) DriverManager.getConnection(url, user, senha);
		} catch (SQLException ex) {
			System.out.println("Falha na conexao");
			throw new RuntimeException(ex);
		}
		
	}
	

}
