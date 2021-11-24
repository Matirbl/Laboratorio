const url = 'localhost:3000';


function consultarAPI(consulta, funcion, funcionError) {
    fetch(url + consulta)
        .then(resultado => resultado.json())
        .then(datos => {
            funcion(datos);
        })
        .catch(error => {
            funcionError();
        });
}
/**
 * Obtiene de la API un objeto JSON con todos los tragos que coinciden 
 * con el nombre buscado.
 */
function obtenerInstrumentos(funcion, funcionError) {
    consultarAPI(url, (datos) => {
        funcion(datos);
    }, funcionError);
}
obtenerInstrumentos((datos) => { console.log(datos) }, (datos) => { console.log(datos) });

console.log("hola mundo");