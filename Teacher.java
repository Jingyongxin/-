package xkg;

public class Teacher extends Personnel {
	Subject subject;
	public String toString(){
		return "��ʦ��ţ�"+id+",��ʦ��"+name+",�Ա�"+sex;
	}
	public Teacher(String id, String name, String sex) {
		super(id, name, sex);
	}
}
