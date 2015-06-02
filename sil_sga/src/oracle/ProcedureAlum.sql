create or replace procedure sp_addAlumno
(grado in int, nom in varchar, apater in varchar, amater in varchar, dni in varchar, telefono in varchar, movil in varchar, email in varchar )
as

VID INT;

begin

      SELECT sq_usuario.NEXTVAL
      INTO VID
      FROM DUAL;
      
insert into usuario ( id, usuario, clave, tipo)
values (VID, (select usuario+1  from usuario where id = (select max(id) from usuario)), (SELECT dbms_random.string('p', 8) FROM dual),'2');
      
      SELECT sq_alumno.NEXTVAL
      INTO VID
      FROM DUAL;

insert into ALUMNO (id, idgrado, nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, telefono, movil, email)
values (VID, grado,nom,apater,amater,dni,(select max(id) from usuario), telefono, movil, email);

end;
