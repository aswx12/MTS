package suikaMod.cards.CardGenerator;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class ContentAdd
{

    //region Actions
    static final String damage = "Damage";
    static final String block = "Block";
    static final String gainEnergy = "GainEnergy";

    static final String applyVulnerable = "ApplyVulnerable";

    static final String applyWeak = "ApplyWeak";

    static final String applyPoison = "ApplyPoison";

    static final String repeat = "Repeat";

    static final String applyStr = "ApplyStrength";

    static final String gainVulnerable = "GainVulnerable";
    static final String gainWeak = "GainWeak";
    static final String gainPoison = "GainPoison";
    static final String gainStr = "GainStrength";

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
                        "    private static final int UPGRADE_PLUS_DMG = " + upgradeValue + ";\n";
                break;
            case block:
                variable = "    private static final int BLOCK = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_BLOCK = " + upgradeValue + ";\n";
                break;
            case gainEnergy: //change this later to magic number
                variable = "    private static final int ENERGY = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_ENERGY = " + upgradeValue + ";\n";
                break;
            case repeat:
                variable = "    private int TIME = " + value + ";\n" +
                        "    private final int UPGRADE_PLUS_TIME = " + upgradeValue + ";\n";
                break;

                //region Apply
            case applyVulnerable: //change this later to magic number
                variable = "    private static final int aVULNERABLE = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_aVULNERABLE = " + upgradeValue + ";\n";
                break;
            case applyWeak: //change this later to magic number
                variable = "    private static final int aWEAK = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_aWEAK = " + upgradeValue + ";\n";
                break;
            case applyPoison: //change this later to magic number
                variable = "    private static final int aPOISON = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_aPOISON = " + upgradeValue + ";\n";
                break;

            case applyStr:
                variable = "    private static final int aSTR = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_aSTR = " + upgradeValue + ";\n";
                break;
                //endregion

                //region Gain
            case gainVulnerable:
                variable = "    private static final int gVULNERABLE = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_gVULNERABLE = " + upgradeValue + ";\n";
                break;
            case gainWeak:
                variable = "    private static final int gWEAK = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_gWEAK = " + upgradeValue + ";\n";
                break;
            case gainPoison:
                variable = "    private static final int gPOISON = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_gPOISON = " + upgradeValue + ";\n";
                break;
            case gainStr:
                variable = "    private static final int gSTR = " + value + ";\n" +
                        "    private static final int UPGRADE_PLUS_gSTR = " + upgradeValue + ";\n";
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
                Upgrade = "upgradeDamage(UPGRADE_PLUS_DMG);\n";
                break;
            case block:
                Upgrade = "            upgradeBlock(UPGRADE_PLUS_BLOCK);\n";
                break;
            case gainEnergy:
                Upgrade = "            this.upgradeMagicNumber(UPGRADE_PLUS_ENERGY);\n";
                //region Apply
                break;
            case repeat:
                Upgrade = "            TIME = UPGRADE_PLUS_TIME;\n";
                break;
            case applyVulnerable:
                Upgrade = "            this.upgradeAVulnerableValue(UPGRADE_PLUS_aVULNERABLE);\n";
                break;
            case applyWeak:
                Upgrade = "            this.upgradeAWeakValue(UPGRADE_PLUS_aWEAK);\n";
                break;
            case applyPoison:
                Upgrade = "            this.upgradeAPoisonValue(UPGRADE_PLUS_aPOISON);\n";
                break;
            case applyStr:
                Upgrade = "            this.upgradeAStrValue(UPGRADE_PLUS_gSTR);\n";
                break;
                //endregion

                //region Gain
            case gainVulnerable:
                Upgrade = "            this.upgradeGVulnerableValue(UPGRADE_PLUS_gVULNERABLE);\n";
                break;
            case gainWeak:
                Upgrade = "            this.upgradeGWeakValue(UPGRADE_PLUS_gWEAK);\n";
                break;
            case gainPoison:
                Upgrade = "            this.upgradeGPoisonValue(UPGRADE_PLUS_gPOISON);\n";
                break;
            case gainStr:
                Upgrade = "            this.upgradeGStrValue(UPGRADE_PLUS_gSTR);\n";
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
