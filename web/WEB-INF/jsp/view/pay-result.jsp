<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="refresh" content="4; URL=http://localhost:8080/booksonline/cleanup">
        <title>BooksOnline</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Playball|Alfa+Slab+One|Pinyon+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Playball|Alfa+Slab+One|Pinyon+Script|Oswald|Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>

        <style>
            body , .alert-warning {
                /*background-color: #C7CDB2;*/
            }
            .container-fluid {
            	/*background-color: #C7CDB2;*/
                font-size:28px;
                text-align:center;
                vertical-align: middle;
                margin-top: 28px;
            }
            i{
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
    <div class="container-fluid">
        <c:choose>
            <c:when test="${paymentStatus}">
                <i class="fa fa-check fa-2x"></i>
                <h1 style:"color:green">PAYMENT WAS SUCCESSFUL !!!! </h1>
            </c:when>
            <c:otherwise>
                <i class="fa fa-times fa-2x"></i>
                <h1 style:"color:red">PAYMENT FAILED !!!! </h1>
            </c:otherwise>
        </c:choose>
        </div>
    </body>
</html>
