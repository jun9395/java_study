import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 서버 역할을 위해 객체 생성
			ServerSocket server = new ServerSocket(55555);
			
			// 사용자 접속 대기
			System.out.println("사용자 접속 대기");
			// 보통은 이 server.accept()를 반복문을 통해서
			// 많은 사용자의 접속이 가능하게 해준다
			Socket socket = server.accept();
//			System.out.println(socket);
			
			// 입출력 스트림
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 데이터 스트림 연결
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			
			// 서버가 데이터를 보냄
			dos.writeInt(100);
			dos.writeDouble(11.11);
			dos.writeBoolean(true);
			dos.writeUTF("서버가 보낸 문자열");
			
			// 클라이언트가 보낸 데이터를 받음
			int data1 = dis.readInt();
			double data2 = dis.readDouble();
			boolean data3 = dis.readBoolean();
			String data4 = dis.readUTF();
			
			System.out.println("data1 : " + data1);
			System.out.println("data2 : " + data2);
			System.out.println("data3 : " + data3);
			System.out.println("data4 : " + data4);
			
			
			socket.close();
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
