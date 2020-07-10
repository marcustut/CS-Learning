--------------------------------------------------------------------------------------
-- Name        : Disease Management System (DMS)
-- Author      : Lee Kai Yang, Esther Wong, Alex Ho
-- Version     : 1.0
-- Last Updated: July-10-2020
-- Description : This database is used as a Disease Management System (DMS) by 
--               Malaysia Disease Relief and Management Team(MDRMT) to coordinate
--               the rescue mission in a more efficient and effective manner.
--------------------------------------------------------------------------------------

-- This SQL Script will create a user

-- Create New User
CREATE USER dms IDENTIFIED BY dms123;

-- Grant Priviledges
GRANT CONNECT, RESOURCE, DBA TO dms;
