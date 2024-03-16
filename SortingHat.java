
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class SortingHat implements ActionListener  {
    //Field
    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private ImageIcon icon;


    public SortingHat(){
        // Frame 
        frame = new JFrame();
        frame.setTitle("4 King Sorting Hat");
        frame.setResizable(false);
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Image
        icon = new ImageIcon("image2.png");

        
        // set Icon
        frame.setIconImage(icon.getImage());
        

        // Lebel
        label = new JLabel("Enter Number of student"){

            // Back Group
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage image = ImageIO.read(new File("image.png"));
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        label.setForeground(Color.black);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);


        // TextField

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100,30));
        textField.setBounds(290,25,200,30);


        // Input Number of Student(ONLY INTEGER)

        textField.addKeyListener(new KeyAdapter(){
         public void keyPressed(KeyEvent ke) {
            String value = textField.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' ) {
               textField.setEditable(true);
               label.setText("");
            } else {
               textField.setEditable(false);
               label.setText("* Enter only numeric digits(0-9)");
            }
        }     
      });



        // Button

        button = new JButton("Next");
        button.setBounds(350, 76, 80, 30);
        button.addActionListener(this);


        // ADD and OTHER
        
        frame.add(button);
        frame.add(textField);
        frame.add(label);
        frame.setVisible(true);
    }

    // Action when Click button
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            frame.dispose();
            int num_student = Integer.parseInt(textField.getText()) ;
            SortingHat_second_GUI SortingHat_second_GUI = new SortingHat_second_GUI(num_student);    
        }
    }

    //_________________________//
    //           MAIN          //
    //__________________________//
    public static void main(String[] args) {
        new SortingHat();
    }
    
}
