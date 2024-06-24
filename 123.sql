SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE SEQUENCE public.currencies_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.currencies_id_seq OWNER TO bsuir_guy;

SET default_tablespace = '';
SET default_table_access_method = heap;

CREATE TABLE public.currencies (
    value double precision NOT NULL,
    name text,
    symbol character varying NOT NULL,
    id integer DEFAULT nextval('public.currencies_id_seq'::regclass) NOT NULL
);


ALTER TABLE public.currencies OWNER TO bsuir_guy;

ALTER TABLE ONLY public.currencies
    ADD CONSTRAINT currencies_pkey PRIMARY KEY (id);

CREATE UNIQUE INDEX symbol_unique ON public.currencies USING btree (symbol);

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON TABLES  TO bsuir_guy;
