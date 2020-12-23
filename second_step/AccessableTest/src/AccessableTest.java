import com.test.BClass;

public class AccessableTest {
    public static void main(String[] args) {
        new Class1();
        new Class2();
        new Class3();
        new Class4();
    }
}

// 같은 패키지의 클래스를 객체생성해서 참조할 경우
class Class1 {
    public Class1() {
        AClass a = new AClass();

        a.publicValue = 10;
        a.publicMehotd();

        a.protectedValue = 11;
        a.protectedMethod();

        a.defaultValue = 13;
        a.defaultMethod();
    }
}

// 같은 패키지의 클래스를 상속받아서 사용할 경우
class Class2 extends AClass {
    public Class2() {
        publicValue = 10;
        publicMehotd();

        protectedValue = 12;
        protectedMethod();

        defaultValue = 14;

        defaultMethod();
    }
}

// 다른 패키지의 클래스를 객체생성해서 참조할 경우
class Class3 {
    public Class3() {
        BClass b = new BClass();

        b.publicValue2 = 20;
        b.publicMethod2();

//        b.protectedValue2 = 21;
//        b.protectedMethod2();

//        b.defaultValue2 = 22;
    }
}

// 다른 패키지의 클래스를 상속받아서 사용할 경우
class Class4 extends BClass {
    public Class4() {
        publicValue2 = 20;
        publicMethod2();

        protectedValue2 = 22;
        protectedMethod2();
    }
}