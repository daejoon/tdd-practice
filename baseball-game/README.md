# 야구게임

[14회 공감세미나 TDD 발담그기](https://www.youtube.com/watch?v=hFXkjZthuzU&index=4&list=PLqguNAnlRGuGmVpYsU8AFkwLrJp07fGX3)의
야구 게임을 직접 `TDD`로 구현해 본다.

## 규칙

- 숫자 3개를 맞추면 이김
- 각 숫자는 겹치지 않음
- 예측한 숫자가 존재할 때
    - 위치가 같으면 스트라이크
    - 위치가 다르면 볼
    
## `First Baseball Game TDD`를 Commit 하고서

- BaseballGame 이라는 클래스 하나만 만들었는데 결과를 리턴하는 `Score`라는 협력 객체가 필요하다.
- 테스트 케이스에서도 공통부분(`assertMatch`)으로 메소드 추출이 가능하다.
