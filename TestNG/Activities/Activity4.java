package activities;

import org.testng.annotations.Test;

@Test
public class Activity4 {

    public static class DemoOne {
        @Test
        public void firstTestCase() {
            System.out.println("I'm in first test case from demoOne Class");
        }

        @Test
        public void secondTestCase() {
            System.out.println("I'm in second test case from demoOne Class");
        }
    }

    public static class DemoTwo {
        @Test
        public void TestCase() {
            System.out.println("I'm in the test case from DemoTwo Class");
        }
    }

}


