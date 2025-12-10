package laba4;

public class Person {

	private int id;
	private String name;
	private String gender;
	private Division division;
	private int salary;
	private String birthDate;
	
	public Person(int id, String name, String gender, Division division, int salary, String birthDate) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.division = division;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Division getDepartment() {
		return division;
	}

	public void setDepartment(Division department) {
		this.division = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + ", division=" + division + ", salary="
				+ salary + "]";
	}
	
}
