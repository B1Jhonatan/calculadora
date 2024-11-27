/*Este Script muestra el historial dependiendo le la figura que se seleccione*/

document.addEventListener("DOMContentLoaded", () => {
    // Obtener la URL actual
    const url = window.location.href;

    // Verificar si la URL contiene "figura3d" o "figura2d"
    if (url.includes("figura3d")) {
        document.getElementById("elemento3d").style.display = "block";
    } else if (url.includes("figura2d")) {
        document.getElementById("elemento2d").style.display = "block";
    } else {
        console.error("Tipo de figura no encontrado en la URL.");
    }
});