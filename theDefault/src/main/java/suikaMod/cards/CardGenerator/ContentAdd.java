package suikaMod.cards.CardGenerator;

import static suikaMod.cards.CardGenerator.ActionVar.*;


public class ContentAdd
{
    //region Action variables

    //region dmg
    static final String damage = "Damage";

    static final String modifyDmg ="ModifyDamageOnUse";
    static final String DPE = "DamagePerEnergyUsed";

    static final String vampireDmg = "VampireDamage";

    //endregion
    static final String block = "Block";
    static final String gainEnergy = "GainEnergy";
    static final String repeat = "Repeat";

    //region Apply
    static final String applyVulnerable = "ApplyVulnerable";

    static final String applyWeak = "ApplyWeak";

    static final String applyPoison = "ApplyPoison";

    static final String applyStr = "ApplyStrength";
    //endregion

    //region Gain
    static final String gainVulnerable = "GainVulnerable";
    static final String gainWeak = "GainWeak";
    static final String gainPoison = "GainPoison";
    static final String gainStr = "GainStrength";

    //endregion

    //region Add Card

    //region Add Copy
    static final String addCopy2Discard = "AddCopy(Discard)";
    static final String addCopy2Hand = "AddCopy(Hand)";

    static final String addCopy2DrawPile = "AddCopy(DrawPile)";
    static final String addCopy2TopDrawPile = "AddCopy(TopDrawPile)";
    static final String addCopy2BotDrawPile = "AddCopy(BotDrawPile)";

    static final String addRandomAttackHandCopy = "AddRandomAttackCopy(Hand)";
    static final String addRandomSkillHandCopy = "AddRandomSkillCopy(Hand)";
    static final String addRandomPowerHandCopy = "AddRandomPowerCopy(Hand)";
    static final String addRandomColorlessHandCopy = "AddRandomColorlessCopy(Hand)";

    static final String addRandomAttackDiscardCopy = "AddRandomAttackCopy(Discard)";
    static final String addRandomSkillDiscardCopy = "AddRandomSkillCopy(Discard)";
    static final String addRandomPowerDiscardCopy = "AddRandomPowerCopy(Discard)";
    static final String addRandomColorlessDiscardCopy = "AddRandomColorlessCopy(Discard)";

    static final String addRandomAttackDrawPileCopy = "AddRandomAttackCopy(DrawPile)";
    static final String addRandomSkillDrawPileCopy = "AddRandomSkillCopy(DrawPile)";
    static final String addRandomPowerDrawPileCopy = "AddRandomPowerCopy(DrawPile)";
    static final String addRandomColorlessDrawPileCopy = "AddRandomColorlessCopy(DrawPile)";

    static final String addRandomAttackTopDrawPileCopy = "AddRandomAttackCopy(TopDrawPile)";
    static final String addRandomSkillTopDrawPileCopy = "AddRandomSkillCopy(TopDrawPile)";
    static final String addRandomPowerTopDrawPileCopy = "AddRandomPowerCopy(TopDrawPile)";
    static final String addRandomColorlessTopDrawPileCopy = "AddRandomColorlessCopy(TopDrawPile)";

    static final String addRandomAttackBotDrawPileCopy = "AddRandomAttackCopy(BotDrawPile)";
    static final String addRandomSkillBotDrawPileCopy = "AddRandomSkillCopy(BotDrawPile)";
    static final String addRandomPowerBotDrawPileCopy = "AddRandomPowerCopy(BotDrawPile)";
    static final String addRandomColorlessBotDrawPileCopy = "AddRandomColorlessCopy(BotDrawPile)";
    //endregion

    //region Add Random
    static final String addRandomAttackHand = "AddRandomAttack(Hand)";
    static final String addRandomSkillHand = "AddRandomSkill(Hand)";
    static final String addRandomPowerHand = "AddRandomPower(Hand)";
    static final String addRandomColorlessHand = "AddRandomColorless(Hand)";

    static final String addRandomAttackDiscard = "AddRandomAttack(Discard)";
    static final String addRandomSkillDiscard = "AddRandomSkill(Discard)";
    static final String addRandomPowerDiscard = "AddRandomPower(Discard)";
    static final String addRandomColorlessDiscard = "AddRandomColorless(Discard)";

    static final String addRandomAttackDrawPile = "AddRandomAttack(DrawPile)";
    static final String addRandomSkillDrawPile = "AddRandomSkill(DrawPile)";
    static final String addRandomPowerDrawPile = "AddRandomPower(DrawPile)";
    static final String addRandomColorlessDrawPile = "AddRandomColorless(DrawPile)";

    static final String addRandomAttackTopDrawPile = "AddRandomAttack(TopDrawPile)";
    static final String addRandomSkillTopDrawPile = "AddRandomSkill(TopDrawPile)";
    static final String addRandomPowerTopDrawPile = "AddRandomPower(TopDrawPile)";
    static final String addRandomColorlessTopDrawPile = "AddRandomColorless(TopDrawPile)";

    static final String addRandomAttackBotDrawPile = "AddRandomAttack(BotDrawPile)";
    static final String addRandomSkillBotDrawPile = "AddRandomSkill(BotDrawPile)";
    static final String addRandomPowerBotDrawPile = "AddRandomPower(BotDrawPile)";
    static final String addRandomColorlessBotDrawPile = "AddRandomColorless(BotDrawPile)";


