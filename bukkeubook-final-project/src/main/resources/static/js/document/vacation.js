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
		//let empNo = $("#empNo1").val();
		$.ajax({
			url: "/document/empInfo/",
			success: function(data) {
				console.log(data.empName);
				console.log(data.deptName);
				console.log(data.empJobCode);
				console.log(data);

				$("#writer2").text(data.empName);
				$("#dept2").text(data.deptName);
				$("#empJobCode").text(data.empJobCode);
			},
			error: function(error) {
				console.log(error);
			}
		});
	});

	$(function() {
		$.ajax({
			url: "/document/vacationInfo/",
			success: function(data) {
				console.log(data);
				console.log(data[0]);
				console.log(data[2]);
				console.log(data[3]);

				let memo = "총연차 : " + data[2] + " / 잔여연차 : " + data[3];
				console.log(memo);
				$("#no").text(data[0]);
				$("#dayoffMemo").text(memo);
				$("#dayoffRemain").val(data[3]);

			},
			error: function(error) {
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

	let reason = $("#reasonWrite").text();
	console.log(reason);
	$("#reason").val(reason);

	Swal.fire({
		title: '휴가신청',
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

			let start = $("#startDate").val();
			let end = $("#endDate").val();


			let startArr = start.split('-');
			let endArr = end.split('-');
			let today = new Date();

			let startDateCompare = new Date(startArr[0], parseInt(startArr[1]) - 1, parseInt(startArr[2]));
			let endDateCompare = new Date(endArr[0], parseInt(endArr[1]) - 1, parseInt(endArr[2]));

			let getDateDiff = (d1, d2) => {
				let date1 = new Date(d1);
				let date2 = new Date(d2);
				let date3 = new Date(date2);
				
				date3.setDate(date2.getDate() + 1);

				let diffDate = date1.getTime() - date3.getTime();
				
				console.log(diffDate);

				return Math.abs(diffDate / (1000 * 60 * 60 * 24)); // 밀리세컨 * 초 * 분 * 시 = 일
			}

			let startDate = $("#startDate").val();
			let endDate = $("#endDate").val();

			console.log(getDateDiff(startDate,endDate));
			
			if(today > startDateCompare){
				Swal.fire({
					icon: 'warning',
					title: '신청날짜 확인',
					text: '금일 이후로 다시 작성해주세요.'
				})
			} else { countCheck++; }
			
			if(getDateDiff(startDate,endDate) > $("#dayoffRemain").val()){
				console.log("nooooooooo");
				Swal.fire({
					icon: 'warning',
					title: '잔여연차 초과',
					text: '확인 후 다시 작성해주세요.'
				})
			} else { countCheck++; }


			if (startDateCompare.getTime() > endDateCompare.getTime()) {
				Swal.fire({
					icon: 'warning',
					title: '신청날짜 오류',
					text: '시작 날짜와 종료 날짜를 확인해 주세요.'
				})
				$("#startDay").focus();
			} else { countCheck++; }

			if ($("#startDate").val().length < 1 || $("#startDate").val() == "" || $("#startDate").val() == "  ") {
				Swal.fire({
					icon: 'warning',
					title: '신청날짜 입력',
					text: '신청 시작일을 입력해주세요.'
				})
			} else { countCheck++; }

			if ($("#endDate").val().length < 1 || $("#endDate").val() == "" || $("#endDate").val() == "  ") {
				Swal.fire({
					icon: 'warning',
					title: '신청날짜 입력',
					text: '신청 종료일을 입력해주세요.'
				})
			} else { countCheck++; }

			if ($("#reason").val().length < 1 || $("#reason").val() == "" || $("#reason").val() == "  ") {
				Swal.fire({
					icon: 'warning',
					title: '신청 사유가 없습니다',
					text: '사유를 입력해주세요.'
				})
			} else { countCheck++; }

			if($("#reason").val().length > 30){
				Swal.fire({
						icon: 'warning',
						title: '글자수 초과',
						text: '30자 내로 작성해주세요.'
					})
			} else { countCheck++; }

			if ($("#num2").val() == "" && $("#num2").val().length < 1 && $("#num3").val() == "" && $("#num3").val().length < 1) {
				Swal.fire({
					icon: 'warning',
					title: '연락처 입력',
					text: '연락처를 입력해주세요.'
				})
			} else { countCheck++; }

			if (!(Number($("#num2").val()) && Number($("#num3").val()))) {
				Swal.fire({
					icon: 'warning',
					title: '연락처 입력',
					text: '연락처를 숫자로 입력해주세요.'
				})
			} else { countCheck++; }

			if (countCheck == 9) {
				$("#submitReport").submit();
			}

		}
	})

}



