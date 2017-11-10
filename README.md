# Ejercicio Prisma

Aplicacion basada en spring boot + data jpa + hateoas + gradle

## Endpoints

Buscar inmuebles por categoria
```
  GET /inmueble?categoria={categoriaId}[&page&size&sort&dir]
```
Eliminar relacion inmueble/propietario
```
  DELETE /inmueble/{idInmueble}/propietario
```
Obtener inmueble*
```
  GET /inmueble/{idInmueble}
```
Crear propietario
```
  POST /propietario
```
Obtener propietario
```
  GET /propietario/{idPropietario]
```
Actualizar propietario
```
  PUT /propietario/{idPropietario} 
```
Obtener categorias*
```
  GET /categoria
```

###### *no solicitado

## Profiles

* **inmemory** - Levanta una base H2 en memoria
```
-Dspring.profiles.active=inmemory
```
* **default** - Se conecta a una base mysql, requiere las variables de entorno **db.url** , **db.user** , **db.password**. No es necesario especificar profile
```
-Ddb.url=jdbc:mysql://192.168.0.5:3306/prisma -Ddb.user=root -Ddb.password=root
```

En ambos casos se corre el script import.sql que se encuentra en src/main/resources
Propertie spring.jpa.hibernate.ddl-auto seteada en create

## Docker

Correr gradle assemble|build y generar la imagen docker

Correr el contenedor pasando la variable JAVA_OPTS

#### Profile inmemory
```
docker run -p 8080:8080 -e JAVA_OPTS=-Dspring.profiles.active=inmemory image
```
#### Profile default
```
docker run -p 8080:8080 -e "JAVA_OPTS=-Ddb.url=jdbc:mysql://192.168.0.5:3306/prisma -Ddb.user=root -Ddb.password=root" image
```

## Posman

El archivo **Prisma Ejercicio.postman_collection.json** que se encuentra en el raiz del proyecto, se importa a postman, ya contiene los endpoint para probar