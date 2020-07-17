-- CREATE
CREATE TABLE Student (
    StudentID       CHAR(10)        NOT NULL,
    StudentName     VARCHAR2(50)    NOT NULL,
    StudentSex      CHAR(1)         NOT NULL,
    StudentDOB      DATE            NOT NULL,
    StudentCGPA     NUMBER(3,2)
);

-- DROP
DROP TABLE Student;

-- ALTER
ALTER TABLE Staff
ADD (Salary NUMBER(7,2));

ALTER TABLE Staff
DROP (Salary);

ALTER TABLE Staff
ADD (Salary NUMBER(7,2) DEFAULT 1000.00);

-- INSERT
INSERT INTO Staff
VALUES (8888, 'Thomas', '08-JAN-99', '01-JAN-75', 1500);

-- UPDATE
UPDATE Staff
SET Staff_Name = 'Thomas San', Salary = Salary * 1.5
WHERE Staff_Name = 'Thomas' AND Salary = 1500;

COMMIT;

-- DELETE
DELETE FROM Order_List;

ROLLBACK;

DELETE FROM Staff
WHERE Staff_ID = 8888;

COMMIT;