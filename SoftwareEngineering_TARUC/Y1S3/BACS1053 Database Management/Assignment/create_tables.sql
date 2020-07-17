--------------------------------------------------------------------------------------
-- Name        : Disease Management System (DMS)
-- Author      : Lee Kai Yang, Esther Wong, Alex Ho
-- Version     : 1.0
-- Last Updated: July-10-2020
-- Description : This database is used as a Disease Management System (DMS) by 
--               Malaysia Disease Relief and Management Team(MDRMT) to coordinate
--               the rescue mission in a more efficient and effective manner.
--------------------------------------------------------------------------------------

-- No. Tables  : 12
-- 1. states
-- 2. federal_states
-- 3. locations
-- 4. diseases
-- 5. medical_supply
-- 6. exams
-- 7. shelters
-- 8. staffs
-- 9. victims
-- 10. donors
-- 11. donations
-- 12. contacts

-- Settings for Oracle SQL
SET linesize 120
SET pagesize 100
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY'

-- Startup Screen for Users
cl scr
PROMPT Creating Tables for Disease Management System (DMS)

-- Turning on the output for printing info from PL/SQL
SET serveroutput ON size 30000

-- TODO: DROP TABLES FIRST

---------------
-- 1. states --
---------------
CREATE TABLE states (
    state_id        CHAR(2),
    name            VARCHAR(50) NOT NULL UNIQUE,
PRIMARY KEY(state_id),
CONSTRAINT chk_state_id CHECK (UPPER(state_id) in ('JR', 'KD', 'KT', 'MK', 'NS', 'PH', 'PG', 'PK', 'PS', 'SB', 'SR', 'SG', 'TG', 'WP'))
);
--------------------------------------------------------------------------------------------------

-----------------------
-- 2. federal_states --
-----------------------
CREATE TABLE federal_states (
    federal_id      CHAR(2),
    name            VARCHAR(50) NOT NULL UNIQUE,
    state_id        CHAR(2),
PRIMARY KEY(federal_id),
CONSTRAINT chk_federal_states_states
            FOREIGN KEY (state_id)
            REFERENCES states(state_id),
CONSTRAINT chk_federal_id CHECK (UPPER(federal_id) in ('KL', 'LB', 'PJ'))
);
--------------------------------------------------------------------------------------------------

------------------
-- 3. locations --
------------------
CREATE TABLE locations (
    location_id     NUMBER,
    address         VARCHAR(255) NOT NULL,
    postal_code     VARCHAR(20),
    city            VARCHAR(50),
    state_id        CHAR(2), -- Foreign Key
PRIMARY KEY(location_id),
CONSTRAINT fk_locations_states
           FOREIGN KEY(state_id)
           REFERENCES states(state_id)
);

-- Following code is to auto-increment location_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE location_id_seq START WITH 3001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER location_id_bir
BEFORE INSERT ON locations
FOR EACH ROW

BEGIN
    SELECT  location_id_seq.NEXTVAL
    INTO    :new.location_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

-----------------
-- 4. diseases --
-----------------
CREATE TABLE diseases (
   	disease_id      NUMBER,
   	name            VARCHAR(100)     NOT NULL UNIQUE,
   	description     VARCHAR(255),
   	cure_existed    CHAR(1)         NOT NULL,
   	date_discovered DATE            DEFAULT SYSDATE NOT NULL, -- Default to current date if not specified
PRIMARY KEY(disease_id),
CONSTRAINT chk_cure_existed CHECK (UPPER(cure_existed) in ('Y', 'N'))
);

-- Following code is to auto-increment disease_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE disease_id_seq START WITH 4001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER disease_id_bir
BEFORE INSERT ON diseases
FOR EACH ROW

BEGIN
    SELECT  disease_id_seq.NEXTVAL
    INTO    :new.disease_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

-----------------------
-- 5. medical_supply --
-----------------------
CREATE TABLE medical_supply (
   	medical_supply_id       NUMBER          NOT NULL    ,
   	name                    VARCHAR(100)     NOT NULL,
    quantity                NUMBER(5)       NOT NULL,
   	description             VARCHAR(255),
    disease_id              NUMBER, -- Foreign Key
PRIMARY KEY(medical_supply_id),
CONSTRAINT fk_medical_supply_diseases
           FOREIGN KEY (disease_id)
           REFERENCES diseases(disease_id) 
);

-- Following code is to auto-increment medical_supply_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE medical_supply_id_seq START WITH 5001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER medical_supply_id_bir
BEFORE INSERT ON medical_supply
FOR EACH ROW

BEGIN
    SELECT  medical_supply_id_seq.NEXTVAL
    INTO    :new.medical_supply_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

