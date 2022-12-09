package com.example.domparsing;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    RecyclerView recyclerView;
    ArrayList<model> slist=new ArrayList<>();
    RecleryAdapterClass adapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            InputStream stream = getAssets().open("file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse(stream);
            Element element = d.getDocumentElement();
            element.normalize();

            NodeList nodeList = d.getElementsByTagName("students");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element1 = (Element) node;

                    model obj = new model();
                    obj.setName(getValue("name", element1));
                    obj.setCourse(getValue("course", element1));
                    obj.setMobile(getValue("mobile", element1));
                    slist.add(obj);
                    Log.d("list","list"+slist);
                    System.out.println(slist);
                    adapterClass = new RecleryAdapterClass(slist);
                    recyclerView.setAdapter(adapterClass);

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String name, Element element1) {
        NodeList node = element1.getElementsByTagName(name).item(0).getChildNodes();
        Node nodes = node.item(0);
        return nodes.getNodeValue();
    }
}