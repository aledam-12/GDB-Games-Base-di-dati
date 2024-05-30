use gdbgames;
-- Inserimento dei clienti
INSERT INTO cliente (email, nome, cognome, pw, via, civico, città, provincia, cap, stato) 
VALUES
('mariorossi@email.com', 'Mario', 'Rossi', 'hashed_password1', 'Via Roma', 123, 'Milano', 'MI', 20100, 'utente'),
('luigiverdi@email.com', 'Luigi', 'Verdi', 'hashed_password2', 'Via Roma', 23, 'Caserta', 'CE', 81100, 'utente'),
('peppeneri@email.com', 'Peppe', 'Neri', 'hashed_password3', 'Corso Trieste', 12, 'Caserta', 'CE', 81100, 'utente'),
('admin@email.com', 'pippo', 'admin', 'hashed_password4', 'Via Napoli', 10, 'Napoli', 'NA', 34102, 'admin');


-- Inserimento degli acquisti
INSERT INTO acquisto (emailCliente, ncarta, nFattura, dataAcquisto, via, cap, città, prezzoTotale) VALUES
('mariorossi@email.com', 1234567890123456, 1, '2024-05-28', 'Via Roma', 20100, 'Milano', 100.50),
('luigiverdi@email.com', 1234569890125412, 2, '2024-02-10', 'Via Acquaviva', 81100, 'Caserta', 200.50),
('peppeneri@email.com', 1134565590123488, 3,  '2023-12-18', 'Via Roma', 81100, 'Caserta', 500.50);

-- Inserimento dei generi
INSERT INTO genere (nome) 
VALUES 
    ( 'Avventura Storica'),
    ( 'Avventura Epica'),
    ( 'Sparatutto in Prima Persona'),
    ( 'Azione Open-World'),
    ( 'Simulazione di Calcio'),
    ( 'Avventura Post-Apocalittica'),
    ( 'Sparatutto Tattico'),
    ( 'Azione e Avventura'),
    ( 'Platformer'),
    ( 'GDR Epico'),
    ( 'Avventura Open-World');

-- Inserimento delle console
INSERT INTO console (nome) 
VALUES 
('Ps4'),
('Xbox'),
('Switch'),
('PC');

-- Inserimento dei videogiochi
INSERT INTO videogioco (img, titolo, descrizione, pegi) 
VALUES
(null, 'Assassin''s Creed 3', 'Avventura storica che ti porta nel cuore della Rivoluzione Americana. Nei panni di Connor, un assassino nativo americano, combatti per la libertà del tuo popolo e per la giustizia, in un mondo ricco di dettagli storici accurati.', 18),
(null, 'Assassin''s Creed Valhalla', 'Un''Epica avventura vichinga che ti porta nelle terre selvagge dell''Inghilterra medievale. Guida Eivor, un temibile guerriero vichingo, attraverso battaglie sanguinose, alleanze politiche e misteri ancestrali.', 18),
(null, 'Call of Duty: Modern Warfare', 'Un intenso sparatutto in prima persona che ti immerge in una trama realistica e coinvolgente. Combatti in scenari dettagliati e realistici, affrontando minacce globali e terrorismo.', 18),
(null, 'Far Cry 3', 'Un''avventura open-world ambientata su un''isola tropicale paradisiaca ma pericolosa. Esplora l''isola, sopravvivi ai suoi pericoli e affronta nemici spietati per salvare i tuoi amici.', 18),
(null, 'Far Cry 6', 'Un''avventura open-world ambientata in Yara, un''immaginaria isola caraibica. Lotta contro il dittatore Anton Castillo e i suoi sostenitori per liberare l''isola e il suo popolo.', 18),
(null, 'FIFA 24', 'La simulazione di calcio definitiva con squadre e giocatori reali. Vivi l''emozione del calcio, gestisci la tua squadra e competi in tornei internazionali.', 3 ),
(null, 'GTA 5', 'Un''avventura open-world piena di azione, crimini e veicoli. Esplora la vasta città di Los Santos, commetti crimini audaci e costruisci il tuo impero criminale.', 18),
(null, 'Horizon Forbidden West', 'Un''avventura post-apocalittica in un mondo dominato da creature robotiche. Esplora le rovine dell''America, scopri segreti antichi e lotta per la sopravvivenza.', 18),
(null, 'Rainbow Six Siege', 'Un intenso sparatutto tattico in squadra. Scegli tra una varietà di operatori speciali, costruisci difese, pianifica strategie e lavora in squadra per la vittoria.', 18),
(null, 'Sekiro: Shadows Die Twice', 'Un''avventura d''azione ambientata nel Giappone feudale. Affronta nemici letali, scopri segreti oscuri e lotta per la tua sopravvivenza in un mondo brutale e bellissimo.', 18),
(null, 'Super Mario Odyssey', 'Un divertente platformer con il famoso Mario. Esplora mondi fantastici, raccogli lune per alimentare il tuo vascello e salva la principessa Peach dalle grinfie di Bowser.', 3),
(null, 'The Witcher 3: Wild Hunt', 'Un GDR epico che ti mette nei panni di Geralt, un cacciatore di mostri. Esplora un mondo vasto e affascinante, affronta creature leggendarie e prendi decisioni che influenzano il corso della storia.', 18),
(null, 'The Legend of Zelda: Breath of the Wild', 'Un''avventura open-world con Link. Esplora il vasto regno di Hyrule, risolvi enigmi complessi, sconfiggi nemici e salva la principessa Zelda.', 12);

