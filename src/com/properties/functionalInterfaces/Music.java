package com.properties.functionalInterfaces;
@FunctionalInterface
public interface Music {

    public void getTypeOfMusic();

    public static void sampleStaticMethod(){


    }
    default void sampleDefaultMethod(){

    }
}
