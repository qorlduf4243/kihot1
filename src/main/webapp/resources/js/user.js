//jsp 파일과 일반 파일 html 파일의 차이 mvp 프로젝트 의미

function myFunction() {
		alert(document.getElementById("exam").innerHTML);
		if (document.getElementById("exam").innerHTML == "변경 전")
			document.getElementById("exam").innerHTML = "변경 후"
		else
			document.getElementById("exam").innerHTML = "변경 전"
	}