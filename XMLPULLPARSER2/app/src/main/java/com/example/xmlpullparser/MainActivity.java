package com.example.xmlpullparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_id);
        InputStream stream = this.getResources().openRawResource(R.raw.std);
        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = xmlPullParserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(stream, null);
            String tag_name = " ", tex = " ";
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                tag_name = parser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        tex = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        switch (tag_name) {
                            case "name":
                                textView.append("NAME" + tex + "\n");
                                break;
                            case "rollno":
                                textView.append("RollNo" + tex + "\n");
                                break;
                        }
                        break;
                }
                event = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}