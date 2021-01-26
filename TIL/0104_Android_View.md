## View

> 안드로이드에서 눈에 보이는 모든 요소



### 1. TextView

> 사용자에게 문자열을 보여줄 수 있는 View

- 문자열을 표시하는 모든 뷰들은 텍스트뷰를 상속받는다
    - Button
    - EditText : 문자열 입력받는 부분



#### 1.1 주요속성

- text : TextView를 통해 보여줄 문자열을 설정한다

- textAppearance : 미리 제공되는 테마 설정
    - AppCompat이 붙은 옵션이 있다면 우선 사용



객체의 주소값을 가져오려면 참조변수를 선언해야 한다

그를 선언할 때는 태그의 이름하고 동일한 클래스 타입으로 선언을 하고

객체의 주소값은 android:id의 @+id/**아이디**의 **아이디** 부분을 사용하면 된다




#### 1.2 주요 메서드

- setText : 보여주고자 하는 문자열을 설정








### 2. Button

> 사용자가 클릭 시 개발자가 작성한 코드가 작동하는 뷰

- 리스너(Listener)를 배치하여 클릭하면 안드로이드 OS가 어떤 버튼이 눌렸는지 인식하도록 하는 방법을 사용한다




#### 2.1 주요속성

- text : Button 상단에 표시되는 문자열



#### 2.2 OnClickListener

> 클릭 시 실행되는 리스너

```java
class BtnListener implements View.OnClickLister {
    @Override
    public void onClick(View v) {	// 누를 객체의 주소값이 onClick( '여기에' ) 들어간다
        if (v.getId() == R.id.button) {
            text.setText("버튼을 클릭했습니다");
        } else {
            text.settext("다른 버튼을 클릭했습니다");
        }
    }
}
```




- OnClick 속성은 Button 뷰에서 자주 사용되므로, xml 쪽에서 설정해줄 수 있다
    - java 부분에서는 Method를 만들어서 Onclick 속성에 Method를 넣어주면 된다


```java
public void BtnMethod(View view) {
    if (조건) {
        실행코드1
    } else {
        실행코드 2
    }
}
```



이 후 xml에서 설정








### 3. CheckBox

> 항목을 제공하고 체크를 통해 선택할 수 있도록 하는 뷰



#### 3.1 주요속성

- text : CheckBox에 표시되는 문자열을 설정

- checked : 체크 상태를 설정




#### 3.2 주요 메서드

- isChecked : 체크 박스의 현재 체크 상태 확인

- setChecked : 체크 박스의 체크 값을 변경

- toggle : 현재 체크 상태를 변경



#### 3.3 주요 리스너

- OnCheckedChangeListener : 체크 상태가 변경됐을 때 반응하는 리스너
    - android.widget.CompoundButton











### 4. Radio Button

> 하나의 그룹 안에서 하나만 선택할 수 있도록 하는 뷰

- 동일한 RadioGroup 안에 있는 경우에만 제대로 동작



#### 4.1 주요 속성

- text : Radio Button에 표시되는 문자열

- checked : 체크 상태를 설정




#### 4.2 주요 메서드

- setChecked : Radio Button의 Check 상태를 설정한다
    - 같은 RadioGroup 내에서 하나만 설정 가능

- getChecked : Raido Button의 Check 상태
    - 이 메서드 대신에 RaidoGroup 객체의 메서드를 이용하여 체크된 RadioButton의 id를 가져오는 것을 추천



#### 4.3 주요 리스너

- OnCheckedChangeListener : 체크 상태가 변경됐을 때 반응하는 리스너
    - android.widget.RadioGroup







### 5. Progress Bar

> 오래 걸리는 작업이 있을 경우 작업 중임을 표시하는 뷰

- 어느 정도 진행됐다는 것을 알려주기 위한 목적이므로 주요 메서드를 통해 현재 진행 정도를 보여주는 용도

- 비교적 짧은 시간이면 일반, 긴 시간이면 horizontal을 통해 진척 사항을 보여주기



#### 5.1 주요속성

- style : ProgressBar의 모양

- max : 최대값
    - 최소값은 0

- progress : 현재값




#### 5.2 주요 메서드

- incrementProgressBy : 지정된 값만큼 증가 혹은 감소

- setProgress : 주어진 값으로 설정






### 6. SeekBar

> 좌우로 움직이면서 사용자에게서 값을 입력받기 위한 바



#### 6.1 주요 속성

- style : SeekBar의 모양
    - discrete : 일정 눈금씩만 조절 가능

- max : 최대값
    - discrete 같은 경우 1마다 눈금 부여

- progress : 현재값




#### 6.2 주요 메서드

- incrementProgressBy : 지정된 값만큼 증가 혹은 감소

- setProgress : 지정된 값으로 설정

- getProgress : 현재 설정된 값




#### 6.3 주요 리스너

- OnSeekBarChangeListener : SeekBar의 값이 변경됐을 때 반응하는 리스너
    - 다음의 3개의 메서드를 오버라이드 하면 된다
        - onProgressChanged : 현재 값을 변경했을 때 호출되는 메서드
            - fromUser : true면 사용자의 입력으로 변경됨, false면 코드에 의해서 변경됨
        - onStartTrackingTouch : 값을 변경하기 위해 터치하면 호출되는 메서드

        - onStopTrackingTouch : 값을 변경하고 터치를 떼면 호출되는 메서드







### 7. EditText

> 사용자에게 문자열을 입력받는 용도로 사용하는 뷰



#### 7.1 종류

> 종류에 따라 입력방식을 제한할 수는 있지만, 복사 붙여넣기를 통해서 다른 방식이 입력될 수 있으므로 코드에서 검사하도록 하자



- Plain Text
    - 아무 것도 설정 안 함

- Password

- Password (Nemeric)

- E-mail

- Phone

- Postal Address

- Multiline Text

- Time

- Date

- Number

- Number(Signed)

- Number (Decimal)

- TextInputLayout



#### 7.1 주요속성

- inputType : 입력받을 데이터의 형태
    - number : 숫자패드만 나오도록

    - textPersonName : 이름 입력받도록 영문자부터

- hint : 안내 문구 설정
    - 텍스트 뷰에 아무 것도 입력하지 않았을 때 보여주는 문자열

- text : 처음 보여질 때 나타날 문자열

- imeOptions : 키보드 엔터 키의 형태 설정

    - 스마트폰의 엔터 형태를 바꾸고 싶을 때 (돋보기로 바꾼다든가 등)

    - 모양만 바꾼다




#### 7.2 주요 메서드

- setText : EditText에 문자열을 설정

- getText : editText에 입력한 문자열을 가져온다




#### 7.3 주요 리스너

- OnEditorActionListener : 엔터 키를 누르면 반응하는 리스너

    - onEditorAction(Editor 뷰의 주소값, Editor 뷰의 아이디, 사건 객체)
        - return false; 로 끝나면 엔터 눌렀을 때 입력창이 사라짐 (컴퓨터키보드의 엔터가 아님)

- TextWatcher : 입력을 할 때마다 반응하는 리스너

    - onTextChanged : 문자열 값이 변경됐을 때

    - beforeTextChanged : 문자열 값이 변경되기 전

    - afterTextChanged : 문자열 값이 변경된 후






### 8. ImageView

> 이미지를 사용자에게 보여주고자 하는 목적으로 제공되는 뷰




#### 8.1 주요속성

- src : 보여줄 이미지를 지정하는 속성

    - 이제는 아래 속성을 주로 사용

    - 모든 폴더와 파일의 이름은 소문자로만 구성되어야 한다

- srcCompat : 기본적으로 src와 동일하나, 벡터 방식의 이미지(SVG, PSD 등)를 처리할 수 있는 기능이 추가된 속성
    - 안드로이드 5.0 이후에 추가됨

    - 비트맵 방식 : 각 픽셀에 이미지 색깔 정보값
        - 이미지 처리가 빠름
        - 확대&축소 시 이미지가 깨짐
        - 2D 이미지 등

    - 벡터 방식 : 어디서부터 어디까지 무슨 색깔로 채워라, 무슨 도형을 그려라 등의 명령어 형식으로 정보
        - 확대&축소에도 이미지가 자연스러움
        - 3D 게임 등




#### 8.2 Drawable vs Mipmap

- 이미지를 넣는 폴더는 drawable 폴더

    - 어플 내부에서 사용하는 이미지

- 안드로이드가 버전 업그레이드 되면서 mipmap이라는 폴더를 제공
    - 이 폴더 내의 이미지는 비트맵이 아닌 벡터 방식으로 이미지를 그림
        - jpg, png 등의 비트맵 방식 이미지를 넣으면 안드로이드 OS가 분석하여 벡터 방식으로 변환하여 관리

    - mipmap 폴더는 런처 아이콘용 이미지를 넣는 폴더로 사용

    - 안드로이드 버전 업그레이드로 해상도 조절이 가능하게 되어서 mipmap 기능이 필요해짐




#### 8.3 주요 메서드

- setImageResource(R.drawable.이미지이름) : res 폴더에 있는 이미지를 설정

    - 이미지 소스의 객체를 직접 만들 필요 X

    - res 폴더에 있는 이미지는 이 메서드를 통해서 사용

    - 카메라로 지금 촬영한 이미지 혹은 네트워크의 서버에서 받은 이미지들은 개발자가 데이터를 받아서 객체를 생성하여 사용

- setImageBitmap : Bitmap 객체로 만들어진 이미지를 설정

- setImageDrawable : Drawable 객체로 만들어진 이미지를 설정

