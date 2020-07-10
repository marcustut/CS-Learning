--------------------------------------------------------------------------------------
-- Name        : Disease Management System (DMS)
-- Author      : Lee Kai Yang, Esther Wong, Alex Ho
-- Version     : 1.0
-- Last Updated: July-10-2020
-- Description : This database is used as a Disease Management System (DMS) by 
--               Malaysia Disease Relief and Management Team(MDRMT) to coordinate
--               the rescue mission in a more efficient and effective manner.
--------------------------------------------------------------------------------------

-- This SQL Script will insert data into the tables created.
-- make sure you ran create_tables.sql before this.

-- Disable FK Constraints
ALTER TABLE dms.locations DISABLE CONSTRAINT fk_locations_states;

-- Locations
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('Bukit Pandan 2', '55300', 'Cheras', 'KD');

-- Diseases
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Coronavirus', 'This is a deadly virus', 'N');