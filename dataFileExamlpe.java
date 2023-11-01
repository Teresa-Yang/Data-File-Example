import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.DefaultListModel;

public class dataFileExamlpe extends JFrame implements ActionListener{
  //Variable and GUIObject Declaration area 
  String fname="", lname="";
  int jersey=0;
  
  JPanel p1,p2,p3;
  JLabel fL, lL, jL;
  JButton add,remove,modify;
  JTextField usersInput;
  
  DefaultListModel model1;
  JList list1;
  JScrollPane scroll1;
  
  String [] fields;
  
  PrintWriter out=null;
  BufferedReader in=null;
  String line="A B 1"; 
  File f=new File("original.txt");
  
  public static void main(String[ ] args) 
  {
    new dataFileExamlpe();
  }  
  
  public dataFileExamlpe (){
    //Create object and your code goes heretry
    try
    {
      out=new PrintWriter(new BufferedWriter(new FileWriter(f, true)),true); 
      System.out.println("File Opening");
    }
    catch (IOException e)
    {
      System.out.println("Problem opening File");
    }
    try
    {
      in=new BufferedReader(new FileReader(f));
      System.out.println("File Opening");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Problem opening File");
    }
    model1=new DefaultListModel();
    list1=new JList(model1);
    scroll1=new JScrollPane(list1);
    
    //buttons
    p1 = new JPanel();
    p1.setLayout(new BorderLayout());
    p2=new JPanel();
    p1.add(p2);
    p2.setLayout(new GridLayout(1,3));
    add=new JButton("Add");
    add.addActionListener(this);
    p2.add(add);
    
    remove=new JButton("Remove");
    remove.addActionListener(this);
    p2.add(remove);
    
    modify=new JButton("Modify");
    modify.addActionListener(this);
    p2.add(modify);
    
//    textTield
    p3=new JPanel();
    p3.setLayout(new GridLayout(2,1));
    p3.add(p2);
    
    usersInput=new JTextField("",15);
    
    p3.add(usersInput);
    p1.add(p3,BorderLayout.NORTH);
    p1.add(scroll1);
    
//    this.add(p1);
//    fL = new JLabel("First Name:");
//    p1.add(fL);
//    fT = new JTextField("");
//    p1.add(fT);
//    lL = new JLabel("Last Name:");
//    p1.add(lL);
//    lT = new JTextField("");
//    p1.add(lT);
//    jL = new JLabel("Jersey Number:");
//    p1.add(jL);
//    jT = new JTextField("");
//    p1.add(jT);
    
    
    do
    {
      try{
        line=in.readLine();
      }
      catch (IOException e)
      {
        System.out.println("Problem reading data from file");
      }
      
      if (line!=null)
      {
      model1.addElement(line);
//        fields=line.split(",");
//        fname=fields[0];
//        lname=fields[1];
//        readjersey=Integer.parseInt(fields[2]);
//        
//        System.out.println(line);
//        System.out.println(fname);
//        System.out.println(lname);
//        System.out.println(""+readjersey);
      }
    }while (line!=null);
    
    try
    {
      in.close();
      System.out.println("Closing File");
    }
    catch (IOException e)
    {
      System.out.println("Problem Closing "+e);
    }
    
    this.add(p1);
    this.setSize(500,200);
    this.setVisible(true);
  } 
  
  
  
  
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==remove)
    {
      int index = list1.getSelectedIndex();
      if (index!=-1)
      {
        model1.remove(index);
      }
    }
    if(e.getSource()==add)
    {
      line = fname+","+lname+","+jersey;
      
      fields=line.split(",");
      fname=fields[0];
      lname=fields[1];
      jersey=Integer.parseInt(fields[2]);
      out.println(fname+","+lname+","+jersey);
      
      model1.addElement(usersInput.getText());
      usersInput.setText("");
    }
    
    
    
//    if (e.getSource()==add)
//    {
//      fname = fT.getText();
//      lname = lT.getText();
//      jersey = jT.getText();
//      
//      line = fname+","+lname+","+jersey;
//      out.println(line);
//    }
//    else if(e.getSource()==read)
//    
  }
}