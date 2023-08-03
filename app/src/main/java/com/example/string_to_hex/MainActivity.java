package com.example.string_to_hex;
import androidx.appcompat.app.AppCompatActivity;
import java.nio.ByteBuffer;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView tvViewport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvViewport = findViewById(R.id.tvViewport);

        String str1 = "192";                       // байт 0xС0
        String strIn = "192..Привет мир...192";    // Входящая строка
        int strlen = 3;                            // Длина искомого 0xС0 HEX

        char[] chars = strIn.toCharArray();
        StringBuffer hex1 = new StringBuffer();    // начало chars
        StringBuffer hex2 = new StringBuffer();    // конец chars
        StringBuffer hex = new StringBuffer();     // результат

        for(int i = 0; i < strlen; i++){
            hex1.append(chars[i]);
        }
        for(int i = chars.length - strlen; i < chars.length; i++){
            hex2.append(chars[i]);
        }

        if (hex1.toString().equals(str1) & hex2.toString().equals(str1)) {
            for(int i = strlen; i < chars.length-strlen; i++){
                hex.append(Integer.toHexString(chars[i]));
            }
            System.out.println("HEX string: " + hex);
            tvViewport.setText(hex.toString());
        }
    }
}