--------------
-- 6. exams --
--------------
CREATE TABLE exams (
    exam_id             NUMBER   NOT NULL,
    name                VARCHAR(50) NOT NULL,
    date_of_exam        DATE,
    min_kpi             NUMBER(3, 2),
PRIMARY KEY(exam_id)
);

-- Following code is to auto-increment exam_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE exam_id_seq START WITH 6001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER exam_id_bir
BEFORE INSERT ON exams
FOR EACH ROW

BEGIN
    SELECT  exam_id_seq.NEXTVAL
    INTO    :new.exam_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------


-----------------
-- 7. shelters --
-----------------
CREATE TABLE shelters (
   shelter_id       NUMBER,
   name	            VARCHAR(50) NOT NULL,
   type             VARCHAR(20) NOT NULL,
   date_established DATE,
   location_id      NUMBER NOT NULL, -- Foreign Key
PRIMARY KEY(shelter_id),
FOREIGN KEY(location_id) REFERENCES locations(location_id),
CONSTRAINT chk_shelter_type CHECK (UPPER(type) in ('HOSPITAL', 'CLINIC'))
);

-- Following code is to auto-increment shelter_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE shelter_id_seq START WITH 7001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER shelter_id_bir
BEFORE INSERT ON shelters
FOR EACH ROW

BEGIN
    SELECT  shelter_id_seq.NEXTVAL
    INTO    :new.shelter_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

---------------
-- 8. staffs --
---------------
CREATE TABLE staffs (
   staff_id         NUMBER,
   name             VARCHAR(50) NOT NULL,
   position         VARCHAR(30) NOT NULL,
   kpi              NUMBER(3, 2) DEFAULT 2.00 NOT NULL, -- eg: 3.78
   shelter_id       NUMBER, -- Foreign Key
   exam_id          NUMBER, -- Foreign Key
PRIMARY KEY(staff_id),
CONSTRAINT fk_staffs_shelters FOREIGN KEY(shelter_id) REFERENCES shelters(shelter_id),
CONSTRAINT fk_staffs_exams FOREIGN KEY(exam_id) REFERENCES exams(exam_id)
);

-- Following code is to auto-increment staff_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE staff_id_seq START WITH 8001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER staff_id_bir
BEFORE INSERT ON staffs
FOR EACH ROW

BEGIN
    SELECT  staff_id_seq.NEXTVAL
    INTO    :new.staff_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

----------------
-- 9. victims --
----------------
CREATE TABLE victims (
    victim_id        NUMBER,
    name             VARCHAR(50)    NOT NULL,
    date_admitted    DATE           DEFAULT SYSDATE NOT NULL, -- Default to current date if not specified
    weight           NUMBER(5, 2),
    height           NUMBER(5, 2),
    disease_id       NUMBER, -- Foreign Key
    staff_id         NUMBER, -- Foreign Key
    shelter_id       NUMBER, -- Foreign Key
PRIMARY KEY(victim_id),
CONSTRAINT fk_victims_diseases
           FOREIGN KEY(disease_id)
           REFERENCES diseases(disease_id),
CONSTRAINT fk_victims_staffs
           FOREIGN KEY(staff_id)
           REFERENCES staffs(staff_id),
CONSTRAINT fk_victims_shelters
           FOREIGN KEY(shelter_id)
           REFERENCES shelters(shelter_id)
);

-- Following code is to auto-increment victim_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE victim_id_seq START WITH 9001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER victim_id_bir
BEFORE INSERT ON victims
FOR EACH ROW

BEGIN
    SELECT  victim_id_seq.NEXTVAL
    INTO    :new.victim_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

----------------
-- 10. donors --
----------------
CREATE TABLE donors (
    donor_id        NUMBER,
    name            VARCHAR(50) NOT NULL,
PRIMARY KEY(donor_id)
);

-- Following code is to auto-increment donor_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE donor_id_seq START WITH 10001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER donor_id_bir
BEFORE INSERT ON donors
FOR EACH ROW

BEGIN
    SELECT  donor_id_seq.NEXTVAL
    INTO    :new.donor_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

-------------------
-- 11. donations --
-------------------
CREATE TABLE donations (
    donation_id     NUMBER,
    type            VARCHAR(20) NOT NULL,
    amount          NUMBER(12, 2),
    description     VARCHAR(255),
    donor_id        NUMBER,
PRIMARY KEY(donation_id),
CONSTRAINT fk_donations_donors
            FOREIGN KEY(donor_id)
            REFERENCES donors(donor_id)
            ON DELETE CASCADE,
CONSTRAINT chk_donation_type CHECK (UPPER(type) in ('MONEY', 'MEDICAL_SUPPLIES'))
);