-- Inserimento delle distinzioni (associazione tra videogiochi e generi)
INSERT INTO distinzione (titoloVideogioco, nomeGenere) 
VALUES 
    ('Assassin''s Creed 3', 'Avventura Storica'),
    ('Assassin''s Creed Valhalla', 'Avventura Epica'),
    ('Call of Duty: Modern Warfare', 'Sparatutto in Prima Persona'),
    ('Far Cry 3', 'Azione Open-World'),
    ('Far Cry 6', 'Azione Open-World'),
    ('FIFA 24', 'Simulazione di Calcio'),
    ('GTA 5', 'Azione Open-World'),
    ('Horizon Forbidden West', 'Avventura Post-Apocalittica'),
    ('Rainbow Six Siege', 'Sparatutto Tattico'),
    ('Sekiro: Shadows Die Twice', 'Azione e Avventura'),
    ('Super Mario Odyssey', 'Platformer'),
    ('The Witcher 3: Wild Hunt', 'GDR Epico'),
    ('The Legend of Zelda: Breath of the Wild', 'Avventura Open-World');

-- Inserimento delle copie
INSERT INTO copia (stato, percIva, prezzo, codiceAcquisto, titoloVideogioco, nomeConsole) 
VALUES 
(true, 22.0, 49.99, 1, 'GTA 5', 'Ps4'),
(true, 22.0, 59.99, 1, 'Assassin''s Creed 3', 'Ps4'),
(true, 22.0, 39.99, 1, 'FIFA 24', 'Ps4'),
(true, 22.0, 49.99, 2, 'Far Cry 6', 'Xbox'),
(true, 22.0, 59.99, 2, 'Call of Duty: Modern Warfare', 'Xbox'),
(true, 22.0, 39.99, 2, 'Rainbow Six Siege', 'Xbox'),
(true, 22.0, 49.99, 3, 'The Legend of Zelda: Breath of the Wild', 'Switch'),
(true, 22.0, 59.99, 3, 'Super Mario Odyssey', 'Switch'),
(true, 22.0, 39.99, 3, 'Horizon Forbidden West', 'Switch'),
(false, 22.0, 49.99, NULL, 'GTA 5', 'Ps4'),
(false, 22.0, 59.99, NULL, 'Assassin''s Creed Valhalla', 'Ps4'),
(false, 22.0, 39.99, NULL, 'Far Cry 3', 'Ps4'),
(false, 22.0, 49.99, NULL, 'Sekiro: Shadows Die Twice', 'Xbox'),
(false, 22.0, 59.99, NULL, 'The Witcher 3: Wild Hunt', 'Xbox'),
(false, 22.0, 39.99, NULL, 'The Legend of Zelda: Breath of the Wild', 'Switch'),
(false, 22.0, 49.99, NULL, 'Super Mario Odyssey', 'Switch'),
(false, 22.0, 59.99, NULL, 'FIFA 24', 'Switch'),
(false, 22.0, 49.99, NULL, 'GTA 5', 'Xbox'),
(false, 22.0, 49.99, NULL, 'GTA 5', 'PC'),
(false, 22.0, 59.99, NULL, 'Assassin''s Creed Valhalla', 'Xbox'),
(false, 22.0, 59.99, NULL, 'Assassin''s Creed Valhalla', 'PC'),
(false, 22.0, 39.99, NULL, 'Far Cry 3', 'Xbox'),
(false, 22.0, 39.99, NULL, 'Far Cry 3', 'PC'),
(false, 22.0, 49.99, NULL, 'Sekiro: Shadows Die Twice', 'Ps4'),
(false, 22.0, 49.99, NULL, 'Sekiro: Shadows Die Twice', 'PC'),
(false, 22.0, 59.99, NULL, 'The Witcher 3: Wild Hunt', 'Ps4'),
(false, 22.0, 59.99, NULL, 'The Witcher 3: Wild Hunt', 'PC'),
(false, 22.0, 39.99, NULL, 'The Legend of Zelda: Breath of the Wild', 'Ps4'),
(false, 22.0, 39.99, NULL, 'The Legend of Zelda: Breath of the Wild', 'PC'),
(false, 22.0, 49.99, NULL, 'Super Mario Odyssey', 'Ps4'),
(false, 22.0, 49.99, NULL, 'Super Mario Odyssey', 'PC'),
(false, 22.0, 59.99, NULL, 'FIFA 24', 'Ps4'),
(false, 22.0, 59.99, NULL, 'FIFA 24', 'PC');
  
-- Inserimento dei reclami
INSERT INTO reclamo (dataReclamo, nReclamo, titolo, contenuto, emailCliente) 
VALUES 
('2023-02-10', 1, 'Problema con il download', 'Non riesco a scaricare il gioco acquistato.', 'mariorossi@email.com'),
('2024-08-15', 2, 'Gioco difettoso', 'Il gioco si blocca continuamente durante il caricamento.', 'luigiverdi@email.com'),
('2022-12-18', 3, 'Codice di attivazione non funzionante', 'Il codice di attivazione fornito non funziona.', 'peppeneri@email.com'),
('2024-05-20', 4, 'Consegna in ritardo', 'Il gioco acquistato non è ancora stato consegnato nonostante la data di rilascio sia già passata.', 'mariorossi@email.com'),
('2024-05-25', 5, 'Grafica difettosa', 'La grafica del gioco presenta difetti e glitch che rendono l’esperienza di gioco impossibile.', 'luigiverdi@email.com');


INSERT INTO videogioco (titolo, img)
VALUES 
('Assassin''s Creed 3', LOAD_FILE('Progetto TSW 2/foto/assassin-creed-III.jpg')),
('Assassin''s Creed vhalalla', LOAD_FILE('Progetto TSW 2/foto/assassin-creed-vhalalla.jpg'));
