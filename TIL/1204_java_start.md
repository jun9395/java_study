# java start

## Intelli J

### 1. Java 파일

- 기본 형태

  ```java
  public class HelloWorld {
  	public static void main(String [] args){
  		System.out.println("Hello World");
  	}
  }
  ```

  - 컴파일 명령어 : `javac HelloWorld.java`
  - 컴파일 후 만들어지는 결과물 : HelloWorld.class





### 2. 식별자

#### 2.1 식별자의 정의

- 변수 : 프로그램에서 사용하는 값을 담아놓는 기억공간
- 클래스 : 프로그램 내에서 독립적인 단위
  - python에서 .py로 구분되는 파일, 모듈
- 메서드 : 클래스 내부에 있는 기능 단위
  - python에서 파일, 모듈 내의 정의된 함수



### 3. 상수

> System.out.printf("a: %d, b: %s", 100, "안녕하세요")

#### 3.1 서식

- %d : 정수
  - %숫자d : "숫자" 만큼의 공간을 확보하고 빈칸은 빈칸으로 출력
  - %0숫자d : "숫자" 만큼의 공간을 확보하고 남은 빈칸은 0으로 채워서 출력
- %c : 문자
- %f : 실수
- %s : 문자열



### 4. 변수

> 기억된 값을 바꿀 수 있는 값

#### 4.1 자료형

- 논리형
  
  - boolean
- 정수형
  - byte : 1byte 크기의 정수값 (-128 ~ 127)
  - char : 2byte 크기의 문자값 (0 ~ 65535)
  - short : 2byte 크기의 정수값 (-32768 ~ 32767)
  - int : 4byte 크기의 정수값 (-2147483648 ~ 2147483647)
  - long : 8byte 크기의 정수값
- 실수형
  - float : 4byte 크기의 실수값
  - double : 8byte 크기의 실수값
    - 숫자 뒤에 F를 붙여주면 float형으로 잡는다 
- 문자열

  - String : " "로 묶인 문자열

    ```java
    String str1 = "hello";
    String str2 = "hello";	// str2는 str1과 같은 대상을 가리킨다
    
    str1 == str2; // true
    
    String str3 = new String("hello");
    String str4 = new String("hello");
    
    str3 == str4; // false
    
    str3.substring(3);	// index 3번째부터 짤라서 반환
        // 즉 "lo" 반환
    ```

    



### 5. 표준입출력

#### 5.1 표준입력

- System.in.read()

  - 글자 한 개를 입력받게 된다
  - ~~엔터를 누르면 CR, LF라는 2개의 문자가 들어간다~~
    - 이젠 아니다

  ```java
  public class OneRead {
      public static void main(String [] args) {
          int a = System.in.read();
  		char b = (char)System.in.read();
  
  		System.out.println("a: " + a + ", b: " + b);
      }
  }
  ```

  

- BufferedReader

  - 라인 단위의 입력을 받는다

  ```java
  public class OneLineRead {
      public static void main(String [] args) {
  		InputStreamReader ir = new InputStreamReader(System.in);
  		BufferedReader br = new BufferedReader(ir);
  		String str = br.readLine();
  
          System.out.println("str: " + str);
      }
  }
  ```

  

**단, 모든 경우에 엔터를 눌러야만 buffer에 있는 데이터가 전달된다**



### 6. 연산자

- 최우선 연산자 : . [] ()
- 단항 연산자: ! ~ +/- 전위++/-- (cast)
  - ! 연산자의 경우 java에서는 true, false 앞에서만 작동한다
  - ~ 는 2의 보수를 취한다
- 사칙연산자
- 시프트 연산자 : << >> >>>
- 관계 연산자 : > >= == <= < !=
- 비트 연산자 : & | ^
  - & 두 수를 2진수로 변환한 후 각 자리를 비교하여 둘 다 1인 경우만 1로
  - | 둘 중에 하나라도 1이면 1로
  - ^ XOR 연산
- 논리 연산자 : && & || |
  - && : 두 값이 모두 true이면 true, 단 앞이 false면 뒤를 수행하지 않는다
  - & : 두 값이 모두 true이면 true, 앞이 false더라도 뒤를 수행한다
  - || : 두 값 중에 하나라도 true이면 true, 단 앞이 true이면 뒤를 수행하지 않는다 
  - | : 두 값 중에 하나라도 true이면 true, 앞이 true더라도 뒤를 수행한다
- 삼항연산자
  - `조건항 ? 항1 : 항2`

- 배정대입 연산자 : += -= *= /= %= 등
- 후위형 ++/--

