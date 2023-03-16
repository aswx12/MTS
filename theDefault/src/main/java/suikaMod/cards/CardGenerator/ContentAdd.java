package suikaMod.cards.CardGenerator;

import static suikaMod.cards.CardGenerator.ActionVar.*;
import static suikaMod.cards.CardGenerator.ActionVar.actionVar;

public class ContentAdd
{
    //region Action variables

    //region dmg
    static final String damage = "Damage";

    static final String modifyDmg = "ModifyDamageOnUse";
    static final String DPE = "DamagePerEnergyUsed";

    static final String vampireDmg = "VampireDamage";
    static final String damageIfTargetPoison = "DamageIfTargetPoisoned";
    static final String DPAP = "DamagePerAttackPlayed";
    static final String DPSH = "DamagePerSkillInHand";
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
    static final String gainDex = "GainDexterity";
    static final String gainIntangible = "GainIntangible";

    //endregion
    //region Health related

    static final String sacrificeHP = "SacrificeHP";
    static final String heal = "Heal";


    //endregion

    //region Add Card

    //region Add Copy
    static final String addCopy = "AddCopy";
    static final String addRandomAttackCopy = "AddRandomAttackCopy";
    static final String addRandomSkillCopy = "AddRandomSkillCopy";
    static final String addRandomPowerCopy = "AddRandomPowerCopy";
    static final String addRandomColorlessCopy = "AddRandomColorlessCopy";

    static final String addRandomAttack = "AddRandomAttack";
    static final String addRandomSkill = "AddRandomSkill";
    static final String addRandomPower = "AddRandomPower";
    static final String addRandomColorless = "AddRandomColorless";

    static final String addCopy2Hand = "Hand";
    static final String addCopy2Discard = "Discard";
    static final String addCopy2DrawPile = "DrawPile";
    static final String addCopy2TopDrawPile = "TopDrawPile";
    static final String addCopy2BotDrawPile = "BotDrawPile";

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
    static String cpyString="copy";
    static String notCpy="uniq";
    //region Variable
    public static String AllVariable(String action, int value, int upgradeValue, String where)
    {
        return Variable(action, value, upgradeValue, where);
    }

    public static String AllVariableUpgrade(String action, int SingleValue)
    {
        return Variable(action, SingleValue, 0, "");
    }

    public static String varInit(int value, int upgradeValue)
    {
        return "    private int " + actionVar + " = " + value + ";\n" +
                "    private final int UPGRADE_" + actionVar + " = " + upgradeValue + ";\n";
    }
    public static String SetVersion(String where,int V,String actionVarV,int value,int upgradeValue){
        actionVar = actionVarV;
        switch (where)
        {
            case addCopy2Hand:
                actionVar += V + toHand;
                break;
            case addCopy2Discard:
                actionVar += V + toDisc;
                break;
            case addCopy2DrawPile:
                actionVar += V + toDrawP;
                break;
            case addCopy2TopDrawPile:
                actionVar += V + toTopDrawP;
                break;
            case addCopy2BotDrawPile:
                actionVar += V + toBotDrawP;
                break;
            default:
                break;
        }
        return varInit(value, upgradeValue);
    }

    public static String Variable(String matcher, int value, int upgradeValue, String targetLocation)
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
            case damageIfTargetPoison:
                variable = "    private static final int " + dmgIfTargetPsn + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + dmgIfTargetPsn + "= " + upgradeValue + ";\n";
                break;
            case DPAP:
                variable = "    private static final int " + dmgPerAttPlayed + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + dmgPerAttPlayed + "= " + upgradeValue + ";\n";
                break;
            case DPSH:
                variable = "    private static final int " + dmgPerSkillInHand + " = " + value + ";\n" +
                        "    private static final int UPGRADE_" + dmgPerSkillInHand + "= " + upgradeValue + ";\n";
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
            case applyVulnerable:

                /* aVul= aVulOrg + aVulVersion++;*/
                variable = "    private  int " + aVul + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + aVul + " = " + upgradeValue + ";\n";
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
            case gainDex:
                variable = "    private int " + gDex + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + gDex + " = " + upgradeValue + ";\n";
                break;
            case gainIntangible:
                variable = "    private int " + gIntang + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + gIntang + " = " + upgradeValue + ";\n";
                break;
            //endregion

