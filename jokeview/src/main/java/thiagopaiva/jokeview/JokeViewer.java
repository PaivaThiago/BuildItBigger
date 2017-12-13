package thiagopaiva.jokeview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        Intent intent = getIntent();
        TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);

        if (intent.hasExtra("joke"))
            jokeTextView.setText(intent.getStringExtra("joke"));
    }
}
