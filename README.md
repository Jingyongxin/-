 计G191 2019322176 静永鑫
## 综合性实验 学生选课系统设计

## 实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常

## 实验内容与要求

系统角色分析及类设计

学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。从简化系统考虑，每名教师仅教授一门课程，每门课程的授课教师也仅有一位，每名学生选仅选一门课程。
## 具体实验要求

1.设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。 

2.基于事件模型对业务逻辑编程，实现在界面上支持上述操作。

3.针对操作过程中可能会出现的各种异常，做异常处理。

4.基于输入/输出编程，支持学生、课程、教师等数据的读写操作。

5.基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。
 ## 实验过程

## 角色分析与类设计

1.设计Personnel类（人员类）
声明编号、姓名、性别变量。
2.设计Teacher类（教师类）
继承Personnel类，获得编号、姓名、性别变量，调用Subject类， 使用toString() 方法将“"老师编号："+id+",老师："+name+",性别："+sex ”转为字符串返回结果。
```java
public class Teacher extends Personnel {
	Subject subject;
	public String toString(){
		return "老师编号："+id+",老师："+name+",性别："+sex;
	}
	public Teacher(String id, String name, String sex) {
		super(id, name, sex);
	}
}
```
3.设计Student类（学生类）
继承Personnel类，获得编号、姓名、性别变量，调用Subject类，进行选课、退课操作，使用toString() 方法将“"学生编号："+id+",学生："+name+",所选课程："+subject;”转为字符串返回结果。
```java
public void putsubject(){
		if(subject==null){
			System.out.println("您未选课！");
		}else{
			this.toString();
			}
	}
	public String toString(){
		return "学生编号："+id+",学生："+name+",所选课程："+subject;
	}

	public Student(String id, String name, String sex,Subject subject) {
		super(id, name, sex);
		this.subject=subject;
	}
	public Subject delete(){
		return subject = null;
	}
```
4.设计Subject类（课程类）
声明编号、课程名称、上课地点、时间和学分变量，调用Teacher类，使用toString() 方法将“"课程编号："+id+",课程名："+name+",地点："+place+",时间："+time+",学分："+mark+",老师信息："+teacher;”转为字符串返回结果。

# GUI窗体设计

1.界面设计
采用“GridBagLayoutDemo”进行二次开发，设置j2、j3为“选课、退课（开课、关课）”按钮，设置j5下拉列表为课程名称，设置j6文本框获取学生、老师姓名，，设置j9文本框为课程信息输出。（下以教师管理为例）

```java
d = new MyFrame();
j2 = new JButton("开课");
j3 = new JButton("关课");
j4 = new JPanel();
String[] str1 = { "大学语文", "高等数学", "大学英语" };
String[] str2 = { "信息工程学院", "机械工程学院", "经济管理学院" };
j5 = new JComboBox(str1);
j10 = new JLabel("姓名：");
j6 = new JTextField();
j7 = new JButton("清除");
j8 = new JList(str2);
j9 = new TextField();
```
	
2.事件驱动
定义j2（开课）按钮为事件源，j2注册监听器对象actionPerformed，actionPerformed实现ActionEvent event响应操作为j9输出开课信息， ActionEvent event中教师名获取j6文本框输入的文本，课程名获取j5下拉文本。
```java
j2.addActionListener(this);//注册监听器
public void actionPerformed(ActionEvent event) {//指定监听器实现方法
		String name = j6.getText();//获取j6文本框输入的文本赋给 name教师名
		String asubject =(String)j5.getSelectedItem(); //获取j5下拉文本赋给asubject课程名
		System.out.println(asubject);
		teacher=new Teacher("0066",name, "男");   
		subject=new Subject("1111",asubject, "综合楼","周四13:00-15:05",3,teacher);
      	    j9.setText(" "+subject);//j9文本显示输出	
		
	}
    
}
```

定义j3（退课）按钮为事件源，j3注册监听器对象MyActionListener，定义MyActionListener实现ActionListener接口响应操作为j9输出关课文本。
```java
myActionListener =new MyActionListener(j9);//创建监听器
j3.addActionListener(myActionListener);
class MyActionListener implements ActionListener{//定义监听器类
	
	private TextField textField;
	public MyActionListener(TextField textField) {
		this.textField = textField;
	}
	public void actionPerformed(ActionEvent event) {
			textField.setText("已成功关课！");//响应操作
	}
	
}
MyActionListener myActionListener;
```
## 基于文件保存并读取数据（以选、退课为例）

1.声明文件流相关属性和字符缓存器
```java
        File f1= new File("C:\\Users\\lenovo\\Desktop"+File.separator+"选课.txt"); //文件路径及名称
	FileWriter out;//字符数据的写入
	BufferedReader br;//字符的读取
	BufferedWriter bw ;//字符数据的缓存写入
	
	String abc;
	StringBuffer def ;//缓存器
```

2.选课流程
将选课输出内容写入“选课.txt”文件，输入每名学生信息后换行，并设计异常。
	```java
	try {
    	    	out=new FileWriter(f1,true);
    	    	out.write("  "+student.getName()+"  "+student.getSubject()+"\n");
    	    	out.flush();
    	    	out.close();
			} catch (IOException e) {
				System.out.println("文件传输错误");
			}
	```
3.退课流程
读取文件每一行数据逐次放入缓存，缓存中的一行数据与姓名、课程对比，相同则该行数据不写入文件，不同则写入文件，直到缓存读取到文件数据为空停止，并设计异常。
```java
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
```
#流程图

呀！没加载出来

## 实验结果

## 选课操作

呀！没加载出来

选课后“选课.txt”内保存的数据

呀！没加载出来

退课操作

呀！没加载出来

退课后“选课.txt”内保存的数据

呀！没加载出来

实验感悟

通过本学期的多次实验，让我掌握了Java基本语法，学会了图像界面的设计，掌握了字符串String及其方法的使用和添加异常处理。
基本上实现了学生选课系统的设计，虽然有些简陋和不完善，但也是这一学期学习的成果和展现，让我深刻明白在书本上学再多不如动手做一做。
但是通过这一学期对Java的学习，还是觉得Java有些难，只有C语言基础的我在Java学习上有些困难，不过通过同学的帮助还是能跟得上节奏，
以后学习之余我会多看看Java的相关资料，至少不会忘了这学期所学的知识。
