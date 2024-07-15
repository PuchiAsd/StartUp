<%--
  Created by IntelliJ IDEA.
  User: Puchi
  Date: 11-07-2024
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Home</title>
</head>
<body class="container">
    <div class="row">
        <h1 class="text-center">Bienvenidos a StartUp Panel de Administrador</h1>

        <div class="col-md-4 mx-auto">
            <div class="container mx-auto text-center mt-3">
                <c:choose>
                    <c:when test="${usuarioAutenticado != null}">
                        <c:choose>
                            <c:when test="${usuarioAutenticado}">
                                <div class="alert alert-success">${mensaje}</div>

                                <!-- Cuando esta autenticado mostrara los datos-->
                                <div class="card">
                                    <div class="card-body">
                                        <p><span class="fw-bolder">Nombre usuario:</span> ${modeloUsuario.nombre}</p>
                                        <p><span class="fw-bolder">Correo:</span> ${modeloUsuario.correo}</p>
                                        <p><span class="fw-bolder">Rol Usuario:</span>  ${modeloUsuario.rol}</p>
                                        <p><span class="fw-bolder">Apodo Usuario:</span>  ${modeloUsuario.apodo}</p>
                                    </div>
                                </div>

                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger">${mensaje}</div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-danger">Usuario no autenticado o no encontrado.</div>
                    </c:otherwise>
                </c:choose>
            </div>
            <br>
        </div>

        <!-- Aqui mostrara la tabla de usuarios-->
        <div class="col-md-12 mx-auto">
            <div class="container mx-auto text-center mt-3">

                <c:if test="${usuarioAutenticado != null}">
                    <c:choose>
                        <c:when test="${usuarioAutenticado}">
                            <div class="card">
                                <div class="card-body">
                                    <table class="table table-dark table-striped">
                                        <thead>
                                        <tr>
                                            <th scope="col">Id</th>
                                            <th scope="col">Nombre Usuario</th>
                                            <th scope="col">Correo</th>
                                            <th scope="col">Apodo</th>
                                            <th scope="col">Direccion</th>
                                            <th scope="col">Rol</th>
                                            <th scope="col">Auto</th>
                                            <th scope="col">Url</th>
                                            <th scope="col">Proveedor</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="usuario" items="${listaUsuarios}">
                                            <tr>
                                                <td>${usuario.id}</td>
                                                <td>${usuario.nombre}</td>
                                                <td>${usuario.correo}</td>
                                                <td>${usuario.apodo}</td>
                                                <td>${usuario.direccion}</td>
                                                <td>${usuario.rol}</td>
                                                <td>${usuario.auto}</td>
                                                <td>${usuario.url}</td>
                                                <td>${usuario.proveedor}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-danger">Usuario no autenticado o no encontrado.</div>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </div>
            <br>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
