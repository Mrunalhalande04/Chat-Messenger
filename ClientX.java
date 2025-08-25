import java.io.*;
import java.net.*;

class ClientX
{
    public static void main(String Arg[]) throws Exception
    {
        System.out.println("Client is ready to coonect with server");

        Socket sobj = new Socket("localhost",2100);  
        System.out.println("Client is succesfully connect with server");


        PrintStream pobj = new PrintStream(sobj.getOutputStream());  

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));    
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));  

        System.out.println("----------------------------------------------------");
        System.out.println("Chat messanger is ready to use");
        System.out.println("----------------------------------------------------");
    
        String str1 = null, str2 = null; 

        while(!(str1 = bobj2.readLine()).equals("end"))
        {
            pobj.println(str1);
            str2 = bobj1.readLine();
            System.out.println("Server says : "+str2);
            System.out.println("Enter message for server : ");
        }

        pobj.println("end");

        System.out.println("Thank you for using chat Application");

    }
}

