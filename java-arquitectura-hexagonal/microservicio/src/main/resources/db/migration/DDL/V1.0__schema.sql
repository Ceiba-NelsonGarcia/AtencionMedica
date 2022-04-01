create table usuario (
    id_usuario int(11) not null auto_increment,
    nombre_usuario varchar(100) not null,
    primary key (id_usuario)
);

create table tarifa (
    id_tarifa int(11) not null auto_increment,
    nombre_tarifa varchar(100) not null,
    valor_tarifa int(8) not null,
    primary key (id_tarifa)
);

create table horario (
    id_horario int(11) not null auto_increment,
    nombre_horario varchar(100) not null,
    hora_inicial int(2) not null,
    hora_final int(2) not null,
    primary key (id_horario)
);

create table doctor (
    id_doctor int(11) not null auto_increment,
    nombre_doctor varchar(100) not null,
    id_tarifa int(1) not null,
    id_horario int(1) not null,
    primary key(id_doctor)
);
ALTER TABLE doctor ADD CONSTRAINT doctor_FK_1_tarifa FOREIGN KEY (id_tarifa) REFERENCES tarifa(id_tarifa) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE doctor ADD CONSTRAINT doctor_FK_2_horario FOREIGN KEY (id_horario) REFERENCES horario(id_horario) ON DELETE CASCADE ON UPDATE CASCADE;

create table cita (
    id_cita int(11) not null auto_increment,
    id_usuario int(11) not null,
    id_doctor int(11) not null,
    fecha_cita datetime not null,
    hora_inicial int(2) not null,
    hora_final int(2) not null,
    valor_usd float(8),
    valor_cop float(8),
    primary key (id_cita)
);
ALTER TABLE cita ADD CONSTRAINT cita_FK_1_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE cita ADD CONSTRAINT cita_FK_1_doctor FOREIGN KEY (id_doctor) REFERENCES doctor(id_doctor) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'General', 50);
INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'Espeialista', 60);
INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'Dias Habiles', 0);
INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'Dias No Habiles', 5);
INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'Horario Regular', 0);
INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'Horario Extra', 2);

INSERT INTO `horario` (`id_horario`, `nombre_horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Regular', 8, 17);
INSERT INTO `horario` (`id_horario`, `nombre_horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Extra Inicial', 0, 7);
INSERT INTO `horario` (`id_horario`, `nombre_horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Extra Final', 18, 24);

INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Fabio Tellez', '1', '1');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Diego Ariza', '1', '2');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Alisson Vargas', '1', '3');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Ligia Martinez', '2', '1');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Orlando Gutierrez', '2', '2');
INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Martha Rios', '2', '3');