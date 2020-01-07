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

function getReimTable(){ 
    document.getElementById("tableList").style.display = "block";
    document.getElementById("welcomeMessage").style.display = "none";      
    document.getElementById("reimInputForm1").style.display = "none";      
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

            console.log("this is justification" + reims.justification)
            let printReim = reims.map(reimbursement => `   
                <tr id="removeBCline">
                  <td>${reimbursement.emp_id}</td>
                  <td>${reimbursement.reimTotAmount}</td>
                  <td>${reimbursement.reimStatus}</td>
                  <td>${reimbursement.dateSub}</td>
                  <td>${reimbursement.justification}</td>
                  <td><button type="button" class="btn btn-primary" onClick="approvePending(${reimbursement.reim_id})">Approve</button></td>
                  <td><button type="button" class="btn btn-danger" onClick="denyPending(${reimbursement.reim_id}, ${reimbursement.emp_id})">Deny</button></td>
                  <td><textarea id="sendMessage"  rows="2" cols="30"></textarea></td> 
                  <td><button type="button" class="btn btn-primary" onClick="sendMessage(${reimbursement.reim_id}, ${reimbursement.emp_id})">Send Message</button></td>
                  </tr>
                  ` ).join("");
                  console.log(printReim);
                  let reimBody = document.getElementById("reimBody");      
                  reimBody.innerHTML = printReim;
                  showMessages()
           
           
            // console.log('does this work? ' + reimburse)
            // // document.querySelector("table").innerHTML(" ");
            // let data = Object.keys(reimburse[0]);
            // let table = document.querySelector("table");
            // generateTable(table, reimburse);
            // generateTableHead(table, data);
        }}
        xhttp.open("GET", "http://localhost:8080/p0TRMS/reimList.do", true);

        xhttp.send();

}
function grabValue(){
    let value = document.getElementById("sendMessage").value;
    return value;
}

function sendMessage(reim_id, emp_id) {
     let message = grabValue();
    console.log(message);
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            
            let responeReimForm = this.responseText;
    
            console.log(responeReimForm)
                
        }
    }
        
    xhttp.open("POST", "http://localhost:8080/p0TRMS/sendMessage.do", true);
    
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    
    xhttp.send("reim_id="+reim_id+"&emp_id="+emp_id+"&message="+message);

}

function showMessages(){
    document.getElementById("tableList").style.display = "block";
    document.getElementById("welcomeMessage").style.display = "none";      
    document.getElementById("reimInputForm1").style.display = "none";  
    document.getElementById("showMessages").style.display = "block";    
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

            console.log("this is justification" + reims.justification)
            let printReim = reims.map(reimbursement => `   
                <tr id="removeBCline">
                  <td>${reimbursement.emp_id}</td>
                  <td>${reimbursement.reim_id}</td>
                  <td>${reimbursement.benco_message}</td>
                  <td>${reimbursement.employee_message}</td>
                  </tr>
                  ` ).join("");
                  console.log(printReim);
                  let messageBody = document.getElementById("messageBody");      
                  messageBody.innerHTML = printReim;
           
           
            // console.log('does this work? ' + reimburse)
            // // document.querySelector("table").innerHTML(" ");
            // let data = Object.keys(reimburse[0]);
            // let table = document.querySelector("table");
            // generateTable(table, reimburse);
            // generateTableHead(table, data);
        }}
        xhttp.open("GET", "http://localhost:8080/p0TRMS/showMessages.do", true);

        xhttp.send();



}

function approvePending(reim_id){
    let reim_id1 = reim_id;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            
           
            
        }
        
        
    }
    
    xhttp.open("POST", "http://localhost:8080/p0TRMS/approvePending.do", true);
    
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    
    xhttp.send("reim_id="+reim_id1);
    
    getReimTable();

}
function denyPending(reim_id, emp_id){
    let reim_id1 = reim_id;
    let emp_id1 = emp_id;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            
           
            
        }
        
        
    }
    
    xhttp.open("POST", "http://localhost:8080/p0TRMS/denyPending.do", true);
    
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    
    xhttp.send("reim_id="+reim_id1+"&emp_id="+emp_id1);
    
    getReimTable();

}


