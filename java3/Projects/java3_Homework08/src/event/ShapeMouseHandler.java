package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.*;
import shapes.Shape;

public class ShapeMouseHandler extends MouseAdapter {
  
  private Model model;
  //Start x and y location used to mark where the upper left corner of a
  
  private int startX, startY;
  private Shape shape;
  
  public ShapeMouseHandler(Model model) {
    //persist local variable model to this.model
    this.model = model;
  }
  
  public void mousePressed(MouseEvent e) {
    if(model.getAction() == Model.DRAW) {
      startX = e.getX();
      startY = e.getY();
      
      shape = model.createShape();
      
      if(shape != null) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        
        if(shape instanceof Rectangle) {
          ((Rectangle)shape).setWidth(50);
          ((Rectangle)shape).setHeight(50);
        }
        
        if(shape instanceof Oval) {
          ((Oval)shape).setWidth(50);
          ((Oval)shape).setHeight(50);
        }
        
        if(shape instanceof Triangle) {
          ((Triangle)shape).setWidth(50);
          ((Triangle)shape).setHeight(50);
        }
      }
    }
    
    model.repaint();
  }
  
  public void mouseDragged(MouseEvent e) {
    shape = model.getCurrentShape();
    
    if(shape != null) {
      if(model.getAction() == Model.DRAW) {
        shape.setX(Math.min(startX, e.getX()));
        shape.setY(Math.min(startY, e.getY()));
      }
      
      if(shape instanceof Rectangle) {
        ((Rectangle)shape).setWidth(Math.abs(startX - e.getX()));
        ((Rectangle)shape).setHeight(Math.abs(startY - e.getY()));
      }
      
      if(shape instanceof Oval) {
        ((Oval)shape).setWidth(Math.abs(startX - e.getX()));
        ((Oval)shape).setHeight(Math.abs(startY - e.getY()));
      }
      
      if(shape instanceof Triangle) {
        ((Triangle)shape).setWidth(Math.abs(startX - e.getX()));
        ((Triangle)shape).setHeight(Math.abs(startY - e.getY()));
      }
    }
    
    model.repaint();
  }
}
