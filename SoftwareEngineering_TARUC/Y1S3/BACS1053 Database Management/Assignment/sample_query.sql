*DBMS Queries*

*Kai Yang*
-- _Query 1 - *Check workload for each doctor*_
SELECT S.staff_id, S.name, S.position, COUNT(W.task_id) AS WorkloadCount 
FROM Staffs S, Workload W 
WHERE S.staff_id = W.staff_id 
AND UPPER(S.position) = 'DOCTOR' 
GROUP BY S.staff_id, S.name, S.position 
ORDER BY WorkloadCount DESC;

-- _Query 2 - *Check number of items left for each item category corresponding to diseases less than 50*_
SELECT D.name, I.name, I.item_id, COUNT(I.quantity) AS ItemCount
FROM Items I, Diseases D
WHERE I.item_id = D.item_id
GROUP BY D.name, I.name, I.item_id
HAVING ItemCount < 50
ORDER BY D.name, ItemCount;

-- _Query 3 - *Check Number of COVID Victims more than average from each hospital where age lesser than 18*_
SELECT S.name, COUNT(V.victim_id) AS NoOfCOVIDVictims 
FROM Victims V, Shelter_allocations SA, Shelters S, Disease_identifications DI, Diseases D 
WHERE V.victim_id = SA.victim_id AND SA.shelter_id = S.shelter_id 
AND D.disease_id = DI.disease_id AND DI.victim_id = V.victim_id AND (SELECT TRUNC((SYSDATE - TO_DATE(V.birth_date, 'DD-MON-YYYY'))/365.25) 
                                                                FROM DUAL) < 18 
AND (SELECT COUNT(victim_id) 
     FROM victims) > (SELECT AVG(VictimsCount) 
                      FROM (SELECT V.victim_id, COUNT(V.victim_id) AS VictimsCount 
                      FROM Victims V, Disease_identifications DI, Diseases D 
                      WHERE V.victim_id = DI.victim_id AND D.disease_id = DI.disease_id 
                      GROUP BY V.victim_id)) 
AND D.name LIKE '%COVID-19%' 
GROUP BY S.name 
ORDER BY NoOfCOVIDVictims DESC;

-- _Query 4 - *Check Number of facemasks received through donations between March to July*_
SELECT I.item_id, I.name, SUM(DI.quantity_donated) AS TotalNumOfDonation 
FROM Donations D, Donation_items DI, Items I 
WHERE D.donation_id = DI.donation_id AND DI.item_id = I.item_id 
AND D.date_donated BETWEEN TO_DATE('01-MAR-2020', 'DD-MON-YYYY') AND TO_DATE('01-JUL-2020', 'DD-MON-YYYY') 
AND UPPER(I.name) LIKE '%FACE MASK%' 
GROUP BY I.item_id, I.name 
ORDER BY TotalNumOfDonation DESC;

-- _Query 5 - *List the number of tasks for each doctors on Labour's Day including their respective hospitals*_
SELECT S.name, D.name AS DoctorName, COUNT(T.task_id) AS NoOfTasks
FROM Shelters S, Staffs D, Tasks T
WHERE S.shelter_id = D.shelter_id AND D.task_id = T.task_id
AND UPPER(D.position) = 'DOCTOR' AND T.date = TO_DATE('01-MAY-2020', 'DD-MON-YYYY')
GROUP BY S.name, D.fname
ORDER BY NoOfTasks DESC;

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