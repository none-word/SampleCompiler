package Intepreter;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        var currentPath = System.getProperty("user.dir");
        var path = currentPath + Paths.get("/src/main/java/Examples/hard.smpl");
//        var path = currentPath + Paths.get("/src/main/java/Examples/boolExample.smpl");
        var interpreter = new Interpreter(path);
        try {
            interpreter.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
