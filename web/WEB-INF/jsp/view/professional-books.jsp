<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/jsp/template/head-content.jsp" />
<link href="resources/css/books.css" rel="stylesheet" type="text/css">

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
    <c:if test="${itemAdded}">
        <div class="container">
            <div calss="row">
                <div class="col-mid-6">
                    <div class="alert alert-success" role="alert">NEW ITEM HAS BEEN ADDED TO YOUR SHOPPING CART</div>
                </div>
            </div>
        </div>
    </c:if>
  <div id="books-display" class="container">
    <div class="col-md-3">
      <div class="productbox"> <img src="resources/images/hall002.jpg" class="img-responsive">
        <div class="producttitle">Core Web Programming</div>
        <p class="text-justify">One stop shopping for the Web programmer. Topics include Thorough coverage of Java 2; including Threads, Networking, Swing, Java 2D, RMI, JDBC, and Collections A fast introduction to HTML 4.01, including frames, style sheets, and layers. A fast introduction to HTTP 1.1, servlets, and JavaServer Pages. A quick overview of JavaScript 1.2 </p>
        <div class="productprice">
            <div class="pull-right">
                <form method="post" action="<c:url value="/addItem" />">
                  <input type="hidden" name="itemID" value="hall002">
                  <input type="hidden" name="pageOrigin" value="pro">
              <span class="icon-input-btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                  <input type="submit" class="btn btn-primary btn-md" value="Add to">
              </span>
              </form>
            </div>
          <div class="pricetext">£ 27.65</div>
        </div>
      </div>
    </div>
    <div class="col-md-3">
      <div class="productbox"> <img src="resources/images/hall001.jpg" class="img-responsive">
        <div class="producttitle">Core Servlets and JSP</div>
        <p class="text-justify">The definitive reference on servlets and JSP from Prentice Hall and Sun Microsystems Press. Nominated for the Nobel Prize in Literature. The second edition of this book delves deeper into the MVC technology, Web Security and some third party tools for creating an outstanding dynamic web pages. Basics in using Maven as Relational Object Mapping.</p>
        <div class="productprice">
            <div class="pull-right">
                <form method="post" action="<c:url value="/addItem" />">
                  <input type="hidden" name="itemID" value="hall001">
                  <input type="hidden" name="pageOrigin" value="pro">
              <span class="icon-input-btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                  <input type="submit" class="btn btn-primary btn-md" value="Add to">
              </span>
              </form>
            </div>
          <div class="pricetext">£ 48.59</div>
        </div>
      </div>
    </div>
    <div class="col-md-3">
      <div class="productbox"> <img src="resources/images/hall003.jpg" class="img-responsive">
        <div class="producttitle">Java Networking</div>
        <p class="text-justify">The must have book about applying Java Technologies into networking.
        <br>
        <br>
        All you need to know about client - server communication.
        <br>
        Sockets, TCP, I/O, UDP, HTTP tunneling, Firewalls, SSL, Scalability and much more.
        <br>
        <br>Algorithms and problem solutions.</p>
        <div class="productprice">
            <div class="pull-right">
                <form method="post" action="<c:url value="/addItem" />">
                  <input type="hidden" name="itemID" value="hall003">
                  <input type="hidden" name="pageOrigin" value="pro">
              <span class="icon-input-btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                  <input type="submit" class="btn btn-primary btn-md" value="Add to">
              </span>
              </form>
            </div>
          <div class="pricetext">£ 34.99</div>
        </div>
      </div>
    </div>
    <div class="col-md-3">
      <div class="productbox"> <img src="resources/images/java-ee.jpg" class="img-responsive">
        <div class="producttitle">Java EE Development With WildFly</div>
        <p class="text-justify"><img src="resources/images/coming-soon.jpg" class="img-responsive"></p>
        <div class="productprice">
          <div class="pull-right"><a href="#" class="btn btn-danger btm-sm" role="button">Not in stock <i class="fa fa-times"></i></a></div>
          <div class="pricetext">£ 47.85</div>
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
