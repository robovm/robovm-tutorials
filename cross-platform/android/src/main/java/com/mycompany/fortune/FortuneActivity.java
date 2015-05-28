package com.mycompany.fortune;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FortuneActivity extends Activity {
    private FortuneStore fortuneStore = new FortuneStore();
    private FortuneClient fortuneClient = new FortuneClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        final TextView fortuneTextView = (TextView) findViewById(R.id.fortuneTextView);
        final Button nextFortuneButton = (Button) findViewById(R.id.nextFortuneButton);

        nextFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fortuneClient.getFortune(new FortuneClient.OnFortuneListener() {
                    @Override
                    public void onFortune(String fortune) {
                        fortuneTextView.setText(fortune);
                    }
                });
            }
        });
    }
}
