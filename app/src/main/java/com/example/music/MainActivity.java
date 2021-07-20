package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("All Musics");
        final ArrayList<Music> musics = new ArrayList<Music>();
        musics.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.logo));
        musics.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.logo));
        musics.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.logo));
        musics.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.logo));

        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, musics);

        ListView listView = findViewById(R.id.mainList);
        listView.setAdapter(musicAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                Bundle b = new Bundle();
                b.putParcelableArrayList("musics", musics);
                b.putInt("index", position);
                i.putExtras(b);
                startActivity(i);

            }
        });

    }


}







