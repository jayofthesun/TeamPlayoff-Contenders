import java.util.ArrayList;
import java.util.Collections;
import javalib.worldimages.Posn;
import tester.*;
class ExamplesPlayoffMatches {

  PlayoffMatches t1;
  void initData() {
    t1 = new PlayoffMatches();

  }

  void testPlayoffMatches(Tester t) {
    this.initData();
    t1.bigBang(900, 900);
  }
  void testbuttonPressed(Tester t) {
    this.initData();
    t.checkExpect(t1.buttonPressed(new Posn(50,50)), Utils.SKT1);
    t.checkExpect(t1.buttonPressed(new Posn(85,50)), Utils.Griffin1);
  }

  void testdarken(Tester t) {
    this.initData();
    t1.SKT1.isClicked = false;
    t.checkExpect(t1.SKT1, new Button(t1.SKT1.x, t1.SKT1.y, t1.SKT1.text, t1.SKT1.size, false));
    t1.darken(t1.SKT1);
    t.checkExpect(t1.SKT1, new Button(t1.SKT1.x, t1.SKT1.y, t1.SKT1.text, t1.SKT1.size, true));
  }
  void testfinish(Tester t) {
    this.initData();
    t1.SKT1.isClicked = false;
    t1.AF3.isClicked = false;
    t1.AF7.isClicked = false;
    t1.BBQ4.isClicked = false;
    t1.BBQ8.isClicked = false;
    t1.GENG2.isClicked = false;
    t1.KZ9.isClicked = false;
    t1.KT10.isClicked = false;
    t1.KT6.isClicked = false;
    t1.MVP5.isClicked = false;
    t.checkExpect(t1.finish(), false);
    t1.SKT1.isClicked = true;
    t1.AF3.isClicked = true;
    t1.AF7.isClicked = true;
    t1.BBQ4.isClicked = true;
    t1.BBQ8.isClicked = true;
    t1.GENG2.isClicked = true;
    t1.KZ9.isClicked = true;
    t1.KT10.isClicked = true;
    t1.KT6.isClicked = true;
    t1.MVP5.isClicked = true;
    t.checkExpect(t1.finish(), true);

  }
  void testcalculateScores(Tester t) {
    this.initData();
    t.checkExpect(t1.BBQScore, -12);
    t.checkExpect(t1.SKTScore, 0);
    t.checkExpect(t1.GriffinScore, 6);
    t1.SKT1.isClicked = true;
    t1.AF3.isClicked = true;
    t1.AF7.isClicked = true;
    t1.BBQ4.isClicked = true;
    t1.BBQ8.isClicked = true;
    t1.GENG2.isClicked = true;
    t1.KZ9.isClicked = true;
    t1.KT10.isClicked = true;
    t1.KT6.isClicked = true;
    t1.MVP5.isClicked = true;
    t1.calculateScores();
    t.checkExpect(t1.finalBBQScore, -10);
    t.checkExpect(t1.finalSKTScore, 0);
    t.checkExpect(t1.finalGriffinScore, 4);

  }
  void testsortOrder(Tester t) {
    this.initData();
    t1.SKT1.isClicked = true;
    t1.AF3.isClicked = true;
    t1.AF7.isClicked = true;
    t1.BBQ4.isClicked = true;
    t1.BBQ8.isClicked = true;
    t1.GENG2.isClicked = true;
    t1.KZ9.isClicked = true;
    t1.KT10.isClicked = true;
    t1.KT6.isClicked = true;
    t1.MVP5.isClicked = true;
    t1.calculateScores();
    t1.initializeTeams();
    t.checkExpect(t1.SKT.teamName, "SKT");
    ArrayList<Team>list= new ArrayList<Team>();
    Collections.addAll(list, t1.KT, t1.GENG, t1.KZ, t1.Griffin, t1.AF ,t1.SKT, t1.HLE, t1.MVP, t1.JAG, t1.BBQ);
    t.checkExpect(t1.sortOrder(t1.scoreRank(), t1.new IntComparator()),list);

  }
  void testscoreRank(Tester t) {
    this.initData();
    t1.SKT1.isClicked = true;
    t1.AF3.isClicked = true;
    t1.AF7.isClicked = true;
    t1.BBQ4.isClicked = true;
    t1.BBQ8.isClicked = true;
    t1.GENG2.isClicked = true;
    t1.KZ9.isClicked = true;
    t1.KT10.isClicked = true;
    t1.KT6.isClicked = true;
    t1.MVP5.isClicked = true;
    t1.calculateScores();
  
    ArrayList<Team> sRank = new ArrayList<Team>();
    Collections.addAll(sRank, t1.SKT, t1.Griffin, t1.GENG, t1.JAG, t1.AF, t1.HLE, t1.KZ, t1.BBQ, t1.MVP, t1.KT);
    t.checkExpect(t1.scoreRank(), sRank);
  }

  void testinitializeTeams(Tester t) {
    this.initData();
    t1.SKT1.isClicked = true;
    t1.AF3.isClicked = true;
    t1.AF7.isClicked = true;
    t1.BBQ4.isClicked = true;
    t1.BBQ8.isClicked = true;
    t1.GENG2.isClicked = true;
    t1.KZ9.isClicked = true;
    t1.KT10.isClicked = true;
    t1.KT6.isClicked = true;
    t1.MVP5.isClicked = true;
    t1.calculateScores();
    t1.initializeTeams();
    t.checkExpect(t1.SKT,new Team("SKT", t1.finalSKTScore, 0, (int) (Utils.BUTTON_SIZE *3.5), 0, Utils.BUTTON_SIZE));
    t.checkExpect(t1.SKT.teamName, "SKT");
    t.checkExpect(t1.SKT.finalScore, t1.finalSKTScore);
    t.checkExpect(t1.SKT.place, 0);
    t.checkExpect(t1.SKT.x,(int) (Utils.BUTTON_SIZE *3.5));
    t.checkExpect(t1.SKT.y, 0);
    t.checkExpect(t1.SKT.size, Utils.BUTTON_SIZE);
    
  }
  void testplaces(Tester t) {
    this.initData();
    t1.SKT1.isClicked = true;
    t1.AF3.isClicked = true;
    t1.AF7.isClicked = true;
    t1.BBQ4.isClicked = true;
    t1.BBQ8.isClicked = true;
    t1.GENG2.isClicked = true;
    t1.KZ9.isClicked = true;
    t1.KT10.isClicked = true;
    t1.KT6.isClicked = true;
    t1.MVP5.isClicked = true;
    t1.nameOrder();
    t.checkExpect(t1.KT.place, 1);
    t.checkExpect(t1.GENG.place, 2);
    t.checkExpect(t1.KZ.place, 2);
    t.checkExpect(t1.Griffin.place, 4);
    t.checkExpect(t1.AF.place, 4);
    t.checkExpect(t1.HLE.place, 6);
    t.checkExpect(t1.SKT.place,6);
    t.checkExpect(t1.MVP.place, 8);
    t.checkExpect(t1.JAG.place, 9);
    t.checkExpect(t1.BBQ.place, 9);
  }
}
