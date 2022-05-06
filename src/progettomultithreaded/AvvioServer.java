/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettomultithreaded;

/**
 *
 * @author loren
 */
public class AvvioServer 
{
    public static void main(String[] args) 
    {
        Server srv = new Server(2000); // crea un istanza della classe server 
        srv.ascolto(); //srv.scrivi("Benvenuto client"); 
    }
}
