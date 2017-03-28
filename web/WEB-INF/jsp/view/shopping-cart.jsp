<!DOCTYPE html >
<html lang="en">
    <head>
        <c:import url="/WEB-INF/jsp/template/head-content.jsp" />
        <link href="resources/css/cart.css" rel="stylesheet" type="text/css">
        <link href="resources/css/books.css" rel="stylesheet" type="text/css">

        <style type="text/css">
            .icon-input-btn{
                display: inline-block;
                position: relative;
            }
            .icon-input-btn input[type="submit"]{
                padding-right: 2em;
                float:right;
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
            <div id="cart-block" class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-10 col-md-offset-1">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${fn:length(listItems) == 0}">
                                    <div class="alert alert-danger" role="alert">YOUR SHOPPING CART IS EMPTY</div>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${listItems}" var="shoppingCartItem">
                                        <tr>
                                            <td class="col-sm-8 col-md-6"><div class="media"> <a class="thumbnail pull-left" href="#"> <img class="media-object" src="resources/images/<c:out value="${shoppingCartItem.itemID}" />.jpg" style="width: 72px; height: 72px;"> </a>
                                                    <div class="media-body">
                                                        <h4 class="media-heading"><a href="#"><c:out value="${shoppingCartItem.itemID}" /></a></h4>
                                                        <h5 class="media-heading"> Title : <a href="#"><c:out value="${shoppingCartItem.itemTitle}" /></a></h5>
                                                        <span>Status: </span><span class="text-success"><strong>In Stock</strong></span> </div>
                                                </div></td>
                                        <form method="post" action="<c:url value="/updateOrder" />">
                                            <td class="col-sm-1 col-md-1" style="text-align: center"><input type="number" class="form-control" name="numNewOrder" value="<c:out value="${shoppingCartItem.numProducts}" />" required="true"></td>
                                            <td class="col-sm-1 col-md-1 text-center" style="font-size:24px"><strong>£<c:out value="${shoppingCartItem.singleItemPrice}" /></strong></td>
                                            <td class="col-sm-1 col-md-1 text-center"style="font-size:28px"><strong>£<c:out value="${shoppingCartItem.subtotalAmount}" /></strong></td>
                                            <input type="hidden" name="itemID" value="<c:out value="${shoppingCartItem.itemID}" />">
                                            <td class="col-sm-1 col-md-1">
                                                <span id="success-button" class="icon-input-btn"><span class="glyphicon glyphicon-refresh"></span>
                                                    <input type="submit" class="btn btn-success btn-md" value=" UPDATE " />
                                                </span>
                                        </form>
                                        <form method="post" action="<c:url value="/removeOrder" />">
                                            <input type="hidden" name="itemID" value="<c:out value="${shoppingCartItem.itemID}" />">
                                            <span id="remove-button" class="icon-input-btn"><span class="glyphicon glyphicon-trash"></span>
                                                <input type="submit" class="btn btn-danger btn-md" value=" Remove " />
                                            </span>
                                        </form>
                                        </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><h3>Total</h3></td>
                                <td class="text-right"style="font-size:32px"><strong>£<c:out value="${totalCost}" /></strong></td>
                            </tr>
                            <c:if test="${fn:length(listItems) != 0}">
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><a href="index.jsp" type="button" class="btn btn-warning"> <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping</a></td>
                                <td><a href="<c:url value="/checkout?processing=address" />" type="button" class="btn btn-success"> <span class="glyphicon glyphicon-play"></span> Checkout</a></td>
                            </tr>
                            </c:if>
                            </tbody>
                        </table>
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