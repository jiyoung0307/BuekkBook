window.onload = function() {


	let salNo = $("#salNo").val();
	$("#delete").click(function() {
		Swal.fire({
			title: '급여내역 삭제',
			text: "삭제 하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				location.href = "/empPay/paydelete/" + salNo

			}
		})
	});

	$("#backBtn").click(function() {
		window.history.back();
	});

	let salBase = $("#salBase").val();
	let salPension = $("#salPension").val();
	let salHealth = $("#salHealth").val();
	let salCare = $("#salCare").val();
	let salHire = $("#salHire").val();
	let salIncTax = $("#salIncTax").val();
	let salLocalTax = $("#salLocalTax").val();
	let salTotalMinus = $("#salTotalMinus").val();
	let salRealAmount = $("#salRealAmount").val();



	let num = new Intl.NumberFormat().format(salBase);
	let Pension = new Intl.NumberFormat().format(salPension);
	let Health = new Intl.NumberFormat().format(salHealth);
	let Care = new Intl.NumberFormat().format(salCare);
	let Hire = new Intl.NumberFormat().format(salHire);
	let IncTax = new Intl.NumberFormat().format(salIncTax);
	let LocalTax = new Intl.NumberFormat().format(salLocalTax);
	let TotalMinus = new Intl.NumberFormat().format(salTotalMinus);
	let RealAmount = new Intl.NumberFormat().format(salRealAmount);
	
	console.log(num);

	$("#base").text(num);
	$("#base2").text(num);
	$("#pension").text(Pension);
	$("#health").text(Health);
	$("#care").text(Care);
	$("#hire").text(Hire);
	$("#incTax").text(IncTax);
	$("#localTax").text(LocalTax);
	$("#totalMinus").text(TotalMinus);
	$("#realAmount").text(RealAmount);
	
}