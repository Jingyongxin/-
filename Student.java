package xkg;

public class Student extends Personnel {

	private Subject subject;
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public void putsubject(){
		if(subject==null){
			System.out.println("��δѡ�Σ�");
		}else{
			this.toString();
			}
	}
	public String toString(){
		return "ѧ����ţ�"+id+",ѧ����"+name+",��ѡ�γ̣�"+subject;
	}

	public Student(String id, String name, String sex,Subject subject) {
		super(id, name, sex);
		this.subject=subject;
	}

	public Subject delete(){
		return subject = null;
	}

}