    //endregion

    //region choose2Draw
    static final String chooseToDraw = "ChooseToDraw";
    static final String chooseToDrawAttack = "ChooseToDraw(Attack)";
    static final String chooseToDrawSkill = "ChooseToDraw(Skill)";
    //endregion
    //region Draw
    static final String drawCard = "DrawCard";
    static final String drawUntilxCardOnHand = "DrawUntilxCardOnHand\n";
    static final String drawXtraNextTurn = "DrawExtraNextTurn";
    static final String drawXtraAtTurnStart = "DrawExtraAtTurnStart";
    static final String drawWhenDiscard = "DrawWhenDiscard";
    static final String drawPerExhaust = "DrawPerExhaust";
    static final String drawPerUniqueOrb = "DrawPerUniqueOrb";
    static final String drawOnPowerPlay = "DrawOnPowerPlay";

    //endregion


    //endregion

    //endregion

    //region Variable
    public static String AllVariable(String action, int value, int upgradeValue)
    {
        return Variable(action, value, upgradeValue);
    }

    public static String Variable(String matcher, int value, int upgradeValue)
    {
        String variable = "";
        switch (matcher)
        {
            //region Damage
            case damage:
                variable = "    private static final int " + dmg + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + dmg + "= " + upgradeValue + ";\n";
                break;
            case modifyDmg:
                variable = "    private int " + dmgModify + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + dmgModify + "= " + upgradeValue + ";\n";
                break;
            case DPE:
                variable = "    private static final int " + dmgPerEnergy + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + dmgPerEnergy + "= " + upgradeValue + ";\n";
                break;
            case vampireDmg:
                variable = "    private static final int " + vampDmg + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + vampDmg + "= " + upgradeValue + ";\n";
                break;

            //endregion
            case block:
                variable = "    private static final int " + blc + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + blc + " = " + upgradeValue + ";\n";
                break;
            case gainEnergy: //change this later to magic number
                variable = "    private static final int " + gEnergy + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + gEnergy + " = " + upgradeValue + ";\n";
                break;
            case repeat:
                variable = "    private int " + rpt + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rpt + " = " + upgradeValue + ";\n";
                break;

            //region Apply
            case applyVulnerable: //change this later to magic number
                variable = "    private static final int " + aVul + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + aVul + " = " + upgradeValue + ";\n";
                break;
            case applyWeak: //change this later to magic number
                variable = "    private static final int " + aWk + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + aWk + " = " + upgradeValue + ";\n";
                break;
            case applyPoison: //change this later to magic number
                variable = "    private static final int " + aPsn + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + aPsn + " = " + upgradeValue + ";\n";
                break;

            case applyStr:
                variable = "    private static final int " + aStr + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + aStr + " = " + upgradeValue + ";\n";
                break;
            //endregion

            //region Gain
            case gainVulnerable:
                variable = "    private static final int " + gVul + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + gVul + " = " + upgradeValue + ";\n";
                break;
            case gainWeak:
                variable = "    private static final int " + gWk + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + gWk + " = " + upgradeValue + ";\n";
                break;
            case gainPoison:
                variable = "    private static final int " + gPsn + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + gPsn + " = " + upgradeValue + ";\n";
                break;
            case gainStr:
                variable = "    private static final int " + gStr + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + gStr + " = " + upgradeValue + ";\n";
                break;
            //endregion

            //region Add Card

            //region Copy
            case addCopy2Discard:
                variable = "    private int " + copy2Disc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + copy2Disc + " = " + upgradeValue + ";\n";
                break;
            case addCopy2Hand:
                variable = "    private int " + copy2Hand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + copy2Hand + " = " + upgradeValue + ";\n";
                break;
            case addCopy2DrawPile:
                variable = "    private int " + copy2DrawP + " = " + value + ";\n" +
                        "    private final int " + copy2DrawP + " = " + upgradeValue + ";\n";
                break;
            case addCopy2TopDrawPile:
                variable = "    private int " + copy2TopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + copy2TopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addCopy2BotDrawPile:
                variable = "    private int " + copy2BotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + copy2BotDrawP + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackHandCopy:
                variable = "    private int " + rAttackHandCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackHandCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillHandCopy:
                variable = "    private int " + rSkillHandCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillHandCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerHandCopy:
                variable = "    private int " + rPowerHandCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerHandCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessHandCopy:
                variable = "    private int " + rColorlessHandCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessHandCopy + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackDiscardCopy:
                variable = "    private int " + rAttackDiscCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackDiscCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillDiscardCopy:
                variable = "    private int " + rSkillDiscCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillDiscCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerDiscardCopy:
                variable = "    private int " + rPowerDiscCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerDiscCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessDiscardCopy:
                variable = "    private int " + rColorlessDiscCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessDiscCopy + " = " + upgradeValue + ";\n";
                break;
            //------------------------------------------------------------------------
            case addRandomAttackDrawPileCopy:
                variable = "    private int " + rAttackDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillDrawPileCopy:
                variable = "    private int " + rSkillDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerDrawPileCopy:
                variable = "    private int " + rPowerDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessDrawPileCopy:
                variable = "    private int " + rColorlessDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessDrawPCopy + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackTopDrawPileCopy:
                variable = "    private int " + rAttackTopDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackTopDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillTopDrawPileCopy:
                variable = "    private int " + rSkillTopDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillTopDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerTopDrawPileCopy:
                variable = "    private int " + rPowerTopDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerTopDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessTopDrawPileCopy:
                variable = "    private int " + rColorlessTopDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessTopDrawPCopy + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackBotDrawPileCopy:
                variable = "    private int " + rAttackBotDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackBotDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillBotDrawPileCopy:
                variable = "    private int " + rSkillBotDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillBotDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerBotDrawPileCopy:
                variable = "    private int " + rPowerBotDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerBotDrawPCopy + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessBotDrawPileCopy:
                variable = "    private int " + rColorlessBotDrawPCopy + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessBotDrawPCopy + " = " + upgradeValue + ";\n";
                break;

            //endregion
            //-------------------------------------------------------------
            //region Add Random
            case addRandomAttackHand:
                variable = "    private int " + rAttackHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackHand + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillHand:
                variable = "    private int " + rSkillHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillHand + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerHand:
                variable = "    private int " + rPowerHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerHand + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessHand:
                variable = "    private int " + rColorlessHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessHand + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackDiscard:
                variable = "    private int " + rAttackDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackDisc + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillDiscard:
                variable = "    private int " + rSkillDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillDisc + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerDiscard:
                variable = "    private int " + rPowerDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_d" + rPowerDisc + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessDiscard:
                variable = "    private int " + rColorlessDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessDisc + " = " + upgradeValue + ";\n";
                break;
            //--------------------------------------------------
            case addRandomAttackDrawPile:
                variable = "    private int " + rAttackDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillDrawPile:
                variable = "    private int " + rSkillDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerDrawPile:
                variable = "    private int " + rPowerDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessDrawPile:
                variable = "    private int " + rColorlessDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessDrawP + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackTopDrawPile:
                variable = "    private int " + rAttackTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackTopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillTopDrawPile:
                variable = "    private int " + rSkillTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillTopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerTopDrawPile:
                variable = "    private int " + rPowerTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerTopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessTopDrawPile:
                variable = "    private int " + rColorlessTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessTopDrawP + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackBotDrawPile:
                variable = "    private int " + rAttackBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackBotDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillBotDrawPile:
                variable = "    private int " + rSkillBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillBotDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerBotDrawPile:
                variable = "    private int " + rPowerBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerBotDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessBotDrawPile:
                variable = "    private int " + rColorlessBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessBotDrawP + " = " + upgradeValue + ";\n";
                break;


            //---------------------------------------------------


            //endregion

            //region Choose2Draw
            case chooseToDraw:
                variable = "    private int " + choose2Draw + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + choose2Draw + " = " + upgradeValue + ";\n";
                break;
            case chooseToDrawAttack:
                variable = "    private int " + choose2DrawAttack + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + choose2DrawAttack + " = " + upgradeValue + ";\n";
                break;
            case chooseToDrawSkill:
                variable = "    private int " + choose2DrawSkill + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + choose2DrawSkill + " = " + upgradeValue + ";\n";
                break;
            //endregion

            //region Draw

            case drawCard:
                variable = "    private int " + draw + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + draw + " = " + upgradeValue + ";\n";
                break;
            case drawUntilxCardOnHand:
                variable = "    private int " + drawUntilxHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawUntilxHand + " = " + upgradeValue + ";\n";
                break;
            case drawXtraNextTurn:
                variable = "    private int " + drawXtrNxtTurn + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawXtrNxtTurn + " = " + upgradeValue + ";\n";
                break;
            case drawXtraAtTurnStart:
                variable = "    private int " + drawXtrAtStart + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawXtrAtStart + " = " + upgradeValue + ";\n";
                break;
            case drawWhenDiscard:
                variable = "    private int " + drawWhenDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawWhenDisc + " = " + upgradeValue + ";\n";
                break;
            case drawPerExhaust:
                variable = "    private int " + drawPerExh + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawPerExh + " = " + upgradeValue + ";\n";
                break;
            case drawPerUniqueOrb:
                variable = "    private int " + drawPerUOrb + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawPerUOrb + " = " + upgradeValue + ";\n";
                break;
            case drawOnPowerPlay:
                variable = "    private int " + drawOnPowPlay + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + drawOnPowPlay + " = " + upgradeValue + ";\n";
                break;
            //endregion
            //endregion
            default:
                variable = "";
        }
        return variable;
    }
    //endregion

