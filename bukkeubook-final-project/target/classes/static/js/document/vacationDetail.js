window.onload = function() {
	
	$("#back").click(function() {
		window.history.back();
	})

	$(function(){
		//let empNo = $("#empNo1").val();
		//console.log(empNo);
		$.ajax({
			url:"/document/empInfo/" ,
			success: function(data){
				console.log(data.empName);
				console.log(data.deptName);
				console.log(data.empJobCode);
				console.log(data);
				
				$("#writer2").text(data.empName);
				$("#dept2").text(data.deptName);
				$("#empJobCode").text(data.empJobCode);
			},
			error: function(error){
				console.log(error);
			}
		});
	});


}





