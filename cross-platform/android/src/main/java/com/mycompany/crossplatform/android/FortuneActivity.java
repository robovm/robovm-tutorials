package com.mycompany.crossplatform.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mycompany.crossplatform.core.FortuneStore;

public class FortuneActivity extends Activity {
    private FortuneStore fortunes = new FortuneStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        final TextView fortuneLabel = (TextView) findViewById(R.id.fortuneTextView);
        final Button nextFortuneButton = (Button) findViewById(R.id.nextFortuneButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fortuneLabel.setText(fortunes.getFortune());
            }
        };
        nextFortuneButton.setOnClickListener(listener);
    }
}
