 package xkg;
 
 public class Personnel {
	String id;
	String name;
	String sex;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String toString(){
		return id+name+sex;
	}
	public Personnel(String id,String name,String sex){
		this.id=id;
		this.name=name;
		this.sex=sex;
	}

}
