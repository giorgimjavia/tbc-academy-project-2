CREATE TABLE LocationAddress (
    id INT PRIMARY KEY IDENTITY(1,1),
    city VARCHAR(100),
    address VARCHAR(255)
);

INSERT INTO LocationAddress (city, address) VALUES
('Abastumani', '#41 Asatiani Str.'),
('Anaklia', 'Anaklia Vlg.'),
('Chiatura', '#1 Dzmebi Dekanozishvilebi Str.'),
('Ksani', 'Ksani Vlg.'),
('Surami', '#136 Rustaveli Str.');