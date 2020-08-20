<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <!-- begin: .tray-center -->
    <div class="tray tray-center">

        <!-- Begin: Content Header -->
        <div class="content-header">
            <h2>用户管理</h2>
            <p class="lead"></p>
        </div>
        <!-- message listing panel -->
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">

            <div class="panel  heading-border">
                <!-- message listings table -->
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="hidden-xs">ID</th>
                            <th class="hidden-xs">用户名</th>
                            <th class="hidden-xs">邮箱</th>
                            <th class="text-center">状态</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>

                        <C:forEach items="${users}" var="user">
                        <tr class="message-unread">
                            <td class="">${user.id}</td>
                            <td class="">${user.username}</td>
                            <td class="">${user.email}</td>
                            <td class="text-center fw600">
                                <c:if test="${user.userStatus == 0}">正常</c:if>
                                <c:if test="${user.userStatus == 1}">锁定</c:if>
                                <c:if test="${user.userStatus == 2}">删除</c:if>
                            </td>
                            <td>
                                <c:if test="${user.userStatus == 0}">
                                <a href="/users/disable?id=${user.id}">删除</a>
                                <a href="/users/lock?id=${user.id}">锁定用户</a>
                                </c:if>
                                <c:if test="${user.userStatus == 1}">
                                    <a href="/users/disable?id=${user.id}">删除</a>
                                    <a href="/users/normal?id=${user.id}">解锁用户</a>
                                </c:if>
                                <c:if test="${user.userStatus == 2}">
                                    <a href="/users/normal?id=${user.id}">恢复</a>
                                </c:if>
                            </td>
                        </tr>
                        </C:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end: .admin-form -->
        </div>
        <!-- end: .tray-center -->
    </div>
</section>

<jsp:include page="bottom.jsp"/>