CREATE TABLE PREVILEGIO (
	ID serial PRIMARY KEY,
	NOME VARCHAR ( 150 ) UNIQUE NOT NULL,
	USUARIO_CRIACAO  VARCHAR(250),
    USUARIO_ALTERACAO VARCHAR(250),
    DATA_CRIACAO TIMESTAMP,
    DATA_ALTERACAO TIMESTAMP
);