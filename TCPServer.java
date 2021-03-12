import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // CLOSED 是抽象的状态，实际上可能不存在
        ServerSocket serverSocket = new ServerSocket(8888);
        // serverSocket 对应的一个“连接”的状态是 LISTEN
        while (true) {
            Socket socket = serverSocket.accept();
            // socket 对应的连接，是什么状态？
            // socket 对应连接已经是 ESTABLISHED 状态
            System.out.println("有一条连接已建立");

            executorService.execute(() -> {
                try {
                    synchronized (TCPServer.class) {
                        TCPServer.class.wait();
                    }


                    socket.close();
                } catch (IOException | InterruptedException e) {
                }
                // CLOSED 是抽象状态
            });
        }
    }
}
