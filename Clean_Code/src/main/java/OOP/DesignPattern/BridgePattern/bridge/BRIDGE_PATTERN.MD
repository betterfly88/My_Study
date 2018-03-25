# Bridge Pattern

![Alt text](./Bridge_UML_class_diagram.svg.png)

> 브릿지 패턴의 이해
* 기능과 구현부분의 분리

1. 추상클래스에서 필요한 기능을 모두 정의한다
(Abstraction)

```java

public interface MorseCodeFunction {
    public void dot();
    public void dash();
    public void space();

}
```
2. 기능을 재정의하는 클래스를 구현한다(Refined Abstraction)
```java

public class MorseCode {

    private MorseCodeFunction function;

    public MorseCode(MorseCodeFunction function){
        this.function = function;
    }

    public void setFunction(MorseCodeFunction function){
        this.function = function;
    }

    public void dot(){
        function.dot();
    }

    public void dash(){
        function.dash();

    }

    public void sapce(){
        function.space();
    }
}

```

3. 기능을 실제로 구현하는(작동하는) 클래스 구현한다  
=> 이부분이 핵심. 
필요에 따라 구현을 개조하여 실행 클래스에서 유연하게 조립하여 사용할 수 있다 
(Implementor)
```java

public class PrintMorseCode implements MorseCodeFunction {

    @Override
    public void dot() {
        System.out.print(".");
    }

    @Override
    public void dash() {
        System.out.print("-");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}



```


4. 최종적으로 구현한 기능을 조립하여 실행해주는 클래스
```java

public class ExcuteMorseCode extends MorseCode{
    public ExcuteMorseCode(MorseCodeFunction function) {
        super(function);
    }

    //betterfly
    public ExcuteMorseCode b(){
        dash();dot();dot();dot();
        return this;
    }
    public ExcuteMorseCode e(){
        dot();
        return this;
    }

    public ExcuteMorseCode t(){
        dash();
        return this;
    }

    public ExcuteMorseCode r(){
        dot();dash();dot();
        return this;
    }

    public ExcuteMorseCode f(){
        dot();dot();dash();dot();
        return this;
    }

    public ExcuteMorseCode l(){
        dot();dash();dot();dot();
        return this;
    }

    public ExcuteMorseCode y(){
        dash();dot();dash();dash();
        return this;
    }
}


```
