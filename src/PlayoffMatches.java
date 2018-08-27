import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javalib.funworld.World;
import javalib.funworld.WorldScene;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;

public class PlayoffMatches extends World {
  int height;
  int width; 
  Button SKT1, SKT9;
  Button Griffin1, Griffin8;
  Button GENG2, GENG5;
  Button JAG2, JAG7;
  Button AF3, AF7;
  Button HLE3, HLE6;
  Button KZ4, KZ9;
  Button BBQ4, BBQ8;
  Button MVP5, MVP10;
  Button KT6, KT10;
  
  //tells how many games the match is taken in
  Button firstMatchTwo, firstMatchThree;
  Button secondMatchTwo, secondMatchThree;
  Button thirdMatchTwo, thirdMatchThree;
  Button fourthMatchTwo, fourthMatchThree;
  Button fifthMatchTwo, fifthMatchThree;
  Button sixthMatchTwo, sixthMatchThree;
  Button seventhMatchTwo, seventhMatchThree;
  Button eighthMatchTwo, eighthMatchThree; 
  Button ninthMatchTwo, ninthMatchThree;
  Button tenthMatchTwo, tenthMatchThree;
  
  Team SKT, Griffin;
  Team GENG, JAG;
  Team AF, HLE; 
  Team KZ, BBQ;
  Team MVP, KT;
  //subtracts wins from losses 
  int SKTScore, GriffinScore, GENGScore, JAGScore, AFScore, HLEScore, KZScore, BBQScore, MVPScore, KTScore;
  int SKTmatchScore, GriffinmatchScore, GENGmatchScore, JAGmatchScore, AFmatchScore, HLEmatchScore,
  KZmatchScore, BBQmatchScore, MVPmatchScore, KTmatchScore;
  
  ArrayList<String> rank = new ArrayList<String>();
  ArrayList<Team> finalRank = new ArrayList<Team>();

