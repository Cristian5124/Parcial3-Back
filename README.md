# Parcial 3-CVDS
Parcial 3 - CVDS | Cristian David Polo Garrido
1. Creación del repositorio en GitHub.
2. Creación del proyecto Maven en base a las configuraciones requeridas. <br>
En este caso las configuraciones del proyecto las he determinado como: <br>
```
mvn archetype:generate -DgroupId=com.coyote -DartifactId=parcial -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
![image](https://github.com/user-attachments/assets/c1417b41-1e78-4493-9010-9b93fe31493f)


![image](https://github.com/user-attachments/assets/7abbb54d-cb60-4949-8f85-b6a94c3df17e)
<br>
3. Revisamos si todo se ha creado correctamente por medio de `mvn compile`. <br>
![image](https://github.com/user-attachments/assets/b82ca3eb-96b6-41d4-aa90-0cac4771474b)
4. Configurar el archivo pom.xml con la inyección de dependiencias que nos requiere el proyecto.
![image](https://github.com/user-attachments/assets/30c826d7-cc13-435b-91b4-fcca77f36ce1)
Agregamos la propiedad:
![image](https://github.com/user-attachments/assets/0ba20c71-b331-4a00-9e04-dbee97150479)
5. Dar `mvn package`
![image](https://github.com/user-attachments/assets/64ae439e-2144-4382-9d8a-821383b40682)
6. Posterior a esto, creamos los directorios en donde se alojaran las clases Java de nuestro proyecto:
```
C:.
│   .gitignore
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│   README.md
│   
├───.github
│   └───workflows
│           main.yml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───ecisaludvital
│   │   │           └───gestion_citas_medicas
│   │   │               │   ecisaludvitalReservasApplication.java
│   │   │               │   ServletInitializer.java
│   │   │               │
│   │   │               ├───config
│   │   │               │       SecurityConfig.java
│   │   │               │
│   │   │               ├───controllers
│   │   │               │       citaController.java
│   │   │               │       citaDTO.java
│   │   │               │       ecisaludvitalController.java
│   │   │               │
│   │   │               ├───models
│   │   │               │       Cita.java
│   │   │               │       ecisaludvital.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       CitaRepository.java
│   │   │               │       ecisaludvitalRepository.java
│   │   │               │
│   │   │               └───services
│   │   │                       CitaService.java
│   │   │                       ecisaludvitalService.java
│   │   │
│   │   └───resources
│   │       │   application-dev.properties
│   │       │   application-prod.properties
│   │       │   application.properties
│   │       │
│   │       └───META-INF
│   │               additional-spring-configuration-metadata.json
│   │
│   └───test
│       └───java
│           └───com
│               └───ecisaludvital
│                   └───gestion_citas_medicas
│                           citaControllerTest.java
│                           citaDTOTest.java
│                           CitaServiceTest.java
│
└───target
    ├───classes
    │   │   application-dev.properties
    │   │   application-prod.properties
    │   │   application.properties
    │   │
    │   ├───com
    │   │   └───ecisaludvital
    │   │       └───gestion_citas_medicas
    │   │           │   ecisaludvitalReservasApplication.class
    │   │           │   ServletInitializer.class
    │   │           │
    │   │           ├───config
    │   │           │       SecurityConfig.class
    │   │           │
    │   │           ├───controllers
    │   │           │       citaController.class
    │   │           │       citaDTO$Builder.class
    │   │           │       citaDTO.class
    │   │           │       ecisaludvitalController.class
    │   │           │
    │   │           ├───models
    │   │           │       Cita.class
    │   │           │       ecisaludvital.class
    │   │           │
    │   │           ├───repositories
    │   │           │       CitaRepository.class
    │   │           │       ecisaludvitalRepository.class
    │   │           │
    │   │           └───services
    │   │                   CitaService.class
    │   │                   ecisaludvitalService.class
    │   │
    │   └───META-INF
    │           additional-spring-configuration-metadata.json
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       │           createdFiles.lst
    │       │           inputFiles.lst
    │       │
    │       └───testCompile
    │           └───default-testCompile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    └───test-classes
        └───com
            └───ecisaludvital
                └───gestion_citas_medicas
                        citaDTOTest.class
                        CitaServiceTest.class
                        ecisaludvitalControllerTest.class
```
7. Creo las clases que contienen la funcionalidad del proyecto

Cita.java:

```java
package com.ecisaludvital.gestion_citas_medicas.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class Cita {

    @Id
    private String id;
    private String idecisaludvital;
    private String usuario;
    private Date fecha;
    private String horaInicio;
    private String horaFin;
    private String especialidad;
    private String estado;

    public Cita() {
    }

    public Cita(String idecisaludvital, String usuario, Date fecha, String horaInicio, String horaFin, String especialidad, String estado) {
        this.idecisaludvital = idecisaludvital;
        this.usuario = usuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdecisaludvital() {
        return idecisaludvital;
    }

    public void setIdecisaludvital(String idecisaludvital) {
        this.idecisaludvital = idecisaludvital;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

```

ecisaludvital.java:

```
package com.ecisaludvital.gestion_citas_medicas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ecisaludvitals")
public class ecisaludvital {

    @Id
    private String id;
    private String nombre;
    private int capacidad;
    private String ubicacion;
    private boolean estado;

    public ecisaludvital() {
    }

    public ecisaludvital(String nombre, int capacidad, String ubicacion, boolean estado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

```

También he creado los controllers, tests, repositorios, modelos, pero esos no los pongo aquí porque me demoro mucho.


9. Creo la base de datos en MongoDB Atlas, he creado un registro en la base de datos:

   ![image](https://github.com/user-attachments/assets/183aab60-09e7-49b7-ab63-68d3a0ea6a53)


10. Las pruebas Unitarias
