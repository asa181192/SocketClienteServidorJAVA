
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class InfoSO {
    private OperatingSystem sys = OperatingSystem.getInstance();
    
    public String getArquitectura () {
    	 return sys.getArch();
    }
    
    public String getSO () {
		return sys.getName();
    }
    public String getDescripcion () {
    	return sys.getDescription() ;
    }
}
