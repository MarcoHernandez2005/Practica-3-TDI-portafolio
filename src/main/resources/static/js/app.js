$(document).ready(function() {
    
    $("#buscador").on("keyup", function() {
        var valor = $(this).val().toLowerCase();

        $("#galeria-proyectos .proyecto-card").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(valor) > -1);
        });

        $("#tabla-proyectos tbody tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(valor) > -1);
        });
    });

    $(".btn-eliminar").on("click", function(e) {
        var confirmacion = confirm("¿Estás seguro de que deseas eliminar este proyecto de tu portafolio?");
        if (!confirmacion) {
            e.preventDefault();
        }
    });

});