  PlayoffMatches() {
    this.SKT1= Utils.SKT1;
    this.SKT9 = Utils.SKT9;
    this.Griffin1 = Utils.Griffin1;
    this.Griffin8 = Utils.Griffin8;
    this.GENG2 = Utils.GENG2;
    this.GENG5 = Utils.GENG5;
    this.JAG2 = Utils.JAG2;
    this.JAG7 = Utils.JAG7;
    this.AF3 = Utils.AF3;
    this.AF7 = Utils.AF7;
    this.HLE3 = Utils.HLE3;
    this.HLE6 = Utils.HLE6;
    this.KZ4 = Utils.KZ4;
    this.KZ9 = Utils.KZ9;
    this.BBQ4 = Utils.BBQ4;
    this.BBQ8 = Utils.BBQ8;
    this.MVP5 = Utils.MVP5;
    this.MVP10 = Utils.MVP10;
    this.KT6 = Utils.KT6;
    this.KT10 = Utils.KT10;
    this.firstMatchThree = Utils.firstMatchThree;
    this.firstMatchTwo = Utils.firstMatchTwo;
    this.secondMatchThree = Utils.secondMatchThree;
    this.secondMatchTwo = Utils.secondMatchTwo;
    this.thirdMatchThree = Utils.thirdMatchThree;
    this.thirdMatchTwo = Utils.thirdMatchTwo;
    this.fourthMatchThree = Utils.fourthMatchThree;
    this.fourthMatchTwo = Utils.fourthMatchTwo;
    this.fifthMatchThree = Utils.fifthMatchThree;
    this.fifthMatchTwo = Utils.fifthMatchTwo;
    this.sixthMatchThree = Utils.sixthMatchThree;
    this.sixthMatchTwo = Utils.sixthMatchTwo;
    this.seventhMatchThree = Utils.seventhMatchThree;
    this.seventhMatchTwo = Utils.seventhMatchTwo;
    this.eighthMatchThree = Utils.eighthMatchThree;
    this.eighthMatchTwo = Utils.eighthMatchTwo;
    this.ninthMatchThree = Utils.ninthMatchThree;
    this.ninthMatchTwo = Utils.ninthMatchTwo;
    this.tenthMatchThree = Utils.tenthMatchThree;
    this.tenthMatchTwo = Utils.tenthMatchTwo;
    this.SKTScore = 0;
    this.JAGScore = -8;
    this.GriffinScore = 6;
    this.GENGScore = 6;
    this.KZScore = 6;
    this.AFScore = 2;
    this.HLEScore = 2;
    this.KTScore = 6;
    this.MVPScore = -8;
    this.BBQScore = -12;
    this.SKTmatchScore = 0;
    this.GriffinmatchScore = 11;
    this.GENGmatchScore = 9; 
    this.JAGmatchScore = -14;
    this.AFmatchScore = 5;
    this.HLEmatchScore = 5;
    this.KZmatchScore = 9;
    this.BBQmatchScore = -21;
    this.MVPmatchScore = -15;
    this.KTmatchScore = 11;
    
  }
  @Override
  public WorldScene makeScene() {
    
    WorldScene s = new WorldScene(Utils.GAME_SIZE, Utils.GAME_SIZE);
    WorldScene match = s.placeImageXY(new OverlayImage(new TextImage("MATCHES", Color.BLACK), new RectangleImage(Utils.BUTTON_SIZE, Utils.BUTTON_SIZE, "outline", Color.BLACK))
        , Utils.BUTTON_SIZE * 5/2, Utils.BUTTON_SIZE/2);
    WorldScene bar = match.placeImageXY(new RectangleImage(Utils.BUTTON_SIZE, Utils.BUTTON_SIZE *9, "SOLID", Color.BLACK), Utils.BUTTON_SIZE *5/2, Utils.BUTTON_SIZE*11/2);
    WorldScene choices = SKT1.draw(SKT9.draw(Griffin1.draw(Griffin8.draw(GENG2.draw(GENG5.draw
        (JAG2.draw(JAG7.draw(AF3.draw(AF7.draw(HLE3.draw(HLE6.draw
            (KZ4.draw(KZ9.draw(BBQ4.draw(BBQ8.draw(MVP5.draw(MVP10.draw
                (KT6.draw(KT10.draw(bar))))))))))))))))))));
    WorldScene matchScore = tenthMatchThree.draw(tenthMatchTwo.draw(ninthMatchThree.draw(ninthMatchTwo.draw(
        eighthMatchThree.draw(eighthMatchTwo.draw(seventhMatchThree.draw(seventhMatchTwo.draw(sixthMatchThree.draw(
            sixthMatchTwo.draw(fifthMatchThree.draw(fifthMatchTwo.draw(fourthMatchThree.draw(fourthMatchTwo.draw(
                thirdMatchThree.draw(thirdMatchTwo.draw(secondMatchThree.draw(secondMatchTwo.draw(firstMatchThree.draw(
                    firstMatchTwo.draw(choices))))))))))))))))))));

    if(this.finish()) {
    this.nameOrder();
  WorldScene places = SKT.drawPlaces(Griffin.drawPlaces(GENG.drawPlaces(JAG.drawPlaces(AF.drawPlaces
  (HLE.drawPlaces(KZ.drawPlaces(BBQ.drawPlaces(MVP.drawPlaces(KT.drawPlaces(matchScore))))))))));
  WorldScene all = SKT.drawNames(Griffin.drawNames(GENG.drawNames(JAG.drawNames(AF.drawNames
      (HLE.drawNames(KZ.drawNames(BBQ.drawNames(MVP.drawNames(KT.drawNames(places))))))))));
  WorldScene newAll = SKT.drawMatchPoint(Griffin.drawMatchPoint(GENG.drawMatchPoint(JAG.drawMatchPoint(AF.drawMatchPoint
      (HLE.drawMatchPoint(KZ.drawMatchPoint(BBQ.drawMatchPoint(MVP.drawMatchPoint(KT.drawMatchPoint(all))))))))));
  
      return newAll;
    } else {
      return matchScore;
    }
  }
  
