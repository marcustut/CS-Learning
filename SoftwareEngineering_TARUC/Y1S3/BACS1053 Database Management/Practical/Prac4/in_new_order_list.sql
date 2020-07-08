-- Settings for SQL Plus
SET linesize 120
SET pagesize 100
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY'; 

-- Formatting the Columns
COLUMN order_no     FORMAT A7       HEADING "Order No"
COLUMN menu_id      FORMAT A5       HEADING "Menu ID"
COLUMN quantity     FORMAT 99  		HEADING "Quantity"
COLUMN price   		FORMAT $9999.99 HEADING "Price (RM)"

/*
SQL> desc order_list
Name                                                              Null?    Type
----------------------------------------------------------------- -------- --------------------------------------------
ORDER_NO                                                          NOT NULL NUMBER(7)
MENU_ID                                                           NOT NULL VARCHAR2(5)
QUANTITY                                                                   NUMBER(2)
PRICE                                                                      NUMBER(6,2)

SQL> select * from menu;
Menu  Description                    Price *RM Intro Date  CAT_I REMARKS
----- ------------------------------ --------- ----------- ----- --------------------------------------------------
M001  Sparkling Lime                     $3.90 01-JAN-2014 DR01  Refreshing soda lime
M091  Cappuccino                         $5.90 01-JAN-2014 DB01  Made with quality Espresso brew
M101  Crab stick and Fish Fingers       $11.95 24-FEB-2015 ST01  Delicious finger food
M111  Coca-cola                          $3.89 07-JUL-2020 DR01  High Sugar Drink
*/

cl scr
PROMPT 'Data entry for ORDER LIST table'
PROMPT
PROMPT

ACCEPT v_order_no    	 char   FORMAT 'A7'         PROMPT 'Enter Order No: '
ACCEPT v_menu_id      	 char   FORMAT 'A5'         PROMPT 'Enter Menu ID: '
ACCEPT v_quantity      	 number FORMAT '99'    		PROMPT 'Enter Quantity: '
ACCEPT v_price 			 number FORMAT '9999.99'    PROMPT 'Enter Price (RM): '

--execute the INSERT statement
INSERT INTO order_list VALUES
('&v_order_no','&v_menu_id',&v_quantity,&v_price);