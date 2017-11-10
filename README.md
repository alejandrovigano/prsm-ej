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

## Solucion Alternativa
Como solucion alternativa al requerimiento, se puede usar spring-data-rest, el cual genera los endpoints necesarios en base a los repositorios.
```
   	// compile("org.springframework.data:spring-data-rest-webmvc") // solucion alternativa
    // compile("org.springframework.data:spring-data-rest-hal-browser")
```