package model;

import javax.persistence.*;

@Entity
@Table(name="Student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student {
	int sid;
	String sname;
	int age;
	public Student() {}
	public Student(int sid, String sname, int age) {
		this.sid = sid;
		this.sname = sname;
		this.age = age;
	}
	@Id
	@Column(name="sid")
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
