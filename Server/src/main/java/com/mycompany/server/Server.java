/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.server;

import java.io.*;
import java.net.*;

/**
 *
 * @author Haris
 */
public class Server {

    public static void main(String[] args) {
        int host=3000;
        String odgovor,odgovori[];
        String licnost;
        try{
        ServerSocket server=new ServerSocket(host);
        Socket veza=server.accept();
        System.out.println("Veza je uspostavljena");
        DataInputStream dIn=new DataInputStream(veza.getInputStream());
        DataOutputStream dOut=new DataOutputStream(veza.getOutputStream());
                while(true){
                    odgovor=dIn.readUTF();
                    odgovori=odgovor.split(",");
                    if(odgovori[0].equals("Da") && odgovori[1].equals("Da"))
                    {
                    licnost="introvetna licnost";
                    }
                    else if(odgovori[0].equals("Da") && odgovori[1].equals("Ne"))
                    {
                    licnost="ekstrovertna licnost";
                    }
                    else if((odgovori[0].equals("Ne") && odgovori[1].equals("Da")) || (odgovori[0].equals("Da") && odgovori[1].equals("Ne")))
                    {
                    licnost="umerena licnost";
                    }
                    else
                    {
                    licnost="POGRESNI ODGOVORI";
                    }
                    dOut.writeUTF(licnost);

                }
          } 
        catch(Exception e)
        {
            
        }
        
    }
}
