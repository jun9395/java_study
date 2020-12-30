import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
    public static void main(String[] args) {
        try {
            // 서버 소켓 생성
            ServerSocket server = new ServerSocket(22323);   // 포트는 되도록 10000번 이상을 쓰자
                // 인터넷 통신은 80번, FTP는 21번 등


            // 사용자 접속 대기
            System.out.println("사용자 접속 대기");
            Socket socket = server.accept();

            // 스트림 연결
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // 필터 스트림
            DataInputStream dis = new DataInputStream(is);
            DataOutputStream dos = new DataOutputStream(os);


            // 데이터 송수신
            dos.writeUTF("서버의 메시지입니다");
            String recData = dis.readUTF();

            System.out.println(recData);


            // 접속 종료
            socket.close();


            // 서버 종료
            server.close();
        } catch (Exception e) {}
    }
}
