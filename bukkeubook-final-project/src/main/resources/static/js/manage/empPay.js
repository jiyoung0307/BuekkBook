window.onload = function() {
	
	$("#salBase").keyup(function(){
		let sal = $("#salBase").val();
		
		if(!(Number(sal))){
			Swal.fire({
				icon: 'warning',
				title: '입력 오류',
				text: '급여는 숫자만 입력이 가능합니다.'
			})
		}
		
		if(Number(sal) < 0){
			Swal.fire({
				icon: 'warning',
				title: '입력 오류',
				text: '급여는 음수입력이 불가능합니다.'
			})
		}
	})
	
	$("#totalSal2").blur(function(){
		let totalSal = $("#totalSal").val();
		let salary = Math.round(totalSal / 12);
		
		console.log(salary);
	});
	
	$(function() {
		$.ajax({
			url: "/empPay/dept",
			success: function(data) {
				/*console.log(data[0].name);
				console.log(data);
				console.table(data);*/

				const $deptCode = $("#deptCode");

				for (let index in data) {
					$deptCode.append($("<option>").val(data[index].deptCode).text(data[index].deptName));
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
		let deptName = $("#deptCode option:selected").text();
		console.log($("#deptCode option:selected").text());
		
		$("#dept").val(deptName);
		
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

	$("#empList").change(function(){
		let empNo = $(this).val();
		let empName = $("#empList option:selected").text();
		console.log(empNo);
		console.log(empName);
		
		$("#empName").val(empName);
		$("#empNo").val(empNo);
		console.log($("#empNo").val());
		
		$.ajax({
			url: "/empPay/payInfo/" + empNo,
			success: function(data) {
				console.log(data);
				console.log(data.empTotalSal);
				console.log(data.salary.salMonth);
				console.log(data.salary.salBase);
				console.log(data.salary.salRealAmount);
				console.log(data.salary.salTotalMinus);
				console.log(data.salary);
				
				let message = "지급일 : " + data.salary.salMonth + "<br>기본급 : " + data.salary.salBase +
							  "<br>총 공제액 : " + data.salary.salTotalMinus +
							  "<br>실지급액 : " + data.salary.salRealAmount
				
				$("#totalSal").val(data.empTotalSal);
				$("#totalSal2").text(data.empTotalSal);
				$("#message").html(message);
				let totalSal = Number($("#totalSal").val());
				let salary = Math.round(totalSal / 12);
				
				console.log($("#totalSal").val());
				console.log(Number($("#totalSal").val()));
				
				$("#salBase").val(salary);
				$("#salBase2").text(salary);
				printName();
			},
			error: function(error) {
				console.log(error);
			}
		});
	});



	$("#backBtn").click(function() {
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
	});


	$("#insert").click(function() {
		Swal.fire({
			title: '급여 등록',
			text: "등록하시겠습니까?",
			icon: 'question',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				let empNo = $("#empNo").val();
				let date = $("#date").val();
				let salBase = $("#salBase").val();
				let salPension = $("#salPension").val();
				let salHealth = $("#salHealth").val();
				let salCare = $("#salCare").val();
				let salHire = $("#salHire").val();
				let salIncTax = $("#salIncTax").val();
				let salLocalTax = $("#salLocalTax").val();
				let salTotalMinus = $("#salTotalMinus").val();
				let salRealAmount = $("#salRealAmount").val();
				
				let check = 0;
				if(empNo.length < 1 || empNo == "" || empNo == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '직원 선택',
						text: '직원을 선택해주세요.'
					})
				} else {
					check++;
				}
				if(date.length < 1 || date == "" || date == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '지급일 선택',
						text: '지급일을 선택해주세요.'
					})
				} else {
					check++;
				}
				if(salBase.length < 1 || salBase == "" || salBase == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '기본급 확인 요망',
					})
				} else {
					check++;
				}
				if(salPension.length < 1 || salPension == "" || salPension == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '국민연금 확인 요망',
					})
				} else {
					check++;
				}
				if(salHealth.length < 1 || salHealth == "" || salHealth == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '건강보험 확인 요망',
					})
				} else {
					check++;
				}
				if(salCare.length < 1 || salCare == "" || salCare == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '요양보험 확인 요망',
					})
				} else {
					check++;
				}
				if(salHire.length < 1 || salHire == "" || salHire == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '고용보험 확인 요망',
					})
				} else {
					check++;
				}
				if(salIncTax.length < 1 || salIncTax == "" || salIncTax == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '근로소득세 확인 요망',
					})
				} else {
					check++;
				}
				if(salLocalTax.length < 1 || salLocalTax == "" || salLocalTax == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '지방소득세 확인 요망',
					})
				} else {
					check++;
				}
				if(salTotalMinus.length < 1 || salTotalMinus == "" || salTotalMinus == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '공제액 합계 확인 요망',
					})
				} else {
					check++;
				}
				if(salRealAmount.length < 1 || salRealAmount == "" || salRealAmount == "  " ) {
					Swal.fire({
						icon: 'warning',
						title: '차인지급액 확인 요망',
					})
				} else {
					check++;
				}
				
				if(check ==11){
					$("#insertForm").submit();
				}
			}
		})
	});
}


function printName() {
	let salBase = document.getElementById('salBase').value;
	let salPension, salHealth, salCare, salHire, salIncTax, salLocalTax, salRealAmount, salTotalMinus;
	salPension = Math.round(salBase * 0.045);
	salHealth = Math.round(salBase * 0.03495);
	salCare = Math.round(salHealth * 0.1227);
	salHire = Math.round(salBase * 0.008);
	salIncTax = Math.round(salBase * 0.04);
	salLocalTax = Math.round(salIncTax * 0.1);
	salTotalMinus = salPension + salHealth + salCare + salHire + salIncTax + salLocalTax
	salRealAmount = salBase - salPension - salHealth - salCare - salHire - salIncTax - salLocalTax;
	document.getElementById("salBase").value = salBase;
	document.getElementById("salPension").value = salPension;
	document.getElementById("salHealth").value = salHealth;
	document.getElementById("salCare").value = salCare;
	document.getElementById("salHire").value = salHire;
	document.getElementById("salIncTax").value = salIncTax;
	document.getElementById("salLocalTax").value = salLocalTax;
	document.getElementById("salTotalMinus").value = salTotalMinus;
	document.getElementById("salRealAmount").value = salRealAmount;
}





