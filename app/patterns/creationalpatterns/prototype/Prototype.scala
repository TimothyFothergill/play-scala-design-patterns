package patterns.creationalpatterns.prototype

import patterns.creationalpatterns.prototype.ShapeBase.Square

case class ShapePrototype(
    height: Int,
    width: Int,
    colour: ShapeColour,
    shape: ShapeBase,
    shapeName: String,
    shapeDescription: String,
    shapeIsAShape: Boolean
)

object ShapePrototype {
    override def clone: ShapePrototype = ShapePrototype(
        height = 50,
        width = 50,
        colour = ShapeColour.Red,
        shape = ShapeBase.Square,
        shapeName = "Square",
        shapeDescription = "A Red Square",
        shapeIsAShape = true
    )
}

sealed trait ShapeBase {
    def drawShape: String
}
object ShapeBase {
    case object Square extends ShapeBase {
        override def drawShape: String =
            """
            <svg>
                <rect id="square" x="0" y="0" width="50" height="50"/>
            </svg>
            """
    }
    case object Circle extends ShapeBase {
        override def drawShape: String = 
            """
            <svg>
                <circle id="circle" cx="0" cy="0" r="0" width="50" height="50"/>
            </svg>
            """
    }
    case object Rectangle extends ShapeBase {
        override def drawShape: String = 
            """
            <svg>
                <rect id="rectangle" x="0" y="0" width="100" height="50"/>
            </svg>
            """
    }
}

sealed trait ShapeColour {
    def toString: String
}
object ShapeColour {
    case object Red extends ShapeColour {
        override def toString: String = "Red"
    }
    case object Green extends ShapeColour {
        override def toString: String = "Green"
    }
    case object Blue extends ShapeColour {
        override def toString: String = "Blue"
    }
}