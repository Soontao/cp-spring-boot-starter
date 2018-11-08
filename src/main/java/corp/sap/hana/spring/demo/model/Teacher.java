package corp.sap.hana.spring.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Teacher extends Base {

	private String teacherName;

	private Integer teacherAge;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "teachers") // necessary
	private List<Class> classes;

	public List<Class> getClasses() {
		return classes;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getTeacherAge() {
		return teacherAge;
	}

	public void setTeacherAge(Integer teacherAge) {
		this.teacherAge = teacherAge;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

}
