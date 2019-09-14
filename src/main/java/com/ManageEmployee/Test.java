package com.ManageEmployee;

import com.ManageEmployee.repository.EmployeeRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws ParseException {
        Set<String> strings = new HashSet<>();
        strings.add("Tuând");
        strings.add("Nam");
        strings.stream().forEach( a -> System.out.println(a) );

    }
}
