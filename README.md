# almacen_microservice
Ejercio de varios microservicios de 3 microservicio inter comunicados entre se de producto-inventrario-tiket 
Usando buenas practicas,standares de pogramacion, y verbos http,DTO's,codigos de estado,patrones de diseño y patron de arquitectura de microservicios

Ejercicio de micro servicios usando ApiRESTful la codificacion de los serviios se encuentran en la carpeta -->nombre del servicio-->src 

- los end point son:

- (post) /api/v1/order -> crea una orden con una lista de productos
- (get) /api/v1/order -> devuelve todas las ordenes creadas
- (get) /api/v1/inventory/{sku} -> para verificar si existe el pruducto
- (post) /api/v1/inventory/in-stock -> crea una lista de items para una orden de productos
- (post) /api/v1/Product -> para crear productos
- (get) /api/v1/Product -> obtener una lista de productos


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
    - el servicio de inventario tiene dos tareas importantes, crea listas de productos donde se comunica con el servicio de ordenes y tambien verificacon el servicio de productos para obtener informacion si existe el producto en el alamcen esta informacion esta respalda en un server de postgressSQL
      
- un servico de tikets  
    - el servicio de tikets o de ordenes es el encargado principal de obtener informacion de los microservicios de inventario y de productos,aqui es donde se generan los tikets de ordenes otorgandoles un uid unico para cada orden con un lista de productos necesarios tambein esta respaldado en una base de datos MYSQL
      
- un serwvicio de productos
    - el servicio de productos se encarga de registrar cada uno de los productos juntos con una breve descripccion de cada uno con varios atributos como:
    - id unico
    - sku
    - nombre
    - descripcion
    - precio
    - status
