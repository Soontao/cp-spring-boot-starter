package corp.sap.hana.spring.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Class extends Base {

	private String className;
	private String credit;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "class_teacher_rel") // necessary
	private List<Teacher> teachers;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result + ((teachers == null) ? 0 : teachers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class other = (Class) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (teachers == null) {
			if (other.teachers != null)
				return false;
		} else if (!teachers.equals(other.teachers))
			return false;
		return true;
	}

}
