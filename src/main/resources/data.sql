DROP TABLE IF EXISTS tipo_cambio;

CREATE TABLE tipo_cambio (
                             id INT AUTO_INCREMENT  PRIMARY KEY,
                             moneda_origen CHAR(3) NOT NULL,
                             moneda_destino CHAR(3) NOT NULL,
                             ratio double DEFAULT 0.0,
                             fecha date NULL
);

insert into tipo_cambio (id,moneda_origen,moneda_destino,ratio,fecha)values('1','PEN', 'USD', 0.24,'2021-10-05');
insert into tipo_cambio (id,moneda_origen,moneda_destino,ratio,fecha)values('2','PEN', 'EUR', 0.21,'2021-10-05');
insert into tipo_cambio (id,moneda_origen,moneda_destino,ratio,fecha)values('3','PEN', 'CAD', 0.30,'2021-10-05');
insert into tipo_cambio (id,moneda_origen,moneda_destino,ratio,fecha)values('4','PEN', 'BTC', 0.048,'2021-10-05');
insert into tipo_cambio (id,moneda_origen,moneda_destino,ratio,fecha)values('5','USD', 'PEN', 4.13,'2021-10-05');
insert into tipo_cambio (id,moneda_origen,moneda_destino,ratio,fecha)values('6','EUR', 'PEN', 4.79,'2021-10-05');

