-- Generado por Oracle SQL Developer Data Modeler 19.2.0.182.1216
--   en:        2021-04-08 19:58:30 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE alumno (
    id                       INTEGER NOT NULL,
    dni                      INTEGER NOT NULL,
    nombre_completo          VARCHAR2(60) NOT NULL,
    email_institucional      VARCHAR2(60) NOT NULL,
    email_personal           VARCHAR2(60) NOT NULL,
    teléfono                 INTEGER,
    móvil                    INTEGER,
    direccion_notificacion   VARCHAR2(30) NOT NULL,
    localidad_notificacion   VARCHAR2(30) NOT NULL,
    provincia_notificacion   VARCHAR2(30) NOT NULL,
    cp_notificacion          VARCHAR2(30) NOT NULL,
    apellido_1               VARCHAR2(4000) NOT NULL,
    apellido_2               VARCHAR2(4000)
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id );

ALTER TABLE alumno ADD CONSTRAINT alumno_dni_un UNIQUE ( dni );

CREATE TABLE asignatura (
    referencia                         INTEGER NOT NULL,
    codigo                             INTEGER NOT NULL,
    créditos_totales                   INTEGER NOT NULL,
    ofertada                           CHAR(1) NOT NULL,
    nombre                             VARCHAR2(30) NOT NULL,
    curso                              INTEGER,
    carácter                           VARCHAR2(20),
    duración                           INTEGER,
    "Unidad_Temporal_(Cuatrimestre)"   INTEGER,
    idiomas_de_impartición             VARCHAR2(20),
    titulación_código                  INTEGER NOT NULL,
    créditos_practicos                 INTEGER NOT NULL,
    créditos_teoricos                  INTEGER NOT NULL
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( referencia );

CREATE TABLE asignaturas_matricula (
    grupo_id                               INTEGER,
    optativas_referencia                   INTEGER NOT NULL,
    matricula_curso_academico              INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    matricula_expedientes_num_expediente   INTEGER NOT NULL,
    calificacion                           VARCHAR2(4000),
    matricula_id                           INTEGER NOT NULL
);

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_pk PRIMARY KEY ( optativas_referencia,
                                                          matricula_expedientes_num_expediente,
                                                          matricula_id );

CREATE TABLE centro (
    id                INTEGER NOT NULL,
    nombre            VARCHAR2(60) NOT NULL,
    dirección         VARCHAR2(60) NOT NULL,
    tlf_conserjeria   VARCHAR2(60) NOT NULL
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( id );

ALTER TABLE centro ADD CONSTRAINT centro_nombre_un UNIQUE ( nombre );

CREATE TABLE clase (
    dia                     VARCHAR2(10) NOT NULL,
    hora_inicio             DATE NOT NULL,
    hora_fin                DATE,
    asignatura_referencia   INTEGER NOT NULL,
    grupo_id                INTEGER NOT NULL,
    aula                    VARCHAR2(4000)
);

ALTER TABLE clase
    ADD CONSTRAINT clase_pk PRIMARY KEY ( dia,
                                          hora_inicio,
                                          grupo_id );

CREATE TABLE encuesta (
    fecha_de_envío               DATE NOT NULL,
    expedientes_num_expediente   INTEGER NOT NULL,
    id                           INTEGER NOT NULL
);

ALTER TABLE encuesta ADD CONSTRAINT encuesta_pk PRIMARY KEY ( expedientes_num_expediente,
                                                              id );

CREATE TABLE expedientes (
    num_expediente           INTEGER NOT NULL,
    activo                   CHAR(1),
    nota_media_provisional   NUMBER,
    titulación_código        INTEGER NOT NULL,
    alumno_id                INTEGER NOT NULL,
    creditos_superados       INTEGER NOT NULL,
    creditos_fb              INTEGER NOT NULL,
    creditos_ob              INTEGER NOT NULL,
    creditos_op              INTEGER NOT NULL,
    creditos_cf              INTEGER NOT NULL,
    creditos_pe              INTEGER NOT NULL,
    creditos_tf              INTEGER NOT NULL
);

ALTER TABLE expedientes ADD CONSTRAINT expedientes_pk PRIMARY KEY ( num_expediente );

CREATE TABLE grupo (
    id                   INTEGER NOT NULL,
    curso                INTEGER NOT NULL,
    letra                VARCHAR2(1) NOT NULL,
    turno_mañana_tarde   VARCHAR2(10) NOT NULL,
    ingles               CHAR(1) NOT NULL,
    titulación_código    INTEGER NOT NULL,
    grupo_id             INTEGER,
    visible              CHAR(1),
    asignar              VARCHAR2(20),
    plazas               INTEGER
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id );

ALTER TABLE grupo ADD CONSTRAINT grupo_curso_letra_un UNIQUE ( curso,
                                                               letra );

CREATE TABLE grupos_por_asignatura (
    curso_academico         INTEGER NOT NULL,
    oferta                  VARCHAR2(30),
    grupo_id                INTEGER NOT NULL,
    asignatura_referencia   INTEGER NOT NULL
);

ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_pk PRIMARY KEY ( curso_academico,
                                                          grupo_id,
                                                          asignatura_referencia );

CREATE TABLE matricula (
    curso_academico              INTEGER NOT NULL,
    estado                       VARCHAR2(60) NOT NULL,
    num_archivo                  INTEGER,
    turno_preferente             VARCHAR2(10),
    fecha_de_matricula           DATE NOT NULL,
    nuevo_ingreso                CHAR(1),
    listado_asignaturas          VARCHAR2(30),
    expedientes_num_expediente   INTEGER NOT NULL,
    id                           INTEGER NOT NULL
);

ALTER TABLE matricula ADD CONSTRAINT matricula_pk PRIMARY KEY ( expedientes_num_expediente,
                                                                id );

CREATE TABLE optativas (
    referencia   INTEGER NOT NULL,
    plazas       INTEGER NOT NULL,
    mencion      VARCHAR2(30)
);

ALTER TABLE optativas ADD CONSTRAINT optativas_pk PRIMARY KEY ( referencia );

CREATE TABLE relation_8 (
    encuesta_fecha_de_envío                       DATE NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    encuesta_expedientes_num_expediente           INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_curso_academico         INTEGER NOT NULL,
    grupos_por_asignatura_grupo_id                INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_asignatura_referencia   INTEGER NOT NULL,
    encuesta_id                                   INTEGER
);

ALTER TABLE relation_8
    ADD CONSTRAINT relation_8_pk PRIMARY KEY ( encuesta_fecha_de_envío,
                                               encuesta_expedientes_num_expediente,
                                               grupos_por_asignatura_curso_academico,
                                               grupos_por_asignatura_grupo_id,
                                               grupos_por_asignatura_asignatura_referencia,
                                               encuesta_id );

CREATE TABLE relation_9 (
    centro_id           INTEGER NOT NULL,
    titulación_código   INTEGER NOT NULL
);

ALTER TABLE relation_9 ADD CONSTRAINT relation_9_pk PRIMARY KEY ( centro_id,
                                                                  titulación_código );

CREATE TABLE titulación (
    código     INTEGER NOT NULL,
    nombre     VARCHAR2(50) NOT NULL,
    créditos   INTEGER NOT NULL
);

ALTER TABLE titulación ADD CONSTRAINT titulación_pk PRIMARY KEY ( código );

ALTER TABLE asignatura
    ADD CONSTRAINT asignatura_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_matricula_fk FOREIGN KEY ( matricula_expedientes_num_expediente,
                                                                    matricula_id )
        REFERENCES matricula ( expedientes_num_expediente,
                               id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_optativas_fk FOREIGN KEY ( optativas_referencia )
        REFERENCES optativas ( referencia );

ALTER TABLE clase
    ADD CONSTRAINT clase_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE clase
    ADD CONSTRAINT clase_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE encuesta
    ADD CONSTRAINT encuesta_expedientes_fk FOREIGN KEY ( expedientes_num_expediente )
        REFERENCES expedientes ( num_expediente );

ALTER TABLE expedientes
    ADD CONSTRAINT expedientes_alumno_fk FOREIGN KEY ( alumno_id )
        REFERENCES alumno ( id );

ALTER TABLE expedientes
    ADD CONSTRAINT expedientes_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE matricula
    ADD CONSTRAINT matricula_expedientes_fk FOREIGN KEY ( expedientes_num_expediente )
        REFERENCES expedientes ( num_expediente );

ALTER TABLE optativas
    ADD CONSTRAINT optativas_asignatura_fk FOREIGN KEY ( referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE relation_8
    ADD CONSTRAINT relation_8_encuesta_fk FOREIGN KEY ( encuesta_expedientes_num_expediente,
                                                        encuesta_id,
                                                        encuesta_fecha_de_envío )
        REFERENCES encuesta ( expedientes_num_expediente,
                              id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE relation_8
    ADD CONSTRAINT relation_8_grupos_por_asignatura_fk FOREIGN KEY ( grupos_por_asignatura_curso_academico,
                                                                     grupos_por_asignatura_grupo_id,
                                                                     grupos_por_asignatura_asignatura_referencia )
        REFERENCES grupos_por_asignatura ( curso_academico,
                                           grupo_id,
                                           asignatura_referencia );

ALTER TABLE relation_9
    ADD CONSTRAINT relation_9_centro_fk FOREIGN KEY ( centro_id )
        REFERENCES centro ( id );

ALTER TABLE relation_9
    ADD CONSTRAINT relation_9_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                             0
-- ALTER TABLE                             36
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   8
-- WARNINGS                                 0
