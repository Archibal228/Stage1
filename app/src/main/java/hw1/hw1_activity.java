package hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.a081995gmail.ivany4.android.R;

import org.w3c.dom.Text;

import classwork2.classwork2Activity;

public class hw1_activity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView text1;
    TextView text2;
    private View.OnClickListener listerner = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String text = (String) text2.getText();
            text2.setText(text1.getText());
            text1.setText(text);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw1_activity);
        button = findViewById(R.id.button);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        text1.setOnClickListener(this);
        text2.setOnClickListener(listerner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(hw1_activity.this, classwork2Activity.class);
//                startActivity(intent);
//                intent.putExtra(classwork2Activity.KEY_TEXT, "Helloooooooooo");
                String text = (String) text2.getText();
                text2.setText(text1.getText());
                text1.setText(text);
            }

        });


    }


    @Override
    public void onClick(View view) {
        String text = (String) text2.getText();
        text2.setText(text1.getText());
        text1.setText(text);

    }
}
