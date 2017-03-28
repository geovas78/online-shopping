<!DOCTYPE html>
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
            .buttons-forward{
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div id="page">
            <c:import url="/WEB-INF/jsp/template/header.jsp" />
                <div class="container">
                    <div class="row">
                        <div id="authen-head" class="col-md-12 col-xs-12">
                            <h2>ADDRESS SUMMARY</h2>
                            <hr style="border-color:#000000">
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-block" class="col-md-5">
                            <p>DELIVERY ADDRESS</p>
                            <hr style="border-color:#000000">
                            <form method="get" action="<c:url value="/register-address" />">
                                <div class="form-group">
                                    <p><c:out value="${deliveryAddress.firstName}" /> &nbsp;  <c:out value="${deliveryAddress.lastName}" /></p>
                                    <p>${deliveryAddress.firstLine}</p> 
                                    <p>${deliveryAddress.secondLine}</p> 
                                    <p>${deliveryAddress.town}</p> 
                                    <p>${deliveryAddress.postcode}</p>
                                    <p>${deliveryAddress.country}</p> 
                                    <p>${deliveryAddress.mobile}</p> 
                                    <p>${deliveryAddress.landline}</p> 
                                </div>
                                <input type="hidden" name="address" value="delivery" />
                                <span class="icon-input-btn"><span class="glyphicon glyphicon-refresh"></span>
                                    <input type="submit" class="btn btn-success btn-md" value="UPDATE">
                                </span>
                            </form>
                        </div>
                        <div id="form2-block" class="col-md-5">
                            <p id="register-header">BILLING ADDRESS</p>
                            <hr style="border-color:#000000">
                            <form method="get" action="<c:url value="/register-address" />">
                                <div class="form-group">
                                    <p><c:out value="${billingAddress.firstName}" />  &nbsp;  <c:out value="${deliveryAddress.lastName}" /></p>
                                    <p>${billingAddress.firstLine}</p> 
                                    <p>${billingAddress.secondLine}</p> 
                                    <p>${billingAddress.town}</p> 
                                    <p>${billingAddress.postcode}</p>
                                    <p>${billingAddress.country}</p> 
                                    <p>${billingAddress.mobile}</p> 
                                    <p>${billingAddress.landline}</p> 
                                </div>
                                <p>
                                    <input type="hidden" name="address" value="billing" />
                                    <span class="icon-input-btn"><span class="glyphicon glyphicon-refresh"></span>
                                        <input type="submit" class="btn btn-success btn-md" value="UPDATE">
                                    </span>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
                <hr style="border-color:#000000">
                <div class="buttons-forward">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-8">
                            <br />
                            <a href="<c:url value="/checkout?processing=shipping" />" type="button" class="btn btn-success"> <span class="glyphicon glyphicon-play"></span> Proceed to delivery options</a>
                            <br />
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
