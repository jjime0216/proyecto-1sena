// // Aqui empieza la travesia

//// Funciones Globales //////
let incorrecto
//////////////////////////////////  JS pantalla 2 /////////////////////////////////////////

function ingresar(){
    let usuario = document.getElementById("usuario").value;
    let password = document.getElementById("password").value;
    

    if(usuario == "adminProyecto@admin.com" && password == "1234"){
        window.location = "..//index.html"
    }else{
        incorrecto = document.getElementById("incorrecto").innerHTML = "Correo y/o contraseña invalidos "
    }

}

////////////////////////////////// JS pantalla 1 //////////////////////////////////////////////////
function registro(){
    let nombre = document.getElementById("name").value
    let apellido = document.getElementById("lastname").value
    let correoEle = document.getElementById("correoEle").value
    let numeroCel = document.getElementById("numeroCel").value
    let password = document.getElementById("password").value
    let conPassword = document.getElementById("conPassword").value
    let terminos = document.getElementById("terminos")

    if(nombre == "" || apellido == "" || correoEle == "" || numeroCel == "" || password == "" || conPassword == ""){
        incorrecto = document.getElementById("incorrecto").innerHTML = "Por favor completa todos los campos para continuar."
    }
    else if(password != conPassword){
        incorrecto = document.getElementById("incorrecto").innerHTML = "la contraseña no coincide, intenta de nuevo."
    }else if(!terminos.checked){
        incorrecto = document.getElementById("incorrecto").innerHTML = "Por favor acepta terminos y condiciones."
    }
    else{
        window.location = "..//index.html"
    }

}

function imagen(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        
        reader.onload = function (e) {
            $('#ImgProfile').attr('src', e.target.result).show();
        };

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function () {
    imagen(this);
});
