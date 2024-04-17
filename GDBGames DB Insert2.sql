-- Inserimento nella tabella cliente
INSERT INTO cliente (email, nome, cognome, pw) 
VALUES ('cliente4@email.com', 'Laura', 'Bianchi', 'hash4'),
       ('cliente5@email.com', 'Marco', 'Ferrari', 'hash5');

-- Inserimento nella tabella acquisto
INSERT INTO acquisto (dataAcquisto, via, cap, città, prezzoTotale) 
VALUES ('2024-04-02', 'Via Dante 20', 40100, 'Bologna', 19.99),
       ('2024-04-07', 'Corso Italia 5', 20100, 'Milano', 59.99);
select * from distinzione;
-- Inserimento nella tabella genere
INSERT INTO genere (nome) 
VALUES ('RPG'), ('FPS').("Simulazione");

-- Inserimento nella tabella console
INSERT INTO console (nome) 
VALUES ('PC'), ('Nintendo Switch2');

-- Inserimento nella tabella videogioco
INSERT INTO videogioco (console, titolo, descrizione, pegi) 
VALUES ('PC', 'The Witcher 3: Wild Hunt', 'Un vasto mondo aperto pieno di avventure, mostri e intrighi politici.', 18),
       ('Nintendo Switch2', 'Animal Crossing: New Horizons', "Crea il tuo paradiso tropicale su un'isola deserta.", 3);

-- Inserimento nella tabella distinzione
INSERT INTO distinzione (titoloVideogioco, nomeGenere) 
VALUES ('The Witcher 3: Wild Hunt', 'RPG'),
       ('Animal Crossing: New Horizons', 'Simulazione');

-- Inserimento nella tabella copia
INSERT INTO copia (stato, prezzo, codiceAcquisto, titoloVideogioco, nomeConsole) 
VALUES (1, 19.99, 4, 'The Witcher 3: Wild Hunt', 'PC'),
       (1, 59.99, 5, 'Animal Crossing: New Horizons', 'Nintendo Switch2');

-- Inserimento nella tabella reclamo
INSERT INTO reclamo (dataReclamo, titolo, contenuto, emailCliente) 
VALUES ('2024-04-12', 'Spedizione ritardata', 'Il pacco è arrivato con notevole ritardo rispetto alla data prevista.', 'cliente4@email.com'),
       ('2024-04-14', 'Errore di fatturazione', "Il prezzo totale addebitato non corrisponde a quello visualizzato durante l'acquisto.", 'cliente5@email.com');
