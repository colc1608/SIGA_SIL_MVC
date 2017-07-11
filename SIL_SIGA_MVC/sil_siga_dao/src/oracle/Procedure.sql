

---------------------------------------------
---------------------------------------------
-- PROCEDURE PARA EL DOCENTE :)


create or replace procedure sp_addDocente
(espec in int, nom in varchar, apater in varchar, amater in varchar, dni in varchar, fec in DATE)
as

VID INT;

begin

      SELECT sq_usuario.NEXTVAL
      INTO VID
      FROM DUAL;
      
insert into usuario ( id, usuario, clave, tipo)
values (VID, (select usuario+1  from usuario where id = (select max(id) from usuario)), (SELECT dbms_random.string('x', 8) FROM dual),'1');
      
      SELECT sq_docente.NEXTVAL
      INTO VID
      FROM DUAL;

insert into docente (id, idespecialidad, nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, FECHADENACIMIENTO)
values (VID, espec,nom,apater,amater,dni,(select max(id) from usuario), fec);

end;



---------------------------------------------
---------------------------------------------
-- PROCEDURE PARA EL ALUMNO :)
create or replace procedure sp_addAlumno
( nom in varchar, apater in varchar, amater in varchar, dni in varchar, telefono in varchar, movil in varchar, email in varchar )
as

VID INT;

begin

      SELECT sq_usuario.NEXTVAL
      INTO VID
      FROM DUAL;
      
insert into usuario ( id, usuario, clave, tipo)
values (VID, (select usuario+1  from usuario where id = (select max(id) from usuario)), (SELECT dbms_random.string('x', 8) FROM dual),'2');
      
      SELECT sq_alumno.NEXTVAL
      INTO VID
      FROM DUAL;

insert into ALUMNO (id, nombre, APELLIDOPATERNO, APELLIDOMATERNO, dni, idusuario, telefono, movil, email)
values (VID,nom,apater,amater,dni,(select max(id) from usuario), telefono, movil, email);

end;

------------------------------------------------
------------------------------------------------
--PROCEDIMIENTO PARA EL PARENTESCO

create or replace PROCEDURE SP_ADDPARENTESCO
(par in varchar, obs in varchar)
AS
vid INT;
BEGIN
    SELECT SQ_PARENTESCO.NEXTVAL
    INTO vid FROM DUAL;
    
    INSERT INTO PARENTESCO(ID,PARENTESCO, OBSERVACION,IDALUMNO,IDAPODERADO)
    VALUES(vid,par,obs,(select max(id) from ALUMNO),(select max(id) from APODERADO));
END;
