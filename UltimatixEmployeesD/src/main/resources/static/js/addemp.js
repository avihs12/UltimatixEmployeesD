var sno = document.getElementById("sno");
var firstname = document.getElementById("firstname");
var lastname = document.getElementById("lastname");
var employeeid = document.getElementById("employeeid");
var salary = document.getElementById("salary");
var salaryhike = document.getElementById("salaryhike");
var error1 = document.getElementById("error1");
var error2 = document.getElementById("error2");
var error3 = document.getElementById("error3");
var error4 = document.getElementById("error4");
var error5 = document.getElementById("error5");
var savebutton = document.getElementById("savebutton");
var cancelbutton = document.getElementById("cancelbutton");
var searchbarSearch = document.getElementById("searchInput");
var searchbarReset = document.getElementById("seachbarreset");

function myfunction() {
  debugger;
  let error = false;
  if (!firstname.value && firstname.value.trim() === "") {
    debugger;
    error1.innerHTML = "invalid firstname"
    firstname.value.trim();
    firstname.style.border = "2px solid red";
    error = true
  }
  if (!lastname.value && lastname.value.trim() === "") {
    error2.innerHTML = "invalid last name"
    lastname.style.border = "2px solid red";
    lastname.value.trim();
    error = true
  }

  if (!employeeid.value && employeeid.value.trim() === "") {
    error3.innerHTML = "lenght mistmatched"
    employeeid.style.border = "2px solid red";
    error = true
  }

  if (!salary.value && salary.value.trim() === "") {
    error4.innerHTML = "lenght mistmatched"
    salary.style.border = "2px solid red";
    error = true
  }

  if (!salaryhike.value && salaryhike.value.trim() === "") {
    error5.innerHTML = "lenght mistmatched"
    salaryhike.style.border = "2px solid red";
    error = true
  }

  if (!error) {
    document.getElementById("addemployee").submit();
  }

  // document.getElementById("cancelbutton").submit();
  // document.getElementById("seachbarreset").submit();\

}

savebutton.addEventListener("click", function (e) {
  e.preventDefault();
  debugger;

  myfunction();
});
cancelbutton.addEventListener("click", function (e) {
  e.preventDefault();
  myfunction();
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
