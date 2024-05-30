

function changeForm(str) {
  let lForm = document.getElementById("loginForm");
  let sForm = document.getElementById("signUpForm");

  if (str === "Sign Up") {
    lForm.style.display = "none";
    sForm.style.display = "block";
  } else {
    sForm.style.display = "none";
    lForm.style.display = "block";
  }
}