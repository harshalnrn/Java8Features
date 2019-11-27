package com.interfaces.methodOverriding;

import com.properties.functionalInterfaces.Shape;

public class Sqare implements Shape {

    @Override
    public int area(int side) {
        return side * side;
    }
}
