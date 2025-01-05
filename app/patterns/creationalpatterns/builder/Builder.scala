package patterns.creationalpatterns.builder

case class EnemyBuilder private (
    enemyName: String               = "enemy",
    enemyHealth: Float              = 10.0,
    enemyAttack: Int                = 1,
    enemyDefence: Int               = 1,
    enemyMagicAttack: Int           = 1,
    enemyRangedAttack: Int          = 1,
    enemyHasSpecialAttack: Boolean  = false,
    enemyIsType: EnemyType          = EnemyType.Human,
    enemyDrops: Seq[EnemyDrop]      = Seq()
) {
    def withName(name: String)                  = { copy(enemyName = name)                  }
    def withHealth(health: Float)               = { copy(enemyHealth = health)              }
    def withAttack(attack: Int)                 = { copy(enemyAttack = attack)              }
    def withDefence(defence: Int)               = { copy(enemyDefence = defence)            }
    def withMagicAttack(magicAttack: Int)       = { copy(enemyMagicAttack = magicAttack)    }
    def withRangedAttack(rangedAttack: Int)     = { copy(enemyRangedAttack = rangedAttack)  }
    def withSpecialAttack(hasSpecial: Boolean)  = { copy(enemyHasSpecialAttack = hasSpecial)}
    def withEnemyType(enemyType: EnemyType)     = { copy(enemyIsType = enemyType)           }
    def withDrops(hasDrops: Seq[EnemyDrop])     = { copy(enemyDrops = hasDrops)             }

    def build() = Enemy(
        enemyName = enemyName,
        enemyHealth = enemyHealth,
        enemyAttack = enemyAttack,
        enemyDefence = enemyDefence,
        enemyMagicAttack = enemyMagicAttack,
        enemyRangedAttack = enemyRangedAttack,
        enemyHasSpecialAttack = enemyHasSpecialAttack,
        enemyIsType = enemyIsType,
        enemyDrops = enemyDrops
    )
}

object EnemyBuilder {
    def apply() = new EnemyBuilder()
}

case class Enemy(
    enemyName: String,
    enemyHealth: Float,
    enemyAttack: Int,
    enemyDefence: Int,
    enemyMagicAttack: Int,
    enemyRangedAttack: Int,
    enemyHasSpecialAttack: Boolean,
    enemyIsType: EnemyType,
    enemyDrops: Seq[EnemyDrop]
)

sealed trait EnemyType {
    def icon: String = ""
    def typeName: String = ""
}

object EnemyType {
    case object Human extends EnemyType {
        override def icon: String = "human.png"
        override def typeName: String = "Human"
    }
    case object Goblin extends EnemyType {
        override def icon: String = "goblin.png"
        override def typeName: String = "Goblin"
    }
}

case class EnemyDrop(
    dropName: String = "item",
    dropQuantity: Int = 1
)