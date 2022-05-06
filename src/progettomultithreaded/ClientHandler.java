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

/**
 *
 * @author loren
 */
public class ClientHandler implements Runnable
{
    private final Socket clientSocket; //oggetto client socket //final(classe diviene una costante. Un metodo dichiarato final non può essere riscritto in una sottoclasse.)
    BufferedWriter bw; //write
    BufferedReader br; //read
    
    // Constructor
    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }
    
    public void run()
    {
        //PrintWriter out = null;
        //BufferedReader in = null;
        
        BufferedWriter bw; //write
        BufferedReader br; //read
        
        try 
        {
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // inizializzo br
            bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); // inizializzo bw
            
            
            
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
