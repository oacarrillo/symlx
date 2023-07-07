#language:es
@DEMO
Característica: Login/Logout

  @TC1
  Escenario: Login with valid credentials
    Dado que accede a la URL
    Y que no está logueado
    Cuando ingresa el correo electrónico "symphony@nttdata.com" en el campo 'Email'
    Y ingresa la contraseña "symphony@nttdata.com" en el campo 'Contraseña'
    Y hace clic en el botón 'Login'
    Entonces inicia sesión de manera exitosa siendo dirigido a la página de 'Inventory'

  @TC2
  Escenario: Logout flow
    Dado que accede a la URL
    Y que no está logueado
    Cuando ingresa el correo electrónico "symphony@nttdata.com" en el campo 'Email'
    Y ingresa la contraseña "symphony@nttdata.com" en el campo 'Contraseña'
    Y hace clic en el botón 'Login'
    Y hace clic en el ícono 'Profile' de la barra de navegación
    Y hace clic en la opción 'Logout'
    Entonces la sesión se cierra exitosamente

  @TC3
  Escenario: Session after successful login
    Dado que accede a la URL
    Y que no está logueado
    Cuando ingresa el correo electrónico "symphony@nttdata.com" en el campo 'Email'
    Y ingresa la contraseña "symphony@nttdata.com" en el campo 'Contraseña'
    Y hace clic en el botón 'Login'
    Y abre la URL en otra pestaña del mismo navegador
    Entonces es dirigido a la página de 'Inventory' después de haber iniciado sesión en otra pestaña

  @TC4
  Escenario: Session after successful logout
    Dado que accede a la URL
    Y que no está logueado
    Cuando ingresa el correo electrónico "symphony@nttdata.com" en el campo 'Email'
    Y ingresa la contraseña "symphony@nttdata.com" en el campo 'Contraseña'
    Y hace clic en el botón 'Login'
    Y abre la URL en otra pestaña del mismo navegador
    Y hace clic en el ícono 'Profile' de la barra de navegación
    Y hace clic en la opción 'Logout'
    Y va a la pestaña anterior
    Y actualiza la página
    Entonces es dirigido a la página de inicio de sesión

  @TC5
  Escenario: You have been logged out after successful log out on another tab
    Dado que accede a la URL
    Y que no está logueado
    Cuando ingresa el correo electrónico "symphony@nttdata.com" en el campo 'Email'
    Y ingresa la contraseña "symphony@nttdata.com" en el campo 'Contraseña'
    Y hace clic en el botón 'Login'
    Y abre la URL en otra pestaña del mismo navegador
    Y hace clic en el ícono 'Profile' de la barra de navegación
    Y hace clic en la opción 'Logout'
    Y va a la pestaña anterior
    Y hace clic en cualquier ícono de la barra de navegación
    Y hace clic en el botón 'Cancel' de la ventana de diálogo
    Y hace clic en cualquier ícono de la barra de navegación
    Y hace clic en el botón 'Reload Page' de la ventana de diálogo
    Entonces es dirigido a la página de inicio de sesión

  @TC6
  Escenario: UI on Login dialog
    Dado que accede a la URL
    Y que no está logueado
    Cuando pasa el cursor sobre el campo 'Email' y 'Password'
    Y pasa el cursor sobre el botón 'Login'
    Y hace clic en el campo 'Email' y 'Password'
    Y hace clic en la tecla 'Tab' del teclado
    Entonces el enfoque se moverá al siguiente campo o botón

  @TC9
  Escenario: Clicking browser back/forward button after successfully login/logout
    Dado que accede a la URL
    Y que no está logueado
    Cuando ingresa el correo electrónico "symphony@nttdata.com" en el campo 'Email'
    Y ingresa la contraseña "symphony@nttdata.com" en el campo 'Contraseña'
    Y hace clic en el botón 'Login'
    Y hace clic en el botón 'Back' del navegador
    Y actualiza la página
    Y hace clic en el ícono 'Profile' de la barra de navegación
    Y hace clic en la opción 'Logout'
    Y hace clic en el botón 'Back' del navegador
    Y actualiza la página
    Entonces navega correctamente a través de las páginas de 'Login' e 'Inventory'

  @TC10
  Escenario: Navigating to different tools using the Main menu
    Dado que accede a la URL
    Y está logueado
    Cuando abre la URL
    Y hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Workforce Management'
    Y hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Inventory Management'
    Entonces se realiza correctamente la navegación entre opciones del menú

  @TC11
  Escenario: Switching between 'Inventory Management' pages
    Dado que accede a la URL
    Y está logueado
    Cuando abre la URL
    Y hace clic en el ícono 'Map' de la barra de navegación
    Y hace clic en el ícono 'Catalog' de la barra de navegación
    Y hace clic en el ícono 'Configuration Management' de la barra de navegación
    Y hace clic en el ícono 'Action Execution' de la barra de navegación
    Y hace clic en el ícono 'Locations' de la barra de navegación
    Entonces navega correctamente entre las opciones de la barra de navegación de Inventory Management

  @TC12
  Escenario: Switching between 'Workforce Management' pages
    Dado que accede a la URL
    Y está logueado
    Cuando abre la URL
    Y hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Workforce Management'
    Y hace clic en el ícono 'Projects' de la barra de navegación
    Y hace clic en el ícono 'Templates' de la barra de navegación
    Y hace clic en el ícono 'Work Orders' de la barra de navegación
    Entonces navega correctamente entre las opciones de la barra de navegación de Workforce Management

  @TC13
  Escenario: Navigating to 'Administrative Tool' (Only for 'Admin' user)
    Dado que accede a la URL
    Y está logueado
    Cuando abre la URL
    Y hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Entonces ingresa correctamente a la opción 'Administrative Tools'

  @TC14
  Escenario: Collapse/Expand button on navbar
    Dado que accede a la URL
    Y está logueado
    Cuando abre la URL
    Y pasa el cursor sobre la barra de navegación o la barra 'Locations' mientras está en la página 'Inventory'
    Y quita el cursor de la barra de navegación o de la barra 'Locations' mientras está en la página 'Inventory'
    Entonces se muestra y oculta correctamente el botón Expandir-Contraer en la sección de 'Locations'

  @TC15
  Escenario: Expand/Collapse 'Locations' bar on 'Inventory' Page
    Dado que accede a la URL
    Y está logueado
    Cuando abre la URL
    Y pasa el cursor sobre la barra de navegación o la barra 'Locations' mientras está en la página 'Inventory'
    Y hace clic en el botón Contraer de la barra de navegación
    Y hace clic en el botón Expandir de la barra de navegación
    Entonces se contrae y expande correctamente la sección de Locations

  @TC17
  Escenario: UI of navbar
    Dado  que accede a la URL
    Y está logueado
    Cuando hace clic en cualquier ícono de la barra de navegación
    Y pasa el cursor sobre cualquier ícono de la barra de navegación
    Y pasa el cursor sobre el ícono 'Profile' de la barra de navegación
    Y pasa el cursor sobre el ícono 'Grid' de la barra de navegación
    Entonces los íconos de 'Profile' y 'Grid' cambian a color azul

  @TC19
  Escenario: Hiding the error snack bar
    Dado  que accede a la URL
    Y está logueado
    Cuando deshabilita la conexión a Internet
    Y hace clic en cualquier ícono de la barra de navegación de 'Locations'
    Y hace clic en el botón 'X' de la snack bar
    Entonces se oculta la snack bar

  @TC42
  Escenario: Adding Location Type
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Catalog' de la barra de navegación
    Y hace clic en la pestaña 'LOCATIONS'
    Y hace clic en el botón 'Add Location Type'
    Y introduce detalles válidos en el formulario 'New Location Type'
    Y hace clic en el botón 'Save'
    Entonces agrega exitosamente un nuevo tipo de ubicación

  @TC43
  Escenario: Editing Location Type
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Catalog' de la barra de navegación
    Y hace clic en la pestaña 'LOCATIONS'
    Y hace clic en el ícono 'Edit' de cualquier tipo
    Y actualiza el valor de cualquier campo en el formulario 'Edit Location Type'
    Y hace clic en el botón 'Save'
    Entonces edita exitosamente un tipo de ubicación

  @TC44
  Escenario: Deleting Location Type
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Catalog' de la barra de navegación
    Y hace clic en la pestaña 'LOCATIONS'
    Y hace clic en el ícono 'Delete' de cualquier tipo
    Y hace clic en el botón 'Confirm' del cuadro de diálogo de confirmación
    Entonces elimina satisfactoriamente un tipo de ubicación

  @TC78
  Escenario: UI of 'Select a location type' dialog
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en el botón '+' junto a 'Add top-level locations' de la barra 'Locations'
    Y hace clic en cualquier pestaña del cuadro de diálogo
    Y hace clic en la pestaña 'LOCATIONS' del cuadro de diálogo
    Y pasa el cursor sobre el botón 'Cancel' del cuadro de diálogo
    Y pasa el cursor sobre cualquier nombre de tipo de ubicación
    Y hace clic en cualquier tipo de ubicación
    Entonces el cuadro de diálogo 'Select Location Type' funciona correctamente

  @TC79
  Escenario: UI of new location form
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en el botón '+' junto a 'Add top-level locations' de la barra 'Locations'
    Y hace clic en cualquier tipo de ubicación
    Y hace clic en el botón 'Add'
    Y ingresa cualquier carácter en el campo 'Name*'
    Y pasa el cursor sobre el campo de entrada de texto o desplegable de cualquier selección
    Y va a la sección de propiedades
    Y introduce o selecciona un valor en un campo obligatorio
    Entonces se visualizan los campos obligatorios con el borde en color negro y el mensaje 'Name cannot be empty' ya no se visualiza

  @TC80
  Escenario: UI of edit location form
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando edita el formulario
    Y pasa el cursor sobre cualquier campo de entrada de texto o desplegable de cualquier sección
    Y limpia el valor de cualquier campo obligatorio
    Y introduce el valor en cualquier campo obligatorio que haya borrado anteriormente
    Entonces se visualiza el campo obligatorio con el borde en color negro y el mensaje 'Name cannot be empty' ya no se visualiza

  @TC81
  Escenario: Cancel'/'Save' button on new/edit location form
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en el botón '+' junto a 'Add top-level locations' de la barra 'Locations'
    Y hace clic en cualquier tipo de ubicación
    Y hace clic en el botón 'Add'
    Y se asegura que el campo obligatorio 'Name*' está vacío
    Y introduce un valor válido en los campos 'Lat.' y 'Long.' por defecto o coordenadas tipo propiedad
    Y introduce detalles válidos en todos los campos obligatorios
    Y pasa el cursor sobre el botón 'Cancel' del formulario de Locations
    Entonces el botón 'Save' aparece deshabilitado si un campo obligatorio tiene el mensaje 'Name cannot be empty'

  @TC82
  Escenario: UI of 'Add a new URL' dialog while adding a link to 'Documents'
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en una ubicación
    Y hace clic en la pestaña 'DOCUMENTS'
    Y hace clic en el botón 'Add URL'
    Y pasa el cursor sobre cualquier campo de entrada de texto del cuadro de diálogo
    Y introduce una URL válida en el campo 'URL*'
    Y pasa el cursor sobre el botón 'Cancel' del cuadro de diálogo 'Add a new URL'
    Entonces el texto del botón 'Cancel' cambia a color azul

  @TC83
  Escenario: UI of the header on the Location page
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en una ubicación
    Y verifica la presencia del encabezado, los botones y las pestañas de la página
    Y hace clic en una ubicación dentro de la ubicación principal seleccionada
    Y verifica que en la cabecera aparezcan la ubicación principal y la ubicación hija separadas por un Slash
    Y verifica que en la cabecera aparezcan el nombre de la ubicación principal en color gris claro y la ubicación hija en color negro
    Y pasa el cursor sobre el ícono '...' de la cabecera
    Y pasa el cursor sobre el botón 'Edit Location'
    Y selecciona cualquier pestaña de la cabecera
    Entonces se visualiza la pestaña seleccionada resaltada en color azul

  @TC85
  Escenario: UI of 'DOCUMENTS' tab on the location page
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en la ubicación definida
    Y hace clic en la pestaña 'DOCUMENTS'
    Y pasa el cursor sobre el botón 'Add URL'
    Y pasa el cursor sobre el botón 'Upload File'
    Y verifica que la fila de URL contiene el ícono 'Link', el nombre, fecha y hora de cargue
    Y verifica que la fila de Uploaded File contiene una imagen miniatura, el ícono 'Doc', el nombre del archivo con tipo de archivo, fecha y hora de cargue
    Y pasa el cursor sobre el ícono 'Menú'
    Entonces el color del ícono 'Menú' cambia a gris claro


  @TC87
  Escenario: UI of 'WORK ORDERS' tab on the location page
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en una ubicación
    Y hace clic en la pestaña 'WORK ORDERS'
    Y pasa el cursor sobre la columna 'Name'
    Y hace clic en el botón flecha arriba
    Y hace clic en el botón flecha abajo
    Y pasa el cursor sobre la columna 'Project'
    Y va a los botones '<' y '>' en la parte inferior derecha de la tabla
    Entonces los botones '<' y '>' estarán deshabilitados si no hay más ordenes para mostrar

  @TC112
  Escenario: Search location using search bar
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Map' de la barra de navegación
    Y escribe el nombre de una ubicación en el cuadro de búsqueda
    Y selecciona cualquier ubicación de la sugerencia
    Entonces se hace zoom al mapa automáticamente y se visualiza la ubicación seleccionada

  @TC113
  Escenario: UI of Layers bar
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en el ícono 'Map' de la barra de navegación
    Y desmarca cualquier casilla de la barra de Layers
    Entonces el chulo y el color azul son removidos de la casilla y el color del borde de la casilla se cambia a gris

  @TC114
  Escenario: UI of the location box
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en el ícono 'Map' de la barra de navegación
    Y hace clic en cualquier nodo de instancia del mapa
    Y pasa el cursor sobre cualquier instancia de ruta del cuadro de ubicación
    Y hace clic en el ícono '...' si la ruta es muy larga
    Y pasa el cursor sobre cualquier ubicación del cuadro de la ruta expandida
    Y hace clic en el botón 'X' ubicado en la parte superior derecha del cuadro de ubicación
    Entonces se cierra el cuadro de ubicación

  @TC117
  Escenario: Uncheck layers and refresh the page
    Dado que accede a la URL
    Y está logueado
    Y hay tipos de ubicaciones
    Cuando hace clic en el ícono 'Map' de la barra de navegación
    Y desmarca algunas casillas de la barra de Layers
    Y actualiza la página
    Entonces se muestran todas las casillas de la barra de Layers marcadas

  @TC118
  Escenario: Switch to 'Satellite' view and refresh the page
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Map' de la barra de navegación
    Y hace clic en el botón 'Satellite'
    Y actualiza la página
    Entonces se cambia la vista del mapa de 'Satellite' a 'Map'

  @TC227
  Escenario: Creating a work order template
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Templates' de la barra de navegación
    Y hace clic en 'Work Orders' del menú Templates
    Y hace clic en el botón 'Create Work Order Template'
    Y escribe el título de la plantilla en el campo 'Title*'
    Y escribe el nombre de la plantilla en el campo 'Name'
    Y hace clic en el botón 'Save'
    Entonces se crea una nueva plantilla en la tabla de ordenes de trabajo

  @TC228
  Escenario: Editing work order template
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Templates' de la barra de navegación
    Y hace clic en 'Work Orders' del menú Templates
    Y hace clic en cualquier plantilla de la tabla de ordenes de trabajo
    Y actualiza el valor de cualquier campo en la plantilla de orden de servicio
    Y hace clic en el botón 'Save'
    Entonces se actualizan los cambios en la tabla de ordenes de trabajo

  @TC229
  Escenario: Deleting work order template
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Templates' de la barra de navegación
    Y hace clic en 'Work Orders' del menú Templates
    Y hace clic en cualquier nombre de plantilla que no tenga ninguna instancia
    Y hace clic en el ícono 'Delete'
    Y hace clic en el botón 'Confirm'
    Entonces la plantilla eliminada es removida de la tabla de ordenes de trabajo

  @TC231
  Escenario: Editing project template
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Templates' de la barra de navegación
    Y hace clic en 'Projects' del menú Templates
    Y hace clic en el botón 'Edit' de cualquier plantilla de proyecto
    Y actualiza el valor de cualquier campo en la plantilla de proyecto
    Y hace clic en el botón 'Save'
    Entonces se actualizan los cambios realizados a la plantilla de proyecto

  @TC232
  Escenario: Deleting project template
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Templates' de la barra de navegación
    Y hace clic en 'Projects' del menú Templates
    Y hace clic en el ícono 'Delete' de cualquier plantilla de proyecto
    Y hace clic en el botón 'Delete' del cuadro de diálogo
    Entonces la plantilla es removida de las plantillas de proyecto

  @TC249
  Escenario: Editing work order
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Work Orders' de la barra de navegación
    Y hace clic en cualquier nombre de la lista de ordenes de trabajo
    Y ingresa un nuevo correo en el campo 'Owner'
    Y ingresa un nuevo correo en el campo 'Assignee'
    Y escribe un comentario en el campo 'Activity & Comments'
    Y hace clic en el ícono de subir archivo en la sección de anexos
    Y selecciona un archivo válido en la ventana emergente y hace clic en 'Abrir'
    Y hace clic en el botón 'Save'
    Entonces se muestran los detalles actualizados de la instancia en la tabla de work orders

  @TC250
  Escenario: Deleting work order
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Work Orders' de la barra de navegación
    Y hace clic en cualquier nombre de la lista de ordenes de trabajo
    Y hace clic en el ícono 'Delete' de la cabecera
    Y hace clic en el botón 'Delete' del cuadro de diálogo
    Entonces la orden de trabajo es removida de la tabla

  @TC251
  Escenario: Filtering work order
    Dado que accede a la URL
    Y está logueado
    Y está en el módulo de 'Workforce Management'
    Cuando hace clic en el ícono 'Work Orders' de la barra de navegación
    Y hace clic en el botón 'X' del filtro de estado predeterminado
    Y hace clic en la barra de filtro
    Y hace clic en 'Status' de la lista desplegable del menú de filtro
    Y hace clic en el campo de entrada
    Y hace clic en cualquier opción del campo de entrada del filtro seleccionado
    Y presiona la tecla 'TAB'
    Y presiona la tecla 'TAB'
    Y hace clic en el botón 'X' del filtro aplicado en la barra de filtro
    Entonces se volverán a mostrar todas las ordenes de trabajo

  @TC336
  Escenario: Adding new user
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Users and Roles' del menú User Management
    Y hace clic en el botón 'Add User'
    Y introduce detalles válidos en el formulario New user account
    Y hace clic en el botón 'Save'
    Entonces el usuario es agregado exitosamente a la lista

  @TC337
  Escenario: Updating existing user profile
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Users and Roles' del menú User Management
    Y hace clic en cualquier usuario
    Y modifica detalles válidos del formulario
    Y hace clic en el botón 'Apply'
    Entonces se guarda el formulario con las modificaciones realizadas

  @TC352
  Escenario: Creating new group
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Permission groups' del menú User Management
    Y hace clic en el botón 'Create a group'
    Y introduce detalles válidos en el formulario 'New group'
    Y hace clic en el botón 'Save'
    Entonces se crea exitosamente un nuevo permiso de grupo

  @TC353
  Escenario: Updating existing group
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Permission groups' del menú User Management
    Y hace clic en cualquier nombre de grupo
    Y actualiza cualquier sección con detalles válidos
    Y hace clic en el botón 'Save'
    Entonces se actualizan los cambios del grupo satisfactoriamente

  @TC354
  Escenario: Deleting existing group
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Permission groups' del menú User Management
    Y hace clic en cualquier nombre de grupo
    Y hace clic en el ícono 'Delete' de la cabecera
    Y hace clic en el botón 'Confirm' del cuadro de diálogo de confirmación
    Entonces el grupo es removido de la tabla

  @TC369
  Escenario: Creating a new inventory policy
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Policies' del menú User Management
    Y hace clic en el botón 'Create a policy'
    Y hace clic en cualquier opción del campo desplegable 'Policy Type'
    Y introduce detalles válidos en el formulario 'New policy'
    Y hace clic en el botón 'Save'
    Entonces se crea exitosamente una nueva política

  @TC370
  Escenario: Updating existing inventory policy
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Policies' del menú User Management
    Y hace clic en cualquier política
    Y actualiza cualquier sección con detalles válidos
    Y hace clic en el botón 'Save'
    Entonces se actualizan los cambios de la política satisfactoriamente

  @TC371
  Escenario: Deleting existing policy
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Administrative Tools'
    Y hace clic en 'Policies' del menú User Management
    Y hace clic en cualquier política
    Y hace clic en el ícono 'Delete' de la cabecera
    Y hace clic en el botón 'Confirm' del cuadro de diálogo de confirmación
    Entonces la política es removida de la tabla


  @TC772
  Escenario: Display the workflow log
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Automation Management'
    Y hace clic en el ícono 'Operation' de la barra de navegación
    Y hace clic en cualquier ID Instance
    Entonces se muestra la interfaz de ejecución del flujo y el Workflow Log

  @TC773
  Escenario: Show the details of the flow instance
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Automation Management'
    Y hace clic en el ícono 'Operation' de la barra de navegación
    Y hace clic en cualquier ID Instance
    Y hace clic en el botón de Detalles de la Instancia
    Entonces se muestran los detalles de la instancia

  @TC774
  Escenario: enter the flow editing interface
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Automation Management'
    Y hace clic en el ícono 'Operation' de la barra de navegación
    Y hace clic en cualquier ID Instance
    Y hace clic en el botón 'Edit Flow'
    Entonces ingresa a la interfaz de edición del flujo

  @TC775
  Escenario: Flow visualization UI
    Dado que accede a la URL
    Y está logueado
    Cuando hace clic en el ícono 'Grid' de la barra de navegación
    Y hace clic en la opción 'Automation Management'
    Y hace clic en el ícono 'Operation' de la barra de navegación
    Y hace clic en cualquier ID Instance
    Entonces la interfaz de usuario del flujo interactúa correctamente