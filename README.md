# Java 수업과 Swing·JDBC 프로젝트

문법·컬렉션·파일·Swing 실습과 Oracle DB를 연결한 관리 프로그램을 함께 보관한 2025년 수업 저장소.

## 먼저 볼 프로젝트

[Movie Sniper](JavaTermProject/README.md)는 영화 목록·검색·등록·수정·삭제를 처리하는 Swing 프로그램이다. 등록·수정 입력을 `MovieFormPanel`로 공유하고, `MovieController`가 이벤트를 `MovieRepository`의 PreparedStatement 쿼리에 연결한다.

![영화 목록 화면](JavaTermProject/README/main.png)

## 자료 위치

| 폴더 | 내용 |
|---|---|
| `JavaTermProject/` | 영화 관리 GUI, 화면 이미지, DB schema 설명 |
| `Java_Project1/` | Java 기초 수업 코드 |
| `Java_Project2/` | 배열·메서드·파일·Swing, JDBC 고객/도서 관리 실습 |
| `Vending_Machine/` | 자판기 예제 |

각 폴더는 독립 프로젝트다. 루트에 공통 Gradle/Maven 빌드가 없다. IDE에서 사용할 프로젝트를 열고 `src/`를 source root로 지정한다. JDBC 예제에는 Oracle DB와 ojdbc driver 설정이 필요하다. 상세 조건은 Movie Sniper README를 확인한다.

수업·과제 저장소이므로 전체를 하나의 서비스나 직접 설계한 제품으로 소개하지 않는다. 기존 MovieSniper의 일부 구현이라는 설명과 클래스별 리팩터링 기록을 유지한다. API 서버·배포·자동 테스트가 있는 프로젝트는 아니다.
