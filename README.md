# inmoBarcelona

Mi proyecto final del Bootcamp en Backend de Ironhack

## Tema

Una plataforma que permita a los usuarios buscar, filtrar y obtener información detallada sobre los inmuebles en venta en la ciudad.
Puedo sacar datos scrapeando Idealista.

## Modelos

- Inmueble: Dirección, superficie, número de habitaciones, precio, descripción, estado (nuevo, usado), y fecha de publicación
- Vivienda (extiende Inmueble): si tiene garaje, jardín, piscina
- Local (extiende Inmueble): tipo de negocio (oficina, tienda, almacén, etc.), mobiliario/equipo

- Dirección: Barrio, Calle, número, piso, puerta
- Barrio: id, nombre, descripción
- Calle: id, nombre

## Relaciones

- Usuario: nombre, apellido, correo electrónico y contraseña.
- Favoritos: @ManyToMany con Inmueble
- Barrio: @ManyToMany con Calle

## Rutas CRUD

- GET: Lista de Inmuebles con filtros (precio, número de habitaciones...).
- POST: Publicar un nuevo Inmueble en venta
- PUT/PATCH: Actualizar información de un Inmuebles en venta
- DELETE: Eliminar un Inmuebles en venta

## Autenticación

- Roles: comprador, vendedor, administrador. No es obligatorio
