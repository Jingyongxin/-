package xkg;

public class Subject{
	String id;
	String name;
	String place;
	String time;
	int mark;
    Teacher teacher;
	
	public String toString(){
		return "�γ̱�ţ�"+id+",�γ�����"+name+",�ص㣺"+place+",ʱ�䣺"+time+",ѧ�֣�"+mark+",��ʦ��Ϣ��"+teacher;
	}
	public Subject(String id,String name,String place,String time,int mark,Teacher teacher){
		this.id = id;
		this.name = name;
		this.place = place;
		this.time = time;
		this.mark = mark;
		this.teacher = teacher;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
/*	public Teacher getteacher() {
		return teacher;
	}
	public void stitcher(Teacher teacher) {
		this.teacher = teacher;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
}