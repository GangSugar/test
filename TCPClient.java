import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 连接是 CLOSED 状态，抽象的
        Socket socket = new Socket("182.254.132.183", 8888);
        // 已经是 ESTABLISHED 状态

        socket.getInputStream().read();
    }
}
