/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettomultithreaded;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class Server 
{
    /*public static void main(String[] args) 
    {
        CountDown c = new CountDown(5);
        c.start();
    }*/
    ServerSocket ss;
    Socket so; // socket apre la connessione con il client
    BufferedWriter bw; //write
    BufferedReader br; //read
    
    
    public Server (int porta)
    {
        try 
        {
            ss = new ServerSocket(porta);
            System.out.println("Server avviato in ascolto");
            //ss.setSoTimeout(3000);
            
        }
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ascolto() // server si mette in ascolto 3way con il client 
    {
        try 
        {
            so = ss.accept(); // tramite il metodo accept() si inizializza la connessione tra server e client
            System.out.println("Connessione stabilita");
            // create a new thread object
            ClientHandler clientSock = new ClientHandler(so);
  
            // This thread will handle the client
            // separately
            new Thread(clientSock).start();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi(String messaggio)
    {
        try 
        {
            bw.write(messaggio+"\n");
            bw.flush();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String leggi()
    {
        String messaggioritorno = " ";
        try 
        {
            messaggioritorno = br.readLine();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggioritorno;
    }
    
}
