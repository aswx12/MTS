package suikaMod.cards.CardGenerator;

public class ContentAdd
{

    //region Actions
    static final String damage = "Damage";
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
    static final String addCopy2Discard = "AddCopy(Discard)";
    static final String addCopy2Hand = "AddCopy(Hand)";

    static final String addRandomAttack = "AddRandomAttack(Hand)";
    static final String addRandomSkill = "AddRandomSkill(Hand)";
    static final String addRandomPower = "AddRandomPower(Hand)";

    static final String chooseToDraw = "ChooseToDraw";
    static final String chooseToDrawAttack = "ChooseToDraw(Attack)";
    static final String chooseToDrawSkill = "ChooseToDraw(Skill)";

    static final String drawCard = "Draw Card";


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
            case damage:
                variable = "    private static final int DAMAGE = " + value + ";\n" +
                        "    private static final int UPGRADE_DMG = " + upgradeValue + ";\n";
                break;
            case block:
                variable = "    private static final int BLOCK = " + value + ";\n" +
                        "    private static final int UPGRADE_BLOCK = " + upgradeValue + ";\n";
                break;
            case gainEnergy: //change this later to magic number
                variable = "    private static final int ENERGY = " + value + ";\n" +
                        "    private static final int UPGRADE_ENERGY = " + upgradeValue + ";\n";
                break;
            case repeat:
                variable = "    private int TIME = " + value + ";\n" +
                        "    private final int UPGRADE_TIME = " + upgradeValue + ";\n";
                break;

            //region Apply
            case applyVulnerable: //change this later to magic number
                variable = "    private static final int aVULNERABLE = " + value + ";\n" +
                        "    private static final int UPGRADE_aVULNERABLE = " + upgradeValue + ";\n";
                break;
            case applyWeak: //change this later to magic number
                variable = "    private static final int aWEAK = " + value + ";\n" +
                        "    private static final int UPGRADE_aWEAK = " + upgradeValue + ";\n";
                break;
            case applyPoison: //change this later to magic number
                variable = "    private static final int aPOISON = " + value + ";\n" +
                        "    private static final int UPGRADE_aPOISON = " + upgradeValue + ";\n";
                break;

            case applyStr:
                variable = "    private static final int aSTR = " + value + ";\n" +
                        "    private static final int UPGRADE_aSTR = " + upgradeValue + ";\n";
                break;
            //endregion

            //region Gain
            case gainVulnerable:
                variable = "    private static final int gVULNERABLE = " + value + ";\n" +
                        "    private static final int UPGRADE_gVULNERABLE = " + upgradeValue + ";\n";
                break;
            case gainWeak:
                variable = "    private static final int gWEAK = " + value + ";\n" +
                        "    private static final int UPGRADE_gWEAK = " + upgradeValue + ";\n";
                break;
            case gainPoison:
                variable = "    private static final int gPOISON = " + value + ";\n" +
                        "    private static final int UPGRADE_gPOISON = " + upgradeValue + ";\n";
                break;
            case gainStr:
                variable = "    private static final int gSTR = " + value + ";\n" +
                        "    private static final int UPGRADE_gSTR = " + upgradeValue + ";\n";
                break;
            //endregion

            //region Add Card
            case addCopy2Discard:
                variable = "    private int dCOPY_AMOUNT = " + value + ";\n" +
                        "    private final int UPGRADE_dCOPY_AMOUNT = " + upgradeValue + ";\n";
                break;
            case addCopy2Hand:
                variable = "    private int hCOPY_AMOUNT = " + value + ";\n" +
                        "    private final int UPGRADE_hCOPY_AMOUNT = " + upgradeValue + ";\n";
                break;

            case addRandomAttack:
                variable = "    private int ADD_AMOUNT_RANDOM_ATTACK = " + value + ";\n" +
                        "    private final int UPGRADE_AMOUNT_RANDOM_ATTACK = " + upgradeValue + ";\n";
                break;
            case addRandomSkill:
                variable = "    private int ADD_AMOUNT_RANDOM_SKILL = " + value + ";\n" +
                        "    private final int UPGRADE_AMOUNT_RANDOM_SKILL = " + upgradeValue + ";\n";
                break;
            case addRandomPower:
                variable = "    private int ADD_AMOUNT_RANDOM_POWER = " + value + ";\n" +
                        "    private final int UPGRADE_AMOUNT_RANDOM_POWER = " + upgradeValue + ";\n";
                break;

