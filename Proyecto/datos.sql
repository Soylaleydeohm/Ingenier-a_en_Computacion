#-------------------------------------------------------------------------
# Carga de datos de Prueba
 
INSERT INTO Conductores VALUES (11111111, "Virginia", "Cardoso", "Nicaragua 1234","155111111", 1);
INSERT INTO Conductores VALUES (22222222, "Micaela", "Pintos", "Alem 1220", "155222222", 2);
INSERT INTO Conductores VALUES (33333333, "Gabriel", "Salazar", "Alem 1220", "155333333", 3);
INSERT INTO Conductores VALUES (44444444, "Gandalf", "Cardoso", "Nicaragua 1234","0800", 4);

INSERT INTO Automoviles VALUES("AAA111", "Ford", "Ka", "azul",11111111);
INSERT INTO Automoviles VALUES("BBB222", "Toyota", "Hilux", "Negro",22222222);
INSERT INTO Automoviles VALUES("BBB333", "Toyota", "Hilux", "Blanco",44444444);
INSERT INTO Automoviles VALUES("CCC111", "Audi", "Aicon", "Blanco",44444444);
INSERT INTO Automoviles VALUES("AAA333", "Walk Wagen", "Gol trend", "Gris",33333333);

INSERT INTO Tipos_tarjeta VALUES("Comun", 0.00); 
INSERT INTO Tipos_tarjeta VALUES("Estudiante", 0.20);
INSERT INTO Tipos_tarjeta VALUES("Jubilado", 0.15);

INSERT INTO Tarjetas(saldo, tipo, patente) VALUES(125.00, "Comun", "BBB222"); 
INSERT INTO Tarjetas(saldo, tipo, patente) VALUES(125.00, "Comun", "BBB333");
INSERT INTO Tarjetas(saldo, tipo, patente) VALUES(125.00, "Estudiante", "BBB333");
INSERT INTO Tarjetas(saldo, tipo, patente) VALUES(90.35, "Jubilado", "AAA111"); 
INSERT INTO Tarjetas(saldo, tipo, patente) VALUES(025.10, "Estudiante", "AAA333");

INSERT INTO Inspectores VALUES(111, 11111111, "Virginia", "Cardoso", md5("asd")); #Un inspector que tambien es conductor
INSERT INTO Inspectores VALUES(222, 11111222, "Juan", "Alonso", md5("abc"));
INSERT INTO Inspectores VALUES(333, 11111333, "Maxima", "Salazar", md5("ada"));

INSERT INTO Ubicaciones VALUES("Alem", 1200, 010.00);
INSERT INTO Ubicaciones VALUES("Sarmiento", 0, 040.00);
INSERT INTO Ubicaciones VALUES("Sarmiento", 200, 020.00);
INSERT INTO Ubicaciones VALUES("Chiclana", 300, 030.00);

INSERT INTO Parquimetros VALUES(1,1250, "Alem", 1200);
INSERT INTO Parquimetros VALUES(2,10, "Sarmiento", 0);
INSERT INTO Parquimetros VALUES(3, 70, "Sarmiento", 0);
INSERT INTO Parquimetros VALUES(4,230, "Sarmiento", 200);

INSERT INTO Estacionamientos VALUES(1, 1, "2017-11-11", "11:35:05", "2017-11-11", "13:05:25"); #Estacionamiento cerrado
INSERT INTO Estacionamientos VALUES(2, 4, "2017-11-11", "13:36:09",NULL ,NULL); #Estacionamiento abierto
INSERT INTO Estacionamientos VALUES(3, 3, "2017-11-11", "09:45:00", "2017-11-11", "11:55:32");#Estacionamiento cerrado
INSERT INTO Estacionamientos VALUES(3, 3, "2017-11-11", "13:36:19",NULL ,NULL); #Estacionamiento abierto / volvio al parquimetro
INSERT INTO Estacionamientos(id_tarjeta, id_parq, fecha_ent, hora_ent) VALUES(4, 1, "2017-11-11", "12:55:55"); #Estacionamiento abierto

INSERT INTO Accede VALUES(111, 1, "2017-09-13", "14:45:02");
INSERT INTO Accede VALUES(333, 2, "2017-09-13", "10:10:56");

INSERT INTO Asociado_con VALUES(1111, 111, "Alem", 1200, "Mi", "T");
INSERT INTO Asociado_con VALUES(2222, 333, "Sarmiento", 200 , "Mi", "M");

INSERT INTO Multa(fecha, hora, patente, id_asociado_con) VALUES("2017-09-13", "14:55:02", "AAA111", 1111);
INSERT INTO Multa(fecha, hora, patente, id_asociado_con) VALUES("2017-09-13", "15:00:00", "CCC111", 1111);