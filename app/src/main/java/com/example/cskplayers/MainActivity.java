package com.example.cskplayers;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    View input_layout;
    Boolean inputLayoutIsOpen=true;

    public Bitmap imgData;
    private static final int PICK_IMAGE_REQUEST = 1;
    private RecyclerView playerDetails;
    private ArrayList<PlayerModel> playerModelArrayList = new ArrayList<>();
    private EditText nameEditText , bornEditText ,roleEditText;
    private EditText battingStyleEditText , bowlingStyleEditText , nationalityEditText , iplDebutEditText,auctionPriceEditText;
    private EditText runs,wickets,fifties,higestscore,hundreds,matches;
    private ImageView playerImageView;
    private Button savePlayerDetails;
    PlayersAdapter pd;

    FloatingActionButton add_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerDetails = findViewById(R.id.player_details);
        playerDetails.setLayoutManager(new LinearLayoutManager(this));

        initializeViews();


            playerImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGallery();
                }
            });


        savePlayerDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateFields()){
                    saveData(view);
                    clearData();
                    input_layout.setVisibility(View.GONE);

                }else {
                    Toast.makeText(getApplicationContext(), "Player Details Not Added", Toast.LENGTH_SHORT).show();
                }


            }
        });


        add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputLayoutIsOpen){
                    add_player.setImageDrawable(getDrawable(android.R.drawable.ic_menu_close_clear_cancel));
                    input_layout.setVisibility(View.VISIBLE);
                    inputLayoutIsOpen=false;
                }else{
                    add_player.setImageDrawable(getDrawable(android.R.drawable.ic_input_add));
                    input_layout.setVisibility(View.GONE);
                    inputLayoutIsOpen=true;
                }



            }
        });



        // Initialize player data
        initializePlayers();

        // Initialize RecyclerView adapter
        pd = new PlayersAdapter(getApplicationContext(), playerModelArrayList);
        playerDetails.setAdapter(pd);
    }

    private void clearData() {

        nameEditText.getText().clear();
        bornEditText.getText().clear();
        roleEditText.getText().clear();
        battingStyleEditText.getText().clear();
        bowlingStyleEditText.getText().clear();
        nationalityEditText.getText().clear();
        iplDebutEditText.getText().clear();
        auctionPriceEditText.getText().clear();
        matches.getText().clear();
        runs.getText().clear();
        higestscore.getText().clear();
        fifties.getText().clear();
        hundreds.getText().clear();
        wickets.getText().clear();
    }

    private void initializeViews() {
        input_layout = findViewById(R.id.input_data);
        nameEditText = findViewById(R.id.nameEditText);
        bornEditText = findViewById(R.id.bornEditText);
        roleEditText = findViewById(R.id.roleEditText);
        battingStyleEditText = findViewById(R.id.battingStyleEditText);
        bowlingStyleEditText = findViewById(R.id.bowlingStyleEditText);
        nationalityEditText = findViewById(R.id.nationalityEditText);
        iplDebutEditText = findViewById(R.id.iplDebutEditText);
        auctionPriceEditText = findViewById(R.id.auctionPriceEditText);
        playerImageView = (ImageView) findViewById(R.id.player_img1);
        savePlayerDetails=(Button) findViewById(R.id.sava_details);
        matches = findViewById(R.id.matchesEditText);
        runs = findViewById(R.id.runsEditText);
        fifties = findViewById(R.id.fiftiesEditText);
        hundreds = findViewById(R.id.hundredsEditText);
        higestscore=findViewById(R.id.highestScoreEditText);
        wickets = findViewById(R.id.wicketsEditText);
        add_player = findViewById(R.id.Add_player);
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgData = bitmap;
                playerImageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveData(View view) {

        String name = nameEditText.getText().toString();
        String dateOfBirth = bornEditText.getText().toString();
        String role = roleEditText.getText().toString();
        String battingStyle = battingStyleEditText.getText().toString();
        String bowlingStyle = bowlingStyleEditText.getText().toString();
        String nationality = nationalityEditText.getText().toString();
        String iplDebut = iplDebutEditText.getText().toString();
        String auctionPrice = auctionPriceEditText.getText().toString();
        String match= matches.getText().toString();
        String run = runs.getText().toString();
        String highScore=higestscore.getText().toString();
        String fifty=fifties.getText().toString();
        String hundred=hundreds.getText().toString();
        String wicket=wickets.getText().toString();


        PlayerModel newPlayer = new PlayerModel(""+name,""+dateOfBirth,""+role,""+battingStyle,""+bowlingStyle,""+nationality,""+iplDebut,""+auctionPrice,""+match,""+run,""+wicket,""+fifty,""+hundred,""+highScore,imgData);


        playerModelArrayList.add(newPlayer);

        pd.notifyDataSetChanged();


        Toast.makeText(this, "Player Details Added", Toast.LENGTH_LONG).show();
    }

    private void initializePlayers() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ruturaj);
        PlayerModel p1 = new PlayerModel("Ruturaj Gaikwad", "Jan 31, 1997", "Batter", "Right Handed", "Right Arm", "India", "2020", "6.00 Cr", "63", "2,338", "0", "18", "2", "108*", bitmap);

