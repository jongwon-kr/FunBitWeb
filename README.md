# 🌐 MY 통합 웹페이지 (JWeb)

## 프로젝트 기간
- 2024.03 ~

## 개발 인원
- 개인프로젝트

## 사용언어 및 개발환경
- Java, Javascript, Springboot, React, Docker, MySql, Intellij

## 프로젝트 목적
- 나만의 페이지를 만들어 보고자 시작하였으며 1시간 단위로 급 상승 인기 검색어를 갱신해주며 제공
- TODO리스트도 관리하는 통합 웹페이지로 Springboot의 기능들과 Spring Data JPA, JWT인증 API사용등을 통해 전반적인 숙련도 향상

## 개발 내용
- Spring Scheduler를 사용하여 1시간 단위로 구글의 검색 볼륨이 가장 높은 것부터 일정 볼륨을 가지는 키워드까지 DB에 업데이트 구현
- JPA를 통한 Todo list CRUD구현
- 사용자로 로그인을 했을 경우 JWT를 통한 인증시스템으로 TODOLIST를 사용할 수 있도록 구현
- React에서 axios를 통해 Spring 서버와 http통신을 연결 하고 JPA와 RestAPI 호출로 데이터 전송 구현
- Docker 환경에서 Springboot + Mysql + selenium을 구현하였다.

## 느낀점 및 문제 해결
- Springboot의 JPA, Security, OAuth2 등 사용해보고 싶은 기술들을 조합하여 구현하였고 Docker컨테이너로 DB생성, Selenium 개발 환경 구축등 여러 테스트를 진행하며 개발
- Selenium을 통해 데이터들을 가져오는 과정에서 요소를 못찾는 오류가 많이 발생 할 것이라 생각하여 단위 테스트 진행을 위해 메소드 테스트 코드를 작성하여 개발
- 검색어 fetch나 TODO데이터의 보안을 위해 엔드포인트에 Spring보안필더를 설정함으로써 익명 사용자와 로그인 사용자의 API요청을 구분되게 개발
- AWS에 Docker Compose로 배포를 한 후 배포 자동화 작업을 구현중

## 구현 
[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/v0881c75XOI/0.jpg)](https://www.youtube.com/watch?v=v0881c75XOI)

<img src="https://github.com/jongwon-kr/BitProject/assets/76871947/60593c97-c90d-43bf-991c-db1d3df43b6e" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/0ca7dff8-2825-461f-a7ab-401079bab400" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/afb5dcf1-acc7-444f-a6f1-d4a313eee0bc" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/5a5a04ed-607c-418b-84ef-90087034d52b" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/c1f788a9-77d9-4924-8b4b-6fd60e2a5e82" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/1b920af4-c9fa-4188-a62d-1fcbba6e6a95" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/522376ec-96c2-4e98-9d24-932b36ecb893" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/56f06c07-1598-48e8-b701-e4aac256b9e1" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/5b4685b5-1ec5-41a2-9046-34b0d2a0f8bd" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/74a59fa6-8610-4e03-9d1d-7bf7efeb0213" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/a5e03e0b-f9f7-40aa-a1b4-afe5fc2a8816" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/d586da69-a262-4e47-b6ef-2ce834f370dd" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/cc8b8b2d-97a5-4c64-8d01-3d0e88a2c107" width="750" height="400">
 <img src="https://github.com/jongwon-kr/JWeb-server/assets/76871947/df1d5f40-6fbe-4e5b-9d7a-cd0a0268e731" width="750" height="400">


