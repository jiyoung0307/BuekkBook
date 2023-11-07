window.onload = function() {
	
	$(function(){
		$.ajax({
			url:"/document/findSignName",
			success: function(data){
				console.log(data);
				$("#empSign").val(data[0]);
				console.log($("#empSign").val());
				let empSign = $("#empSign").val();
				
				$("#sign1").append("<img src='/images/sign/" + empSign +  "'style='width: 65px; height:70px;'>");
			},
			error : function(error){
				console.log(error);
			}
		})
	})
	
	$(function(){
		//let empNo = $("#empNo1").val();
		$.ajax({
			url:"/document/empInfo/",
			success: function(data){
				console.log(data.empName);
				console.log(data.deptName);
				console.log(data.docNo);
				console.log(data);
				
				$("#writer2").text(data.empName);
				$("#dept2").text(data.deptName);
				$("#docnumber").text(data.docNo);
			},
			error: function(error){
				console.log(error);
			}
		});
	});
	
	$("#clear").click(function(){
		$("#account1").val("");
		$("#acco1").val("");
		$("#deptName1").val("");
		$("#account2").val("");
		$("#acco2").val("");
		$("#deptName2").val("");
		$("#account3").val("");
		$("#acco3").val("");
		$("#deptName3").val("");
		$("#stepNo").val("");
		$("#step").text("");
		$("#selacc1").text("");
		$("#selacc2").text("");
		$("#selacc3").text("");
		$("#empList option:eq(0)").prop("selected", true);
		$("#empList2 option:eq(0)").prop("selected", true);
		$("#empList3 option:eq(0)").prop("selected", true);
		$("#deptCode option:eq(0)").prop("selected", true);
		$("#deptCode2 option:eq(0)").prop("selected", true);
		$("#deptCode3 option:eq(0)").prop("selected", true);
	})

	$("#empList").change(function(){
		let appro = $(this).val();
		let account = $("#empList option:selected").text();
		let deptName = $("#deptCode option:selected").text();
		console.log(appro);
		console.log(account);
		console.log(deptName);
		
		let approver1 = deptName + "<br>" + account
		$("#account1").val(appro);
		$("#acco1").val(account);
		$("#deptName1").val(deptName);
		$("#selacc1").html(approver1);
	});
	
	$("#empList2").change(function(){
		let appro = $(this).val();
		let account = $("#empList2 option:selected").text();
		let deptName = $("#deptCode2 option:selected").text();
		console.log(appro);
		console.log(account);
		console.log(deptName);
		let approver1 = deptName + "<br>" + account
		$("#account2").val(appro);
		$("#acco2").val(account);
		$("#deptName2").val(deptName);
		$("#selacc2").html(approver1);
	});
	
	$("#empList3").change(function(){
		let appro = $(this).val();
		let account = $("#empList3 option:selected").text();
		let deptName = $("#deptCode3 option:selected").text();
		console.log(appro);
		console.log(account);
		console.log(deptName);
		let approver1 = deptName + "<br>" + account
		$("#account3").val(appro);
		$("#acco3").val(account);
		$("#deptName3").val(deptName);
		$("#selacc3").html(approver1);
	});


	$(function() {
		$.ajax({
			url: "/document/dept",
			success: function(data) {
				/*console.log(data[0].name);
				console.log(data);
				console.table(data);*/

				const $deptCode = $("#deptCode");
				const $deptCode2 = $("#deptCode2");
				const $deptCode3 = $("#deptCode3");

				for (let index in data) {
					$deptCode.append($("<option>").val(data[index].deptCode).text(data[index].deptName));
					$deptCode2.append($("<option>").val(data[index].deptCode).text(data[index].deptName));
					$deptCode3.append($("<option>").val(data[index].deptCode).text(data[index].deptName));
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
	
	$("#deptCode").change(function() {
		let deptValue = $(this).val();
		console.log($(this).val());

		$.ajax({
			url: "/document/emp/" + deptValue,
			success: function(data) {
				//console.log(data[0].empName);
				//console.log(data);
				//console.table(data);

				
				const $empList = $("#empList");

				$empList.text("");
				
				$empList.append($("<option>").val("").text("----"));

				for (let index in data) {
					let jobEmp = data[index].empName +"  "+data[index].empJobCode ;
					$empList.append($("<option>").val(data[index].empNo).text(jobEmp));
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
	$("#deptCode2").change(function() {
		let deptValue = $(this).val();
		console.log($(this).val());

		$.ajax({
			url: "/document/emp/" + deptValue,
			success: function(data) {
				//console.log(data[0].empName);
				//console.log(data);
				//console.table(data);

				const $empList = $("#empList2");

				$empList.text("");
				
				$empList.append($("<option>").val("").text("----"));

				for (let index in data) {
					let jobEmp = data[index].empName +"  "+data[index].empJobCode ;
					$empList.append($("<option>").val(data[index].empNo).text(jobEmp));
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	});
	$("#deptCode3").change(function() {
		let deptValue = $(this).val();
		console.log($(this).val());

		$.ajax({
			url: "/document/emp/" + deptValue,
			success: function(data) {
				//console.log(data[0].empName);
				//console.log(data);
				//console.table(data);

				const $empList = $("#empList3");

				$empList.text("");
				
				$empList.append($("<option>").val("").text("----"));

				for (let index in data) {
					let jobEmp = data[index].empName +"  "+data[index].empJobCode ;
					$empList.append($("<option>").val(data[index].empNo).text(jobEmp));
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	});

	$('.description').summernote({
		height: 500,
		width: 440,
		toolbar: [
			// 표만들기
			['table', ['table']],
			// 글머리 기호, 번호매기기, 문단정렬
			['para', ['ul', 'ol', 'paragraph']],
			// 코드보기, 확대해서보기, 도움말
			['view', ['codeview', 'fullscreen', 'help']]
		],
		callbacks: {
			onKeyup: function(e) {
				setTimeout(function() {
					$("#result").html($('.description').val());
				}, 200);
			}
		}
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
		$("#wrDate1").val(todayString);
		$("#wrDate2").val(todayString);
	});

	$("#title").keyup(function() {
		let title = $("#title").val();
		// console.log(title);
		
		if(title.length > 50){
			Swal.fire({
				icon: 'warning',
				title: '제목 글자수 초과',
				text: '50자 이하로 입력해주세요.'
			})
		}
		
		$("#title2").text(title);
	});

	$("#tempStore").click(function() {
		Swal.fire({
			title: '임시저장',
			text: "작성하신 문서를 임시저장 하시겠습니까?",
			icon: 'question',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				
				let countCheck = 0;

				if ($("#title").val().length < 1 || $("#title").val() == "" || $("#title").val() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '제목이 없습니다',
						text: '문서의 제목을 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($("#title").val().length > 50) {
					Swal.fire({
						icon: 'warning',
						title: '제목 글자수 초과',
						text: '50자 이하로 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($(".note-editable").text().length < 1 || $(".note-editable").text() == "" || $(".note-editable").text() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '내용이 없습니다',
						text: '문서의 내용을 입력해주세요.'
					})
				} else{countCheck++;}
				
				if(countCheck == 3) {
					
				$("#docStatus1").val("임시저장");
				let cnt = $(".description").val();
				console.log(cnt)
				$("#cnttt1").val(cnt);

				let sendDraft = $(".draft").html();
				console.log(sendDraft);
				$("#draftcnt1").val(sendDraft);
				$("#temp").submit();
				
				}				
				
			}
		})
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
	
	Swal.fire({
			title: '결재 상신',
			text: "작성하신 문서를 상신 하시겠습니까?",
			icon: 'question',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				
				let countCheck = 0;
			
				if ($("#title").val().length < 1 || $("#title").val() == "" || $("#title").val() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '제목이 없습니다',
						text: '문서의 제목을 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($("#title").val().length > 50) {
					Swal.fire({
						icon: 'warning',
						title: '제목 글자수 초과',
						text: '50자 이하로 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($("#title").val().length < 5 || $("#title").val().length < 5) {
					Swal.fire({
						icon: 'warning',
						title: '글자 수 부족',
						text: '문서의 제목을 5글자 이상 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($(".note-editable").text().length < 1 || $(".note-editable").text() == "" || $(".note-editable").text() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '내용이 없습니다',
						text: '문서의 내용을 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($(".note-editable").text().length < 10) {
					Swal.fire({
						icon: 'warning',
						title: '글자 수 부족',
						text: '문서의 내용을 10글자 이상 입력해주세요.'
					})
				} else{countCheck++;}
				
				if ($("#stepNo").val() == "") {
					Swal.fire({
						icon: 'warning',
						title: '결재단계 확인',
						text: '단계 지정버튼을 눌러주세요!'
					})
				} else{countCheck++;}
				
				if(countCheck == 6) {
					let sendDraft = $(".draft").html();
					console.log(sendDraft);
					$("#draftcnt2").val(sendDraft);
					$("#docStatus2").val("대기");
					let cnt = $(".description").val();
					console.log(cnt)
					$("#cnttt2").val(cnt);
					$("#docTitle2").val($("#title").val());
					$("#submitReport").submit();
				}
				
			}
	})

}

function selectacc() {
	let stepNo = "";

	if ($("#account1").val() == "") {
		Swal.fire({
			icon: 'warning',
			title: '결재라인 없음',
			text: '최소 결재라인을 지정해주세요!'
		})
	} else if ($("#account2").val() == "" && $("#account3").val() == "") {
		Swal.fire({
			title: '결재라인이 1단계로 \n종료됩니다.',
			text: "맞으시면 확인을 눌러주세요.",
			icon: 'info',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				stepNo = "1";
				$("#stepNo").val(stepNo);
				$("#step").text(stepNo);
				$("#selacc2").text("");
				$("#selacc3").text("");
			}
		})
	} else if ($("#account3").val() == "") {
		Swal.fire({
			title: '결재라인이 2단계로 \n종료됩니다.',
			text: "맞으시면 확인을 눌러주세요.",
			icon: 'info',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				stepNo = "2";
				$("#stepNo").val(stepNo);
				$("#step").text(stepNo);
				$("#selacc3").text("");
			}
		})
	} else {
		Swal.fire({
			title: '결재라인이 3단계로 \n종료됩니다.',
			text: "맞으시면 확인을 눌러주세요.",
			icon: 'info',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				stepNo = "3";
				$("#stepNo").val(stepNo);
				$("#step").text(stepNo);
			}
		})
	}
}



