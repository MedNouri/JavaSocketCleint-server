
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

class ClientHandler extends Thread
{

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    int compteurdemots ;


    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos,int compteurdemots)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.compteurdemots = compteurdemots ;
    }



    private String ConvertoString(String mots){

        return mots.toUpperCase();
    }

    @Override
    public void run()
    {
        String received;
        String toreturn;

        while (true)
        {
            try {

                dos.writeUTF("Ecrire vos mots \n");

                // receive the answer from client 
                received = dis.readUTF();
                compteurdemots--;


                if(compteurdemots <= 0)
                {
                    dos.writeUTF("Exit");
                    System.out.println("Closing this connection number Max .");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
                toreturn = ConvertoString(received);
                dos.writeUTF("YOUR WORD IS "+"  Number   "+compteurdemots+toreturn);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try
        {
            // closing resources 
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
} 