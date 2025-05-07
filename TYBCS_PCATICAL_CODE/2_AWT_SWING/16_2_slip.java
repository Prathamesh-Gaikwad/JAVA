import java.awt.*;

class MenuBarDemo extends Frame
{
	MenuBarDemo()
	{		
		MenuBar bar = new MenuBar();
		
		Menu file = new Menu("FILE");
		Menu edit = new Menu("EDIT");
		Menu about = new Menu("ABOUT");
		
		MenuItem _new = new MenuItem("NEW   Ctrl+N");
		MenuItem open = new MenuItem("OPEN");
		MenuItem save = new MenuItem("SAVE");
		MenuItem showAbout = new MenuItem("SHOW ABOUT");
		MenuItem exit = new MenuItem("EXIT");
		
		file.add(_new);
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(showAbout);
		file.add(exit);
		
		bar.add(file);
		bar.add(edit);
		bar.add(about);
	
		setLayout(new FlowLayout());
		
		setMenuBar(bar);
		
		setSize(300, 300);
		setVisible(true);
		//setResizable(false);
		setTitle("[JAVA-AWT-EXAMPLE]");
	}
	
	public static void main(String args[])
	{
		new MenuBarDemo();
	}
}

