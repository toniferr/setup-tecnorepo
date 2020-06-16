<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="categoria==null || categoria.id == null">
    <s:set var="title" value="%{'Add new categoria'}"/>
</s:if>
<s:else>
    <s:set var="title" value="%{'Update categoria'}"/>
</s:else>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <s:head />
        <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <style>td { white-space:nowrap; }</style>
        <title><s:property value="#title"/></title>
    </head>
    <body>
        <div class="titleDiv"><s:text name="application.title.categorias"/></div>
        <h1><s:property value="#title"/></h1>
        <s:actionerror />
        <s:actionmessage />
        <s:form action="saveCategoria" method="post">
            <s:textfield key="categoria.nombre" />             
            <s:hidden name="categoria.id" value="%{categoria.id}"/>
            <s:submit value="%{getText('button.label.submit')}"/>
            <s:submit value="%{getText('button.label.cancel')}" action="index"/>
        </s:form>
    </body>
</html>

