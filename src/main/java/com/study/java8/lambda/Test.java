package com.study.java8.lambda;

/**
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 */
class Test {

    public static void main(String[] args) {
        Test test = new Test();
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (int a, int b) -> {return a * b; };
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + test.operation(10, 5, addition));
        System.out.println("10 - 5 = " + test.operation(10, 5, subtraction));
        System.out.println("10 * 5 = " + test.operation(10, 5, multiplication));
        System.out.println("10 / 5 = " + test.operation(10, 5, division));

        GreetingService greetingService1 = message ->
                System.out.println("Hello " + message);

        GreetingService greetingService2 = (message) ->
                System.out.println("Hello " + message);

        greetingService1.sayMessage("Baidu");
        greetingService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operation(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
