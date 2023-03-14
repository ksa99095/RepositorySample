# RepositorySample
Android Repository Sample

<br/><br/>


**Repository란?**

데이터 출처(로컬 DB인지 API응답인지 등)와 관계 없이 동일 인터페이스로 데이터에 접속할 수 있도록 만드는 것을 Repository 패턴이라고 한다. 레포지토리는 데이터 소스에 액세스하는 데 필요한 논리를 캡슐화하는 클래스 또는 구성 요소이다.

<br/>

**Repository 패턴을 사용하는 이유?**

- 도메인과 연관된 모델을 가져오기 위해 필요한 DataSource 가 무엇인지 Presenter 계층에서는 알 필요가 없다.
- Presentation Layer(ViewModel)에서는 Repository에 데이터 요청만 하면 되므로, 일관된 인터페이스로 데이터를 요청할 수 있다.
- Presentation Layer에서 Data Layer에 직접 접근하지 않으므로, 새로운 Data의 추가가 쉽다.
- DataSource 의 변경이 발생하더라도 다른 계층은 영향받지 않는다.
- client 는 repository 인터페이스에 의존하기 때문에 Unit Test를 통한 검증이 쉬워진다.

Repository는 Presenter Layer과 Data Layer 간의 의존성을 줄여줌으로, DataSource 추가나 변경에 있어 다른 계층은 영향을 받지 않아 소스 수정에 부담이 적다.


<br/><br/>

## 구조

<br/>

<p align="center">
<img src="https://user-images.githubusercontent.com/63940434/224926602-f017a4de-f099-4da4-ac71-8d6267dd5972.png" width=600 height=500>
<br/>View → Presenter / ViewModel → Repository → DataSource (API, Local DB)
</p>

<br/>
Presenter / ViewModel에서 직접 Data에 접근하여 가져오는 것이 아니라, Repository로만 접근한다.<br/>
Repository에서는 Remote / Local Data 를 판단하여 필요한 데이터를 가져와 ViewModel에 전달해준다.<br/><br/>
즉, 데이터 소스의 위치를 몰라도 일관성 있게 원하는 데이터를 취할 수 있도록 돕는 역할을 한다.<br/>
