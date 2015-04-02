
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
public class InfoMemoria {
    private Sigar sigar = new Sigar();
    Mem memoria ;
    public InfoMemoria () throws SigarException {
     memoria = sigar.getMem();
    }

    
   public long getMemoria ()  {
	   return memoria.getRam () ;
   }
 
}
