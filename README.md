# almacen_microservice
Ejercio de varios microservicios de 3 microservicio inter comunicados entre se de producto-inventrario-tiket

Ejercicio de micro servicios usando ApiRESTful la codificacion de los serviios se encuentran en la carpeta -->nombre del servicio-->src 

- los end point son:

- /api/v1


esta api usa 7 microservicios

- un servicio de configuracon global

    - donde se encuentran las configuraciones de los servicio utilizados para encapsular la mayoria de configuracion utilizado por la api
      este micro servicio esta configurado para no ser visible en spring cloud para una capa de seguridad

- un servcio eureka
    -para registrar y ver los microservicios de spring cloud dados de alta

- un servicio gateway
    - para distribuir las peticiones a cada servicio correspondiente y evitar la comunicacion directa con el servicio
    - 
- un servicio de inventario
    - ###
- un servico de tikets
  
    - ###
- un serwvicio de productos
    - ###