    //region BaseValue
    public static String SetBase(String action)
    {
        return BaseValue(action);
    }

    public static String BaseValue(String matcher)
    {
        String base = "";
        switch (matcher)
        {
            //region Dmg
            case damage:
                base = "        baseDamage = " + dmg + ";\n";
                break;

            case DPE:
                base = "        baseDmgPerEnergy = " + dmgPerEnergy + ";\n";
                break;

            case vampireDmg:
                base = "        baseVampDmg = " + vampDmg + ";\n";
                break;

            //endregion
            case block:
                base = "        baseBlock = " + blc + ";\n";
                break;
            case gainEnergy:
                base = "        magicNumber = baseMagicNumber = " + gEnergy + ";\n";
                break;
            //region Apply
            case applyVulnerable:
                base = "        aVulnerableValue = aBaseVulnerableValue = " + aVul + ";\n";
                break;
            case applyWeak:
                base = "        aWeakValue = aBaseWeakValue= " + aWk + ";\n";
                break;
            case applyPoison:
                base = "        aPoisonValue = aBasePoisonValue= " + aPsn + ";\n";
                break;
            case applyStr:
                base = "        aStrValue = aBaseStrValue= " + aStr + ";\n";
                break;
            //endregion

            //region Gain
            case gainVulnerable:
                base = "        gVulnerableValue = gBaseVulnerableValue = " + gVul + ";\n";
                break;
            case gainWeak:
                base = "        gWeakValue = gBaseWeakValue= " + gWk + ";\n";
                break;
            case gainPoison:
                base = "        gPoisonValue = gBasePoisonValue= " + gPsn + ";\n";
                break;
            case gainStr:
                base = "        gStrValue = gBaseStrValue= " + gStr + ";\n";
                break;
            //endregion
            default:
                base = "";
        }
        return base;
    }
    //endregion