            //region Health related

            case sacrificeHP:
                variable = "    private int " + loseHP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + loseHP + " = " + upgradeValue + ";\n";
                break;
            case heal:
                variable = "    private int " + healing + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + healing + " = " + upgradeValue + ";\n";
                break;

            //endregion

            //region Add Card

            //region Copy
            case addCopy:
                variable = SetVersion(targetLocation,addCpyV++,addCpy,value,upgradeValue);
                break;
            case addRandomAttackCopy:
                variable = SetVersion(targetLocation,randomAttCpyV++, RandomAttCpy,value,upgradeValue);
                break;
            case addRandomSkillCopy:
                variable = SetVersion(targetLocation,randomSkillCpyV++, RandomSkillCpy,value,upgradeValue);
                break;
            case addRandomPowerCopy:
                variable = SetVersion(targetLocation,randomPowerCpyV++, RandomPowerCpy,value,upgradeValue);
                break;
            case addRandomColorlessCopy:
                variable = SetVersion(targetLocation,randomColorlessCpyV++, RandomColorlessCpy,value,upgradeValue);
                break;
            //endregion
            //-------------------------------------------------------------
            //region Add Random
            case addRandomAttack:
                variable = SetVersion(targetLocation,randomAttV++, RandomAtt,value,upgradeValue);
                break;
            case addRandomSkill:
                variable = SetVersion(targetLocation,randomSkillV++,RandomSkill,value,upgradeValue);
                break;
            case addRandomPower:
                variable = SetVersion(targetLocation,randomPowerV++,RandomPower,value,upgradeValue);
                break;
            case addRandomColorless:
                variable = SetVersion(targetLocation,randomColorlessV++,RandomColorless,value,upgradeValue);
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
            case damageIfTargetPoison:
                base = "        baseDmgPsnCondition = " + dmgIfTargetPsn + ";\n";
                break;
            case DPAP:
                base = "        baseDPAP = " + dmgPerAttPlayed + ";\n";
                break;
            case DPSH:
                base = "        baseDPSH = " + dmgPerSkillInHand + ";\n";
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
            /*case gainVulnerable:
                base = "        gVulnerableValue = gBaseVulnerableValue = " + gVul + ";\n";
                break;*/
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

            //region Health

            case heal:
                base = "        this.tags.add(CardTags.HEALING);\n";
                break;

            //endregion

