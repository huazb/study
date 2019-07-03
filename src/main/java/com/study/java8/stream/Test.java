package com.study.java8.stream;

import org.junit.Before;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhibin.hua on 2019/2/19.
 */
public class Test {

    List stuList;
    @Before
    public void init() {
         Random random = new Random();
        stuList = new ArrayList<Student>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    public class Student {
        private String name;
        private Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
        //-----getters and setters-----

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    //1列出班上超过85分的学生姓名，并按照分数降序输出用户名字
    /*@org.junit.Test
    public void test1() {
        List<String> studentList = stuList.stream()
                .filter(x->x.getScore()>85)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(studentList);
    }*/

    @org.junit.Test
    public void test2(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered.parallelStream().toString());
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }
    @org.junit.Test
    public void testFilter(){
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).filter(x->x>3&&x<8).forEach(System.out::println);
    }
    /**
     * map把一种类型的流转换为另外一种类型的流
     * 将String数组中字母转换为大写
     */
    @org.junit.Test
    public void testMap() {
        String[] arr = new String[]{"yes", "YES", "no", "NO"};
        Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
    }
    /**
     * 产生规律的数据
     */
    @org.junit.Test
    public void testUnlimitStream1(){
        Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);
        Stream.iterate(0,x->x).limit(10).forEach(System.out::println);
        //Stream.iterate(0,x->x).limit(10).forEach(System.out::println);与如下代码意思是一样的
        Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::println);
    }
    /**
     * flapMap：拆解流
     */
    @org.junit.Test
    public void testFlapMap1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        // Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
    }

    @org.junit.Test
    public void a(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

}
