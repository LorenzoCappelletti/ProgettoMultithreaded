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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loren
 */
public class ClientHandler implements Runnable // Runnable è una interfaccia che poi va concatenata al thread per farla diventare tale
{
    private final Socket clientSocket; //oggetto client socket //final(classe diviene una costante. Un metodo dichiarato final non può essere riscritto in una sottoclasse.)
    BufferedWriter bw; //write
    BufferedReader br; //read
    
    // Constructor
    public ClientHandler(Socket socket) // riceve il socket del server che è solo uno. Stesso socket, ma thread diversi. Ogni thread appartiene ad un client
    {
        this.clientSocket = socket;
    }
    
    public void run()
    {
        PrintWriter out = null;
        BufferedReader in = null;
        
        //BufferedWriter bw; //write
        //BufferedReader br; //read
        
        try 
        {
            //br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // inizializzo br
            //bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); // inizializzo bw
            
            // get the outputstream of client
            out = new PrintWriter(clientSocket.getOutputStream(), true);
  
            // get the inputstream of client
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  
            String line;
            while ((line = in.readLine()) != null) 
            {
                // writing the received message from
                // client
                System.out.printf(" Sent from the client: %s\n",line);
                out.println(line);
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
                try 
                {
                    if (out != null) 
                    {
                        out.close();
                    }
                    
                    if (in != null) 
                    {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
        }
    }
}       
