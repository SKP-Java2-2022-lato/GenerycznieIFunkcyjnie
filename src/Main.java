import anonimowe.SomeInterface;

public class Main {
    public static void main(String[] args) {
        anonymous();
    }

    private static void  anonymous(){
        SomeInterface someInterface = new SomeInterface() {
            @Override
            public void doSomething() {
                System.out.println("Robię coś!");
            }
        };
        someInterface.doSomething();
        System.out.println(someInterface.getClass());

    }
}