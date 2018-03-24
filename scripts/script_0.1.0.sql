CREATE TABLE st_bovespa (
  id         SERIAL NOT NULL,
  ativo      VARCHAR(255),
  data       VARCHAR(255),
  volume     VARCHAR(255),
  abertura   VARCHAR(255),
  fechamento VARCHAR(255),
  minima     VARCHAR(255),
  maxima     VARCHAR(255),
  media      VARCHAR(255),
  CONSTRAINT pk_st_bovespa PRIMARY KEY (id) );