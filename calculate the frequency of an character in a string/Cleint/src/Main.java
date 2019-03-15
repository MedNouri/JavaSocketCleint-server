/**
 * Created by mohamed nouri on 14/02/2019.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner scn = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 5058);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true)
            {
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);
                String received = dis.readUTF();
                if(received.equals("Exit"))
                {
                    System.out.println("Closing this connection : number is Max");
                    s.close();

                    break;
                }

                System.out.println(received);
            }


            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


