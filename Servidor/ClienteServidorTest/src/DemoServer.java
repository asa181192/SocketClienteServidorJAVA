import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * @autor Alfredo Santiago Alvarado 
 * 30/03/2015
 * ----Cambios----
 *  
 */

import org.hyperic.sigar.SigarException;
		public class DemoServer
			{
			public static void main(String[] args) throws Exception
			{
				InfoSO so = new InfoSO() ;
				InfoCPU cpu = new InfoCPU();
				InfoMemoria mem = new InfoMemoria();
				
				ObjectInputStream ois = null;
				ObjectOutputStream oos = null;
				Socket s = null;
				ServerSocket ss = new ServerSocket(9000);
				
					while( true )
					{
						try
						{
							// el ServerSocket me da el Socket
							System.out.println("Esperando cliente");
							s = ss.accept();
							// informacion en la consola
							System.out.println("Se conectaron desde la IP: "+s.getInetAddress());
							// enmascaro la entrada y salida de bytes
							ois = new ObjectInputStream( s.getInputStream() );
							oos = new ObjectOutputStream( s.getOutputStream() );
							System.out.println("****Equipo cliente caracteristicas***** ");
							// Leo las caracteristicas del equipo que se conecta . 
							System.out.println("-----OS-----");
							System.out.println("Descripcion......"+(String)ois.readObject());
							System.out.println("Nombre OS......"+(String)ois.readObject());
							System.out.println("Arquitectura......"+(String)ois.readObject());
							System.out.println("-----CPU------");
							System.out.println("Fabricante......"+(String)ois.readObject());
							System.out.println("Modelo......"+(String)ois.readObject());
							System.out.println("MHZ......"+(int)ois.readObject());
							System.out.println("Cores......"+(int)ois.readObject());
							System.out.println("------MEMORIA------");
							System.out.println("RAM Total......"+(long)ois.readObject());
							
							//Envio ñas caracteriticas del equipo servidor al equipo cliente 
							oos.writeObject(so.getDescripcion());
							oos.writeObject(so.getSO());
							oos.writeObject(so.getArquitectura());
							oos.writeObject(cpu.getFabricante());
							oos.writeObject(cpu.getModelo());
							oos.writeObject(cpu.getMhz());
							oos.writeObject(cpu.getCores());
							oos.writeObject(mem.getMemoria());
							
							System.out.println("Se termino de enviar y recibir informacion ");
							
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
								finally
								{
									if( oos !=null ) oos.close();
									if( ois !=null ) ois.close();
									if( s != null ) s.close();
									System.out.println("Conexion cerrada!");
									}
								}
							}
						}