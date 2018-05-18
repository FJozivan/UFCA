package br.com.curso_caleum.BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {
	
	private Connection con;
	
	//Realiza a conexao com o banco
	public ContatoDao() {
		this.con = new Conexao_BD().get_Connection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento) " + "values (?, ?, ?, ?)";
		
		
		try{
			//Prepara o statement
			PreparedStatement stmt = con.prepareStatement(sql);
			
			//Seta os valorea
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			// executa
	         stmt.execute();
	         stmt.close();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}				
	}
	
	public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.con.prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // montando a data atraves do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                // adicionando o objeto a lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
}
