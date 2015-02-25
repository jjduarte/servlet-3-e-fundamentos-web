<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}
</c:if>

<form action="executa" method="Post">
	<input type="hidden" name="tarefa" value="novaEmpresa">
	Nome: <input type="text" name="nome">
	<input type="submit" value="Enviar">
</form>

<form action="login" method="Post">
	
	Email: <input type="email" name="email"/>
	Senha: <input type="password" name="senha"/>
	<input type="submit" value="Enviar"/>
</form>	

<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Deslogar">
</form>

</body>
</html>