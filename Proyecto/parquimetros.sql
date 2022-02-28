#Archivo batch (parquimetros.sql) para la creación de la 
#Base de datos del práctico de SQL

#Lo que esta después del "#" es un comentario

# Creo de la Base de Datos
CREATE DATABASE parquimetros;

# selecciono la base de datos sobre la cual voy a hacer modificaciones
USE parquimetros;

#-------------------------------------------------------------------------
# Creación Tablas para las entidades

CREATE TABLE Conductores (
	 dni INT UNSIGNED NOT NULL, 
	 nombre VARCHAR(45) NOT NULL, 
	 apellido VARCHAR(45) NOT NULL,
	 direccion VARCHAR(45) NOT NULL,
	 telefono VARCHAR(45),
	 registro INT UNSIGNED NOT NULL,
	 
	 CONSTRAINT pk_conductores 
	 PRIMARY KEY (dni),
	 
	 KEY (registro)
) ENGINE=InnoDB;

CREATE TABLE Automoviles (
	 patente CHAR(6) NOT NULL, 
	 marca VARCHAR(45) NOT NULL, 
	 modelo VARCHAR(45) NOT NULL,
	 color VARCHAR(45) NOT NULL,
	 dni INT UNSIGNED NOT NULL,
	 
	 CONSTRAINT pk_automoviles 
	 PRIMARY KEY (patente),
	 
	 CONSTRAINT FK_automoviles_conductores
	 FOREIGN KEY (dni) REFERENCES Conductores (dni) 
	   ON DELETE RESTRICT ON UPDATE CASCADE
 
 ) ENGINE=InnoDB;
 
CREATE TABLE Tipos_tarjeta (
	 tipo VARCHAR(45) NOT NULL, 
	 descuento DECIMAL(3,2) UNSIGNED NOT NULL,
	 
	 CONSTRAINT pk_tipos_tarjeta 
	 PRIMARY KEY (tipo)
 
 ) ENGINE=InnoDB;
 
 CREATE TABLE Tarjetas (
	 id_tarjeta INT UNSIGNED NOT NULL AUTO_INCREMENT,
	 saldo DECIMAL(5,2) NOT NULL,
	 tipo VARCHAR(45) NOT NULL,
	 patente CHAR(6) NOT NULL,
	 
	 CONSTRAINT pk_tarjeta 
	 PRIMARY KEY (id_tarjeta),
	 
	 CONSTRAINT FK_tarjeta_tipo_tarjeta
	 FOREIGN KEY (tipo) REFERENCES Tipos_tarjeta (tipo) 
	   ON DELETE RESTRICT ON UPDATE CASCADE,
	   
	   CONSTRAINT FK_tarjeta_automovil
	 FOREIGN KEY (patente) REFERENCES Automoviles (patente) 
	   ON DELETE RESTRICT ON UPDATE CASCADE
 
 ) ENGINE=InnoDB;
 
  CREATE TABLE Inspectores (
	 legajo INT UNSIGNED NOT NULL,
	 dni INT UNSIGNED NOT NULL,
	 nombre VARCHAR(45) NOT NULL, 
	 apellido VARCHAR(45) NOT NULL,
	 password CHAR(32) NOT NULL,
	 
	 CONSTRAINT pk_inspectores
	 PRIMARY KEY (legajo),
	  
	  KEY (dni)
 ) ENGINE=InnoDB;
 
   CREATE TABLE Ubicaciones (
	 calle VARCHAR(45) NOT NULL, 
	 altura INT UNSIGNED NOT NULL,
	 tarifa DECIMAL(5,2) UNSIGNED NOT NULL, 
	 
	 CONSTRAINT pk_ubicaciones
	 PRIMARY KEY (calle, altura)
	 
 ) ENGINE=InnoDB;
 
    CREATE TABLE Parquimetros (
	 id_parq INT UNSIGNED NOT NULL,
	 numero INT UNSIGNED NOT NULL,
	 calle VARCHAR(45) NOT NULL, 
	 altura INT UNSIGNED NOT NULL,
	 
	 CONSTRAINT pk_parquimetros
	 PRIMARY KEY (id_parq),
	 
	 	 CONSTRAINT FK_parquimetro_ubicacion
	 FOREIGN KEY (calle,altura) REFERENCES Ubicaciones (calle,altura) 
	   ON DELETE RESTRICT ON UPDATE CASCADE

 ) ENGINE=InnoDB;
 
 #-------------------------------------------------------------------------
