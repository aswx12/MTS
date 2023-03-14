package suikaMod.cards.CardGenerator;

public class ActionVar
{
    //region dmg related
    public static String dmg = "DAMAGE";

    public static String dmgModify = "dmgModifyValue";

    public static String dmgPerEnergy ="dmgPerEnergyValue";

    public static String dmgPerExhaustedAtt = "dmgPerExhAtt";
    public static String vampDmg ="vampDmgValue";

    public static String dmgIfTargetPsn ="dmgIfTargetPsnValue";
    public static String dmgPerAttPlayed ="dmgPerAttPlayedValue";
    public static String dmgPerSkillInHand ="dmgPerSkillHandValue";
    //endregion
    public static String blc = "BLOCK";
    public static String gEnergy = "ENERGY";
    public static String rpt = "repeatTIME";

    //region Buff/debuff
    public static String aVul = "aVULNERABLE";
    public static String aWk = "aWEAK";
    public static String aPsn = "aPOISON";
    public static String aStr = "aSTR";

    public static String gVul = "gVULNERABLE";
    public static String gWk = "gWEAK";
    public static String gPsn = "gPOISON";
    public static String gStr = "gSTR";

    public static String gDex = "gDEX"; //maybe attack intent too?

    public static String gIntang="gINTANG";

    //endregion

    //region Buff/debuff enemy intent
    public static String aVulEneAttIntent = "aVULNERABLEAttIntent";
    public static String aWkEneAttIntent = "aWEAKAttIntent";
    public static String aPsnEneAttIntent = "aPOISONAttIntent";
    public static String aStrEneAttIntent = "aSTRAttIntent";

    public static String gVulEneAttIntent = "gVULNERABLEAttIntent";
    public static String gWkEneAttIntent = "gWEAKAttIntent";
    public static String gPsnEneAttIntent = "gPOISONAttIntent";
    public static String gStrEneAttIntent = "gSTRAttIntent";


    //endregion

    //region Health related

    public static String loseHP = "hpValue";
    public static String healing = "healingValue";


    //endregion

    //Discard(Disc)
    //Qty(quantity)
    //Draw Pile(DrawP)

    //region Copy played card
    public static String copy2Disc = "copy2DiscQty";
    public static String copy2Hand = "copy2HandQty";
    public static String copy2DrawP = "copy2DrawPQty";
    public static String copy2TopDrawP = "copy2TopDrawPQty";
    public static String copy2BotDrawP = "copy2BotDrawPQty";
    //endregion

    //region Add random copies
    //(r)andom
    public static String rAttackHandCopy = "rAttackCopy2HandQty";
    public static String rSkillHandCopy = "rSkillCopy2HandQty";
    public static String rPowerHandCopy = "rPowerCopy2HandQty";
    public static String rColorlessHandCopy = "rColorlessCopy2HandQty";

    public static String rAttackDiscCopy = "rAttackCopy2DiscQty";
    public static String rSkillDiscCopy = "rSkillCopy2DiscQty";
    public static String rPowerDiscCopy = "rPowerCopy2DiscQty";
    public static String rColorlessDiscCopy = "rColorlessCopy2DiscQty";

    public static String rAttackDrawPCopy = "rAttackCopy2DrawPQty";
    public static String rSkillDrawPCopy = "rSkillCopy2DrawPQty";
    public static String rPowerDrawPCopy = "rPowerCopy2DrawPQty";
    public static String rColorlessDrawPCopy = "rColorlessCopy2DrawPQty";

    public static String rAttackTopDrawPCopy = "rAttackCopy2TopDrawPQty";
    public static String rSkillTopDrawPCopy = "rSkillCopy2TopDrawPQty";
    public static String rPowerTopDrawPCopy = "rPowerCopy2TopDrawPQty";
    public static String rColorlessTopDrawPCopy = "rColorlessCopy2TopDrawPQty";

    public static String rAttackBotDrawPCopy = "rAttackCopy2BotDrawPQty";
    public static String rSkillBotDrawPCopy = "rSkillCopy2BotDrawPQty";
    public static String rPowerBotDrawPCopy = "rPowerCopy2BotDrawPQty";
    public static String rColorlessBotDrawPCopy = "rColorlessCopy2BotDrawPQty";
    //endregion

    //-----------------------------------------

    //region Add random cards
    public static String rAttackHand = "rAttack2HandQty";
    public static String rSkillHand= "rSkill2HandQty";
    public static String rPowerHand = "rPower2HandQty";
    public static String rColorlessHand = "rColorless2HandQty";

    public static String rAttackDisc = "rAttack2DiscQty";
    public static String rSkillDisc= "rSkill2DiscQty";
    public static String rPowerDisc = "rPower2DiscQty";
    public static String rColorlessDisc = "rColorless2DiscQty";

    public static String rAttackDrawP = "rAttack2DrawPQty";
    public static String rSkillDrawP = "rSkill2DrawPQty";
    public static String rPowerDrawP= "rPower2DrawPQty";
    public static String rColorlessDrawP = "rColorless2DrawPQty";

    public static String rAttackTopDrawP = "rAttack2TopDrawPQty";
    public static String rSkillTopDrawP = "rSkill2TopDrawPQty";
    public static String rPowerTopDrawP = "rPower2DrawTopPQty";
    public static String rColorlessTopDrawP = "rColorless2TopDrawPQty";

    public static String rAttackBotDrawP = "rAttack2BotDrawPQty";
    public static String rSkillBotDrawP = "rSkill2BotDrawPQty";
    public static String rPowerBotDrawP = "rPower2BotDrawPQty";
    public static String rColorlessBotDrawP = "rColorless2BotDrawPQty";

    //endregion

   //region Choose2Draw

    public static String choose2Draw = "chooseDrawQty";
    public static String choose2DrawAttack= "chooseAttackDrawQty";
    public static String choose2DrawSkill = "chooseSkillDrawQty";

    //endregion
    //region Draw
    public static String draw = "drawQty";
    public static String drawUntilxHand = "drawUntilxHandQty";
    public static String drawXtrNxtTurn = "drawXtraNextTurnQty";
    public static String drawXtrAtStart = "drawXtraAtTurnStartQty";
    public static String drawWhenDisc = "drawWhenDiscQty";
    public static String drawPerExh = "drawPerExhQty";
    public static String drawPerUOrb = "drawPerUniqOrbQty";
    public static String drawOnPowPlay = "drawPowerPlayQty";


    //endregion
}
