<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">注册</div>
                <div class="panel-body">
                    <form role="form" method="POST" action="/register">

                        <div class="form-group">
                            <input type="text" class="form-control" name="username" value="" placeholder="用户名">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" value="" placeholder="邮箱地址">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password" placeholder="密码">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="password_confirm" placeholder="确认密码">
                        </div>

                        <button type="submit" class="btn btn-primary">
                            注册
                        </button>
                        <a href="" class="btn btn-default">取消</a>
                    </form>
                </div>
            </div>
            <div class="panel-footer">
                已注册或使用社交账号登录，请点击 <a href="login.html">这里</a> 进行登录。
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>