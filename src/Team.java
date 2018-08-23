import java.awt.Color;
import javalib.funworld.WorldScene;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;

class Team {
  String teamName;
  int finalScore;
  int place;
  int x;
  int y;
  int size;

  Team(String teamName, int finalScore, int place, int x, int y, int size) {
    this.teamName = teamName;
    this.finalScore = finalScore;
    this.place = place;
    this. x = x;
    this.y= y;
    this.size = size;
  }

  WorldScene drawPlaces (WorldScene img) {
    return img.placeImageXY(new OverlayImage(new TextImage(Integer.toString(this.place), Color.BLACK), new RectangleImage(this.size, this.size, "outline", Color.BLACK)),
        this.x, this.y);

  }
  
  WorldScene drawNames (WorldScene img) {
    return img.placeImageXY(new OverlayImage(new TextImage(this.teamName, Color.BLACK), new RectangleImage(this.size, this.size, "outline", Color.BLACK)), x + Utils.BUTTON_SIZE, y);
  }
  //  String getName() {
  //    return this.teamName;
  //  }
}
