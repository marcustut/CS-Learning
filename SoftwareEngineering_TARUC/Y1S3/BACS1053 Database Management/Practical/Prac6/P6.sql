ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY';
SET LINESIZE 120
SET PAGESIZE 100

COLUMN cust_name FORMAT A15
COLUMN descr FORMAT A25 TRUNCATE
COLUMN order_no HEADING 'Order No'
COLUMN price FORMAT $990.99
COLUMN sub_total FORMAT $9,999.99

TTITLE CENTER 'Customer Analysis for' _DATE -
RIGHT 'Page:' FORMAT 999 SQL.PNO SKIP 2

BREAK ON Cust_No ON Cust_Name ON Order_No SKIP 1 ON order_date
COMPUTE SUM label 'Total:' OF Sub_Total ON Order_No

SELECT C.cust_no, C.cust_name,
       F.order_no, F.order_date,
       M.descr, L.quantity, L.price,
       (L.quantity*L.price) AS Sub_Total
FROM customer C, food_order F, order_list L, menu M
WHERE C.cust_no = F.cust_no AND
      F.order_no = L.order_no AND
      L.menu_id = M.menu_id
ORDER BY 1, 3;

CLEAR COLUMNS
CLEAR BREAKS
CLEAR COMPUTES
TTITLE OFF