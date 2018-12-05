import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//TODO Delete all imports at the end and then add them one by one because dark voodoo reasons
public class Gui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu options;
	private JMenu help;
	private ImageIcon icon;
	Container contentPane;
	private JPanel mainContent;
	
	JTabbedPane tabbedPane;
	public LoadTab loadTab;
	public SearchTab searchTab;
	
	public static void main(String[] args) {
		JFrame gui = new Gui();
	}
	
	public Gui()
	{
		super("Pirex");
		contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(new BorderLayout());
		this.setSize(650, 400);
		
		//setIcon();
		setupMenu();			
		// create a JTabbedPane object
	    tabbedPane = new JTabbedPane();
	    
	    searchTab = new SearchTab();
	    loadTab = new LoadTab();
	    
		// add each tab object to JTabbedPane
	    tabbedPane.addTab("Search for Documents", searchTab);
	    tabbedPane.addTab("Load Documents", loadTab);
	    //tabbedPane.addTab("Summarize Documents");

	    getContentPane().add(tabbedPane);
		this.setVisible(true);
	}
	/*
	private void setIcon() {
		try {
			icon = new ImageIcon(ImageIO.read(new File("assets/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setIconImage(icon.getImage());
	}
	*/
	private void setupMenu() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		JMenuItem saveQuery = new JMenuItem("SaveQR");
		JMenuItem loadQuery = new JMenuItem("LoadQR");
		options = new JMenu("Options");
		JMenuItem sources = new JMenuItem("Sources");
		JMenuItem documents = new JMenuItem("Documents");
		help = new JMenu("Help");
		JMenuItem index = new JMenuItem("Index");
		JMenuItem about = new JMenuItem("About");
		
		about.addActionListener((event) -> JOptionPane.showMessageDialog(null, "Made by Group 3"));
		file.add(saveQuery);
		file.add(loadQuery);
		help.add(index);
		help.add(about);
		options.add(sources);
		options.add(documents);
		
		menuBar.add(file);
		menuBar.add(options);
		menuBar.add(help);
		getContentPane().add(menuBar, BorderLayout.NORTH);
	}
}
