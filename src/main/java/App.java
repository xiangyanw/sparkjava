import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8080);

        // 添加before过滤器来处理请求头
        before((request, response) -> {
            if ("keep-alive".equalsIgnoreCase(request.headers("Connection"))) {
                // 设置响应头来关闭连接
                response.header("Connection", "close");
            }
        });

        String cpuArch = System.getProperty("os.arch");
        get("/", (req, res) -> {
            // 返回更加显眼的HTML
            return "<html><body style='text-align:center; font-family: Arial, sans-serif;'>" +
                   "<h1 style='color: #FF5733; font-size: 48px; margin-top: 100px;'>Hello from</h1>" +
                   "<div style='color: #3498DB; font-size: 72px; font-weight: bold; margin: 30px;'>" + 
                   cpuArch + 
                   "</div>" +
                   "</body></html>";
        });
    }
}
