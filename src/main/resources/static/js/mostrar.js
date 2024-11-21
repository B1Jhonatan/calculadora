document.addEventListener('DOMContentLoaded', () => {

    document.getElementById('resultado').addEventListener('submit', function (event) {

        event.preventDefault();

        let tipo = document.getElementById('tipo').value.trim();
        let largo = document.getElementById('largo').value.trim();
        let ancho = document.getElementById('ancho').value.trim();
        let alto = document.getElementById('alto').value.trim();
        let cantidad = document.getElementById('cantidad').value.trim();

        let valido = true;

        if (tipo === '' || largo === '' || ancho === '' || alto === '' || cantidad === '') {
            valido = false;
        }

        if (valido === true) {
            const resultado = document.getElementById('mirar');
            resultado.innerHTML = `
            <h3>Datos enviados:</h3>
            <p><strong>Tipo:</strong> ${tipo}</p>
            <p><strong>Largo:</strong> ${largo}</p>
            <p><strong>Ancho:</strong> ${ancho}</p>
            <p><strong>Alto:</strong> ${alto}</p>
            <p><strong>Cantidad:</strong> ${cantidad}</p>
        `;
            resultado.style.display = 'block';

            this.submit();
            
            setTimeout(() => {
                document.getElementById('resultado').submit();
            }, 3000);
            
        }

    })

});