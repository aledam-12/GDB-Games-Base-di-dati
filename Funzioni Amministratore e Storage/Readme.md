<pre> In questa cartella ci sarà l'implementazione dei bean con una pagina jsp per il catalogo e le funzioni amministratore e il control

/**** per il control **** \
creare classe che estende httpservlet <br/>
istanziare oggetto product model con costruttore <br/>
  nel doGet: <br/>
  try - catch per SQL Exception <br/>
    prendere campo action dalla richiesta (se non è nullo) <br/>
      se action = read, prendere l'id della copia, settare l'attributo id = a quello che si ottiene facendo doRetrievebyKey, inoltrare la richiesta a vediProdotto.jsp <br/>
      se action = delete, prendere l'id della copia e chiamare il doDelete <br/>
      se action = insert, prendere in input i vari campi dalla richiesta e chiamare il doSave, instanziando prima il bean corretto <br/>
    inoltrare la richiesta a vediCatalogo.jsp <br/>
    in caso di errore (nel catch) ridirezionare alla schermata di errore <br/>
</pre>
