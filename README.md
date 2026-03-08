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