
function login() {

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    


    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
			console.log("response text:" + this.responseText);
			
			let employee = JSON.parse(this.responseText);
				
			console.log("emp.name" + employee["firstName"])
			console.log("This is emp: " + employee);
			if(employee != null){
				window.location.href = "homePage.html";
				
			} else {
				let information = "<p>Incorrect Username or Password</p>"
				document.getElementById("incorrect").innerHTML = information;
			}
			
        }
    }


    xhttp.open("POST", "http://localhost:8080/p0TRMS/login.do", true);

    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhttp.send("email="+email+"&password="+password);

}

function homePage(){

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
        	document.GetElementById("welcomeMessage").innerHTML = information;
        }
    }


    xhttp.open("POST", "http://localhost:8080/p0TRMS/homePage.do", true);

    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhttp.send("email="+email+"&password="+password);

}
	


