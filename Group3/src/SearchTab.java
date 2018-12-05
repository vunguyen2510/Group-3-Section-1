import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class SearchTab extends JPanel
{
  private static final long serialVersionUID   = 1L;

  JButton                  searchBtn, clearTabBtn;
  JTextField               queryTField;
  DefaultListModel<String> defaultList;
  JList<String>            queryRList;
  JTextArea                queryRText, selectedText;
  JLabel                   seperateBar;
  
  public SearchTab()
  {
    super();
    setLayout(new BorderLayout());                

    JPanel north = new JPanel(new BorderLayout()); 
    JPanel mid   = new JPanel(new BorderLayout()); 
    JPanel south = new JPanel(new BorderLayout()); 
    
    JPanel bottom = new JPanel(new GridLayout(2,1));  
    
    JLabel queryLabel = new JLabel("Query");   											
    clearTabBtn = new JButton("Clear");  												
    // create the query result text Text Area and disable the text
    queryRText = new JTextArea();        												
    queryRText.setEditable(false);        												
    // create a break between two text area
    seperateBar = new JLabel("\n"); 													
    
    defaultList = new DefaultListModel<String>();    
    queryRList = new JList<String>(defaultList); 

    queryRList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 			// set JList selection model
    queryRList.setLayoutOrientation(JList.VERTICAL);                           			// set JList orientation

    JScrollPane scroll = new JScrollPane(queryRList);                           		// create JScrollPane for JList
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);     	// set vertical scroll bar
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 	// set horizontal scroll bar
    
    selectedText = new JTextArea();                                            			// create selected text area JTextArea
    selectedText.setEditable(false);                                               		// disable editing
    JScrollPane scroller = new JScrollPane(selectedText);                          		// create JScrollPane for text area
    scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);     	// set vertical scroll bar
    scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 	// set horizontal scroll bar
    
    searchBtn = new JButton("Search");            										// create Search JButton
    queryTField = new JTextField();
    
        
    JPanel btnPanel = new JPanel(new GridLayout(1,2));  
    btnPanel.add(searchBtn);                                 							// add Search button to btnPanel
    btnPanel.add(clearTabBtn);                         									// add Clear button to btnPanel

    north.add(queryLabel, BorderLayout.WEST);                							// add queryLabel to north, WEST
    north.add(queryTField, BorderLayout.CENTER);          								// add queryTField to north, CENTER
    north.add(btnPanel, BorderLayout.EAST);                  							// add btnPanel to north, EAST
    
    mid.add(scroll, BorderLayout.CENTER);                    							// add scroll to mid, CENTER
    mid.add(seperateBar, BorderLayout.SOUTH);             								// add seperateBar to mid, SOUTH
    
    south.add(scroller, BorderLayout.CENTER);                							// add scroller to south, CENTER
    
    bottom.add(mid);                                            						// add mid to bottom
    bottom.add(south);                                          						// add south to bottom
    
    add(north, BorderLayout.NORTH);                          							// add north to container, NORTH
    add(bottom, BorderLayout.CENTER);                           						// add bottom to container, CENTER
  }
}