package clientesocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {
	
	public static void main(String[] args){
		try{
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			
			InetSocketAddress addr=new InetSocketAddress("10.0.9.133",5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");
                        System.out.println("Conexión establecida");
                       
                        System.out.print("Introduzca el primer numero: ");
                        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
                        String numero1 = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
			os.write(numero1.getBytes());
                        System.out.println();
                        System.out.println("Para sumar teclee 1");
                        System.out.println("Para restar teclee 2");
                        System.out.println("Para multiplicar teclee 3");
                        System.out.print("Para dividir teclee 4: ");
                        
                        Scanner entradaEscaner2 = new Scanner (System.in); //Creación de un objeto Scanner
                        String opeacion = entradaEscaner2.nextLine (); //Invocamos un método sobre un objeto Scanner
                        os.write(opeacion.getBytes());
                        
                        System.out.println();
                        System.out.print("Introduzca el segundo numero: ");
                        Scanner entradaEscaner3 = new Scanner (System.in); //Creación de un objeto Scanner
                        String numero2 = entradaEscaner3.nextLine (); //Invocamos un método sobre un objeto Scanner
			os.write(numero2.getBytes());
                        
                        byte[] resultado = new byte[25];
                        is.read(resultado);
                        
                        System.out.println("El resultado de la operación es: "+new String(resultado));
                        

			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
				e.printStackTrace();
			}
	}
}	