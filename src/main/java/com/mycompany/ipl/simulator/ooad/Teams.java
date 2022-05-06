/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipl.simulator.ooad;

/**
 *
 * @author prath
 */

public class Teams{
    

public static void Winbid(String team,int price)
{
    int NewPurse;
    if("Team 1".equals(team))
    {
NewPurse=Players.T1Purse-price;
AuctionDisplay.Team1Purse.setText(String.valueOf(NewPurse));
AuctionDisplay.Team1PlayerList.append(AuctionDisplay.PlayerName.getText()+"-->"+AuctionDisplay.PlayerRating.getText()+"\n");
AuctionDisplay.Team1Points.setText(String.valueOf(Integer.parseInt(AuctionDisplay.Team1Points.getText())+Integer.parseInt(AuctionDisplay.PlayerRating.getText())));
    }
    if("Team 2".equals(team))
    {
NewPurse=Players.T2Purse-price;
AuctionDisplay.Team2Purse.setText(String.valueOf(NewPurse));
AuctionDisplay.Team2PlayerList.append(AuctionDisplay.PlayerName.getText()+"-->"+AuctionDisplay.PlayerRating.getText()+"\n");
AuctionDisplay.Team2Points.setText(String.valueOf(Integer.parseInt(AuctionDisplay.Team2Points.getText())+Integer.parseInt(AuctionDisplay.PlayerRating.getText())));

    }
    if("Team 3".equals(team))
    {
NewPurse=Players.T3Purse-price;
AuctionDisplay.Team3Purse.setText(String.valueOf(NewPurse));
AuctionDisplay.Team3PlayerList.append(AuctionDisplay.PlayerName.getText()+"-->"+AuctionDisplay.PlayerRating.getText()+"\n");
AuctionDisplay.Team3Points.setText(String.valueOf(Integer.parseInt(AuctionDisplay.Team3Points.getText())+Integer.parseInt(AuctionDisplay.PlayerRating.getText())));

    }
    if("Team 4".equals(team))
    {
NewPurse=Players.T4Purse-price;
AuctionDisplay.Team4Purse.setText(String.valueOf(NewPurse));
AuctionDisplay.Team4PlayerList.append(AuctionDisplay.PlayerName.getText()+"-->"+AuctionDisplay.PlayerRating.getText()+"\n");
AuctionDisplay.Team4Points.setText(String.valueOf(Integer.parseInt(AuctionDisplay.Team4Points.getText())+Integer.parseInt(AuctionDisplay.PlayerRating.getText())));

    }



}
}
