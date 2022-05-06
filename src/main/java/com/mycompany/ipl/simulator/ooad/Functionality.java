/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ipl.simulator.ooad;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author prath
 */
public class Functionality {
    static Functionality instance;
    private Functionality(){
        
    }
    
    public static Functionality getInstance(){
        if(instance == null){
            instance  = new Functionality();
        }
        return instance;
    }
    static Players One=new Players();
    int second;
    Timer timer;    
    void timer()
    {
        timer = new Timer(1000, (ActionEvent e) -> {
            second--;
            AuctionDisplay.Timer.setText(second+"");
            if (second<=0)
            {timer.stop();
            AuctionDisplay.Timer.setText("0");
            EndBid();
            }
        });
        
                }
    void timerStatus(int status)
    {
        second=16;
        if (status==0)
        timer.start();
        else
        timer.restart();    
    }
   
    void Bid(String Team)
    {
        int NewBidValue=20;
        int CurrentBidValue=Integer.parseInt(AuctionDisplay.CurrentPriceTeam.getText());
        if(CurrentBidValue>=100 && CurrentBidValue<400)
        {
            NewBidValue=25;    
        }
        else if(CurrentBidValue>=400)
        {
            NewBidValue=50;
        }
        AuctionDisplay.LastTeamPrice.setText(AuctionDisplay.PrevTeamPrice.getText());
        AuctionDisplay.PrevTeamPrice.setText(AuctionDisplay.CurrTeamPrice.getText());
        AuctionDisplay.Prev2PriceTeam.setText(AuctionDisplay.PrevPriceTeam.getText());
        AuctionDisplay.PrevPriceTeam.setText(String.valueOf(CurrentBidValue));
        AuctionDisplay.CurrentPriceTeam.setText(String.valueOf(CurrentBidValue+NewBidValue));
        AuctionDisplay.CurrTeamPrice.setText(Team);
        setBidIncrement(CurrentBidValue+NewBidValue);
        
        
        
    }
    
    void setBidIncrement(int CurrentPrice)
    {
        if(CurrentPrice>=100 && CurrentPrice<400)
        {
            int NewBidValue=25; 
            AuctionDisplay.BidIncrement.setText(String.valueOf(NewBidValue));
        }
        else if(CurrentPrice>=400)
        {
            int NewBidValue=50;
            AuctionDisplay.BidIncrement.setText(String.valueOf(NewBidValue));
        }
    }
    
    void EndBid()
    {
        String WinTeam=AuctionDisplay.CurrTeamPrice.getText();
        int SoldPrice=Integer.parseInt(AuctionDisplay.CurrentPriceTeam.getText());
        Teams.Winbid(WinTeam,SoldPrice);
        AuctionDisplay.count+=1;
        
        AuctionDisplay.Team1Button.setEnabled(true);
        AuctionDisplay.Team2Button.setEnabled(true);
        AuctionDisplay.Team3Button.setEnabled(true);
        AuctionDisplay.Team4Button.setEnabled(true);
        
        AuctionDisplay.LastTeamPrice.setText("None");
        AuctionDisplay.PrevTeamPrice.setText("None");
        AuctionDisplay.CurrTeamPrice.setText("None");
        AuctionDisplay.Prev2PriceTeam.setText("0");
        AuctionDisplay.PrevPriceTeam.setText("0");
        if(AuctionDisplay.count<=11)
        {One.onePlayer(AuctionDisplay.count);}
        else
        {
            EndGame();
            timer.stop();
        }
        timerStatus(0);
        
        
        
            
        
        
    }
    void ButtonStatus(String Team)
    {
        if("T1".equals(Team))
        {
            AuctionDisplay.Team1Button.setEnabled(false);
            AuctionDisplay.Team2Button.setEnabled(true);
            AuctionDisplay.Team3Button.setEnabled(true);
            AuctionDisplay.Team4Button.setEnabled(true);
            }
        else if("T2".equals(Team))
        {
            AuctionDisplay.Team2Button.setEnabled(false);
            AuctionDisplay.Team1Button.setEnabled(true);
            AuctionDisplay.Team3Button.setEnabled(true);
            AuctionDisplay.Team4Button.setEnabled(true);
        }
        else if("T3".equals(Team))
        {
            AuctionDisplay.Team3Button.setEnabled(false);
            AuctionDisplay.Team2Button.setEnabled(true);
            AuctionDisplay.Team1Button.setEnabled(true);
            AuctionDisplay.Team4Button.setEnabled(true);
        }
        else if("T4".equals(Team))
        {
            AuctionDisplay.Team4Button.setEnabled(false);
            AuctionDisplay.Team2Button.setEnabled(true);
            AuctionDisplay.Team3Button.setEnabled(true);
            AuctionDisplay.Team1Button.setEnabled(true);
        }
        int nextvalue=Integer.parseInt(AuctionDisplay.CurrentPriceTeam.getText())+Integer.parseInt(AuctionDisplay.BidIncrement.getText());
        System.out.println(nextvalue);
        if(Integer.parseInt(AuctionDisplay.Team1Purse.getText())<nextvalue)
        {
           AuctionDisplay.Team1Button.setEnabled(false); 
        }
        if(Integer.parseInt(AuctionDisplay.Team2Purse.getText())<nextvalue)
        {
           AuctionDisplay.Team2Button.setEnabled(false); 
        }
        if(Integer.parseInt(AuctionDisplay.Team3Purse.getText())<nextvalue)
        {
           AuctionDisplay.Team3Button.setEnabled(false); 
        }
        if(Integer.parseInt(AuctionDisplay.Team4Purse.getText())<nextvalue)
        {
           AuctionDisplay.Team4Button.setEnabled(false); 
        }
       
    }
    void EndGame()
    {
     JFrame jFrame = new JFrame();
        int T1Points=Integer.parseInt(AuctionDisplay.Team1Points.getText());
        int T2Points=Integer.parseInt(AuctionDisplay.Team2Points.getText());
        int T3Points=Integer.parseInt(AuctionDisplay.Team3Points.getText());
        int T4Points=Integer.parseInt(AuctionDisplay.Team4Points.getText());
        int winner=max(T1Points,T2Points,T3Points,T4Points);
        String win="";
        if(winner==T1Points)
        {
            win="Team 1";
        }
        else if(winner==T2Points)
        {
            win="Team 2";
        }
        else if(winner==T3Points)
        {
            win="Team 3";
        }
        else if(winner==T4Points)
        {
            win="Team 4";
        }
               
                JOptionPane.showMessageDialog(jFrame, win+" Wins!");   
    }
    int max(int a, int b, int c, int d) {

    int max = a;

    if (b > max)
        max = b;
    if (c > max)
        max = c;
    if (d > max)
        max = d;

     return max;
}
}
         
         
    
    

