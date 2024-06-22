let formConsole = document.getElementById("Searchbar Console");
let formTitolo = document.getElementById("Searchbar Titolo");
var xhr = new XMLHttpRequest();
formTitolo.addEventListener('keypress', function (event) {	
	xhr.open("POST", "./Searchbar", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let titolo = formTitolo.value;
	let piattaforma = formConsole.value;
	xhr.send("search=" + encodeURIComponent(titolo) + "&console=" + encodeURIComponent(piattaforma));
});
formConsole.addEventListener('change', function (event) {
	xhr.open("POST", "./Searchbar", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let titolo = formTitolo.value;
	let piattaforma = formConsole.value;
	xhr.send("search=" + encodeURIComponent(titolo) + "&console=" + encodeURIComponent(piattaforma));
});

function rimuoviRighe() {
    // Rimuovere tutte le righe esistenti nella tabella
    let tabella = document.getElementById("SearchResult");
	while (tabella.rows.length >= 1) {
		console.log("cancello riga" + tabella.rows.length);
        tabella.deleteRow(0);
    }
}

xhr.onreadystatechange = function() {
  if (xhr.readyState === 4 && xhr.status === 200) {
    var response = JSON.parse(xhr.responseText);
    console.log("Response: "+response);

    var table = document.getElementById("SearchResult");
    table.style.color = "white";
    
    rimuoviRighe();
    for (var i = 0; i < response.length; i++) {
  var row = table.insertRow(i); 
  
  var cellImg = row.insertCell(0);
  cellImg.innerHTML = '<img src = "./getFoto?titolo='+ response[i].titolo + '"alt = "immagine non trovata">';
  console.log (cellImg.innerHTML);
  
  var cellTitolo = row.insertCell(1);
  cellTitolo.innerHTML = response[i].titolo;

  var cellPrezzo = row.insertCell(2);
  cellPrezzo.innerHTML = response[i].prezzo;

  var cellConsole = row.insertCell(3);
  cellConsole.innerHTML = response[i].console;

  var cellQuantita = row.insertCell(4);
  cellQuantita.innerHTML = response[i].quantita;
}    

  }
};
