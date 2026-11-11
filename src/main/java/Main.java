import app.Invoker;
import app.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Invoker.runAllProtectedPrivateMethods(myClass);

    }
}
