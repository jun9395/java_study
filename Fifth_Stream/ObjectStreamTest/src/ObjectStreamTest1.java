import java.io.*;

public class ObjectStreamTest1 {
    public static void main(String[] args) {
        try {
////            TestClass t = new SerialClass();
            SerialClass t = new SerialClass();
            t.a = 100;
            t.b = 200;

            FileOutputStream fos = new FileOutputStream(".\\test.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(t); // 개체 직렬화를 하지 않아서 오류 메시지가 저장된다
            oos.close();
            fos.close();

            
            // 저장되어 있는 직렬화된 파일을 읽자
            FileInputStream fis = new FileInputStream(".\\test.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            SerialClass t2 = (SerialClass)ois.readObject();

            System.out.println(t2.a);
            System.out.println(t2.b);
            t2.sayHi();
        } catch (IOException | ClassNotFoundException e) {

        }  // catch (NotSerializableException e) {}
    }
}


class TestClass {
    int a, b;

    public void sayHi() {
        System.out.println("안녕하세요");
    }
}

class SerialClass extends TestClass implements Serializable {
    int a, b;
}