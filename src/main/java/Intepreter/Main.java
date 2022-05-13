package Intepreter;

public class Main {
    public static void main(String[] args) {
        var path = "C:/Users/Regina Hamatova/Desktop/Study/SampleInterpreter/src/main/java/example.smpl";
        var interpreter = new Interpreter(path);
        interpreter.run();
    }
}
