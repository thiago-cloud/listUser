create TABLE usuario(
	 id bigserial NOT NULL,
    ativo boolean,
    cpf character varying(30),
    data_nascimento date,
    email character varying(50),
    login character varying(50),
    nome character varying(255),
    password character varying(50),
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
)