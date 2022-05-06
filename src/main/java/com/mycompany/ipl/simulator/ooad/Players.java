/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.ipl.simulator.ooad;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.io.*;
import java.util.Random;
import java.util.*;


/**
 *
 * @author User
 */
public class Players {
        
        static Integer[] player_array=new Integer[12];
        static Functionality fun = Functionality.getInstance();
        static MongoClient client=MongoClients.create("mongodb+srv://playerdb:playerdb@playerdb.ho8dm.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        static MongoDatabase db=client.getDatabase("AuctionDB");
        static MongoCollection col=db.getCollection("Players");
        public static int T1Purse,T2Purse,T3Purse,T4Purse;
              
    public static void onePlayer(int PlayerIndex){
        
        Document abc=(Document) col.find(new Document("_id",player_array[PlayerIndex])).first();
       
        AuctionDisplay.PlayerName.setText(""+abc.get("Name"));
        AuctionDisplay.PlayerRole.setText(""+abc.get("Role"));
        AuctionDisplay.PlayerBasePrice.setText(""+abc.get("BasePrice"));
        AuctionDisplay.PlayerRating.setText(""+abc.get("Rating"));
        AuctionDisplay.CurrentPriceTeam.setText(""+abc.get("BasePrice"));
        fun.setBidIncrement(Integer.parseInt(""+abc.get("BasePrice")));
        T1Purse=Integer.parseInt(AuctionDisplay.Team1Purse.getText());
        T2Purse=Integer.parseInt(AuctionDisplay.Team2Purse.getText());
        T3Purse=Integer.parseInt(AuctionDisplay.Team3Purse.getText());
        T4Purse=Integer.parseInt(AuctionDisplay.Team4Purse.getText());
                
    }
    
   
    public static void gen(){
        Random rand = new Random();
        int[] a=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int count=0;
        while(count<12){
            int rand_int1 = rand.nextInt(24);
            if(a[rand_int1]!=0)
            {
                player_array[count]=rand_int1+1;
                a[rand_int1]=0;
                count++;
            }
        }
        }
    
}
