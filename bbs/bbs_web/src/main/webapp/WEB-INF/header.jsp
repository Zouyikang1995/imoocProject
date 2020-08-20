<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>慕课论坛</title>
    <link rel="stylesheet"  href="/static/css/all-df86af5803.css">
</head>
<body class="forum" data-page="forum">
<div class="header">
    <nav class="navbar navbar-inverse navbar-fixed-top navbar-default">
        <div class="container">
            <div class="navbar-header" id="navbar-header">
                <a href="" class="navbar-brand"><img src="/images/logo.png">
                </a>
            </div>
            <div id="main-nav-menu">
                <ul class="nav navbar-nav">
                    <li ><a href="/list"><i class="fa fa-home"></i><span class="hidden-xs hidden-sm">首页</span></a></li>
                    <li class="hidden-sm hidden-xs"><a href=""><i class="fa fa-comments-o"></i> 话题</a></li>

                </ul>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="nav-search hidden-xs hidden-sm">
                    <form method="GET" action="/bbs/preLogin.do" accept-charset="UTF-8" class="navbar-form form-search active" target="_blank">
                        <div class="form-group">
                            <input placeholder="搜索" class="form-control" name="q" type="search">
                        </div>
                        <i class="fa fa-search"></i>
                    </form>
                </li>
                <c:if test="${null == sessionScope.user}">
                <li ><a href="/to_register" id="signup-btn">注册</a></li>
                <li class="active"><a href="/to_login" id="login-btn">登录</a></li>
                </c:if>
                <c:if test="${null != sessionScope.user}">
                <li ><a href="/logout" id="signout-btn">${sessionScope.user.username} 注销</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</div>
<div id="main" class="main-container container">