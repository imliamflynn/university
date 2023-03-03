import java.io.*;

public class Prog1{
    public static void main(String[]args){
        InputStream ins = System.in;
        OutputStream outs = System.out;
        try{
            int content =  0;
            while((content = ins.read()) != -1){
                outs.write(content);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
