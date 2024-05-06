package com.example.cskplayers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder> {


    LayoutInflater viewInflayter;
    Context context;

    ArrayList<PlayerModel> playerModelArrayList;

    public PlayersAdapter(Context context, ArrayList<PlayerModel> playerModelArrayList) {
        this.context = context;
        this.playerModelArrayList = playerModelArrayList;
        viewInflayter=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = viewInflayter.inflate(R.layout.playerdetails,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PlayerModel p1=playerModelArrayList.get(position);
        holder.playerImg.setImageResource(p1.getPlayerImg());
        holder.nameTextView.setText("Name: "+p1.getName());
        holder.bornTextView.setText("Born: "+p1.getBorn());
        holder.roleTextView.setText("Role: "+p1.getRole());
        holder.battingStyleTextView.setText("Batting Style: "+p1.getBattingStyle());
        holder.bowlingStyleTextView.setText("Bowling Style "+p1.getBowlingStyle());
        holder.nationalityTextView.setText("Nationality: "+p1.getNationality());
        holder.iplDebutTextView.setText("IPL Debut: "+p1.getIplDebut());
        holder.auctionPriceTextView.setText("Auction Price: "+p1.getAuctionPrice());

        holder.matchesTextView.setText(p1.getMatches());
        holder.runsTextView.setText(p1.getRuns());
        holder.wicketsTextView.setText(p1.getWickets());
        holder.fiftiesTextView.setText(p1.getFifties());
        holder.hundredsTextView.setText(p1.getHundreds());
        holder.highestScoreTextView.setText(p1.getHighestScore());


    }
    @Override
    public int getItemCount() {
        return playerModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView playerImg;
        TextView nameTextView;
        TextView bornTextView;
        TextView roleTextView;
        TextView battingStyleTextView;
        TextView bowlingStyleTextView;
        TextView nationalityTextView;
        TextView iplDebutTextView;
        TextView auctionPriceTextView;
        TextView matchesTextView;
        TextView runsTextView;
        TextView wicketsTextView;
        TextView fiftiesTextView;
        TextView hundredsTextView;
        TextView highestScoreTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initializeviews();
        }

        private void initializeviews() {
            playerImg = itemView.findViewById(R.id.player_img);
            nameTextView = itemView.findViewById(R.id.name);
            bornTextView = itemView.findViewById(R.id.bornTextView);
            roleTextView = itemView.findViewById(R.id.roleTextView);
            battingStyleTextView = itemView.findViewById(R.id.battingStyleTextView);
            bowlingStyleTextView = itemView.findViewById(R.id.bowlingStyleTextView);
            nationalityTextView = itemView.findViewById(R.id.nationalityTextView);
            iplDebutTextView = itemView.findViewById(R.id.iplDebutTextView);
            auctionPriceTextView = itemView.findViewById(R.id.auctionPriceTextView);
            matchesTextView = itemView.findViewById(R.id.matchesTextView);
            runsTextView = itemView.findViewById(R.id.runsTextView);
            wicketsTextView = itemView.findViewById(R.id.wicketsTextView);
            fiftiesTextView = itemView.findViewById(R.id.fiftiesTextView);
            hundredsTextView = itemView.findViewById(R.id.hundredsTextView);
            highestScoreTextView = itemView.findViewById(R.id.highestScoreTextView);

        }
    }
}
