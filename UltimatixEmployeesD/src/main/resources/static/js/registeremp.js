var firstname = document.getElementById("firstname");
var lastname = document.getElementById("lastname");
var employeeid = document.getElementById("employeeid");
var password = document.getElementById("password");
var salary = document.getElementById("salary");
var salaryhike = document.getElementById("salaryhike");
var username = document.getElementById("username");
var registration = document.getElementById("registration");


var error1 = document.getElementById("error1");
var error2 = document.getElementById("error2");
var error3 = document.getElementById("error3");
var error4 = document.getElementById("error4");
var error5 = document.getElementById("error5");
var error6 = document.getElementById("error6");
var error7 = document.getElementById("error7");

var register = document.getElementById("register");




debugger;
function validations() {
  debugger;
  let error = false;
  if (!firstname.value && firstname.value.trim() === "") {
    debugger;
    firstname.style.border = "2px solid red";
    lastname.value.trim();
    error1.innerHTML = "invalid firstname"
    error = true
  }
  if (!lastname.value && lastname.value.trim() === "") {
    error2.innerHTML = "invalid last name"
    lastname.style.border = "2px solid red";
    lastname.value.trim();
    error = true
  }

  if (!employeeid.value && employeeid.value.trim() === "") {
    error5.innerHTML = "lenght mistmatched"
    employeeid.style.border = "2px solid red";
    error = true
  }


  if (!salary.value && salary.value.trim() === "") {
    error3.innerHTML = "lenght mistmatched"
    salary.style.border = "2px solid red";
    error = true
  }

  if (!salaryhike.value && salaryhike.value.trim() === "") {
    error4.innerHTML = "lenght mistmatched"
    salaryhike.style.border = "2px solid red";
    error = true
  }

  if (!username.value && username.value.trim() === "") {
    error6.innerHTML = "lenght mistmatched"
    username.style.border = "2px solid red";
    error = true
  }

  if (!password.value && password.value.trim() === "") {
    error7.innerHTML = "lenght mistmatched"
    password.style.border = "2px solid red";
    error = true
  }

  if (!error) {
    document.getElementById("addemployeeregiser").submit();
  }

}

function successPopUp(){
  document.getElementById("register").onclick=()=>{
    debugger
    const style = document.getElementById("registration").style
    if(style.display === "none"){
      style.display = "block";
    }
    else{
      style.display = "none";
    }
  }
}



register.addEventListener("click", function (e) {
  e.preventDefault();
  validations();
  successPopUp();
});


firstname.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (firstname.value) {
    firstname.value.trim();
    firstname.style.border = "2px solid green";
  }
});

lastname.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (lastname.value) {
    lastname.value.trim();
    lastname.style.border = "2px solid green";
  }
});

employeeid.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (employeeid.value) {
    employeeid.value.trim();
    employeeid.style.border = "2px solid green";
  }
});



salary.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (salary.value) {
    salary.value.trim();
    salary.style.border = "2px solid green";
  }
});

salaryhike.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (salaryhike.value) {
    salaryhike.value.trim();
    salaryhike.style.border = "2px solid green";
  }
});

password.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (password.value) {
    password.value.trim();
    password.style.border = "2px solid green";
  }
});

username.addEventListener("keyup", function (e) {
  e.preventDefault();
  if (username.value) {
    username.value.trim();
    username.style.border = "2px solid green";
  }
});


