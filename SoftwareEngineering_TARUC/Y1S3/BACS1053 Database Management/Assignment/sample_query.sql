*DBMS Queries*

*Kai Yang*
-- _Query 1 - *Check workload for each doctor*_
SELECT S.staff_id, S.fname || ' ' || S.lname AS Sname, S.position, COUNT(W.workload_id) AS WorkloadCount
FROM Staffs S, Workloads W
WHERE S.staff_id = W.staff_id
AND UPPER(S.position) = 'DOCTOR'
GROUP BY S.staff_id
ORDER BY WorkloadCount;

-- _Query 2 - *Check number of items left for each item category corresponding to diseases less than 50*_
SELECT D.name, I.name, I.item_id, COUNT(I.quantity) AS ItemCount
FROM Items I, Diseases D
WHERE I.item_id = D.item_id
GROUP BY D.name, I.name,
HAVING ItemCount < 50
ORDER BY D.name, ItemCount;

-- _Query 3 - *Check Number of COVID Victims more than average from each states where age lesser than 10*_
SELECT S.state, COUNT(V.victim_id) AS NoOfCOVIDVictims
FROM Victims V, Shelter_allocations S
WHERE (SELECT TRUNC((SYSDATE - birthdate)/365.25) AS Age
       FROM Dual, Victims) < 10
AND (SELECT COUNT(victim_id)
     FROM victims) > (SELECT AVG(VictimsCount)
                      FROM (SELECT victim_id, COUNT(victim_id) AS VictimsCount
                      FROM victims
                      GROUP BY victim_id))
GROUP BY S.state
ORDER BY NoOfCOVIDVictims DESC;

-- _Query 4 - *Check Number of facemasks received through donations between March to July*_
SELECT I.donation_item_id, I.name, SUM(DI.quantity) AS TotalNumOfDonation
FROM Items I, Donation_items DI
WHERE I.donation_item_id = DI.donation_item_id
AND DI.date_received BETWEEN TO_DATE('01-MAC-2020', 'DD-MON-YYYY') AND TO_DATE('01-JUL-2020', 'DD-MON-YYYY') 
AND UPPER(I.name) LIKE '%FACEMASK%';
GROUP BY I.donation_item_id, I.name,
ORDER BY TotalNumOfDonation DESC; 

-- _Query 5 - **_

*Esther Wong*
_Query 1_
_Query 2_
_Query 3_
_Query 4_
_Query 5_

*Alex Ho*
_Query 1_
_Query 2_
_Query 3_
_Query 4_
_Query 5_