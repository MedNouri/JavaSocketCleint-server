
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

class HandelClient extends Thread
{

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    // Constructor 
    public HandelClient(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;

    }



    private String ConvertoString(String mots){

        return mots.toUpperCase();
    }

    @Override
    public void run()
    {
        String received;
        String toreturn;
        try {
            dos.writeUTF("\"\\n\" +\n" +
                    "                \"\\\"  Programme calculatrice \\\\n\\\" +\\n\" +\n" +
                    "                \"\\\"  1 -  calcul du factoriel \\\\n\\\" +\\n\" +\n" +
                    "                \"\\\"  2 -  puissance \\\\n\\\" +\\n\" +\n" +
                    "                \"\\\"  3 -  conversion binaire en décimal\\\\n\\\" +\\n\" +\n" +
                    "                \"\\\"  4 -  calcul de la fréquence \\\\n\\\" +\\n\" +\n" +
                    "                \"\\\"  5 -  type EXIT to exit\\\");\\n\");");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true)
        {
            try {






                // receive the answer from client 
                received = dis.readUTF();
if (received.equals("1")){
   // toreturn = ConvertoString(received);
    factoriel();
}

                else if (received.equals("2")){

    puissance();
}
                else if (received.equals("3")){

    Binary();
                }

else if (received.equals("4")){
    frequence();
}


else if (received.equals("5")){
    dos.writeUTF("Exit");
    System.out.println("Closing this connection number Max .");
    this.s.close();
    System.out.println("Connection closed");
    break;
}




            } catch (IOException e) {
                e.printStackTrace();
                break;
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

    private void Binary() throws IOException {
        String received;
        dos.writeUTF("S'il vous plaît entrer un nombre en binary");
        received = dis.readUTF();

        dos.writeUTF("Result = " + Integer.parseInt(received, 2 ));

    }

    private void puissance() throws IOException {
        dos.writeUTF("S'il vous plaît entrer un nombre X ");
        int X = dis.readInt();
        dos.writeUTF("S'il vous plaît entrer un nombre Y ");
        int Y  = dis.readInt() ;
        dos.writeUTF("Result = "+ Math.pow(X, Y) );

    }

    private void factoriel() throws IOException {

        dos.writeUTF("S'il vous plaît entrer un nombre");
        String received = dis.readUTF();
        int a  = Helper.calc(Integer.valueOf(received));
        dos.writeUTF("Result = "+ a );
    }

    private void frequence() throws IOException {

        dos.writeUTF("S'il vous plaît entrer un nombre");

        String received = dis.readUTF();
        String a  = Helper.calcF(received);
        dos.writeUTF("Result = "+ a );
    }
} 