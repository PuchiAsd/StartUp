<%--
  Created by IntelliJ IDEA.
  User: Puchi
  Date: 12-07-2024
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Registro</title>
</head>
<body class="container">
    <div class="row">
        <h1 class="text-center">Registro usuario</h1>

        <div class="col-md-4 mx-auto">
            <br/>
            <form action="registroUsuario" method="post">
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >Correo</span>
                    <input type="email" class="form-control" id="correo" name="correo" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >Clave</span>
                    <input type="password" class="form-control" id="clave" name="clave" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >Nombre</span>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >Apodo</span>
                    <input type="text" class="form-control" id="apodo" name="apodo" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >Peso</span>
                    <input type="number" class="form-control" id="peso" name="peso" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >Dirección</span>
                    <input type="text" class="form-control" id="direccion" name="direccion" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" style="width: 30%!important"  >N°Dirección</span>
                    <input type="number" class="form-control" id="direccionNum" name="direccionNum" required>
                </div>

                <div class="input-group mb-3">
                    <!-- Selector de autos precargado desde el servlet -->
                    <select class="form-select" name="selectRol" id="selectRol" required>
                        <option selected>Selecciona un Rol</option>
                        <c:forEach var="rol" items="${ListaRoles}">
                            <option value="${rol.id}">${rol.nombre}</option>
                        </c:forEach>
                    </select>

                    <div class="container mx-auto text-center mt-3">
                        <c:if test="${not empty errorSelectRol}">
                            <div class="alert alert-danger">${errorSelectRol}</div>
                        </c:if>
                    </div>
                </div>

                <div class="input-group mb-3">
                    <!-- Selector de autos precargado desde el servlet -->
                    <select class="form-select" name="selectAuto" id="selectAuto" required>
                        <option selected>Selecciona un auto</option>
                        <c:forEach var="auto" items="${ListaAuto}">
                            <option value="${auto.id}">${auto.nombre}</option>
                        </c:forEach>
                    </select>

                    <div class="container mx-auto text-center mt-3">
                        <c:if test="${not empty errorSelectAuto}">
                            <div class="alert alert-danger">${errorSelectAuto}</div>
                        </c:if>
                    </div>
                </div>

                <div class="text-center">
                    <a class="btn btn-secondary" href="index.jsp">Volver a Inicio</a>
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </form>
            <p class="mt-5 mb-3 text-body-secondary">© Puchi~ 2024</p>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
