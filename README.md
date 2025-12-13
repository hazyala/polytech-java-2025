# 🎬 Movie Sniper (무비 스나이퍼)

> **Java Swing & Oracle DB 기반의 영화 정보 관리 시스템 (Administrator Mode)**

이 프로젝트는 대학 수업 과정에서 학습한 내용을 바탕으로, **MVC 패턴**과 **JDBC 연동**을 활용하여 제작한 영화 관리 프로그램입니다.
MovieSniper Project의 일부를 구현했습니다.
기본적인 **CRUD(등록, 조회, 수정, 삭제)** 기능뿐만 아니라, **코드의 재사용성**과 **유지보수성**을 높이기 위해 다양한 리팩토링 기법을 적용하여 심화 학습하였습니다.

---

## 🛠 Tech Stack (사용 기술)
- **Language**: Java (JDK 17)
- **GUI**: Java Swing (JFrame, JPanel, JTable 등)
- **Database**: Oracle Database
- **Library**: ojdbc8 / ojdbc17
- **IDE**: IntelliJ IDEA

---

## 📸 Screenshots (실행 화면)

### **1. 영화 목록 및 검색 (메인)**
<img src="README/main.png" width="800">
<br>
*전체 영화 목록 조회 및 조건별(제목, 감독 등) 검색 기능*

<br>

### **2. 영화 등록**
<img src="README/insert.png" width="800">
<br>
*새로운 영화 정보 입력 및 DB 저장*

<br>

### **3. 영화 수정 및 삭제**
<img src="README/update.png" width="800">
<br>
*선택한 영화 정보 수정 및 삭제 처리*

---

## 💡 Key Features & Improvements (주요 기능 및 개선사항)

수업 시간에 배운 내용을 기반으로 하되, **코드의 효율성과 가독성**을 높이기 위해 다음과 같은 부분들을 심화 학습하여 적용하였습니다.

### 1. MVC 패턴 구조화
* **Model (VO, DAO)**: 데이터베이스 접근과 데이터 객체를 명확히 분리하였습니다.
* **View**: 사용자 인터페이스(UI)를 담당하며, 로직을 포함하지 않도록 설계하였습니다.
* **Controller**: View와 Model 사이를 중재하며, 모든 이벤트 처리를 총괄합니다.

### 2. UI 스타일 중앙 관리 (`UIConstants`) 
* **[개선]**: 기존에는 각 화면마다 폰트와 색상을 개별적으로 지정했으나, **`util.UIConstants`** 클래스를 도입하여 **스타일(Font, Color)을 상수로 통합 관리**하였습니다.
* **효과**: 테마 변경 시 한 곳만 수정하면 전체 앱에 반영되며, 코드 중복이 획기적으로 줄어들었습니다.

### 3. 공통 폼 패널의 재사용 (`MovieFormPanel`) 
* **[개선]**: '등록 화면'과 '수정 화면'에서 영화 정보를 입력받는 UI가 동일함을 파악하고, 이를 **`MovieFormPanel`이라는 별도의 패널로 분리**하여 조립하는 방식을 택했습니다.
* **효과**: 중복 코드를 제거하고, 유지보수가 용이해졌습니다.

### 4. JDBC 자원 해제 최적화 (`JDBC_Connector`) 🔌
* **[개선]**: Repository의 모든 메소드마다 반복되던 `try-catch-close` 블록을 **`JDBC_Connector.close()` 정적 메소드**로 통합하였습니다.
* **효과**: DAO 코드가 훨씬 간결해지고 가독성이 향상되었습니다.

### 5. 유효성 검사 강화 (Validation) 
* **[개선]**: 사용자 입력값의 누락, 숫자/날짜 형식 오류 등을 사전에 방지하기 위해 꼼꼼한 예외 처리를 적용하였습니다.

---

## 📂 Project Structure (폴더 구조)

```text
src
 ├─ 📂 movie
 │   ├─ 📂 controller
 │   │   └─ MovieController.java    // 프로그램의 메인 두뇌 (이벤트 처리)
 │   ├─ 📂 domain
 │   │   └─ MovieVO.java            // 영화 데이터 객체 (Value Object)
 │   ├─ 📂 repository
 │   │   ├─ JDBC_Connector.java     // DB 연결 및 자원 해제 공통 모듈
 │   │   └─ MovieRepository.java    // DB CRUD 수행 (DAO)
 │   └─ 📂 view
 │       ├─ MovieMainFrame.java     // 메인 프레임 (탭 구성)
 │       ├─ MovieSearchView.java    // 탭1: 목록 조회 및 검색
 │       ├─ MovieInsertView.java    // 탭2: 영화 등록
 │       ├─ MovieUpdateView.java    // 탭3: 수정 및 삭제
 │       └─ MovieFormPanel.java     // [공용] 영화 정보 입력 폼
 └─ 📂 util
    ├─ CenterFrame.java            // 화면 중앙 배치 유틸
    └─ UIConstants.java            //  UI 스타일(폰트, 색상) 통합 관리
```

## 💾 Database Schema (데이터베이스 구조)

**[Table: MOVIE]**

```sql
-- Movie 영화 테이블
-- 1. 영화 ID 자동 증가를 위한 시퀀스 생성
CREATE SEQUENCE seq_movie_id START WITH 1 INCREMENT BY 1;

-- 2. 영화(Movie) 테이블 생성
CREATE TABLE Movie (
    movie_id      NUMBER(10)      NOT NULL,   -- 영화 고유 번호 (PK)
    title         VARCHAR2(200)   NOT NULL,   -- 영화 제목
    genre         VARCHAR2(100)   NOT NULL,   -- 장르
    runtime       NUMBER(4)       NOT NULL,   -- 상영 시간 (분)
    grade         VARCHAR2(20)    NOT NULL,   -- 관람 등급
    release_date  DATE            NOT NULL,   -- 개봉일
    poster        VARCHAR2(500),              -- 포스터 이미지 URL
    director      VARCHAR2(100),              -- 감독 이름 
    cast          VARCHAR2(500),              -- 출연 배우
    end_date      DATE,                       -- 상영 종료일 
    synopsis      CLOB,                       -- 줄거리 
    CONSTRAINT pk_movie PRIMARY KEY (movie_id)
);
```
