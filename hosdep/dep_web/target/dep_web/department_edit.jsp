<%--
  Created by IntelliJ IDEA.
  User: zouzo
  Date: 2020/5/27
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室修改</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/dept/list.do">
                慕课网科室管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, XXX!</h1>
        <p>请小心的修改科室记录，要是修改错误的就不好了。。。</p>
    </div>
    <div class="page-header">
        <h3><small>科室修改</small></h3>
    </div>
    <form class="form-horizontal" action="/department/edit.do" method="post">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="id" type="hidden" value="${OBJ.id}">
                <input name="name" class="form-control" id="name" value="${OBJ.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
            <select id="categoryId" name="categoryId" class="col-sm-2 form-control" style="width: auto">
                <c:forEach items="${CLIST}" var="cate">
                    <c:if test="${OBJ.categoryId==cate.id}">
                        <option value="${cate.id}" selected="selected">${cate.name}</option>
                    </c:if>
                    <c:if test="${OBJ.categoryId!=cate.id}">
                        <option value="${cate.id}">${cate.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center">
    copy@imooc
</footer>
</body>
</html>

