package suikaMod.cards.CustomCards;

public class Actions
{

    public static String AllActions(String condition,int value)
    {
        /*return Damage(condition) +
                Block(condition);*/
        return Cases(condition,value);
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

    public static String Cases(String matcher,int value)
    {
        String action="";
        switch (matcher)
        {
            case "Damage":
                 action=" this.addToBot(\n" +
                        "                new DamageAction(m, new DamageInfo(p, "+value+", damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n";
                break;
            case "Block":
                 action="         this.addToBot(new GainBlockAction(p, p, "+value+"));\n";
                break;
            case "GainEnergy":
                 action="         this.addToBot(new GainEnergyAction("+value+"));\n";
                 break;
            default:
                action="";
        }
        return action;

    }


}
