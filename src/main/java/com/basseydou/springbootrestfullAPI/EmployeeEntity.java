package com.basseydou.springbootrestfullAPI;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    public EmployeeEntity() {

    }

    public EmployeeEntity(String name, String location, String emailId) {
        this.name = name;
        this.location = location;
        this.emailId = emailId;
    }


    public Integer getEmployee_Id() {
        return employee_Id;
    }
    public void setEmployee_Id(Integer employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employee_Id + ", name=" + name + ", emailId=" + emailId
                + "]";
    }

}