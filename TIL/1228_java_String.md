### 1. Wrapper

- 기본 자료형에 대한 작업을 할 수 있는 클래스들
    - Boolean
    - Byte
    - Character
    - Integer
        - MAX_VALUE
        - MIN_VALUE
    - Long
    - Short
    - Double
    - Float
    - ...

- 기본 자료형 값을 객체화 시킬 때 사용
    - parseInt
    - parseLong

- 문자열로 되어있는 값을 수치형 값으로 변환할 때 사용





### 2. Runtime

> 프로그램과 운영체제 간의 상호 작용을 위한 메서드들이 있는 클래스

- 프로그램이 실행되면 이미 Runtime 클래스의 객체를 생성해서 갖고 있다
    - 이 객체의 주소값을 얻어와서 사용하면 된다


#### 2.1 대표메서드

- totalMemory() : 메모리 전체 양을 알아온다

- freeMemory() : 여유 메모리 양을 알아온다

- exec() : 운영체제에 명령어를 전달한다

- gc() : 메모리를 청소한다


---

- loadLibrary

C언어로 만들어진 라이브러리를 자바 언어로 사용하려고 할 때

JNDI를 검색해보자

---





### 3. String 클래스

> 문자열에 대한 작업을 할 수 있도록 제공되는 클래스

- "로 묶인 문자열도 String 클래스로 판단
    - 컴파일 할 때는 String 클래스로 객체를 생성하는 것으로 인식


#### 3.1 주요 메서드

- A.equals(B) : A와 B의 문자열 내용을 비교

- equalsIsIgnoreCase() : 대소문자를 무시한 문자열 비교

- toUpperCase() : 모두 대문자로 변경

- toLowerCase() : 모두 소문자로 변경

- startsWith(B) : B로 시작하는지 검사

- endsWith(B) : B로 끝나는지 검사

- indexOf(B) : B가 어디에 들어있는지 첫 인덱스 반환

- getBytes() : 문자열을 바이트화 한다

- length() : 문자열의 길이 측정

- substring() : 문자열의 일부를 갖고 옴

- trim() : 좌우 공백 제거
    - trimleft() : 좌 공백 제거
    - trimrignt() : 우 공백 제거





### 4. StringBuffer

> 관리하는 문자열을 직접 조작할 수 있는 기능

> 문자열을 계속 생성하는 것을 방지해서 메모리가 절약된다



#### 4.1 주요 메서드

- toString() : StringBuffer클래스가 관리한느 문자열을 String으로 반환
    - 문자열을 추가한 다음에 주소값을 넘겨준다

- append("문자열") : 뒷부분에 "문자열"을 추가

- delete(startIndex, endIndex + 1) : startIndex부터 endIndex의 문자열을 삭제

- insert(index, "문자열") : index에 문자열을 삽입한다

- replace(startIndex, endIndex + 1, "문자열") : startIndex부터 endIndex까지의 부분을 "문자열"로 변경한다




### 5. StringTokenizer

> 토큰 : 구분자에 의해 잘려진 문자열

- 문자열을 구분자를 통해 잘라내어 사용할 수 있도록 하는 클래스
    - 구분자를 지정하지 않으면 공백이 구분자



#### 5.1 주요 메서드

- hasMoreElements : (bool) 다음에 가져올 토큰이 있는지 여부 검사

- nextToken : 다음 토큰을 가져온다







### 6. Date  클래스

> 시간과 날짜 관리 목적의 클래스

- 밀레니엄 버그 때문에 날짜와 시간 정보를 갖고 오는 메서드는 사용하지 않음
    - Calendar 클래스를 사용




### 7. Calendar 클래스

- get 메서드를 통해 모든 시간과 날짜 값을 갖고 올 수 있다
    - year : 년을 가져온다
    - month : 달을 가져온다
    - ...



#### 7.1 주요 메서드

- get() : 시간 정보를 갖고 온다

- set() : 시간 정보를 세팅한다

- getTime() : Calender 클래스의 값을 Date 객체 형태로 가져온다

- setTime() : Date 객체로 Calender 객체에 시간 값을 설정한다