  public void initializeTeams() {
    SKT = new Team("SKT", SKTmatchScore, 0, (int) (Utils.BUTTON_SIZE *3.5)*2, 0, Utils.BUTTON_SIZE); 
    Griffin = new Team("Griffin", GriffinmatchScore, 0, (int) (Utils.BUTTON_SIZE *3.5)*2, 0, Utils.BUTTON_SIZE);
    GENG = new Team("GEN.G", GENGmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2,0, Utils.BUTTON_SIZE);
    JAG = new Team("JAG", JAGmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2,0, Utils.BUTTON_SIZE); 
    AF = new Team("AF", AFmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2, 0,Utils.BUTTON_SIZE); 
    HLE = new Team("HLE", HLEmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2, 0, Utils.BUTTON_SIZE); 
    KZ = new Team("KZ", KZmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2,0, Utils.BUTTON_SIZE);
    BBQ = new Team("BBQ", BBQmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2,0, Utils.BUTTON_SIZE); 
    MVP = new Team("MVP", MVPmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2,0, Utils.BUTTON_SIZE);
    KT = new Team("KT", KTmatchScore, 0,(int)(Utils.BUTTON_SIZE *3.5)*2,0, Utils.BUTTON_SIZE);
    

  }
  public World onMouseClicked (Posn pos) {
    return this.darken(this.buttonPressed(pos));
  }

