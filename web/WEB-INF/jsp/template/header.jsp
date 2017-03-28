
<div class="container">
    <div class="row">
        <div class="col-md-12"> <img class="banner" src="resources/images/banner1.jpg"> </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-1">
            <h3 id="logo">BooksOnline</h3>
        </div>
    </div>
    <div class="row">
        <c:choose>
            <c:when test="${homeButton}">
                <div class="col-md-6 col-md-offset-7">
                </c:when>
                <c:otherwise>
                    <div class="col-md-6 col-md-offset-8">
                    </c:otherwise>
                </c:choose>
                <div id="headerLinks">
                    <c:if test="${homeButton}">
                        <a id="home-button" href="<c:url value="/home?page=menu" />" style="color: #C88810">HOME</a>
                    </c:if>
                    <c:choose>
                        <c:when test="${logged}">
                            <div class="btn-group show-on-hover">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown" style="color: #C88810"><c:out value="${name}" /> <b class="caret"></b></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="<c:url value="/my-account?page=personal" />"><span id="menu-item"><i class="fa fa-folder-open-o"></i>
                                                My Account</span></a></li>
                                    <li><a href="<c:url value="/my-account?page=orders" />"><span id="menu-item"><i class="fa fa-truck"></i>
                                                My Orders</span></a></li>
                                    <li class="divider"></li>
                                    <li><a href="<c:url value="/logout" />"><span style="color:red"><i class="fa fa-sign-out"></i>
                                                LOGOUT</span></a></li>
                                </ul>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/home?page=authentication" />" title="Login/Register" style="color: #C88810">Login/Register</a>
                        </c:otherwise>
                    </c:choose>
                            <a href="<c:url value="/home?page=shopping-cart" />" title="cart"><img src="resources/images/cart3.png"><span style="color:#C88810"><c:out value="${numberOfProducts}" /></span></a></div>
            </div>
        </div>
        <c:if test="${probooks}">
            <div class="row">
                <div class="col-md-12">
                    <div id="headerSection">
                        <h3 id="head">Books for programmers of any professional levels</h3>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
