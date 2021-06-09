
function imgChk() {
	var frmElem = document.querySelector('#frm');
	function imgChk() {
		if(frmElem.profileImg.files.length === 0) {
			alert('이미지를 선택해 주세요');
			return false;
		}
	}
}