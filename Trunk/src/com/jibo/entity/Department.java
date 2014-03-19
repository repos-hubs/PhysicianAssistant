package com.jibo.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table department.
 * 
 * ���ҹ�ϵ��
 * 
 */
public class Department {

    private Long id;
    private String bigDepartmentPinyin;
    private String bigDepartment;
    private String department;

    public Department() {
    }

    public Department(Long id) {
        this.id = id;
    }
    public Department(String department) {
        this.department = department;
    }
    

    @Override
	public String toString() {
		return department ;
	}
    
    @Override
 	public boolean equals(Object o) {
 		return o.toString().equals(department);
 	}

	public Department(Long id, String bigDepartmentPinyin, String bigDepartment, String department) {
        this.id = id;
        this.bigDepartmentPinyin = bigDepartmentPinyin;
        this.bigDepartment = bigDepartment;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBigDepartmentPinyin() {
        return bigDepartmentPinyin;
    }

    public void setBigDepartmentPinyin(String bigDepartmentPinyin) {
        this.bigDepartmentPinyin = bigDepartmentPinyin;
    }

    public String getBigDepartment() {
        return bigDepartment;
    }

    public void setBigDepartment(String bigDepartment) {
        this.bigDepartment = bigDepartment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}