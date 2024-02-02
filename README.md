# STOCK MANAGER WEB PROJECT

Este documento tiene como objetivo proporcionar las directrices y la información necesaria para 
colaborar en el desarrollo de software de manera efectiva y coordinada.

## Objetivo del Proyecto

Desarrollar una aplicación web para la gestión de un inventario estandar.

## DESARROLLO:FRONT-END:

- Los ficheros se harán usando ficheros JSP (HTML dinamicos).
- La nomenclatura de los name="" y los id="" de las etiquetas del HTML pueden ser en español.
- Cada campo input debe representar una de las variables de instancia definida en cada objeto (pueden verse en la carpeta src/main/java/entities), exceptuando el id.
- Las URL para la comunicación con los Servlets type="post" y type="get" tendrán la raíz action="/StockManagerWebProject/FormularioObjeto", sin importar si el servlets está creado o no, @CarlosB revisará las URL.
- La nomenclatura se hará en español y cuando se comprueba la correcta funcionalidad de cada evento, esta se traducirá al ingles por @CarlosB.
<br>
1.   FORMULARIOS PARA DAR DE ALTA:

- Dirección / Address:
  
  Solo se puede crear en el momento en el que se crea un Comprador. <br>
  Todos los campos obligatorios.
  
- Articulo / Item:

  Este objeto se crea sin el input MovimientosDeStock.
  
- Comprador / Customer:

  Debe tener un subformulario del objeto Direccion
  Todos los datos son obligatorios.
  
- Tienda / Store:
  
  Puede prescindirse del formulario para crear tienda porque actualmente solo hay una.

- DetallesDeMovimiento / Envoice Details:
  
  Este objeto requiere un formulario en el que se creen un objeto del tipo factura y de forma dinamica uno o varios objetos del tipo MovimientoDeArticulo.

- Factura / Envoice:

  El comprador es el primer dato a comprobar que existe en la base de datos, si no existe debe alertar al usuario. <br>
  Los datos de usuario se añaden automaticamente consultando por debajo la información del usuario que haya iniciado sesión dentro del sistema.

- MovimientoDeArticulo / StockMov:
  
  Se deben poder añadir de forma dinamica a la lista de movimientos del objeto DetallesDeMovimiento. <br>
  El usuario debe poder poner el nombre o el codigo del articulo en su respectivo input para consultar que si existe dicho articulo y en caso de que no, saltar una alarma que avise   de la inexistencia del mismo.
    
INTERFACES DE BUSQUEDA DE OBJETO / TABLAS DINÁMICAS

- Usuario:

Se mostrarán los nombres, apellidos, rol y numero telefonico >>> Se redireccionará al formulario de Usuario solo si el Usuario que hace la consulta especifica es administrador.

- Compradores:

Se mostrarán todos los datos y al hacer clic en uno de ellos se enviará al formulario para poder modificar datos.


  

## DESARROLLO:BACK-END JAVA

SERVLETS:

Se crea un Servlet por cada Objeto, de la misma forma que un DAO.

DAOS:

Faltan los metodos de UPDATE






 

