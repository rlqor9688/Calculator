1. 요구사항(Level 3 기준)
- Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용하기
- 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기(ArithmeticCalculator 클래스)
- 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력(ArithmeticCalculator 클래스)

2. 구현(Level 3 기준)
2-1. 설계: ArithmeticCalculator 클래스와 Main 클래스를 생성
- ArithmeticCalculator<T>: 사칙연산 기호에 따라 연산을 수행하는 클래스.
- Main: 유저로부터 입력값을 받아 ArithmeticCalculator 클래스의 동작을 결정하는 클래스.

2-2. 세부 설계
- ArithmeticCalculator<T>
1) enum OperatorType : 연산자와 연산 방법을 저장한 상수 배열
2) ArithmeticCalculator<T>
속성: T input1~2 (계산기용), T input3 (결과값 비교용), double result(결과값 저장용), List<Double> results (결과값들을 모아둔 컬렉션), OperatorType operator (연산 반환용)
생성자:
기능: getResult(결과값 조회), getResults(결과값 컬렉션 조회), findBySymbol(입력한 연산 기호에 맞는 연산 방법(OperatorType) 반환), calculate(연산 수행), printResultsGreaterThan(결과값 비교)

- Main
1) Scanner로 입력 값을 받아온다(input1, input2, 연산자)
2) 연산자에 해당하는 OperatorType을 findBySymbol 함수로 찾아, 이 연산을 input1~2와 함께 calculate 함수에 넣어준다. (calculate(input1, input2, operator))
3) 결과값은 this.result에 넣고, 이 값을 results 컬렉션에 추가해준다.
4) 계산이 끝나면 Scanner로 계속 할지 묻는다. exit 입력 시 프로그램을 종료한다. exit 이외의 값을 입력할 경우 1~2의 과정을 반복한다.
5) exit 입력 시 Scanner로 값을 비교할지 묻는다. yes 입력 시 Scanner로 비교하고 싶은 값을 입력하라고 한다.
6) 입력한 값을 printResultsGreaterThan함수에 넣고 결과를 출력해준다
7) 프로그램을 종료한다.
 
(기타: 0으로 나누는 에러 발생 시 throw new ArithmeticException을 하고, main에서 이를 catch해 "0으로 나눌 수 없습니다."를 출력한다.)
