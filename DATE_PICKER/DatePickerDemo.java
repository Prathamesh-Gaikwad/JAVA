import java.awt.*;
import javax.swing.*;
//import org.jdatepicker.impl.UtilDateModel;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.*;

class DatePickerDemo
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame();
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

		frame.add(datePicker);
		
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

