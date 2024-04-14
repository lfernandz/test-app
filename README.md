Prueba Técnica
===

La aplicación test-app cuenta con 5 microservicios, los cuales se nombran a continuación:
1. CloudConfigServer
2. EurekaService
3. GatewayService
4. WasteManagerAddressService
5. WasteManagerService

# Funcionalidades por microservicio

Microservicio CloudConfigServer:

+ Este microservicion contiene la configuracion de cada uno de los microservicios restantes, dentro de la que se incluye 
la conexión a base de datos, eureka, perfiles activos, entre otras.

Microservicio EurekaService:

+ Este microservicio tiene la responsabilidad de establecer el servidor de Eureka, brindando el servicio a los otros microservicios
como clientes

Microservicio GatewayService:

+ Este microservicio se encarga de redireccionar las solicitudes a su correspondiente microservicio.

Microservicio WasteManagerAddressService:

+ Este microservicio controla todas las funcionalidades correspondientes al manejo de la información de la Waste Manager Address

Microservicio WasteManagerService

+ Este microservicio controla todas las funcionalidades correspondientes al manejo de la informacion de la Waste Manager y Waste Center Authorization

# Requisitos previos

Antes de ejecutar el proyecto, asegúrese de tener instalado lo siguiente:

+ Java Development Kit (JDK 17)
+ IntelliJ IDEA o el IDE de su preferencia
+ Maven

# Obtener

Clonar el repositorio
``git clone https://github.com/lfernandz/test-app.git``

# Ejecución

Para la ejecución, debemos iniciar primeramente el microservicio CLoudConfigServer,
pues es quien porta las configuraciones de los próximos microservicios a levantar.

A continuación se debe ejecutar el microservicio EurekaService, pues siendo el servidor de Eureka, permite que los siguientes microservicios puedan 
establecer una comunicación con Eureka.

Próximamente se deben ejecutar los microservicios WasteManagerService y WasteManagerAddressService
en orden de preferencia y seguidamente el otro.

Por último se debe ejecutar el microservico GatewayService, para poder establecer la distribución de las solicitudes mediante este.

# Test

Antes de iniciar los test debe conocer que existen datos información en la base de datos, insertada previamente al iniciar el microservcicio
la cual se puede revisar en la consola H2

``url: http://localhost:9090/h2-console/``

``Driver Class: org.h2.Driver``

``JDBC URL: jdbc:h2:mem:wastedb``

``User Name: sa``

``Password: password``

O apoyarse en los archivos ubicados en
``src/main/resources/data.sql``
para ver la información


Puede auxiliarse de herramientas como Postman para realizar las pruebas.

# Test microservicio WasteManagerAddressService

Enpoint para obtener el listado de WasteManagerAddress
``
GET - localhost:8080/waste-manager-address/find-all
``

Enpoint para obtener un WasteManagerAddress por id
``
GET - localhost:8080/waste-manager-address/find-by-id/{id}
``

Enpoint para crear un nuevo WasteManagerAddress
``
POST - localhost:8080/waste-manager-address/create
``
``
Body:
{
"direccion": "direccion a insertar"
}
``

Enpoint para actualizar un WasteManagerAddress
``
PUT - localhost:8080/waste-manager-address/update
``
``
Body:
{
    "id": 6,
    "direccion": "Example Updated",
    "isEnabled" : false,
    "version" : 1
}
``

Enpoint para eliminar un WasteManagerAddress
``
DELETE - localhost:8080/waste-manager-address/delete/{id}
``

# Test microservicio WasteManagerService

Enpoint para obtener un WasteManager por id
``
GET - localhost:8080/waste-manager/find-by-id/{id}
``

Enpoint para crear un nuevo WasteManager
``
POST - localhost:8080/waste-manager/create
``
``
Body:
{
"nombre": "ejemplo",
"nif": "nif",
"wasteManagerAddressDto": {
"direccion": "Example 7",
"wasteManagerId": 7
},
"listOfWasteCenterAuthorization": [
{
"authorizationNumber": "ejemplo 1"
},
{
"authorizationNumber": "ejemplo 2"
}
]
}
``

Enpoint para actualizar un WasteManager
``
PUT - localhost:8080/waste-manager/update
``
``
Body:
{
"id": 3,
"nombre": "ejemplo cambiado",
"nif": "nif",
"isEnabled": true,
"version": 0,
"createdDate": "2024-04-13T23:49:38.175+00:00",
"lastModifiedDate": "2024-04-13T23:49:38.175+00:00",
"wasteManagerAddressDto": {
"id": 9,
"direccion": "Example cambiado 7",
"isEnabled": true,
"version": 0,
"createdDate": "2024-04-13T23:49:38.208+00:00",
"lastModifiedDate": "2024-04-13T23:49:38.208+00:00"
},
"listOfWasteCenterAuthorization": [
{
"id": 3,
"authorizationNumber": "ejemplo cambiado 1"
},
{
"id": 4,
"authorizationNumber": "ejemplo cambiado 2"
}
]
}
``