-- Following code is to auto-increment donation_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE donation_id_seq START WITH 11001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER donation_id_bir
BEFORE INSERT ON donations
FOR EACH ROW

BEGIN
    SELECT  donation_id_seq.NEXTVAL
    INTO    :new.donation_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

------------------
-- 12. contacts --
------------------
CREATE TABLE contacts (
   contact_id       NUMBER,
   first_name       VARCHAR(255)    NOT NULL,
   last_name        VARCHAR(255)    NOT NULL,
   age              NUMBER(3)       NOT NULL,
   gender           CHAR(1)         NOT NULL,
   race             VARCHAR(12)     NOT NULL,
   ic_num           NUMBER(12)      NOT NULL UNIQUE, -- IC Number must be specified and cannot be duplicated
   birth_date       DATE            NOT NULL,
   phone_num        NUMBER(15)      NOT NULL UNIQUE,
   email            VARCHAR(50),
   address          VARCHAR(255),
   victim_id        NUMBER, -- Foreign Key
   staff_id         NUMBER, -- Foreign Key
   donor_id         NUMBER, -- Foreign Key
PRIMARY KEY(contact_id),
CONSTRAINT fk_contacts_victims
           FOREIGN KEY (victim_id)
           REFERENCES victims(victim_id)
           ON DELETE CASCADE, -- this constraint means that if the victim is deleted from victims table, then its contact will also be deleted.
CONSTRAINT fk_contacts_staff
           FOREIGN KEY (staff_id)
           REFERENCES staffs(staff_id)
           ON DELETE CASCADE, -- this constraint means that if the staff is deleted from staffs table, then its contact will also be deleted.
CONSTRAINT fk_contacts_donor
           FOREIGN KEY (donor_id)
           REFERENCES donors(donor_id)
           ON DELETE CASCADE, -- this constraint means that if the donor is deleted from donors table, then its contact will also be deleted.
CONSTRAINT chk_gender CHECK (UPPER(gender) in ('M', 'F')),
CONSTRAINT chk_race CHECK (UPPER(race) in ('CHINESE', 'MALAY', 'INDIAN', 'IBAN', 'KADAZANDUSUN', 'OTHERS')),
CONSTRAINT chk_email CHECK (REGEXP_LIKE(email,'^[a-zA-Z]\w+@(\S+)$'))
);

-- Following code is to auto-increment contact_id

-- This sequence is to auto increment the id.
CREATE SEQUENCE contact_id_seq START WITH 12001;

-- Below code is to trigger sequence to increment by 1 when CREATE or REPLACE is detected.
CREATE OR REPLACE TRIGGER contact_id_bir
BEFORE INSERT ON contacts
FOR EACH ROW

BEGIN
    SELECT  contact_id_seq.NEXTVAL
    INTO    :new.contact_id
    FROM    dual;
END;
/
--------------------------------------------------------------------------------------------------

-----------------
-- Table Check --
-----------------
DECLARE
    type tablesarray IS VARRAY(12) OF VARCHAR(20);
    tables tablesarray;
    total integer;
    nCount integer;
    successCount integer;
BEGIN
    -- Assigning tables names to the array
    tables := tablesarray('states', 'federal_states', 'locations', 'diseases', 'medical_supply', 'exams', 'shelters', 'staffs', 'victims', 'donors', 'donations', 'contacts');
    total := tables.count;
    successCount := 0;

    -- Enabling DBMS_OUTPUT package
    DBMS_OUTPUT.ENABLE;

    -- Printing info screen
    DBMS_OUTPUT.PUT_LINE('Disease Management System (DMS) of Malaysia Disease Relief and Management Team (MDRMT)');
    DBMS_OUTPUT.NEW_LINE();
    DBMS_OUTPUT.PUT_LINE(chr(13));
    DBMS_OUTPUT.PUT_LINE('Total of ' || total || ' tables.');
    DBMS_OUTPUT.NEW_LINE();
    DBMS_OUTPUT.PUT_LINE(chr(13));

    -- Looping through the array
    FOR i in 1 .. total LOOP
        SELECT COUNT(*) INTO nCount FROM user_tables WHERE LOWER(table_name) LIKE (tables(i)); -- Put the count of table into nCount

        IF (nCount <= 0) THEN -- If nCount <= 0 then table doesn't exist
            DBMS_OUTPUT.PUT_LINE('[FAILED] (' || tables(i) || ') is not created.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('[SUCCESS] (' || tables(i) || ') is created.');
            successCount := successCount + 1;
        END IF;
    END LOOP;

    -- Printing the summary
    DBMS_OUTPUT.PUT_LINE(chr(13));
    DBMS_OUTPUT.PUT_LINE(successCount || '/' || total || ' tables are successfully created. (' || round((successCount/total)*100, 2) || '%)');
END;
/
