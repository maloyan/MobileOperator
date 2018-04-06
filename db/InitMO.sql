INSERT INTO Tariff VALUES (1, 'Base', 5, NULL, 3, 2, NULL, 1);
INSERT INTO Tariff VALUES (2, 'Unlim', NULL, 15, NULL, NULL, 10, 1);

INSERT INTO Customer VALUES (1, 'James' , 'Carter',     NULL, 'JC@mail.com'    , '110 W. Liberty St.', 'personal'  , '6085551001');
INSERT INTO Customer VALUES (2, 'Helen' , 'Leary' ,     NULL, 'HL@mail.com'    , '638 Cardinal Ave.' , 'personal'  , '6085551002');
INSERT INTO Customer VALUES (3, 'Rafael', 'Ortega',     NULL, 'RO@mail.com'    , '2387 S. Fair Way'  , 'personal'  , '6085551003');
INSERT INTO Customer VALUES (4, 'Mark', 'Hurd', 'Oracle', 'Oracle@mail.com', '1450 Oak Blvd.'    , 'commercial', '6085551004');

INSERT INTO Services VALUES (1, 'call', NULL);
INSERT INTO Services VALUES (2, 'sms', NULL);
INSERT INTO Services VALUES (3, 'internet', NULL);
INSERT INTO Services VALUES (4, 'topup balance', NULL);

INSERT INTO Contract VALUES (1, 1, 1, '88005553535', 100, '2017-09-07');
INSERT INTO Contract VALUES (2, 2, 1, '88005553536', 100, '2017-04-17');
INSERT INTO Contract VALUES (3, 3, 2, '88005553537', 100, '2017-09-04');
INSERT INTO Contract VALUES (4, 4, 2, '88005553538', 100, '2017-06-08');

INSERT INTO Event VALUES (1, 4, 1, '2017-09-07', NULL, 100)
