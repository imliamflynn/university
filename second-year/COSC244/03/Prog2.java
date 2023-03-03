import java.io.*;
import java.util.*;

public class Prog2{
    public static void main(String[]args){;
        BufferedReader buff = new
            BufferedReader(new InputStreamReader(System.in));
        OutputStream outs = System.out;
        StringBuilder str;
        try{
            String content;
            while((content=buff.readLine()) != null){
                str = new StringBuilder(content).reverse();
                System.out.println(str);
               
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
