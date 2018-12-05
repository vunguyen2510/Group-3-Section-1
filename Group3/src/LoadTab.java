import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoadTab extends JPanel
{
  private static final long serialVersionUID = 1L;

  int num = 0;

  JButton browseBtn, processBtn;
  JComboBox<String> fileType;
  JTextField textFileField, titleTField, authorTField;
  JTextArea processTArea;

  public LoadTab()
  {
    super();
    setLayout(new BorderLayout());                 			

    JPanel north = new JPanel(new BorderLayout()); 			
    JPanel south = new JPanel(new BorderLayout()); 				
  //Create more part of north JPanel
    JPanel north1 = new JPanel(new BorderLayout());    			
    JPanel north2 = new JPanel(new BorderLayout());    		
    JPanel north3 = new JPanel(new GridLayout(1,2));   		
    //Create more part of south JPanel
    JPanel south1 = new JPanel(new BorderLayout());    			
    JPanel south2 = new JPanel(new BorderLayout());    			

    JLabel textLB = new JLabel("Text File:"); 			
    textFileField = new JTextField();                			
    // create process button and disable the text
    processBtn = new JButton("Process");             			
    processBtn.setEnabled(false);                    			
    // create Browse button
    browseBtn = new JButton("Browse");           				
    // create title label and title text field
    JLabel titleLabel = new JLabel("Title:");    				
    titleTField = new JTextField();           					
    // create author label and title text field
    JLabel authorLabel = new JLabel("Author:");  				
    authorTField = new JTextField();          					

    JLabel textTypeLB = new JLabel("Text File Type:"); 			
    fileType = new JComboBox<String>();                       	
    fileType.addItem("Project Gutenberg File");               	
    // create process button and disable the text
    processTArea = new JTextArea();            					
    processTArea.setEditable(false);           					
    
    north1.add(textLB, BorderLayout.WEST);   					// add text file label to north1, WEST
    north1.add(textFileField, BorderLayout.CENTER); 			// add text file field to north1, CENTER
    north1.add(browseBtn, BorderLayout.EAST);       			// add Browse button to north1, EAST
    north.add(north1, BorderLayout.NORTH);          			// add north1 to north, NORTH
    
    north2.add(textTypeLB, BorderLayout.WEST); 					// add text file type label to north2, WEST
    north2.add(fileType, BorderLayout.CENTER);        			// add file type combo box to north2, CENTER
    north.add(north2, BorderLayout.CENTER);           			// add north2 to north, CENTER
    
    JPanel north31 = new JPanel(new BorderLayout());  			// create north31 JPanel as part of north3
    north31.add(titleLabel, BorderLayout.WEST);       			// add title label to north31, WEST
    north31.add(titleTField, BorderLayout.CENTER); 				// add title text field to north31, CENTER
    north3.add(north31);                                  		// add north31 to north3
    
    JPanel north32 = new JPanel(new BorderLayout());   			// create north32 JPanel as part of north3
    north32.add(authorLabel, BorderLayout.WEST);       			// add author label to north32, WEST
    north32.add(authorTField, BorderLayout.CENTER); 			// add author text field to north32, CENTER
    north3.add(north32);                                   		// add north32 to north3
    north.add(north3, BorderLayout.SOUTH);             			// add north3 to north, SOUTH
    
    JPanel btnPanel = new JPanel(new GridLayout(1,2)); 			// create JPanel for Process buttons
    btnPanel.add(processBtn);                          			// add Process button to btnPanel
    south1.add(btnPanel, BorderLayout.WEST);              		// add btnPanel to south1, WEST
    south.add(south1, BorderLayout.NORTH);                 		// add south1 to south, NORTH
    
    south2.add(processTArea, BorderLayout.CENTER);      		// add process text area to south2, CENTER
    south.add(south2, BorderLayout.CENTER);                		// add south2 to south, CENTER
    
    add(north, BorderLayout.NORTH);                    			// add north to container, NORTH
    add(south, BorderLayout.CENTER);                  		 	// add south to container, CENTER
  }
}
