import java.io.*;

public class Caesar{
    public static void main(String[]args){
        InputStream in = System.in;
        OutputStream out = System.out;
        int shift = Integer.parseInt(args[0]);
        int i = 0;
        try{
            while ((i = in.read()) != -1){
                i = (i + shift) % 255;
                out.write(i);
            }
            out.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}