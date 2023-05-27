# inmoBarcelona
Mi proyecto final del Bootcamp en Backend de Ironhack

## Descripción del proyecto
inmoBarcelona es una plataforma web que permite a los usuarios publicar, buscar, y obtener información sobre los inmuebles en venta en la ciudad de Barcelona. La aplicación también permite a los usuarios crear una lista de favoritos de las propiedades.

Cuenta con los siguientes modelos:
1. **User**: representa a los usuarios de la plataforma. Cada usuario tiene un nombre, un nombre de usuario y una contraseña. Un usuario puede tener varios roles y puede marcar varios inmuebles como favoritos.
2. **Role**: representa los distintos roles que pueden tener los usuarios en la plataforma, que le dan unos u otros permisos. Se definen tres por defecto: "ROLE_BUYER", "ROLE_SELLER" y "ROLE_ADMIN".
3. **Property**: modela los inmuebles que están disponibles en la plataforma. Cada inmueble está asociado con un usuario (el propietario), tiene una dirección y puede tener una lista de usuarios que lo han marcado como favorito. Además, cada inmueble tiene información sobre su área en metros cuadrados, número de habitaciones, precio, descripción, estado (enum PropertyStatus), fecha de publicación y orientación (enum ORIENTATION).
4. **Address**: representa la dirección de un inmueble. Contiene información sobre el número de la calle, el piso y la puerta, así como referencias al barrio y a la calle donde se encuentra.
5. **Neighborhood**: representa los distintos barrios de Barcelona. Contiene un nombre y una descripción del barrio que podría ser útil para compradores que no conocen bien la ciudad, y mantiene una lista de todas las direcciones que están dentro de ese vecindario.
6. **Street**: representa las diferentes calles donde se pueden ubicar los inmuebles. Cada calle tiene un nombre y mantiene una lista de todas las direcciones que se encuentran en esa calle.
7. **Favorite**: sirve como entidad intermedia entre el modelo de Usuario y el de Inmueble. Representa a los inmuebles que han sido marcados como favoritos por los usuarios.

## Diagrama de Clases
![Diagrama de clases UML](https://github.com/carlostxrres/inmoBarcelona/blob/main/inmoBarcelona.png)

## Configuración
Para configurar este proyecto en tu entorno local, sigue los pasos a continuación:

1. Clona el repositorio a tu ordenador local utilizando `git clone https://github.com/carlostxrres/inmoBarcelona.git`
2. Navega al directorio del proyecto: `cd inmoBarcelona`
3. Instala las dependencias del proyecto: `mvn install`
4. Inicia la aplicación

## Tecnologías utilizadas
- Java 11
- Spring Boot 2.4.5
- Spring Security
- JPA / Hibernate
- MySQL
- Maven
- Lombok
- SLF4J

## Estructura de controladores y rutas
Se proporciona una API REST con las siguientes rutas para la interacción con la base de datos:

| Operación CRUD | Ruta | Roles con permiso | Descripción |
|---|---|---|---|
| GET | api/properties | Admin, Seller, Buyer | Ve la lista de inmuebles. |
| POST | api/properties | Admin, Seller | Crea un inmueble |
| PUT | api/properties/{id} | Admin, Seller | Edita un inmueble. |
| DELETE | api/properties/{id} | Admin, Seller | Elimina un inmueble. |
| GET | api/favorites | Admin, Seller, Buyer | Ve la lista de favoritos. |
| POST | api/users/{userId}/favorites/{propertyId} | Admin, Seller, Buyer | Añade un inmueble a favoritos. |
| DELETE | api/favorites/{id} | Admin, Seller, Buyer | Elimina un inmueble de favoritos. |
| GET | api/users | Admin, Seller, Buyer | Ve la lista de usuarios. |
| POST | api/users | Admin | Crea un usuario. |
| POST | api/roles/addtouser | Admin | Asigna un rol a un usuario. |
| POST | api/login | Admin, Seller, Buyer | Autentifica a un usuario. |

## Enlaces adicionales (Trello, presentaciones, etc.)
Los enlaces a la presentación, Trello y otros materiales se proporcionarán pronto.

## Trabajo futuro
- Crear tests más robustos.
- Agregar funcionalidad para obtener datos de la web scrapeando portales inmobiliarios como Idealista.

## Recursos
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/5.4/)
- [Java 11 Documentation](https://docs.oracle.com/en/java/javase/11/)

## Miembros del equipo
Carlos
