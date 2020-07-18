package org.apache.maven.archetypes.maven_archetype_quickstart;

public class Employee {
	private String name;
	private String id;
	private String mail;
	private String month;
	private int year;
	private int basic;
	private int bonus;
	private int salary;
	
	public Employee(String name,String id,String mail,String month,int year,int basic,int bonus,int salary) {
		this.name=name;
		this.id=id;
		this.mail=mail;
		this.month=month;
		this.year=year;
		this.basic=basic;
		this.bonus=bonus;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	

}
