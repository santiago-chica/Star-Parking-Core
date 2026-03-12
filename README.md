# 🚗 Star Parking Core

Star Parking Core busca revolucionar el servicio de parqueo para distintos tipos de vehículos.  
Se diferencia del servicio convencional al integrar **inteligencia artificial** que sirve como apoyo para identificar las características de los vehículos de manera automatizada.

---

## 📌 Descripción del Proyecto

Star Parking Core es un sistema diseñado para optimizar la gestión de parqueaderos mediante el uso de tecnologías modernas y algoritmos de inteligencia artificial.  

El sistema permite:

- 🔍 Identificación automática de vehículos.
- 🚘 Clasificación por tipo (automóvil, motocicleta, vehículo pesado, etc.).
- 🧠 Análisis inteligente de características vehiculares.
- 📊 Gestión eficiente de espacios disponibles.
- 🕒 Registro automatizado de ingreso y salida.

---

## 🎯 Objetivos

- Reducir errores humanos en la identificación de vehículos.
- Optimizar tiempos de acceso y salida.
- Mejorar la seguridad mediante validación automática.
- Implementar soluciones tecnológicas escalables y modernas.

# Servicios del API

## Clientes

Gestiona la información de los clientes del sistema.

Base URL: /api/clients

 - GET  /api/clients: Obtiene todos los clientes 
 - GET  /api/clients/{id}: Obtiene un cliente por ID 
 - POST  /api/clients: Crea un nuevo cliente 
 - PUT  /api/clients/{id}: Actualiza un cliente 
 - DELETE  /api/clients/{id}: Elimina un cliente 

--------------------------------------------------------

# Vehículos

Gestiona los vehículos registrados en el sistema.

Base URL: /api/vehicles

 - GET  /api/vehicles: Lista todos los vehículos 
 - GET  /api/vehicles/{id}: Obtiene un vehículo por ID 
 - POST  /api/vehicles: Registra un vehículo 
 - PUT  /api/vehicles/{id}: Actualiza un vehículo 
 - DELETE  /api/vehicles/{id}: Elimina un vehículo 

-----------------------------------------------------------

# Tipos de Vehículo

Define los tipos de vehículos permitidos en el parqueadero.

Base URL: /api/vehicle-types

 - GET  /api/vehicle-types: Lista tipos de vehículo 
 - GET  /api/vehicle-types/{id}: Obtiene tipo por ID 
 - POST  /api/vehicle-types: Crea un tipo de vehículo 
 - PUT  /api/vehicle-types/{id}: Actualiza un tipo 
 - DELETE  /api/vehicle-types/{id}: Elimina un tipo 

----------------------------------------------------------

# Colores de Vehículo

Administra los colores disponibles para los vehículos.

Base URL: /api/vehicle-colors

 - GET  /api/vehicle-colors: Lista colores 
 - GET  /api/vehicle-colors/{id}: Obtiene color 
 - POST  /api/vehicle-colors: Crea color 
 - PUT  /api/vehicle-colors/{id}: Actualiza color 
 - DELETE  /api/vehicle-colors/{id}: Elimina color 

--------------------------------------------------------------

# Espacios de Parqueo

Gestiona los espacios disponibles en el parqueadero.

Base URL: /api/parking-spots

 - GET  /api/parking-spots: Lista todos los espacios 
 - GET  /api/parking-spots/{id}: Obtiene un espacio 
 - POST  /api/parking-spots: Crea un espacio 
 - PUT  /api/parking-spots/{id}: Actualiza un espacio 
 - DELETE  /api/parking-spots/{id}: Elimina un espacio 

----------------------------------------------------------------

# Uso de Parqueo

Registra cuándo un vehículo usa un espacio de parqueo.

Base URL: /api/parking-uses

 - GET  /api/parking-uses: Lista registros de uso 
 - GET  /api/parking-uses/{id}: Obtiene un registro 
 - POST  /api/parking-uses: Registra un uso 
 - PUT  /api/parking-uses/{id}: Actualiza registro 
 - DELETE  /api/parking-uses/{id}: Elimina registro 

------------------------------------------------------------------

# Pagos

Gestiona los pagos realizados por los clientes.

Base URL: /api/payments

 - GET  /api/payments: Lista pagos 
 - GET  /api/payments/{id}: Obtiene un pago 
 - POST  /api/payments: Registra un pago 
 - PUT  /api/payments/{id}: Actualiza pago 
 - DELETE  /api/payments/{id}: Elimina pago 

-----------------------------------------------------------------

# Facturación

Gestiona las facturas generadas en el sistema.

Base URL: /api/bills

 - GET  /api/bills: Lista facturas 
 - GET  /api/bills/{id}: Obtiene factura 
 - POST  /api/bills: Crea factura 
 - PUT  /api/bills/{id}: Actualiza factura 
 - DELETE  /api/bills/{id}: Elimina factura 

----------------------------------------------------------------

# Suscripciones

Administra suscripciones de clientes (planes o membresías).

Base URL: /api/subscriptions

 - GET  /api/subscriptions: Lista suscripciones 
 - GET  /api/subscriptions/{id}: Obtiene suscripción 
 - POST  /api/subscriptions: Crea suscripción 
 - PUT  /api/subscriptions/{id}: Actualiza suscripción 
 - DELETE  /api/subscriptions/{id}: Elimina suscripción 

-----------------------------------------------------------------

# Historial de Suscripciones

Registra cambios o eventos relacionados con las suscripciones.

Base URL: /api/subscription-logs

 - GET  /api/subscription-logs: Lista historial 
 - GET  /api/subscription-logs/{id}: Obtiene registro 
 - POST  /api/subscription-logs: Crea registro 
 - PUT  /api/subscription-logs/{id}: Actualiza registro 
 - DELETE  /api/subscription-logs/{id}: Elimina registro 

-----------------------------------------------------------------

# Usuarios

Gestiona los usuarios del sistema.

Base URL: /api/users

 - GET  /api/users: Lista usuarios 
 - GET  /api/users/{id}: Obtiene usuario 
 - POST  /api/users: Crea usuario 
 - PUT  /api/users/{id}: Actualiza usuario 
 - DELETE  /api/users/{id}: Elimina usuario 

-----------------------------------------------------------------

# Actividades

Registra actividades realizadas en el sistema.

Base URL: /api/activities

 - GET  /api/activities: Lista actividades 
 - GET  /api/activities/{id}: Obtiene actividad 
 - POST  /api/activities: Crea actividad 
 - PUT  /api/activities/{id}: Actualiza actividad 
 - DELETE  /api/activities/{id}: Elimina actividad 
 
---------------------------------------------------------------

## Setup
En application.properties se tienen las siguientes definiciones

```
spring.application.name=Star Parking Core

server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/star-parking-dev

spring.datasource.username=root
spring.datasource.password=

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

Para ver documentación en http://localhost:8080/swagger-ui/index.html
