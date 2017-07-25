import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yahva on 05.07.2017.
 */
public class Client {

    public static void main(String[] args) throws IOException {

        args[0]="localhost";
        final int PORT=5555;

        Socket socketClient = null;

        System.out.println("Starting Client");

        if(args[0].length()==0){
            System.out.println("Use don not localhost");
            System.exit(-1);
        }

        System.out.println("Connection to "+args[0]);

        socketClient = new Socket(args[0],PORT);

        BufferedReader in= new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        PrintWriter out = new PrintWriter(socketClient.getOutputStream(),true);
        BufferedReader in_this=new BufferedReader(new InputStreamReader(System.in));

        String inputS,inputC;

        while ((inputC=in_this.readLine())!=null){
            if(inputC.equalsIgnoreCase("exit")){
                break;
            }

            out.println(inputC);//Setnd from Client
            inputS=in.readLine();//Reading date from Server
            System.out.println("From Server: "+inputS);
        }

        in.close();
        out.close();
        in_this.close();
        socketClient.close();


    }
}
