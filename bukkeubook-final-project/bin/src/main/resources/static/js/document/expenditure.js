window.onload = function() {
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
	});

	$("#title").keyup(function() {
		let title = $("#title").text();
		// console.log(title.length);
		$("#title2").text(title);
	})

}
	function sendData() {

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
				alert('숫자 아닌거 있음');
				return;
			} else if (amts[i].innerText.length < 1) {
				alert('내용 한개이상 입력해야함');
				return;
			} else {
				totalamt += Number(amts[i].innerText);
			}
		}

		for (let i = 0; i < cnts.length; i++) {
			if (cnts[0].innerText.length < 1) {
				alert('내용없음 한개이상 입력해야함');
				return;
			} else {
				resultamts[i].innerText = amts[i].innerText
				resultcnts[i].innerText = cnts[i].innerText
				resultmemos[i].innerText = memos[i].innerText

				// console.log(totalamt);

				document.getElementById("sumamt").innerText = totalamt;

			}
		}

	}