# Creación Tablas para las relaciones

 
     CREATE TABLE Estacionamientos (
	 id_tarjeta INT UNSIGNED NOT NULL,
	 id_parq INT UNSIGNED NOT NULL,
	 fecha_ent DATE NOT NULL,
	 hora_ent TIME NOT NULL,
	 fecha_sal DATE,
	 hora_sal TIME,
	 
	 CONSTRAINT pk_estacionamientos
	 PRIMARY KEY (id_parq,fecha_ent,hora_ent),
	 
	 	 CONSTRAINT FK_estacionamiento_tarjetas
	 FOREIGN KEY (id_tarjeta) REFERENCES Tarjetas (id_tarjeta) 
	   ON DELETE RESTRICT ON UPDATE CASCADE,
	   
	   CONSTRAINT FK_estacionamiento_parquimetro
	 FOREIGN KEY (id_parq) REFERENCES Parquimetros (id_parq) 
	   ON DELETE RESTRICT ON UPDATE CASCADE
	   	 
 ) ENGINE=InnoDB;
 
      CREATE TABLE Accede (
	 legajo INT UNSIGNED NOT NULL,
	 id_parq INT UNSIGNED NOT NULL,
	 fecha DATE NOT NULL,
	 hora TIME NOT NULL,
	 
		CONSTRAINT pk_accede
	 PRIMARY KEY (id_parq,fecha,hora),
	 
		CONSTRAINT FK_accede_parquimetro
	 FOREIGN KEY (id_parq) REFERENCES Parquimetros (id_parq) 
	   ON DELETE RESTRICT ON UPDATE CASCADE,
	 
	 	 CONSTRAINT FK_accede_inspectores
	 FOREIGN KEY (legajo) REFERENCES Inspectores (legajo) 
	   ON DELETE RESTRICT ON UPDATE CASCADE
	      	 
 ) ENGINE=InnoDB;
 
       CREATE TABLE Asociado_con (
	     id_asociado_con INT UNSIGNED NOT NULL AUTO_INCREMENT,
		 legajo INT UNSIGNED NOT NULL,
		 calle VARCHAR(45) NOT NULL, 
		 altura INT UNSIGNED NOT NULL,
		 dia CHAR(2) NOT NULL,
		 turno CHAR(1) NOT NULL,
	 
		CONSTRAINT pk_asociado
	 PRIMARY KEY (id_asociado_con),
	 
		CONSTRAINT FK_asociado_inspectores
	 FOREIGN KEY (legajo) REFERENCES Inspectores (legajo) 
	   ON DELETE RESTRICT ON UPDATE CASCADE,
		   
	 CONSTRAINT FK_asociado_ubicacion
		 FOREIGN KEY (calle,altura) REFERENCES Ubicaciones (calle,altura) 
		   ON DELETE RESTRICT ON UPDATE CASCADE
	      	 
 ) ENGINE=InnoDB;
 
        CREATE TABLE Multa (
	     numero INT UNSIGNED NOT NULL AUTO_INCREMENT,
		 fecha DATE NOT NULL,
		 hora TIME NOT NULL,
		 patente CHAR(6) NOT NULL, 
		 id_asociado_con INT UNSIGNED NOT NULL,
	 
		CONSTRAINT pk_multa
		PRIMARY KEY (numero),
	 
		CONSTRAINT FK_multa_automovil
	 FOREIGN KEY (patente) REFERENCES Automoviles (patente) 
	   ON DELETE RESTRICT ON UPDATE CASCADE,
	   
	   	 CONSTRAINT FK_multa_asociado
	 FOREIGN KEY (id_asociado_con) REFERENCES Asociado_con (id_asociado_con) 
	   ON DELETE RESTRICT ON UPDATE CASCADE
	      	 
 ) ENGINE=InnoDB;
 
         CREATE TABLE ventas (
	     id_tarjeta INT UNSIGNED NOT NULL,
         tipo_tarjeta VARCHAR(45) NOT NULL, 
		 saldo DECIMAL(5,2) NOT NULL,
		 fecha DATE NOT NULL,
		 hora TIME NOT NULL,
	 
		 CONSTRAINT pk_tarjeta 
		 PRIMARY KEY (id_tarjeta),
		 
		 CONSTRAINT FK_tipo_tarjeta
		 FOREIGN KEY (tipo_tarjeta) REFERENCES Tipos_tarjeta (tipo) 
		   ON DELETE RESTRICT ON UPDATE CASCADE,
           
		CONSTRAINT FK_id_tarjeta
		 FOREIGN KEY (id_tarjeta) REFERENCES Tarjetas (id_tarjeta) 
		   ON DELETE RESTRICT ON UPDATE CASCADE
	      	 
 ) ENGINE=InnoDB;
 