  public Button buttonPressed(Posn pos) {
    if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE) {
      return SKT1;
    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE){
      return Griffin1;
    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *2){
      return GENG2;
    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *2) {
      return JAG2;
    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *3) {
      return AF3;
    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *3) {
      return HLE3;
    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *4) {
      return KZ4;
    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *4) {
      return BBQ4;

    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *5) {
      return GENG5;

    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *5) {
      return MVP5;

    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *6) {
      return HLE6;

    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *6) {
      return KT6;

    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *7) {
      return JAG7;

    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *7) {
      return AF7;

    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *8) {
      return Griffin8;

    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *8) {
      return BBQ8;

    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *9) {
      return SKT9;

    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *9) {
      return KZ9;

    } else if (pos.x < Utils.BUTTON_SIZE && pos.y < Utils.BUTTON_SIZE *10) {
      return MVP10;

    } else if (pos.x < Utils.BUTTON_SIZE*2 && pos.y < Utils.BUTTON_SIZE *10) {
      return KT10;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y < Utils.BUTTON_SIZE) {
      return firstMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE) {
      return firstMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 2) {
      return secondMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 3) {
      return thirdMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 4) {
      return fourthMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 5) {
      return fifthMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 6) {
      return sixthMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 7) {
      return seventhMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 8) {
      return eighthMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 9) {
      return ninthMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*4 && pos.x > Utils.BUTTON_SIZE*3 && pos.y< Utils.BUTTON_SIZE * 10) {
      return tenthMatchTwo;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 2) {
      return secondMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 3) {
      return thirdMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 4) {
      return fourthMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 5) {
      return fifthMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 6) {
      return sixthMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 7) {
      return seventhMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE *8) {
      return eighthMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE *9) {
      return ninthMatchThree;
    } else if (pos.x < Utils.BUTTON_SIZE*5 && pos.x > Utils.BUTTON_SIZE*4 && pos.y< Utils.BUTTON_SIZE * 10) {
      return tenthMatchThree;
    } else {
      return new Button(0,0,"nothing",0,true);
    }
  }
  //connect connected pieces
  public World darken(Button name) {
    if(name.equals(this.SKT1)) {
      if(Griffin1.isClicked) {
        this.Griffin1.changeState();
      }
      this.SKT1.changeState(); 

    } else if(name.equals(this.SKT9)) {
      if(KZ9.isClicked) {
        this.KZ9.changeState();
      }
      this.SKT9.changeState();

    } else if(name.equals(this.Griffin1)) {
      if(SKT1.isClicked) { 
       this.SKT1.changeState();
      }
      this.Griffin1.changeState();

    } else if (name.equals(this.Griffin8)) {
      if(BBQ8.isClicked) {
        this.BBQ8.changeState();
      }
      this.Griffin8.changeState();

    }else if (name.equals(this.GENG2)) {
      if(JAG2.isClicked) {
       this.JAG2.changeState();
      }
      this.GENG2.changeState();

    } else if (name.equals(this.GENG5)) {
      if (MVP5.isClicked) {
        this.MVP5.changeState();
      }
      this.GENG5.changeState();

    } else if (name.equals(this.JAG2)) {
      if(GENG2.isClicked) {
        this.GENG2.changeState();
      }
      this.JAG2.changeState();

    } else if (name.equals(this.JAG7)) {
      if(AF7.isClicked) {
       this.AF7.changeState();
      }
      this.JAG7.changeState();

    } else if (name.equals(this.AF3)) {
      if(HLE3.isClicked) {
        this.HLE3.changeState();
      }

      this.AF3.changeState();

    } else if (name.equals(this.AF7)) {
      if(JAG7.isClicked) {
        JAG7.changeState();
      }

      this.AF7.changeState();

    } else if (name.equals(this.HLE3)) {
      if(AF3.isClicked) {
         this.AF3.changeState();
      }
      this.HLE3.changeState();

    } else if (name.equals(this.HLE6)) {
      if(KT6.isClicked) {
        this.KT6.changeState();
      }
      this.HLE6.changeState();

    } else if (name.equals(this.KZ4)) {
      if(BBQ4.isClicked) {
        this.BBQ4.changeState();
      }
      this.KZ4.changeState();

    } else if (name.equals(this.KZ9)) {
      if(SKT9.isClicked) {
       this.SKT9.changeState();
      }
      this.KZ9.changeState();

    } else if (name.equals(this.BBQ4)) { 
      if(KZ4.isClicked) {
        this.KZ4.changeState();
      }
      this.BBQ4.changeState();

    } else if (name.equals(this.BBQ8)) {
      if(Griffin8.isClicked) {
      this.Griffin8.changeState();
      }
      this.BBQ8.changeState();

    } else if (name.equals(this.MVP5)) {
      if(GENG5.isClicked) {
      this.GENG5.changeState();
      }
      this.MVP5.changeState();

    } else if (name.equals(this.MVP10)) {
      if (KT10.isClicked) {
      this.KT10.changeState();
      }
      this.MVP10.changeState();

    } else if (name.equals(this.KT6)) {
      if(HLE6.isClicked) {
       this.HLE6.changeState();
      }
      this.KT6.changeState();

    } else if (name.equals(this.KT10)) {
      if(MVP10.isClicked) {
        this.MVP10.changeState();
      }
      this.KT10.changeState();
    } else if (name.equals(firstMatchTwo)) {
      if (firstMatchThree.isClicked) {
        this.firstMatchThree.changeState();
      }
      this.firstMatchTwo.changeState();
    } else if (name.equals(firstMatchThree)) {
      if (firstMatchTwo.isClicked) {
        this.firstMatchTwo.changeState();
      }
      this.firstMatchThree.changeState();
    } else if (name.equals(secondMatchThree)) {
      if (secondMatchTwo.isClicked) {
        this.secondMatchTwo.changeState();
      }
      this.secondMatchThree.changeState();
    } else if (name.equals(secondMatchTwo)) {
     if (secondMatchThree.isClicked) {
       this.secondMatchThree.changeState();
     }
     this.secondMatchTwo.changeState();
    } else if (name.equals(thirdMatchThree)) {
    
      if(thirdMatchTwo.isClicked) {
        this.thirdMatchTwo.changeState();
      }
      this.thirdMatchThree.changeState();
    } else if (name.equals(thirdMatchTwo)) {
      if (thirdMatchThree.isClicked) {
        this.thirdMatchThree.changeState();
      }
      this.thirdMatchTwo.changeState();
    } else if (name.equals(fourthMatchThree)) {
      if (fourthMatchTwo.isClicked) {
        this.fourthMatchTwo.changeState();
      }
      this.fourthMatchThree.changeState();
    } else if (name.equals(fourthMatchTwo)) {
      if(fourthMatchThree.isClicked) {
        fourthMatchThree.changeState();
      }
      fourthMatchTwo.changeState();
    } else if (name.equals(fifthMatchThree)) {
      if (fifthMatchTwo.isClicked) {
        this.fifthMatchTwo.changeState();
      }
      this.fifthMatchThree.changeState();
    } else if (name.equals(fifthMatchTwo)) {
      if(fifthMatchThree.isClicked) {
        fifthMatchThree.changeState();
      }
      fifthMatchTwo.changeState();
    } else if (name.equals(sixthMatchThree)) {
      if (sixthMatchTwo.isClicked) {
        this.sixthMatchTwo.changeState();
      }
      this.sixthMatchThree.changeState();
    } else if (name.equals(sixthMatchTwo)) {
      if(sixthMatchThree.isClicked) {
        sixthMatchThree.changeState();
      }
      sixthMatchTwo.changeState();
    } else if (name.equals(seventhMatchThree)) {
      if (seventhMatchTwo.isClicked) {
        this.seventhMatchTwo.changeState();
      }
      this.seventhMatchThree.changeState();
    } else if (name.equals(seventhMatchTwo)) {
      if(seventhMatchThree.isClicked) {
        seventhMatchThree.changeState();
      }
      seventhMatchTwo.changeState();
    } else if (name.equals(eighthMatchThree)) {
      if (eighthMatchTwo.isClicked) {
        this.eighthMatchTwo.changeState();
      }
      this.eighthMatchThree.changeState();
    } else if (name.equals(eighthMatchTwo)) {
      if(eighthMatchThree.isClicked) {
        eighthMatchThree.changeState();
      }
      eighthMatchTwo.changeState();
    } else if (name.equals(ninthMatchThree)) {
      if (ninthMatchTwo.isClicked) {
        this.ninthMatchTwo.changeState();
      }
      this.ninthMatchThree.changeState();
    } else if (name.equals(ninthMatchTwo)) {
      if(ninthMatchThree.isClicked) {
        ninthMatchThree.changeState();
      }
      ninthMatchTwo.changeState();
    } else if (name.equals(tenthMatchThree)) {
      if (tenthMatchTwo.isClicked) {
        this.tenthMatchTwo.changeState();
      }
      this.tenthMatchThree.changeState();
    } else if (name.equals(tenthMatchTwo)) {
      if(tenthMatchThree.isClicked) {
        tenthMatchThree.changeState();
      }
      tenthMatchTwo.changeState();
    } 
    return this;
  }

  public boolean finish() {
    return (SKT1.isClicked || Griffin1.isClicked) && (GENG2.isClicked || JAG2.isClicked) && (AF3.isClicked || HLE3.isClicked) &&
        (BBQ4.isClicked|| KZ4.isClicked) && (MVP5.isClicked || GENG5.isClicked) && (HLE6.isClicked|| KT6.isClicked) && (JAG7.isClicked || AF7.isClicked) 
        && (Griffin8.isClicked|| BBQ8.isClicked) && (SKT9.isClicked || KZ9.isClicked) && (KT10.isClicked||MVP10.isClicked)
        && this.matchFinish(); 
  }
  
  public boolean matchFinish() {
    return (firstMatchTwo.isClicked || firstMatchThree.isClicked) && (secondMatchTwo.isClicked || secondMatchThree.isClicked) && (thirdMatchTwo.isClicked || thirdMatchThree.isClicked)
        && (fourthMatchTwo.isClicked || fourthMatchThree.isClicked) && (fifthMatchTwo.isClicked || fifthMatchThree.isClicked) && (sixthMatchTwo.isClicked || sixthMatchThree.isClicked)
        && (seventhMatchTwo.isClicked || seventhMatchThree.isClicked) && (eighthMatchTwo.isClicked || eighthMatchThree.isClicked) && (ninthMatchTwo.isClicked || ninthMatchThree.isClicked)
        && (tenthMatchTwo.isClicked || tenthMatchThree.isClicked);
  }
  public void resetMatchPoints() {
    this.SKTmatchScore = 0;
    this.GriffinmatchScore = 11;
    this.GENGmatchScore = 9; 
    this.JAGmatchScore = -14;
    this.AFmatchScore = 5;
    this.HLEmatchScore = 5;
    this.KZmatchScore = 9;
    this.BBQmatchScore = -21;
    this.MVPmatchScore = -15;
    this.KTmatchScore = 11;
  }
  
  public void calculateMatchScores() {
    if(SKT1.getisClicked()) {
      if(firstMatchTwo.getisClicked()) {
        SKTmatchScore += 2;
        GriffinmatchScore -= 2;
      } else if (firstMatchThree.getisClicked()) {
        SKTmatchScore += 1;
        GriffinmatchScore -= 1;
      }
    }
    
    if (Griffin1.getisClicked()) {
      if(firstMatchTwo.getisClicked()) {
        GriffinmatchScore += 2;
        SKTmatchScore -= 2;
      } else if (firstMatchThree.getisClicked()) {
        SKTmatchScore -= 1;
        GriffinmatchScore += 1;
      }
    }
    
    if(JAG2.getisClicked()) {
      if(secondMatchTwo.getisClicked()) {
        JAGmatchScore += 2;
        GENGmatchScore -= 2;
      } else if (secondMatchThree.getisClicked()) {
        JAGmatchScore += 1;
        GENGmatchScore -= 1;
      }
    }
    
    if(GENG2.getisClicked()) {
      if(secondMatchTwo.getisClicked()) {
        JAGmatchScore -= 2;
        GENGmatchScore += 2;
      } else if (secondMatchThree.getisClicked()) {
        JAGmatchScore -= 1;
        GENGmatchScore += 1;
      }
    }
    if(AF3.getisClicked()) {
      if(thirdMatchTwo.getisClicked()) {
        AFmatchScore += 2;
        HLEmatchScore -= 2;
      } else if (thirdMatchThree.getisClicked()) {
        AFmatchScore += 1;
        HLEmatchScore -= 1;
      }
    }
    
    if(HLE3.getisClicked()) {
      if(thirdMatchTwo.getisClicked()) {
        AFmatchScore -= 2;
        HLEmatchScore += 2;
      } else if (thirdMatchThree.getisClicked()) {
        AFmatchScore -= 1;
        HLEmatchScore += 1;
      }
    }
    
    if(KZ4.getisClicked()) {
      if(fourthMatchTwo.getisClicked()) {
        KZmatchScore += 2;
        BBQmatchScore -= 2;
      } else if (fourthMatchThree.getisClicked()) {
        KZmatchScore += 1;
        BBQmatchScore -= 1;
      }
    }
    
    if(BBQ4.getisClicked()) {
      if(fourthMatchTwo.getisClicked()) {
        KZmatchScore -= 2;
        BBQmatchScore += 2;
      } else if (fourthMatchThree.getisClicked()) {
        KZmatchScore -= 1;
        BBQmatchScore += 1;
      }
    }
    
    if(GENG5.getisClicked()) {
      if(fifthMatchTwo.getisClicked()) {
        GENGmatchScore += 2;
        MVPmatchScore -= 2;
      } else if (fifthMatchThree.getisClicked()) {
        GENGmatchScore += 1;
        MVPmatchScore -= 1;
      }
    }
    
    if(MVP5.getisClicked()) {
      if(fifthMatchTwo.getisClicked()) {
        GENGmatchScore -= 2;
        MVPmatchScore += 2;
      } else if (fifthMatchThree.getisClicked()) {
        GENGmatchScore -= 1;
        MVPmatchScore += 1;
      }
    }
    
    if(HLE6.getisClicked()) {
      if(sixthMatchTwo.getisClicked()) {
        HLEmatchScore += 2;
        KTmatchScore -= 2;
      } else if (sixthMatchThree.getisClicked()) {
        HLEmatchScore += 1;
        KTmatchScore -= 1;
      }
    }
    
    if(KT6.getisClicked()) {
      if(sixthMatchTwo.getisClicked()) {
        HLEmatchScore -= 2;
        KTmatchScore += 2;
      } else if (sixthMatchThree.getisClicked()) {
        HLEmatchScore -= 1;
        KTmatchScore += 1;
      }
    }
    
    if(AF7.getisClicked()) {
      if(seventhMatchTwo.getisClicked()) {
        AFmatchScore += 2;
        JAGmatchScore -= 2;
      } else if (seventhMatchThree.getisClicked()) {
        AFmatchScore += 1;
        JAGmatchScore -= 1;
      }
    }
    
    if(JAG7.getisClicked()) {
      if(seventhMatchTwo.getisClicked()) {
        AFmatchScore -= 2;
        JAGmatchScore += 2;
      } else if (seventhMatchThree.getisClicked()) {
        AFmatchScore -= 1;
        JAGmatchScore += 1;
      }
    }
    
    if(Griffin8.getisClicked()) {
      if(eighthMatchTwo.getisClicked()) {
        GriffinmatchScore += 2;
        BBQmatchScore -= 2;
      } else if (eighthMatchThree.getisClicked()) {
        GriffinmatchScore += 1;
        BBQmatchScore -= 1;
      }
    }
    
    if(BBQ8.getisClicked()) {
      if(eighthMatchTwo.getisClicked()) {
        GriffinmatchScore -= 2;
        BBQmatchScore += 2;
      } else if (eighthMatchThree.getisClicked()) {
        GriffinmatchScore -= 1;
        BBQmatchScore += 1;
      }
    }
    
    if(SKT9.getisClicked()) {
      if(ninthMatchTwo.getisClicked()) {
        SKTmatchScore += 2;
        KZmatchScore -= 2;
      } else if (ninthMatchThree.getisClicked()) {
        SKTmatchScore += 1;
        KZmatchScore -= 1;
      }
    }
    
    if(KZ9.getisClicked()) {
      if(ninthMatchTwo.getisClicked()) {
        SKTmatchScore -= 2;
        KZmatchScore += 2;
      } else if (ninthMatchThree.getisClicked()) {
        SKTmatchScore -= 1;
        KZmatchScore += 1;
      }
    }
    
    if(MVP10.getisClicked()) {
      if(tenthMatchTwo.getisClicked()) {
        MVPmatchScore += 2;
        KTmatchScore -= 2;
      } else if (tenthMatchThree.getisClicked()) {
        MVPmatchScore += 1;
        KTmatchScore -= 1;
      }
    }
    
    if(MVP10.getisClicked()) {
      if(tenthMatchTwo.getisClicked()) {
        MVPmatchScore -= 2;
        KTmatchScore += 2;
      } else if (tenthMatchThree.getisClicked()) {
        MVPmatchScore -= 1;
        KTmatchScore += 1;
      }
    }
    
  }
  
