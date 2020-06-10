package com.properties.functionalInterfaces;

import com.interfaces.methodOverriding.Sqare;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {


    public static void main(String[] args) {

        Shape c = new Sqare();  //traditional using child implementing classes
        Shape b = (int a) -> {
            return a * a;
        };

        Shape k = a -> {           //() optional and type inference
            return a * a;
        };

        Shape l = a -> a * a;     //() {} optional ,type, return inference

        System.out.println(c.area(4));
        System.out.println(b.area(4));
        System.out.println(k.area(4));
        System.out.println(l.area(4));


        //multiple implementation allowed as also in traditional approach

        Music m = () -> System.out.println("Classical music");
        Music m1 = () -> System.out.println("jazz music");

        m.getTypeOfMusic();
        m1.getTypeOfMusic();




//below is comparator implementation using lambda expressions, where we sort lists, (i.e Comparator interface is a functional interface)




        Comparator<Integer> comparator = (i, j) -> j - i;                   //implementation using lambda expresions, instead of child class
        Comparator<Employee> comparator1 = (i, j) -> j.getEmployeeNo() - i.getEmployeeNo();
        // Comparator<Integer> comparator1=(i,j)-> (i>j)? -1 : (i<j) ? 1 : 0 ;

        //sorting the list,sets (Treeset),maps(Treemap) by key
        List<Integer> list = new LinkedList<Integer>();
        Set<Integer> set = new TreeSet<Integer>(comparator);
        Map<Integer, String> map = new TreeMap<Integer, String>(comparator);
        map.put(1, "harshal");
        map.put(2, "keshav");
        map.put(3, "amar");


        set.add(1);
        set.add(6);
        set.add(3);
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(2);

        Collections.sort(list, comparator);
        // Collections.sort(list,comparator1);

        Employee emp = new Employee(8, "harshal");
        Employee emp1 = new Employee(3, "keshav");
        List<Employee> empList = new LinkedList<Employee>();
        empList.add(emp);
        empList.add(emp1);
        Collections.sort(empList, comparator1);

        System.out.println(list);
        System.out.println(set);
        System.out.println(map);

//---------------------------------------------------------------------------------------------------------------
        //Dealing with multiple conditional blocks in filter/map.forEach


        //inner loop/conditions blocks inside map/filter/reduce/forEach of streams
        //note lambda expression must end like a statement

        //no return in forEach
        empList.stream().forEach(i -> {
            if (i.getEmployeeNo() % 2 == 0) {
                System.out.println("even number");
            } else if (i.getEmployeeNo() % 3 == 0) {
                System.out.println("divisible by 3");
            } else {
                System.out.println("neighter divisible by 2 or 3");
            }
        }); //end as a statement


        // map method should madatoriy return
        empList.stream().map(i -> {
                    if (i.getEmployeeNo() % 2 == 0) {
                        i.setEmployeeNo(i.getEmployeeNo() + 2);
                    } else if (i.getEmployeeNo() % 3 == 0) {
                        i.setEmployeeNo(i.getEmployeeNo() + 3);
                    } else {
                        i.setEmployeeNo(i.getEmployeeNo() + 5);
                    }

                    return i.getEmployeeNo();
                }
        );


        //comment: filter method should return boolean only . filter and collect, based upon condition.
        empList.stream().filter(i -> {
                    if (i.getEmployeeNo() % 2 == 0) {
                        empList.stream().collect(Collectors.toList());
                    } else if (i.getEmployeeNo() % 3 == 0) {
                        empList.stream().collect(Collectors.toList());
                    } else {
                        empList.stream().collect(Collectors.toList());
                    }
                    return true;
                }
        );


        //.
        int a = 0;


        int j = (a == 0) ? (1) : (a == 1) ? (2) : (3);  //..use ternary operators only when statement is short, and concise, and you assign variable based upon conditions


//wont work //empList.stream().forEach(i -> (i.getEmployeeNo()%2==0) ?  System.out.println("even number") : (i.getEmployeeNo()%3==0) ? System.out.println("divisible by 3") :  System.out.println("neighter divisible by 2 or 3") );
        System.out.println("empty");
System.out.println("end of main method");
    }

}


//note lambda expression syntax rules while implementing eighter in streams or with functional interfaces