//        PlayerModel p2 = new PlayerModel("Shivam Dube", "Jun 26, 1993",  "All-Rounder", "Left Handed", "Right Arm", "India", "2019", "4.00 Cr", "62", "1,456", "5", "9", "0", "95*", R.drawable.s);
//        PlayerModel p3 = new PlayerModel("Daryl Mitchell", "May 20, 1991",  "All-Rounder", "Right Handed", "Right Arm ", "New Zealand", "2022", "14.00 Cr", "12", "262", "1", "1", "0", "52*", R.drawable.daryl);
//        PlayerModel p4 = new PlayerModel("Ravindra Jadeja", "Dec 6, 1988",  "All-rounder", "Left Handed", "Left Arm ", "India", "2008", "16.00 Cr", "237", "289,4", "160", "3", "0", "62*", R.drawable.rj);
//        PlayerModel p5 = new PlayerModel("Ajinkya Rahane", "Jun 6, 1988",  "Batter", "Right Handed", "Right Arm", "India", "2018", "50.00 Lac", "183", "4,608", "1", "30", "2", "105*", R.drawable.ar);
//        PlayerModel p6 = new PlayerModel("Rachin Ravindra", "Nov 18, 1999",  "Batter", "Left Handed", "Left Arm ", "New Zealand", "2024", "1.80 Cr", "7", "133", "0", "0", "0", "46*", R.drawable.rr);
//        PlayerModel p7 = new PlayerModel("Shardul Thakur", "Oct 16, 1991",  "Bowler", "Right Handed", "Right Arm Medium", "India", "2015", "4.00 Cr", "92", "303", "92", "1", "0", "68", R.drawable.st);
//        PlayerModel p8 = new PlayerModel("MS Dhoni", "Jul 07, 1981",  "Wicket Keeper", "Right Handed", "Right Arm", "India", "2008", "12.00 Cr", "261", "5,192", "0", "24", "0", "84*", R.drawable.msd);

        playerModelArrayList.add(p1);

//        playerModelArrayList.add(p2);
//        playerModelArrayList.add(p3);
//        playerModelArrayList.add(p4);
//        playerModelArrayList.add(p5);
//        playerModelArrayList.add(p6);
//        playerModelArrayList.add(p7);
//        playerModelArrayList.add(p8);
    }


    private boolean validateFields() {
        boolean isValid = true;

        // Validation for name field
        String name = nameEditText.getText().toString().trim();
        if (name.isEmpty()) {
            nameEditText.setError("Name cannot be empty");
            isValid = false;
        }

        // Validation for date of birth field
        String dateOfBirth = bornEditText.getText().toString().trim();
        if (dateOfBirth.isEmpty()) {
            bornEditText.setError("Date of birth cannot be empty");
            isValid = false;
        }

        // Validation for role field
        String role = roleEditText.getText().toString().trim();
        if (role.isEmpty()) {
            roleEditText.setError("Role cannot be empty");
            isValid = false;
        }

        // Validation for batting style field
        String battingStyle = battingStyleEditText.getText().toString().trim();
        if (battingStyle.isEmpty()) {
            battingStyleEditText.setError("Batting style cannot be empty");
            isValid = false;
        }

        // Validation for bowling style field
        String bowlingStyle = bowlingStyleEditText.getText().toString().trim();
        if (bowlingStyle.isEmpty()) {
            bowlingStyleEditText.setError("Bowling style cannot be empty");
            isValid = false;
        }

        // Validation for nationality field
        String nationality = nationalityEditText.getText().toString().trim();
        if (nationality.isEmpty()) {
            nationalityEditText.setError("Nationality cannot be empty");
            isValid = false;
        }

        // Validation for IPL debut field
        String iplDebut = iplDebutEditText.getText().toString().trim();
        if (iplDebut.isEmpty()) {
            iplDebutEditText.setError("IPL debut date cannot be empty");
            isValid = false;
        }

        // Validation for auction price field
        String auctionPrice = auctionPriceEditText.getText().toString().trim();
        if (auctionPrice.isEmpty()) {
            auctionPriceEditText.setError("Auction price cannot be empty");
            isValid = false;
        }

        // Validation for matches field
        String match = matches.getText().toString().trim();
        if (match.isEmpty()) {
            matches.setError("Matches cannot be empty");
            isValid = false;
        }

        // Validation for runs field
        String run = runs.getText().toString().trim();
        if (run.isEmpty()) {
            runs.setError("Runs cannot be empty");
            isValid = false;
        }

        // Validation for high score field
        String highScore = higestscore.getText().toString().trim();
        if (highScore.isEmpty()) {
            higestscore.setError("High score cannot be empty");
            isValid = false;
        }

        // Validation for fifties field
        String fifty = fifties.getText().toString().trim();
        if (fifty.isEmpty()) {
            fifties.setError("Fifties cannot be empty");
            isValid = false;
        }

        // Validation for hundreds field
        String hundred = hundreds.getText().toString().trim();
        if (hundred.isEmpty()) {
            hundreds.setError("Hundreds cannot be empty");
            isValid = false;
        }

        // Validation for wickets field
        String wicket = wickets.getText().toString().trim();
        if (wicket.isEmpty()) {
            wickets.setError("Wickets cannot be empty");
            isValid = false;
        }

        if(imgData==null ){
            playerImageView.setImageBitmap(imgData);
            Toast.makeText(getApplicationContext(),"Please Select Image",Toast.LENGTH_SHORT).show();
            isValid=false;
        }

        return isValid;
    }






}
