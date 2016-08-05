import java.io.*;
import java.net.*;
import java.util.Scanner;


public class EchoServer {

	public EchoServer() {
		
	}
	public void runserver() throws IOException{
		//start server socket
		ServerSocket serversock1 = new ServerSocket(229); 
		//accept connection from client
		Socket sock1 = serversock1.accept();
		
		//read from client
		InputStreamReader ir = new InputStreamReader(sock1.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		String message = br.readLine();
		PrintStream toClient = new PrintStream(sock1.getOutputStream());
		
		//keep echoing
		while(true){
			if(message != null){
				toClient.println(message);
			}
			message = br.readLine();
		}
	
	}
	
	public static void main(String[] args) throws IOException{
		EchoServer echoserver1 = new EchoServer();
		echoserver1.runserver();
	}
}
