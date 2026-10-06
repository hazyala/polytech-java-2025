# 콘솔 자판기와 반려용품 키오스크

Scanner 입력으로 상품 선택·금액 계산·재고 또는 장바구니 상태를 처리하는 두 Java 프로그램.

## 음료 자판기

[vendingMachine/Vending_Machine](src/vendingMachine/Vending_Machine.java)은 음료 이름·가격·재고 배열을 같은 index로 관리한다. 번호를 선택하면 품절을 검사하고 투입 금액이 가격에 도달할 때까지 입력받는다. 구매가 끝나면 재고를 줄이고 잔돈과 보유 금액을 출력한다. `TimerThread`는 금액 입력 대기 중 타이머를 처리한다.

## 반려용품 키오스크

[kiosk/Kiosk](src/kiosk/Kiosk.java)는 고양이·강아지 상품군을 선택하고 상품·수량을 `Cart`에 넣는다. `CatProduct`와 `DogProduct`는 `PetProduct`의 상품 목록을 구현한다. 장바구니는 합계와 목록을 보여주며 결제 메뉴는 안내 메시지·대기 후 장바구니를 비운다. 외부 결제 호출과 DB 저장은 없다.

## 실행

IDE에서 이 폴더를 열고 `src/`를 source root로 지정한다. 음료 프로그램은 `vendingMachine.Vending_Machine.main`, 반려용품 프로그램은 `kiosk.Kiosk.main`을 실행한다. 표준 Java 클래스만 사용하며 Maven/Gradle 구성은 없다. 두 프로그램의 데이터는 실행 중 메모리에 있다.
