<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="app.title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="#"><spring:message code="app.title"/></a>
            <div class="d-flex">
                <a href="?lang=es" class="btn btn-sm btn-outline-light me-2"><spring:message code="app.lang.es"/></a>
                <a href="?lang=en" class="btn btn-sm btn-outline-light"><spring:message code="app.lang.en"/></a>
            </div>
        </div>
    </nav>

    <div class="container">
        
        <h2 class="mb-4"><spring:message code="app.projects.title"/></h2>
        
        <input type="text" id="buscador" class="form-control mb-4" placeholder="Buscar proyecto en vivo...">

        <div class="row" id="galeria-proyectos">
            <c:forEach var="p" items="${proyectos}">
                <div class="col-md-4 mb-4 proyecto-card">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">${p.titulo}</h5>
                            <p class="card-text">${p.descripcion}</p>
                            <p class="card-text"><small class="text-muted">${p.tecnologias}</small></p>
                            <a href="${p.enlaceGithub}" class="btn btn-primary btn-sm" target="_blank"><spring:message code="app.table.link"/></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <hr class="my-5">

        <div class="row">
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-header bg-secondary text-white">
                        <spring:message code="app.projects.new"/>
                    </div>
                    <div class="card-body">
                        <form:form action="/proyectos" method="post" modelAttribute="proyecto">
                            <div class="mb-3">
                                <label class="form-label"><spring:message code="app.table.title"/></label>
                                <form:input path="titulo" class="form-control" />
                                <form:errors path="titulo" cssClass="text-danger small" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label"><spring:message code="app.table.description"/></label>
                                <form:textarea path="descripcion" class="form-control" rows="3" />
                                <form:errors path="descripcion" cssClass="text-danger small" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label"><spring:message code="app.table.tech"/></label>
                                <form:input path="tecnologias" class="form-control" />
                                <form:errors path="tecnologias" cssClass="text-danger small" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label"><spring:message code="app.table.link"/></label>
                                <form:input path="enlaceGithub" class="form-control" />
                                <form:errors path="enlaceGithub" cssClass="text-danger small" />
                            </div>
                            <button type="submit" class="btn btn-success w-100"><spring:message code="app.projects.save"/></button>
                        </form:form>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <table class="table table-striped table-hover bg-white shadow-sm" id="tabla-proyectos">
                    <thead class="table-dark">
                        <tr>
                            <th><spring:message code="app.table.id"/></th>
                            <th><spring:message code="app.table.title"/></th>
                            <th><spring:message code="app.table.tech"/></th>
                            <th><spring:message code="app.table.actions"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${proyectos}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.titulo}</td>
                                <td>${p.tecnologias}</td>
                                <td>
                                    <form action="/proyectos/eliminar/${p.id}" method="post" style="display:inline;">
                                        <input type="hidden" name="_method" value="delete" />
                                        <button type="submit" class="btn btn-danger btn-sm btn-eliminar">
                                            <spring:message code="app.projects.delete"/>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/app.js"></script>

</body>
</html>