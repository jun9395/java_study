# Android Messaging

## 1. Toast

> 안드로이드에서 간단하게 메시지를 표시할 때 사용

- 화면과 관련 없이 안드로이드 OS에게 메시지 출력을 요청
    - 안드로이드 OS는 각 애플리케이션의 요청 순서대로 메시지 표시



### 1.1 주요 메서드

- makeText : 토스트 메시지 객체를 만들다
    - 화면 모양, 글자 크기 및 색상 등은 기본 설정

    - 매개변수 : 액티비티, 표시할 문자열, 표시 시간

- setGravity : 토스트 메시지가 표시될 위치 설정
    - 매개변수 : Gravity.위치, x좌표, y좌표
        - Gravity.위치를 기준으로 x좌표만큼 좌우로, y좌표만큼 위아래로 추가


- setView : 토스트 메시지를 통해 보여줄 뷰 설정

- show : 메시지 출력 요청







## 2. 다이얼로그

> 사용자에게 메시지를 전달하는 용도
>
> 다이얼로그가 나타나 있을 때는 주변의 뷰를 선택할 수 없다

- 메시지 전달이나 입력 등의 용도로 사용





### 2.1 기본 다이얼로그

> 총 3개의 버튼을 배치할 수 있다



#### 2.1.1 메서드

- setPosiviteButton
  - 문자열
  - 리스너
- setNeutralButton
- setNegativeButton



#### 2.1.2 리스너

> DialogInterface

- OnClickListenter
  - DialogInterface dialog : 다이얼로그 객체
  - int which : 어떤 버튼을 눌렀는지 버튼 구분 id





### 2.2 커스텀 다이얼로그

> 기본 다이얼로그에 View를 설정하면 다이얼로그에 표시되는 모양을 자유롭게 구성할 수 있다



- LayoutInflater로 xml파일을 View로 만들자





### 2.3 DatePicker

> 날짜를 선택할 수 있도록 제공되는 다이얼로그



#### 2.3.1 리스너

- OnDateSetListener
  - onDateSet
    - view
    - year
    - month : 0부터 시작하므로 +1 해주자
    - dayOfMonth





### 2.4 TimePicker

> 시간을 선택할 수 있도록 제공되는 다이얼로그



#### 2.4.1 TimePickerDialog

- 패러미터
  - context : 보통은 this
  - 리스너
  - 시간
  - 분
  - 24시간
    - true : 24시간 형식
    - false : 12시간 형식



#### 2.4.2 OnTimeSetListener

- onTimeSet
  - 선택된 뷰
  - hourOfDay
  - minute





### 2.5 ProgressDialog

> 작업 사용자가 애플리케이션을 조작할 수 없도록 하는 다이얼로그
>
> 안드로이드 8.0 이상부터는 사용을 권장하지 않는다



- ProgressDialog
  - show
    - this,
    - 제목
    - 내용
  - cancel : 프로그레스 다이얼로그를 제거







## 3. 리스트 다이얼로그

> 리스트 뷰를 표시할 수 있는 다이얼로그
>
> 버튼을 4개 이상 배치하고자 할 때도 사용



### 3.1 기본 리스트 다이얼로그

> 기본 다이얼로그를 생성하는 과정과 똑같이 진행

- setItems
  - 문자열이 담긴 배열이나 어레이 리스트
  - 리스너

setItems를 사용하면 리스트 뷰를 만들어준다



#### 3.1.1 리스너

> DialogInterface

- OnClickListenter
  - DialogInterface dialog : 다이얼로그 객체
  - int which : 어느 리스트를 눌렀는지 인덱스 번호



### 3.2 커스텀 리스트 다이얼로그

- alertdialog.builer에 setAdapter라는 메서드가 있다
  - 여기에 adapter를 세팅해주면 리스트 뷰 커스터마이징 가능







## 4. Notification

> 애플리케이션과 별도로 관리되는 메시지



