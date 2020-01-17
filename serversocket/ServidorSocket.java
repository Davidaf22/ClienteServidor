package serversocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocket {
	
	public static void main(String[] args){
		try{
			System.out.println("Creando socket servidor");
	
			ServerSocket serverSocket=new ServerSocket();

			System.out.println("Realizando el bind");

			InetSocketAddress addr=new InetSocketAddress("10.0.9.133 ",5555);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");

			Socket newSocket= serverSocket.accept();

			System.out.println("Conexion recibida");

			InputStream is=newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();

			byte[] mensaje=new byte[25];
			is.read(mensaje);

			System.out.println("Mensaje recibido: "+new String(mensaje));

			System.out.println("Cerrando el nuevo socket");

			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
			}
		}
}