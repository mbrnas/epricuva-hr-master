--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2024-02-20 22:32:36 CET

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16470)
-- Name: stan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stan (
    id bigint NOT NULL,
    broj_stana character varying(255),
    kat integer NOT NULL,
    kvadratura double precision NOT NULL,
    vlasnik_id bigint,
    zgrada_id bigint
);


ALTER TABLE public.stan OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16469)
-- Name: stan_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.stan_id_seq OWNER TO postgres;

--
-- TOC entry 3610 (class 0 OID 0)
-- Dependencies: 216
-- Name: stan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.stan_id_seq OWNED BY public.stan.id;


--
-- TOC entry 219 (class 1259 OID 16477)
-- Name: vlasnik; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vlasnik (
    id bigint NOT NULL,
    email character varying(255),
    ime character varying(255),
    oib character varying(255),
    prezime character varying(255),
    telefon character varying(255)
);


ALTER TABLE public.vlasnik OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16476)
-- Name: vlasnik_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vlasnik_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.vlasnik_id_seq OWNER TO postgres;

--
-- TOC entry 3611 (class 0 OID 0)
-- Dependencies: 218
-- Name: vlasnik_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vlasnik_id_seq OWNED BY public.vlasnik.id;


--
-- TOC entry 215 (class 1259 OID 16462)
-- Name: zgrada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zgrada (
    id bigint NOT NULL,
    adresa character varying(255),
    drzava character varying(255),
    godina_izgradnje character varying(255),
    grad character varying(255),
    broj_katova integer NOT NULL,
    broj_stanova integer NOT NULL,
    ulica character varying(255)
);


ALTER TABLE public.zgrada OWNER TO postgres;

--
-- TOC entry 3452 (class 2604 OID 16473)
-- Name: stan id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stan ALTER COLUMN id SET DEFAULT nextval('public.stan_id_seq'::regclass);


--
-- TOC entry 3453 (class 2604 OID 16480)
-- Name: vlasnik id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vlasnik ALTER COLUMN id SET DEFAULT nextval('public.vlasnik_id_seq'::regclass);


--
-- TOC entry 3457 (class 2606 OID 16475)
-- Name: stan stan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stan
    ADD CONSTRAINT stan_pkey PRIMARY KEY (id);


--
-- TOC entry 3459 (class 2606 OID 16484)
-- Name: vlasnik vlasnik_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vlasnik
    ADD CONSTRAINT vlasnik_pkey PRIMARY KEY (id);


--
-- TOC entry 3455 (class 2606 OID 16468)
-- Name: zgrada zgrada_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zgrada
    ADD CONSTRAINT zgrada_pkey PRIMARY KEY (id);


--
-- TOC entry 3460 (class 2606 OID 16490)
-- Name: stan fkprjrf7jt3sgn7y5jwlbjw67sk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stan
    ADD CONSTRAINT fkprjrf7jt3sgn7y5jwlbjw67sk FOREIGN KEY (zgrada_id) REFERENCES public.zgrada(id);


--
-- TOC entry 3461 (class 2606 OID 16485)
-- Name: stan fkq1mbihc6j2iasmmaogimcfo5h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stan
    ADD CONSTRAINT fkq1mbihc6j2iasmmaogimcfo5h FOREIGN KEY (vlasnik_id) REFERENCES public.vlasnik(id);


-- Completed on 2024-02-20 22:32:36 CET

--
-- PostgreSQL database dump complete
--

