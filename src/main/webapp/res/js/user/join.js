var frmElem = document.querySelector('#frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var chkUpwElem = frmElem.chkUpw;
var unmElem = frmElem.unm;
var chkUidResultElem = frmElem.querySelector('#chkUidResult');

var btnChkIdElem = frmElem.btnChkId;

btnChkIdElem.addEventListener('click', function(){
	idChkAjax(uidElem.value);
});

function idChkAjax(uid) {
	
	fetch('/user/idChk?uid=' + uid)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		switch(myJson.result){
			case 0:
			chkUidResultElem.innerText = '이 아이디는 사용할 수 있습니다.';
			break;
			case 1:
			chkUidResultElem.innerText = '이 아이디는 사용할 수 없습니다.';
		}
		
	});
}

function frmChk() {
	var uidVal = uidElem.value;
	if (uidVal.length < 3) {
		if (uidVal.length == 0) {
			alert('아이디를 작성해 주세요')
			return false;
		} else {
			alert("아이디는 3자 이상 작성해 주세요.")
			return false;
		}
		return false;
	}
	var upwVal = upwElem.value;
	var chkUpwVal = chkUpwElem.value;

	if (upwVal.length < 4) {
		if (upwVal.length == 0) {
			alert('비밀번호를 작성해 주세요.')
		} else {
			alert('비밀번호는 4자 이상 작성해주세요')
		}
		return false;
	} else if (upwVal !== chkUpwVal) {
		alert('비밀번호를 확인해 주세요');
		return false;
	}
	var unmVal = unmElem.value;
	if(unmVal.length < 2){
		alert('이름은 2자 이상 작성해 주세요');
		return false;
	}
}

