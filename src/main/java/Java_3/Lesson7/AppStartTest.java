package Java_3.Lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.PriorityQueue;

public class AppStartTest {

    public static void start(Class<?> testClass){
        runOutside(testClass, BeforeSuite.class);
        runTests(testClass);
        runOutside(testClass, AfterSuite.class);
    }

    private static void runTests(Class<?> testClass){
        Method[] methods = testClass.getDeclaredMethods();
        PriorityQueue<Priority> priority = new PriorityQueue<>();
        for (Method method: methods) {
            if (method.getAnnotation(Test.class) != null) {
                Test annotation = method.getAnnotation(Test.class);
                priority.add(new Priority(method, annotation.priority()));
            }
        }
        while (!priority.isEmpty()) {
            try{
                priority.remove().getMethod().invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static <T extends Annotation> void runOutside(Class<?> testClass, Class<T> classAnnotation) {
        Method[] methods = testClass.getDeclaredMethods();
        boolean check = false;
        for (Method method: methods) {
            if(method.getAnnotation(classAnnotation) != null) {
                try{
                    if(!check) {
                        method.invoke(null);
                        check = true;
                    } else {
                        throw new RuntimeException(classAnnotation.getSimpleName() + " - should only be used once");
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void main(String[] args) {
        start(AppTests.class);
    }




}
