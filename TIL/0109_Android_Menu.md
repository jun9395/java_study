# Android Menu

## 1. Option Menu

> 화면당 하나씩 가질 수 있는 메뉴

> 현재 보이는 화면(Activity)의 메인 메뉴가 된다


### 1.1 onCreateOptionsMenu

> Activity의 객체가 만들어질 때 자동으로 호출되는 메서드

- 여기서 메뉴를 생성한다
    - 메서드가 true를 반환하면 메뉴가 나타난다



#### 1.1.1 xml로 메뉴 구성하기

> xml에 세팅되어 있는 대로 메뉴를 구성



1. res 폴더에서 우클릭 -> 안드로이드 리소스 경로 -> menu 타입

2. 소문자로 메뉴용 xml 생성

3. code를 확인하면 <menu> 가 있다. 여기에 item이라는 항목을 추가하여 메뉴를 구성한다

4. 이후 Activity에서 onCreateOptionsMenu 오버라이딩
    - true를 반환할 때만 메뉴 생성

5. 터치 시 반응하게 하려면 Activity에서 onOptionsItemSelected 오버라이딩




#### 1.1.2 code로 메뉴 구성하기

> 개발자가 코드를 통해서 만드므로 옵션 메뉴의 항목을 유동적으로 통제 가능



1. onCreateOptionsMenu 오버라이딩

2. menu.add(그룹아이디, 아이템아이디, 순서, 타이틀);
    - 그룹아이디 : 메뉴 아이디를 자유롭게 구성하면 메뉴를 그룹별로 묶을 수 있다

    - 아이템 아이디 : 정수값으로 자유롭게
        - Menu.FIRST는 1 값

    - 순서 : Menu.CATEGORY_순서 에 따라서 순서가 정해져서 메뉴가 구성됨
        - CONTAINER : 첫번째

        - SYSTEM : 두번째

        - SECONDARY : 세번째

        - ALTERNATIVE : 네번째

        - NONE : 구성한 순서대로

3. submenu를 가진 메뉴를 구성하려면 다음과 같이 한다

    ```java
    Menu sub = menu.addSubMenu("타이틀");	// 이렇게 하면 타이틀을 가진 서브메뉴를 가질 수 있는 객체가 생성됨
    sub.add("그룹아이디, 아이템아이디, 순서, 타이틀);
    ```





## 2. Context Menu

> 화면에 배치된 뷰에 설정할 수 있는 메뉴

> 메뉴가 설정된 뷰를 길게 누르면 메뉴가 나타난다



### 2.1 registerForContext

> 컨텍스트 메뉴를 등록하는 메서드

- 메서드의 매개변수로 넣어준 뷰 객체에 메뉴가 설정된다

- 실행예시

    ```java
    registerForContextMenu(뷰 객체);
    ```




### 2.2 onCreateContextMenu

> 컨텍스트 메뉴가 설정되어 있는 뷰를 길게 누르면 컨텍스트 메뉴 구성을 위해서 (안드로이드 OS가 호출하는 메서드

> 매개변수 ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo


- ContextMenu menu : menu를 이용해서 메뉴 구성

- View v : 컨텍스트 메뉴가 세팅된 뷰를 길게 눌렀을 경우, 해당 뷰의 주소가 들어온다

- ContextMenu.ContextMenuInfo menuInfo : 길게 눌렀을 때 나타나는 컨텍스트 메뉴에 대한 정보를 갖고 있는 객체
    - 몇 번째 항목을 길게 눌렀는지 등 정보 포함

    - 우선 menuInfo를 AdapterContextMenuInfo로 형변환 해줘야 한다




이후 컨텍스트가 설정된 메뉴마다 메뉴 목록이 다를 수 있으므로 주소를 참조하여 분기




### 2.3 onContextItemSelected

> 컨텍스트 메뉴의 항목을 터치하면 호출되는 메서드


컨텍스트메뉴는 여러 뷰에 세팅될 수 있으므로,

텍스트뷰를 길게 눌러서 나온 컨텍스트 메뉴의 항목을 눌러서 호출됐는지,

이미지뷰의 컨텍스트 메뉴의 항목을 눌러서 호출됐는지 여기서는 구분해야한다

하지만 여기서 따로 구분할 방법은 없다

그러므로 뷰가 다르다고 하더라도 컨텍스트 메뉴 항목의 아이디값을 전부 다르게 줘서

메뉴 항목의 아이디로 구분을 해주자






## 3. PopUp Menu

> 개발자가 원할 때 원하는 곳(뷰)에 띄우는 메뉴



### 3.1 주요 메서드

- getMenu : Popup Menu의 메뉴를 관리하는 객체를 반환
    - 이를 이용해 메뉴를 구성




### 3.2 리스너

- OnMenuItemClickListener : 메뉴의 항목을 눌렀을 때 반응하는 리스너
    - onMenuItemClick





## 4. ActionBar

> 화면 상단에 배치된 바 부분

- OptionMenu 항목의 일부를 (아이콘 형태 등으로) 배치할 수 있다

- 우선 OptionMenu를 구성해놓고, 원하는 메뉴를 골라서 상단 바에 배치하면 된다




### 4.1 구성하기

> Option Menu를 사용하는 방법과 동일하며 ActionBar를 위한 속성 몇 가지를 설정

- Icon : ActionBar에 표시되는 아이콘을 설정

- showAsAction : ActionBar 배치 여부를 결정. OptionMenu에 있는 메뉴 항목들이 각각 갖고 있는 속성으로, 옵션메뉴로 표시할 것인가 액션바로 표현할 것인가 결정

- actionViewClass : 접었다 폈다 할 때 나타날 뷰 설정




### 4.2 showAsAction 속성

- Never (기본) : 메뉴를 ActionBar에 절대 표시하지 않는다

- Always : 항상 ActionBar에 표시한다

- ifRoom : 공간이 허락한다면 ActionBar에 표시한다

- withText : title 속성의 문자열과 함께 표시된다
    - icon이 설정되어있다면 icon만 나오는데, 이를 설정하면 공간이 허락하면 title 문자열도 표시

- collapseActionView : 접었다 펼쳤다 하면서 뷰를 표시할 수 있다
    - 기본적으로 뷰 하나를 배치할 수 있다

    - ActionViewClass 에 배치

    - `android.widget.SearchView`는 검색을 위한 기본 뷰 
        - 호환성을 위해 `androidx.appcompat.widget.SearchView`


#### 4.2.1 android 기본 내장 SearchView

##### 리스너

> OnQueryTextListener

- onQueryTextChange : 서치 뷰의 문자열이 변경될 때마다 호출되는 메서드

- onQueryTextSubmit : 엔터 키를 누르면 호출되는 메서드