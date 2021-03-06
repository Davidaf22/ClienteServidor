package calculadoraclienteservidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class CalculadoraClienteServidor {
	
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

			byte[] numero1=new byte[1];
			is.read(numero1);
                        
                        byte[] operacion =new byte[1];
			is.read(operacion);
                        
                        byte[] numero2 =new byte[1];
			is.read(numero2);
                        
                        String numero1String = new String(numero1);
                        int numero1Int = Integer.parseInt(numero1String);
                        
                        String operacionString = new String(operacion);
                        int operacionInt = Integer.parseInt(operacionString);
                        
                        String numero2String = new String(numero2);
                        int numero2Int = Integer.parseInt(numero2String);

                        int resultado = 0;
                        //1 es sumar, 2 es restar, 3 es multiplicar y 4 dividir
                       switch (operacionInt) {
                            case 1:
                                resultado = numero1Int + numero2Int;
                                break;
                            case 2:
                                resultado = numero1Int - numero2Int;
                                break;
                            case 3:
                                resultado = numero1Int * numero2Int;
                                break;
                            case 4:
                                resultado = numero1Int / numero2Int;
                                break;
                        }
                        String str1 = Integer.toString(resultado);
                        
                        os.write(str1.getBytes());
                        
                        System.out.println("Resultado enviado");
                       
			newSocket.close();

			System.out.println("Cerrando el socket servidor");

			serverSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
			}
		}
}