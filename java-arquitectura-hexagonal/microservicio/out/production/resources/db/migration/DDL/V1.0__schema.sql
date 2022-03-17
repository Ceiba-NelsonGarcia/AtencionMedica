create table usuario (
    id_usuario int(11) not null auto_increment,
    nombre_usuario varchar(100) not null,
    primary key (id_usuario)
);

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`) VALUES (NULL, 'Nelson Garcia');
INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`) VALUES (NULL, 'Lizeth Ariza');
INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`) VALUES (NULL, 'Cesar Castro');
INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`) VALUES (NULL, 'Tania Rojas');

create table tarifa (
    id_tarifa int(11) not null auto_increment,
    tarifa varchar(100) not null,
    valor_tarifa int(8) not null,
    primary key (id_tarifa)
);

INSERT INTO `tarifa` (`id_tarifa`, `tarifa`,`valor_tarifa`) VALUES (NULL, 'General', 50);
INSERT INTO `tarifa` (`id_tarifa`, `tarifa`,`valor_tarifa`) VALUES (NULL, 'Espeialista', 60);
INSERT INTO `tarifa` (`id_tarifa`, `tarifa`,`valor_tarifa`) VALUES (NULL, 'Hora Extra', 2);
INSERT INTO `tarifa` (`id_tarifa`, `tarifa`,`valor_tarifa`) VALUES (NULL, 'No Habiles', 5);
INSERT INTO `tarifa` (`id_tarifa`, `tarifa`,`valor_tarifa`) VALUES (NULL, 'No Habiles Extra', 7);

create table horario (
    id_horario int(11) not null auto_increment,
    horario varchar(100) not null,
    hora_inicial int(2) not null,
    hora_final int(2) not null,
    primary key (id_horario)
);

INSERT INTO `horario` (`id_horario`, `horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Regular', 8, 17);
INSERT INTO `horario` (`id_horario`, `horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Extra Inicial', 0, 7);
INSERT INTO `horario` (`id_horario`, `horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Extra Final', 18, 24);

create table doctor (
    id_doctor int(11) not null auto_increment,
    nombre_doctor varchar(100) not null,
    id_tarifa int(1) not null,
    id_horario int(1) not null,
    primary key(id_doctor)
);

ALTER TABLE doctor ADD CONSTRAINT doctor_FK_1_tarifa FOREIGN KEY (id_tarifa) REFERENCES tarifa(id_tarifa) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE doctor ADD CONSTRAINT doctor_FK_2_horario FOREIGN KEY (id_horario) REFERENCES horario(id_horario) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Fabio Tellez', '1', '1');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Diego Ariza', '1', '2');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Alisson Vargas', '1', '3');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Ligia Martinez', '2', '1');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Orlando Gutierrez', '2', '2');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Martha Rios', '2', '3');

create table cita (
    id_cita int(11) not null auto_increment,
    id_usuario int(11) not null,
    id_doctor int(11) not null,
    fecha_cita datetime not null,
    hora_inicial int(2) not null,
    hora_final int(2) not null,
    valor_usd float(8,2),
    valor_cop float(8,2),
    primary key (id_cita)
);

ALTER TABLE cita ADD CONSTRAINT cita_FK_1_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE cita ADD CONSTRAINT cita_FK_1_doctor FOREIGN KEY (id_doctor) REFERENCES doctor(id_doctor) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `cita` (`id_cita`, `id_usuario`, `id_doctor`, `fecha_cita`, `hora_inicial`, `hora_final`, `valor_usd`, `valor_cop`) VALUES (NULL, '1', '1', DATE('2022-03-14 17:41:27'), '8', '9', '50', '185000');