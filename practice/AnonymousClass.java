package practice;

public class AnonymousClass {
    public interface Greet {
        void greetWorld();
        void greetSomeone(String name);
    }

    public void sayHello() {
        class GreetEnglish implements Greet {
            public void greetWorld() {
                System.out.println("Hello World");
            }
            public void greetSomeone(String name) {
                System.out.println("Hello" + name);
            }
        }

        Greet gEnglish = new GreetEnglish();
        gEnglish.greetWorld();

        Greet gJapanese = new Greet() {
            public void greetWorld() {
                System.out.println("こんにちは世界");
            }
            public void greetSomeone(String name) {
                System.out.println(name + " さん、こんにちは");
            }
        };

        gJapanese.greetSomeone("mike");
    }

    public static void main(String[] args) {
        AnonymousClass c = new AnonymousClass();
        c.sayHello();
    }
}