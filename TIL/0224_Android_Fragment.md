## Fragment

- 여러 화면을 갖고 있다는 것은 여러 Activity를 갖고 있다는 뜻이다

- Activity는 독립된 실행단위로 메모리를 많이 소모하는데, 독립된 실행단위가 아닌 화면만 필요한 경우 Activity보다는 Fragment를 사용하는 것이 효율적이다

- Fragment는 Activity 내의 작은 화면의 조각으로 Activity의 화면을 여러 영역으로 나누어 관리하고자 하는 목적으로 사용



### 1. Fragment

- Fragment는 안드로이드 5.0에서 추가됐지만 하위 버전에서도 사용할 수 있도록 설계됨
    - 한번 배치된 프래그먼트 객체를 또 배치하도록 하면 오류가 발생하여 튕김

- add : Fragment를 지정된 레이아웃에 추가

- replace : 지정된 레이아웃에 설정되어 있는 Fragment를 제거하고 새로운 Fragment로 추가
    - 없으면 배치

- Fragment 내에 배치된 Button은 onClick 불가능



#### 1.1 AddToBackStack

- 안드로이드의 Back Button은 현재 액티비티를 종료한다

- Fragment는 Activity가 아니므로 Back Button으로 제거할 수 없는데, AddToBackStack 메서드를 통해 Back Stack에 포함할 경우 Back Button으로 제거할 수 있다

- 이를 통해 이전 화면으로 돌아가는 듯한 효과를 줄 수 있다





### 2. Activity Controller

- 웹, 모바일 등 애플리케이션 개발 시 눈에 보이는 화면들을 관리하는 요소를 Controller라고 부른다

- 만약 눈에 보이는 모든 화면을 Fragment로 만들어 사용할 경우 Fragment를 관리하는 Activity가 Controller의 역할
    - 각 Fragment를 교환하고 관리하는 역할

    - Fragment들이 사용할 데이터를 관리하는 역할







### 3. ListFragment

- Fragment 내에 ListView를 사용할 때 보다 편리하게 구성할 수 있도록 제공되는 Fragment
  - Fragment 안에 있는 ListView가 딱 하나만 있어야 한다
- ListView의 id가 @android:id/list로 설정되어 있을 경우 자동으로 ListView를 찾아 관리
  - Fragment가 아니라 ListFragment를 상속할 경우에





### 4. DialogFragment

- AlertDialog를 Fragment로 만들어 사용할 수 있도록 제공되는 Fragment
- AlertDialog와 큰 차이는 없다
- 현업에서 개발하다보면 DialogFragment를 사용하는 것이 더 편할 때가 종종 있다
  - AlertDialog는 안드로이드에서 제공하는 대로 사용하게 되지만, DialogFragment는 커스텀이 용이하다



