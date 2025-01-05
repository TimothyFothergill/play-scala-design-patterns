package patterns.creationalpatterns

import org.scalatest._
import flatspec._
import matchers._
import patterns.creationalpatterns.builder._

class BuilderSpec extends AnyFlatSpec with should.Matchers {
    "EnemyBuilder" should "create a default enemy" in {
        val enemy: Enemy = EnemyBuilder().build()
        enemy.enemyName shouldBe "enemy"
    }

    it should "accept a custom name" in {
        val enemy: Enemy = EnemyBuilder()
                            .withName("custom")
                            .build()

        enemy.enemyName shouldBe "custom"
    }
    it should "accept a different EnemyType" in {
        val enemy: Enemy = EnemyBuilder()
                            .withEnemyType(EnemyType.Goblin)
                            .build()

        enemy.enemyIsType.typeName shouldBe "Goblin"
    }
    it should "accept a custom health as a float or as an int" in {
        val enemy: Enemy = EnemyBuilder()
                            .withHealth(150)
                            .build()

        enemy.enemyHealth shouldBe 150.0
    }
    it should "accept integers for enemy attack, defence, magic and ranged" in {
        val enemy: Enemy = EnemyBuilder()
                            .withAttack(20)
                            .withDefence(30)
                            .withMagicAttack(40)
                            .withRangedAttack(50)
                            .build()

        enemy.enemyAttack shouldBe 20
        enemy.enemyDefence shouldBe 30
        enemy.enemyMagicAttack shouldBe 40
        enemy.enemyRangedAttack shouldBe 50
    }

    it should "accept a boolean for if it has a special attack" in {
        val enemy: Enemy = EnemyBuilder()
                            .withSpecialAttack(true)
                            .build()

        enemy.enemyHasSpecialAttack shouldBe true
    }

    it should "accept a Seq of custom EnemyDrop" in {
        val enemyDropSeq: Seq[EnemyDrop] = Seq(EnemyDrop("helmet of defence",1), EnemyDrop("bones",2))
        val enemy: Enemy = EnemyBuilder()
                            .withDrops(enemyDropSeq)
                            .build()

        enemy.enemyDrops.head.dropName shouldBe "helmet of defence"
    }
  
}
