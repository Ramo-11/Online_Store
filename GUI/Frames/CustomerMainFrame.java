package GUI.Frames;

import java.awt.event.*;
import javax.swing.*;

import Program.*;

public class CustomerMainFrame extends JFrame implements ActionListener{

    CustomerMainFrame(String title, Customer customer) {
        super(title + ": " + customer.getName());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
