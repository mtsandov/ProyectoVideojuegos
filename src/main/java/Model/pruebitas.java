/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import estructuras.ArrayListTDA;

/**
 *
 * @author Melanie
 */
public class pruebitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Cuenta c1= new Cuenta("Melanie", "Sandoval", "msandov@espol.edu.ec", "Espol", "melmiel", "mela","2");
        Cuenta c2= new Cuenta("Juan", "Castle", "juadicas@espol.edu.ec", "Espol", "juanito", "juanito","1");
        ArrayListTDA<Cuenta> cuentas= new ArrayListTDA<Cuenta>();
        cuentas.add(c1);
        cuentas.add(c2);
        Cuenta.serializar(cuentas, "cuentas");
       ArrayListTDA<Cuenta> cuentas2= Cuenta.leer("cuentas");
        for(Cuenta c:cuentas)
            System.out.println(c);
    }
    
}
