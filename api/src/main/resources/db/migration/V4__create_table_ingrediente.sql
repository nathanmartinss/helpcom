CREATE TABLE Ingredientes (
    id SERIAL PRIMARY KEY,
    id_item BIGINT,
    id_receita BIGINT,
    qtd_ingrediente INT,
    unidade_medida VARCHAR(5),
    FOREIGN KEY (id_item) REFERENCES Items(id),
    FOREIGN KEY (id_receita) REFERENCES Receitas(id)
);