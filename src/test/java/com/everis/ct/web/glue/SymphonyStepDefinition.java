package com.everis.ct.web.glue;

import com.everis.ct.web.WebAutomationApplication;
import com.everis.ct.web.lib.WebDriverManager;
import com.everis.ct.web.step.SymphonySearchStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

@CucumberContextConfiguration
@SpringBootTest(classes = WebAutomationApplication.class)
public class SymphonyStepDefinition {
    @Value("${url.symphony}")
    private String urlSymphony;
    @Value("${url.settings}")
    private String urlSymphonySettings;
    @Autowired
    private WebDriverManager manager;
    @Autowired
    private SymphonySearchStep searchStep;
    public String mainTab;
    public int pos;
    public Keys tab = Keys.TAB;
    public Keys control = Keys.CONTROL;
    public Keys alt = Keys.ALT;
    public Keys delete = Keys.DELETE;
    public Keys avPag = Keys.PAGE_DOWN;
    public Keys rePag = Keys.PAGE_UP;

    @Given("que accede a la URL")
    public void queAccedeALaURL(){
        manager.navigateTo(urlSymphony);
    }
    @And("que no está logueado")
    public void queNoEstaLogueado(){
        searchStep.pageLocation("Connectivity Platform", "//input[@name='email']", "xPath",WebDriverManager.getDriver().getCurrentUrl(), urlSymphony + "user/login?to=%2F");
    }
    @When("ingresa el correo electrónico {string} en el campo 'Email'")
    public void ingresaUnCorreoElectronicoDeUsuarioValidoEnElCampo(String usuario) {
        searchStep.writeData(usuario, "//input[@name='email']", "xPath");
    }
    @And("ingresa la contraseña {string} en el campo 'Contraseña'")
    public void ingresaUnPasswordDeUsuarioValidoEnElCampo(String usuario) {
        searchStep.writeData(usuario, "//input[@name='password']", "xPath");
    }
    @And("hace clic en el botón 'Login'")
    public void haceClicEnElBotonLogin() {
        searchStep.sendClick("//button[@type='button']", "xPath");
    }
    @Then("inicia sesión de manera exitosa siendo dirigido a la página de 'Inventory'")
    public void iniciaSesion() {
        searchStep.pageLocation("Connectivity Platform", "//button[@type='button']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory");
    }
    @And("hace clic en el ícono 'Profile' de la barra de navegación")
    public void haceClicEnElIconoProfileDeLaBarraDeNavegacion() {
        searchStep.sendClick("//div[@class='jss17']", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='navigation-menu']/div[3]/nav", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory");
    }
    @And("hace clic en la opción 'Logout'")
    public void haceClicEnLogout() {
        searchStep.sendClick("//a[@href='/user/logout']", "xPath");
    }
    @Then("la sesión se cierra exitosamente")
    public void cierraSesion() {
        searchStep.pageLocation("Connectivity Platform", "//input[@name='email']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "user/login?to=%2F");
    }
    @Given("abre la URL en otra pestaña del mismo navegador")
    public void queAccedeALaURLEnOtraPestana(){
        //WebDriverManager.getDriver().getWindowHandle();
        //WebDriverManager.getDriver().manage().window();
        //WebDriverManager.getDriver().navigate().to("https://google.com");
        //WebDriverManager.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+ "t");     //otra forma de abrir una tab
        mainTab = WebDriverManager.getDriver().getWindowHandle();
        searchStep.newTab(urlSymphony);
    }
    @Then("es dirigido a la página de 'Inventory' después de haber iniciado sesión en otra pestaña")
    public void esDirigidoALaPaginaDeInventory() {
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Location']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory");
    }
    @And("va a la pestaña anterior")
    public void vaALaPestanaAnterior() {
        searchStep.selectTab(mainTab);
    }
    @And("actualiza la página")
    public void actualizaLaPagina(){
        searchStep.refreshTab();
        searchStep.needTime(10000);
    }
    @Then("es dirigido a la página de inicio de sesión")
    public void esDirigidoALaPaginaDeInicioDeSesion() {
        searchStep.pageLocation("Connectivity Platform", "//input[@name='email']", "xPath",WebDriverManager.getDriver().getCurrentUrl(), urlSymphony + "user/login?to=%2Finventory%2Finventory");
    }
    @And("hace clic en cualquier ícono de la barra de navegación")
    public void haceClicEnCualquierIconoDeLaBarraDeNavegacion() {
        searchStep.sendClick("//div[@class='jss11']", "xPath");
    }
    @And("hace clic en el botón 'Cancel' de la ventana de diálogo")
    public void haceClicEnElBotonCancelDeLaVentanaDeDialogo() {
        searchStep.sendClick("//button[@type='button'][1]", "xPath");
    }
    @And("hace clic en el botón 'Reload Page' de la ventana de diálogo")
    public void haceClicEnElBotonRealoadPageDeLaVentanaDeDialogo() {
        searchStep.sendClick("//button[@type='button'][2]", "xPath");
    }
    @When("pasa el cursor sobre el campo 'Email' y 'Password'")
    public void pasaElCursorSobreElCampoEmailPassword() {
        searchStep.actionHover("//div[@class='MuiFormControl-root MuiTextField-root jss2']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiInput-underline:hover:not(.Mui-disabled)'),'::before').getPropertyValue('border-bottom-width')", "2px");
        searchStep.actionHover("//div[@class='MuiFormControl-root MuiTextField-root jss2'][2]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiInput-underline:hover:not(.Mui-disabled)'),'::before').getPropertyValue('border-bottom-width')", "2px");
    }
    @And("pasa el cursor sobre el botón 'Login'")
    public void pasaElCursorSobreElBotonLogin() {
        searchStep.actionHover("//button[@type='button']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss45.jss37:hover:not(.jss44)'),'::before').getPropertyValue('background-color')","rgba(0, 0, 0, 0)");
    }
    @And("hace clic en el campo 'Email' y 'Password'")
    public void haceClicEnElCampoEmailPassword() {
        //Actions action = new Actions(WebDriverManager.getDriver());
        //action.release().build().perform();
        searchStep.sendClick("//input[@name='email']", "xPath");
        searchStep.sendClick("//input[@name='password']", "xPath");
    }
    @And("hace clic en la tecla 'Tab' del teclado")
    public void haceClicEnLaTeclaTabDelTeclado() {
        searchStep.sendKeyboard(tab, "//input[@name='password']", "xPath");
    }
    @Then("el enfoque se moverá al siguiente campo o botón")
    public void elEnfoqueSeMoveraAlSiguienteCampoOBoton() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss30:focus'),'::before').getPropertyValue('outline-style')","none");
    }
    @And("hace clic en el botón 'Back' del navegador")
    public void haceClicEnElBotonBackDelNavegador() {
        searchStep.back();
    }
    @Then("navega correctamente a través de las páginas de 'Login' e 'Inventory'")
    public void navegaCorrectamenteATravesDeLasPaginasDeLoginInventory() {
        searchStep.pageLocation("Connectivity Platform", "//input[@name='email']", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,83),urlSymphony + "user/login?to=%2Finventory%2Finventory");
                                                                                                                                    //https://symphony.coe.telecomopennetworks.com/user/login?to=%2Finventory%2Finventory
    }
    @And("está logueado")
    public void estaLogueado() {
        searchStep.writeData("symphony@nttdata.com", "//input[@name='email']", "xPath");
        searchStep.writeData("symphony@nttdata.com", "//input[@name='password']", "xPath");
        searchStep.sendClick("//button[@type='button']", "xPath");
    }
    @When("abre la URL")
    public void abreLaURL(){
        manager.navigateTo(urlSymphony);
    }
    @And("hace clic en el ícono 'Grid' de la barra de navegación")
    public void haceClicEnElIconoGridDeLaBarraDeNavegacion() {
        //searchStep.sendClick(WebDriverManager.getDriver().findElement(By.xpath("//div[@class='jss247'] | //div[@class='jss34']")));
        //searchStep.sendClick("//div[@class='jss247' or @class='jss34']", "xPath");
        searchStep.sendClick("(//div[@class='jss23' or @class='jss235'])[2]", "xPath");
        searchStep.elementPresence("//*[@id='navigation-menu']/div[3]/div", "xPath", true);
    }
    @And("hace clic en la opción 'Workforce Management'")
    public void haceClicEnLAOpcionWorkforceManagement() {
        //searchStep.sendClick(WebDriverManager.getDriver().findElement(By.xpath("//*[@id='navigation-menu']/div[3]/div/div[2]/span")));
        searchStep.sendClick("//*[text()='Workforce Management']", "xPath");
    }
    @And("hace clic en la opción 'Inventory Management'")
    public void haceClicEnLaOpcionInventoryManagement() {
        //searchStep.sendClick(WebDriverManager.getDriver().findElement(By.xpath("//*[@id='navigation-menu']/div[3]/div/div[1]/span")));
        searchStep.sendClick("//*[@id='navigation-menu']/div[3]/div/div[1]", "xPath");
    }
    @Then("se realiza correctamente la navegación entre opciones del menú")
    public void seRealizaCorrectamenteLANavegacionEntreOpcionesDelMenu() {
        searchStep.pageLocation("Connectivity Platform", "//span[@class='jss131 jss137 jss115'] | //span[@class='jss540 jss546 jss115'] | //*[@id='root']/div/main/div[2]/div[1]/div/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,64),urlSymphony + "inventory/inventory");
    }
    @And("hace clic en el ícono 'Map' de la barra de navegación")
    public void haceClicEnElIconoMapDeLaBarraDeNavegacion() {
        searchStep.sendClick("(//div[@class='jss11'])[2] | (//canvas[@aria-label='Map'])[1]", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//canvas[@class='mapboxgl-canvas'] | //span[@class='jss153 jss164 jss146']", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,58),urlSymphony + "inventory/map");
    }
    @And("hace clic en el ícono 'Catalog' de la barra de navegación")
    public void haceClicEnElIconoCatalogDeLaBarraDeNavegacion() {
        searchStep.sendClick("//a[@href='/inventory/configure']", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[2]/div[1]/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory/configure/equipment_types");
    }
    @And("hace clic en el ícono 'Configuration Management' de la barra de navegación")
    public void haceClicEnElIconoConfigurationManagementDeLaBarraDeNavegacion() {
        searchStep.sendClick("//*[@id='root']/div/div/div[1]/a[4]/div", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[2]/div[1]/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,99),urlSymphony + "inventory/configuration_management/configurations_view");
    }
    @And("hace clic en el ícono 'Action Execution' de la barra de navegación")
    public void haceClicEnElIconoActionExecutionDeLaBarraDeNavegacion() {
        searchStep.sendClick("//*[@id='root']/div/div/div[1]/a[5]/div", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[2]/div[1]/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,99),urlSymphony + "inventory/action_execution/scheduled_actions_types");
    }
    @And("hace clic en el ícono 'Locations' de la barra de navegación")
    public void haceClicEnElIconoLocationsDeLaBarraDeNavegacion() {
        searchStep.sendClick("//*[@id='root']/div/div/div[1]/a[1]/div", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div[2]/div[1]/div/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,64),urlSymphony + "inventory/inventory");
    }
    @Then("navega correctamente entre las opciones de la barra de navegación de Inventory Management")
    public void navegaCorrectamenteEntreLasOpcionesDeLaBarraDeNavegacionDeInventoryManagement() {
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div[2]/div[1]/div/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,64),urlSymphony + "inventory/inventory");
    }
    @And("hace clic en el ícono 'Projects' de la barra de navegación")
    public void haceClicEnElIconoProjectsDeLaBarraDeNavegacion() {
        searchStep.sendClick("//*[@id='root']/div/div/div[1]/a[2]/div", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[1]/div[1]/span", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,71),urlSymphony + "workorders/projects/search");
    }
    @And("hace clic en el ícono 'Templates' de la barra de navegación")
    public void haceClicEnElIconoTemplatesDeLaBarraDeNavegacion() {
        //sandbox//searchStep.sendClick("//*[@id='root']/div/div/div[1]/a[3]/div", "xPath");
        searchStep.sendClick("//div[@id='root']/div/div/div/a[3]/div", "xPath");
        //sandbox//searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div/div[1]/span/span", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,79),urlSymphony + "workorders/configure/project_types");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div/div[1]/span/span", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "workorders/configure/project_types");
        searchStep.elementPresence("//span[text()='Project Templates'] | //span[text()='Modelos de Projeto']","xPath",true);
    }
    @And("hace clic en el ícono 'Work Orders' de la barra de navegación")
    public void haceClicEnElIconoWorkOrdersDeLaBarraDeNavegacion() {
        searchStep.sendClick("//*[@id='root']/div/div/div[1]/a[1]/div", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[1]/div[1]/span", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "workorders/search");
    }
    @Then("navega correctamente entre las opciones de la barra de navegación de Workforce Management")
    public void navegaCorrectamenteEntreLasOpcionesDeLaBarraDeNavegacionDeWorkforceManagement() {
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[1]/div[1]/span", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,62),urlSymphony + "workorders/search");
    }
    @And("hace clic en la opción 'Administrative Tools'")
    public void haceClicEnLaOpcionAdministrativeTools() {
        searchStep.sendClick("//span[text()='Administrative Tools']", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//span[text()='User Management'] | (//span[@class='jss270 jss276 jss284 jss257'])[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin");
    }
    @And("ingresa correctamente a la opción 'Administrative Tools'")
    public void ingresaCorrectamenteALaOpcionAdministrativeTools() {
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[2]/div[1]/div[2]/div/div", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,50),urlSymphony + "admin");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[2]/div[1]/div[2]/div/div", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,76),urlSymphony + "admin/user_management/users/all");
    }
    @And("pasa el cursor sobre la barra de navegación o la barra 'Locations' mientras está en la página 'Inventory'")
    public void pasaElCursorSobreLaBarraDeNavegacionOLaBarraLocationsMientrasEstaEnLaPaginaInventory() {
        searchStep.actionHover("//div[@class='jss6']", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//div[@class='jss7']", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,64),urlSymphony + "inventory/inventory");
    }
    @And("quita el cursor de la barra de navegación o de la barra 'Locations' mientras está en la página 'Inventory'")
    public void quitaElCursorDeLaBarraDeNavegacionOLaBarraLocationsMientrasEstaEnLaPaginaInventory() {
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]", "xPath");
    }
    @Then("se muestra y oculta correctamente el botón Expandir-Contraer en la sección de 'Locations'")
    public void seMuestraYOcultaCorrectamenteElBotonExpandirContraerEnLaSeccionDeLocations() {
        searchStep.pageLocation("Connectivity Platform", "//div[@class='jss6']", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0,64),urlSymphony + "inventory/inventory");
    }
    @And("hace clic en el botón Contraer de la barra de navegación")
    public void haceClicEnElBotonContraerDeLaBarraDeNavegacion(){
        searchStep.sendClick("//div[@class='jss6']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.ps--active-x')).getPropertyValue('overflow')","hidden");
    }
    @And("hace clic en el botón Expandir de la barra de navegación")
    public void haceClicEnElBotonExpandirDeLaBarraDeNavegacion(){
        searchStep.sendClick("//div[@class='jss6']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.ps')).getPropertyValue('overflow')","hidden");
    }
    @Then("se contrae y expande correctamente la sección de Locations")
    public void seContraeYExpandeCorrectamenteLaSeccionDeLocations(){
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div[2]/div[1]/div/div[1]/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl().substring(0, 64),urlSymphony + "inventory/inventory");
    }
    @And("pasa el cursor sobre cualquier ícono de la barra de navegación")
    public void pasaElCursorSobreCualquierIconoDeLaBarraDeNavegacion() {
        searchStep.actionHover("//*[@id='root']/div/div/div[1]/a[1]/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss11:hover .jss9'),'.jss11.jss12.jss9').getPropertyValue('color')","rgb(255, 255, 255)");
    }
    @And("pasa el cursor sobre el ícono 'Profile' de la barra de navegación")
    public void pasaElCursorSobreElIconoProfileDeLaBarraDeNavegacion() {
        searchStep.actionHover("//div[@class='jss17']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss17:hover .jss19'),'.jss17.jss18.jss19').getPropertyValue('fill')","rgb(57, 132, 255)");
    }
    @And("pasa el cursor sobre el ícono 'Grid' de la barra de navegación")
    public void pasaElCursorSobreElIconoGridDeLaBarraDeNavegacion() {
        searchStep.actionHover("//div[@class='jss34']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss34:hover')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @Then("los íconos de 'Profile' y 'Grid' cambian a color azul")
    public void losIconosDeProfileYGridCambianAColorAzul() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss34:hover')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @And("deshabilita la conexión a Internet")
    public void deshabilitaLaConexionAInternet() {
        //System.out.println("Deshabilite la conexión a Internet, tiene 60 segundos para hacerlo");
        //searchStep.needTime(10000);
        searchStep.setProxy("10.10.10.10", 8080);

       }





    @And("hace clic en cualquier ícono de la barra de navegación de 'Locations'")
    public void haceClicEnCualquierIconoDeLaBarraDeNavegacionDeLocations() {
        //Random random = new Random(4);
        //int numAleatorio = random.nextInt(4);
        searchStep.sendClick("//a[@href='/inventory/map'] | (//a[@href='/inventory/map'])[1]", "xPath");
        searchStep.sendClick("//a[@href='/inventory/inventory']", "xPath");
        searchStep.elementPresence("//span[text()='Sorry, something went wrong']", "xPath", true);
    }
    @And("hace clic en el botón 'X' de la snack bar")
    public void haceClicEnElBotonXDeLaSnackBar() {
        searchStep.sendClick("(//*[name()='path'])[10]", "xPath");
    }
    @Then("se oculta la snack bar")
    public void seOcultaLaSnackBar() {
        searchStep.elementPresence("//span[text()='Sorry, something went wrong']", "xPath", false);
    }
    @And("hace clic en la pestaña 'LOCATIONS'")
    public void haceClicEnLaPestanaLocations() {
        searchStep.sendClick("//span[text()='LOCATIONS'] | //span[text()='LOCALIZAÇÕES']", "xPath");
        //searchStep.needTime(600000);
        searchStep.pageLocation("Connectivity Platform","//*[@id='root']/div/main/div/div[1]/div[2]/span | //span[text()='LOCATIONS'] | //span[text()='LOCALIZAÇÕES']", "xPath", WebDriverManager.getDriver().getCurrentUrl(), urlSymphony + "inventory/configure/location_types");
    }
    @And("hace clic en el botón 'Add Location Type'")
    public void haceClicEnElBotonAddLocationType() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div[2]/div[1]/div[2]/div/span", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//*[@id='root']/div/main/div/div[2]/div[1]/div[1]/div[1]/span", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory/configure/location_types");
    }
    @And("introduce detalles válidos en el formulario 'New Location Type'")
    public void introduceDetallesValidosEnElFormularioNewLocationType() {
        searchStep.writeData("Prueba_Automation", "//input[@type='string']", "xPath");
    }
    @And("hace clic en el botón 'Save'")
    public void haceClicEnElBotonSave() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div[2]/div[2]/div[3] | //span[text()='Save'] | (//span[normalize-space()='Salvar'])[1]", "xPath");
        searchStep.elementPresence("//*[@id='root']/div/main/div/div[2]/div[1]/div[1]/span | //span[text()='Permission groups']", "xPath", true);
    }
    @Then("agrega exitosamente un nuevo tipo de ubicación")
    public void agregaExitosamenteUnNuevoTipoDeUbicacion() {
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Prueba_Automation']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory/configure/location_types");
    }
    @And("hace clic en el ícono 'Edit' de cualquier tipo")
    public void haceClicEnElIconoEditDeCualquierTipo() {
        //int cuenta = searchStep.findLast(1, "//*[@id='root']/div/main/div/div[2]/div[2]/div/div[", "]/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div[2]/span");
        //searchStep.sendClick("//*[@id='root']/div/main/div/div[2]/div[2]/div/div[" + cuenta + "]/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div[2]/span", "xPath");
        searchStep.sendClick("//span[text()='Prueba_Automation']//parent::div//parent::div//parent::div//descendant::span[4]", "xPath");
    }
    @And("actualiza el valor de cualquier campo en el formulario 'Edit Location Type'")
    public void actualizaElValorDeCualquierCampoEnElFormularioEditLocationType() {
        searchStep.writeData("_Editado_Por_El_Robot", "//input[@type='string']", "xPath");
    }
    @Then("edita exitosamente un tipo de ubicación")
    public void editaExitosamenteUnTipoDeUbicacion() {
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Prueba_Automation_Editado_Por_El_Robot']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory/configure/location_types");
    }
    @And("hace clic en el ícono 'Delete' de cualquier tipo")
    public void haceClicEnElIconoDeleteDeCualquierTipo() {
        int cuenta = searchStep.findLast(1, "//*[@id='root']/div/main/div/div[2]/div[2]/div/div[", "]/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div[1]");
        searchStep.sendClick("//*[@id='root']/div/main/div/div[2]/div[2]/div/div[" + cuenta + "]/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div[1]", "xPath");
    }
    @And("hace clic en el botón 'Confirm' del cuadro de diálogo de confirmación")
    public void haceClicEnElBotonConfirmDelCuadroDeDialogoDeConfirmacion() {
        searchStep.sendClick("//span[text()='Confirm']", "xPath");
    }
    @And("elimina satisfactoriamente un tipo de ubicación")
    public void eliminaSatisfactoriamenteUnTipoDeUbicacion() {
        searchStep.refreshTab();
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Location Types'] | //span[text()='Tipos de localização']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "inventory/configure/location_types");
        searchStep.elementPresence("//span[text()='Prueba_Automation_Editado_Por_El_Robot']", "xPath", false);
    }
    @And("hay tipos de ubicaciones")
    public void hayTiposDeUbicaciones() {
        int cuenta = searchStep.findLast(2, "//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[", "]");
        searchStep.elementPresence("//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[" + cuenta + "]", "xPath", true);
    }
    @And("hace clic en el botón '+' junto a 'Add top-level locations' de la barra 'Locations'")
    public void haceClicEnElBotonMasJuantoAAddTopLevelLocationsDeLaBarraLocations() {
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/div/div/button/span", "xPath");
    }
    @And("hace clic en cualquier pestaña del cuadro de diálogo")
    public void haceClicEnCualquierPestañaDelCuadroDeDialogo() {
        searchStep.sendClick("/html/body/div[2]/div[3]/div/div[1]/div/div/button[2]/span[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiTab-textColorPrimary.Mui-selected')).getPropertyValue('color')","rgb(57, 132, 255)");
        searchStep.sendClick("/html/body/div[2]/div[3]/div/div[1]/div/div/button[3]/span[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiTab-textColorPrimary.Mui-selected')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @And("hace clic en la pestaña 'LOCATIONS' del cuadro de diálogo")
    public void haceClicEnLaPestanaLocationsDelCuadroDeDialogo() {
        searchStep.sendClick("/html/body/div[2]/div[3]/div/div[1]/div/div/button[1]/span[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiTab-textColorPrimary.Mui-selected')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @And("pasa el cursor sobre el botón 'Cancel' del cuadro de diálogo")
    public void pasaElCursorSobreElBotonCancelDelCuadroDeDialogo() {
        searchStep.actionHover("//span[text()='Cancel'] | //span[text()='Cancelar']", "xPath");
        //searchStep.needTime(600000);
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss235.jss229:hover:not(.jss234) .jss236', '.jss235.jss229:hover:not(.jss234) .jss219')).getPropertyValue('color')","rgb(57, 132, 255)");
   }
    @And("pasa el cursor sobre cualquier nombre de tipo de ubicación")
    public void pasaElCursorSobreCualquierNombreDeTipoDeUbicacion() {
        searchStep.actionHover("/html/body/div[2]/div[3]/div/div[3]/ul/div[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiListItem-button:hover')).getPropertyValue('background-color')","rgb(207, 216, 220)");
    }
    @And("hace clic en cualquier tipo de ubicación")
    public void haceClicEnCualquierTipoDeUbicacion() {
        searchStep.sendClick("/html/body/div[2]/div[3]/div/div[3]/ul/div[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiListItem-root.Mui-selected','.MuiListItem-root.Mui-selected:hover')).getPropertyValue('background-color')","rgb(242, 243, 245)");
    }
    @Then("el cuadro de diálogo 'Select Location Type' funciona correctamente")
    public void elCuadroDeDialogoSelectLocationTypeFuncionaCorrectamente() {
       searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiListItem-root.Mui-selected','.MuiListItem-root.Mui-selected:hover')).getPropertyValue('background-color')","rgb(242, 243, 245)");
    }
    @And("hace clic en el botón 'Add'")
    public void haceClicEnElBotonAdd() {
        searchStep.sendClick("//span[text()='Add'] | //span[text()='Adicionar']", "xPath");
        searchStep.elementPresence("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/span[1]", "xPath", true);
        searchStep.clearElement("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253.jss258')).getPropertyValue('border-color')","rgb(250, 56, 62)");
        searchStep.elementPresence("//span[text()='Name cannot be empty']", "xPath", true);
    }
    @And("ingresa cualquier carácter en el campo 'Name*'")
    public void ingresaCualquierCaracterEnElCampoNameAsterisco() {
        searchStep.writeData("R", "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
    }
    @And("pasa el cursor sobre el campo de entrada de texto o desplegable de cualquier selección")
    public void pasaElCursorSobreElCampoDeEntradaDeTextoODesplegableDeCualquierSeleccion() {
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253:hover:not(.jss257)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[1]/div/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253:hover:not(.jss257)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253:hover:not(.jss257)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        //solo para ambiente sandbox
        //searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[5]/div/div/div/div", "xPath");
        //searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253:hover:not(.jss257)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        //solo para ambiente sandbox
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253:hover:not(.jss257)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
    }
    @And("va a la sección de propiedades")
    public void vaALaSeccionDePropiedades() {
        //solo para ambiente sandbox
        //searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[5]/div/div/div/div/div[1]/input", "xPath");
        //searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss254:hover:not(.jss258)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        //solo para ambiente sandbox
    }
    @And("introduce o selecciona un valor en un campo obligatorio")
    public void introduceOSeleccionaUnValorEnUnCampoObligatorio() {
        searchStep.writeData("-4,210066831251578", "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[2]/input", "xPath");
        searchStep.writeData("-69,94284818571127", "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div/div/div[2]/input", "xPath");
    }
    @Then("se visualizan los campos obligatorios con el borde en color negro y el mensaje 'Name cannot be empty' ya no se visualiza")
    public void seVisulizanLosCamposObligatoriosConElBordeEnColorNegroYElMensajeNameCannotBeEmptyYaNoSeVisualiza() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss253')).getPropertyValue('border')","0.666667px solid rgb(115, 131, 158)");
    }
    @When("edita el formulario")
    public void editaElFormulario() {
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div/div", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[1]/div[3]", "xPath");
        searchStep.elementPresence("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/span", "xPath", true);
    }
    @And("pasa el cursor sobre cualquier campo de entrada de texto o desplegable de cualquier sección")
    public void pasaElCursorSobreCualquierCampoDeEntradaDeTextoODesplegableDeCualquierSeccion() {
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss358:hover:not(.jss361)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[1]/div/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss358:hover:not(.jss361)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss358:hover:not(.jss361)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        }
    @And("limpia el valor de cualquier campo obligatorio")
    public void limpiaElValorDeCualquierCampoObligatorio() {
        searchStep.copyText("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
        searchStep.clearElement("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
        searchStep.needTime(500);
        //jss133 jss137 jss333
        searchStep.elementPresence("//span[text()='Name cannot be empty']", "xPath", true);
        searchStep.needTime(500);
    }
    @And("introduce el valor en cualquier campo obligatorio que haya borrado anteriormente")
    public void introduceElValorEnCualquierCampoObligatorioQueHayaBorradoAnteriormente() {
        searchStep.pasteText("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
        searchStep.needTime(500);
    }
    @Then("se visualiza el campo obligatorio con el borde en color negro y el mensaje 'Name cannot be empty' ya no se visualiza")
    public void seVisulizaElCampoObligatorioConElBordeEnColorNegroYElMensajeNameCannotBeEmptyYaNoSeVisualiza() {
        searchStep.elementPresence("//span[text()='Name cannot be empty']", "xPath", false);
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss358:hover:not(.jss361)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
    }
    @When("edita cualquier formulario o crea uno nuevo")
    public void editaCualquierFormularioOCreaUnoNuevo() {
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div/div", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[1]/div[3]", "xPath");
        searchStep.elementPresence("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/span", "xPath", true);
    }
    @And("se asegura que el campo obligatorio 'Name*' está vacío")
    public void seAseguraQueElCampoObligatorioNameEstaVacio() {
        searchStep.compareText("", true, "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
    }
    @And("introduce un valor válido en los campos 'Lat.' y 'Long.' por defecto o coordenadas tipo propiedad")
    public void introduceUnValorValidoEnLosCamposLatYLongPorDefectoOCoordenadasTipoPropiedad() {
        searchStep.writeData("-4,210066831251578", "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[1]/div/div/div[2]/input", "xPath");
        searchStep.writeData("-69,94284818571127", "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[3]/div/div/div/div[2]/div/div/div[2]/input", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss300.jss299')).getPropertyValue('background-color')","rgba(48, 56, 70, 0.38)");
    }
    @And("introduce detalles válidos en todos los campos obligatorios")
    public void introduceDetallesValidosEnTodosLosCamposObligatorios() {
        searchStep.writeData("ROBOT_AUTOMATIZACIÓN", "//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/input", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss300.jss290')).getPropertyValue('background-color')","rgb(57, 132, 255)");
    }
    @And("pasa el cursor sobre el botón 'Cancel' del formulario de Locations")
    public void pasaElCursorSobreElBotonCancelDelFormularioDeLocations() {
        searchStep.actionHover("//span[text()='Cancel']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss300.jss294:not(.jss299) .jss301', '.jss300.jss294:not(.jss299) .jss284')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @Then("el botón 'Save' aparece deshabilitado si un campo obligatorio tiene el mensaje 'Name cannot be empty'")
    public void elBotonSaveApareceDeshabilitadoSiUnCampoObligatorioTieneElMensajeNameCannotBeEmpty() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss300.jss290')).getPropertyValue('background-color')","rgb(57, 132, 255)");
    }
    @When("hace clic en una ubicación")
    public void haceClicEnUnaUbicacion() {
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div[1]", "xPath");
        searchStep.elementPresence("//span[text()='Documents'] | //span[text()='Documentos']", "xPath", true);
    }
    @And("hace clic en la pestaña 'DOCUMENTS'")
    public void haceClicEnLaPestanaDocuments() {
        searchStep.sendClick("//span[text()='Documents'] | //span[text()='Documentos']", "xPath");
        searchStep.elementPresence("//span[text()='Add URL'] | //span[normalize-space()='Adicionar URL']", "xPath", true);
    }
    @And("hace clic en el botón 'Add URL'")
    public void haceClicEnElBotonAddUrl() {
        searchStep.sendClick("//span[text()='Add URL']", "xPath");
        searchStep.elementPresence("//span[text()='Add a new URL']", "xPath", true);
        //searchStep.needTime(600000);
        searchStep.elementPresence("/html/body/div[3]/div[3]/div/div[2]/div[1]/span[1]", "xPath", true);
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss384.jss389')).getPropertyValue('border-color')","rgb(250, 56, 62)");
        searchStep.elementPresence("//span[text()='URL cannot be empty']", "xPath", true);
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss251.jss250')).getPropertyValue('background-color')","rgba(48, 56, 70, 0.38)");
    }
    @And("pasa el cursor sobre cualquier campo de entrada de texto del cuadro de diálogo")
    public void pasaElCursorSobreCualquierCampoDeEntradaDeTextoDelCuadroDeDialogo() {
        //searchStep.needTime(600000);
        searchStep.actionHover("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss384:hover:not(.jss388)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
        searchStep.actionHover("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss384:hover:not(.jss388)')).getPropertyValue('border-color')","rgb(115, 131, 158)");
    }
    @And("introduce una URL válida en el campo 'URL*'")
    public void introduceUnaUrlValidaEnElCampoUrl() {
        searchStep.writeData(urlSymphony,"//input[@type='url']","xPath");
        //searchStep.needTime(600000);
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss251.jss241')).getPropertyValue('background-color')","rgb(57, 132, 255)");
        searchStep.elementPresence("//span[text()='URL cannot be empty']", "xPath", false);
        searchStep.sendClick("//span[text()='Add a new URL']", "xPath");

    }
    @And("pasa el cursor sobre el botón 'Cancel' del cuadro de diálogo 'Add a new URL'")
    public void pasaElCursorSobreElBotonCancelDelCuadroDeDialogoAddANewUrl() {
        searchStep.actionHover("//span[text()='Cancel']", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss251.jss245:not(.jss250) .jss252','.jss251.jss245:not(.jss250) .jss235')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @Then("el texto del botón 'Cancel' cambia a color azul")
    public void elTextoDelBotonCancelCambiaAColorAzul() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss251.jss245:not(.jss250) .jss252','.jss251.jss245:not(.jss250) .jss235')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @And("verifica la presencia del encabezado, los botones y las pestañas de la página")
    public void verificaLaPresenciaDelEncabezadoLosBotonesYLasPestanasDeLaPaina() {
        searchStep.elementPresence("//span[text()='Locations' or 'Localização']", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[1]/div[2]/span", "xPath", true);
        searchStep.elementPresence("//span[text()='Edit Location' or 'Editar Localização']", "xPath", true);
        searchStep.elementPresence("//span[text()='Details' or 'Detalhes']", "xPath", true);
        searchStep.elementPresence("//span[text()='Documents' or 'Documentos']", "xPath", true);
        //searchStep.elementPresence("//span[text()='Network Map']", "xPath", true);        //solo disponible para sandbox
        searchStep.elementPresence("//span[text()='Work Orders' or 'Ordens de Trabalho']", "xPath", true);
    }
    @And("hace clic en una ubicación dentro de la ubicación principal seleccionada")
    public void haceClicEnUnaUbicacionDentroDeLaUbicacionPrincipalSeleccionada() {
        searchStep.sendClick("(//*[name()='svg'][@class='MuiSvgIcon-root jss210'])[1] | (//*[name()='path'])[10]", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/div/div/div", "xPath");
    }
    @And("verifica que en la cabecera aparezcan la ubicación principal y la ubicación hija separadas por un Slash")
    public void verificaQueEnLaCabeceraAparezcanLaUbicacionPrincipalYLaUbicacionHijaSeparadasPorUnSlash() {
        searchStep.elementPresence("//span[text()='España' or 'CHILE']", "xPath", true);
        searchStep.elementPresence("//span[text()='/']", "xPath", true);
        searchStep.elementPresence("//span[text()='Badajoz' or 'ANTOFAGASTA']", "xPath", true);
    }
    @And("verifica que en la cabecera aparezcan el nombre de la ubicación principal en color gris claro y la ubicación hija en color negro")
    public void verificaQueEnLaCabeceraAparezcanElNombreDeLaUbicacionPrincipalEnColorGrisClaroYLaUbicacionHijaEnColorNegro() {
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss383')).getPropertyValue('color')","rgb(136, 149, 173)");
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss379')).getPropertyValue('color')","rgb(136, 149, 173)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss359')).getPropertyValue('color')","rgb(136, 149, 173)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss355')).getPropertyValue('color')","rgb(136, 149, 173)");

    }
    @And("pasa el cursor sobre el ícono '...' de la cabecera")
    public void pasaElCursorSobreElIconoTresPuntosDeLaCabecera() {
        searchStep.actionHover("(//div[@class='jss410 jss390 jss401 jss409 jss385'])[1] | (//div[@class='jss386 jss366 jss377 jss385 jss361'])[1]", "xPath");
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss418')).getPropertyValue('fill')","rgb(115, 131, 158)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss394')).getPropertyValue('fill')","rgb(115, 131, 158)");
    }
    @And("pasa el cursor sobre el botón 'Edit Location'")
    public void pasaElCursorSobreElBotonEditLocation() {
        searchStep.actionHover("//span[text()='Edit Location'] | //span[text()='Editar Localização']", "xPath");
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss407.jss397:hover:not(.jss406)')).getPropertyValue('background-color')","rgb(58, 113, 234)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss383.jss373:hover:not(.jss382)')).getPropertyValue('background-color')","rgb(58, 113, 234)");

    }
    @And("selecciona cualquier pestaña de la cabecera")
    public void seleccionaCualquierPestanaDeLaCabecera() {
        searchStep.sendClick("//span[text()='Documents'] | //span[text()='Documentos']", "xPath");
        searchStep.sendClick("//span[text()='Network Map'] | //span[text()='Detalhes']", "xPath");
        searchStep.sendClick("//span[text()='Work Orders'] | //span[text()='Ordens de Trabalho']", "xPath");
        searchStep.sendClick("//span[text()='Documents'] | //span[text()='Documentos']", "xPath");
    }
    @Then("se visualiza la pestaña seleccionada resaltada en color azul")
    public void seVisualizaLaPestanaSeleccionadaResaltadaEnColorAzul() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiTab-textColorPrimary.Mui-selected')).getPropertyValue('color')","rgb(57, 132, 255)");
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss427')).getPropertyValue('background-color')","rgb(57, 132, 255)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss403')).getPropertyValue('background-color')","rgb(57, 132, 255)");
    }
    @When("hace clic en la ubicación definida")
    public void haceClicEnLaUbicacionDefinida() {
        searchStep.sendClick("//span[text()='Prueba Robot']", "xPath");
        searchStep.elementPresence("//span[text()='Documents'] | //span[text()='Documentos']", "xPath", true);
    }
    @And("pasa el cursor sobre el botón 'Add URL'")
    public void pasaElCursorSobreElBotonAddUrl() {
        //sandbox//searchStep.actionHover("//span[text()='Add URL']", "xPath");      //al pasar el mouse sobre este elemento no cambia el colo, sino sobre el elemento que contiene tanto el + como el texto
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div", "xPath");
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss251.jss246:not(.jss250) .jss252', '.jss251.jss246:not(.jss250) .jss235')).getPropertyValue('color')","rgb(57, 132, 255)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss240:hover:not(.jss249) .jss251', '.jss252.jss240:hover:not(.jss249) .jss234')).getPropertyValue('fill')","rgb(58, 113, 234)");          //el más es el que cambia de color y el texto 'Adicionar URL'
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss240:hover:not(.jss249) .jss251', '.jss252.jss240:hover:not(.jss249) .jss234')).getPropertyValue('color')","rgb(58, 113, 234)");         //el más es el que cambia de color y el texto 'Adicionar URL'
    }
    @And("pasa el cursor sobre el botón 'Upload File'")
    public void pasaElCursorSobreElBotonUploadFile() {
        //sandbox//searchStep.actionHover("//span[text()='Upload File']", "xPath");
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/div", "xPath");
        //searchStep.needTime(600000);
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss251.jss241:hover:not(.jss250)')).getPropertyValue('background-color')","rgb(58, 113, 234)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss240:hover:not(.jss249) .jss251', '.jss252.jss240:hover:not(.jss249) .jss234')).getPropertyValue('fill')","rgb(58, 113, 234)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss240:hover:not(.jss249) .jss251', '.jss252.jss240:hover:not(.jss249) .jss234')).getPropertyValue('color')","rgb(58, 113, 234)");
    }
    @And("verifica que la fila de URL contiene el ícono 'Link', el nombre, fecha y hora de cargue")
    public void verificaQueLaFilaDeUrlContieneElIconoLinkElNombreFechaYHoraDeCargue() {
        searchStep.elementPresence("(//*[name()='svg'][@class='MuiSvgIcon-root'])[8] | //*[@id='column0']/span/div/svg", "xPath", true);
        searchStep.elementPresence("(//a[normalize-space()='URL Prueba Robot'])[1] | //*[@id='column1']/span/div[1]/a", "xPath", true);
        searchStep.elementPresence("(//div[@class='jss351'])[1] | //*[@id='column2']/span/div[2]", "xPath", true);

    }
    @And("verifica que la fila de Uploaded File contiene una imagen miniatura, el ícono 'Doc', el nombre del archivo con tipo de archivo, fecha y hora de cargue")
    public void verificaQueLaFilaDeUploadedFileContieneUnaImagenMiniaturaElIconoDocElNombreDelArchivoConTipoDeArchivoFechaYHoraDeCargue() {
        searchStep.elementPresence("(//*[name()='svg'][@class='MuiSvgIcon-root'])[8] | //*[@id='column0']/span/div/svg", "xPath", true);
        searchStep.elementPresence("(//a[normalize-space()='URL Prueba Robot'])[1] | //*[@id='column1']/span/div[1]/a", "xPath", true);
        searchStep.elementPresence("(//div[@class='jss351'])[1] | //*[@id='column2']/span/div[2]", "xPath", true);
    }
    @And("pasa el cursor sobre el ícono 'Menú'")
    public void pasaElCursorSobreElIconoMenu() {
        searchStep.actionHover("//*[@id='root']/div/main/div[2]/div[2]/div/div[1]/div[1]/div[2] | (//div[@class='jss253 jss233 jss244 jss252 jss228'])[1]", "xPath");
    }
    @Then("el color del ícono 'Menú' cambia a gris claro")
    public void elColorDelIconoMenuCambiaAGrisClaro() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss261')).getPropertyValue('fill')","rgb(115, 131, 158)");
    }
    @And("hace clic en la pestaña 'WORK ORDERS'")
    public void haceClicEnLaPestanaWorkOrders() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.sendClick("//span[text()='WORK ORDERS'] | //span[text()='Ordens de Trabalho']", "xPath");
        searchStep.elementPresence("//span[text()='Nome' and 'Modelo' and 'Projeto' and 'Responsável' and 'Situação' and 'Hora da Criação' and 'Data de vencimento' and 'Responsável' and 'Prioridade' and 'Fechar Hora'] | //span[text()='Name' and 'Plantilla' and 'Proyecto' and 'Propietario' and 'Estado' and 'Hora da Creación' and 'Fecha de vencimento' and 'Asignado' and 'Prioridad' and 'Hora de cierre']","xPath", true);
    }
    @And("pasa el cursor sobre la columna 'Name'")
    public void pasaElCursorSobreLaColumnaName() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.actionHover("(//th[@title='Nome'])[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss359:hover .jss355')).getPropertyValue('color')","rgb(57, 132, 255)");
        searchStep.elementPresence("(//*[name()='path'])[20]","xPath", true);
    }
    @And("hace clic en el botón flecha arriba")
    public void haceClicEnElBotonFlechaArriba() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        //searchStep.needTime(3000);
        searchStep.sendClick("(//th[@title='Nome'])[1]","xPath");
        searchStep.sendClick("(//th[@title='Nome'])[1]","xPath");
        searchStep.elementPresence("(//*[name()='path'])[19]","xPath", true);
    }
    @And("hace clic en el botón flecha abajo")
    public void haceClicEnElBotonFlechaAbajo() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        //searchStep.needTime(3000);
        searchStep.sendClick("(//th[@title='Nome'])[1]","xPath");
        searchStep.elementPresence("(//*[name()='path'])[20]","xPath", true);
    }
    @And("pasa el cursor sobre la columna 'Project'")
    public void pasaElCursorSobreLaColumnaProject() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.actionHover("(//span[normalize-space()='Projeto'])[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss365:not(.jss362):hover .jss363', '.jss365:not(.jss362) .jss364 .jss363')).getPropertyValue('background-color')","rgb(57, 132, 255)");
    }
    @And("va a los botones '<' y '>' en la parte inferior derecha de la tabla")
    public void vaALosBotonesAnteriorYSiguienteEnLaParteInferiorDerechaDeLaTabla() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.actionHover("(//div[@class='jss253 jss254 jss233 jss246 jss252 jss249 jss381'])[1]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss249 .jss251', '.jss252.jss249 .jss234')).getPropertyValue('fill')","rgba(48, 56, 70, 0.38)");
        searchStep.actionHover("(//div[@class='jss253 jss254 jss233 jss246 jss252 jss249 jss381'])[2]", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss249 .jss251', '.jss252.jss249 .jss234')).getPropertyValue('fill')","rgba(48, 56, 70, 0.38)");
    }
    @Then("los botones '<' y '>' estarán deshabilitados si no hay más ordenes para mostrar")
    public void losBotonesAnteriorYSiguienteEstaranDeshabilitadosSiNoHayMasOrdenesParaMostrar() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss249 .jss251', '.jss252.jss249 .jss234')).getPropertyValue('fill')","rgba(48, 56, 70, 0.38)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss252.jss249 .jss251', '.jss252.jss249 .jss234')).getPropertyValue('fill')","rgba(48, 56, 70, 0.38)");
    }
    @And("escribe el nombre de una ubicación en el cuadro de búsqueda")
    public void escribeElNombreDeUnaUbicacionEnElCuadroDeBusqueda() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.writeData("Colombia", "(//input[@placeholder='Search'])[1]", "xPath");
        searchStep.needTime(3000);
    }
    @And("selecciona cualquier ubicación de la sugerencia")
    public void seleccionaCualquierUbicacionDeLeSugerencia() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        searchStep.sendClick("(//span[@class='MuiTypography-root MuiListItemText-primary MuiTypography-body2 MuiTypography-displayBlock'][normalize-space()='Colombia'])[1]", "xPath");
        //searchStep.needTime(300000);
    }
    @And("se hace zoom al mapa automáticamente y se visualiza la ubicación seleccionada")
    public void seHaceZoomAlMapaAutomaticamenteYSeVisualizaLaUbicacionSeleccionada() {
        //estos pasos solo funcionan para coe porque en sandbox no aparece nada en workorders
        //En este paso no sé cómo verificar que el mapa sí hizo zoom y está mostrando la ubicación seleccionada
        searchStep.sendClick("(//button[@title='Zoom in'])[1]", "xPath");
        searchStep.sendClick("(//button[@title='Zoom in'])[1]", "xPath");
    }
    @And("desmarca cualquier casilla de la barra de Layers")
    public void desmarcaCualquierCasillaDeLaBarraDeLayers() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div[1]/div/div[6]/span[1]", "xPath");
    }
    @And("el chulo y el color azul son removidos de la casilla y el color del borde de la casilla se cambia a gris")
    public void elChuloYElColorAzulSonRemovidosDeLaCasillaYElColorDelBordeDeLaCasillaSeCambiaAGris() {
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiIconButton-colorPrimary')).getPropertyValue('background-color')","rgba(0, 0, 0, 0)");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.MuiIconButton-colorPrimary:hover')).getPropertyValue('background-color')","rgba(57, 132, 255, 0.04)");
        searchStep.elementPresence("//*[@id='root']/div/main/div/div[1]/div/div[6]/span[1]/span/svg/path", "xPath", false);
    }
    @And("hace clic en cualquier nodo de instancia del mapa")
    public void haceClicEnCualquierNodoDeInstanciaDelMapa() throws AWTException {
        searchStep.refreshTab();
        searchStep.needTime(4000);
        //searchStep.sendClick("(//button[@title='Zoom in'])[1]", "xPath");
        //searchStep.sendClick("(//button[@title='Zoom in'])[1]", "xPath");
        searchStep.needTime(1000);
        searchStep.clickOnImage("C:\\Users\\dninocam\\Documents\\AUTOMATIZACION\\images\\Waypoint_Test_3.png");
        //searchStep.needTime(600000);
    }
    @And("pasa el cursor sobre cualquier instancia de ruta del cuadro de ubicación")
    public void pasaElCursorSobreCualquierInstanciaDeRutaDelCuadroDeUbicacion() {
        searchStep.actionHover("//*[@id='root']/div/main/div/div[2]/div/div[6]/div[2]/div/div[2]/div/div/div[1]/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss190:hover')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @And("hace clic en el ícono '...' si la ruta es muy larga")
    public void haceClicEnElIconoTresPuntosSiLaRutaEsMuyLarga() {
        if(searchStep.isElement("//span[text()='...']", "")){
            searchStep.sendClick("//span[text()='...']", "");
        }
    }
    @And("pasa el cursor sobre cualquier ubicación del cuadro de la ruta expandida")
    public void pasaElCursorSobreCualquierUbicacionDelCuadroDeLaRutaExpandida() {
        searchStep.actionHover("//*[@id='root']/div/main/div/div[2]/div/div[6]/div[2]/div/div[2]/div/div/div[1]/div", "xPath");
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss594:hover')).getPropertyValue('color')","rgb(57, 132, 255)");
    }
    @And("hace clic en el botón 'X' ubicado en la parte superior derecha del cuadro de ubicación")
    public void haceClicEnElBotonXUbicadoEnLaPArteSuperiorDerechaDelCuadroDeUbicacion() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div[2]/div/div[6]/div[2]/div/div[1]", "xPath");
    }
    @Then("se cierra el cuadro de ubicación")
    public void seCierraElCuadroDeUbicacion() {
        searchStep.elementPresence("//*[@id='root']/div/main/div/div[2]/div/div[6]/div[2]", "xPath", false);
    }
    @And("desmarca algunas casillas de la barra de Layers")
    public void desmarcaAlgunasCasillasDeLaBarraDeLayers() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div[1]/div/div[4]/span[1]", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div/div[1]/div/div[5]/span[1]", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div/div[1]/div/div[6]/span[1]", "xPath");
    }
    @Then("se muestran todas las casillas de la barra de Layers marcadas")
    public void seMuestranTodasLasCasillasDeLaBarraDeLayersMarcadas() {
        //sandbox//searchStep.elementPresence("//div[6]//span[1]//span[1]//*[name()='svg']//*[name()='path' and contains(@d,'M19 3H5c-1')]", "xPath", true);
        //sandbox//searchStep.elementPresence("//*[@id='root']/div/main/div/div[1]/div/div[5]/span[1]/span/svg/path", "xPath", true);
        //sandbox//searchStep.elementPresence("//*[@id='root']/div/main/div/div[1]/div/div[6]/span[1]/span/svg/path", "xPath", true);
        //searchStep.needTime(600000);
        searchStep.checkBoxState("//*[@id='root']/div/main/div/div[1]/div/div[4]/span[1]/span/input", "xPath", true);
        searchStep.checkBoxState("//*[@id='root']/div/main/div/div[1]/div/div[5]/span[1]/span/input", "xPath", true);
        searchStep.checkBoxState("//*[@id='root']/div/main/div/div[1]/div/div[6]/span[1]/span/input", "xPath", true);
    }
    @And("hace clic en el botón 'Satellite'")
    public void haceClicEnElBotonSatellite() {
        searchStep.sendClick("(//span[contains(text(),'Satellite')])[1]", "xPath");
    }
    @Then("se cambia la vista del mapa de 'Satellite' a 'Map'")
    public void seCambiaLaVistaDelMapaDeSatelliteAMap() {
        //consultar a Oscar o Sebas cómo validar esto porque ni idea cómo, tocaría por visión artificial
    }
    @And("está en el módulo de 'Workforce Management'")
    public void estaEnElModuloDeWorkforceManagement() {
        searchStep.sendClick("//div[@class='jss247' or @class='jss34']", "xPath");
        searchStep.elementPresence("//*[@id='navigation-menu']/div[3]/div", "xPath", true);
        searchStep.sendClick("//*[@id='navigation-menu']/div[3]/div/div[2]", "xPath");
        searchStep.elementPresence("//span[text()='Work Orders'] | //span[text()='Ordens de trabalho']", "xPath", true);
    }
    @And("hace clic en 'Work Orders' del menú Templates")
    public void haceClicEnWorkOrdersDelMenuTemplates() {
        searchStep.sendClick("//span[text()='Work Orders'] | //span[text()='Ordens de Trabalho']", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Work Order Templates'] | //span[text()='Modelos de ordem de serviço']", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "workorders/configure/work_order_types");
        searchStep.elementPresence("//span[text()='Create Work Order Template'] | //span[text()='Criar modelo de ordem de serviço']", "xPath", true);
        searchStep.elementPresence("//span[text()='Create reusable templates for frequently created work order types.'] | //span[text()='Criar modelos reutilizáveis para tipos de ordem de serviço criados com frequência.']", "xPath", true);
        //sandbox//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss306')).getPropertyValue('color')","rgb(57, 132, 255)");//sandbox
        //coe//searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss303')).getPropertyValue('color')","rgb(57, 132, 255)");//coe
        searchStep.pseudoElement("return window.getComputedStyle(document.querySelector('.jss310')).getPropertyValue('color')","rgb(57, 132, 255)");//coe.dev
    }
    @And("hace clic en el botón 'Create Work Order Template'")
    public void haceClicEnElBotonCreateWorkOrderTemplate() {
        searchStep.sendClick("//span[text()='Create Work Order Template'] | //span[text()='Criar modelo de ordem de serviço']", "xPath");
        searchStep.elementPresence("//span[text()='New work order template'] | //span[text()='Novo modelo de ordem de serviço']", "xPath", true);
        searchStep.elementPresence("//span[text()='Cancel'] | //span[text()='Cancelar']", "xPath", true);
        searchStep.elementPresence("//span[text()='Save'] | //span[text()='Salvar']", "xPath", true);
    }
    @And("escribe el título de la plantilla en el campo 'Title*'")
    public void escribeElTituloDeLaPlantillaEnElCampoTitleAsterisco() {
        searchStep.writeData("Prueba Robot","//*[@id='root']/div/main/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div/div[1]/input","xPath");
    }
    @And("escribe el nombre de la plantilla en el campo 'Name'")
    public void escribeElNombreDeLaPlantillaEnElCampoName() {
        searchStep.writeData("Prueba Robot","(//input[@placeholder='Name'])[1] | (//input[@placeholder='Nome'])[1]","xPath");
    }
    @Then("se crea una nueva plantilla en la tabla de ordenes de trabajo")
    public void seCreaUnaNuevaPlantillaEnLaTablaDeOrdenesDeTrabajo() {
        searchStep.elementPresence("(//span[contains(text(),'Prueba Robot')])[1]","xPath", true);
    }
    @And("hace clic en cualquier plantilla de la tabla de ordenes de trabajo")
    public void haceClicEnCualquierPlantillaDeLaTablaDeOrdenesDeTrabajo() {
        searchStep.sendClick("(//span[contains(text(),'Prueba Robot')])[1]","xPath");
    }
    @And("actualiza el valor de cualquier campo en la plantilla de orden de servicio")
    public void actualizaElValorDeCualquierCampoEnLaPlantillaDeOrdenDeServicio() {
        searchStep.writeData("_Editado_Por_El_Robot", "(//input[@placeholder='New work order template'])[1] | (//input[@placeholder='Novo modelo de ordem de serviço'])[1]", "xPath");
    }
    @Then("se actualizan los cambios en la tabla de ordenes de trabajo")
    public void seActualizanLosCambiosEnLaTablaDeOrdenesDeTrabajo() {
        searchStep.elementPresence("(//span[contains(text(),'Prueba Robot_Editado_Por_El_Robot')])[1]","xPath", true);
    }
    @And("hace clic en cualquier nombre de plantilla que no tenga ninguna instancia")
    public void haceClicEnCualquierNombreDePlantillaQueNoTengaNingunaInstancia() {
        searchStep.sendClick("(//span[contains(text(),'Prueba Robot_Editado_Por_El_Robot')])[1]","xPath");
    }
    @And("hace clic en el ícono 'Delete'")
    public void haceClicEnElIconoDelete() {
        searchStep.sendClick("(//*[name()='svg'][@class='MuiSvgIcon-root'])[5]","xPath");
    }
    @And("hace clic en el botón 'Confirm'")
    public void haceClicEnElBotonConfirm() {
        searchStep.sendClick("(//span[normalize-space()='Confirm'])[1]","xPath");
    }
    @Then("la plantilla eliminada es removida de la tabla de ordenes de trabajo")
    public void laPlantillaEliminadaEsRemovidaDeLaTablaDeOrdenesDeTrabajo() {
        searchStep.elementPresence("(//span[contains(text(),'Prueba Robot_Editado_Por_El_Robot')])[1]","xPath", false);
    }
    @And("hace clic en 'Projects' del menú Templates")
    public void haceClicEnProjectsDelMenuTemplates() {
        searchStep.sendClick("//span[text()='Projects'] | //span[text()='Projetos']","xPath");
        searchStep.elementPresence("//span[text()='Project Templates'] | //span[text()='Modelos de Projeto']","xPath", true);
    }
    @And("hace clic en el botón 'Edit' de cualquier plantilla de proyecto")
    public void haceClicEnElBotonEditDeCualquierPlantillaDeProyecto() {
        searchStep.sendClick("//span[text()='Prueba Robot']//parent::div//parent::div//parent::div//parent::div//descendant::span[5]","xPath");
        searchStep.elementPresence("//span[text()='Prueba Robot']","xPath", true);
        searchStep.elementPresence("//span[text()='Details'] | //span[text()='Detalhes']","xPath", true);
        searchStep.elementPresence("//span[text()='Work Orders'] | //span[text()='Ordens de Trabalho']","xPath", true);
    }
    @And("actualiza el valor de cualquier campo en la plantilla de proyecto")
    public void actualizaElValorDeCualquierCampoEnLaPlantillaDeOrdenDeProyecto() {
        searchStep.writeData("_Editado_Por_El_Robot", "//input[@value='Prueba Robot']", "xPath");
        searchStep.writeData("_Editado_Por_El_Robot", "(//input[@placeholder='Name'])[1] | //input[@placeholder='Nome']", "xPath");
    }
    @And("se actualizan los cambios realizados a la plantilla de proyecto")
    public void seActualizanLosCambiosRealizadosALaPlantillaDeProyecto() {
        searchStep.elementPresence("//span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", true);
        searchStep.elementPresence("//span[text()='Project Templates'] | //span[text()='Modelos de Projeto']", "xPath", true);
    }
    @And("hace clic en el ícono 'Delete' de cualquier plantilla de proyecto")
    public void haceClicEnElIconoDeleteDeCualquierPlantillaDeProyecto() {
        searchStep.sendClick("//span[text()='Prueba Robot_Editado_Por_El_Robot']//parent::div//parent::div//descendant::div[2]", "xPath");
        searchStep.elementPresence("//span[text()='Delete'] | //span[text()='Excluir']","xPath", true);
    }
    @And("hace clic en el botón 'Delete' del cuadro de diálogo")
    public void haceClicEnElBotonDeleteDelCuadroDeDialogo() {
        searchStep.sendClick("//span[text()='Excluir'] | //span[text()='Delete']","xPath");
        searchStep.needTime(3000);
    }
    @Then("la plantilla es removida de las plantillas de proyecto")
    public void laPlantillaEsRemovidaDeLasPlantillasDeProyecto() {
        searchStep.elementPresence("//span[text()='Prueba Robot_Editado_Por_El_Robot']","xPath", false);
    }
    @And("hace clic en cualquier nombre de la lista de ordenes de trabajo")
    public void haceClicEnCualquierNombreDeLaListaDeOrdenesDeTrabajo() {
        //searchStep.needTime(600000);
        searchStep.sendClick("//div[@title='Prueba Robot']", "xPath");
        searchStep.elementPresence("//span[text()='Prueba Robot']","xPath", true);
        searchStep.elementPresence("//span[text()='Details'] | //span[text()='Detalhes']","xPath", true);
    }
    @And("ingresa un nuevo correo en el campo 'Owner'")
    public void ingresaUnNuevoCorreoEnElCampoOwner() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div/div/div/div/div[1] | (//div[@class='jss649'])[1] | (//div[@class='jss631'])[1]", "xPath");
        searchStep.writeData("symphony@nttdata.com", "(//input[@placeholder='Search...'])[4] | //*[@id='root']/div/main/div/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div/div/div/div/input", "xPath");
    }
    @And("ingresa un nuevo correo en el campo 'Assignee'")
    public void ingresaUnNuevoCorreoEnElCampoAssignee() {
        searchStep.writeData("symphony@nttdata.com", "(//input[@placeholder='Search...'])[5]", "xPath");
    }
    @And("escribe un comentario en el campo 'Activity & Comments'")
    public void escribeUnComentarioEnElCampoActivityComments() {
        searchStep.writeData("Comentado Por El Robot", "(//input[@placeholder='Write a comment'])[1]", "xPath");
    }
    @And("hace clic en el ícono de subir archivo en la sección de anexos")
    public void haceClicEnElIconoDeSubirArchivoEnLaSeccionDeAnexos() {
        //searchStep.sendClick("(//div[@class='jss572 jss552 jss559 jss571 jss490'])[2]", "xPath");
        //searchStep.needTime(600000);
        searchStep.sendClick("//*[@id='root']/div/main/div/div/div[2]/div/div[1]/div[3]/div[1]/div[1]/div/div/div[2]/span | //*[@id='root']/div/main/div/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div/div/div[2]", "xPath");
    }
    @And("selecciona un archivo válido en la ventana emergente y hace clic en 'Abrir'")
    public void seleccionaUnArchivoValidoEnLaVentanaEmergenteYHaceClicEnAbrir() throws AWTException {
        searchStep.sendPathToOpenFile("C:\\Users\\dninocam\\Documents\\AUTOMATIZACION\\images\\file_name.png");
    }
    @Then("se muestran los detalles actualizados de la instancia en la tabla de work orders")
    public void seMuestranLosDetallesActualizadosDeLaInstanciaEnLaTablaDeWorkOrders() {
        searchStep.elementPresence("//span[text()='Prueba Robot']", "xPath", true);
    }
    @And("hace clic en el ícono 'Delete' de la cabecera")
    public void haceClicEnElIconoDeleteDeLaCabecera() {
        searchStep.sendClick("//*[@id='root']/div/main/div/div[2]/div[1]/div[2]/div/div[1] | //*[@id='root']/div/main/div/div/div[1]/div[2]/div[2]/div[1] | (//div[@class='jss572 jss552 jss564 jss571 jss504 jss601'])[1] | (//div[@class='jss496 jss476 jss488 jss495'])[1] | (//div[@class='jss519 jss499 jss511 jss518'])[1]", "xPath");
    }
    @Then("la orden de trabajo es removida de la tabla")
    public void laOrdenDeTrabajoEsRemovidaDeLaTabla() {
        searchStep.elementPresence("//span[text()='Prueba Robot']", "xPath", false);
    }
    @And("hace clic en el botón 'X' del filtro de estado predeterminado")
    public void haceClicEnElBotonXDelFiltroDeEstadoPredeterminado() {
        searchStep.sendClick("(//button[@type='button'])[1]", "xPath");
    }
    @And("hace clic en la barra de filtro")
    public void haceClicEnLaBarraDeFiltro() {
        searchStep.sendClick("(//input[@type='text'])[1]", "xPath");
    }
    @And("hace clic en 'Status' de la lista desplegable del menú de filtro")
    public void haceClicEnStatusDeLaListaDesplegableDelMenuDeFiltro() {
        searchStep.sendClick("//span[text()='Status']", "xPath");
    }
    @And("hace clic en el campo de entrada")
    public void haceClicEnElCampoDeEntrada() {
        searchStep.sendClick("(//div[@role='button'])[1]", "xPath");
    }
    @And("hace clic en cualquier opción del campo de entrada del filtro seleccionado")
    public void haceClicEnCualquierOpcionDelCampoDeEntradaDelFiltroSeleccionado() {
        searchStep.sendClick("(//li[normalize-space()='Closed'])[1]", "xPath");
    }
    @And("presiona la tecla 'TAB'")
    public void presionaLATeclaTab() {
        searchStep.sendKeysWE(tab);
    }
    @And("hace clic en el botón 'X' del filtro aplicado en la barra de filtro")
    public void haceClicEnElBotonXDelFiltroAplicadoEnLaBarraDeFiltro() {
        searchStep.sendClick("(//button[@type='button'])[1]", "xPath");
    }
    @Then("se volverán a mostrar todas las ordenes de trabajo")
    public void seVolveranAMostrarTodasLasOrdenesDeTrabajo() {
        searchStep.elementPresence("(//button[@type='button'])[1]", "xPath", false);
    }
    @And("hace clic en 'Users and Roles' del menú User Management")
    public void haceClicEnUsersAndRolesDelMenuUserManagement() {
        searchStep.sendClick("//span[text()='Users and Roles'] | (//span[@class='jss923 jss930 jss939'])[1]", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Add User']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/users/all");
    }
    @And("hace clic en el botón 'Add User'")
    public void haceClicEnElBotonAddUser() {
        searchStep.sendClick("//span[text()='Add User'] | (//span[@class='jss924 jss929 jss937 jss939 jss984'])[1]", "xPath");
        searchStep.elementPresence("//span[text()='New user account']", "xPath", true);
    }
    @And("introduce detalles válidos en el formulario New user account")
    public void introduceDetallesValidosEnElFormularioNewUserAccount() {
        searchStep.writeData("Robot", "(//input[@type='string'])[1]", "xPath");
        searchStep.writeData("Robot", "(//input[@type='string'])[2]", "xPath");
        searchStep.writeData("robot@nttdata.com", "(//input[@type='string'])[3]", "xPath");
        searchStep.writeData("PruebaRobot", "(//input[@type='password'])[1]", "xPath");
        searchStep.writeData("PruebaRobot", "(//input[@type='password'])[2]", "xPath");
        searchStep.sendClick("/html/body/div[2]/div[3]/div/div[2]/div[4]/div[2]/div/div/div", "xPath");
        searchStep.sendClick("(//span[normalize-space()='MyOrganization'])[1] | /html/body/div[3]/div/div/div[1]/div/span", "xPath");
    }
    @Then("el usuario es agregado exitosamente a la lista")
    public void elUsuarioEsAgregadoExitosamenteALaLista() {
        searchStep.sendClick("//span[text()='Users and Roles'] | (//span[@class='jss923 jss930 jss939'])[1]", "xPath");
        searchStep.elementPresence("//span[text()='robot@nttdata.com']", "xPath", true);
    }
    @And("hace clic en cualquier usuario")
    public void haceClicEnCualquierUsuario() {
        searchStep.sendClick("//span[text()='robot@nttdata.com'] | //span[text()='Robot Robot']", "xPath");
        searchStep.elementPresence("//span[text()='Profile']", "xPath", true);
        searchStep.elementPresence("//span[text()='Personal Details']", "xPath", true);
    }
    @And("modifica detalles válidos del formulario")
    public void modificaDetallesValidosDelFormulario() {
        searchStep.sendKeyComb(control, "a", "(//input[@type='string'])[2]", "xPath");
        searchStep.sendKeyboard(delete, "(//input[@type='string'])[2]", "xPath");
        searchStep.writeData("Prueba", "(//input[@type='string'])[2]", "xPath");
    }
    @And("hace clic en el botón 'Apply'")
    public void haceClicEnElBotonApply() {
        searchStep.sendClick("(//span[normalize-space()='Apply'])[1] | //*[@id='root']/div/main/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]", "xPath");
    }
    @Then("se guarda el formulario con las modificaciones realizadas")
    public void seGuardaElFormularioConLasModificacionesRealizadas() {
        searchStep.elementPresence("//span[text()='Robot Prueba']", "xPath", true);
    }
    @And("hace clic en 'Permission groups' del menú User Management")
    public void haceClicEnPermissionGroupsDelMenuUserManagement() {
        searchStep.sendClick("//span[text()='Permission groups'] | //*[@id='root']/div/main/div/div[1]/div/div[2]/span", "xPath");
        searchStep.elementPresence("//span[text()='Create a group']", "xPath",true);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Create a group']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/groups");
    }
    @And("hace clic en el botón 'Create a group'")
    public void haceClicEnElBotonCreateAGroup() {
        searchStep.sendClick("//span[text()='Create a group'] | //span[text()='Create Group'] | (//span[@class='jss239 jss244 jss252 jss254 jss299'])[1]", "xPath");
        searchStep.elementPresence("//span[text()='New group']", "xPath", true);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='New group']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/group/new");
    }
    @And("introduce detalles válidos en el formulario 'New group'")
    public void introduceDetallesValidosEnElFormularioNewGroup() {
        searchStep.writeData("Prueba Robot", "(//input[@type='string'])[1]", "xPath");
    }
    @And("se crea exitosamente un nuevo permiso de grupo")
    public void seCreaExitosamenteUnNuevoGrupoDePermiso() {
        searchStep.elementPresence("//span[text()='Prueba Robot']", "xPath", true);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Prueba Robot']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/groups");
    }
    @And("hace clic en cualquier nombre de grupo")
    public void haceClicEnCualquierNombreDeGrupo() {
        searchStep.sendClick("//span[text()='Prueba Robot'] | //span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath");
        searchStep.elementPresence("//span[text()='Prueba Robot'] | //span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", true);
        searchStep.elementPresence("//span[text()='Group details']", "xPath", true);
    }
    @And("actualiza cualquier sección con detalles válidos")
    public void actualizaCualquierSeccionConDetallesValidos() {
        searchStep.writeData("_Editado_Por_El_Robot", "//input[@value='Prueba Robot']", "xPath");
    }
    @Then("se actualizan los cambios del grupo satisfactoriamente")
    public void seActualizanLosCambiosDelGrupoSatisfactoriamente() {
        //searchStep.needTime(6000);
        searchStep.elementPresence("//span[text()='Create a group'] | //span[text()='Create Group']", "xPath", true);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/groups");
    }
    @Then("el grupo es removido de la tabla")
    public void elGrupoEsRemovidoDeLaTabla() {
        //searchStep.needTime(6000);
        searchStep.elementPresence("//span[text()='Prueba Robot'] | //span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", false);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Create a group'] | //span[text()='Create Group']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/groups");
    }
    @And("hace clic en 'Policies' del menú User Management")
    public void haceClicEnPoliciesDelMenuUserManagement() {
        searchStep.sendClick("//span[text()='Policies'] | (//span[normalize-space()='Policies'])[1] | //*[@id='root']/div/main/div/div[1]/div/div[3]/span", "xPath");
        searchStep.elementPresence("//span[text()='Create a policy']", "xPath",true);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Create a policy']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/policies");
    }
    @And("hace clic en el botón 'Create a policy'")
    public void haceClicEnElBotonCreateAPolicy() {
        searchStep.sendClick("//span[text()='Create a policy'] | //*[@id='root']/div/main/div/div[2]/div[1]/div[2]/div/div | //*[@id='root']/div/main/div/div[2]/div[1]/div[2]/div/div/span", "xPath");
        searchStep.elementPresence("//span[text()='New policy'] | //*[@id='root']/div/main/div/div[2]/div[1]/div[1]/span/div/div[2]/div/span", "xPath",true);
        searchStep.elementPresence("(//h2[normalize-space()='Policy Details'])[1] | //*[@id='root']/div/main/div/div[2]/div[2]/div/div[1]/div/div/h2", "xPath",true);
        searchStep.pageLocation("Connectivity Platform", "(//h2[normalize-space()='Policy Details'])[1] | //*[@id='root']/div/main/div/div[2]/div[2]/div/div[1]/div/div/h2", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/policy/new");
    }
    @And("hace clic en cualquier opción del campo desplegable 'Policy Type'")
    public void haceClicEnCualquierOpcionDelCampoDesplegablePolicyType() {
        searchStep.sendClick("//*[@id='mui-component-select-type'] | (//div[@id='mui-component-select-type'])[1]", "xPath");
        searchStep.elementPresence("(//li[normalize-space()='Inventory'])[1] | //*[@id='menu-type']/div[3]/ul/li[1] | (//li[normalize-space()='Workforce'])[1] | //*[@id='menu-type']/div[3]/ul/li[2] | (//li[normalize-space()='Assurance'])[1] | //*[@id='menu-type']/div[3]/ul/li[3]", "xPath",true);
        searchStep.sendClick("(//li[normalize-space()='Inventory'])[1] | //*[@id='menu-type']/div[3]/ul/li[1] | (//li[normalize-space()='Workforce'])[1] | //*[@id='menu-type']/div[3]/ul/li[2] | (//li[normalize-space()='Assurance'])[1] | //*[@id='menu-type']/div[3]/ul/li[3]", "xPath");
    }
    @And("introduce detalles válidos en el formulario 'New policy'")
    public void introduceDetallesValidosEnElFormularioNewPolicy() {
        searchStep.writeData("Prueba Robot", "(//input[@name='name'])[1] | //*[@id='root']/div/main/div/div[2]/div[2]/div/div[1]/div/div/div/div[2]/form/div/div/input", "xPath");
        searchStep.writeData("Prueba Robot", "(//textarea[@id='outlined-multiline-flexible'])[1] | //*[@id='outlined-multiline-flexible']", "xPath");
    }
    @Then("se crea exitosamente una nueva política")
    public void seCreaExitosamenteUnaNuevaPolitica() {
        searchStep.elementPresence("//span[text()='Prueba Robot'] | (//span[contains(text(),'Prueba Robot')])[1] | //*[@id='column0']/span/div/span", "xPath", true);
    }




    @And("hace clic en cualquier política")
    public void haceClicEnCualquierPolitica() {
        searchStep.sendClick("//span[text()='Prueba Robot'] | //span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath");
        searchStep.elementPresence("//span[text()='Prueba Robot'] | //span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", true);
        searchStep.elementPresence("//span[text()='Policy Details'] | (//h2[normalize-space()='Policy Details'])[1]", "xPath", true);
    }
    @Then("se actualizan los cambios de la política satisfactoriamente")
    public void seActualizanLosCambiosDeLaPoliticaSatisfactoriamente() {
        //searchStep.needTime(6000);
        searchStep.elementPresence("//span[text()='Create a policy'] | (//span[@class='jss60 jss65 jss73 jss75 jss921'])[1]", "xPath", true);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/policies");
    }
    @Then("la política es removida de la tabla")
    public void laPoliticaEsRemovidoDeLaTabla() {
        //searchStep.needTime(6000);
        searchStep.elementPresence("//span[text()='Prueba Robot'] | //span[text()='Prueba Robot_Editado_Por_El_Robot']", "xPath", false);
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Create a policy'] | (//span[@class='jss60 jss65 jss73 jss75 jss921'])[1]", "xPath", WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "admin/user_management/policies");
    }
    @And("hace clic en la opción 'Automation Management'")
    public void haceClicEnLaOpcionAutomationManagement() {
        searchStep.sendClick("//span[text()='Automation Management'] | (//span[normalize-space()='Automation Management'])[1]", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Automation Flows'] | //span[text()='Automation Flows Catalog'] | //*[@id='root']/div/main/div/div[1]/div[1]/span", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "automation");
    }
    @And("hace clic en el ícono 'Operation' de la barra de navegación")
    public void haceClicEnElIconoOperationDeLaBarraDeNavegacion() {
        searchStep.sendClick("(//div[@class='jss222'])[1] | (//a[@href='/automation/operation'])[1]", "xPath");
        searchStep.pageLocation("Connectivity Platform", "//span[text()='Operation'] | //span[text()='Instances Flow'] |  //*[@id='root']/div/main/div/div[1]/div/span[1]", "xPath",WebDriverManager.getDriver().getCurrentUrl(),urlSymphony + "automation/operation");
    }
    @And("hace clic en cualquier ID Instance")
    public void haceClicEnCualquierIdInstance() {
        searchStep.sendClick("//*[@id='column0']/span/div", "xPath");
        searchStep.switchTab(1);
    }
    @Then("se muestra la interfaz de ejecución del flujo y el Workflow Log")
    public void seMuestraLaInterfazDeEjecucionDelFlujoYElWorkflowLog() {
        searchStep.elementPresence("//*[@id='simple-popover']/div[3]/h4 | (//h4[normalize-space()='Workflow Log'])[1]", "xPath", true);
        searchStep.elementPresence("//*[@id='v-10']", "xPath", true);
    }
    @And("hace clic en el botón de Detalles de la Instancia")
    public void haceClicEnElBotonDeDetallesDeLaInstancia() {
        searchStep.sendClick("//*[@id='simple-popover']/div[1]", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div[1]/div/div[3]/div/div/div/button", "xPath");
        }
    @Then("se muestran los detalles de la instancia")
    public void seMuestranLosDetallesDeLaInstancia() {
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div/div[3]/div/div/div[2]/div[1]/div[1]/div[1]/b", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div/div[3]/div/div/div[2]/div[1]/div[2]/div[1]/b", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div/div[3]/div/div/div[2]/div[1]/div[3]/div[1]/b", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div/div[3]/div/div/div[2]/div[1]/div[4]/div[1]/b", "xPath", true);
    }
    @And("hace clic en el botón 'Edit Flow'")
    public void haceClicEnElBotonEditFlow() {
        searchStep.sendClick("//*[@id='simple-popover']/div[1]", "xPath");
        searchStep.sendClick("//*[@id='root']/div/main/div[1]/div/div[1]/div[2]/div/div | //span[text()='Edit Flow']", "xPath");
    }
    @Then("ingresa a la interfaz de edición del flujo")
    public void ingresaALaInterfazDeEdicionDelFlujo() {
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div[1]/div/div/div[1]", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div[2]/div[1]/div[3]/div[1]", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div[2]/div[1]/div[3]/div[3]/div", "xPath", true);
    }
    @Then("la interfaz de usuario del flujo interactúa correctamente")
    public void laInterfazDeUsuarioDelFlujoInteractuaCorrectamente() {
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div[1]/div/div/div[1]", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div[2]/div[1]/div[3]/div[1]", "xPath", true);
        searchStep.elementPresence("//*[@id='root']/div/main/div[1]/div[2]/div[1]/div[3]/div[3]/div", "xPath", true);
    }
















    @And("hace clic en la pestaña 'Permission groups' del usuario seleccionado")
    public void haceClicEnLaPestanaPermissionGroupsDelUsuarioSeleccionado() {
        searchStep.sendClick("(//span[@class='jss270 jss276 jss284 jss389'][normalize-space()='Permission groups'])[1] | //*[@id='root']/div/main/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div[1]/div[3]/span", "xPath");
        searchStep.needTime(600000);
    }

}
