-- Settings for SQL Plus
SET linesize 120
SET pagesize 100
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY'; 

-- Formatting the Columns
COLUMN menu_id           FORMAT A5        HEADING "Menu ID"
COLUMN descr             FORMAT A30       HEADING "Description"
COLUMN price             FORMAT $9999.99  HEADING "Price *RM"
COLUMN date_introduced   FORMAT A11       HEADING "Intro Date"

-- Taking User Input
ACCEPT v_minPrice NUMBER FORMAT '9999.99'   PROMPT 'Enter the minimum value of price: '
ACCEPT v_maxPrice NUMBER FORMAT '9999.99'   PROMPT 'Enter the maximum value of price: '

-- Displaying the Query
SELECT menu_id, descr, price, date_introduced
FROM menu
WHERE price BETWEEN &v_minPrice AND &v_maxPrice;

CLEAR COLUMNS