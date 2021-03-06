package com.xiaohai.beans;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Data
public class Person {

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String,Object> score;
    private Set<Double> salaries;
    private Map<String,List<Pet>> allPets;

}
