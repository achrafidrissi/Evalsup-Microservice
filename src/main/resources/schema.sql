CREATE TABLE Formations (
    Id_Formation INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(100) NOT NULL
);

CREATE TABLE Modules (
    Id_Modules INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(100) NOT NULL,
    Id_Formation INT,
    FOREIGN KEY (Id_Formation) REFERENCES Formations(Id_Formation)
);

CREATE TABLE SousModules (
     Id_chapitres INT PRIMARY KEY AUTO_INCREMENT,
     titre VARCHAR(100),
     Id_Modules INT,
     FOREIGN KEY (Id_Modules) REFERENCES Modules(Id_Modules)
);

CREATE TABLE Professeurs (
     code_prof VARCHAR(20) PRIMARY KEY,
     Id_Personne INT
    -- Pas de FOREIGN KEY ici car Personne est dans un autre service
);

CREATE TABLE Etudiants (
       code_etu VARCHAR(20) PRIMARY KEY,
       Id_Personne INT
    -- Même remarque ici
);
