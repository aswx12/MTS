package myMod.cards.CustomCards;

import com.megacrit.cardcrawl.cards.AbstractCard;

import javax.swing.*;

public class CardTemplateStrings
{

    public static int intParse(JTextField stringToParse)
    {
        return Integer.parseInt(stringToParse.getText());
    }

    //region Basic Attack
    public static String BasicAttackCard(JTextField name,
                                         JTextField cost,
                                         JTextField upgradeCost,
                                         JTextField dmg,
                                         JTextField upgradePlusDmg)
    {

        String attackCard = "package myMod.cards.CustomCards;\n" +
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
                "import myMod.DefaultMod;\n" +
                "import myMod.cards.AbstractDynamicCard;\n" +
                "import myMod.characters.TheDefault;\n" +
                "\n" +
                "import static myMod.DefaultMod.makeCardPath;\n" +
                "\n" +
                "import java.io.File;  // Import the File class\n" +
                "import java.io.IOException;\n" +
                "\n" +
                "import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;\n" +
                "\n" +
                "\n" +
                "@AutoAdd.Seen\n" +
                "public class " + name.getText() + " extends AbstractDynamicCard\n" +
                "{\n" +
                "    public static final String ID = DefaultMod.makeID(" + name.getText() + ".class.getSimpleName()); \n" +
                "    public static final String IMG = makeCardPath(\"Attack.png\"); \n" +
                "    private static final CardRarity RARITY = CardRarity.COMMON; //  Up to you, I like auto-complete on these\n" +
                "    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.\n" +
                "    private static final CardType TYPE = CardType.ATTACK;       //\n" +
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
                "        super(ID, \"" + name.getText() + "\", IMG," + "\"Deal !D! damage\"" + ", COST, TYPE, COLOR, RARITY, TARGET);\n" +
                "        baseDamage = DAMAGE;\n" +
                "        this.tags.add(CardTags.STARTER_STRIKE); \n" +
                "        this.tags.add(CardTags.STRIKE);\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Actions the card should do.\n" +
                "    @Override\n" +
                "    public void use(AbstractPlayer p, AbstractMonster m)\n" +
                "    {\n" +
                "        AbstractDungeon.actionManager.addToBottom(\n" +
                "                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));\n" +
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

        return attackCard;
    }
    //endregion
}
