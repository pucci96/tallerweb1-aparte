INSERT INTO Usuario(id, email, password, rol, activo) VALUES(null, 'test@unlam.edu.ar', 'test', 'ADMIN', true);

INSERT INTO Establecimiento(id,cantLugaresParaDiscapacitados, cantidadEstacionamientosDisponibles, capacidadMaxima, direccion, nombre, usuario_id) VALUES(1, 10, 50, 50, 'Arieta 1234', 'Larga Vida', 1);

INSERT INTO Estacionamiento(id,establecimiento,usuario, fecha) VALUES(1,1,1,null);