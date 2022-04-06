insert into usuario(id_usuario, nombre_usuario) values(1,'test');

INSERT INTO `tarifa` (`id_tarifa`, `nombre_tarifa`,`valor_tarifa`) VALUES (NULL, 'General', 50);

INSERT INTO `horario` (`id_horario`, `nombre_horario`,`hora_inicial`, `hora_final`) VALUES (NULL, 'Regular', 8, 17);

INSERT INTO `doctor` (`id_doctor`, `nombre_doctor`, `id_tarifa`, `id_horario`) VALUES (NULL, 'Fabio Tellez', '1', '1');

INSERT INTO `cita` (`id_cita`, `id_usuario`, `id_doctor`, `fecha_cita`, `hora_inicial`, `hora_final`, `valor_usd`, `valor_cop`)
VALUES (NULL, '1', '1', DATE('2022-03-14 17:41:27'), '8', '9', '50', '185000');