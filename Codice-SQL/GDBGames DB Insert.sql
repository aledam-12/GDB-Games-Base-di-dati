-- Inserimento nella tabella cliente
INSERT INTO cliente (email, nome, cognome, pw) 
VALUES ('cliente1@email.com', 'Mario', 'Rossi', 'hash1'),
       ('cliente2@email.com', 'Luigi', 'Verdi', 'hash2'),
       ('cliente3@email.com', 'Paolo', 'Bianchi', 'hash3');

-- Inserimento nella tabella acquisto
INSERT INTO acquisto (dataAcquisto, via, cap, città, prezzoTotale) 
VALUES ('2024-04-01', 'Via Roma 1', 20100, 'Milano', 49.99),
       ('2024-04-05', 'Via Garibaldi 10', 10100, 'Torino', 29.99),
       ('2024-04-10', 'Corso Vittorio Emanuele 15', 90100, 'Napoli', 39.99);

-- Inserimento nella tabella genere
INSERT INTO genere (nome) 
VALUES ('Azione'), ('Avventura'), ('Sport');

-- Inserimento nella tabella console
INSERT INTO console (nome) 
VALUES ('PlayStation 5'), ('Xbox Series X'), ('Nintendo Switch');

-- Inserimento nella tabella videogioco 
INSERT INTO videogioco (console, titolo, descrizione, pegi) 
VALUES ('PlayStation 5', 'Spider-Man: Miles Morales', "Un gioco d'azione avvincente ambientato nell'universo di Spider-Man.", 16),
       ('Xbox Series X', 'Halo Infinite', "Un'epica avventura spaziale con azione frenetica.", 18),
       ('Nintendo Switch', 'The Legend of Zelda: Breath of the Wild', 'Esplora il vasto regno di Hyrule in questa avventura epica.', 12);

-- Inserimento nella tabella distinzione --
INSERT INTO distinzione (titoloVideogioco, nomeGenere) 
VALUES ('Spider-Man: Miles Morales', 'Azione'),
       ('Halo Infinite', 'Azione'),
       ('The Legend of Zelda: Breath of the Wild', 'Avventura');

-- Inserimento nella tabella copia
INSERT INTO copia (stato, prezzo, codiceAcquisto, titoloVideogioco, nomeConsole) 
VALUES (1, 10, 1, 'Spider-Man: Miles Morales', 'PlayStation 5'),
       (1, 15, 2, 'Halo Infinite', 'Xbox Series X'),
       (1, 25, 3, 'The Legend of Zelda: Breath of the Wild', 'Nintendo Switch');

-- Inserimento nella tabella reclamo
INSERT INTO reclamo (dataReclamo, titolo, contenuto, emailCliente) 
VALUES ('2024-04-15', 'Problema di grafica', 'Il gioco presenta problemi di grafica su determinate scene.', 'cliente1@email.com'),
       ('2024-04-16', 'Bug multiplayer', 'Riscontrato un bug nel multiplayer che causa il crash del gioco.', 'cliente2@email.com');