#-------------------------------------------------------------------------
# Creación de vistas 
# estacionados = Datos de todos los autos que están "estacionados"

   CREATE VIEW estacionados AS 
   SELECT patente, calle, altura
   FROM  (Tarjetas NATURAL JOIN Estacionamientos) NATURAL JOIN Parquimetros
   WHERE fecha_sal IS NULL AND hora_sal IS NULL;
 
 #-------------------------------------------------------------------------
# Creación de usuarios y otorgamiento de privilegios

# Usuario admin
	CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
    GRANT ALL PRIVILEGES ON parquimetros.* TO 'admin'@'localhost' WITH GRANT OPTION;
# El usuario 'admin' tiene acceso total a todas las tablas de 
# la B.D. parquimetros, puede conectarse solo desde la computadora 
# donde se encuentra el servidor de MySQL (localhost), el password de su 
# cuenta es 'admin' y puede otorgar privilegios. 

# Usuario venta
    CREATE USER 'venta'@'%' IDENTIFIED BY 'venta'; 
    GRANT SELECT ON parquimetros.Automoviles TO 'venta'@'%';
    GRANT SELECT ON parquimetros.Tipos_tarjeta TO 'venta'@'%';
    GRANT SELECT ON parquimetros.Tarjetas TO 'venta'@'%';
   	GRANT INSERT ON parquimetros.Tarjetas TO 'venta'@'%';
   	GRANT UPDATE ON parquimetros.Tarjetas TO 'venta'@'%';
# el usuario 'venta' solo puede acceder a la tabla (tarjetas)
# con permiso para agregar filas.

# Usuario inspector
	CREATE USER 'inspector'@'%' IDENTIFIED BY 'inspector';	
   	GRANT SELECT ON parquimetros.Inspectores TO 'inspector'@'%';
   	GRANT SELECT ON parquimetros.estacionados TO 'inspector'@'%';
   	GRANT SELECT ON parquimetros.Multa TO 'inspector'@'%';
   	GRANT SELECT ON parquimetros.Accede TO 'inspector'@'%';
    GRANT SELECT ON parquimetros.Asociado_con TO 'inspector'@'%';
   	GRANT SELECT ON parquimetros.Parquimetros TO 'inspector'@'%';
   	GRANT INSERT ON parquimetros.Multa TO 'inspector'@'%';
   	GRANT INSERT ON parquimetros.Accede TO 'inspector'@'%';



