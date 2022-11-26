import anonimowe.SomeInterface;
import generycznie.*;
import lambda.Checker;
import lambda.Human;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
       // anonymous();
       // generic();
       // checker();
       //lambda();
       // sort();
        human();
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

    private static void checker(){
        Checker<Integer> isEven = new Checker<Integer>() {
            @Override
            public boolean check(Integer object) {
                return object%2 == 0;
            }
        };

        System.out.println(isEven.check(123));
        System.out.println(isEven.check(124));

        Checker<Integer> isEvenLambda = (object) -> object%2 == 0;
        System.out.println(isEvenLambda.check(123));
        System.out.println(isEvenLambda.check(124));

        Function<Integer, Long> func = (x) -> {
            if(x!= null && x%2 == 0)
                return (long)x*x;
            else
                return 0L;
        };
        System.out.println(func.apply(126));

        Consumer<Integer> consumer = (i) -> System.out.println("Dostałam "+ i);
        consumer.accept(15);

        Supplier<String> someString = () -> "jakiś tekst";
        System.out.println(someString.get());

        UnaryOperator<Integer> pow = x -> x*x;
        System.out.println(pow.apply(4));

        BiPredicate<Integer, Integer> equals = (a,b) -> a == b;
        System.out.println(equals.test(10, 12));
        System.out.println(equals.test(12, 12));

        Object o = new Object();
        System.out.println(o.hashCode());
        Supplier<Integer> method = o::hashCode;
        System.out.println(method.get());
        //to samo
        IntSupplier method1 = o::hashCode;
        System.out.println(method1.getAsInt());

        //bez podania instancji
        Function<Object, Integer> hash = Object::hashCode;
        System.out.println(hash.apply(o));

        ToIntFunction<Object> hash2 = Object::hashCode;
        System.out.println(hash2.applyAsInt(o));

        //Odwolanie sie do konstuktora
        Supplier<Object> objectSupplier = Object::new;
        System.out.println(objectSupplier.get());

    }

    private static void lambda(){
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        // Wyswietl zawartosc listy
        for(Integer number : numbers){
            System.out.println(number);
        }

        // funkcyjnie
        System.out.println("Funkcyjnie");
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);
        System.out.println("Jeszcze inaczej");
        numbers.forEach(System.out::println);
    }

    private static void sort(){
       	/*
       	Napisz program, który pobierze od użytkownika cztery łańcuchy znaków, które umieścisz w liście.
       	Następnie posortuj tę listę używając metody List.sort.
       	Użyj wyrażenia lambda, które posortuje łańcuchy znaków malejąco po długości
       	 */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 4 łańcuchy znaków odzielając je znakiem nowej lini");
        List<String> strings = new ArrayList<>();
        for(int i=0; i<4; i++)
            strings.add(scanner.nextLine());

        System.out.println(strings);
        //strings.sort((a, b) -> b.length()-a.length());
        strings.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(strings);

    }

    private static void human(){
        // Utworz obiekt z uzyciem wyrazenia lambda
        BiFunction<Integer, String, Human> humanBiFunction = Human::new;
        Function<Human, String> function = Human::getName;

        Human human = humanBiFunction.apply(34, "Janek");
        Human human1 = humanBiFunction.apply(45, "Zenek");

        Supplier<String> name = human::getName;
        System.out.println(human.getAge());
        System.out.println(name.get());
        System.out.println(function.apply(human));

        Predicate<Human> equalMethod1 = human::equals;
        System.out.println(equalMethod1.test(human1));
        System.out.println(equalMethod1.test(human));

        BiPredicate<Human, Human> equalMethod2 = Human::equals;
        System.out.println(equalMethod2.test(human, human));
        System.out.println(equalMethod2.test(human1, human));

    }
}