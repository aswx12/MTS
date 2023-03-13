package suikaMod.cards.CardGenerator;

import com.sun.crypto.provider.JceKeyStore;
import suikaMod.DefaultMod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CardTemplateStrings
{
    public static String MODID = DefaultMod.MODID;
    static StringBuilder sbVariable = new StringBuilder();
    static StringBuilder sbBaseValue = new StringBuilder();
    static StringBuilder sbActions = new StringBuilder();
    static StringBuilder sbActionsOnUpgrade = new StringBuilder();
    static StringBuilder sbDiscActions = new StringBuilder();
    static StringBuilder sbUpgrade = new StringBuilder();

    static StringBuilder sbState = new StringBuilder();
    static StringBuilder sbUpState = new StringBuilder();
    static boolean repeat;

    //region UTILITIES
    public static int intParse(JTextField stringToParse)
    {
        return Integer.parseInt(stringToParse.getText());
    }

    public static String stringParse(JComboBox thingToParse)
    {
        return thingToParse.getSelectedItem().toString();
    }

    public static int GetActionValues(DefaultTableModel actionModel, int row, int col)
    {

        return Integer.parseInt(actionModel.getValueAt(row, col).toString());
    }

    public static String GetActionNames(DefaultTableModel actionTableModel, int row)
    {
        return DeleteSpace((String) actionTableModel.getValueAt(row, 0));
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
                "import com.megacrit.cardcrawl.actions.AbstractGameAction.*;\n" +
                "import com.megacrit.cardcrawl.actions.common.*;\n" +
                "import com.megacrit.cardcrawl.actions.unique.*;\n" +
                "import com.megacrit.cardcrawl.actions.defect.*;\n" +
                "import com.megacrit.cardcrawl.cards.AbstractCard;\n" +
                "import com.megacrit.cardcrawl.cards.DamageInfo;\n" +
                "import com.megacrit.cardcrawl.characters.AbstractPlayer;\n" +
                "import com.megacrit.cardcrawl.core.CardCrawlGame;\n" +
                "import com.megacrit.cardcrawl.dungeons.AbstractDungeon;\n" +
                "import com.megacrit.cardcrawl.powers.*;\n" +
                "import com.megacrit.cardcrawl.localization.CardStrings;\n" +
                "import com.megacrit.cardcrawl.localization.LocalizedStrings;\n" +
                "import com.megacrit.cardcrawl.monsters.AbstractMonster;\n" +
                "import " + MODID + ".DefaultMod;\n" +
                "import " + MODID + ".actions.*;\n" +
                "import " + MODID + ".cards.AbstractDynamicCard;\n" +
                "import " + MODID + ".characters.TheDefault;\n" +
                "\n" +
                "import static " + MODID + ".DefaultMod.makeCardPath;\n" +
                "\n" +
                "import java.io.File;  // Import the File class\n" +
                "import java.io.IOException;\n" +
                "import java.util.Iterator;\n" +
                "\n" +
                "import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;\n" +
                "\n" +
                "\n" + "";
        return imports;
    }

    public static String ReplaceSpace(JComboBox input)
    {
        String targetSpaceCheck = upperCase(input);
        if (targetSpaceCheck.matches(".*\\s+.*"))
            return targetSpaceCheck = targetSpaceCheck.replaceAll("[\\s|\\u00A0]+", "_");
        else
            return targetSpaceCheck;
    }

    public static String DeleteSpace(String input)
    {
        String targetSpaceCheck = input;
        if (targetSpaceCheck.matches(".*\\s+.*"))
            return targetSpaceCheck = targetSpaceCheck.replaceAll("[\\s|\\u00A0]+", "");
        else
            return targetSpaceCheck;
    }

    public static void SetState(JCheckBox stateCheck, String state)
    {
        if (stateCheck.isSelected())
        {
            sbState.append("            this.").append(state).append("=true; \n");
        }
    }

    public static String CardState(JCheckBox cardStates[])
    {
        String states = "";
        SetState(cardStates[0], "isInnate");
        SetState(cardStates[1], "retain");
        SetState(cardStates[2], "exhaust");
        SetState(cardStates[3], "isEthereal");
        states = sbState.toString();
        return states;
    }

    public static void SetUpgradedState(JCheckBox CardState[], JCheckBox upCardState[], int i, String state)
    {
        if (upCardState[i].isSelected())
        {
            if (!CardState[i].isSelected())
            {
                sbUpState.append("            this.").append(state).append("=true; \n");
            }
        } else
        {
            if (CardState[i].isSelected())
            {
                sbUpState.append("            this.").append(state).append("=false; \n");
            }
        }
    }

    public static String UpgradedCardState(JCheckBox cardStates[], JCheckBox upCardStates[])
    {
        String states = "";
        SetUpgradedState(cardStates, upCardStates, 0, "isInnate");
        SetUpgradedState(cardStates, upCardStates, 1, "retain");
        SetUpgradedState(cardStates, upCardStates, 2, "exhaust");
        SetUpgradedState(cardStates, upCardStates, 3, "isEthereal");
        states = sbUpState.toString();
        return states;
    }

    public static String LoopInsert(boolean repeat, String actions, boolean addOnUpgrade, String actionOnUpgrade)
    {
        String loop = "";
        if (repeat)
        {
            if (addOnUpgrade)
            {
                return loop = "for (int i = 0; i < TIME; i++) {\n" +
                        "           " + actions + actionOnUpgrade + "        }\n";
            }

            return loop = "for (int i = 0; i < TIME; i++) {\n" +
                    "           " + actions + "        }\n";
        }
        if(addOnUpgrade)
            return actions+actionOnUpgrade;

        return actions;
    }

    //endregion

/*    public void callClassByName(Class cls, String funcName) throws Exception {
        // Ignoring any possible result
        cls.getDeclaredMethod(funcName).invoke(null);
    }*/

    //region Basic Attack
    public static String CardTemplate(JTextField name,
                                      JTextField cost,
                                      JTextField upgradeCost,
                                      JComboBox rarity,
                                      JComboBox target,
                                      JComboBox cardType,
                                      JTextArea description,
                                      JTextArea upDescription,
                                      JCheckBox diffUpDescCheck,
                                      JCheckBox seen,
                                      DefaultTableModel actionTableModel,
                                      DefaultTableModel actionOnUpgradeTableModel,
                                      JCheckBox addActionOnUpgrade,
                                      JCheckBox cardStates[],
                                      JCheckBox upCardStates[])
    {

        String DESCRIPTION = description.getText().replaceAll("(?!\\r)\\n", " NL ");
        String upgrade_DESCRIPTION = upDescription.getText().replaceAll("(?!\\r)\\n", " NL ");

        String variable = "";
        String baseValue = "";
        String actions = "";
        String actionsOnUpgrade = "";
        String actionsWhenDiscard = "";
        String upgrade = "";


        //region Adding info to cards
        for (int i = 0; i < actionTableModel.getRowCount(); i++)
        {

            sbVariable.append(ContentAdd.AllVariable(
                    GetActionNames(actionTableModel, i),
                    GetActionValues(actionTableModel, i, 1),
                    GetActionValues(actionTableModel, i, 2)));

            sbBaseValue.append(ContentAdd.BaseValue(
                    GetActionNames(actionTableModel, i)));

            sbActions.append(ContentAdd.AllActions(
                    GetActionNames(actionTableModel, i),
                    stringParse(target)));

            sbDiscActions.append(ContentAdd.ActionsWhenDiscard(
                    GetActionNames(actionTableModel, i)));

            sbUpgrade.append(ContentAdd.Upgrade(
                    GetActionNames(actionTableModel, i)));

            if (GetActionNames(actionTableModel, i).equals("Repeat")) //own table?
            {
                repeat = true; //rework?
            }
        }

        for (int i = 0; i < actionOnUpgradeTableModel.getRowCount(); i++)
        {

            sbVariable.append(ContentAdd.AllVariableUpgrade(
                    GetActionNames(actionOnUpgradeTableModel, i),
                    GetActionValues(actionOnUpgradeTableModel, i, 1)));

            sbBaseValue.append(ContentAdd.BaseValue(
                    GetActionNames(actionOnUpgradeTableModel, i)));

            sbActionsOnUpgrade.append(ContentAdd.AllActions(
                    GetActionNames(actionOnUpgradeTableModel, i),
                    stringParse(target)));

            sbDiscActions.append(ContentAdd.ActionsWhenDiscard(
                    GetActionNames(actionOnUpgradeTableModel, i))); //set upgrade condition

           /* sbUpgrade.append(ContentAdd.Upgrade(
                    GetActionNames(actionOnUpgradeTableModel, i)));*/

        }

        //endregion

        variable = sbVariable.toString();
        baseValue = sbBaseValue.toString();
        actions = sbActions.toString();
        actionsOnUpgrade = sbActionsOnUpgrade.toString();
        actionsWhenDiscard = sbDiscActions.toString();
        upgrade = sbUpgrade.toString();

        //region condition checks
        String closeDiscAction = "";
        if (!actionsWhenDiscard.isEmpty())
        {
            closeDiscAction = "\n   }";
        }

        String isMulti = "";
        if (target.getSelectedItem().toString().equals("All Enemy"))
        {
            isMulti = "isMultiDamage = true;\n";
        }

        String addActOnUpgrade = "";
        if (addActionOnUpgrade.isSelected())
        {
            addActOnUpgrade = "        if(this.upgraded){\n" +
                    "   "+actionsOnUpgrade +"       }\n";
        }

        String upDescInit = "";
        String upDescChange = "";
        if (diffUpDescCheck.isSelected())
        {
            upDescInit = "    private static final String upDesc=\"" + upgrade_DESCRIPTION + "\";\n";
            upDescChange = "            rawDescription=upDesc;\n";
        } else
        {
            upDescInit = "";
            upDescChange = "";
        }

        String unlocked = "";
        if (seen.isSelected())
            unlocked = "Seen";
        else
            unlocked = "Notseen";
        //endregion

        String cardInfo = Imports() +
                "@AutoAdd." + unlocked + "\n" +
                "public class " + DeleteSpace(name.getText()) + " extends AbstractDynamicCard\n" +
                "{\n" +
                "    public static final String ID = DefaultMod.makeID(" + name.getText() + ".class.getSimpleName()); \n" +
                "    public static final String IMG = makeCardPath(\"Attack.png\"); \n" +
                "    private static final CardRarity RARITY = CardRarity." + upperCase(rarity) + "; \n" +
                "    private static final CardTarget TARGET = CardTarget." + ReplaceSpace(target) + "; \n" +
                "    private static final CardType TYPE = CardType." + upperCase(cardType) + ";       //\n" +
                "    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;\n" +
                "\n" +
                "    private static final int COST = " + intParse(cost) + ";  \n" +
                "    private static final int UPGRADED_COST = " + intParse(upgradeCost) + "; \n" +
                "\n" + variable +
                "\n" +
                "    // /STAT DECLARATION/\n" +
                "\n    private static String desc =\"" + DESCRIPTION + "\";\n" +
                "" + upDescInit +

                "    public " + name.getText() + " ()\n" +
                "    { \n" +
                "        super(ID, \"" + name.getText() + "\", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);\n" +
                "" + baseValue + "\n" +
                "" + CardState(cardStates) +
                "       " + isMulti +
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
                "" + LoopInsert(repeat, actions, addActionOnUpgrade.isSelected(), addActOnUpgrade) +
                "    }\n" +
                "\n" +
                "" + actionsWhenDiscard + closeDiscAction +
                "\n" +
                "    // Upgraded stats.\n" +
                "    @Override\n" +
                "    public void upgrade()\n" +
                "    {\n" +
                "        if (!upgraded)\n" +
                "        {\n" +
                "            upgradeName();\n" +
                "" + upgrade +
                "            upgradeBaseCost(UPGRADED_COST);\n" +
                "" + upDescChange +
                "" + UpgradedCardState(cardStates, upCardStates) +
                "            initializeDescription();\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return cardInfo;
    }
    //endregion
}
