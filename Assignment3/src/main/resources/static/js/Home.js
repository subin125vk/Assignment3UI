/*	var gender;
	$(document).ready(function(){
		alert("AAAABBBCCCC");
		$.ajax({ 	
		type: "GET",
	      url: "/listdetails",      
	      success: function (data) {
	    	  $('#gender').append("<option value="+data.genderid+">"+data.name+"</option>");
	    	  
		$("#genderid").html(genderid);}
	});		
	});		
	
	*/

//$(document).ready(function(){
//genderFn();
//alert("ABCCC")
//});
//function genderFn(){
//	var gender;
//	$.ajax({
//		type: "GET",
//		url: "/listgenderdetails",
//		success: function(data) {
//			var gender = ("#genderid");
//			alert(data.length);
//			for (var i = 0; i < data.length; i++) {
//				$(gender).append("<option id=" + data[i].genderid + "value=" + data[i].name + ">"  "</option>");
//			}
//		}
//	});
//}



	$(document).ready(function(){
		alert("AAAABBBCCCC");
		genderFn();
		saveSalutation();
	});	
	function genderFn() {
		var gender;
			$.ajax({ 	
			type: "GET",
		    url: "/listgenderdetails",      
		    success: function (data) {
	    	  for (var i=0;i<data.length;i++) {
		    	  gender+=("<option value="+data[i].genderid+">"+data[i].name+"</option>"); 	  
		    	  $("#genderid").html(gender);
		    	  }
		    }
		    });	
		}
	 function saveSalutation(){
       
         $("#savebtn").click(function () {
        	  var salutation = {};
             salutation.code = $("#code").val();
             salutation.name = $("#name").val();
             salutation.genderid = $("#genderid").val();
             salutation.activeyn = $("input[name='activeyn']:checked").val();
             alert($("#code").val());
             alert($("#name").val());
             alert($("#genderid").val());
             alert($("#activeyn").val());
             alert($(salutation));

            
             $.ajax({
                 url: "/addSalutation",
                 type: "POST",
                 contentType: "application/json; charset=utf-8",
                 data:salutation,
                 success: function (data) {
                     alert("Saved successfully!");
                 },
                 error: function (error) {
                     alert(error);
                 }
             })  
         }); 
         
	 }
   
/*$(document).ready(function () {
var book = {};
$('#btnAddBook').click(function () {
                 book.title = $('#txtName').val();
                 book.author = $('#txtAuthor').val();
                 var bookJSON = JSON.stringify(book);
                 $.ajax({
                     url: 'http://localhost:8037/spring-mvc-restfull-crud-example/book',
                     method: 'POST',
                     data: bookJSON,
                     contentType: "application/json; charset=utf-8",
                     success: function () {
                         alert('Saved successfully!');
                     },
                     error: function (error) {
                         alert(error);
                     }
                 })  
             })
         });  */      
         
