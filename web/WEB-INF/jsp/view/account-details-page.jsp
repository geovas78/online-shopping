<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="/WEB-INF/jsp/template/head-content.jsp" />
        <link href="resources/css/books.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            .icon-input-btn {
                display: inline-block;
                position: relative;
            }
            .icon-input-btn input[type="submit"] {
                padding-right: 2em;
                float: left;
            }
            .icon-input-btn .glyphicon {
                color: #FFFEFC;
                display: inline-block;
                position: absolute;
                right: 0.65em;
                top: 30%;
            }
            form {
                margin-top: 35px;
                margin-bottom: 45px;
                margin-left: 15px;
                margin-right: 15px;
            }
            #submit-button {
                margin-left: 25px;
                margin-bottom: 35px;
            }
            #title {
                font-family: Tahoma, Geneva, sans-serif;
                color: #009;
                font-size: 36px;
            }
        </style>
    </head>
    <body>
        <div id="page">
            <c:import url="/WEB-INF/jsp/template/header.jsp" />
            <div id="my-account" class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title"> <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"><span id="title"> Your personal details</span> </a> </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <p> Name : <c:out value="${deliveryAddress.firstName}" /> &nbsp;  <c:out value="${deliveryAddress.lastName}" /> </p>
                                        <br />
                                        <p> Username : <c:out value="${username}" /></p>
                                        <!--<p><button type="button" class="btn btn-primary">Change password</button>-->
                                        <br />
                                        <p>Last used CREDIT CARD number : <c:out value="${cardDetails.cardNumber}" /></p>
                                        <br />
                                        <p>Security code : <c:out value="${cardDetails.cvc}" /></p>
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title"> <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"><span id="title"> Delivery address</span> </a> </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                    <div class="panel-body">
                                        <p>${deliveryAddress.firstLine}</p>
                                        <br />
                                        <p>${deliveryAddress.secondLine}</p>
                                        <br />
                                        <p>${deliveryAddress.town}</p>
                                        <br />
                                        <p>${deliveryAddress.postcode}</p>
                                        <br />
                                        <p>home : ${deliveryAddress.landline}</p>
                                        <br />
                                        <p> mobile : ${deliveryAddress.mobile}</p>
                                        <br />
                                        <br />
                                        <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#delivery-address"> <span class="glyphicon glyphicon-hdd"></span> CHANGE ADDRESS </button>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingThree">
                                    <h4 class="panel-title"> <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree"> <span id="title">Billing address</span> </a> </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                    <div class="panel-body">
                                        <p>${billingAddress.firstLine}</p>
                                        <br />
                                        <p>${billingAddress.secondLine}</p>
                                        <br />
                                        <p>${billingAddress.town}</p>
                                        <br />
                                        <p>${billingAddress.postcode}</p>
                                        <br />
                                        <p>home : ${billingAddress.landline}</p>
                                        <br />
                                        <p> mobile : ${billingAddress.mobile}</p>
                                        <br />
                                        <br />
                                        <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#billing-address"> <span class="glyphicon glyphicon-hdd"></span> CHANGE ADDRESS </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="/WEB-INF/jsp/template/footer.jsp" />
        </div>

        <!-- modal for changing the addresses -->

        <div class="modal fade" id="delivery-address" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Change your delivery address</h4>
                    </div>
                    <div class="modal-body">
                        <form action="<c:url value="/register-address" />" method="get" id="account-creation_form" class="std box">
                            <div class="account_creation"> 
                                <div class="required form-group">
                                    <label for="address">Address <sup>*</sup></label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="first_line" type="text" required>
                                </div>
                                <div class="required form-group">
                                    <label for="address_line2">Address (line2) </label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="second_line" type="text">
                                </div>
                                <div class="required form-group">
                                    <label for="city">City <sup>*</sup></label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="city" type="text" required>
                                </div>
                                <div class="required form-group">
                                    <label for="postcode">Postcode <sup>*</sup></label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="postcode" type="text" required>
                                </div>
                                <div class="required form-group">
                                    <label for="country">Country (we deliver only in UK at the moment)</label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="country1" type="text" value="United Kingdom" disabled>
                                    <input type="hidden" name="country" value="United Kingdom" />
                                </div>
                                <div class="required form-group">
                                    <label for="mobile">Mobile phone <sup>**</sup></label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="mobile" type="text" required>
                                </div>
                                <div class="required form-group">
                                    <label for="landline">Home phone <sup>**</sup></label>
                                    <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="landline" type="text"  required>
                                </div>
                            </div>
                    </div>
                    <div id="submit-button" class="submit clearfix"> <span class="icon-input-btn"><span class="glyphicon glyphicon-floppy-save"></span>
                            <input type="hidden" name="address" value="delivery" />
                            <input type="hidden" name="page-origin" value="my-account" />
                            <input type="submit" class="btn btn-success btn-md" value="SAVE">
                        </span> </div>
                    </form>
                </div>
                <br />
                <div class="modal-footer"> </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="billing-address" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Change your billing address</h4>
                </div>
                <div class="modal-body">
                    <form action="<c:url value="/register-address" />" method="get" id="account-creation_form" class="std box">
                        <div class="account_creation">
                            <div class="required form-group">
                                <label for="address">Address <sup>*</sup></label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="first_line" type="text" required>
                            </div>
                            <div class="required form-group">
                                <label for="address_line2">Address (line2) </label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="second_line" type="text">
                            </div>
                            <div class="required form-group">
                                <label for="city">City <sup>*</sup></label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="city" type="text" required>
                            </div>
                            <div class="required form-group">
                                <label for="postcode">Postcode <sup>*</sup></label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="postcode" type="text" required>
                            </div>
                            <div class="required form-group">
                                <label for="country">Country (we deliver only in UK at the moment)</label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="country1" type="text" value="United Kingdom" disabled>
                                <input type="hidden" name="country" value="United Kingdom" />
                            </div>
                            <div class="required form-group">
                                <label for="mobile">Mobile phone <sup>**</sup></label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="mobile" type="text" required>
                            </div>
                            <div class="required form-group">
                                <label for="landline">Home phone <sup>**</sup></label>
                                <input class="is_required validate form-control" data-validate="isName" id="customer_lastname" name="landline" type="text"  required>
                            </div>
                        </div>
                </div>
                <div id="submit-button" class="submit clearfix"> <span class="icon-input-btn"><span class="glyphicon glyphicon-floppy-save"></span>
                        <input type="hidden" name="address" value="billing" />
                        <input type="hidden" name="page-origin" value="my-account" />
                        <input type="submit" class="btn btn-success btn-md" value="SAVE">
                    </span> </div>
                </form>
            </div>
            <br />
            <div class="modal-footer"> </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
