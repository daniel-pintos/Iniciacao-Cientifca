<%@page import="br.ufpr.dao.NotaDAO.GerenicObject"%>
<%@page import="br.ufpr.dao.NotaDAO"%>
<%@page import="br.ufpr.entidade.Nota"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	final String NomeSite = "Teste de Produçãos";
	System.out.println("Recarregando da página");
	NotaDAO notaDao = new NotaDAO();
%>
<html>
<head>
<title><%=NomeSite%></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="header col-md-12">
				<h1><%=NomeSite%></h1>
			</div>
		</div>
		<div class="row">
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">#id</th>
						<th scope="col">Nome</th>
						<th scope="col">Produto</th>
						<th scope="col">Nota</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < 5; i++) {
							List<GerenicObject> lista = notaDao.buscarNotaPorIdCliente(i);
							for (GerenicObject nota : lista) {
					%>
					<tr>
						<th scope="row"><%=i%></th>
						<td><%=nota.getNomeCliente()%></td>
						<td><%=nota.getNomeProduto()%></td>
						<td id='valor'><%=nota.getNota()%></td>
					</tr>

					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-md-12">
				<input type="text" class="form-control" name="CampoNovo" aria-describedby="Enserir novos Campos" placeholder="Insira o nome da pessoa">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<input type="text" class="form-control" name="CampoNovo" aria-describedby="Enserir novos Campos" placeholder="O produto">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				
				<input type="text" class="form-control" name="CampoNovo" aria-describedby="Enserir novos Campos" placeholder="A nota que ela deu">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form class="form-group" action="#" method="GET">
					<button type="submit" onclick="validar()"
						class="btn btn-primary" name="envio" value="Enviar">Prever</button>

					<hr>
				</form>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	
</script>
<style>
body, html {
	background: #222;
}


input {
	margin: 5px; 
}

h1 {
	color: white;
}

button {
	margin-top: 20px;
	
}
</style>

</html>
jsp
