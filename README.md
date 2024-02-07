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

FORMULARIO COMPRADOR (CUSTOMER)

  - Comprador / Customer:

   Debe tener un "subformulario" del objeto Direccion
  Todos los datos son obligatorios.

- Dirección / Address:
  
   Solo se puede crear en el momento en el que se crea un Comprador. <br>
  Todos los campos obligatorios.

  FORMULARIO ARTICULO (ITEM)
  
- Articulo / Item:

  Este objeto se crea sin el input MovimientosDeStock.
  
  FORMULARIO TIENDA (STORE)
  
- Tienda / Store:
  
  Se colocan los campos para crear la tienda y la direccion.

FORMULARIO DE FACTURA-DETALLESFACTURA-MOVIMIENTO ARTICULO

  - Factura / Envoice:
 
   El Codigo de factura (EnvoiceCode) Se genera automaticamente con una secuencia en la base de datos.
  Se genera automaticamente el mismo día que se ingresa.
   El comprador es el primer dato a comprobar que existe en la base de datos, si no existe debe alertar al usuario. <br>
   Los datos de usuario se añaden automaticamente consultando por debajo la información del usuario que haya iniciado sesión dentro del sistema.<br>
   La observación es una caja de texto opcional.

- DetallesFactura / Envoice Details:
  
  Se debe poder ingresar varios MovimientoDeArticulo(StockMov) como un listado, dentro del formulario.
  La fianza(fiance) es de ingreso manual
  
- MovimientoDeArticulo / StockMov:

 El usuario debe poder poner el nombre o el codigo del articulo en su respectivo input para consultar que si existe dicho articulo y en caso de que no, saltar una alarma que avise  de la inexistencia del mismo.
 El precio (por unidad) y las unidades debe ser de ingreso manual, con estos dos datos debe poder mostrarse un resultado total.
 La Tienda(Store) se ingresa de forma automatica dentro del servlet, se crea el campo con un valor bloquedao Tienda = 01. 


    
INTERFACES DE BUSQUEDA DE OBJETO / TABLAS DINÁMICAS

- Usuario:

Se mostrarán los nombres, apellidos, rol y numero telefonico >>> Se redireccionará al formulario de Usuario solo si el Usuario que hace la consulta especifica es administrador.

- Compradores:

Se mostrarán todos los datos y al hacer clic en uno de ellos se enviará al formulario para poder modificar datos.


  

## DESARROLLO:BACK-END JAVA

SERVLETS:

Se crea un Servlet por cada Objeto, de la misma forma que un DAO.



Se modifican los Address dentro de Customer, Supplier y Store con la etiqueta CascadeType.REFRESH

Faltan los metodos de UPDATE de Envoice y Receipt, se van a hacer con la etiqueta CascadeType.REFRESH en cadena pasando por Envoice/ReceiptDet y los StockMovs.

DAOS:
CREATE - CHECK
REMOVE - CHECK
UPDATE - Faltan Envoice y Receipt con Cascada hasta E/R-Details y StockMov.



Listos:
- Address
- Customer
- Supplier
- Store
- User
- Item





 

