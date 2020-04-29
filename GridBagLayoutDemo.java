package course;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
class MyFrame extends JFrame{
	public MyFrame() {
		 setTitle("学生选课系统");  	 
         setSize(600,600);
         setVisible(true);
	}
}
class MyWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		Window window=(Window)e.getComponent();
		window.dispose();
		
	}
}
/*class MyActionListener implements ActionListener{
	
	private TextField textField;
	public MyActionListener(TextField textField) {
		this.textField = textField;
	}
	public void actionPerformed(ActionEvent event) {
			textField.setText("您未选课！");
	}
	
}*/
public class GridBagLayoutDemo implements ActionListener {
    public static void main(String args[]) throws IOException {
    	GridBagLayoutDemo demo = new GridBagLayoutDemo();
    } 
    public GridBagLayoutDemo() throws IOException{
    	f = new MyFrame();
        j2 = new JButton("选课");
        j3 = new JButton("退课");
        j4 = new JPanel();
        String[] str1 = { "大学语文", "高等数学", "大学英语" };
        String[] str2 = { "信息工程学院", "机械工程学院", "经济管理学院" };
        j5 = new JComboBox(str1);
        j10 = new JLabel("姓名：");
        j6 = new JTextField();
        j7 = new JButton("清除");
        j8 = new JList(str2);
        j9 = new TextField();
        j9.setBackground(Color.ORANGE);
        //myActionListener =new MyActionListener(j9);
        j2.addActionListener(this);
        j3.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
				try {
					String bname=j6.getText();
				    String bsubject=(String)j5.getSelectedItem();
					j9.setText(bname+" 您未选课！ " );				
					def = new StringBuffer(4096);
					abc = null;
					br = new BufferedReader(new FileReader(f1)); 
					while((abc = br.readLine())!= null){ 
					       if ((abc.indexOf(bname))==-1) {
					    	   def.append(abc).append("\r\n");
						}       
					} 
					br.close(); 
					bw = new BufferedWriter((new FileWriter(f1))); 
					bw.write(def.toString()); 
					bw.close();
				} catch (IOException e) {
					System.out.println("传输错误！");
				}
			}
        });
     
        
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(j5);
        f.add(j10);
        f.add(j6);
        f.add(j7);
        f.add(j8);
        f.add(j9);
        GridBagConstraints s= new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridwidth=1;s.weightx = 0;s.weighty=0;
       

        layout.setConstraints(j2, s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j3, s);
        s.gridwidth=0;s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j4, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j5, s);
        s.gridwidth=4;
        s.weightx = 1;
        s.weighty=0;
        layout.setConstraints(j6, s);
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j7, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j8, s);
        s.gridwidth=5;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j9, s);
        f.addWindowListener(new MyWindow());
    }
    
    JButton j1;
    JButton j2;
    JButton j3;
    JPanel j4;
    JComboBox j5;
    JTextField j6;
    JButton j7;
    JList j8;
    TextField j9;
    JLabel j10;
    Teacher teacher;
    Subject subject;
    Student student;
    MyFrame f ;
    File f1= new File("C:\\Users\\lenovo\\Desktop"+File.separator+"选课.txt"); 
	FileWriter out;
	BufferedReader br;
	BufferedWriter bw ;
	String abc;
	StringBuffer def ;
	
 //   MyActionListener myActionListener;

	public void actionPerformed(ActionEvent event) {
		String name = j6.getText();
		String asubject =(String)j5.getSelectedItem();
		System.out.println(asubject);
		teacher=new Teacher("0066", "张世博", "男");
		subject=new Subject("1111", asubject, "综合楼","周四13:00-15:05",3,teacher);
		student=new Student("2019322031",name, "男",subject);	   
      	j9.setText(" "+student);	
      	try {
    	    	out=new FileWriter(f1,true);
    	    	out.write("  "+student.getName()+"  "+student.getSubject()+"\n");
    	    	out.flush();
    	    	out.close();
			} catch (IOException e) {
				System.out.println("文件传输错误");
			}
		
	}
    
}