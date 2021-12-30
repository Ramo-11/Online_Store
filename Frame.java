import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import Buttons.*;

public class Frame extends JFrame {
    JPanel topPanel;
    JPanel rightPanel;
    JPanel leftPanel;
    JPanel bottomPanel;

    CenterPanel centerPanel;

    Frame(String title) {
        super(title);

        setUpFrame();
        setUpPanels();
    }

    public void setUpFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setSize(1000, 800);  // width = 1000, height = 800
        this.setVisible(true);
    }
    
    public void setUpPanels() {
        topPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setPreferredSize(new Dimension(100, 100));
        rightPanel.setPreferredSize(new Dimension(10, 100));
        leftPanel.setPreferredSize(new Dimension(10, 100));
        bottomPanel.setPreferredSize(new Dimension(100, 10));

        this.add(topPanel, BorderLayout.NORTH);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(bottomPanel, BorderLayout.SOUTH);

        centerPanel = new CenterPanel();
        this.add(centerPanel, BorderLayout.CENTER);
    }
} // End class
