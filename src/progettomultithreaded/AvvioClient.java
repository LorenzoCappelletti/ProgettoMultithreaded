/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettomultithreaded;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class AvvioClient 
{
    public static void main(String[] args) 
    {
        try 
        {
            Client cli = new Client(InetAddress.getLocalHost(), 2000); //LocalHost perchè client e server stanno sulla stessa macchina
            cli.scrivi("scrivo");
            cli.leggi();
        } 
        catch (UnknownHostException ex) 
        {
            Logger.getLogger(AvvioClient.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
           
}
