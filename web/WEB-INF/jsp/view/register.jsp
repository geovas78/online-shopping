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
            <div class="container">
                <div class="row">
                    <div class="col-md-12"> <img class="banner" src="resources/images/banner1.jpg"> </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-1">
                        <h3 id="logo">BooksOnline</h3>
                    </div>
                </div>
            </div>
                <div class="container">
                    <div class="row">
                        <div id="authen-head" class="col-md-12 col-xs-12">
                            <h2>CREATE AN ACCOUNT</h2>
                            <hr style="border-color:#000000">
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-block" class="col-sm-8">
                            <p>YOUR PERSONAL INFORMATION</p>
                            <hr style="border-color:#000000">
                            <div style="display: block;" id="noSlide">


                                <!---->
                                <form action="<c:url value="/authenticate?option=user-registration" />" method="post" id="account-creation_form" class="std box">
                                    <div class="account_creation">
                                        <div class="clearfix">
                                            <label>Title</label>
                                            <br>
                                            <div class="radio-inline">
                                                <label for="id_gender1" class="top">
                                                    <div id="uniform-id_gender1" class="radio"><span>
                                                            <input name="id_gender" id="id_gender1" value="MR." type="radio">
                                                        </span></div>
                                                    Mr.
                                                </label>
                                            </div>
                                            <div class="radio-inline">
                                                <label for="id_gender2" class="top">
                                                    <div id="uniform-id_gender2" class="radio"><span>
                                                            <input name="id_gender" id="id_gender2" value="Mrs." type="radio">
                                                        </span></div>
                                                    Mrs.
                                                </label>
                                            </div>
                                            <div class="radio-inline">
                                                <label for="id_gender23" class="top">
                                                    <div id="uniform-id_gender2" class="radio"><span>
                                                            <input name="id_gender" id="id_gender2" value="Miss." type="radio">
                                                        </span></div>
                                                    Miss
                                                </label>
                                            </div>
                                        </div>
                                        <div class="required form-group">
                                            <label for="customer_firstname">First name <sup>*</sup></label>
                                            <input class="is_required validate form-control" data-validate="isName" id="customer_firstname" name="customer_firstname" type="text" required>
                                        </div>
                                        <div class="required form-group">
                                            <label for="customer_lastname">Last name <sup>*</sup></label>
                                            <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="customer_lastname" type="text" required>
                                        </div>
                                        <div class="required form-group">
                                            <label for="email">Email <sup>*</sup></label>
                                            <input type="email" class="is_required validate form-control" data-validate="isEmail" id="email" name="email" value="<c:out value="${email}" />" disabled>
                                            <input type="hidden" name="email-db" value="<c:out value="${email}" />">
                                        </div>
                                        <div class="required password form-group">
                                            <label for="passwd">Password <sup>*</sup></label>
                                            <input class="is_required validate form-control" data-validate="isPasswd" name="passwd" id="passwd" type="password" required>
                                            <span class="form_info">(Five characters minimum)</span> </div>
                                        <div class="form-group">
                                        </div>
                                    </div>
                                    <div class="submit clearfix">
                                        <!--<input name="email_create" value="1" type="hidden">
                                        <input name="is_new_customer" value="1" type="hidden">
                                        <input class="hidden" name="back" value="my-account" type="hidden">-->
                                        <span class="icon-input-btn"><span class="glyphicon glyphicon-book"></span>
                                            <input type="submit" class="btn btn-success btn-md" value="Register">
                                        </span>
                                    </div>
                                </form>
                            </div>
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
