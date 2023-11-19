CREATE TABLE Compras(
    id SERIAL PRIMARY KEY,
    id_item BIGINT,
    qtd_item INT,
    valor INT,
    validade DATE,
    data_compra DATE,
    FOREIGN KEY (id_item) REFERENCES Items(id)
);