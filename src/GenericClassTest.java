import java.lang.reflect.Method;
import java.util.*;

public class GenericClassTest {

    public static void main(String[] args) {
        System.out.println(StringList.class.getGenericSuperclass());
        try {
            Method method = StringList.class.getDeclaredMethod("getT", Object.class);
            System.out.println(method.getGenericReturnType());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static class StringList extends ArrayList<String> {
        public <T> T getT(T t) {
            return t;
        }
    }

    private static void testFood() {
        // 协变定义上限 上限是Food
        // 定义一个装食物类型的列表，但是不知道能装什么类型；
        // 可能装水果、也可能装蔬菜，但就是不知道实际可以装什么，所以调用 add() 方法会报错；
        List<? extends Food> foods = new ArrayList<>();
        // 可以从里面取食物，但也不知道是什么类型的食物，所以 get() 返回值是 Food 类型
        Food food = foods.get(0);

        // 逆变定义下限，下限是 Fruit
        List<? super Fruit> fruits = new ArrayList<>();
        Object object = fruits.get(0);
        fruits.add(new Apple());
        fruits.add(new Fruit());

        List<? super Apple> apples = new ArrayList<Fruit>();//编译通过
        apples.add(new Apple());//编译通过
        apples.add(new BigApple());//编译通过
        Object object1 = apples.get(0);//编译通过
//        Apple apple = apples.get(0);//编译不通过，因为只知道取出来的类型是 Apple 的父类
        List<? super Fruit> fruitList = new ArrayList<Fruit>();
    }

    static class Food { }

    static class Fruit extends Food { }

    static class Vegetable extends Food { }

    static class Apple extends Fruit { }

    static class Orange extends Fruit { }

    static class BigApple extends Apple { }
}
