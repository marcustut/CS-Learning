-- settings for SQL Plus
SET linesize 120
SET pagesize 100
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY'; 

-- Formatting the Columns
COLUMN menu_id           FORMAT A5        HEADING "Menu ID"
COLUMN descr             FORMAT A30       HEADING "Description"
COLUMN price             FORMAT $9999.99  HEADING "Price *RM"
COLUMN date_introduced   FORMAT A11       HEADING "Intro Date"

/*
 SQL> desc menu;
 Name                                                              Null?    Type
 ----------------------------------------------------------------- -------- ------------
 MENU_ID                                                           NOT NULL VARCHAR2(5)
 DESCR                                                             NOT NULL VARCHAR2(30)
 PRICE                                                                      NUMBER(6,2)
 DATE_INTRODUCED                                                            DATE
 CAT_ID                                                                     VARCHAR2(5)
 REMARKS                                                                    VARCHAR2(50)

SQL> select * from category;

CAT_I DESCRIPTION                     MIN_PRICE  MAX_PRICE
----- ------------------------------ ---------- ----------
DR01  Carbonated drinks                       1         10
DB01  Beverages                               3         15
ST01  Starters                              4.5         25
*/

cl scr
PROMPT 'Data entry for MENU table'
PROMPT
PROMPT

ACCEPT v_menu_id    	 char   FORMAT 'A5'          PROMPT 'Enter Menu ID: '
ACCEPT v_descr      	 char   FORMAT 'A30'         PROMPT 'Enter Menu Description: '
ACCEPT v_price      	 number FORMAT '9999.99'     PROMPT 'Enter Price(RM): '
ACCEPT v_date_introduced char   FORMAT 'A11'         PROMPT 'Enter Date Introduced(dd-mon-yyyy): '
ACCEPT v_cat_id 		 char   FORMAT 'A5'          PROMPT 'Enter Category ID: '
ACCEPT v_remarks         char   FORMAT 'A50'         PROMPT 'Enter Remarks: '

--execute the INSERT statement
INSERT INTO menu VALUES
('&v_menu_id','&v_descr',&v_price,'&v_date_introduced','&v_cat_id','&v_remarks');