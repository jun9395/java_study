import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkClient {
    public static void main(String[] args) {
        try {
            // 소켓 객체 생성(서버 접속)
            Socket socket = new Socket("127.0.0.1", 22323);    // 자기 자신을 뜻하는 아이피


            // 스트림 연결
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(is);
            DataOutputStream dos = new DataOutputStream(os);


            // 데이터 송수신 - 서버와 순서를 맞물리게 해야한다
            String recData = dis.readUTF();
            dos.writeUTF("클라이언트가 보낸 메시지입니다");
            System.out.println(recData);


            // 접속 종료
            socket.close();
        } catch (Exception e) {}
    }
}
