package com.TTN.restfulday2.internationalizationHateosCN;


//my bean class
public class Employee
{


    private Integer id;

    private String userName;

    private Integer age;



    //constructor
    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.userName = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String name) {

        this.userName = name;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
