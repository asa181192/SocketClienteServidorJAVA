
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
public class InfoCPU {
    private Sigar sigar;
    CpuInfo[] infos = null;
    CpuPerc[] cpus = null;
    CpuInfo info ;
    public InfoCPU (){
    
        sigar = new Sigar();
            try {
            infos = sigar.getCpuInfoList();
            cpus = sigar.getCpuPercList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
            info = infos[0];
    	
    }
    
   public String getFabricante () {
	return info.getVendor() ;   
   }
   
   public String getModelo () {
	return info.getModel() ;   
   }
   
   public int getMhz () {
	return info.getMhz() ;   
   } 
   public int getCores (){
	   return info.getTotalCores();
	   
   }
    }

