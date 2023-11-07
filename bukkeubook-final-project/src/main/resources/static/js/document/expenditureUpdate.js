window.onload = function() {

	$(function() {
		//let empNo = $("#empNo1").val();
		$.ajax({
			url: "/document/empInfo/",
			success: function(data) {
				console.log(data.empName);
				console.log(data.deptName);
				console.log(data.docNo);
				console.log(data);

				$("#writer2").text(data.empName);
				$("#dept2").text(data.deptName);
				$("#docnumber").text(data.docNo);
			},
			error: function(error) {
				console.log(error);
			}
		});
	});

	$("#clear").click(function() {
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

	$("#empList").change(function() {
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

	$("#empList2").change(function() {
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

	$("#empList3").change(function() {
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
					let jobEmp = data[index].empName + "  " + data[index].empJobCode;
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
					let jobEmp = data[index].empName + "  " + data[index].empJobCode;
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
					let jobEmp = data[index].empName + "  " + data[index].empJobCode;
					$empList.append($("<option>").val(data[index].empNo).text(jobEmp));
				}
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

		$("#date").text(todayString);
		$("#wrDate").val(todayString);
		$("#wrDate1").val(todayString);
		$("#wrDate2").val(todayString);
	});

	$("#title").keyup(function() {
		let title = $("#title").text();
		// console.log(title.length);
		
		if(title.length > 50){
			Swal.fire({
				icon: 'warning',
				title: '제목 글자수 초과',
				text: '50자 이하로 입력해주세요.'
			})
		}
		
		$("#title2").text(title);
		$("#docTitle1").val(title);
		$("#submitTitle").val(title);
	});

	$("#back").click(function() {
		Swal.fire({
			title: '작성내용이 모두 사라집니다.',
			text: "진행 하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '승인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				window.history.back();
			}
		});
	});

	$("#deleteTemp").click(function() {
		let docNo = $("#docNo1").val();
		Swal.fire({
			title: '해당 임시저장 문서를\n삭제합니다.',
			text: "진행 하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {

				console.log(docNo);
				location.href = "/document/deleteTempDoc/" + docNo
			}
		});
	})

	$("#tempStore").click(function() {


		// console.log(cnts);
		// console.log(amts);
		// console.log(memos);

		let totalamt = 0;

		let check = true;


		Swal.fire({
			title: '임시저장',
			text: "작성하신 문서를 임시저장 하시겠습니까?\n맞으시면 '확인'을 눌러주세요.",
			icon: 'question',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '승인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				let countCheck = 0;
				let countCheck2 = 0;
				if ($("#title").text().length < 1 || $("#title").text() == "" || $("#title").text() == "  ") {
					Swal.fire({
						icon: 'warning',
						title: '제목이 없습니다',
						text: '문서의 제목을 입력해주세요.'
					})
				} else { countCheck++; }
				
				if ($("#title").text().length > 50) {
					Swal.fire({
						icon: 'warning',
						title: '제목 글자수 초과',
						text: '50자 이하로 입력해주세요.'
					})
				} else{countCheck++;}
				
				
				console.log(countCheck);
				if (check) {

					const cnts = document.querySelectorAll('table#write tbody tr #cnt');
					const amts = document.querySelectorAll('table#write tbody tr #amt');
					const memos = document.querySelectorAll('table#write tbody tr #memo');

					const resultcnts = document.querySelectorAll('table#inserttbl tbody tr #cnt');
					const resultamts = document.querySelectorAll('table#inserttbl tbody tr #amt');
					const resultmemos = document.querySelectorAll('table#inserttbl tbody tr #memo');

					//console.log(cnts);
					//console.log(amts);
					//console.log(memos);



					for (let i = 0; i < amts.length; i++) {
						if (!(Number(amts[i].innerText) || amts[i].innerText === '')) {
							//alert('숫자 아닌거 있음');
							Swal.fire({
								icon: 'warning',
								title: '금액란 입력 오류',
								text: '금액란에 숫자만 입력해주세요!',
							})
							break;
						} else if (amts[0].innerText.length < 1) {
							//console.log(amts[0].innerText);
							//alert('내용 한개이상 입력해야함');
							Swal.fire({
								icon: 'warning',
								title: '등록된 금액이 없습니다!',
								text: '내용을 한개이상 입력해주세요!',
							})
							break;
						} else {
							totalamt += amts[i].innerText;
							countCheck2 += 1;
						}
					}
					console.log(countCheck2);
					for (let i = 0; i < cnts.length; i++) {
						if (cnts[0].innerText.length < 1) {
							//console.log(cnts[0].innerText);
							//alert('내용없음 한개이상 입력해야함');
							Swal.fire({
								icon: 'warning',
								title: '등록된 내용이 없습니다!',
								text: '내용을 한개이상 입력해주세요!',
							})
							break;
						} else {
							if (resultamts[i].innerText = Intl.NumberFormat().format(amts[i].innerText) == 0) {
								resultamts[i].innerText = "";
							} else {
								resultamts[i].innerText = Intl.NumberFormat().format(amts[i].innerText);

							}
							resultcnts[i].innerText = cnts[i].innerText
							resultmemos[i].innerText = memos[i].innerText

							// console.log(totalamt);

							document.getElementById("sumamt").innerText = Intl.NumberFormat().format(totalamt);
							countCheck2 += 1;
						}
					}
					console.log(countCheck2);
				}
				if (countCheck2 == 20) { countCheck += 1; }
				console.log(countCheck);
				if (countCheck == 3) {

					$("#docStatus1").val("임시저장");
					let sendDraft = $("#insertin").html();
					console.log(sendDraft);
					$("#draftcnt1").val(sendDraft);
					let cnt = $("#writein").html();
					console.log(cnt)
					$("#cnttt1").val(cnt);
					$("#temp").submit();

				}

			}
		})
	});

}

function sendData() {

	console.log("나불러쪄?");

	const cnts = document.querySelectorAll('table#write tbody tr #cnt');
	const amts = document.querySelectorAll('table#write tbody tr #amt');
	const memos = document.querySelectorAll('table#write tbody tr #memo');

	const resultcnts = document.querySelectorAll('table#inserttbl tbody tr #cnt');
	const resultamts = document.querySelectorAll('table#inserttbl tbody tr #amt');
	const resultmemos = document.querySelectorAll('table#inserttbl tbody tr #memo');

	// console.log(cnts);
	// console.log(amts);
	// console.log(memos);

	let totalamt = 0;

	let check = true;
	let countCheck = 0;
	let countCheck2 = 0;

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

		if ($("#stepNo").val() == "") {
			Swal.fire({
				icon: 'warning',
				title: '결재단계 확인',
				text: '단계 지정버튼을 눌러주세요!'
			})
		} else { countCheck++; }
		
		console.log(countCheck);
		
		if ($("#submitTitle").val() == "") {
			Swal.fire({
				icon: 'warning',
				title: '제목 확인',
				text: '제목에 수정사항을 작성해주세요!'
			})
		} else { countCheck += 1; }
		
		console.log(countCheck);
		
		if ($("#submitTitle").val().length > 50) {
			Swal.fire({
				icon: 'warning',
				title: '제목 글자수 초과',
				text: '50자 이하로 입력해주세요.'
			})
		} else { countCheck += 1; }
		
		if (check) {
			for (let i = 0; i < amts.length; i++) {
				if (!(Number(amts[i].innerText) || amts[i].innerText === '')) {
					//alert('숫자 아닌거 있음');
					Swal.fire({
						icon: 'warning',
						title: '금액란 입력 오류',
						text: '금액란에 숫자만 입력해주세요!',
					})
					break;
				} else if (amts[0].innerText.length < 1) {
					//console.log(amts[0].innerText);
					//alert('내용 한개이상 입력해야함');
					Swal.fire({
						icon: 'warning',
						title: '등록된 금액확인',
						text: '내용을 확인 후 재입력해주세요!',
					})
					break;
				} else {
					totalamt += Number(amts[i].innerText);
				}
			}
			countCheck2 += 1;
			for (let i = 0; i < cnts.length; i++) {
				if (cnts[0].innerText.length < 1) {
					//console.log(cnts[0].innerText);
					//alert('내용없음 한개이상 입력해야함');
					Swal.fire({
						icon: 'warning',
						title: '등록된 내용확인',
						text: '내용을 확인 후 재입력해주세요!',
					})
					break;
				} else {
					if (resultamts[i].innerText = Intl.NumberFormat().format(amts[i].innerText) == 0) {
						resultamts[i].innerText = "";
					} else {
						resultamts[i].innerText = Intl.NumberFormat().format(amts[i].innerText);

					}
					resultcnts[i].innerText = cnts[i].innerText;
					resultmemos[i].innerText = memos[i].innerText;

					// console.log(totalamt);

					document.getElementById("sumamt").innerText = Intl.NumberFormat().format(totalamt);

				}
			}
			countCheck2 += 1;
		}
		if (countCheck2 == 2) { countCheck += 1; }
		console.log(countCheck);
		if (countCheck == 4) {

			let text = $("#title").text();
			console.log(text);
			console.log($("#submitTitle").val(text));


			let sendDraft = $("#insertin").html();
			console.log(sendDraft);

			let cnt = $("#writein").html();
			console.log(cnt)

			$("#draftcnt2").val(sendDraft);
			$("#cnttt2").val(cnt);
			$("#docStatus2").val("대기");
			$("#submitReport").submit();
		}
	});

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

function takeout() {

	console.log("send send 나불러쪄?");

	const cnts = document.querySelectorAll('table#write tbody tr #cnt');
	const amts = document.querySelectorAll('table#write tbody tr #amt');
	const memos = document.querySelectorAll('table#write tbody tr #memo');

	const resultcnts = document.querySelectorAll('table#inserttbl tbody tr #cnt');
	const resultamts = document.querySelectorAll('table#inserttbl tbody tr #amt');
	const resultmemos = document.querySelectorAll('table#inserttbl tbody tr #memo');

	// console.log(cnts);
	// console.log(amts);
	// console.log(memos);

	let totalamt = 0;

	for (let i = 0; i < amts.length; i++) {
		if (!(Number(amts[i].innerText) || amts[i].innerText === '')) {
			//alert('숫자 아닌거 있음');
			Swal.fire({
				icon: 'warning',
				title: '금액란 입력 오류',
				text: '금액란에 숫자만 입력해주세요!',
			})
			break;
		} else if (amts[0].innerText.length < 1) {
			//console.log(amts[0].innerText);
			//alert('내용 한개이상 입력해야함');
			Swal.fire({
				icon: 'warning',
				title: '등록된 금액이 없습니다!',
				text: '내용을 한개이상 입력해주세요!',
			})
			break;
		} else {
			totalamt += Number(amts[i].innerText);
		}
	}

	for (let i = 0; i < cnts.length; i++) {
		if (cnts[0].innerText.length < 1) {
			//console.log(cnts[0].innerText);
			//alert('내용없음 한개이상 입력해야함');
			Swal.fire({
				icon: 'warning',
				title: '등록된 내용이 없습니다!',
				text: '내용을 한개이상 입력해주세요!',
			})
			break;
		} else {
			if (resultamts[i].innerText = Intl.NumberFormat().format(amts[i].innerText) == 0) {
				resultamts[i].innerText = "";
			} else {
				resultamts[i].innerText = Intl.NumberFormat().format(amts[i].innerText);

			}
			resultcnts[i].innerText = cnts[i].innerText;
			resultmemos[i].innerText = memos[i].innerText;

			// console.log(totalamt);

			document.getElementById("sumamt").innerText = Intl.NumberFormat().format(totalamt);

		}
	}

}