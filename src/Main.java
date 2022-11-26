import anonimowe.SomeInterface;
import generycznie.*;

public class Main {
    public static void main(String[] args) {
       // anonymous();
        generic();
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

    private static void generic(){
        AppleBox appleBox = new AppleBox(new Apple());
        System.out.println(appleBox.getApple());

        FruitBox fruitBox = new FruitBox(new Orange());
        Orange orange = (Orange) fruitBox.getFruit();

        BoxOnSteroids<Apple> appleBoxOnSteroids = new BoxOnSteroids<Apple>(new Apple());
        BoxOnSteroids<Orange> orangeBoxOnSteroids = new BoxOnSteroids<>(new Orange());
        Orange fruit = orangeBoxOnSteroids.getFruit();
        System.out.println(fruit);

        Pair<BoxOnSteroids<Apple>, BoxOnSteroids<Orange>> pair = new Pair<>(new BoxOnSteroids<>(new Apple()),
                                                                            new BoxOnSteroids<>(new Orange()));

        FigureBox<Circle> figureBox = new FigureBox<>(new Circle());
        System.out.println(figureBox.getElement().getName());

        //FigureBox<Apple> figureBox1 = new FigureBox<Apple>(new Apple());
    }
}