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
       
            Client cli = new Client("127.0.0.1", 2000); //LocalHost perchè client e server stanno sulla stessa macchina
 
        
    }
           
}
