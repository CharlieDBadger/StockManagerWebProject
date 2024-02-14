document.getElementById("passwordForm").addEventListener("submit", function(event) {
    var password1 = document.getElementById("password1").value;
    var password2 = document.getElementById("password2").value;
    var message = document.getElementById("message");

    if (password1 !== password2) {
        message.innerHTML = "Las contraseñas no coinciden";
        event.preventDefault(); // Evita que se envíe el formulario
    } else {
        message.innerHTML = "";
    }
});