package com.junwei.weatherapis.model;
import javax.persistence.*;

//make the Student Class as Entity
@Entity
// The class name is table name in DB
@Table
public class Student {
    //set id as primary key
    @Id
    //set id as column name
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    //set name as column name
    @Column
    private String firstName;
    //set age as column name
    @Column
    private int age;
    //set email as column name
    @Column
    private String email;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return firstName;
    }
    public void setName(String name)
    {
        this.firstName = name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
