## Handler

> 안드로이드에서 쓰레드 작동 방식

> 짧지만 반복 작업해야하는 작업을 메인 쓰레드에서 처리하도록

- 쓰레드에서 코드 처리 중 화면에 관련된 작업이 필요하다면 Handler를 상속받은 클래스를 만들어 필요시 Handler를 요청

- Handler를 상속한 클래스에 만든 메서드는 Main Thread에서 처리




### Main Thread에서의 반복

- Main Thread에서 처리하는 코드(Acitivty 내의 코드) 중에 일정 작업을 계속 반복 처리해야할 경우
    - 무한 루프를 사용하면 화면 처리가 불가능
    - Handler를 통해 원하는 코드를 반복해서 작업



### Handler

- 개발자가 안드로이드 OS에게 작업 수행을 요청하는 역할

- 개발자가 작업을 요청하면 안드로이드 OS는 작업을 하지 않을 때 개발자가 요청한 작업을 처리
    - Main Thread에서 처리

    - 5초 이상 걸리는 작업 불가

    - (안드로이드 누가 이하에서) 화면 처리 가능





### Handler를 통한 화면 처리

- 안드로이드에서 **네트워크에 관련된 처리**나 5초 이상 걸리는 작업은 모두 개발자가 발생한 쓰레드에서 처리해야 한다

- 개발자가 발생한 쓰레드에서 화면에 관련 처리를 하고자 할 때는 Handler를 이용해야 한다

- 안드로이드 오레오(8.0) 이상에서는 개발자가 발생한 쓰레드에서 화면처리를 해도 된다




#### DisplayHandler 예시 참조

- 안드로이드 누가 이하에서는 메인 스레드 이외의 스레드로 화면에 처리를 하려고 하면 오류 발생

- Handler (Android.os)를 extends 한 클래스를 이용
    - handleMessage(non null Message msg) : msg에 들어온 작업 구분 코드(what)로 동작하자
    - 화면에 관련된 작업만 하고, 화면에 관련된 작업에 필요한 데이터는 쓰레드클래스에서 해주자






### AsyncTask

- 비동기 처리를 위해 제공되는 클래스

- 개발자가 발생한 스레드와 핸들러의 조합으로 스레드 운영 중 화면 처리가 가능했던 구조를 클래스로 제공




#### AsyncTaskClass 참조

- extends AsyncTask<Type1, Type2, Type3>
    - onPreExecute() : doInBackground 메서드가 호출되기 전에 호출되는 메서드.
        - Main Thread가 처리

        - 일반 Thread로 처리할 작업이 동작하지 전에 필요한 사전 작업 처리

    - protected Type3 doInBackground(Type1... type1s) : 일반 쓰레드에서 처리
        - 네트워크 관련 처리나 굉장히 **오래 걸리는 작업** 처리

        - 화면 관련된 처리 금지

        - Type1로 이루어진 배열 type1s

        - publicProgress(Type2)를 통해 onProgressUpdate 실행

    - onProgressUpdate(Type2... values) : doInBackground 메서드에서 publicProgress 메서드를 호출하면 Main Thread가 처리하는 메서드
        - doInBackground 메서드 내에서 화면 처리가 필요할 때 사용

    - onPostExecute(Type3 s) : doInBackground 메서드 수행 완료 후 호출
        - Main Thread가 처리





### RunOnUiThread

- 개발자가 발생한 일반 스레드에서 코드 일부를 Main Thread가 처리하도록 하는 메서드

- 핸들러에서 만든 코드를 여기서도 사용하고 저기서도 사용 할 때

- 오로지 여기에서만 사용하는 화면 처리 코드면 RunOnUiThread 사용

- Runable 인터페이스를 구현한 클래스를 객체를 생성하여 넣어주기