    //region Actions
    public static String AllActions(String action, String target)
    {
        return Actions(action, target);
    }

    public static String Actions(String matcher, String target)
    {
        String action = "";
        switch (matcher)
        {
            //region Dmg
            case damage:
                if (target.equals("All Enemy"))
                {
                    action = "         this.addToBot(\n" +
                            "                new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AttackEffect.SLASH_HORIZONTAL));\n";
                    break;
                }
                action = "         this.addToBot(\n" +
                        "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));\n";
                break;

            case modifyDmg:
                action = "         this.addToBot(new ModifyDmgAction(this.uuid,"+dmgModify+"));\n";
                break;

            case DPE:
                if (target.equals("All Enemy"))
                {
                    action = "         this.addToBot(\n" +
                            "                new WhirlwindAction(p, this.multiDPE, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));\n";
                    break;
                }
                action = "         this.addToBot(\n" +
                        "                new SkewerAction(p, m, dmgPerEnergy, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));\n";
                break;
            case vampireDmg:
                if (target.equals("All Enemy"))
                {
                    action = "         this.addToBot(\n" +
                            "                new VampireDamageAllEnemiesAction(p, this.multiVampDmg, this.damageTypeForTurn, AttackEffect.NONE));\n";
                    break;
                }
                action = "         this.addToBot(\n" +
                        "                new VampireDamageAction(m, new DamageInfo(p, vampDmg, damageTypeForTurn), AttackEffect.NONE));\n";
                break;

            //endregion
            case block:
                action = "         this.addToBot(new GainBlockAction(p, p, block));\n";
                break;
            case gainEnergy:
                action = "         this.addToBot(new GainEnergyAction(magicNumber));\n";
                break;
            //region apply
            case applyVulnerable:

                if (target.equals("All Enemy"))
                {
                    action = TargetAllEnemy(
                            "this.addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, this.aVulnerableValue, false), this.aVulnerableValue));");

                    action = MultiDebuff(target) + action;
                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.aVulnerableValue, false), this.aVulnerableValue));\n";
                break;
            case applyWeak:
                if (target.equals("All Enemy"))
                {
                    action = TargetAllEnemy(
                            "this.addToBot(new ApplyPowerAction(mo, p, new WeakPower(mo, this.aWeakValue, false), this.aWeakValue));");

                    action = MultiDebuff(target) + action;
                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.aWeakValue, false), this.aWeakValue));\n";

                break;
            case applyPoison:
                if (target.equals("All Enemy"))
                {
                    action = TargetAllEnemy(
                            "this.addToBot(new ApplyPowerAction(mo, p, new PoisonPower(mo, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));");

                    action = MultiDebuff(target) + action;
                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));\n";

                break;
            case applyStr:
                if (target.equals("All Enemy"))
                {
                    action = targetAllEnemy +
                            "            this.addToBot(new ApplyPowerAction(mo, p, new StrengthPower(mo, this.aStrValue), this.aStrValue));\n" +
                            "        }\n";
                    action = MultiDebuff(target) + action;
                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, this.aStrValue), this.aStrValue));\n";

                break;
            //endregion

            //region gains
            case gainVulnerable:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, this.gVulnerableValue, false), this.gVulnerableValue));\n";
                break;
            case gainWeak:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new WeakPower(p, this.gWeakValue, false), this.gWeakValue));\n";
                break;
            case gainPoison:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new PoisonPower(p, p, this.gPoisonValue), this.gPoisonValue, AttackEffect.POISON));\n";
                break;
            case gainStr:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.gStrValue), this.gStrValue));\n";
                break;
            //endregion

            //region Add Card

            //region Add Copy
            case addCopy2Discard:
                action = "         this.addToBot(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), " + copy2Disc + "));\n";
                break;
            case addCopy2Hand:
                action = "         this.addToBot(new MakeTempCardInHandAction(this.makeStatEquivalentCopy()," + copy2Hand + "));\n";
                break;
            case addCopy2DrawPile:
                action = "         this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy()," + copy2DrawP + " ,true,true));\n";
                break;
            case addCopy2TopDrawPile:
                action = "         this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), " + copy2TopDrawP + ",false,false,false));\n";
                break;
            case addCopy2BotDrawPile:
                action = "         this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), " + copy2BotDrawP + ",false,false,true));\n";
                break;

            case addRandomAttackHandCopy:
                action = "         AddRandomCardHandCopy(" + rAttackHandCopy + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillHandCopy:
                action = "         AddRandomCardHandCopy(" + rSkillHandCopy + ",CardType.SKILL);\n";
                break;
            case addRandomPowerHandCopy:
                action = "         AddRandomCardHandCopy(" + rPowerHandCopy + ",CardType.POWER);\n";
                break;
            case addRandomColorlessHandCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessHandCopy + ",\"Hand\");\n";
                break;

            case addRandomAttackDiscardCopy:
                action = "         AddRandomCardDiscardCopy(" + rAttackDiscCopy + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillDiscardCopy:
                action = "         AddRandomCardDiscardCopy(" + rSkillDiscCopy + ",CardType.SKILL);\n";
                break;
            case addRandomPowerDiscardCopy:
                action = "         AddRandomCardDiscardCopy(" + rPowerDiscCopy + ",CardType.POWER);\n";
                break;
            case addRandomColorlessDiscardCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessDiscCopy + ",\"Discard\");\n";
                break;

            case addRandomAttackDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rAttackDrawPCopy + ",CardType.ATTACK,\"Random\");\n";
                break;
            case addRandomSkillDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rSkillDrawPCopy + ",CardType.SKILL,\"Random\");\n";
                break;
            case addRandomPowerDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rPowerDrawPCopy + ",CardType.POWER,\"Random\");\n";
                break;
            case addRandomColorlessDrawPileCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessDrawPCopy + ",\"DrawPile\");\n";
                break;

            case addRandomAttackTopDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rAttackTopDrawPCopy + ",CardType.ATTACK,\"Top\");\n";
                break;
            case addRandomSkillTopDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rSkillTopDrawPCopy + ",CardType.SKILL,\"Top\");\n";
                break;
            case addRandomPowerTopDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rPowerTopDrawPCopy + ",CardType.POWER,\"Top\");\n";
                break;
            case addRandomColorlessTopDrawPileCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessTopDrawPCopy + ",\"TopDrawPile\");\n";
                break;

            case addRandomAttackBotDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rAttackBotDrawPCopy + ",CardType.ATTACK,\"Bot\");\n";
                break;
            case addRandomSkillBotDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rSkillBotDrawPCopy + ",CardType.SKILL,\"Bot\");\n";
                break;
            case addRandomPowerBotDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rPowerBotDrawPCopy + ",CardType.POWER,\"Bot\");\n";
                break;
            case addRandomColorlessBotDrawPileCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessBotDrawPCopy + ",\"BotDrawPile\");\n";
                break;
            //endregion

            //region Add Random
            case addRandomAttackHand:
                action = "         AddRandomCardHand(" + rAttackHand + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillHand:
                action = "         AddRandomCardHand(" + rSkillHand + ",CardType.SKILL);\n";
                break;
            case addRandomPowerHand:
                action = "         AddRandomCardHand(" + rPowerHand + ",CardType.POWER);\n";
                break;
            case addRandomColorlessHand:
                action = "         AddRandomColorless(" + rColorlessHand + ",\"Hand\");\n";
                break;

            case addRandomAttackDiscard:
                action = "         AddRandomCardDiscard(" + rAttackDisc + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillDiscard:
                action = "         AddRandomCardDiscard(" + rSkillDisc + ",CardType.SKILL);\n";
                break;
            case addRandomPowerDiscard:
                action = "         AddRandomCardDiscard(" + rPowerDisc + ",CardType.POWER);\n";
                break;
            case addRandomColorlessDiscard:
                action = "         AddRandomColorless(" + rColorlessDisc + ",\"Discard\");\n";
                break;

            //-----------------------------------
            case addRandomAttackDrawPile:
                action = "         AddRandomCardDrawP(" + rAttackDrawP + ",CardType.ATTACK,\"Random\");\n";
                break;
            case addRandomSkillDrawPile:
                action = "         AddRandomCardDrawP(" + rSkillDrawP + ",CardType.SKILL,\"Random\");\n";
                break;
            case addRandomPowerDrawPile:
                action = "         AddRandomCardDrawP(" + rPowerDrawP + ",CardType.POWER,\"Random\");\n";
                break;
            case addRandomColorlessDrawPile:
                action = "         AddRandomColorless(" + rColorlessDrawP + ",\"DrawPile\");\n";
                break;

            case addRandomAttackTopDrawPile:
                action = "         AddRandomCardDrawP(" + rAttackTopDrawP + ",CardType.ATTACK,\"Top\");\n";
                break;
            case addRandomSkillTopDrawPile:
                action = "         AddRandomCardDrawP(" + rSkillTopDrawP + ",CardType.SKILL,\"Top\");\n";
                break;
            case addRandomPowerTopDrawPile:
                action = "         AddRandomCardDrawP(" + rPowerTopDrawP + ",CardType.POWER,\"Top\");\n";
                break;
            case addRandomColorlessTopDrawPile:
                action = "         AddRandomColorless(" + rColorlessTopDrawP + ",\"TopDrawPile\");\n";
                break;

            case addRandomAttackBotDrawPile:
                action = "         AddRandomCardDrawP(" + rAttackBotDrawP + ",CardType.ATTACK,\"Bot\");\n";
                break;
            case addRandomSkillBotDrawPile:
                action = "         AddRandomCardDrawP(" + rSkillBotDrawP + ",CardType.SKILL,\"Bot\");\n";
                break;
            case addRandomPowerBotDrawPile:
                action = "         AddRandomCardDrawP(" + rPowerBotDrawP + ",CardType.POWER,\"Bot\");\n";
                break;
            case addRandomColorlessBotDrawPile:
                action = "         AddRandomColorless(" + rColorlessBotDrawP + ",\"BotDrawPile\");\n";
                break;
            //-----------------------------------
            //endregion

            //region choose2Draw
            case chooseToDraw:
                action = "         this.addToBot(new BetterDrawPileToHandAction(" + choose2Draw + "));\n";
                break;
            case chooseToDrawAttack:
                action = "         this.addToBot(new AttackFromDeckToHandAction(" + choose2DrawAttack + "));\n";
                break;
            case chooseToDrawSkill:
                action = "         this.addToBot(new SkillFromDeckToHandAction(" + choose2DrawSkill + "));\n";
                break;
            //endregion

            //region Draw
            case drawCard:
                action = "         this.addToBot(new DrawCardAction(p, " + draw + "));\n";
                break;
            case drawUntilxCardOnHand:
                action = "         this.addToBot(new ExpertiseAction(p, " + drawUntilxHand + "));\n";
                break;
            case drawXtraNextTurn:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, " + drawXtrNxtTurn + "), " + drawXtrNxtTurn + "));\n";
                break;
            case drawXtraAtTurnStart:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new DrawPower(p, " + drawXtrAtStart + "), " + drawXtrAtStart + "));\n";
                break;
