import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * @Autor Alfredo Santiago Alvarado 
 * 30/03/2015 
 * ----Cambios----
 * 
 */
	public class DemoCliente
		{
		public static void main(String[] args) throws Exception
			{
			InfoSO so = new InfoSO() ;
			InfoCPU cpu = new InfoCPU();
			InfoMemoria mem = new InfoMemoria();
			
			
			
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			Socket s = null;
				try
					{
					// instancio el server con la IP y el PORT
					s = new Socket("192.168.1.71",9000);
					oos = new ObjectOutputStream(s.getOutputStream());
					ois = new ObjectInputStream(s.getInputStream());
					
					//Envio las caracteriticas del equipo cliente la Servidor 
					oos.writeObject(so.getDescripcion());
					oos.writeObject(so.getSO());
					oos.writeObject(so.getArquitectura());
					oos.writeObject(cpu.getFabricante());
					oos.writeObject(cpu.getModelo());
					oos.writeObject(cpu.getMhz());
					oos.writeObject(cpu.getCores());
					oos.writeObject(mem.getMemoria());
					//Recibo las caracteristicas del equipo servidor 
					
					System.out.println("****Equipo Servidor caracteristicas***** ");
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
					System.out.println("RAM Total......"+(long)ois.readObject());;
					
					System.out.println("Se termino de enviar y recibir informacion");

					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					finally
					{
						if( ois != null ) ois.close();
						if( oos != null ) oos.close();
						if( s != null ) s.close();
					}
			}
		}