public class AbstractTest {
    public static void main(String[] args) {
        Animal human = new Animal() {
            // 인텔리제이는 자동으로 오버라이딩 하도록 강제한다
            @Override
            public void sayHi() {
                System.out.println("안녕하세요");
            }
        };
        human.sayHi();

        Dog dog = new Dog();
        dog.sayHi();

        Animal dog2 = new Dog();    // 부모클래스 변수 = new 자식클래스
        dog2.sayHi();
    }
}

abstract class Animal {
    public abstract void sayHi();
}


class Dog extends Animal {

    @Override
    public void sayHi() {
        System.out.println("멍멍");
    }
}