<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   	<ul class="list-group list-group-flush">
            <li>
                <div class="list-group-item bg-light">
                	<form id="search-form" action="ViewController?index=1" method="POST">
                    	<div class="input-group">
                       		<input class="form-control my-0 py-1 " type="text" placeholder="Search..." aria-label="Search" name="txtSearch" id="txtSearch">
                        	<div class="input-group-append">
                            	<button class="input-group-text btn btn-light" type="submit"><i class="fas fa-search text-grey" aria-hidden="true"></i></button>
                        	</div>
                    	</div>
                	</form>
                </div>
            </li>
            <li>
                <a id="viewcontent" href="#" data-id_user="${loginUserId}"
                    class="list-group-item list-group-item-action bg-light ">
                    <i class="fas fa-table"></i> View contents</a>
            </li>
            <li>
                <a href="addContent.tiles" class="list-group-item list-group-item-action bg-light ">
                    <i class="fas fa-edit"></i> Form content</a>
            </li>
            <li class="list-group-item bg-light"></li>
        </ul>

</body>
</html>