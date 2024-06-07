"use strict";

const d = document, c = console,w=window;

const getParameter = (key)=>{
    let address = w.location.search;

    let parameterList = new URLSearchParams(address);

    return parameterList.get(key);
};

let nombre = getParameter("nombreUsuario"),
apellidos = getParameter("apellidosUsuaro"),
correo = getParameter("correoUsuario"),
contra = getParameter("contraUsuario"),
contraRepetida = getParameter("contraRepetida");

const $conenedorCards = d.getElementById("cardsUserContainer");



const $newCard = d.createElement("div");
$newCard.setAttribute("class","usuarioCard row container my-4 mx-auto hoverscale");
$newCard.innerHTML = `
    <div class="infoUsuario col-8 p-2">
        <h6>${nombre} ${apellidos}</h6>
        <ul>
          <li><strong>Correo:</strong>${correo}</li>
          <li><strong>Telefono:</strong> 7778242913</li>
        </ul>
      </div>
      <div class="d-flex justify-content-center 
          flex-column controlesUsuario col-3 p-1 flex-lg-row">
        <button class="btn btn-positive mx-1">Editar</button>
        <button class="btn btn-danger mx-1 eliminarUsuario">Eliminar</button>
      </div>
`;
if($conenedorCards) $conenedorCards.appendChild($newCard);


// Se probó eliminar usuario pero aún le falta...
// const $eliminarUsuarioBtn = d.querySelector(".eliminarUsuario");
// $eliminarUsuarioBtn.addEventListener("click",()=> {
//     $conenedorCards.removeChild($newCard);
//     c.log("aaaa");
// });




