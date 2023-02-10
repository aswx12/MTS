package suikaMod.cards.CustomCards;

public class ContentAdd {

    //region Variable
    public static String AllVariable(String action, int value,int valuePlusUpgade ) {
        return Variable(action, value,valuePlusUpgade);
    }

    public static String Variable(String matcher, int value,int valuePlusUpgade) {
        String variable = "";
        switch (matcher) {
            case "Damage":
                variable = "    private static final int DAMAGE = "+value+";\n" +
                        "    private static final int UPGRADE_PLUS_DMG = "+valuePlusUpgade+";\n";
                break;
            case "Block":
                variable = "    private static final int BLOCK = "+value+";\n" +
                        "    private static final int UPGRADE_PLUS_BLOCK = "+valuePlusUpgade+";\n";
                break;
            case "GainEnergy": //change this later to magic number
                variable = "    private static final int ENERGY = "+value+";\n" +
                        "    private static final int UPGRADE_PLUS_ENERGY = "+valuePlusUpgade+";\n";
                break;
            default:
                variable = "";
        }
        return variable;
    }
    //endregion

    //region BaseValue
    public static String SetBase(String action) {
        return BaseValue(action);
    }

    public static String BaseValue(String matcher) {
        String base = "";
        switch (matcher) {
            case "Damage":
                base = "baseDamage = DAMAGE;\n";
                break;
            case "Block":
                base = "        baseBlock = BLOCK;\n";
                break;
            case "GainEnergy":
                base = "        magicNumber = baseMagicNumber = ENERGY;\n";
                break;
            default:
                base = "";
        }
        return base;
    }
    //endregion

    //region Actions
    public static String AllActions(String action) {
        return Actions(action);
    }

    public static String Actions(String matcher) {
        String action = "";
        switch (matcher) {
            case "Damage":
                action = " this.addToBot(\n" +
                        "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n";
                break;
            case "Block":
                action = "         this.addToBot(new GainBlockAction(p, p, block));\n";
                break;
            case "GainEnergy":
                action = "         this.addToBot(new GainEnergyAction(magicNumber));\n";
                break;
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

    public static String Upgrade(String matcher) {
        String Upgrade = "";
        switch (matcher) {
            case "Damage":
                Upgrade = "upgradeDamage(UPGRADE_PLUS_DMG);\n";
                break;
            case "Block":
                Upgrade = "           upgradeBlock(UPGRADE_PLUS_BLOCK);\n";
                break;
            case "GainEnergy":
                Upgrade = "           this.upgradeMagicNumber(UPGRADE_PLUS_ENERGY);\n";
                break;
            default:
                Upgrade = "";
        }
        return Upgrade;
    }
    //endregion

    //region trash
    public static String Damage(String damage) {
        String dmg = "";
        if (damage == "Damage")
            return dmg = " this.addToBot(\n" + "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n";
        return dmg;
    }

    public static String Block(String Block) {
        String block = "";
        if (Block == "Block") return block = " this.addToBot(new GainBlockAction(p, p, this.damage));\n";

        return block;
    }
    //endregion

}
