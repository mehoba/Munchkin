package com.example.munchkin;

import android.content.Context;
import android.widget.Toast;

import com.example.munchkin.Karte.BodyPart;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenTypen.Rüstungskarte;

import java.util.LinkedList;
import java.util.List;

public class PlayerAusrüstung
{
   private LinkedList<Rüstungskarte> ausgerüsteteKartenList;
   private int levelSum=0;
   private int countArms;
   private int countLegs;
   private int countLarge=0;

   public int getLevelSum() {
      return levelSum;
   }

   public void setLevelSum(int levelSum) {
      this.levelSum = levelSum;
   }


   public LinkedList<Rüstungskarte> getAusgerüsteteKartenList() {
      return ausgerüsteteKartenList;
   }

   public void setAusgerüsteteKartenList(LinkedList<Rüstungskarte> ausgerüsteteKartenList) {
      this.ausgerüsteteKartenList = ausgerüsteteKartenList;
   }



   public PlayerAusrüstung(){
      ausgerüsteteKartenList=new LinkedList<>();
   }

   public boolean addCard(Rüstungskarte karte){
      if(checkIfBodyPartEquipped(karte) == false && checkSize(karte) == true) {
         if(karte.getBodyPart().equals(BodyPart.HAND)){
            countArms=karte.getSizeOfArmor();
         }
         else if(karte.getBodyPart().equals(BodyPart.FOOT)){
            countLegs=karte.getSizeOfArmor();
         }
         if(karte.getIsGroß())
            countLarge++;
         ausgerüsteteKartenList.add(karte);
         addLevel(karte.getSizeOfArmor());
         return true;
      }
      else
         return  false;
   }

   public void addLevel(int level){
      levelSum+=level;
   }

   public boolean checkSize(Rüstungskarte rüstungskarte){
      if(rüstungskarte.getIsGroß() && countLarge < 2)
         return true;
      else if(!rüstungskarte.getIsGroß())
         return true;
      else
         return false;
   }

   public boolean checkIfBodyPartEquipped(Rüstungskarte rüstungskarte){
      if (rüstungskarte.getBodyPart().equals(BodyPart.HAND)){
         if(rüstungskarte.getSizeOfArmor() + countArms >2)
            return true;
         else return false;
      }
      if (rüstungskarte.getBodyPart().equals(BodyPart.FOOT)){
         if(rüstungskarte.getSizeOfArmor() + countLegs >2)
            return true;
         else return false;
      }

      for(Rüstungskarte rüstungskarte1: ausgerüsteteKartenList){
         if(rüstungskarte1.getBodyPart().equals(rüstungskarte.getBodyPart())){
            return true;}
      }
      return false;
   }

}