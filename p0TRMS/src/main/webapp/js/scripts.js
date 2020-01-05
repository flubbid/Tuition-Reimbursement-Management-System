let loggedUser = [];

function login() {

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    


    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
			console.log("response text:" + this.responseText);
			let employee = JSON.parse(this.responseText);
			console.log("loggedUser: " + loggedUser);
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

function logout(){
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
    if(this.readyState == 4 && this.status == 200) {
        if(this.readyState == 4){
            window.location.replace(this.responseURL);
        }
        }
        
    }
    xhttp.open("GET", "http://localhost:8080/p0TRMS/logout.do", true);
    xhttp.send();

}




function getReimList(){

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
			
            let reims = JSON.parse(this.responseText);
            console.log("plain jane reims: " + reims)
            let reimburse = [];
 
            for(let i = 0; i < reims.length; i++){
                console.log(reims[i])
                reimburse.push(reims[i]);
                // document.getElementById("reimList1").innerHTML = JSON.stringify(reims[i]);
            }
            console.log('does this work? ' + reimburse)
            let data = Object.keys(reimburse[0]);
            let table = document.querySelector("table");
            generateTable(table, reimburse);
            generateTableHead(table, data);
				
        }
    }


    xhttp.open("GET", "http://localhost:8080/p0TRMS/reimList.do", true);

    xhttp.send();

	
}


function onLoading(){

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
			
            let name = this.responseText;
            let info = `Hello there ${name}, welcome to Easy Tut's`;
            document.getElementById("welcomeMessage").innerHTML = info;
				
        }
    }


    xhttp.open("GET", "http://localhost:8080/p0TRMS/welcome.do", true);

    xhttp.send();
	
}

function availableFunds(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
			
            let aFunds = JSON.parse(this.responseText);
            let info = `You have an available balance of $ ${aFunds}`;
            document.getElementById("welcomeMessage").innerHTML = info;
				
        }
    }


    xhttp.open("GET", "http://localhost:8080/p0TRMS/funds.do", true);

    xhttp.send();
	
}

function generateTableHead(table, data) {
    let thead = table.createTHead();
    let row = thead.insertRow();
    for (let key of data) {
      let th = document.createElement("th");
      let text = document.createTextNode(key);
      th.appendChild(text);
      row.appendChild(th);
    }
  }
  function generateTable(table, data) {
    for (let element of data) {
      let row = table.insertRow();
      for (key in element) {
        let cell = row.insertCell();
        let text = document.createTextNode(element[key]);
        cell.appendChild(text);
      }
    }
  }








// function generateTestTable(){
//     let potatoes= [
//      { name: "Russet", length: 69, place: "Merica" },
//     { name: "Golden", length: 4, place: "Not Merica" },
//     { name: "Orange", length: 69, place: "Mexico" },
//         ];

//     let data = Object.keys(potatoes[0]);
//     let table = document.querySelector("table");
//     generateTable(table, potatoes);
//     generateTableHead(table, data);
// }



//
//function homePage(){
//
//    let xhttp = new XMLHttpRequest();
//
//    xhttp.onreadystatechange = function () {
//        if(this.readyState == 4 && this.status == 200) {
//        	document.GetElementById("welcomeMessage").innerHTML = information;
//        }
//    }
//
//
//    xhttp.open("POST", "http://localhost:8080/p0TRMS/homePage.do", true);
//
//    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
//    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//
//    xhttp.send("email="+email+"&password="+password);
//
//}
//	


