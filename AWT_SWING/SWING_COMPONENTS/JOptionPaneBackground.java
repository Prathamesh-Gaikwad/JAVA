import java.awt.*;
import java.util.*;
import javax.swing.*;

public class JOptionPaneBackground {

    public static void main(String[] args) throws Exception 
    {
	 UIManager um=new UIManager();
	 um.put("OptionPane.background",Color.white);
	 um.put("Panel.background",Color.white);

        // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //UIDefaults uiDefaults = UIManager.getLookAndFeelDefaults();
        /*java.util.List<Object> keys = new ArrayList<Object>(uiDefaults.keySet());
        Collections.sort(keys, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String)o2);
            }
        });
        for (Object key : keys) {
            System.out.println(String.format("%-40s = %s", key, uiDefaults.get(key)));
        }
        */
        //UIManager.put("OptionPane.background", Color.BLACK);
        //UIManager.put("Panel.background", Color.WHITE);
        
        JOptionPane.showConfirmDialog(null, "Hello World!");
    }
}


