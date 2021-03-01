package com.ssafy.xmlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.textView);
    }


    public void ConnectXMLNetwork(View view) {
        NetworkThread thread = new NetworkThread();
        thread.start();
    }


    class NetworkThread extends Thread {
        @Override
        public void run() {
            try {
                URL url = new URL("http://172.30.1.36:8081/XmlServer/basicxml.jsp");
                URLConnection conn = url.openConnection();

                InputStream is = conn.getInputStream();

                // DOM 방식으로 XML 문서를 분석할 수 있는 parser 객체 생성
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                // xml 파일의 데이터를 싹 읽어온 다음에 분석작업이 끝나면 doc 객체에 넣는다
                Document doc = builder.parse(is);

                // 최상위 Root 태그 객체를 얻는다
                Element root = doc.getDocumentElement();
                // 하위 태그들은 여러 개가 있을 수 있으므로 1개가 있더라도 무조건 리스트로 가져온다
                NodeList item_list = root.getElementsByTagName("item");

                text1.setText("");

                for (int i = 0; i < item_list.getLength(); i++) {
                    // i번째 item 태그 객체 추출
                    Element item_tag = (Element)item_list.item(i);

                    // item 태그 안의 태그들을 얻어온다
                    NodeList data1_list = item_tag.getElementsByTagName("data1");
                    NodeList data2_list = item_tag.getElementsByTagName("data2");
                    NodeList data3_list = item_tag.getElementsByTagName("data3");

                    Element data1_tag = (Element)data1_list.item(0);
                    Element data2_tag = (Element)data2_list.item(0);
                    Element data3_tag = (Element)data3_list.item(0);

                    // 문자열 데이터 추출
                    final String data1 = data1_tag.getTextContent();
                    String data2 = data2_tag.getTextContent();
                    String data3 = data3_tag.getTextContent();

                    final int a2 = Integer.parseInt(data2);
                    final double a3 = Double.parseDouble(data3);

                    runOnUiThread(() -> {
                        text1.append("data1 : " + data1 + "\ndata2 : " + data2 + "\ndata3 : " + data3 + "\n");
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}