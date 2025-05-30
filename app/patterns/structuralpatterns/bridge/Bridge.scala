package patterns.structuralpatterns.bridge

class RPGClassWarrior extends RPGClassBridge (
    className   = "",
    attack      = 13,
    defence     = 12,
    health      = 12,
    wisdom      = 8,
    intellect   = 7,
    dexterity   = 10,
    weaponType  = Sword    
)

class RPGClassMage extends RPGClassBridge (
    className   = "Mage",
    attack      = 7,
    defence     = 8,
    health      = 10,
    wisdom      = 12,
    intellect   = 15,
    dexterity   = 8,
    weaponType  = Staff    
)

class RPGClassRanger extends RPGClassBridge (
    className   = "Ranger",
    attack      = 10,
    defence     = 10,
    health      = 8,
    wisdom      = 12,
    intellect   = 10,
    dexterity   = 14,
    weaponType  = Bow
)

class RPGClassBridge(
    className   : String    ,
    attack      : Int       ,
    defence     : Int       ,
    health      : Int       ,
    wisdom      : Int       ,
    intellect   : Int       ,
    dexterity   : Int       ,
    weaponType  : WeaponType
) 


object RPGClassBridge {

}

sealed trait WeaponType {
    val weaponName: String
    val strength: Int
    val intellect: Int
    val dexterity: Int
}

object Sword extends WeaponType {
  override val weaponName: String = "Sword"
  override val strength: Int = 11
  override val intellect: Int = 0
  override val dexterity: Int = 0
}

object Staff extends WeaponType {
  override val weaponName: String = "Staff"
  override val strength: Int = 0
  override val intellect: Int = 11
  override val dexterity: Int = 0
}

object Bow extends WeaponType {
  override val weaponName: String = "Bow"
  override val strength: Int = 0
  override val intellect: Int = 0
  override val dexterity: Int = 11
}
