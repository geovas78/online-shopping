<!DOCTYPE html >
<html lang="en">
    <head>
        <c:import url="/WEB-INF/jsp/template/head-content.jsp" />
        <link href="resources/css/books.css" rel="stylesheet" type="text/css">
        <link href="resources/css/authentication.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            .icon-input-btn{
                display: inline-block;
                position: relative;
            }
            .icon-input-btn input[type="submit"]{
                padding-right: 2em;
                float:left;
            }
            .icon-input-btn .glyphicon{
                color: #FFFEFC;
                display: inline-block;
                position: absolute;
                right: 0.65em;
                top: 30%;
            }
        </style>
    </head>
    <body>
        <div id="page">
            <c:import url="/WEB-INF/jsp/template/header.jsp" />
                <div class="container">
                    <div class="row">
                        <div id="authen-head" class="col-md-12 col-xs-12">
                            <h2>AUTHENTICATION</h2>
                            <!-- show message for the operation status -->
                            <c:if test="${RegistrationStatus}">
                                <div class="alert alert-danger" role="alert"><c:out value="${message}" /></div>
                            </c:if>
                            <c:if test="${registerFail}">
                                <div class="alert alert-danger" role="alert"><c:out value="${message}" /></div>
                            </c:if>
                            <c:if test="${registerOK}">
                                <div class="alert alert-success" role="alert"><c:out value="${message}" /></div>
                            </c:if>
                            <hr style="border-color:#000000">
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-block" class="col-md-5">
                            <p>CREATE ACCOUNT</p>
                            <hr style="border-color:#000000">
                            <form method="post" action="<c:url value="/authenticate?option=register-email" />">
                                <p>Please enter your email address to create an account</p>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter email" size="15" required="true">
                                </div>
                                <span class="icon-input-btn"><span class="glyphicon glyphicon-user"></span>
                                    <input type="submit" class="btn btn-warning btn-md" value="Create account">
                                </span>
                            </form>
                        </div>
                        <div id="form2-block" class="col-md-5">
                            <p id="register-header">ALREADY REGISTERED?</p>
                            <hr style="border-color:#000000">
                            <form method="post" action="<c:url value="/authenticate?option=login" />">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter email" required="true">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password" required="true">
                                </div>
                                <p><a href="">Forgot your password?</a></p>
                                <p><span class="icon-input-btn"><span class="glyphicon glyphicon-lock"></span>
                                        <input type="submit" class="btn btn-success btn-md" value="SIGN IN">
                                    </span>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                                <c:import url="/WEB-INF/jsp/template/footer.jsp" />
            </div>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
            <!-- Include all compiled plugins (below), or include individual files as needed --> 
            <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