            default:
                base = "";
        }
        return base;
    }
    //endregion

    //region Actions
    public static String AllActions(String action, String target, String where)
    {
        return Actions(action, target, where);
    }
    public static String randomAdd(String method, String where, String cardType){
        String action="";
        String methodHand="";
        String methodDisc="";
        String methodDraw="";


        if(method.equals(cpyString)){
            methodHand="AddRandomCardHandCopy";
            methodDisc ="AddRandomCardDiscardCopy";
            methodDraw="AddRandomCardDrawPCopy";
        }
        else {
            methodHand="AddRandomCardHand";
            methodDisc ="AddRandomCardDiscard";
            methodDraw="AddRandomCardDrawP";
        }

        switch (where)
        {
            case addCopy2Hand:
                action = "         "+methodHand+"(" + actionVar + ",CardType."+cardType+");\n";
                break;
            case addCopy2Discard:
                action = "         "+methodDisc+"(" + actionVar + ",CardType."+cardType+");\n";
                break;
            case addCopy2DrawPile:
                action = "         "+methodDraw+"(" + actionVar + ",CardType."+cardType+",\"Random\");\n";
                break;
            case addCopy2TopDrawPile:
                action = "         "+methodDraw+"(" + actionVar + ",CardType."+cardType+",\"Top\");\n";
                break;
            case addCopy2BotDrawPile:
                action = "         "+methodDraw+"(" + actionVar + ",CardType."+cardType+",\"Bot\");\n";
                break;
            default:
                break;
        }
        return action;
    }

    public static String randomColorless(String method,String where){
        String action="";
        String methodString="";
        if(method.equals(cpyString)){
            methodString="AddRandomColorlessCopy";
        }
        else
            methodString="AddRandomColorless";
        switch (where)
        {
            case addCopy2Hand:
                action = "         "+methodString+"(" + actionVar + ",\"Hand\");\n";
                break;
            case addCopy2Discard:
                action = "         "+methodString+"(" + actionVar + ",\"Discard\");\n";
                break;
            case addCopy2DrawPile:
                action = "         "+methodString+"(" + actionVar + ",\"DrawPile\");\n";
                break;
            case addCopy2TopDrawPile:
                action = "         "+methodString+"(" + actionVar + ",\"TopDrawPile\");\n";
                break;
            case addCopy2BotDrawPile:
                action = "         "+methodString+"(" + actionVar + ",\"BotDrawPile\");\n";
                break;
            default:
                break;
        }
        return action;
    }
    public static String Actions(String matcher, String target, String targetLocation)
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
                action = "        this.addToBot(\n" +
                        "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));\n";
                break;

            case modifyDmg:
                action = "        this.addToBot(new ModifyDmgAction(this.uuid," + dmgModify + "));\n";
                break;

            case DPE:
                if (target.equals("All Enemy"))
                {
                    action = "        this.addToBot(\n" +
                            "                new WhirlwindAction(p, this.multiDPE, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));\n";
                    break;
                }
                action = "        this.addToBot(\n" +
                        "                new SkewerAction(p, m, dmgPerEnergy, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));\n";
                break;
            case vampireDmg:
                if (target.equals("All Enemy"))
                {
                    action = "        this.addToBot(\n" +
                            "                new VampireDamageAllEnemiesAction(p, this.multiVampDmg, this.damageTypeForTurn, AttackEffect.NONE));\n";
                    break;
                }
                action = "        this.addToBot(\n" +
                        "                new VampireDamageAction(m, new DamageInfo(p, vampDmg, damageTypeForTurn), AttackEffect.NONE));\n";
                break;
            case damageIfTargetPoison:
                if (target.equals("All Enemy"))
                {
                    action = TargetAllEnemy(
                            "this.addToBot(new BaneAction(mo, new DamageInfo(p, this.dmgPsnCondition, this.damageTypeForTurn)));");

                    action = MultiTarget(target) + action;
                    break;
                }
                action = "         this.addToBot(new BaneAction(m, new DamageInfo(p, this.dmgPsnCondition, this.damageTypeForTurn)));\n";
                break;
            case DPAP:
                if (target.equals("All Enemy"))
                {
                    action = TargetAllEnemy(
                            "this.addToBot(\n" +
                                    "                new DamagePerAttackPlayedAction(mo, new DamageInfo(p, this.dmgPerAttPlayed, this.damageTypeForTurn), AttackEffect.SLASH_DIAGONAL));");

                    action = MultiTarget(target) + action;
                    break;
                }
                action = "         this.addToBot(\n" +
                        "                new DamagePerAttackPlayedAction(m, new DamageInfo(p, this.dmgPerAttPlayed, this.damageTypeForTurn), AttackEffect.SLASH_DIAGONAL));\n";
                break;
            case DPSH:
                if (target.equals("All Enemy"))
                {
                    action = TargetAllEnemy(
                            "this.addToBot(new FlechetteAction(mo, new DamageInfo(p, this.dmgPerSkillInHand, this.damageTypeForTurn)));");

                    action = MultiTarget(target) + action;
                    break;
                }
                action = "         this.addToBot(new FlechetteAction(m, new DamageInfo(p, this.dmgPerSkillInHand, this.damageTypeForTurn)));\n";
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
                    action = "         this.addToBot(new ApplyVulnerableActionAll(this.aVulnerableValue));\n";
                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, " + aVul + ", false), " + aVul + "));\n";
                break;
            case applyWeak:
                if (target.equals("All Enemy"))
                {
                    action = "         this.addToBot(new ApplyWeakActionAll(this.aWeakValue));\n";
                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.aWeakValue, false), this.aWeakValue));\n";

                break;
            case applyPoison:
                if (target.equals("All Enemy"))
                {
                    action = "         this.addToBot(new ApplyPoisonActionAll(this.aPoisonValue));\n";

                    break;
                }
                action = "         this.addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));\n";

                break;
            case applyStr:
                if (target.equals("All Enemy"))
                {
                    action = "         this.addToBot(new ApplyStrActionAll(this.aStrValue));\n";
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
            case gainDex:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, " + gDex + "), " + gDex + "));\n";
                break;
            case gainIntangible:
                action = "         this.addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, " + gIntang + "), " + gIntang + "));\n";
                break;
            //endregion

            //region Health related

            case sacrificeHP:
                action = "         this.addToBot(new LoseHPAction(p, p, " + loseHP + "));\n";
                break;
            case heal:
                action = "         this.addToBot(new HealAction(p, p, " + healing + "));\n";
                break;

            //endregion

            //region Add Card

            //region Add Copy
            case addCopy:
                switch (targetLocation)
                {
                    case addCopy2Hand:
                        action = "         this.addToBot(new MakeTempCardInHandAction(this.makeStatEquivalentCopy()," + actionVar + "));\n";
                        break;
                    case addCopy2Discard:
                        action = "         this.addToBot(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), " + actionVar + "));\n";
                        break;
                    case addCopy2DrawPile:
                        action = "         this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy()," + actionVar + " ,true,true));\n";
                        break;
                    case addCopy2TopDrawPile:
                        action = "         this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), " + actionVar + ",false,false,false));\n";
                        break;
                    case addCopy2BotDrawPile:
                        action = "         this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), " + actionVar + ",false,false,true));\n";
                        break;
                    default:
                        break;
                }

                break;

            case addRandomAttackCopy:
                action= randomAdd(cpyString,targetLocation,"ATTACK");
                break;
            case addRandomSkillCopy:
                action= randomAdd(cpyString,targetLocation,"SKILL");
                break;
            case addRandomPowerCopy:
                action= randomAdd(cpyString,targetLocation,"POWER");
                break;
            case addRandomColorlessCopy:
                action = randomColorless(cpyString,targetLocation);
                break;
            //endregion

            //region Add Random
            case addRandomAttack:
                action= randomAdd(notCpy,targetLocation,"ATTACK");
                break;
            case addRandomSkill:
                action= randomAdd(notCpy,targetLocation,"SKILL");
                break;
            case addRandomPower:
                action= randomAdd(notCpy,targetLocation,"POWER");
                break;
            case addRandomColorless:
                action = randomColorless(notCpy,targetLocation);
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
    public static String AddUpgrade(String action, String where)
    {
        return Upgrade(action, where);
    }

    public static String Upgrade(String matcher, String where)
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
            case damageIfTargetPoison:
                Upgrade = "            upgradeDmgPsnCon(UPGRADE_" + dmgIfTargetPsn + ");\n";
                break;
            case DPAP:
                Upgrade = "            upgradeDPAP(UPGRADE_" + dmgPerAttPlayed + ");\n";
                break;
            case DPSH:
                Upgrade = "            upgradeDPSH(UPGRADE_" + dmgPerSkillInHand + ");\n";
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
                Upgrade = "            " + aVul + "=upgradeAVulnerableValue(UPGRADE_" + aVul + ");\n";
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
            case gainDex:
                Upgrade = "            " + gDex + " = UPGRADE_" + gDex + ";\n";
                break;
            case gainIntangible:
                Upgrade = "            " + gIntang + " = UPGRADE_" + gIntang + ";\n";
                break;
            //endregion

            //health related

            case sacrificeHP:
                Upgrade = "            " + loseHP + " = UPGRADE_" + loseHP + ";\n";
                break;
            case heal:
                Upgrade = "            " + healing + " = UPGRADE_" + healing + ";\n";
                break;

            //endregion

            //region Add cards

            //region Add Copy
            case addCopy:
            case addRandomAttackCopy:
            case addRandomSkillCopy:
            case addRandomPowerCopy:
            case addRandomColorlessCopy:
            case addRandomAttack:
            case addRandomSkill:
            case addRandomPower:
            case addRandomColorless:
                Upgrade = "            " + actionVar + "=UPGRADE_" + actionVar + ";\n";
                break;

            //endregion

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
            "            mo = (AbstractMonster)var3.next();\n" +
            "            if (!mo.isDead && !mo.isDying) {\n";

    public static String MultiTarget(String target)
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
                "           }\n" +
                "        }\n";
        return var;
    }
    //endregion


    //region trash

    //endregion

}
