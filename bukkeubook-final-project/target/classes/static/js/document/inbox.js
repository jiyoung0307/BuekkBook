window.onload = function(){
	
	$(function(){
		$.ajax({
			url:"/document/findSignName",
			success: function(data){
				console.log(data);
				$("#empSign").val(data[0]);
				console.log($("#empSign").val());
			},
			error : function(error){
				console.log(error);
			}
		})
	})
	
	
	let docNo = $("#docNo").val();
	$(function(){
		$.ajax({
			url:"/document/checkButton/" + docNo,
			success: function(data){
				console.log(data);
				
				let docStatus = data[0];
				let place = data[1];
				console.log(place);
				$("#place").val(place);
				console.log($("#place").val());
				
				//console.log(docStatus);
				if(docStatus == "반려" || docStatus == "승인"){
					Swal.fire({
						icon: 'info',
						title: '결재 완료',
						text: '결재가 완료된 문서입니다.'
					})
					$("#apply").hide();
					$("#refuse").hide();
				}else{
					if(docStatus == "0"){
						Swal.fire({
							icon: 'info',
							title: '결재 요망',
							text: '결재를 진행해주세요.'
						})
						$("#apply").show();
						$("#refuse").show();
					} else if(docStatus == "1" || docStatus == "2" || docStatus == "3"){
						let isPossible = data[2];
						
						if(isPossible == "가능"){
							Swal.fire({
								icon: 'info',
								title: '결재 요망',
								text: '결재를 진행해주세요.'
							})
							$("#apply").show();
							$("#refuse").show();
						} else {
							$("#apply").hide();
							$("#refuse").hide();
						}
					}
				}
			},
			error: function(error){
				console.log(error);
			}
		});
	});
	
	$("#back").click(function() {
		window.history.back();
	})
	
	$("#apply").click(function() {
		Swal.fire({
			title: '결재승인',
			text: "진행 하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				console.log("dddd");
				$("#appStatus").val('승인');
				console.log($("#appStatus").val());
				
				let empSign = $("#empSign").val();
				let place = $("#place").val();
				
				if(place == "1"){
					$("#sign2").append("<img src='/images/sign/" + empSign +  "'style='width: 65px; height:70px;'>");
				} else if(place == "2"){
					$("#sign3").append("<img src='/images/sign/" + empSign +  "'style='width: 65px; height:70px;'>");
				} else{
					$("#sign4").append("<img src='/images/sign/" + empSign +  "'style='width: 65px; height:70px;'>");
				}
				let total = $("#total").html();
				$("#tagCnt").val(total);
				
				console.log($("#tagCnt").val());
								
				$("#app").submit();
			}
		})
	})
	
	$("#refuse").click(function() {
		Swal.fire({
			title: '결재반려',
			text: "진행 하시겠습니까?",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#c5bfbf',
			cancelButtonColor: '#c5bfbf',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				
				$("#appStatus").val('반려');
				
				
				let place = $("#place").val();
				if(place == "1"){
					$("#sign2").append("<img src='/images/document/refuse/refuse.png'>");
				} else if(place == "2"){
					$("#sign3").append("<img src='/images/document/refuse/refuse.png'>");
				} else{
					$("#sign4").append("<img src='/images/document/refuse/refuse.png'>");
				}
				let total = $("#total").html();
				$("#tagCnt").val(total);
				
				console.log($("#tagCnt").val());
				$("#app").submit();
			}
		})
	})
	
	
}