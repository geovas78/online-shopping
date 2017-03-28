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
                <div class="col-md-4">
                    <div class="productbox"> <img src="resources/images/lewis001.jpg" class="img-responsive">
                        <div class="producttitle">The Chronicles of Narnia</div>
                        <p class="text-justify">The classic children's adventure pitting Aslan the Great Lion and his followers against the White Witch and the forces of evil. Dragons, magicians, quests, and talking animals wound around a deep spiritual allegory. Series includes The Magician's Nephew, The Lion, the Witch and the Wardrobe, The Horse and His Boy, Prince Caspian, The Voyage of the Dawn Treader, The Silver Chair, and The Last Battle.</p>
                        <div class="productprice">
                            <div class="pull-right">
                                <form method="post" action="<c:url value="/addItem" />">
                                    <input type="hidden" name="itemID" value="lewis001" />
                                    <input type="hidden" name="pageOrigin" value="kids">
                                    <span class="icon-input-btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                                        <input type="submit" class="btn btn-primary btn-md" value="Add to" />
                                    </span>
                                </form>
                            </div>
                            <div class="pricetext">£ 19.95</div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="productbox"> <img src="resources/images/alexander001.jpg" class="img-responsive">
                        <div class="producttitle">The Prydain</div>
                        <p class="text-justify">Humble pig-keeper Taran joins mighty Lord Gwydion in his battle against Arawn the Lord of Annuvin. Joined by his loyal friends the beautiful princess Eilonwy, wannabe bard Fflewddur Fflam,and furry half-man Gurgi, Taran discovers courage, nobility, and other values along the way. Series includes The Book of Three, The Black Cauldron, The Castle of Llyr, Taran Wanderer, and The High King.</p>
                        <div class="productprice">
                            <div class="pull-right">
                                <form method="post" action="<c:url value="/addItem" />">
                                    <input type="hidden" name="itemID" value="alexander001">
                                    <input type="hidden" name="pageOrigin" value="kids">
                                    <span class="icon-input-btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                                        <input type="submit" class="btn btn-primary btn-md" value="Add to">
                                    </span>
                                </form>
                            </div>
                            <div class="pricetext">£ 15.45</div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="productbox"> <img src="resources/images/rowling001.jpg" class="img-responsive">
                        <div class="producttitle">Harry Potter</div>
                        <p class="text-justify">The first five of the popular stories about wizard-in-training Harry Potter topped both the adult and children's best-seller lists. Series includes Harry Potter and the Sorcerer's Stone, Harry Potter and the Chamber of Secrets, Harry Potter and the Prisoner of Azkaban, Harry Potter and the Goblet of Fire, and Harry Potter and the Order of the Phoenix..</p>
                        <div class="productprice">
                            <div class="pull-right">
                                <form method="post" action="<c:url value="/addItem" />">
                                    <input type="hidden" name="itemID" value="rowling001">
                                    <input type="hidden" name="pageOrigin" value="kids">
                                    <span class="icon-input-btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                                        <input type="submit" class="btn btn-primary btn-md" value="Add to">
                                    </span>
                                </form>
                            </div>
                            <div class="pricetext">£ 47.85</div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="bottom" class="container">
                <div class="row">
                    <div class="col-md-12">
                        <marquee behavior="scroll" scrollamount="2" direction="left">More interesting children's books on the way soon....</marquee>
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