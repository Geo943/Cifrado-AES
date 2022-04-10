
package servicio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ghernandez
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Crypt crip =new Crypt();
        String var1="92AE31A79FEEB2A3";
                String var2="0123456789ABCDEF";
                        String var3="hola";
        try {
            String  salida=crip.encrypt(var1,var2 ,var3 );
            System.out.println("salida de Encriptado = " +salida);
            String salida2=crip.decrypt(var1,var2,salida);
            System.out.println("salida de deseEncriptado = " +salida2);
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR!!!!!!!");
        }
    }
    
}
