package xkg;

public class Teacher extends Personnel {
	Subject subject;
	public String toString(){
		return "老师编号："+id+",老师："+name+",性别："+sex;
	}
	public Teacher(String id, String name, String sex) {
		super(id, name, sex);
	}
}
