const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
  history.pushState({}, 'Signup', '/register');
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
  history.pushState({}, 'Login', '/login');
});