delimiter !
create procedure conectar (IN id_tarjeta INTEGER, IN id_parq INTEGER)
begin
	declare Mensaje VARCHAR(50);
    declare Operacion VARCHAR(50);
    declare c INTEGER;
    declare s DECIMAL (5,2);
    declare d DECIMAL(3,2);
    declare t INTEGER; #tarifa. 
    declare Tiempo DECIMAL (10,2);
	
         # Declaro variables locales para recuperar los errores 
	 DECLARE codigo_SQL  CHAR(5) DEFAULT '00000';	 
	 DECLARE codigo_MYSQL INT DEFAULT 0;
	 DECLARE mensaje_error TEXT;
	 
     # mas info en: http://dev.mysql.com/doc/refman/5.0/en/declare-handler.html
     DECLARE EXIT HANDLER FOR SQLEXCEPTION 	 	 
	  BEGIN #En caso de una excepción SQLEXCEPTION retrocede la transacción y
         	# devuelve el código de error especifico de MYSQL (MYSQL_ERRNO), 
			# el código de error SQL  (SQLSTATE) y el mensaje de error  	  
	    # "GET DIAGNOSTICS" solo disponible a partir de la versión 5.6, 
		# más info en: http://dev.mysql.com/doc/refman/5.6/en/get-diagnostics.html
		GET DIAGNOSTICS CONDITION 1  codigo_MYSQL= MYSQL_ERRNO,  
		                             codigo_SQL= RETURNED_SQLSTATE, 
									 mensaje_error= MESSAGE_TEXT;
	    SELECT 'SQLEXCEPTION!, transacción abortada' AS resultado, 
		        codigo_MySQL, codigo_SQL,  mensaje_error;		
        ROLLBACK;
	  END;		      
         
	 START TRANSACTION;	# Comienza la transacción  

    SET t = 1; #Suponemos la misma para cualquier ubicacion.
	SELECT count(*), saldo INTO c, s
    FROM Tarjetas
    WHERE Tarjetas.id_tarjeta = id_tarjeta;
          
    if c = 0 then #Si el ID de tarjeta es inválido
		SET Mensaje = "id de tarjeta inválido";
		SELECT id_tarjeta, Mensaje as Error;
	else #Si el ID de tarjeta es válido
		SELECT count(*) INTO c
		FROM parquimetros
		WHERE parquimetros.id_parq = id_parq;
        
        if c = 0 then #Si el ID de parquímetro es inválido
        
			SET Mensaje = "id de parquimetro inválido";
			SELECT id_parq, Mensaje as Error;
        
        else #Si el ID de parquímetro es válido, me fijo si hay un estacionamiento abierto con esa tarjeta
        
			SELECT count(*) INTO c
			FROM Estacionamientos as E
			WHERE fecha_sal IS NULL AND hora_sal IS NULL AND id_tarjeta = E.id_tarjeta;
			
			if c = 0 then #No hay estacionamiento abierto, abre uno
				
                if s > 0 then #Si tiene saldo disponible
					INSERT INTO Estacionamientos VALUES(id_tarjeta, id_parq, CURDATE() ,CURTIME() ,NULL ,NULL); #Estacionamiento abierto
					SET Mensaje = "Operación Exitosa";
					SET Operacion = "Apertura";
					SELECT descuento INTO d FROM Tarjetas NATURAL JOIN Tipos_tarjeta WHERE Tarjetas.id_tarjeta = id_tarjeta;
					SET Tiempo = s/(t*(1-d));
					SELECT Operacion, Mensaje, Tiempo as Tiempo_Disponible;
                else #Si es pobre/ratón
					SET Mensaje = "Saldo insuficiente";
					SET Operacion = "Apertura";
					SET Tiempo = 0;
					SELECT Operacion, Mensaje, Tiempo as Tiempo_Disponible;
                end if;
            else #Cierra el estacionamiento abierto
				SELECT (TIME_TO_SEC(TIMEDIFF(NOW(), concat(Estacionamientos.fecha_ent,' ',Estacionamientos.hora_ent)))/60) INTO Tiempo
			FROM Estacionamientos WHERE Estacionamientos.id_tarjeta = id_tarjeta AND fecha_sal IS NULL AND hora_sal IS NULL FOR UPDATE;
				UPDATE Estacionamientos SET fecha_sal = curdate(), hora_sal = curtime() 
                WHERE Estacionamientos.id_tarjeta = id_tarjeta AND fecha_sal IS NULL AND hora_sal IS NULL;
				SET Mensaje = "Operación Exitosa";
				SET Operacion = "Cierre";
                SELECT descuento INTO d FROM Tarjetas NATURAL JOIN Tipos_tarjeta WHERE Tarjetas.id_tarjeta = id_tarjeta;
				SET s = s - Tiempo*t*(1-d);
                UPDATE Tarjetas SET Tarjetas.saldo = s WHERE Tarjetas.id_tarjeta = id_tarjeta;
				SELECT Operacion, Mensaje, Tiempo as tiempo_transcurrido, s as saldo_disponible;
            end if;
            
		end if;
        
	end if;
	COMMIT;   # Comete la transacción  
end; !
delimiter ;

delimiter !
CREATE TRIGGER AñadirVenta after INSERT ON Tarjetas for each row
begin
	INSERT INTO ventas (id_tarjeta, tipo_tarjeta, saldo, fecha, hora) 
	VALUES (NEW.id_tarjeta, NEW.tipo, NEW. saldo, curdate(), curtime());
end; !
delimiter ;

# Usuario parquímetros
	CREATE USER 'parquimetro'@'%' IDENTIFIED BY 'parq';	
   	GRANT EXECUTE ON procedure parquimetros.conectar TO 'parquimetro'@'%';
	GRANT SELECT ON parquimetros.Tarjetas TO 'parquimetro'@'%';
	GRANT SELECT ON parquimetros.Parquimetros TO 'parquimetro'@'%';

FLUSH PRIVILEGES;
