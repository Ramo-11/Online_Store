import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Frame extends JFrame implements ActionListener {
    JButton adminButton;
    JButton userButton;

    Frame() {
        adminButton = new JButton("Admin Log in");
        userButton = new JButton("User Log in");

        setUpAdminButton();
        setUpUserButton();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(800,600);  // width = 800, height = 600
        this.setVisible(true);
        this.add(adminButton);
        this.add(userButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adminButton)
            System.out.println("Admin log in");

        else if(e.getSource() == userButton)
            System.out.println("User log in");
    }

    public void setUpAdminButton() {
        ImageIcon adminButtonIcon = new ImageIcon("Images/adminIcon.png");

        adminButton.setBounds(500, 300, 150, 60);
        adminButton.addActionListener(this);
        adminButton.setFocusable(false);    // Removes highlight on text
        adminButton.setForeground(Color.darkGray);  //set text color
        adminButton.setBackground(Color.lightGray);
        adminButton.setBorder(BorderFactory.createEtchedBorder());
        adminButton.setIcon(adminButtonIcon);
    }

    public void setUpUserButton() {
        ImageIcon userButtonIcon = new ImageIcon("Images/userIcon.png");

        userButton.setBounds(100, 300, 150, 60);
        userButton.addActionListener(this);
        userButton.setFocusable(false); // Removes highlight on text
        userButton.setForeground(Color.darkGray);   //set text color
        userButton.setBackground(Color.lightGray);
        userButton.setBorder(BorderFactory.createEtchedBorder());
        userButton.setIcon(userButtonIcon);
    }
} // End class
