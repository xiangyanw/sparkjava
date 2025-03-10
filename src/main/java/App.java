import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);

        String cpuArch = System.getProperty("os.arch");
        get("/", (req, res) -> "Hello from <b>" + cpuArch + "</b>!");
    }
}
