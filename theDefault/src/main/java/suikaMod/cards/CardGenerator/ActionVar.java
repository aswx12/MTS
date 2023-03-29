package suikaMod.cards.CardGenerator;

public class ActionVar
{
    //region dmg related
    public static String dmg = "DAMAGE";

    public static String dmgModify = "dmgModifyValue";

    public static String dmgPerEnergy = "dmgPerEnergyValue";

    public static String dmgPerExhaustedAtt = "dmgPerExhAtt";
    public static String vampDmg = "vampDmgValue";

    public static String dmgIfTargetPsn = "dmgIfTargetPsnValue";
    public static String dmgPerAttPlayed = "dmgPerAttPlayedValue";
    public static String dmgPerSkillInHand = "dmgPerSkillHandValue";
    //endregion
    public static String blc = "BLOCK";
    public static String gEnergy = "ENERGY";

    public static String energized ="energizedValue";
    public static String energyDisc ="energyDiscValue";
    public static String rpt = "repeatTIME";

    //region Buff/debuff
    public static String aVul = "aVULNERABLE";
    /*    static int aVulVersion;
        static String aVulOrg = aVul;*/
    public static String aWk = "aWEAK";
    public static String aPsn = "aPOISON";
    public static String aStr = "aSTR";

    public static String gVul = "gVULNERABLE";
    public static String gWk = "gWEAK";
    public static String gPsn = "gPOISON";
    public static String gStr = "gSTR";

    public static String gDex = "gDEX"; //maybe attack intent too?

    public static String gIntang = "gINTANG";

    //endregion

    //region Buff/debuff enemy intent
/*
    public static String aVulEneAttIntent = "aVULNERABLEAttIntent";
    public static String aWkEneAttIntent = "aWEAKAttIntent";
    public static String aPsnEneAttIntent = "aPOISONAttIntent";
    public static String aStrEneAttIntent = "aSTRAttIntent";

    public static String gVulEneAttIntent = "gVULNERABLEAttIntent";
    public static String gWkEneAttIntent = "gWEAKAttIntent";
    public static String gPsnEneAttIntent = "gPOISONAttIntent";
    public static String gStrEneAttIntent = "gSTRAttIntent";
*/


    //endregion

    //region Health related

    public static String loseHP = "hpValue";
    public static String healing = "healingValue";


    //endregion

    //Discard(Disc)
    //Qty(quantity)
    //Draw Pile(DrawP)
    public static String toDisc = "DiscQty";

    public static String toHand = "HandQty";

    public static String toDrawP = "DrawPQty";

    public static String toTopDrawP = "TopDrawPQty";

    public static String toBotDrawP = "BotDrawPQty";
    public static String actionVar="";
    //region Copy played card
    public static String addCpy = "addCopyV";
    public static int addCpyV;



    //endregion

    //region Add random copies
    //(r)andom
    public static String RandomAttCpy = "rAttCopyV";
    public static int randomAttCpyV;
    public static String RandomSkillCpy = "rSkillCopyV";
    public static int randomSkillCpyV;
    public static String RandomPowerCpy = "rPowerCopyV";
    public static int randomPowerCpyV;
    public static String RandomColorlessCpy = "rColorlessCopyV";
    public static int randomColorlessCpyV;
    //endregion

    //-----------------------------------------

    //region Add random cards
    public static String RandomAtt = "rAttV";
    public static int randomAttV;
    public static String RandomSkill = "rSkillV";
    public static int randomSkillV;
    public static String RandomPower = "rPowerV";
    public static int randomPowerV;
    public static String RandomColorless = "rColorlessV";
    public static int randomColorlessV;

    //endregion

    //region Choose2Draw

    public static String choose2Draw = "chooseDrawQty";
    public static String choose2DrawAttack = "chooseAttackDrawQty";
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

    //region Exhaust

    public static String exhCard = "exhCardQty";
    public static String exhCardR = "exhCardRandomQty";
    public static String exhUpTo = "exhUpToQty";

    //endregion
}