public void resetScores() {
  this.SKTScore = 0;
  this.JAGScore = -8;
  this.GriffinScore = 6;
  this.GENGScore = 6;
  this.KZScore = 6;
  this.AFScore = 2;
  this.HLEScore = 2;
  this.KTScore = 6;
  this.MVPScore = -8;
  this.BBQScore = -12;
}
  public void calculateScores() {
    if (SKT1.isClicked && SKT9.isClicked) {
     SKTScore += 2;
    } else if (!SKT1.isClicked && !SKT9.isClicked) {
      SKTScore -= 2;
    }

    if (Griffin1.isClicked && Griffin8.isClicked) {
      GriffinScore += 2;
    } else if (!Griffin1.isClicked && !Griffin8.isClicked) {
     GriffinScore -= 2;
    } 

    if(GENG2.isClicked && GENG5.isClicked) {
     GENGScore += 2;
    } else if (!GENG2.isClicked && !GENG5.isClicked) {
      GENGScore -= 2;
    } 

    if(JAG2.isClicked && JAG7.isClicked) {
      JAGScore += 2;
    } else if (!JAG2.isClicked && !JAG7.isClicked) {
      JAGScore -= 2;
    }

    if(AF3.isClicked && AF7.isClicked) {
      AFScore += 2;
    } else if (!AF3.isClicked && !AF7.isClicked) {
      AFScore -= 2;
    } 

    if(HLE3.isClicked && HLE6.isClicked) {
      HLEScore += 2;
    } else if (!HLE3.isClicked && !HLE6.isClicked) {
      HLEScore -= 2;
    } 

    if(BBQ4.isClicked && BBQ8.isClicked) {
      BBQScore += 2;
    } else if (!BBQ4.isClicked && !BBQ8.isClicked) {
      BBQScore =- 2;
    } 

    if(KZ4.isClicked && KZ9.isClicked) {
      KZScore += 2;
    } else if (!KZ4.isClicked && !KZ9.isClicked) {
      KZScore =- 2;
    } 

    if (MVP5.isClicked && MVP10.isClicked) {
      MVPScore += 2;
    } else if (!MVP5.isClicked && !MVP10.isClicked) {
      MVPScore -= 2;
    }

    if(KT6.isClicked && KT10.isClicked) {
     KTScore += 2;
    } else if (!KT6.isClicked && !KT10.isClicked) {
     KTScore -= 2;
    } 
  }

  public void nameOrder() {
      this.resetMatchPoints();
      this.resetScores();
      this.calculateMatchScores();
      this.calculateScores();
      this.initializeTeams();
      finalRank = sortOrder(this.scoreRank(), new IntComparator());
      this.places(finalRank);
      this.location(finalRank);
  
    }
  
  public void location(ArrayList<Team> team) {
    for(int i=0 ; i< team.size(); i++) {
      team.get(i).y = 40 + i * Utils.BUTTON_SIZE;
    }
  }
  

  

  // places for each team 
  public void places(ArrayList<Team> team) {
    for(int i = 1 ; i< team.size(); i++) {
      int place = 1;
      team.get(0).place = place;
      if (team.get(i-1).getScore() != team.get(i).getScore()) {
        place = i+1;
        team.get(i).place = place;

      } else {
        team.get(i).place = team.get(i-1).place;
      }
    }

  }

  // unordered rank with teams
  public ArrayList<Team> scoreRank() {
    ArrayList<Team> sRank = new ArrayList<Team>();
    Collections.addAll(sRank, SKT, Griffin, GENG, JAG, AF, HLE, KZ, BBQ, MVP, KT);
    return sRank;
  }

  // ordered rank with final scores
  public ArrayList<Team> sortOrder(ArrayList<Team> unordered, Comparator<Integer> comp) {
    for(int i = 1 ; i < unordered.size(); i++) {
      for(int j = i ; j> 0 ; j--) {
        if (comp.compare(unordered.get(j).getScore(), unordered.get(j-1).getScore()) > 0) {
          Collections.swap(unordered, j, j-1);
        }
      }
    }
    return unordered;
  }


  class IntComparator implements Comparator<Integer> {

    // compares the two integers
    // 0 - integers are the same
    // < 0 - second integer is larger
    // > 0 - first integer is larger
    public int compare(Integer int1, Integer int2) {
      return int1 - int2;
    }
  }
}



