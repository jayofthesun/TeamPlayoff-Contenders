import java.awt.Color;

import javalib.funworld.WorldScene;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;

class Button {
  int x;
  int y;
  String text;
  int size;
  boolean isClicked;

  Button(int x, int y, String text, int size, boolean isClicked) {
    this.x = x;
    this.y = y;
    this.text = text;
    this.size = size;
    this.isClicked = isClicked;
  }

  //draws a button
  WorldScene draw(WorldScene img) {
    if(!isClicked) {
      return img.placeImageXY(new OverlayImage(new TextImage(this.text, Color.BLACK), new RectangleImage(this.size, this.size, "outline", Color.BLACK)),
          this.x, this.y);
    }else {
      return img.placeImageXY(new OverlayImage(new TextImage(this.text, Color.BLACK), new RectangleImage(this.size, this.size, "solid", Color.GRAY)),
          this.x, this.y);
    }
  }
  Button changeState() {
    return new Button(this.x,this.y, this.text, this.size, !this.isClicked);
  }


}