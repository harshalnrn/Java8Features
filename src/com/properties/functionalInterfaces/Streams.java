package com.properties.functionalInterfaces;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streams {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);


        Stream<Integer> stream=list.stream().map(i -> {
                    i = (i == 1) ? (i + 1) : (i); //use ternay operator for conditional assignment
                    return i;
                });
            stream.forEach(i -> System.out.println(i));
            //map and collect each element
        List<Integer> list1=list.stream().map(i ->{
            i= (i==1)? (i+1) : (i);
            return i;
        }).collect(Collectors.toList());
        for(Integer i:list1){
            System.out.println(i);
        }

        for(Integer i:list){
            System.out.println(i);
        }

        //learning: original list/stream is not affected. where a new stream gets created

//----------------------------------------- using findAny, findFirst, anyMatch, allMatch, Optionals----------------------------
        Optional<Integer> value=list.stream().filter(i ->i==1).findAny();
        System.out.println(value.get());
        System.out.println(list.stream().anyMatch(i -> i==4));
        System.out.println(list.stream().allMatch(i -> i==4));

//---------------------------------------------------------------------------------------------------
        //collect a stream , group and create a freq map, with value as frequency of each element.
        //The Collectors.groupingBy(classifier, downstream) collector converts the collection of elements into a map by grouping elements
        // according to a classification method and then performing a reduction operation on the values associated with a given key using the specified downstream Collector.
       Map<Integer,Long> map= list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(map);

        //use stream for simpler operations of bigger lists to make code consise. if i have too many operations for each element, i go for conventional. generally use this for to compare transactional data with static data. (As used in validator module)


//-------------------------------------------------------------------------------------
        //Flat maps to deal with nested collections.(i.e list of list)

        //Flattening is the process of converting several lists of lists and merge all those lists to create a single list containing all the elements from all the lists.


    }
}
