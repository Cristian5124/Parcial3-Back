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
6. Posterior a esto, creamos los directorios en donde se alojaran las clases Java de nuestro proyecto.
7. Creo las clases que contienen la funcionalidad del proyecto

8. Configuración de Spring Boot

9. Las pruebas Unitarias
