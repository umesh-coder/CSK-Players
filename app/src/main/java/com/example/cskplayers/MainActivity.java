package com.example.cskplayers;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView playerDetails;
    ArrayList<PlayerModel> playerModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerDetails = findViewById(R.id.player_details);
        playerDetails.setLayoutManager(new LinearLayoutManager(this));


        PlayerModel p1 = new PlayerModel("Ruturaj Gaikwad", "Jan 31, 1997", "Batter", "Right Handed", "Right Arm", "India", "2020", "6.00 Cr", "63", "2,338", "0", "18", "2", "108*", R.drawable.ic_launcher_background);


        PlayerModel p2 = new PlayerModel("MS Dhoni", "Jul 7, 1981",  "Wicketkeeper", "Right Handed", "Right Arm Medium", "India", "2008", "15.00 Cr", "204", "4,614", "-", "23", "0", "84*", R.drawable.ic_launcher_background);

        PlayerModel p3 = new PlayerModel("Suresh Raina", "Nov 27, 1986",  "Batter", "Left Handed", "Right Arm Offbreak", "India", "2008", "11.00 Cr", "193", "5,368", "25", "38", "1", "100*", R.drawable.ic_launcher_background);

        PlayerModel p4 = new PlayerModel("Ravindra Jadeja", "Dec 6, 1988",  "All-rounder", "Left Handed", "Left Arm Orthodox", "India", "2008", "9.25 Cr", "184", "2,617", "114", "13", "0", "50", R.drawable.ic_launcher_background);

        PlayerModel p5 = new PlayerModel("Deepak Chahar", "Aug 7, 1992",  "Bowler", "Right Handed", "Right Arm Medium", "India", "2018", "2.00 Cr", "58", "213", "40", "0", "0", "20*", R.drawable.ic_launcher_background);

        PlayerModel p6 = new PlayerModel("Faf du Plessis", "Jul 13, 1984",  "Batter", "Right Handed", "Right Arm Legbreak", "South Africa", "2012", "1.60 Cr", "100", "2,442", "0", "14", "0", "96*", R.drawable.ic_launcher_background);

        PlayerModel p7 = new PlayerModel("Shardul Thakur", "Oct 16, 1991",  "Bowler", "Right Handed", "Right Arm Medium", "India", "2015", "2.60 Cr", "43", "151", "47", "0", "0", "15", R.drawable.ic_launcher_background);

        PlayerModel p8 = new PlayerModel("Moeen Ali", "Jun 18, 1987",  "All-rounder", "Left Handed", "Right Arm Offbreak", "England", "2021", "7.00 Cr", "32", "206", "13", "0", "0", "25", R.drawable.ic_launcher_background);

        PlayerModel p9 = new PlayerModel("Ambati Rayudu", "Sep 23, 1985", "Batter", "Right Handed", "Right Arm Offbreak", "India", "2008", "2.20 Cr", "162", "3,713", "4", "20", "0", "100*", R.drawable.ic_launcher_background);

        PlayerModel p10 = new PlayerModel("Imran Tahir", "Mar 27, 1979",  "Bowler", "Right Handed", "Right Arm Legbreak", "South Africa", "2014", "1.00 Cr", "55", "13", "84", "0", "0", "10*", R.drawable.ic_launcher_background);


        playerModelArrayList.add(p1);
        playerModelArrayList.add(p2);
        playerModelArrayList.add(p3);
        playerModelArrayList.add(p3);
        playerModelArrayList.add(p4);
        playerModelArrayList.add(p5);
        playerModelArrayList.add(p6);
        playerModelArrayList.add(p7);
        playerModelArrayList.add(p8);
        playerModelArrayList.add(p9);
        playerModelArrayList.add(p10);

        PlayersAdapter pd=new PlayersAdapter(getApplicationContext(),playerModelArrayList);
        playerDetails.setAdapter(pd);





    }
}