- Notification 메시지를 OS에 요청하면 OS는 알림창 영역에 알림 메시지 표시
- 화면을 갖지 않는 실행 단위에서 메시지를 표시할 때 사용

- 사용자가 메시지를 확인하거나 제거하기 전까지 유지
- 터치하면 지정된 Activity가 실행되어 애플리케이션 실행 유도





### 4.1 Notification Channel

> 안드로이드8부터는 알림 메시지를 채널이라는 그룹으로 묶을 수 있으며 같은 채널 별로 메시지에 대한 설정을 따로 할 수 있게 된다



#### 4.1.1 생성 메서드

```java
public NotificationCompat.Builder getNotificationBuilder(String id, String name) {	// id : 각 채널을 구분해주는 역할, name : 설정 화면에서 보여주는 이름
    NotificaionCompat.Builder builder = null;
    
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {	// 안드로이드 8.0은 Oreo
        // 알림 메시지를 관리하는 객체
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        
        // 채널 객체
        NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);	// id, name, 중요도
        
        // 채널 객체를 등록
        manager.createNotificationChannel(channel);
        
        // 메시지 생성을 위한 객체 생성
        builder = new NotificationCompat.Builder(this, id);
    } else {
        builder = new NotificationCompat.Builder(this);
    }
    
    return builder;
}
```



#### 4.1.2 호출 메서드

``` java
public void makeNotification(View view) {
    NotificationCompat.Builder builder = getNotificationBuilder("channel1", "첫 번째 채널");
    
    // 표시문구 설정
    builder.setContentTitle("타이틀");
    builder.setContentText("내용");
    
    // 위의 설정한 메시지 정보 객체로부터 메시지 객체를 생성
    Notification notification = builder.build();
    
    // 알림 메시지 관리 객체 생성
    NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    
    // 알림 메시지 출력
    manager.notify(10, notification);
}
```





### 5. Pending Intent

> Pending Intent를 사용하여 애플리케이션의 Activity를 실행할 수 있다
>
> 실행되는 Activity로 데이터를 전달 할 수 있다





#### 5.1 사용법

```java
// Notification 객체를 담을 builder를 생성하여 보여주는 메서드 내부

Intent intent = new Intent(this, NextActivity.class);	// 실행할 Activity의 class를 지정

// 실행될 Activitiy에 전달할 데이터 세팅
intent.putExtra("데이터이름", 데이터);

// Intent 객체를 관리할 PendingIntent 객체를 생성하여 세팅
PendingIntent pending = PendingIntent.getActivity(this, requestCode, 인텐트, 메시지 중요도);

builder.setContentIntent(pending);
```



- 메시지 중요도 PendingIntent
  - FLAG_UPDATE_CURRENT 등이 있다





### 6. Action

> 알림 세미지에 버튼과 같은 것을 배치하여 눌렀을 때 각각 지정된 Activity를 실행할 수 있다
>
> 안드로이드 4.1부터는 하나의 메시지를 통해 여러 Activity를 실행할 수 있다









### 7. Style Notification

> 알림 메시지를 접었다 펼쳤다 하면서 부가 정보를 표시할 수 있다

- 안드로이드 4.1에 새롭게 추가된 부분
- 4.0 이하에서는 기본 알림 메시지로 표시





#### 7.1 Big Picture Style

> 메시지를 펼쳤을 때 이미지를 표시할 수 있다





#### 7.2 Big Text Style

> 메시지를 펼쳤을 때 장문의 문자열을 표시할 수 있다





#### 7.3 InBox Style

> 메시지를 펼쳤을 때 문자열들을 표시할 수 있다

- 문자열이 너무 긴 경우에는 뒷부분을 생략해서 보여준다







### 8. Message Notification

> 다수의 사용자 간의 메시지 내용을 표시하는 용도

- 안드로이드 9.0에서 새롭게 추가

- 하위 버전에서 사용 불가능
  - builer 분기 불필요



