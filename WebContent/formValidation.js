document.getElementById("signUpForm").addEventListener('submit', function (event) {
    let valido = document.getElementsByClassName("form-not-valid")[0];
    valido.innerHTML = ""; 

    let email = document.getElementById("reg-mail");
    let valEmail = email.value
    const regexEmail = /^[a-z0-9._%-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
    //@  obbligatorio, inclusi caratteri speciali solo minuscole


    if(!regexEmail.test(valEmail)) {
        event.preventDefault(); //impedire l'invio del form in caso non c e pattern 

        let textNode = document.createTextNode("Formato email non valido");
        valido.appendChild(textNode);
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    let password = document.getElementById("reg-password");
    let passwordVal = password.value
    const regexPass = /^[A-Za-z0-9.]{3,16}$/;
    //solo alfanumerici 

    if(!regexPass.test(passwordVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato password non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    let nome = document.getElementById("reg-nome");
    let nomeVal = nome.value
    const regexNome = /^[A-Za-z]{2,30}$/;

    if(!regexNome.test(nomeVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato nome non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    let cognome = document.getElementById("reg-cognome");
    let cognomeVal = cognome.value
    const regexCognome = /^[A-Za-z]{2,30}$/;

    if(!regexCognome.test(cognomeVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato cognome non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }



    let via = document.getElementById("reg-via");
    let viaVal = via.value
    const regexVia = /^[A-Za-z]{2,30}$/;


    if(!regexVia.test(viaVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato via non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    let civico = document.getElementById("reg-civico");
    let ciicoVal = civico.value
    const regexCivico = /^[0-9]{1,4}$/;

    if(!regexCivico.test(civicoVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato civico non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    let cap = document.getElementById("reg-cap");
    let capVal = cap.value
    const regexCap = /^\d{5}$/;

    if(!regexCap.test(capVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato cap non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    
    let provincia = document.getElementById("reg-provincia");
    let provinciaVal = provincia.value
    const regexProvincia = /^[A-Z]{2}$/;

    if(!regexProvincia.test(capProvincia)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato Provincia non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }
});



document.getElementById("loginForm").addEventListener('submit', function (event) {
    let valido = document.getElementsByClassName("form-not-valid")[0];
    valido.innerHTML = ""; 

    let username = document.getElementById("log-username");
    let valUsername = username.value
    const regexUser = /^[a-z0-9._%-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
 


    if(!regexEmail.test(valUsername)) {
        event.preventDefault(); 

        let textNode = document.createTextNode("Formato email non valido");
        valido.appendChild(textNode);
        let br = document.createElement("br");
        valido.appendChild(br);
    }

    let password = document.getElementById("log-password");
    let passwordVal = password.value
    const regexPass = /^[A-Za-z0-9.]{3,16}$/;

    if(!regexPass.test(passwordVal)) {
        event.preventDefault();
        let textNode = document.createTextNode("Formato password non valido");
        valido.appendChild(textNode);
        document.createElement("br");
        let br = document.createElement("br");
        valido.appendChild(br);
    }

});