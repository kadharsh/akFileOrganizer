import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui implements ActionListener
{
  public static JButton b1 = new JButton("Browse");
  public static JTextField tf1 = new JTextField();
  ///////////fiels for file typs///////////////
  public static JTextField tf21 = new JTextField();
  public static JTextField tf22 = new JTextField();
  public static JTextField tf23 = new JTextField();
  public static JTextField tf24 = new JTextField();
  
  public static JButton cleanUp = new JButton("Clean Up !!!");
  public static JFrame f= new JFrame("ak File Organiser");
   
  public void button(){
    b1.addActionListener(this);
    cleanUp.addActionListener(this); 
  }
  public static void main(String[]arg) 
  { 
    Font font1 = new Font("Segoe UI",Font.PLAIN,20);
    Font font2 = new Font("Segoe UI",Font.PLAIN,18);
    gui myprog = new gui();
    myprog.button();
    //////////////////////
    f.getContentPane().setBackground(Color.decode("#8fceeb"));
   
  
   //heading
   JLabel name=new JLabel("ak File Organiser",SwingConstants.CENTER);
   name.setForeground(Color.decode("#fafafa"));
   name.setBackground(Color.decode("#5365a3"));
   name.setOpaque(true);
   name.setFont(new Font("Segoe Print",Font.PLAIN,28));
   name.setBounds(0,0,550,50);   //160,0,550,50
   f.add(name);
   //contents
   
   
   JLabel l1=new JLabel("Target Folder");
   l1.setFont(new Font("Segoe UI",Font.PLAIN,17));
   l1.setBounds(10,70,110,28);
   f.add(l1);
   
   JLabel cont1 =new JLabel("Files");
   JLabel cont2 =new JLabel("Extentions");
   cont1.setFont(font1);
   cont2.setFont(font1);
   cont1.setBounds(20,120,100,25);
   cont2.setBounds(135,120,100,25 );
   f.add(cont1);
   f.add(cont2);
   
   JLabel file1 =new JLabel("Images"); file1.setFont(font2); file1.setBounds(20,166,100,25); f.add(file1);
      tf21.setBounds(130,166,340,25);   f.add(tf21); 
      tf21.setText(".jpg .png .gif");
   JLabel file2 =new JLabel("Videos"); file2.setFont(font2); file2.setBounds(20,199,100,25); f.add(file2);
      tf22.setBounds(130,199,340,25);   f.add(tf22);    
      tf22.setText(".mp4 .mkv .avi");
   JLabel file3 =new JLabel("Docs");   file3.setFont(font2); file3.setBounds(20,232,100,25); f.add(file3);
      tf23.setBounds(130,232,340,25);   f.add(tf23);
      tf23.setText(".txt .doc .pdf");
   JLabel file4 =new JLabel("Music"); file4.setFont(font2); file4.setBounds(20,266,100,25); f.add(file4);
      tf24.setBounds(130,266,340,25);   f.add(tf24);
      tf24.setText(".mp3 .wav");
  
   tf1.setBounds(125,70,300,28);      
   f.add(tf1);
   
   b1.setBounds(430,70,80,28);
   f.add(b1);
   
   cleanUp.setBounds(25,320,480,40);
   f.add(cleanUp);
    
   f.setSize(550,420);
   f.setResizable(false);
   f.setLayout(null);
   f.setVisible(true);
    
   try{
    Image image = new ImageIcon("g866.png").getImage();
    f.setIconImage(image);
   }catch(Exception e){
    System.out.println("icon not found"); 
   }
  
  
  
  }
  public void actionPerformed(ActionEvent e)
      {
        if(e.getSource()== gui.b1){
          JFileChooser j = new JFileChooser();
        j.setCurrentDirectory(new java.io.File("C:\\Users\\adharsh\\Desktop\\downloads\\"));
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r = j.showSaveDialog(null);
        if(r== JFileChooser.APPROVE_OPTION) gui.tf1.setText(j.getSelectedFile().getPath());
        }
        if(e.getSource()== gui.cleanUp){
          ////////////////Clean Up The Files//////////////////TODO
          String path = tf1.getText();
          String img  = tf21.getText();
          String vid  = tf22.getText();
          String doc  = tf23.getText();
          String music = tf24.getText();

          fileSorter obj = new fileSorter();
         obj.startSort(path, img, vid, doc, music);        
        
        }
     }
  public static void finished(){
     JOptionPane.showMessageDialog(f,"Completed Succesfully :)");
  }
      
    
}