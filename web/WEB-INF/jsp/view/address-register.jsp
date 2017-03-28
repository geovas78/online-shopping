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
                        <h2><c:out value="${kindOfAddress}" /></h2>
                        <hr style="border-color:#000000">
                    </div>
                </div>
                <div class="row">
                    <div id="form-block" class="col-sm-8">
                        <p>FILL UP THE FORM FOR <c:out value="${kindOfAddress}" /></p>
                        <hr style="border-color:#000000">
                        <div style="display: block;" id="noSlide">


                            <!---->
                            <form method="post" action="<c:url value="${direction}" />" id="account-creation_form" class="std box">
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
                                <div class="submit clearfix">
                                    <span class="icon-input-btn"><span class="glyphicon glyphicon-floppy-save"></span>
                                        <input type="submit" class="btn btn-success btn-md" value="SAVE">
                                    </span>
                                </div>
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
