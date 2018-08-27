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
      return img.placeImageXY(new OverlayImage(new TextImage(this.text, Color.BLACK), 
          new RectangleImage(this.size, this.size, "outline", Color.BLACK)),
          this.x, this.y);
    }else {
      return img.placeImageXY(new OverlayImage(new TextImage(this.text, Color.BLACK), 
          new OverlayImage(new RectangleImage(this.size, this.size, "outline", Color.BLACK), 
              new RectangleImage(this.size, this.size, "solid", Color.GREEN))),
          this.x, this.y);
    }
  }
  //change to void ...isclicked = !isClicked
  void changeState() {
    this.isClicked = !this.isClicked;
  }
  int getX() {
    return this.x;
   
  }
  int getY() {
    return this.y;
  }
  String getText() {
    return this.text;
  }
  int getSize() {
    return this.size;
  }
  boolean getisClicked() {
    return this.isClicked;
  }

}
