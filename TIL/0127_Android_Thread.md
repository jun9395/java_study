### 안드로이드 쓰레드

> VM 방식의 어플리케이션은 한 쓰레드에서 오류가 발생하면 프로그램 전체를 중지시키지는 않는다. 네트워크에 관련된 코드들은 오류가 발생할 확률이 높으므로 반드시 쓰레드로 운영해야 한다

- 쓰레드는 여러 동작를 비동기적으로 처리하기 위해 사용

- 비동기적 처리 외의 네트워크에 관련된 코드는 전부 쓰레드로 운영


#### ANR

- 안드로이드는 Activity의 코드를 처리하기 위해 쓰레드를 발생
    - 이 쓰레드를 Main Thread 혹은 UI Thread라고 부른다

- Main Thread가 현재 작업을 하지 않을 때만 화면 작업이 가능

- Main Thread가 바쁠 때 화면 작업이나 터치가 발생하면 ANR(Applicaton Not Pespond)가 발생

- Main Thread는 onCreate를 처리하고, 그 다음 화면을 통제하고 사용자 터치를 받는다
    - 그러므로 onCreate에 오래 걸리는 작업이 있으면 화면이 그려지지 않는다





#### 화면 처리

- 안드로이드는 개발자가 발생한 쓰레드에서 화면에 대한 처리를 하면 오류가 발생

- 현재 안드로이드 오레오(8.0) 이상부터는 개발자가 발생한 쓰레드에서도 화면 처리가 가능
    - 내부 OS 적으로 알아서 처리해준다


