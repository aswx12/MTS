package suikaMod.cards.CardGenerator;

import suikaMod.DefaultMod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CardTemplateStrings
{
    public static String MODID = DefaultMod.MODID;
    static StringBuilder sbVariable = new StringBuilder();
    static StringBuilder sbBaseValue = new StringBuilder();

    static StringBuilder sbActions = new StringBuilder();
    static StringBuilder sbActionsRepeat = new StringBuilder();
    static StringBuilder sbActionsEneAttIntent = new StringBuilder();
    static StringBuilder sbActionsEneAttIntentRepeat = new StringBuilder();

    static StringBuilder sbActionsOnUpgrade = new StringBuilder();
    static StringBuilder sbActionsOnUpgradeRepeat = new StringBuilder();
    static StringBuilder sbActionsEneAttIntentOnUpgrade = new StringBuilder();
    static StringBuilder sbActionsEneAttIntentOnUpgradeRepeat = new StringBuilder();

    static StringBuilder sbDiscActions = new StringBuilder();
    static StringBuilder sbUpgrade = new StringBuilder();

    static StringBuilder sbState = new StringBuilder();
    static StringBuilder sbUpState = new StringBuilder();
    static boolean repeat;
    static boolean repeatUpgrade;

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

        if (actionModel.getValueAt(row, col).toString().equals("x"))
            return 0;
        return Integer.parseInt(actionModel.getValueAt(row, col).toString());
    }

    public static boolean CheckCellValue(DefaultTableModel actionModel, int row, int col, String compare)
    {

        return actionModel.getValueAt(row, col).toString().equals(compare);
    }

    public static String GetActionNames(DefaultTableModel actionTableModel, int row)
    {
        return DeleteSpace((String) actionTableModel.getValueAt(row, 0));
    }

    public static String GetActionExtraOption(DefaultTableModel actionTableModel, int row, int col)
    {
        return DeleteSpace((String) actionTableModel.getValueAt(row, col));
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
        if (addOnUpgrade)
            return actions + actionOnUpgrade;

        return actions;
    }

    //endregion

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

        String className = DeleteSpace(name.getText());
        String DESCRIPTION = description.getText().replaceAll("(?!\\r)\\n", " NL ");
        String upgrade_DESCRIPTION = upDescription.getText().replaceAll("(?!\\r)\\n", " NL ");

        String variable = "";
        String baseValue = "";

        String actions = "";
        String actionsOnEneAttIntent = "";
        String actionsRepeat = "";
        String actionsOnEneAttIntentRepeat = "";

        String actionsOnUpgrade = "";
        String actionsOnUpgradeRepeat = "";
        String actionsOnEneAttIntentOnUpgrade = "";
        String actionsOnEneAttIntentOnUpgradeRepeat = "";

        String actionsWhenDiscard = "";
        String upgrade = "";

        for (int i = 0; i < actionTableModel.getRowCount(); i++)
        {
            if (GetActionNames(actionTableModel, i).equals("Repeat"))
            {
                repeat = true;
            }
        }

        //region Adding info to cards
        for (int i = 0; i < actionTableModel.getRowCount(); i++)
        {
            sbVariable.append(ContentAdd.AllVariable(
                    GetActionNames(actionTableModel, i),
                    GetActionValues(actionTableModel, i, 1),
                    GetActionValues(actionTableModel, i, 2),
                    GetActionExtraOption(actionTableModel, i, 4)));

            sbBaseValue.append(ContentAdd.SetBase(
                    GetActionNames(actionTableModel, i)));


            if (CheckCellValue(actionTableModel, i, 3, "None"))
            {
                if (repeat && (Boolean) actionTableModel.getValueAt(i, 5))
                {
                    sbActionsRepeat.append(ContentAdd.AllActions(
                            GetActionNames(actionTableModel, i),
                            stringParse(target),
                            GetActionExtraOption(actionTableModel, i, 4)));
                } else
                {
                    sbActions.append(ContentAdd.AllActions(
                            GetActionNames(actionTableModel, i),
                            stringParse(target),
                            GetActionExtraOption(actionTableModel, i, 4)));
                }
            } else if (CheckCellValue(actionTableModel, i, 3, "Enemy Intent: Attack"))
            {
                if (repeat && (Boolean) actionTableModel.getValueAt(i, 5))
                {
                    sbActionsEneAttIntentRepeat.append(ContentAdd.AllActions(
                            GetActionNames(actionTableModel, i),
                            stringParse(target),
                            GetActionExtraOption(actionTableModel, i, 4)));
                } else
                    sbActionsEneAttIntent.append(ContentAdd.AllActions(
                            GetActionNames(actionTableModel, i),
                            stringParse(target),
                            GetActionExtraOption(actionTableModel, i, 4)));
            }


            sbDiscActions.append(ContentAdd.ActionsWhenDiscard(
                    GetActionNames(actionTableModel, i)));

            sbUpgrade.append(ContentAdd.Upgrade(
                    GetActionNames(actionTableModel, i),
                    GetActionExtraOption(actionTableModel, i, 4)));


        }
        for (int i = 0; i < actionOnUpgradeTableModel.getRowCount(); i++)
        {
            if (GetActionNames(actionOnUpgradeTableModel, i).equals("Repeat"))
            {
                repeatUpgrade = true;
            }
        }
        int repeatTime = 0;
        if (addActionOnUpgrade.isSelected())
        {
            for (int i = 0; i < actionOnUpgradeTableModel.getRowCount(); i++)
            {
                if (GetActionNames(actionOnUpgradeTableModel, i).equals("Repeat"))
                {
                    repeatTime = GetActionValues(actionOnUpgradeTableModel, i, 1);
                    continue;
                }
                sbVariable.append(ContentAdd.AllVariableUpgrade(
                        GetActionNames(actionOnUpgradeTableModel, i),
                        GetActionValues(actionOnUpgradeTableModel, i, 1),
                        GetActionExtraOption(actionOnUpgradeTableModel, i, 3)));


                sbBaseValue.append(ContentAdd.SetBase(
                        GetActionNames(actionOnUpgradeTableModel, i)));

                if (CheckCellValue(actionOnUpgradeTableModel, i, 2, "None"))
                {
                    if (repeatUpgrade && (Boolean) actionOnUpgradeTableModel.getValueAt(i, 4))
                    {
                        sbActionsOnUpgradeRepeat.append(ContentAdd.AllActions(
                                GetActionNames(actionOnUpgradeTableModel, i),
                                stringParse(target),
                                GetActionExtraOption(actionOnUpgradeTableModel, i, 3)));
                    } else
                    {
                        sbActionsOnUpgrade.append(ContentAdd.AllActions(
                                GetActionNames(actionOnUpgradeTableModel, i),
                                stringParse(target),
                                GetActionExtraOption(actionOnUpgradeTableModel, i, 3)));
                    }
                } else if (CheckCellValue(actionOnUpgradeTableModel, i, 2, "Enemy Intent: Attack"))
                {
                    if (repeatUpgrade && (Boolean) actionOnUpgradeTableModel.getValueAt(i, 4))
                    {
                        sbActionsEneAttIntentOnUpgradeRepeat.append(ContentAdd.AllActions(
                                GetActionNames(actionOnUpgradeTableModel, i),
                                stringParse(target),
                                GetActionExtraOption(actionOnUpgradeTableModel, i, 3)));

                    } else
                        sbActionsEneAttIntentOnUpgrade.append(ContentAdd.AllActions(
                                GetActionNames(actionOnUpgradeTableModel, i),
                                stringParse(target),
                                GetActionExtraOption(actionOnUpgradeTableModel, i, 3)));
                }


                sbDiscActions.append(ContentAdd.ActionsWhenDiscard(
                        GetActionNames(actionOnUpgradeTableModel, i))); //set upgrade condition

            }
        }


        //endregion

        variable = sbVariable.toString();
        baseValue = sbBaseValue.toString();

        actions = sbActions.toString();
        actionsRepeat = sbActionsRepeat.toString();
        actionsOnEneAttIntent = sbActionsEneAttIntent.toString();
        actionsOnEneAttIntentRepeat = sbActionsEneAttIntentRepeat.toString();

        actionsOnUpgrade = sbActionsOnUpgrade.toString();
        actionsOnUpgradeRepeat = sbActionsOnUpgradeRepeat.toString();
        actionsOnEneAttIntentOnUpgrade = sbActionsEneAttIntentOnUpgrade.toString();
        actionsOnEneAttIntentOnUpgradeRepeat = sbActionsEneAttIntentOnUpgradeRepeat.toString();

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
        String loop = "        for (int i = 0; i < repeatTIME; i++) {\n";
        String closeStatement = "        }\n";
        if (!actionsRepeat.isEmpty())
        {
            actionsRepeat = loop + actionsRepeat + closeStatement;
        }


        String eneAttIntent = "        if (m != null && m.getIntentBaseDmg() >= 0)\n" +
                "        {\n";

        if (!actionsOnEneAttIntentRepeat.isEmpty())
        {
            actionsOnEneAttIntentRepeat = loop + actionsOnEneAttIntentRepeat + closeStatement;
        }
        String eneIntentTotal = actionsOnEneAttIntent + actionsOnEneAttIntentRepeat;
        if (!eneIntentTotal.isEmpty())
        {
            eneIntentTotal = eneAttIntent + eneIntentTotal + closeStatement;
        }

        String ifUpgrade = "        if(this.upgraded){\n";
        String loopUpgrade = "        for (int i = 0; i < " + repeatTime + "; i++) {\n";

        if (!actionsOnUpgradeRepeat.isEmpty()) // add actions to repeat
        {
            actionsOnUpgradeRepeat = loopUpgrade + actionsOnUpgradeRepeat + closeStatement;
        }
        if (!actionsOnEneAttIntentOnUpgradeRepeat.isEmpty()) //add actions to intent & repeat
        {
            actionsOnEneAttIntentOnUpgradeRepeat = loopUpgrade + actionsOnEneAttIntentOnUpgradeRepeat + closeStatement;
        }

        String eneIntentUpgradeTotal = actionsOnEneAttIntentOnUpgrade + actionsOnEneAttIntentOnUpgradeRepeat;
        if (!eneIntentUpgradeTotal.isEmpty())//total intent add
        {
            eneIntentUpgradeTotal = eneAttIntent + eneIntentUpgradeTotal + closeStatement;
        }
        String upgradeActionTotal = actionsOnUpgrade + actionsOnUpgradeRepeat + eneIntentUpgradeTotal;
        if (!upgradeActionTotal.isEmpty())//final actions add to upgrade condition
        {
            upgradeActionTotal = ifUpgrade + upgradeActionTotal + closeStatement;
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

        String cardTags = "";
        if (name.getText().contains("Strike"))
        {
            cardTags = "this.tags.add(CardTags.STRIKE);\n";
        }


        String unlocked = "";
        if (seen.isSelected())
            unlocked = "Seen";
        else
            unlocked = "Notseen";
        //endregion

        String cardInfo = Imports() +
                "@AutoAdd." + unlocked + "\n" +
                "public class " + className + " extends AbstractDynamicCard\n" +
                "{\n" +
                "    public static final String ID = DefaultMod.makeID(" + className + ".class.getSimpleName()); \n" +
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

                "    public " + className + " ()\n" +
                "    { \n" +
                "        super(ID, \"" + name.getText() + "\", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);\n" +
                "" + baseValue + "\n" +
                "" + CardState(cardStates) +
                "       " + isMulti +
                "       " + cardTags +
                "        //this.tags.add(CardTags.STARTER_STRIKE); \n" + //wht if not starter?
                "\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    // Actions the card should do.\n" +
                "    @Override\n" +
                "    public void use(AbstractPlayer p, AbstractMonster m)\n" +
                "    {\n" +
                "" + actions/*LoopInsert(repeat, actions, addActionOnUpgrade.isSelected(), addActOnUpgrade)*/ +
                "" + actionsRepeat +
                "" + eneIntentTotal +
                "" + upgradeActionTotal +
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
