import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javalib.funworld.World;
import javalib.funworld.WorldScene;
import javalib.worldimages.Posn;

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
  Team SKT, Griffin;
  Team GENG, JAG;
  Team AF, HLE; 
  Team KZ, BBQ;
  Team MVP, KT;
  //subtracts wins from losses 
  int SKTScore, GriffinScore, GENGScore, JAGScore, AFScore, HLEScore, KZScore, BBQScore, MVPScore, KTScore;
  int finalSKTScore, finalGriffinScore, finalGENGScore;
  int finalJAGScore, finalAFScore, finalHLEScore, finalKZScore, finalBBQScore, finalMVPScore, finalKTScore;
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
  @Override
  public WorldScene makeScene() {
    WorldScene s = new WorldScene(Utils.GAME_SIZE, Utils.GAME_SIZE);
    WorldScene choices = SKT1.draw(SKT9.draw(Griffin1.draw(Griffin8.draw(GENG2.draw(GENG5.draw
        (JAG2.draw(JAG7.draw(AF3.draw(AF7.draw(HLE3.draw(HLE6.draw
            (KZ4.draw(KZ9.draw(BBQ4.draw(BBQ8.draw(MVP5.draw(MVP10.draw
                (KT6.draw(KT10.draw(s))))))))))))))))))));

    if(this.finish()) {
    this.nameOrder();
  WorldScene places = SKT.drawPlaces(Griffin.drawPlaces(GENG.drawPlaces(JAG.drawPlaces(AF.drawPlaces
  (HLE.drawPlaces(KZ.drawPlaces(BBQ.drawPlaces(MVP.drawPlaces(KT.drawPlaces(choices))))))))));
  WorldScene all = SKT.drawNames(Griffin.drawNames(GENG.drawNames(JAG.drawNames(AF.drawNames
      (HLE.drawNames(KZ.drawNames(BBQ.drawNames(MVP.drawNames(KT.drawNames(places))))))))));
      return all;
    } else {
      return choices;
    }
  }
  
  public void initializeTeams() {
    SKT = new Team("SKT", finalSKTScore, 0, (int) (Utils.BUTTON_SIZE *3.5), 0, Utils.BUTTON_SIZE); 
    Griffin = new Team("Griffin", finalGriffinScore, 0, (int) (Utils.BUTTON_SIZE *3.5), 0, Utils.BUTTON_SIZE);
    GENG = new Team("GEN.G", finalGENGScore, 0,(int)(Utils.BUTTON_SIZE *3.5),0, Utils.BUTTON_SIZE);
    JAG = new Team("JAG", finalJAGScore, 0,(int)(Utils.BUTTON_SIZE *3.5),0, Utils.BUTTON_SIZE); 
    AF = new Team("AF", finalAFScore, 0,(int)(Utils.BUTTON_SIZE *3.5), 0,Utils.BUTTON_SIZE); 
    HLE = new Team("HLE", finalHLEScore, 0,(int)(Utils.BUTTON_SIZE *3.5), 0, Utils.BUTTON_SIZE); 
    KZ = new Team("KZ", finalKZScore, 0,(int)(Utils.BUTTON_SIZE *3.5),0, Utils.BUTTON_SIZE);
    BBQ = new Team("BBQ", finalBBQScore, 0,(int)(Utils.BUTTON_SIZE *3.5),0, Utils.BUTTON_SIZE); 
    MVP = new Team("MVP", finalMVPScore, 0,(int)(Utils.BUTTON_SIZE *3.5),0, Utils.BUTTON_SIZE);
    KT = new Team("KT", finalKTScore, 0,(int)(Utils.BUTTON_SIZE *3.5),0, Utils.BUTTON_SIZE);
    

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
    } else {
      return new Button(0,0,"nothing",0,true);
    }
  }
  public World darken(Button name) {
    if(name.equals(this.SKT1)) {
      if(Griffin1.isClicked) {
        this.Griffin1 = this.Griffin1.changeState();
      }
      this.SKT1 = this.SKT1.changeState(); 

    } else if(name.equals(this.SKT9)) {
      if(KZ9.isClicked) {
        this.KZ9 = this.KZ9.changeState();
      }
      this.SKT9 = this.SKT9.changeState();

    } else if(name.equals(this.Griffin1)) {
      if(SKT1.isClicked) { 
        this.SKT1 = this.SKT1.changeState();
      }
      this.Griffin1 = this.Griffin1.changeState();

    } else if (name.equals(this.Griffin8)) {
      if(BBQ8.isClicked) {
        this.BBQ8 = this.BBQ8.changeState();
      }
      this.Griffin8 = this.Griffin8.changeState();

    }else if (name.equals(this.GENG2)) {
      if(JAG2.isClicked) {
        this.JAG2 = this.JAG2.changeState();
      }
      this.GENG2 = this.GENG2.changeState();

    } else if (name.equals(this.GENG5)) {
      if (MVP5.isClicked) {
        this.MVP5 = this.MVP5.changeState();
      }
      this.GENG5 = this.GENG5.changeState();

    } else if (name.equals(this.JAG2)) {
      if(GENG2.isClicked) {
        this.GENG2 =this.GENG2.changeState();
      }
      this.JAG2 = this.JAG2.changeState();

    } else if (name.equals(this.JAG7)) {
      if(AF7.isClicked) {
        this.AF7 = this.AF7.changeState();
      }
      this.JAG7 = this.JAG7.changeState();

    } else if (name.equals(this.AF3)) {
      if(HLE3.isClicked) {
        this.HLE3 = this.HLE3.changeState();
      }

      this.AF3 = this.AF3.changeState();

    } else if (name.equals(this.AF7)) {
      if(JAG7.isClicked) {
        this.JAG7 = JAG7.changeState();
      }

      this.AF7 = this.AF7.changeState();

    } else if (name.equals(this.HLE3)) {
      if(AF3.isClicked) {
        this.AF3 = this.AF3.changeState();
      }
      this.HLE3 = this.HLE3.changeState();

    } else if (name.equals(this.HLE6)) {
      if(KT6.isClicked) {
        this.KT6 = this.KT6.changeState();
      }
      this.HLE6 = this.HLE6.changeState();

    } else if (name.equals(this.KZ4)) {
      if(BBQ4.isClicked) {
        this.BBQ4 = this.BBQ4.changeState();
      }
      this.KZ4 = this.KZ4.changeState();

    } else if (name.equals(this.KZ9)) {
      if(SKT9.isClicked) {
        this.SKT9 = this.SKT9.changeState();
      }
      this.KZ9 = this.KZ9.changeState();

    } else if (name.equals(this.BBQ4)) { 
      if(KZ4.isClicked) {
        this.KZ4 = this.KZ4.changeState();
      }
      this.BBQ4 = this.BBQ4.changeState();

    } else if (name.equals(this.BBQ8)) {
      if(Griffin8.isClicked) {
        this.Griffin8 = this.Griffin8.changeState();
      }
      this.BBQ8 = this.BBQ8.changeState();

    } else if (name.equals(this.MVP5)) {
      if(GENG5.isClicked) {
        this.GENG5 = this.GENG5.changeState();
      }
      this.MVP5 = this.MVP5.changeState();

    } else if (name.equals(this.MVP10)) {
      if (KT10.isClicked) {
        this.KT10 = this.KT10.changeState();
      }
      this.MVP10 = this.MVP10.changeState();

    } else if (name.equals(this.KT6)) {
      if(HLE6.isClicked) {
        this.HLE6 = this.HLE6.changeState();
      }
      this.KT6 = this.KT6.changeState();

    } else if (name.equals(this.KT10)) {
      if(MVP10.isClicked) {
        this.MVP10 = this.MVP10.changeState();
      }
      this.KT10 = this.KT10.changeState();
    }
    return this;
  }

  public boolean finish() {
    return (SKT1.isClicked || Griffin1.isClicked) && (GENG2.isClicked || JAG2.isClicked) && (AF3.isClicked || HLE3.isClicked) &&
        (BBQ4.isClicked|| KZ4.isClicked) && (MVP5.isClicked || GENG5.isClicked) && (HLE6.isClicked|| KT6.isClicked) && (JAG7.isClicked || AF7.isClicked) 
        && (Griffin8.isClicked|| BBQ8.isClicked) && (SKT9.isClicked || KZ9.isClicked) && (KT10.isClicked||MVP10.isClicked); 
  }

  public void calculateScores() {
    if (SKT1.isClicked && SKT9.isClicked) {
      finalSKTScore = SKTScore + 2;
    } else if (!SKT1.isClicked && !SKT9.isClicked) {
      finalSKTScore = SKTScore - 2;
    } else {
      finalSKTScore = SKTScore;
    }

    if (Griffin1.isClicked && Griffin8.isClicked) {
      finalGriffinScore = GriffinScore + 2;
    } else if (!Griffin1.isClicked && !Griffin8.isClicked) {
      finalGriffinScore = GriffinScore - 2;
    } else {
      finalGriffinScore = GriffinScore;
    }

    if(GENG2.isClicked && GENG5.isClicked) {
      finalGENGScore = GENGScore + 2;
    } else if (!GENG2.isClicked && !GENG5.isClicked) {
      finalGENGScore = GENGScore - 2;
    } else {
      finalGENGScore = GENGScore;
    }

    if(JAG2.isClicked && JAG7.isClicked) {
      finalJAGScore = JAGScore + 2;
    } else if (!JAG2.isClicked && !JAG7.isClicked) {
      finalJAGScore = JAGScore - 2;
    } else {
      finalJAGScore = JAGScore;
    }

    if(AF3.isClicked && AF7.isClicked) {
      finalAFScore = AFScore + 2;
    } else if (!AF3.isClicked && !AF7.isClicked) {
      finalAFScore = AFScore - 2;
    } else {
      finalAFScore = AFScore;
    }

    if(HLE3.isClicked && HLE6.isClicked) {
      finalHLEScore = HLEScore + 2;
    } else if (!HLE3.isClicked && !HLE6.isClicked) {
      finalHLEScore = HLEScore - 2;
    } else {
      finalHLEScore = HLEScore;
    }

    if(BBQ4.isClicked && BBQ8.isClicked) {
      finalBBQScore = BBQScore + 2;
    } else if (!BBQ4.isClicked && !BBQ8.isClicked) {
      finalBBQScore = BBQScore - 2;
    } else { 
      finalBBQScore = BBQScore;
    }

    if(KZ4.isClicked && KZ9.isClicked) {
      finalKZScore = KZScore + 2;
    } else if (!KZ4.isClicked && !KZ9.isClicked) {
      finalKZScore = KZScore - 2;
    } else {
      finalKZScore = KZScore;
    }

    if (MVP5.isClicked && MVP10.isClicked) {
      finalMVPScore = MVPScore + 2;
    } else if (!MVP5.isClicked && !MVP10.isClicked) {
      finalMVPScore = MVPScore - 2;
    } else {
      finalMVPScore = MVPScore;
    }

    if(KT6.isClicked && KT10.isClicked) {
      finalKTScore = KTScore + 2;
    } else if (!KT6.isClicked && !KT10.isClicked) {
      finalKTScore = KTScore - 2;
    } else {
      finalKTScore = KTScore;
    }
  }

  public void nameOrder() {
      this.calculateScores();
      this.initializeTeams();
      finalRank = sortOrder(this.scoreRank(), new IntComparator());
      this.places(finalRank);
      this.location(finalRank);
  
    }
  
  public void location(ArrayList<Team> team) {
    for(int i=0 ; i<team.size(); i++) {
      team.get(i).y = 40 + i * Utils.BUTTON_SIZE;
    }
  }
  

  

  // places for each team 
  public void places(ArrayList<Team> team) {
    for(int i = 1 ; i< team.size(); i++) {
      int place = 1;
      team.get(0).place = place;
      if (team.get(i-1).finalScore != team.get(i).finalScore) {
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
        if (comp.compare(unordered.get(j).finalScore, unordered.get(j-1).finalScore) > 0) {
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


