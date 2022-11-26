package generycznie;

public class FigureBox<T extends Figure>{
    private T element;


    public FigureBox(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
