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
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class Client 
{
    BufferedWriter bw; //write
    BufferedReader br; //read
    
    public Client(String ip, int porta) // ip e porta del server
    {
        try (Socket so = new Socket(ip, porta))
        {
            // writing to server
            PrintWriter out = new PrintWriter(so.getOutputStream(), true);
  
            // reading from server
            BufferedReader in= new BufferedReader(new InputStreamReader(
            so.getInputStream()));
            
            Scanner sc = new Scanner(System.in);
            String line = null;
            while (!"exit".equalsIgnoreCase(line)) 
            {
                
                // reading from user
                line = sc.nextLine();
  
                // sending the user input to server
                out.println(line);
                out.flush();
  
                // displaying server reply
                System.out.println("Server replied " + in.readLine());
            }
            
            // closing the scanner object
            sc.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
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
