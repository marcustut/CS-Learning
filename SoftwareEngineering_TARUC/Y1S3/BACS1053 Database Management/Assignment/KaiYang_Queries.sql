-- Settings for SQL Plus
SET LINESIZE 120
SET PAGESIZE 50
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY';

-- Setting current time
SET TERMOUT OFF
BREAK ON TODAY
COLUMN TODAY NEW_VALUE _DATE
SELECT TO_CHAR(SYSDATE, 'fmMonth DD, YYYY') TODAY
FROM DUAL;
CLEAR BREAKS
SET TERMOUT ON

-------------------------------------- QUERY 1 -----------------------------------------

-- Taking User Input
PROMPT QUERY 1 - Check workload for staffs according to their position.
PROMPT
PROMPT Available Positions: [Cleaner, Doctor, Warehouse Manager, Specialist, Nurse, IT Support]
PROMPT
ACCEPT v_position CHAR FORMAT A30           PROMPT 'Enter the Staff Position(in lowercase): '

-- Setting the Titles
TTITLE CENTER '========================================================================================================================' SKIP 2 -
CENTER '---------------------------------------' SKIP 1 -
CENTER '--- Disease Management System (DMS) ---' SKIP 1 -
CENTER '---------------------------------------' SKIP 2 -
CENTER '------------------------------------------------------------------------------------------------------------------------' SKIP 1 -
LEFT '--- ' _DATE CENTER 'Check Workload of Staff based on &v_position' RIGHT 'PAGE: ' SQL.PNO ' ---' SKIP 1 -
CENTER '------------------------------------------------------------------------------------------------------------------------' SKIP 2 
BTITLE '' SKIP 1 -
CENTER 'Malaysia Disease Relief and Management Team (MDRMT)' SKIP 2 -
CENTER '========================================================================================================================'

-- Formatting the Result
COLUMN staff_id            FORMAT 9999          HEADING "Staff ID" JUSTIFY CENTER
COLUMN name                FORMAT A25           HEADING "Doctor Name" JUSTIFY CENTER
COLUMN WorkloadCount       FORMAT 99            HEADING "Number of Workload" JUSTIFY CENTER
BREAK ON WorkloadCount

-- Query 1 - Check workload for each position
SELECT COUNT(W.task_id) AS WorkloadCount, S.name, S.staff_id 
FROM Staffs S, Workload W 
WHERE S.staff_id = W.staff_id 
AND LOWER(S.position) = '&v_position'
GROUP BY S.staff_id, S.name, S.position 
ORDER BY WorkloadCount DESC;

CLEAR COLUMNS
TTITLE OFF
BTITLE OFF
