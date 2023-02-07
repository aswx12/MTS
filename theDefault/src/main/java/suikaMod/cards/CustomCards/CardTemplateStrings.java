package suikaMod.cards.CustomCards;

import suikaMod.DefaultMod;

import javax.swing.*;

public class CardTemplateStrings
{
    public static String MODID = DefaultMod.MODID;

    public static int intParse(JTextField stringToParse)
    {
        return Integer.parseInt(stringToParse.getText());
    }

    public static String upperCase(JComboBox string)
    {
        return string.getSelectedItem().toString().toUpperCase();
    }

    public static String Imports()
    {
        String imports = "package " + MODID + ".cards.CustomCards;\n" +
                "\n" +
                "import basemod.AutoAdd;\n" +
                "import basemod.BaseMod;\n" +
                "import com.megacrit.cardcrawl.actions.AbstractGameAction;\n" +
                "import com.megacrit.cardcrawl.actions.common.DamageAction;\n" +
                "import com.megacrit.cardcrawl.cards.DamageInfo;\n" +
                "import com.megacrit.cardcrawl.characters.AbstractPlayer;\n" +
                "import com.megacrit.cardcrawl.core.CardCrawlGame;\n" +
                "import com.megacrit.cardcrawl.dungeons.AbstractDungeon;\n" +
                "import com.megacrit.cardcrawl.localization.CardStrings;\n" +
                "import com.megacrit.cardcrawl.localization.LocalizedStrings;\n" +
                "import com.megacrit.cardcrawl.monsters.AbstractMonster;\n" +
                "import " + MODID + ".DefaultMod;\n" +
                "import " + MODID + ".cards.AbstractDynamicCard;\n" +
                "import " + MODID + ".characters.TheDefault;\n" +
                "\n" +
                "import static " + MODID + ".DefaultMod.makeCardPath;\n" +
                "\n" +
                "import java.io.File;  // Import the File class\n" +
                "import java.io.IOException;\n" +
                "\n" +
                "import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;\n" +
                "\n" +
                "\n" + "";
        return imports;
    }

    public static String Damage()
    {
        String dmg = "new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n";
            return dmg;
    }

    //region Basic Attack
    public static String CardTemplate(JTextField name,
                                      JTextField cost,
                                      JTextField upgradeCost,
                                      JTextField dmg,
                                      JTextField upgradePlusDmg,
                                      JComboBox rarity,
                                      JComboBox target,
                                      JComboBox cardType,
                                      JTextArea description,
                                      JCheckBox seen)
    {

        String targetSpaceCheck = upperCase(target);
        if (targetSpaceCheck.matches(".*\\s+.*"))
            targetSpaceCheck = targetSpaceCheck.replaceAll("[\\s|\\u00A0]+", "_");

        String unlocked = "";
        if (seen.isSelected())
            unlocked = "Seen";
        else
            unlocked = "Notseen";

        String cardInfo = Imports() +
                "@AutoAdd." + unlocked + "\n" +
                "public class " + name.getText() + " extends AbstractDynamicCard\n" +
                "{\n" +
                "    public static final String ID = DefaultMod.makeID(" + name.getText() + ".class.getSimpleName()); \n" +
                "    public static final String IMG = makeCardPath(\"Attack.png\"); \n" +
                "    private static final CardRarity RARITY = CardRarity." + upperCase(rarity) + "; \n" +
                "    private static final CardTarget TARGET = CardTarget." + targetSpaceCheck + "; \n" +
                "    private static final CardType TYPE = CardType." + upperCase(cardType) + ";       //\n" +
                "    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;\n" +
                "\n" +
                "    private static final int COST = " + intParse(cost) + ";  \n" +
                "    private static final int UPGRADED_COST = " + intParse(upgradeCost) + "; \n" +
                "\n" +
                "    public static int DAMAGE = " + intParse(dmg) + "; \n" +
                "    private static final int UPGRADE_PLUS_DMG = " + intParse(upgradePlusDmg) + ";  \n" +
                "\n" +
                "    // /STAT DECLARATION/\n" +
                "\n" +
                "    public " + name.getText() + " ()\n" +
                "    { \n" +
                "        super(ID, \"" + name.getText() + "\", IMG," + "\"" + description.getText() + "\"" + ", COST, TYPE, COLOR, RARITY, TARGET);\n" +
                "        baseDamage = DAMAGE;\n" +
                "        //this.tags.add(CardTags.STARTER_STRIKE); \n" + //wht if not starter?
                "        //this.tags.add(CardTags.STRIKE);\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Actions the card should do.\n" +
                "    @Override\n" +
                "    public void use(AbstractPlayer p, AbstractMonster m)\n" +
                "    {\n" +
                "        AbstractDungeon.actionManager.addToBottom(\n" +
                "                "+Damage()+
                "    }\n" +
                "\n" +
                "    // Upgraded stats.\n" +
                "    @Override\n" +
                "    public void upgrade()\n" +
                "    {\n" +
                "        if (!upgraded)\n" +
                "        {\n" +
                "            upgradeName();\n" +
                "            upgradeDamage(UPGRADE_PLUS_DMG);\n" +
                "            upgradeBaseCost(UPGRADED_COST);\n" +
                "            initializeDescription();\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return cardInfo;
    }
    //endregion
}
