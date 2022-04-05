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