
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

class Helper
{



    public static int calc(int nb) throws ArithmeticException {
        if (nb > 12 || nb < 0) {
            throw new ArithmeticException();
        } else if (nb == 0) {
            return 1;
        } else {
            return nb * calc(nb - 1);
        }
    }
    public static String calcF(String  nb)   {


        char[] chars = nb.toCharArray();
     String array[] = new String[nb.length()];
        for (int i = 0; i < nb.length(); i++  ) {
            if (i != 0 ){
                if (chars[i] == chars[i-1]) {
                //
                continue;
            }
            }
            array[i] = compterOccurrences(nb,chars[i]) + " fois pour " +  chars[i];
        }


        return Arrays.toString(array);
    }


    public static int compterOccurrences(String maChaine, char recherche)
    {
        int nb = 0;
        for (int i=0; i < maChaine.length(); i++)
        {
            if (maChaine.charAt(i) == recherche)
                nb++;
        }
        return nb;
    }
} 