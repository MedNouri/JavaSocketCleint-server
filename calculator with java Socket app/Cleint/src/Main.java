/**
 * Created by mohamed nouri on 14/02/2019.
 */


/*
import java.io.*;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static InetAddress host;
    private static final int PORT = 5058;


    public static void main(String[] args) throws IOException
    {


        connectToServer(1234, option);

    }

    public static void connectToServer(int port,String option){
        System.out.print("Connecting to the Server");
        try
        {
            Scanner scn = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, port);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());




            while (true)
            {
                dos.writeUTF(option);
                String tosend = scn.nextLine();
                String received = dis.readUTF();

                if(received.equals("Exit"))
                {
                    System.out.println("Closing this connection : number is Max");
                    s.close();

                    break;
                }

                // wait till request is processed and sent back to client
                String ans = dis.readUTF();
                System.out.println("Answer=" + ans);
            }


            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


*/
/**
 * Created by mohamed nouri on 14/02/2019.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {

            connectToServer();


    }

    public static void connectToServer( ){

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

// 1 -  calcul du factoriel
                if (tosend.equals("1")){
                    System.out.println(dis.readUTF());
                    String value = scn.nextLine();
                    dos.writeUTF(value);
                    System.out.println( dis.readUTF());
                    return;
                }
// 2 -  calcul du puissance
                else if (tosend.equals("2")){
                    System.out.println(dis.readUTF());
                    int x = scn.nextInt();
                    dos.writeInt(x);
                    System.out.println( dis.readUTF());
                    int Y = scn.nextInt();
                    dos.writeInt(Y);
                    System.out.println( dis.readUTF());
                    return;
                }

// 3 -  c conversion binaire en décimal
                else if  (tosend.equals("3")){
                    System.out.println(dis.readUTF());
                    String x = scn.nextLine();
                    dos.writeUTF(x);

                    System.out.println( dis.readUTF());
                    return;
                }

// 4 -
                else if  (tosend.equals("4")){
                    System.out.println(dis.readUTF());
                    int  value;
                    do {
                        System.out.print("nombre supérieur à 10000");
                         value = scn.nextInt();
                    }while (value < 10000);

                    dos.writeUTF(String.valueOf(value));
                    System.out.println( dis.readUTF());

                    return;
                }


// EXit

                else if (dis.readUTF().equals("Exit"))
                {
                    System.out.println("Closing this connection : number is Max");
                    s.close();

                    break;
                }


            }


            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


