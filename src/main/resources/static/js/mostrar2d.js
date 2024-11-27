/*Este Script hace la funcion de mostrar la alerta del formulario enviado*/

document.addEventListener('DOMContentLoaded', () => {

    document.getElementById('resultado').addEventListener('submit', function (event) {
        event.preventDefault(); // Detiene el envío automático del formulario.

        let tipo = document.getElementById('tipo').value.trim();
        let largo = document.getElementById('largo').value.trim();
        let ancho = document.getElementById('ancho').value.trim();
        let cantidad = document.getElementById('cantidad').value.trim();

        let valido = true;

        // Validación de campos vacíos.
        if (tipo === '' || largo === '' || ancho === '' || cantidad === '') {
            valido = false;
            alert("Por favor, llena todos los campos.");
        }

        if (valido === true) {
            
            //Mostrar los datos enviados en pantalla
            alert("Datos enviados:\n" +
                `Tipo: ${tipo}\nLargo: ${largo}\nAncho: ${ancho}\nCantidad: ${cantidad}`);

            this.submit(); 

        }
    });

});
