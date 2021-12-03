/**
 * 
 */

$(document).ready(function () {
	let activePage = $("#activePage").attr("value");
	$("#"+activePage).addClass("active");
	
    //Load data
    function fetch_data(txtSearch) {
        $.ajax({
            url: "/Final_Project/ViewController",
            type: "POST",
			data: {index:1, txtSearch: txtSearch},
			success: function(data) {
				window.location.href = "http://localhost:8080/Final_Project/ViewController?index=1&txtSearch=" + txtSearch;
				
			}
        });
    }

    //Get all content
    $("#viewcontent").on("click", function (e) {
        e.preventDefault();
		let txtSearch = "";
		$(".bodyContent").html("<h3>Loading...</h3>")
        setTimeout(function () {
          	window.location.href = "http://localhost:8080/Final_Project/ViewController?index=1&txtSearch=" + txtSearch;
        }, 5000);
    });


    //Delete content
    $(".delcontent").on("click", function (e) {
        e.preventDefault();
        let id = $(this).data("id_xoa");
		let txtSearch = $(this).attr("href");
        $.ajax({
                url: "/Final_Project/delete",
                type: "POST",
                data: { id: id },
                success: function (data) {
                    alert("Delete success!");
                    fetch_data(txtSearch);
                }
        });

    });

    //Update content
    $("#update-form").on("submit", function (e) {
        e.preventDefault();
		let url_string = window.location.href;
		let url = new URL(url_string);
		let txtSearch = url.searchParams.get("txtSearch");
		console.log(txtSearch);
        let data = $("#update-form").serialize();
        $.ajax({
            url: "/Final_Project/update",
            type: "POST",
            data: data,
            success: function (data) {
				alert("Update success!");
                fetch_data(txtSearch);
               
            }
        });
    });



	$("#add-form").on("submit", function (e) {
        alert("Add content success!");
    });

	$("#updateProfile-form").on("submit", function (e) {
	        alert("Update you info success!");
	});
	


});