function getPosition(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
            let position = this.responseText;

        }
        
        }
    


    xhttp.open("GET", "http://localhost:8080/p0TRMS/getPosition.do", true);

    
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
            let rem = JSON.parse(reimburse);
            console.log('does this work? ' + reimburse)
            console.log('does this work rem? ' + rem)
            let data = Object.keys(rem[0]);
            let table = document.querySelector("table");
            generateTable(table, rem);
            generateTableHead(table, data);
				
        }
    }


    xhttp.open("GET", "http://localhost:8080/p0TRMS/reimTable.do", true);

    xhttp.send();

	
}


function onLoading(){

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {
			
            let name = this.responseText;
            let info = `<h1>Hello there ${name}, welcome to Easy Tut's</h1>`;
            document.getElementById("welcomeMessage").innerHTML = info;
				
        }
    }


    xhttp.open("GET", "http://localhost:8080/p0TRMS/welcome.do", true);

    xhttp.send();
	
}

function availableFunds(){
    document.getElementById("tableList").style.display = "none";
    document.getElementById("welcomeMessage").style.display = "block"; 
    document.getElementById("reimInputForm1").style.display = "none";
    document.getElementById("showMessages").style.display = "none"; 

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200) {


            let aFunds = JSON.parse(this.responseText);
            let info = `<h1>You have an available balance of $ ${aFunds}</h1>`;
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

function reimburseForm(){
    //Grading Format

    console.log("somtehing");
    let today = new Date();
    console.log("2");
let gradingFormat = document.getElementById("gradingFormat").value;
let gradeRecieved = document.getElementById("gradeRecieved").value;

//Event Type
let evtType = document.getElementById("evtType").value;

let eventName = document.getElementById("eventName").value;
let eventCost = document.getElementById("eventCost").value;
console.log("3");
let eventAddress = document.getElementById("address").value;
let eventAddress2 = document.getElementById("address2").value;
let city = document.getElementById("city").value;
let state = document.getElementById("state").value;
let zipcode = document.getElementById("zipcode").value;
let beginDate = document.getElementById("beginDate").value;
let endDate = document.getElementById("endDate").value;
let time = document.getElementById("time").value;
let eventDescription = document.getElementById("eventDescription").value;

//Reimbursement
let justification = document.getElementById("justification").value;
let reimStatus = "PENDING_SUPERVISOR";
let reimAmtApproved = 0;
let dateSub = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
let approvalDate = "NOT APPROVED";
console.log("Event cosT:" + eventCost);
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
    if(this.readyState == 4 && this.status == 200) {
        adjustAvailableBalanceFromForm(eventCost, evtType);
        
        let responeReimForm = this.responseText;

        console.log(responeReimForm)
            
    }
}


xhttp.open("POST", "http://localhost:8080/p0TRMS/reimForm.do", true);


xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');


xhttp.send("gradingFormat="+gradingFormat+"&gradeRecieved="+gradeRecieved+"&evtType="+evtType+"&eventName="+eventName+
"&eventCost="+eventCost+"&eventAddress="+eventAddress+"&eventAddress2="+eventAddress2+"&city="+city+"&state="+state+
"&zipcode="+zipcode+"&beginDate="+beginDate+"&endDate="+endDate+"&time="+time+"&eventDescription="+eventDescription+
"&justification="+justification+"&reimStatus="+reimStatus+"&reimAmtApproved="+reimAmtApproved+"&dateSub="+dateSub+
"&approvalDate="+approvalDate
);

}
function showReimburseForm(){
    document.getElementById("tableList").style.display = "none";
    document.getElementById("welcomeMessage").style.display = "none"; 
    document.getElementById("reimInputForm1").style.display = "block"; 
}

function getEventPercentage(evtType){
    if (evtType = "University Courses"){
        return .8;
          
    }else if (evtType = "Seminars"){
        return .6;      
    } else if (evtType = "Certification Preparation Classes"){
        return .75;    
    } else if (evtType = "Certification"){  
        return 1;
    } else if (evtType = "Technical Training"){
       return .9; 
    } else if (evtType = "Other"){
       return .3;
    }

}
function adjustAvailableBalanceFromForm(eventCost, evtType){
   let adjustedCost = eventCost * getEventPercentage(evtType); 
    

let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
    if(this.readyState == 4 && this.status == 200) {
        
        let responeReimForm = this.responseText;

        console.log(responeReimForm)
            
    }
}
    
xhttp.open("POST", "http://localhost:8080/p0TRMS/adjustFormCost.do", true);


xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');


xhttp.send("adjustedCost="+adjustedCost);

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


