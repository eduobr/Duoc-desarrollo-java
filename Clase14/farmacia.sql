USE farmacia;

CREATE TABLE ´producto´(
  ´codigo´ int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ´precio_base´ int(20) NOT NULL,
  ´nombre´ varchar(20) NOT NULL
);

CREATE TABLE ´farmacia´(
  ´id_farmacia´ int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ´nombre_farmacia´ varchar(20) NOT NULL,
  ´comuna´ varchar(20) NOT NULL,
  ´encargado´ varchar(20) NOT NULL 
);

CREATE TABLE ´stock´(
  ´id_stock´ int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ´codigo_producto´ int(3) NOT NULL,
  ´id_farmacia´ int(3) NOT NULL,
  FOREIGN KEY(´codigo_producto´) REFERENCES ´producto´(´codigo´),
  FOREIGN KEY(´id_farmacia´) REFERENCES ´farmacia´(´id_farmacia´)
)