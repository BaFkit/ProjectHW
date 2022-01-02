package Java_3.Lesson7;

public class AppTests {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("Before");
    }
    @Test
    public static void testDefault() {
        System.out.println("priority - default");
    }
    @Test(priority = 4)
    public static void test4() {
        System.out.println("priority - 4");
    }
    @Test(priority = 7)
    public static void test7() {
        System.out.println("priority - 7");
    }
    @Test(priority = 10)
    public static void test10() {
        System.out.println("priority - 10");
    }
    @Test(priority = 2)
    public static void test2() {
        System.out.println("priority - 2");
    }
    @AfterSuite
    public static void afterSuite() {
        System.out.println("After");
    }
}
