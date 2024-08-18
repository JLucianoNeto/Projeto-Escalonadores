/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.escalonadoresso;


import java.lang.management.ManagementFactory;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author LucianoNeto
 */
public class MedirUsos {
    

    private static final long KB = 1024;
    private static final long MB = 1024 * KB;
    private static final long GB = 1024 * MB;
    private static final long TB = 1024 * GB;
    private static final com.sun.management.OperatingSystemMXBean OS_BEAN = 
            (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public static void log(Object message) {
        System.out.println(message);
    }

    private static String formatDouble(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("PT", "BR"));
        nf.setMaximumFractionDigits(2);
        return nf.format(d);
    }

    private static String formatBytes(long b) {
        return b >= TB ? formatDouble(b / (double) TB) + " TB"
                : b >= GB ? formatDouble(b / (double) GB) + " GB"
                : b >= MB ? formatDouble(b / (double) MB) + " MB"
                : b >= KB ? formatDouble(b / (double) KB) + " KB"
                : b + " bytes";
    }

    public static String printMemoryUsage() {
        
        long total = OS_BEAN.getTotalMemorySize();
        long free = OS_BEAN.getFreeMemorySize();
        long used = total - free;
        
        /*
        System.out.println("Total Memory: " + formatBytes(total));
        System.out.println("Memory Used: " + formatBytes(used));
        System.out.println("Memory Free: " + formatBytes(free));
        System.out.println("Percent Used: " + formatDouble(100 * used / (double) total) + "%");
        System.out.println("Percent Free: " + formatDouble(100 * free / (double) total) + "%");
        */
        return Long.toString(used);
}


    public static void printProcessorUsage() {
        int cpuCount = OS_BEAN.getAvailableProcessors();
        double load = OS_BEAN.getCpuLoad();
        
        String formattedLoad = load >= 0 ? formatDouble(load * 100) + "%" : "unknown";
        log("With " + cpuCount + " CPUs usage is " + formattedLoad + ".");
    }

    
}

