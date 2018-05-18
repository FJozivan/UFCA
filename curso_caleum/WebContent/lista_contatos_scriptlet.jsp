<%@page import="java.util.*, br.com.curso_caleum.BD.*" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Lista de Contatos</title>
		<meta charset="UTF-8">
	</head>
	<body>
		<table> 
			<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for(Contato contato : contatos){
			%>
				<tr>
					<td><%contato.getNome(); %></td>
					<td><%contato.getEmail(); %></td>
					<td><%contato.getEndereco(); %></td>
					<td><%contato.getEndereco(); %></td>
					<td><%contato.getDataNascimento(); %></td>
				</tr>
			<%
			}
			%>
		</table>
	
	</body>
</html>

