package suikaMod.cards.CardGenerator;

import suikaMod.DefaultMod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CardTemplateStrings
{
    public static String MODID = DefaultMod.MODID;


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
            if (!CardState[i].isSelected())//maybe not needed
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
    public static final String[] dNum = {
            "DPE",
            "DVAMP",
            "DTP",
            "DPAP",
            "DPSH",
    };

    public static String ID(String idText)
    {
        return MODID + ":" + idText;
    }

    public static String DNUM(String text)
    {
        return "!" + text + "!";
    }

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

        String DESCRIPTION = description.getText();
        DESCRIPTION = DESCRIPTION.replaceAll("(?!\\r)\\n", " NL ");
        for (int i = 0; i < dNum.length; i++)
        {
            DESCRIPTION = DESCRIPTION.replaceAll(DNUM(dNum[i]), DNUM(ID(dNum[i])));
        }

        String upgrade_DESCRIPTION = upDescription.getText();
        upgrade_DESCRIPTION = upgrade_DESCRIPTION.replaceAll("(?!\\r)\\n", " NL ");
        for (int i = 0; i < dNum.length; i++)
        {
            upgrade_DESCRIPTION = upgrade_DESCRIPTION.replaceAll(DNUM(dNum[i]), DNUM(ID(dNum[i])));
        }

        //region strings
        StringBuilder sbVariable = new StringBuilder();
        StringBuilder sbBaseValue = new StringBuilder();

        StringBuilder sbActions = new StringBuilder();
        StringBuilder sbActionsRepeat = new StringBuilder();
        StringBuilder sbActionsEneAttIntent = new StringBuilder();
        StringBuilder sbActionsEneAttIntentRepeat = new StringBuilder();

        StringBuilder sbAddOnUpgrade = new StringBuilder();
        StringBuilder sbAddOnUpgradeRepeat = new StringBuilder();
        StringBuilder sbAddOnUpgradeEneAttIntent = new StringBuilder();
        StringBuilder sbAddOnUpgradeEneAttIntentRepeat = new StringBuilder();

        StringBuilder sbDelOnUpgrade = new StringBuilder();
        StringBuilder sbDelOnUpgradeRepeat = new StringBuilder();
        StringBuilder sbDelOnUpgradeEneAttIntent = new StringBuilder();
        StringBuilder sbDelOnUpgradeEneAttIntentRepeat = new StringBuilder();

        StringBuilder sbDiscActions = new StringBuilder();
        StringBuilder sbUpgrade = new StringBuilder();

        String variable = "";
        String baseValue = "";

        String actions = "";
        String actionsOnEneAttIntent = "";
        String actionsRepeat = "";
        String actionsOnEneAttIntentRepeat = "";

        String addOnUpgrade = "";
        String addOnUpgradeRepeat = "";
        String addOnUpgradeEneAttIntent = "";
        String addOnUpgradeEneAttIntentRepeat = "";

        String delOnUpgrade = "";
        String delOnUpgradeRepeat = "";
        String delOnUpgradeEneAttIntent = "";
        String delOnUpgradeEneAttIntentRepeat = "";

        String actionsWhenDiscard = "";
        String upgrade = "";

        //endregion

        for (int i = 0; i < actionTableModel.getRowCount(); i++)
        {
            if (GetActionNames(actionTableModel, i).equals("Repeat"))
            {
                repeat = true;
            }
        }

        //region Adding info to cards

        //region default action
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
        //endregion

        //region onUpgrade action
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
                        GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));


                sbBaseValue.append(ContentAdd.SetBase(
                        GetActionNames(actionOnUpgradeTableModel, i)));

                if (CheckCellValue(actionOnUpgradeTableModel, i, 2, "Add"))
                {
                    if (CheckCellValue(actionOnUpgradeTableModel, i, 3, "None"))
                    {
                        if (repeatUpgrade && (Boolean) actionOnUpgradeTableModel.getValueAt(i, 5))
                        {
                            sbAddOnUpgradeRepeat.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));
                        } else
                        {
                            sbAddOnUpgrade.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));
                        }
                    } else if (CheckCellValue(actionOnUpgradeTableModel, i, 3, "Enemy Intent: Attack"))
                    {
                        if (repeatUpgrade && (Boolean) actionOnUpgradeTableModel.getValueAt(i, 5))
                        {
                            sbAddOnUpgradeEneAttIntentRepeat.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));

                        } else
                            sbAddOnUpgradeEneAttIntent.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));
                    }
                } else
                {
                    if (CheckCellValue(actionOnUpgradeTableModel, i, 3, "None"))
                    {
                        if (repeatUpgrade && (Boolean) actionOnUpgradeTableModel.getValueAt(i, 5))
                        {
                            sbDelOnUpgradeRepeat.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));
                        } else
                        {
                            sbDelOnUpgrade.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));
                        }
                    } else if (CheckCellValue(actionOnUpgradeTableModel, i, 3, "Enemy Intent: Attack"))
                    {
                        if (repeatUpgrade && (Boolean) actionOnUpgradeTableModel.getValueAt(i, 5))
                        {
                            sbDelOnUpgradeEneAttIntentRepeat.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));

                        } else
                            sbDelOnUpgradeEneAttIntent.append(ContentAdd.AllActions(
                                    GetActionNames(actionOnUpgradeTableModel, i),
                                    stringParse(target),
                                    GetActionExtraOption(actionOnUpgradeTableModel, i, 4)));
                    }
                }

                sbDiscActions.append(ContentAdd.ActionsWhenDiscard(
                        GetActionNames(actionOnUpgradeTableModel, i))); //set upgrade condition

            }
        }
        //endregion

        //endregion

        variable = sbVariable.toString();
        baseValue = sbBaseValue.toString();

        actions = sbActions.toString();
        actionsRepeat = sbActionsRepeat.toString();
        actionsOnEneAttIntent = sbActionsEneAttIntent.toString();
        actionsOnEneAttIntentRepeat = sbActionsEneAttIntentRepeat.toString();

        addOnUpgrade = sbAddOnUpgrade.toString();
        addOnUpgradeRepeat = sbAddOnUpgradeRepeat.toString();
        addOnUpgradeEneAttIntent = sbAddOnUpgradeEneAttIntent.toString();
        addOnUpgradeEneAttIntentRepeat = sbAddOnUpgradeEneAttIntentRepeat.toString();

        delOnUpgrade = sbDelOnUpgrade.toString();
        delOnUpgradeRepeat = sbDelOnUpgradeRepeat.toString();
        delOnUpgradeEneAttIntent = sbDelOnUpgradeEneAttIntent.toString();
        delOnUpgradeEneAttIntentRepeat = sbDelOnUpgradeEneAttIntentRepeat.toString();

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

        String ifUpgradeAdd = "        if(this.upgraded){\n";
        String ifUpgradeDel = "        if(!this.upgraded){\n";
        String loopUpgrade = "        for (int i = 0; i < " + repeatTime + "; i++) {\n";

        //region add section
        if (!addOnUpgradeRepeat.isEmpty()) // add actions to repeat
        {
            addOnUpgradeRepeat = loopUpgrade + addOnUpgradeRepeat + closeStatement;
        }
        if (!addOnUpgradeEneAttIntentRepeat.isEmpty()) //add actions to intent & repeat
        {
            addOnUpgradeEneAttIntentRepeat = loopUpgrade + addOnUpgradeEneAttIntentRepeat + closeStatement;
        }

        String eneIntentUpgradeTotal = addOnUpgradeEneAttIntent + addOnUpgradeEneAttIntentRepeat;
        if (!eneIntentUpgradeTotal.isEmpty())//total intent add
        {
            eneIntentUpgradeTotal = eneAttIntent + eneIntentUpgradeTotal + closeStatement;
        }
        String upgradeAddActionTotal = addOnUpgrade + addOnUpgradeRepeat + eneIntentUpgradeTotal;

        if (!upgradeAddActionTotal.isEmpty())//final actions add to upgrade condition
        {
            upgradeAddActionTotal = ifUpgradeAdd + upgradeAddActionTotal + closeStatement;
        }
        //endregion

        //region del section
        if (!delOnUpgradeRepeat.isEmpty()) // add actions to repeat
        {
            delOnUpgradeRepeat = loopUpgrade + delOnUpgradeRepeat + closeStatement;
        }
        if (!delOnUpgradeEneAttIntentRepeat.isEmpty()) //add actions to intent & repeat
        {
            delOnUpgradeEneAttIntentRepeat = loopUpgrade + delOnUpgradeEneAttIntentRepeat + closeStatement;
        }

        String eneIntentUpgradeDelTotal = delOnUpgradeEneAttIntent + delOnUpgradeEneAttIntentRepeat;
        if (!eneIntentUpgradeDelTotal.isEmpty())//total intent add
        {
            eneIntentUpgradeDelTotal = eneAttIntent + eneIntentUpgradeDelTotal + closeStatement;
        }
        String upgradeDelActionTotal = delOnUpgrade + delOnUpgradeRepeat + eneIntentUpgradeDelTotal;

        if (!upgradeDelActionTotal.isEmpty())//final actions add to upgrade condition
        {
            upgradeDelActionTotal = ifUpgradeDel + upgradeDelActionTotal + closeStatement;
        }
        //endregion

        String unplayable = "";
        String unplayableKeyword = "";
        if (cardType.getSelectedItem().equals("Curse") || cardType.getSelectedItem().equals("Status"))
        {
            unplayable = "    public boolean canUse(AbstractPlayer p, AbstractMonster m) {\n" +
                    "        return false;\n" +
                    "    }\n";
            unplayableKeyword = "Unplayable NL ";
        }

        String upDescInit = "";
        String upDescChange = "";
        if (diffUpDescCheck.isSelected())
        {
            upDescInit = "    private static final String upDesc=\"" + unplayableKeyword + upgrade_DESCRIPTION + "\";\n";
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
            unlocked = "NotSeen";
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
                "\n    private static String desc =\"" + unplayableKeyword + DESCRIPTION + "\";\n" +
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
                "" + upgradeDelActionTotal +
                "" + upgradeAddActionTotal +
                "    }\n" +
                "\n" +
                "" + actionsWhenDiscard + closeDiscAction +
                "\n" + unplayable +
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
        BuildersReset();
        return cardInfo;
    }
    //endregion

    private static void BuildersReset()
    {

        sbState = new StringBuilder();
        sbUpState = new StringBuilder();
    }
}
