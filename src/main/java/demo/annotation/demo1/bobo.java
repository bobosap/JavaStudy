package demo.annotation.demo1;

import demo.annotation.demo1.Person;
import demo.annotation.demo1.ztest;
import demo.annotation.demo1.ztest1;

public class bobo implements Person {

    public String name;
    private int age;

    @Override
    public void laugh() {
        System.out.println("bobo is laughing!");
    }


    @ztest(name = "bobo",age = 30 )
    public void sing(){
        System.out.println("i am the king of singer");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @ztest(name = "bobo",age = 30)
    public String setName(String name) {
        return this.name = name;
    }

    @ztest1("bobo2")
    public void setAge(int age) {
        this.age = age;
    }
}
