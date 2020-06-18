<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <s:head />
        <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="label.categorias"/></title>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title.categorias"/></div>
        <h1><s:text name="label.categorias"/></h1>
        <s:url var="url" action="saveCategoria" />
        <a href="<s:property value="#url"/>">Add New Categoria</a>
        <br/><br/>
        <table class="borderAll">
            <tr>
                <th><s:text name="label.tabla.nombre"/></th>
                <th>&nbsp;</th>
            </tr>
            <s:iterator value="categorias" status="status">
                <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
                    <td class="nowrap"><s:property value="nombre"/></td>
                    
                    <td class="nowrap">
                        <s:url action="inputCategoria" var="url">
                            <s:param name="categoria.id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <s:url action="deleteCategoria" var="url">
                            <s:param name="categoria.id" value="id"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">Delete</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
