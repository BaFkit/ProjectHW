package Java_3.Lesson7;

import java.lang.reflect.Method;

public class Priority implements Comparable<Priority>{
    private final Method method;
    private final byte priority;

    public Priority(Method method, byte priority) {
        this.method = method;
        this.priority = priority;
    }

    public Method getMethod(){
        return method;
    }

    public byte getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Priority o) {
        return Byte.compare(o.getPriority(), this.getPriority());
    }
}
