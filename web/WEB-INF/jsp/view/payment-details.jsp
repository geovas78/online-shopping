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

            #total-summery{
                float:right;
            }
        </style>

    </head>
    <body>
        <div id="page">
            <c:import url="/WEB-INF/jsp/template/header.jsp" />
                <div class="container">
                    <div class="row">
                        <div id="authen-head" class="col-md-12 col-xs-12">
                            <h2>PAYMENT DETAILS</h2>
                            <hr style="border-color:#000000">
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-block" class="col-md-5">
                            <p><img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png"></p>
                            <hr style="border-color:#000000">
                            <form method="post" action="<c:url value="/process-payment" />">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                            <label for="cardNumber">CARD NUMBER (use dashes like in the example)</label>
                                            <div class="input-group">
                                                <input 
                                                    type="tel"
                                                    class="form-control"
                                                    name="cardNumber"
                                                    placeholder="XXXX-XXXX-XXXX-XXXX"
                                                    autocomplete="cc-number"
                                                    required autofocus 
                                                    />
                                                <span class="input-group-addon"><i class="fa fa-credit-card"></i></span> </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-7 col-md-7">
                                        <div class="form-group">
                                            <label for="cardExpiry"><span class="hidden-xs">NAME (as shown on the card)</span><span class="visible-xs-inline">NAME</span></label>
                                            <input 
                                                type="text" 
                                                class="form-control" 
                                                name="name"
                                                placeholder="Mr. John Smith"
                                                autocomplete="cc-name"
                                                required 
                                                />
                                        </div>
                                    </div>
                                    <div class="col-xs-5 col-md-5 pull-right">
                                        <div class="form-group">
                                            <label for="cardCVC">CVC</label>
                                            <input 
                                                type="tel" 
                                                class="form-control"
                                                name="cardCVC"
                                                placeholder="999"
                                                autocomplete="cc-csc"
                                                required
                                                />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                            <label for="couponCode">DISCOUNT CODE (sent to you by email from us)</label>
                                            <input type="text" class="form-control" name="couponCode" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <span id="remove-button" class="icon-input-btn"><span class="glyphicon glyphicon-credit-card"></span>
                                            <input type="submit" class="btn btn-success btn-lg btn-block" value=" PAY " />
                                        </span>
                                        <!--<button class="btn btn-success btn-lg btn-block" type="submit">PAY</button>-->
                                    </div>
                                </div>
                                <div class="row" style="display:none;">
                                    <div class="col-xs-12">
                                        <p class="payment-errors"></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div id="total-summery" class="col-md-5">
                            <p style="color:#30F;font-size:18px">Your credit card will be charged with following amount</p>
                            <br />
                            <p style="color:#30F;font-size:18px">Purchased products cost : £ <c:out value="${totalCost}" /></p>
                            <br />
                            <p style="color:#30F;font-size:18px">Shipping cost : £ <c:out value="${shippingCost}" /></p>
                            <br />
                            <hr />
                            <p style="color:#90C;font-size:34px">Total : £ <c:out value="${priceWithShipping}" /></>
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
