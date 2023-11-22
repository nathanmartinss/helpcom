CREATE TABLE Producoes (
    id SERIAL PRIMARY KEY,
    id_receita BIGINT,
    valor BIGINT,
    margem_lucro DOUBLE PRECISION,
    FOREIGN KEY (id_receita) REFERENCES Receitas(id)
);