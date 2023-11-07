window.onload = function() {
	
	$("#reasonWrite").keyup(function(){
		let checklength = $("#reasonWrite").text();
		$("#reason").val(checklength);
		
		console.log($("#reason").val().length);
		if($("#reason").val().length > 30){
			Swal.fire({
					icon: 'warning',
					title: '글자수 초과',
					text: '30자 내로 작성해주세요.'
				})
		}
	})
	
	$(function() {
		$.ajax({
			url: "/document/vacationList",
			success: function(data) {
				console.log(data);
				console.table(data);
				
				const $vacationList = $("#vacationList");

				if(data.length == 0){
					$vacationList.append($("<option>").val("").text("신청한 휴가신청서가 없습니다."));
				}else{
					
					for (let index in data) {
						
						let vacNo = data[index].vacNo;
						let vacStartDate = data[index].vacStartDate;
						let vacEndDate = data[index].vacEndDate;
						let option = "문서: " + vacNo +"/신청기간: "+vacStartDate +" ~ " +vacEndDate;
						
						$vacationList.append($("<option>").val(data[index].vacNo).text(option));
					}
				}
				

			},
			error: function(error) {
				console.log(error);
			}
		});
	});
	
	$(function(){
		$.ajax({
			url:"/document/vacationInfo/",
			success: function(data){
				console.log(data);
				console.log(data[1]);
				
				$("#no").text(data[1]);
			},
			error: function(error){
				console.log(error);
			}
		});
	});
	
	$(function(){
		//let empNo = $("#empNo1").val();
		$.ajax({
			url:"/document/empInfo/",
			success: function(data){
				//console.log(data.empName);
				//console.log(data.deptName);
				//console.log(data.empJobCode);
				//console.log(data);
				
				$("#writer2").text(data.empName);
				$("#dept2").text(data.deptName);
				$("#empJobCode").text(data.empJobCode);
			},
			error: function(error){
				console.log(error);
			}
		});
	});
	
	

	$(document).ready(function() {
		let now = new Date();
		// $("h6").text(now); //전체

		let year = now.getFullYear();//연도
		let month = now.getMonth() + 1;//월
		let date = now.getDate();//일

		let todayString = now.getFullYear() + "-";
		let todayMonth = now.getMonth() + 1;
		if (todayMonth < 10) {
			todayString += "0";
		}
		todayString += todayMonth + "-";
		let todayDate = now.getDate();
		if (todayDate < 10) {
			todayString += "0";
		}
		todayString += todayDate;

		$("#date2").text(todayString);
		$("#date").val(todayString);
	});

	$("#back").click(function() {
		Swal.fire({
			title: '작성내용이 모두 사라집니다.',
			text: "진행 하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				window.history.back();
			}
		})
	})



}

function sendData() {
	
	let phone = $("#num1 option:selected").val() + " - " + $("#num2").val() + " - " + $("#num3").val();
	$("#phone").val(phone);
	console.log(phone);
	
	let vacNo = $("#vacationList option:selected").val();
	$("#vaca").val(vacNo);
	
	let reason = $("#reasonWrite").text();
	console.log(reason);
	$("#reason").val(reason);
	
	Swal.fire({
			title: '휴가취소신청',
			text: "작성하신 문서를 신청 하시겠습니까?",
			icon: 'question',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				
				let countCheck = 0;
				
				let vaca = $("#vaca").val();
					
				if ($("#vaca").val().length < 1 || $("#vaca").val() == "" || $("#vaca").val() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '취소 서류 선택',
						text: '취소할 신청 서류를 선택해주세요.'
					})
				} else{countCheck++;}
				
				if ($("#reason").val().length < 1 || $("#reason").val() == "" || $("#reason").val() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '신청 사유가 없습니다',
						text: '사유를 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($("#reason").val().length > 30 ) {
					Swal.fire({
						icon: 'warning',
						title: '글자수 초과',
						text: '30자 내로 작성해주세요.'
					})
				} else{countCheck++;}
				
				if(countCheck == 3) {
					$("#submitReport").submit();
				}
				
			}
	})

}



