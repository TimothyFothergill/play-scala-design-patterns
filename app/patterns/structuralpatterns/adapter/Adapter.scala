package patterns.structuralpatterns.adapter

import patterns.structuralpatterns.adapter.Shape.Circle
import patterns.structuralpatterns.adapter.Shape.Square
import patterns.structuralpatterns.adapter.Shape.Triangle
import patterns.structuralpatterns.adapter.Shape.Rectangle

object ShapeAdapter {
    def adaptedShape(expectedShapeName: String, sides: Int, height: Int, width: Int): Shape = {
        expectedShapeName match {
            case "circle" => if(sides != Circle.sides) {
                selectShape(sides, height, width).setName("circle")
            } else {
                Circle
            }
            case "rectangle" => if(sides != Rectangle.sides) {
                selectShape(sides, height, width).setName("rectangle")
            } else {
                Triangle
            }
            case "square" => if(sides != Square.sides) {
                selectShape(sides, height, width).setName("square")
            } else {
                Square
            }
            case "triangle" => if(sides != Triangle.sides) {
                selectShape(sides, height, width).setName("triangle")
            } else {
                Triangle
            }
            case _ => { selectShape(sides, height, width).setName(expectedShapeName) }
        }
    }

    def selectShape(sides: Int, height: Int, width: Int): Shape = {
        sides match {
            case 0 => {Circle}
            case 3 => {Triangle}
            case 4 => {chooseQuadrilateral(height, width)}
        }
    }

    def chooseQuadrilateral(height: Int, width: Int): Shape = {
        if(height != width) { Rectangle } else { Square }
    }
}

sealed trait Shape {
    var shapeName: String = "shape"
    var height: Int
    var width: Int
    var sides: Int

    def drawShape(): String = {
        s"This ${shapeName} is ${height} tall, ${width} wide and has ${sides} sides"
    }

    def setName(newName: String): Shape = {
        shapeName = newName
        this
    }
}

object Shape {
    case object Triangle    extends Shape { 
        var height  : Int = 10
        var width   : Int = 10
        var sides   : Int = 3

        setName("triangle")
    }
    case object Square      extends Shape { 
        var height  : Int = 10
        var width   : Int = 10
        var sides   : Int = 4

        setName("square")
    }
    case object Rectangle   extends Shape {
        var height  : Int = 5
        var width   : Int = 10
        var sides   : Int = 4

        setName("rectangle")
    }
    case object Circle      extends Shape { 
        var height  : Int = 10
        var width   : Int = 10
        var sides   : Int = 0

        setName("circle")
    }
}