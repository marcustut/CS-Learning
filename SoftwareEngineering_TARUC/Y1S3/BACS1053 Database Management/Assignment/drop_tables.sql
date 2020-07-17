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

-- Startup Screen for Users
cl scr
PROMPT Dropping Tables for Disease Management System (DMS)

-- Turning on the output for printing info from PL/SQL
SET serveroutput ON size 30000

-- Detect if tables already exists
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

    -- Looping through the array
    FOR i in REVERSE 1 .. total LOOP -- Droping tables from the back
        SELECT COUNT(*) INTO nCount FROM user_tables WHERE LOWER(table_name) LIKE (tables(i)); -- Put the count of table into nCount

        IF (nCount > 0) THEN -- If nCount > 0 then table exist
            EXECUTE IMMEDIATE 'DROP TABLE ' || tables(i); -- Drop the table
            DBMS_OUTPUT.PUT_LINE('[SUCCESS] (' || tables(i) || ') is dropped.');
            successCount := successCount + 1;
        END IF;
    END LOOP;

    -- Printing the summary
    DBMS_OUTPUT.PUT_LINE(chr(13));
    DBMS_OUTPUT.PUT_LINE(successCount || '/' || total || ' tables are successfully dropped. (' || round((successCount/total)*100, 2) || '%)');
    DBMS_OUTPUT.NEW_LINE();
    DBMS_OUTPUT.PUT_LINE(chr(13));
    DBMS_OUTPUT.PUT_LINE('Disease Management System (DMS) of Malaysia Disease Relief and Management Team (MDRMT)');
END;
/
