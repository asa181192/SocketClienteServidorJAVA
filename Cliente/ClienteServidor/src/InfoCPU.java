
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
public class InfoCPU {
    private Sigar sigar;
    CpuInfo[] infos = null;
    CpuPerc[] cpus = null;
    CpuInfo info = null;
    public InfoCPU (){
    
        sigar = new Sigar();
            try {
            infos = sigar.getCpuInfoList();
            cpus = sigar.getCpuPercList();
             info = infos[0];
        } catch (SigarException e) {
            e.printStackTrace();
        }
       
    	
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

