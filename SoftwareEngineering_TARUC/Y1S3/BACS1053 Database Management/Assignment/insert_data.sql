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
-- ALTER TABLE dms.locations DISABLE CONSTRAINT fk_locations_states;

-- Federal States
INSERT INTO dms.federal_states (federal_id, name) VALUES ('KL','Kuala Lumpur');
INSERT INTO dms.federal_states (federal_id, name) VALUES ('LB','Labuan');
INSERT INTO dms.federal_states (federal_id, name) VALUES ('PJ','Putrajaya');

-- States
INSERT INTO dms.states (state_id, name) VALUES ('JR','Johor');
INSERT INTO dms.states (state_id, name) VALUES ('KD','Kedah');
INSERT INTO dms.states (state_id, name) VALUES ('KT','Kelantan');
INSERT INTO dms.states (state_id, name) VALUES ('MK','Melaka');
INSERT INTO dms.states (state_id, name) VALUES ('NS','Negeri Sembilan');
INSERT INTO dms.states (state_id, name) VALUES ('PH','Pahang');
INSERT INTO dms.states (state_id, name) VALUES ('PG','Penang');
INSERT INTO dms.states (state_id, name) VALUES ('PK','Perak');
INSERT INTO dms.states (state_id, name) VALUES ('PS','Perlis');
INSERT INTO dms.states (state_id, name) VALUES ('SB','Sabah');
INSERT INTO dms.states (state_id, name) VALUES ('SR','Sarawak');
INSERT INTO dms.states (state_id, name) VALUES ('SG','Selangor');
INSERT INTO dms.states (state_id, name) VALUES ('TG','Terengganu');
INSERT INTO dms.states (state_id, name) VALUES ('WP','Wilayah Persekutuan');

-- Locations
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('Bukit Pandan 2', '55300', 'Cheras', 'WP');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('0900 Mandrake Pass', '821 80', 'Bollnäs', 'SR');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('978 Namekagon Road', '3120', 'Tuka', 'PG');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('91 Dovetail Terrace', null, 'Dongxiang', 'WP');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('39971 7th Lane', '98880', 'La Foa', 'PK');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('0 Hintze Drive', '15900-000', 'Taquaritinga', 'SR');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('186 Katie Way', null, 'Pop', 'NS');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('3 Gateway Court', null, 'Cikaras', 'PK');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('21100 Homewood Avenue', '413750', 'Perelyub', 'SB');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('5 Anderson Way', '4815', 'Devin', 'TG');
INSERT INTO dms.locations (address, postal_code, city, state_id) VALUES ('9 Namekagon Drive', null, 'Huaxijie', 'SR');

-- Diseases
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Coronavirus', 'This is a deadly virus', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('dimethicone, octinoxate, oxybenzone', 'Destruction of C-thor Jt, Perc Endo Approach', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('California Live Oak', 'Destruction of Right Thumb Phalanx, Open Approach', 'Y');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Alprazolam', 'Dilation of Mid Esophag with Intralum Dev, Perc Approach', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Acetaminophen', 'Reposition Uvula, External Approach', 'Y');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Sumatriptan Succinate', 'Replacement of L Sphenoid Bone with Autol Sub, Perc Approach', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Levofloxacin', 'Reposition Sacrococcygeal Joint with Int Fix, Open Approach', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Benzalkonium Chloride', 'Replace of L Knee Jt, Tibial with Nonaut Sub, Open Approach', 'Y');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Oxygen-Helium Mixture', 'Removal of Autol Sub from R Wrist Jt, Open Approach', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Lorazepam', 'Supplement Right Humeral Head with Nonaut Sub, Open Approach', 'N');
INSERT INTO dms.diseases (name, description, cure_existed) VALUES ('Rhus toxicodendron', 'Supplement Cul-de-sac with Synthetic Substitute, Via Opening', 'N');

-- Medical Supply
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('Ibuprofen', 88, 'Division of Left Lower Arm Skin, External Approach', 4002);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('Quinidine Sulfate', 183, 'Dilate Gastric Art, Bifurc, w 4+ Intralum Dev, Perc', 4006);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('Triclosan', 895, 'Extirpation of Matter from Left Ureter, Open Approach', 4005);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('PANTOPRAZOLE SODIUM', 59, 'Drainage of Right Thorax Tendon, Open Approach', 4008);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('Warfarin Sodium', 498, 'Introduction of Oth Diagn Subst into Lymph, Perc Approach', 4009);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('3-PHYTASE B (ASPERGILLUS NIGER)', 866, 'Bypass Cecum to Sigmoid Colon with Synth Sub, Endo', 4001);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('ASPIRIN', 90, 'Hyperthermia of Spleen', 4005);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('Benzoyl Peroxide', 275, 'Destruction of R Metatarsotars Jt, Perc Endo Approach', 4003);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('ZINC OXIDE', 633, 'Insertion of Monitoring Electrode into POC, Via Opening', 4004);
INSERT INTO dms.medical_supply (name, quantity, description, disease_id) VALUES ('Naproxen Sodium', 566, 'Destruction of Left Ulnar Artery, Perc Endo Approach', 4005);