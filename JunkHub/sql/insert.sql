INSERT INTO PROFILES(USERNAME, PASSWORD, NICKNAME, FIRSTNAME, LASTNAME, EMAIL, ADDRESS, DOB, CREDIT, STATUS, ADMIN) VALUES ('admin','password', 'admin', 'bruce', 'wayne', 'admin@mail.com', 'sydney', '1989-09-21', 12345678, 1, 1);
INSERT INTO PROFILES(USERNAME, PASSWORD, NICKNAME, FIRSTNAME, LASTNAME, EMAIL, ADDRESS, DOB, CREDIT, STATUS, ADMIN) VALUES ('stephen','password', 'steve', 'stephen', 'pham', 'stephen@gmail.com', 'sydney', '1988-05-28', 12345678, 1, 0);
INSERT INTO PROFILES(USERNAME, PASSWORD, NICKNAME, FIRSTNAME, LASTNAME, EMAIL, ADDRESS, DOB, CREDIT, STATUS, ADMIN) VALUES ('andrew','password', 'andy', 'andrew', 'pham', 'andrew@gmail.com', 'sydney', '1989-09-21', 12345678, 1, 0);

INSERT INTO ITEMS(TITLE, CATEGORY, PICTURE, DESCRIPTION, POSTAGE, RESERVE, START, INC, STARTTIME, PERIOD, OWNER, STATUS) VALUES ('ps3', 'games', '', 'stolen goods', 'auspost', 100.00, 20.00, 10.00, '2013-10-15 14:03:20', 50, 'stephen', 1);
INSERT INTO ITEMS(TITLE, CATEGORY, PICTURE, DESCRIPTION, POSTAGE, RESERVE, START, INC, OWNER, STATUS) VALUES ('xbox', 'games', '', 'used','auspost', 100.00, 20.00, 10.00, 'andrew', 0);

UPDATE ITEMS SET STATUS = 1 WHERE ID = 2;
UPDATE ITEMS SET BID=50, BIDDER='andrew' WHERE ID=1;