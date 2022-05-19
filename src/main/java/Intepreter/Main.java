package Intepreter;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        var current_path = System.getProperty("user.dir");
        var path = current_path + Paths.get("/src/main/java/Examples/boolExample.smpl");
        var interpreter = new Interpreter(path);
        interpreter.run();
    }
}