            case chooseToDraw:
                variable = "    private int CHOOSE_AMOUNT = " + value + ";\n" +
                        "    private final int UPGRADE_CHOOSE_AMOUNT = " + upgradeValue + ";\n";
                break;
            case chooseToDrawAttack:
                variable = "    private int CHOOSE_AMOUNT_ATTACK = " + value + ";\n" +
                        "    private final int UPGRADE_CHOOSE_AMOUNT_ATTACK = " + upgradeValue + ";\n";
                break;
            case chooseToDrawSkill:
                variable = "    private int CHOOSE_AMOUNT_SKILL = " + value + ";\n" +
                        "    private final int UPGRADE_CHOOSE_AMOUNT_SKILL = " + upgradeValue + ";\n";
                break;
            case drawCard:
                variable = "    private int DRAW_AMOUNT = " + value + ";\n" +
                        "    private final int UPGRADE_DRAW_AMOUNT = " + upgradeValue + ";\n";
                break;
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
            case damage:
                base = "baseDamage = DAMAGE;\n";
                break;
            case block:
                base = "        baseBlock = BLOCK;\n";
                break;
            case gainEnergy:
                base = "        magicNumber = baseMagicNumber = ENERGY;\n";
                break;
            //region Apply
            case applyVulnerable:
                base = "        aVulnerableValue = aBaseVulnerableValue = aVULNERABLE;\n";
                break;
            case applyWeak:
                base = "        aWeakValue = aBaseWeakValue= aWEAK;\n";
                break;
            case applyPoison:
                base = "        aPoisonValue = aBasePoisonValue= aPOISON;\n";
                break;
            case applyStr:
                base = "        aStrValue = aBaseStrValue= aSTR;\n";
                break;
            //endregion

