# integrador2

//2b
insert into Carrera_Estudiante(x, x, x) VALUES(:carrera, :estudiante)

//2f
SELECT c 
FROM Carrera c
JOIN Carrera_Estudiante ce 
group by carrera
ORDER BY count(c)

//2g
SELECT e
FROM Estudiante e
JOIN Carrera_Estudiante ce 
WHERE ce.carrera = :carrera
AND e.ciudad=:ciudad

en clase estudiante y carrera
@OneToMany(mapped by estudiante)
List<Estudiante_Carrera> carreras


//entidad relacion
@ManyToOne(cascade = CascadeType.MERGE)//se actualiza cuando lo hace estudiante (es como ponerle un .all a esrtudiante)
@JoinColumn(name="fk_estudiante")
private Estudiante estudiante;
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name="fk_carrera")
private Carrera carrera;

