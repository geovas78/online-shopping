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
            table {
                border: none;
            }
            #thead{
                color:#06C;
                font-weight:bold;
            }
            th, td {
                border: none;
                background-color: #dddddd;
                padding: 5px;
                width: 170px;
            }
        </style>
    </head>
    <body>
        <div id="page">
            <c:import url="/WEB-INF/jsp/template/header.jsp" />
            <div class="container">
                <div class="row">
                    <div id="authen-head" class="col-md-12 col-xs-12">
                        <h2>YOUR ORDERS</h2>
                        <hr style="border-color:#000000">
                    </div>
                </div>
            </div>
                <hr />
                <hr />
                <div id="my-account" class="container">
                    <div class="row">
                        <div class="col-xsl-8">
                            ${orderList}
                        </div>
                    </div>
                </div>
                <hr />
                <hr />
                <c:import url="/WEB-INF/jsp/template/footer.jsp" />
            </div>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
            <!-- Include all compiled plugins (below), or include individual files as needed --> 
            <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