            //region Gain
            case gainVulnerable:
                base = "        gVulnerableValue = gBaseVulnerableValue = gVULNERABLE;\n";
                break;
            case gainWeak:
                base = "        gWeakValue = gBaseWeakValue= gWEAK;\n";
                break;
            case gainPoison:
                base = "        gPoisonValue = gBasePoisonValue= gPOISON;\n";
                break;
            case gainStr:
                base = "        gStrValue = gBaseStrValue= gSTR;\n";
                break;
            //endregion
            default:
                base = "";
        }
        return base;
    }
    //endregion

    //region Actions
    public static String AllActions(String action)
    {
        return Actions(action);
    }

    public static String Actions(String matcher)
    {
        String action = "";
        switch (matcher)
        {
            case damage:
                action = " this.addToBot(\n" +
                        "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));\n";
                break;
            case block:
                action = "         this.addToBot(new GainBlockAction(p, p, block));\n";
                break;
            case gainEnergy:
                action = "         this.addToBot(new GainEnergyAction(magicNumber));\n";
                break;
            //region apply
            case applyVulnerable:
                action = "         this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.aVulnerableValue, false), this.aVulnerableValue));\n";
                break;
            case applyWeak:
                action = "         this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.aWeakValue, false), this.aWeakValue));\n";
                break;
            case applyPoison:
                action = "         this.addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));\n";
                break;
            case applyStr:
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

            //region Add Card
            case addCopy2Discard:
                action = "         this.addToBot(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), dCOPY_AMOUNT));\n";
                break;
            case addCopy2Hand:
                action = "         this.addToBot(new MakeTempCardInHandAction(this.makeStatEquivalentCopy(),hCOPY_AMOUNT));\n";
                break;

            case addRandomAttack:
                action = "         AddRandomCard(ADD_AMOUNT_RANDOM_ATTACK,CardType.ATTACK);\n";
                break;
            case addRandomSkill:
                action = "         AddRandomCard(ADD_AMOUNT_RANDOM_SKILL,CardType.SKILL);\n";
                break;
            case addRandomPower:
                action = "         AddRandomCard(ADD_AMOUNT_RANDOM_POWER,CardType.POWER);\n";
                break;

            case chooseToDraw:
                action = "         this.addToBot(new BetterDrawPileToHandAction(CHOOSE_AMOUNT));\n";
                break;
            case chooseToDrawAttack:
                action = "         this.addToBot(new AttackFromDeckToHandAction(CHOOSE_AMOUNT_ATTACK));\n";
                break;
            case chooseToDrawSkill:
                action = "         this.addToBot(new SkillFromDeckToHandAction(CHOOSE_AMOUNT_SKILL));\n";
                break;
            case drawCard:
                action = "         this.addToBot(new DrawCardAction(p, DRAW_AMOUNT));\n";
                break;
            //endregion
            //endregion
            default:
                action = "";
        }
        return action;
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
            case damage:
                Upgrade = "upgradeDamage(UPGRADE_DMG);\n";
                break;
            case block:
                Upgrade = "            upgradeBlock(UPGRADE_BLOCK);\n";
                break;
            case gainEnergy:
                Upgrade = "            this.upgradeMagicNumber(UPGRADE_ENERGY);\n";
                //region Apply
                break;
            case repeat:
                Upgrade = "            TIME = UPGRADE_TIME;\n";
                break;
            case applyVulnerable:
                Upgrade = "            this.upgradeAVulnerableValue(UPGRADE_aVULNERABLE);\n";
                break;
            case applyWeak:
                Upgrade = "            this.upgradeAWeakValue(UPGRADE_aWEAK);\n";
                break;
            case applyPoison:
                Upgrade = "            this.upgradeAPoisonValue(UPGRADE_aPOISON);\n";
                break;
            case applyStr:
                Upgrade = "            this.upgradeAStrValue(UPGRADE_gSTR);\n";
                break;
            //endregion

            //region Gain
            case gainVulnerable:
                Upgrade = "            this.upgradeGVulnerableValue(UPGRADE_gVULNERABLE);\n";
                break;
            case gainWeak:
                Upgrade = "            this.upgradeGWeakValue(UPGRADE_gWEAK);\n";
                break;
            case gainPoison:
                Upgrade = "            this.upgradeGPoisonValue(UPGRADE_gPOISON);\n";
                break;
            case gainStr:
                Upgrade = "            this.upgradeGStrValue(UPGRADE_gSTR);\n";
                break;
            //endregion
            //region Add cards
            case addCopy2Discard:
                Upgrade = "            dCOPY_AMOUNT=UPGRADE_dCOPY_AMOUNT;\n";
                break;
            case addCopy2Hand:
                Upgrade = "            hCOPY_AMOUNT=UPGRADE_hCOPY_AMOUNT;\n";
                break;

            case addRandomAttack:
                Upgrade = "            ADD_AMOUNT_RANDOM_ATTACK=UPGRADE_AMOUNT_RANDOM_ATTACK;\n";
                break;
            case addRandomSkill:
                Upgrade = "            ADD_AMOUNT_RANDOM_SKILL=UPGRADE_AMOUNT_RANDOM_SKILL;\n";
                break;
            case addRandomPower:
                Upgrade = "            ADD_AMOUNT_RANDOM_POWER=UPGRADE_AMOUNT_RANDOM_POWER;\n";
                break;

            case chooseToDraw:
                Upgrade = "            CHOOSE_AMOUNT=UPGRADE_CHOOSE_AMOUNT;\n";
                break;
            case chooseToDrawAttack:
                Upgrade = "            CHOOSE_AMOUNT_ATTACK=UPGRADE_CHOOSE_AMOUNT_ATTACK;\n";
                break;
            case chooseToDrawSkill:
                Upgrade = "            CHOOSE_AMOUNT_SKILL=UPGRADE_CHOOSE_AMOUNT_SKILL;\n";
                break;
            case drawCard:
                Upgrade = "            DRAW_AMOUNT=UPGRADE_DRAW_AMOUNT;\n";
                break;
            //endregion
            default:
                Upgrade = "";
        }
        return Upgrade;
    }
    //endregion

    //region trash

    //endregion

}
