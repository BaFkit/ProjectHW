package ads.Lesson2;

public enum Brand {
    Lenuvo(1),
    Asos(2),
    MacNote(3),
    Eser(4),
    Xamiou(5);

    public int priority;

    Brand(int priority){
        this.priority = priority;
    }
}
