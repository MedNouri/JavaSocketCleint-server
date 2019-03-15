import java.io.*;
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



    protected   boolean isPalindrom(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
    protected String frequence(String str){


        char ch = str.charAt(0);
        int frequency = 0;

        for(int i = 0; i < str.length(); i++) {
            if(ch == str.charAt(i)) {
                ++frequency;
            }
        }

        return "Frequency of " + ch + " = " + frequency;


    }
    private String ConvertoString(String mots){

        return mots.toUpperCase();
    }

    @Override
    public void run()
    {
        String received;
        String toreturn;
        String toreturn2;

            try {

                dos.writeUTF("Ecrire vos mots \n");

                // receive the answer from client 
                received = dis.readUTF();




                toreturn = ConvertoString(String.valueOf(isPalindrom(received.toCharArray())));
                toreturn2 = ConvertoString(frequence(received));
                dos.writeUTF( toreturn);
                dos.writeUTF( toreturn2);
            } catch (IOException e) {
                e.printStackTrace();
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