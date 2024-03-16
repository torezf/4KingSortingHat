

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SortingHat_second_GUI implements ActionListener {
    private JFrame frame ;
    private JScrollPane scrollPane;
    private JLabel label;
    private JButton button;
    private JTextField textField;
    private JTextArea resultArea;
    private ImageIcon icon;
    private Font font;


    private static int num_student;
    private static int houseindex=0;
    private ArrayList<ArrayList<String>> house;


    public SortingHat_second_GUI(int num_student){
         
        this.num_student = num_student;
        house = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            house.add(new ArrayList<>());
        }
    

        //Frame
        frame = new JFrame("4 King Sorting Hat");
        frame.setSize(800, 700);
        frame.setResizable(false);

        //Image
        icon = new ImageIcon("image2.png");
        frame.setIconImage(icon.getImage());

        // TextField
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100,30));
        textField.setBounds(290,25,200,30);

        // Label
        label = new JLabel("Enter Name of student"){

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
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
       

        //Button
        button = new JButton("Submit");
        button.setBounds(350, 76, 80, 30);
        button.addActionListener(this);

        //TextArea
        resultArea = new JTextArea(10,20);
        resultArea.setEditable(false);
        resultArea.setBounds(150,150,500,400);
        resultArea.setBackground(Color.BLACK);
        resultArea.setForeground(Color.white);

        scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(150,150,500,400);

        //Font and set
        font = new Font("Arial", Font.BOLD, 16);
        resultArea.setFont(font);

        // Add and Other
        frame.add(textField);
        frame.add(button);
        frame.add(scrollPane);
        frame.add(label);
        
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
    //-------------------------//
    // Action when press Button//
    //------------------------//


    public void actionPerformed(ActionEvent e) {
      
        // Add to Arraylist
        
        house.get(houseindex%4).add(textField.getText());
        houseindex++;
        

        if(num_student==1){

        // ALL Invisible
        button.setVisible(false);
        textField.setVisible(false);
        label.setText("List of Student");
        label.setFont(font);
        //result
        Displayresult();

        }
        else{
            num_student-=1;
            label.setText(num_student+" Remaining");
            textField.setText("");
        }
    }





    // Divide people into 4 houses
    public void Displayresult(){
        resultArea.append("Pracha Chuen :\n");
        for(int i=0;i<house.get(0).size();i++){
            resultArea.append(i+1+". "+house.get(0).get(i)+"\n");
        }
        resultArea.append("--------------------------\n");
        resultArea.append("\n");

        resultArea.append("Indara :\n");
        for(int i=0;i<house.get(1).size();i++){
            resultArea.append(i+1+". "+house.get(1).get(i)+"\n");
        }  
        resultArea.append("--------------------------\n");
        resultArea.append("\n");

        resultArea.append("Kanok Chiwa :\n");
        for(int i=0;i<house.get(2).size();i++){
            resultArea.append(i+1+". "+house.get(2).get(i)+"\n");
        }  
        resultArea.append("--------------------------\n");
        resultArea.append("\n");
        
        resultArea.append("Boranapon :\n");
        for(int i=0;i<house.get(3).size();i++){
            resultArea.append(i+1+". "+house.get(3).get(i)+"\n");
        }  
        resultArea.append("--------------------------\n");
        resultArea.append("\n");
    }


}

   
    
    

    




  
    

