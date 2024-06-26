<h1> OrdineCopia </h1>

<p> OrdineCopia &egrave; una classe che si trova nel package model. Essa estende la classe CopiaBean presente nel package model.beans </p>
<h2>Scopo</h2> <br>
<p>Poich&eacute; nel database le copie sono memorizzate singolarmente, c'era bisogno di una classe che potesse memorizzare sia i vari attributi presenti nella classe CopiaBean,
ma che potesse anche memorizzare un attributo quantit&agrave;
L'attributo quantit&agrave; serve a: 
    <ul>
      <li>Memorizzare la quantit&agrave; selezionata dall'utente per la gestione del carrello</li>
      <li>Memorizzare la quantit&agrave; dei prodotti che sono in vendita di un determinato tipo di videogioco</li>
      <li>Memorizzare la quantit&agrave; di prodotti per un determinato acquisto effettuato</li>
    </ul>
Da ci&ograve; che si evince dall'elenco, l'attributo quantit&agrave; varia di significato a seconda delle necessit&agrave;
<h2> Metodi della classe </h2> <br>
<table>
  <tr>
    <th>Dichiarazione</th>
    <th>Scopo</th>
  </tr>
  <tr>
    <td>getQuantit&agrave;() </td>
    <td>ritorna la quantit&agrave;</td>
  </tr>
  <tr>
    <td>setQuantit&agrave;()</td>
    <td>Imposta la quantit&agrave;</td>
  </tr>
  <tr>
    <td>public OrdineCopia (int quantità, CopiaBean a)</td>
    <td>Costruttore che include anche la quantità</td>
  </tr>
    <tr>
    <td>public OrdineCopia (CopiaBean a)</td>
    <td>Costruttore che non include la quantità, usato ad esempio per creare variabili temporanee</td>
  </tr>
    <tr>
    <td>public float getPrezzoTotale() </td>
    <td>Ritorna il prezzo totale di tale quantità di copie (le copie avranno tutte lo stesso prezzo)</td>
  </tr>
    <tr>
    <td>public boolean equals(Object b)</td>
    <td>Override del metodo equals presente nella superclasse Object, viene utilizzato soprattutto per verificare se in un array di OrdineCopia è presente o meno un oggetto uguale.
      Viene confrontato il titolo del videogioco, il nome della console e il prezzo. Se tali attributi sono uguali, allora i due oggetti OrdineCopia sono uguali.
    </td>
  </tr>
</table>
</h3>
<h2>Metodi in cui viene usata la classe OrdineCopia</h2>
<p> Verranno visti solo i metodi pi&ugrave; siginificativi dove viene sfruttata tale classe
    <h4>public synchronized int getQuantità (CopiaBean copia) throws SQLException</h4> <!-- Lasciare spazio sopra ai ~ -->
Utilizza la seguente query: 
  
~~~

SELECT COUNT(*) as quantità, nomeConsole, titoloVideogioco, prezzo FROM copia WHERE stato = 0                  
AND titoloVideogioco = ? AND nomeConsole = ? AND prezzo = ? GROUP BY nomeConsole, titoloVideogioco, prezzo

~~~

Serve per verificare la disponibilità di una certa quantità di prodotti nel database quando nel carrello viene modificata la quantità dall'utente

#### public synchronized CopiaBean leggiOrdineCopia (OrdineCopia ord) throws SQLException 

Utilizza la seguente query: 

~~~

SELECT * FROM copia WHERE titoloVideogioco = ? AND nomeConsole = ? AND prezzo = ? AND stato = 0

~~~

Serve per ottenere un bean di copia con le caratteristiche specificate nella clausola WHERE e serve per andare a modificare una singola copia nel database. Usato sopratutto in fase
di checkout, per eliminare delle copie nelle funzioni admin.


><h2>POSSIBILI DOMANDE</h2>
><h4>Come si apportano modifiche a livello di database partendo da OrdineCopia?</h4>
>Ancora una volta si sfrutta il metodo leggiOrdineCopia, così da avere un singolo oggetto CopiaBean, successivamente si itera lo stesso metodo fino a quando non si raggiunge la quantità necessaria
><h4>Hai modificato qualcosa a livello di database?</h4>
>No, tale classe serve proprio per questo scopo, crea dunque un'interfaccia con le quantità sebbene le copie siano memorizzate singolarmente.


>[!IMPORTANT] 
> Per ulteriori domande scrivete su Whatsapp. Alessandro D'Ambrosio


