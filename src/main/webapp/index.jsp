<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>JSP - Hello World</title>
</head>
<body class="container">
    <div class="row">
        <h1 class="text-center">Bienvenidos a StartUp</h1>

        <div class="col-md-4 mx-auto">
            <p class="text-center">Para continuar, por favor inicie sesión o regístrese.</p>
            <br>
            <form action="login" method="post">
                <div class="form-floating">
                    <input type="email" class="form-control" id="correo" name="correo" placeholder="name@example.com">
                    <label for="correo">Correo</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="clave" name="clave" placeholder="Password">
                    <label for="clave">Contraseña</label>
                </div>
                <div class="container mx-auto text-center mt-3">
                    <c:if test="${usuarioAutenticado != null}">
                        <c:choose>
                            <c:when test="${usuarioAutenticado}">
                                <div class="alert alert-success">${mensaje}</div>
                                <div class="alert alert-success">${mensajeRol}</div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger">${mensaje}</div>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </div>

                <button class="btn btn-success w-100 mt-5 py-2" type="submit">Ingresar</button>
                <div class="form-check text-start my-3">
                    <label>No es un miembro? </label>
                    <a class="btn btn-primary ms-2" href="registroUsuario" >Registrar</a>
                </div>
                <div class="container mx-auto text-center mt-3">
                    <c:if test="${flagExito != null}">
                        <c:choose>
                            <c:when test="${flagExito}">
                                <div class="alert alert-success">${mensajeRespuesta}</div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger">${mensajeRespuesta}</div>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </div>
                <p class="mt-5 mb-3 text-body-secondary">© Puchi~ 2024</p>
            </form>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>