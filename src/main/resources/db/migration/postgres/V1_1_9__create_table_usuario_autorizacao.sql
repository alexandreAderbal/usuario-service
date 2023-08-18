CREATE TABLE USUARIO_AUTORIZACAO (
	ID serial PRIMARY KEY,
	ID_USUARIO int REFERENCES USUARIO (ID),
	ID_PERMISSAO int REFERENCES PERMISSAO (ID),
	ID_PREVILEGIO int REFERENCES PREVILEGIO (ID),
	USUARIO_CRIACAO  VARCHAR(250),
    USUARIO_ALTERACAO VARCHAR(250),
    DATA_CRIACAO TIMESTAMP,
    DATA_ALTERACAO TIMESTAMP
);