<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- import head-content.jsp -->
        <c:import url="/WEB-INF/jsp/template/head-content.jsp" />
    </head>
    <body>
        <div id="page">
            <!-- import header.jsp -->
            <c:import url="/WEB-INF/jsp/template/header.jsp" />
            <div id="choose" class="container">
                <div class="row">
                    <div class="col-mid-12"> <a href="<c:url value="/home?page=kids-books" />" class="btn btn-primary btn-lg btn-block active" role="button">Books for Children</a> <a href="<c:url value="/home?page=professional-books" />" class="btn btn-primary btn-lg btn-block active" role="button">Books for Programming</a> </div>
                </div>
            </div>
            <!-- import footer.jsp -->
            <c:import url="/WEB-INF/jsp/template/footer.jsp" />
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
        <!-- Include all compiled plugins (below), or include individual files as needed --> 
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>