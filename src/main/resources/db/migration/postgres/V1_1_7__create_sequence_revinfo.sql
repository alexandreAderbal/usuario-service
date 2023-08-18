CREATE SEQUENCE IF NOT EXISTS public.revinfo_seq
    INCREMENT 50
    START 1
    CACHE 1
    OWNED BY REVINFO.REV;

ALTER SEQUENCE public.revinfo_seq
    OWNER TO postgres;