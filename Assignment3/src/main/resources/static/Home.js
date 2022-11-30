var gender;
$(document).ready(function()){
	$("#gender_id").on("change",function(){
		var gender_id=$("#gender_id").val();		
	$.ajax({   
	      url: "/listdetails",
	      data: {genderid:genderid},
	      method:"GET,"
	      /*contentType: "application/json",*/
	      success: function (data) {
	         /*let obj = $.parseJSON(data);
	         $.each(obj, function (key, value) {*/
	            $('#gender').append('<option value="' + value.genderid + '">' + value.genderid + '--' + value.genderid + '</option>');
	         });
	      }
	  
}}
	}



/*
$.ajax({
    type: "GET",
    url: "/listdetails",
    data: "json",
    contentType: "application/json",
    success: function (data) {
       let obj = $.parseJSON(data);
       $.each(obj, function (key, value) {
          $('#gender').append('<option value="' + value.genderid + '">' + value.genderid + '--' + value.genderid + '</option>');
       });
    }

}
}*/