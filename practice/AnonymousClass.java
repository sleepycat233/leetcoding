package practice;

public class AnonymousClass {
    interface Greet {
        void greetWorld();
        void greetSomeone(String name);
    }

    public class GreetEnglish implements Greet {
        void greetWorld() {
            System.out.println("Hello World");
        }
        void greetSomeone(String name) {
            System.out.println("Hello" + name);
        }
    }
}