/*            case drawWhenDiscard:
                action = "         this.addToBot(new DrawCardAction(AbstractDungeon.player, "+drawWhenDisc+"));\n";
                break;*/
            case drawPerExhaust:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new DarkEmbracePower(p, " + drawPerExh + "), " + drawPerExh + "));\n";
                break;
            case drawPerUniqueOrb:
                action = "         this.addToBot(new CompileDriverAction(p, " + drawPerUOrb + "));\n";
                break;
            case drawOnPowerPlay:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new HeatsinkPower(p, " + drawOnPowPlay + "), " + drawOnPowPlay + "));\n";
                break;
            //endregion
            //endregion

            default:
                action = "";
        }
        return action;
    }

    //endregion

    //region Actions On Discard
    public static String AllActionsWhenDiscard(String action)
    {
        return ActionsWhenDiscard(action);
    }

    public static String ActionsWhenDiscard(String matcher)
    {
        String discMethod = "public void triggerOnManualDiscard() {\n";
        String actionWhenDisc = "";

        switch (matcher)
        {
            case drawWhenDiscard:
                actionWhenDisc = "         this.addToBot(new DrawCardAction(AbstractDungeon.player, " + drawWhenDisc + "));\n";
                break;
            default:
                break;
        }

        if (!actionWhenDisc.isEmpty())
        {
            if (!actionWhenDisc.contains(discMethod))
            {
                actionWhenDisc = discMethod + actionWhenDisc;
            }
        }
        return actionWhenDisc;
    }
    //endregion

    //region Upgrade
    public static String AddUpgrade(String action)
    {
        return Upgrade(action);
    }

    public static String Upgrade(String matcher)
    {
        String Upgrade = "";
        switch (matcher)
        {
            //region dmg
            case damage:
                Upgrade = "            upgradeDamage(UPGRADE_" + dmg + ");\n";
                break;

            case modifyDmg:
                Upgrade = "            " + dmgModify + "=UPGRADE_" + dmgModify + ";\n";
                break;

            case DPE:
                Upgrade = "            upgradeDPE(UPGRADE_" + dmgPerEnergy + ");\n";
                break;
            case vampireDmg:
                Upgrade = "            upgradeVampDmg(UPGRADE_" + vampDmg + ");\n";
                break;

            //endregion
            case block:
                Upgrade = "            upgradeBlock(UPGRADE_" + blc + ");\n";
                break;
            case gainEnergy:
                Upgrade = "            this.upgradeMagicNumber(UPGRADE_" + gEnergy + ");\n";

                //region Apply
                break;
            case repeat:
                Upgrade = "            " + rpt + " = UPGRADE_" + rpt + ";\n";
                break;
            case applyVulnerable:
                Upgrade = "            this.upgradeAVulnerableValue(UPGRADE_" + aVul + ");\n";
                break;
            case applyWeak:
                Upgrade = "            this.upgradeAWeakValue(UPGRADE_" + aWk + ");\n";
                break;
            case applyPoison:
                Upgrade = "            this.upgradeAPoisonValue(UPGRADE_" + aPsn + ");\n";
                break;
            case applyStr:
                Upgrade = "            this.upgradeAStrValue(UPGRADE_" + aStr + ");\n";
                break;
            //endregion

            //region Gain
            case gainVulnerable:
                Upgrade = "            this.upgradeGVulnerableValue(UPGRADE_" + gVul + ");\n";
                break;
            case gainWeak:
                Upgrade = "            this.upgradeGWeakValue(UPGRADE_" + gWk + ");\n";
                break;
            case gainPoison:
                Upgrade = "            this.upgradeGPoisonValue(UPGRADE_" + gPsn + ");\n";
                break;
            case gainStr:
                Upgrade = "            this.upgradeGStrValue(UPGRADE_" + gStr + ");\n";
                break;
            //endregion

            //region Add cards

            //region Add Copy
            case addCopy2Discard:
                Upgrade = "            " + copy2Disc + "=UPGRADE_" + copy2Disc + ";\n";
                break;
            case addCopy2Hand:
                Upgrade = "            " + copy2Hand + "=UPGRADE_" + copy2Hand + ";\n";
                break;
            case addCopy2TopDrawPile:
                Upgrade = "            " + copy2TopDrawP + "=UPGRADE_" + copy2TopDrawP + ";\n";
                break;
            case addCopy2BotDrawPile:
                Upgrade = "            " + copy2BotDrawP + "=UPGRADE_" + copy2BotDrawP + ";\n";
                break;

            case addRandomAttackHandCopy:
                Upgrade = "            " + rAttackHandCopy + "=UPGRADE_" + rAttackHandCopy + ";\n";
                break;
            case addRandomSkillHandCopy:
                Upgrade = "            " + rSkillHandCopy + "=UPGRADE_" + rSkillHandCopy + ";\n";
                break;
            case addRandomPowerHandCopy:
                Upgrade = "            " + rPowerHandCopy + "=UPGRADE_" + rPowerHandCopy + ";\n";
                break;
            case addRandomColorlessHandCopy:
                Upgrade = "            " + rColorlessHandCopy + "=UPGRADE_" + rColorlessHandCopy + ";\n";
                break;

            case addRandomAttackDiscardCopy:
                Upgrade = "            " + rAttackDiscCopy + "=UPGRADE_" + rAttackDiscCopy + ";\n";
                break;
            case addRandomSkillDiscardCopy:
                Upgrade = "            " + rSkillDiscCopy + "=UPGRADE_" + rSkillDiscCopy + ";\n";
                break;
            case addRandomPowerDiscardCopy:
                Upgrade = "            " + rPowerDiscCopy + "=UPGRADE_" + rPowerDiscCopy + ";\n";
                break;
            case addRandomColorlessDiscardCopy:
                Upgrade = "            " + rColorlessDiscCopy + "=UPGRADE_" + rColorlessDiscCopy + ";\n";
                break;

            case addRandomAttackDrawPileCopy:
                Upgrade = "            " + rAttackDrawPCopy + "=UPGRADE_" + rAttackDrawPCopy + ";\n";
                break;
            case addRandomSkillDrawPileCopy:
                Upgrade = "            " + rSkillDrawPCopy + "=UPGRADE_" + rSkillDrawPCopy + ";\n";
                break;
            case addRandomPowerDrawPileCopy:
                Upgrade = "            " + rPowerDrawPCopy + "=UPGRADE_" + rPowerDrawPCopy + ";\n";
                break;
            case addRandomColorlessDrawPileCopy:
                Upgrade = "            " + rColorlessDrawPCopy + "=UPGRADE_" + rColorlessDrawPCopy + ";\n";
                break;

            case addRandomAttackTopDrawPileCopy:
                Upgrade = "            " + rAttackTopDrawPCopy + "=UPGRADE_" + rAttackTopDrawPCopy + ";\n";
                break;
            case addRandomSkillTopDrawPileCopy:
                Upgrade = "            " + rSkillTopDrawPCopy + "=UPGRADE_" + rSkillTopDrawPCopy + ";\n";
                break;
            case addRandomPowerTopDrawPileCopy:
                Upgrade = "            " + rPowerTopDrawPCopy + "=UPGRADE_" + rPowerTopDrawPCopy + ";\n";
                break;
            case addRandomColorlessTopDrawPileCopy:
                Upgrade = "            " + rColorlessTopDrawPCopy + "=UPGRADE_" + rColorlessTopDrawPCopy + ";\n";
                break;

            case addRandomAttackBotDrawPileCopy:
                Upgrade = "            " + rAttackBotDrawPCopy + "=UPGRADE_" + rAttackBotDrawPCopy + ";\n";
                break;
            case addRandomSkillBotDrawPileCopy:
                Upgrade = "            " + rSkillBotDrawPCopy + "=UPGRADE_" + rSkillBotDrawPCopy + ";\n";
                break;
            case addRandomPowerBotDrawPileCopy:
                Upgrade = "            " + rPowerBotDrawPCopy + "=UPGRADE_" + rPowerBotDrawPCopy + ";\n";
                break;
            case addRandomColorlessBotDrawPileCopy:
                Upgrade = "            " + rColorlessBotDrawPCopy + "=UPGRADE_" + rColorlessBotDrawPCopy + ";\n";
                break;
            //endregion
            //region Add Random
            case addRandomAttackHand:
                Upgrade = "            " + rAttackHand + "=UPGRADE_" + rAttackHand + ";\n";
                break;
            case addRandomSkillHand:
                Upgrade = "            " + rSkillHand + "=UPGRADE_" + rSkillHand + ";\n";
                break;
            case addRandomPowerHand:
                Upgrade = "            " + rPowerHand + "=UPGRADE_" + rPowerHand + ";\n";
                break;
            case addRandomColorlessHand:
                Upgrade = "            " + rColorlessHand + "=UPGRADE_" + rColorlessHand + ";\n";
                break;

            case addRandomAttackDiscard:
                Upgrade = "            " + rAttackDisc + "=UPGRADE_" + rAttackDisc + ";\n";
                break;
            case addRandomSkillDiscard:
                Upgrade = "            " + rSkillDisc + "=UPGRADE_" + rSkillDisc + ";\n";
                break;
            case addRandomPowerDiscard:
                Upgrade = "            " + rPowerDisc + "=UPGRADE_d" + rPowerDisc + ";\n";
                break;
            case addRandomColorlessDiscard:
                Upgrade = "            " + rColorlessDisc + "=UPGRADE_" + rColorlessDisc + ";\n";
                break;

            //------------------------------
            case addRandomAttackDrawPile:
                Upgrade = "            " + rAttackDrawP + "=UPGRADE_" + rAttackDrawP + ";\n";
                break;
            case addRandomSkillDrawPile:
                Upgrade = "            " + rSkillDrawP + "=UPGRADE_" + rSkillDrawP + ";\n";
                break;
            case addRandomPowerDrawPile:
                Upgrade = "            " + rPowerDrawP + "=UPGRADE_" + rPowerDrawP + ";\n";
                break;
            case addRandomColorlessDrawPile:
                Upgrade = "            " + rColorlessDrawP + "=UPGRADE_" + rColorlessDrawP + ";\n";
                break;

            case addRandomAttackTopDrawPile:
                Upgrade = "            " + rAttackTopDrawP + "=UPGRADE_" + rAttackTopDrawP + ";\n";
                break;
            case addRandomSkillTopDrawPile:
                Upgrade = "            " + rSkillTopDrawP + "=UPGRADE_" + rSkillTopDrawP + ";\n";
                break;
            case addRandomPowerTopDrawPile:
                Upgrade = "            " + rPowerTopDrawP + "=UPGRADE_" + rPowerTopDrawP + ";\n";
                break;
            case addRandomColorlessTopDrawPile:
                Upgrade = "            " + rColorlessTopDrawP + "=UPGRADE_" + rColorlessTopDrawP + ";\n";
                break;

            case addRandomAttackBotDrawPile:
                Upgrade = "            " + rAttackBotDrawP + "=UPGRADE_" + rAttackBotDrawP + ";\n";
                break;
            case addRandomSkillBotDrawPile:
                Upgrade = "            " + rSkillBotDrawP + "=UPGRADE_" + rSkillBotDrawP + ";\n";
                break;
            case addRandomPowerBotDrawPile:
                Upgrade = "            " + rPowerBotDrawP + "=UPGRADE_" + rPowerBotDrawP + ";\n";
                break;
            case addRandomColorlessBotDrawPile:
                Upgrade = "            " + rColorlessBotDrawP + "=UPGRADE_" + rColorlessBotDrawP + ";\n";
                break;
            //------------------------------
            //endregion
            //region choose2Draw
            case chooseToDraw:
                Upgrade = "            " + choose2Draw + "=UPGRADE_" + choose2Draw + ";\n";
                break;
            case chooseToDrawAttack:
                Upgrade = "            " + choose2DrawAttack + "=UPGRADE_" + choose2DrawAttack + ";\n";
                break;
            case chooseToDrawSkill:
                Upgrade = "            " + choose2DrawSkill + "=UPGRADE_" + choose2DrawSkill + ";\n";
                break;
            //endregion
            //region Draw
            case drawCard:
                Upgrade = "            " + draw + "=UPGRADE_" + draw + ";\n";
                break;
            case drawUntilxCardOnHand:
                Upgrade = "            " + drawUntilxHand + "=UPGRADE_" + drawUntilxHand + ";\n";
                break;
            case drawXtraNextTurn:
                Upgrade = "            " + drawXtrNxtTurn + "=UPGRADE_" + drawXtrNxtTurn + ";\n";
                break;
            case drawXtraAtTurnStart:
                Upgrade = "            " + drawXtrAtStart + "=UPGRADE_" + drawXtrAtStart + ";\n";
                break;
            case drawWhenDiscard:
                Upgrade = "            " + drawWhenDisc + "=UPGRADE_" + drawWhenDisc + ";\n";
                break;
            case drawPerExhaust:
                Upgrade = "            " + drawPerExh + "=UPGRADE_" + drawPerExh + ";\n";
                break;
            case drawPerUniqueOrb:
                Upgrade = "            " + drawPerUOrb + "=UPGRADE_" + drawPerUOrb + ";\n";
                break;
            case drawOnPowerPlay:
                Upgrade = "            " + drawOnPowPlay + "=UPGRADE_" + drawOnPowPlay + ";\n";
                break;
            //endregion
            //endregion
            default:
                Upgrade = "";
        }
        return Upgrade;
    }
    //endregion

    //region multi target
    static String var = "";
    static String targetAllEnemy = "        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();\n" +
            "        while(var3.hasNext()) {\n" +
            "            mo = (AbstractMonster)var3.next();\n";

    public static String MultiDebuff(String target)
    {
        if (!target.equals("All Enemy") || !var.isEmpty())
            return "";

        if (var.isEmpty())
        {
            var = "        AbstractMonster mo;\n" +
                    "        Iterator var3;\n";
        }
        return var;
    }

    public static String TargetAllEnemy(String action)
    {
        String var = targetAllEnemy +
                "            " + action + "\n" +
                "        }\n";
        return var;
    }
    //endregion


    //region trash

    //endregion

}
