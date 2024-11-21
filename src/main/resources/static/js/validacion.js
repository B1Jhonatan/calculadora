document.addEventListener('DOMContentLoaded', validacion);

function validacion(){

    document.getElementById('login').addEventListener('submit', function(event){
        
        event.preventDefault();

        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();

        document.getElementById('errorUser').style.display = 'none';
        document.getElementById('errorPass').style.display = 'none';
        document.getElementById('errorUP').style.display = 'none';
        document.getElementById('correcto').style.display = 'none';
        
        let esValido = true;

        const usernameRegex = /^[A-Za-z\s]+$/;

        const usuarios = {
            "Jhonatan": "jaimes123",
            "William": "garcia123",
            "Admin": "admin123"
        };
 
        if(username === "" || !usernameRegex.test(username)){
            document.getElementById('errorUser').style.display = 'block';
            document.getElementById('errorUser').textContent = 'El usuario solo debe contener letras.'
            esValido = false;
        }

        if(password === "" || password.length < 8){
            document.getElementById('errorPass').style.display = 'block';
            document.getElementById('errorPass').textContent = 'La contrasenia debe tener al menos 8 caracteres.';
            esValido = false;
        }

        if (!usuarios[username] || usuarios[username] !== password) {
            document.getElementById('errorUP').style.display = 'block';
            document.getElementById('errorUP').textContent = 'Nombre de usuario o contraseña incorrecto.';
            esValido = false;
        }

        if(esValido){
            document.getElementById('correcto').style.display = 'block';

            setTimeout(function() {
                window.location.href = 'graficas.html'; // Cambia esta ruta a la de tu dashboard
            }, 2000);

        }

    });

}