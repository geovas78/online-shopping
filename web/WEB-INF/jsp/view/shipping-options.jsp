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

            .submit-button{
                margin-top: 15px;}
            </style>

        </head>
        <body>
            <div id="page">
                <c:import url="/WEB-INF/jsp/template/header.jsp" />
                <div class="container">
                    <div class="row">
                        <div id="authen-head" class="col-md-12 col-xs-12">
                            <h2>SHIPPING OPTIONS</h2>
                            <hr style="border-color:#000000">
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-block" class="col-sm-8">
                            <p>Please choose from the options below your delivery method</p>
                            <hr style="border-color:#000000">
                            <div style="display: block;" id="noSlide"> 

                                <!---->
                                <form action="<c:url value="/checkout?processing=payment-details" />" method="post" id="account-creation_form" class="std box">
                                    <div class="option-table">
                                        <table width="700" border="1" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td width="10%" align="center"><input id="shipping-option1" type="radio" name="shipping" value="free" checked /></td>
                                                <td width="10%" height="80" align="center"><img class="lorry" src="resources/images/royalmail.jpg" /></td>
                                                <td width="70%" align="center">3 - 5 business days by Royal Mail</td>
                                                <td width="10%" align="center">FREE</td>
                                            </tr>
                                            <tr>
                                                <td width="10%" align="center"><input id="shipping-option2" type="radio" name="shipping" value="paid" /></td>
                                                <td width="10%" height="80" align="center"><img class="lorry" src="resources/images/truck1.jpg" /></td>
                                                <td width="70%" align="center">Next working day by our courier Fast Delivery Transportation</td>
                                                <td width="10%" align="center">£ 12.80</td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="submit-button">
                                        <hr style="border-color:#000000">
                                        <div class="buttons-forward">
                                            <div class="row">
                                                <div class="col-md-6 col-md-offset-8">
                                                    <br />
                                                    <span id="remove-button" class="icon-input-btn"><span class="glyphicon glyphicon-play"></span>
                                                        <input type="submit" class="btn btn-success btn-md" value=" Proceed to payment " />
                                                    </span>
                                                    <br />
                                                </div>
                                            </div>
                                        </div>
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
