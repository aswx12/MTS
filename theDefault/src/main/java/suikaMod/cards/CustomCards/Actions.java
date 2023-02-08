package suikaMod.cards.CustomCards;

public class Actions
{

    public static String AllActions(String condition)
    {
        /*return Damage(condition) +
                Block(condition);*/
        return Cases(condition);
    }

    public static String Damage(String damage)
    {
        String dmg = "";
        if (damage == "Damage")
            return dmg = " this.addToBot(\n" +
                    "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n";
        return dmg;
    }

    public static String Block(String Block)
    {
        String block = "";
        if (Block == "Block")
            return block = " this.addToBot(new GainBlockAction(p, p, this.damage));\n";

        return block;
    }

    public static String Cases(String matcher)
    {
        String action="";
        switch (matcher)
        {
            case "Damage":
                 action=" this.addToBot(\n" +
                        "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n";
                break;
            case "Block":
                 action=" this.addToBot(new GainBlockAction(p, p, this.damage));\n";
                break;
            case "GainEnergy":
                 action=" this.addToBot(new GainEnergyAction(this.damage));\n";
                 break;
            default:
                action="";
        }
        return action;

    }


}
