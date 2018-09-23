
package main;
import controllers.controllerLeer;
import models.modelLeer;
import views.viewLeer;
/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modelLeer modeleer = new modelLeer();
        viewLeer viewleer = new viewLeer();
        controllerLeer controllerleer = new controllerLeer(modeleer, viewleer);
    }
    
}
