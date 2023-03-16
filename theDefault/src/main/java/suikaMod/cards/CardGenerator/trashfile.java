package suikaMod.cards.CardGenerator;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.Iterator;

public class trashfile
{
                /*case addRandomAttackHandCopy:
                action = "         AddRandomCardHandCopy(" + rAttackHandCopy + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillHandCopy:
                action = "         AddRandomCardHandCopy(" + rSkillHandCopy + ",CardType.SKILL);\n";
                break;
            case addRandomPowerHandCopy:
                action = "         AddRandomCardHandCopy(" + rPowerHandCopy + ",CardType.POWER);\n";
                break;
            case addRandomColorlessHandCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessHandCopy + ",\"Hand\");\n";
                break;

            case addRandomAttackDiscardCopy:
                action = "         AddRandomCardDiscardCopy(" + rAttackDiscCopy + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillDiscardCopy:
                action = "         AddRandomCardDiscardCopy(" + rSkillDiscCopy + ",CardType.SKILL);\n";
                break;
            case addRandomPowerDiscardCopy:
                action = "         AddRandomCardDiscardCopy(" + rPowerDiscCopy + ",CardType.POWER);\n";
                break;
            case addRandomColorlessDiscardCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessDiscCopy + ",\"Discard\");\n";
                break;

            case addRandomAttackDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rAttackDrawPCopy + ",CardType.ATTACK,\"Random\");\n";
                break;
            case addRandomSkillDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rSkillDrawPCopy + ",CardType.SKILL,\"Random\");\n";
                break;
            case addRandomPowerDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rPowerDrawPCopy + ",CardType.POWER,\"Random\");\n";
                break;
            case addRandomColorlessDrawPileCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessDrawPCopy + ",\"DrawPile\");\n";
                break;

            case addRandomAttackTopDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rAttackTopDrawPCopy + ",CardType.ATTACK,\"Top\");\n";
                break;
            case addRandomSkillTopDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rSkillTopDrawPCopy + ",CardType.SKILL,\"Top\");\n";
                break;
            case addRandomPowerTopDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rPowerTopDrawPCopy + ",CardType.POWER,\"Top\");\n";
                break;
            case addRandomColorlessTopDrawPileCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessTopDrawPCopy + ",\"TopDrawPile\");\n";
                break;

            case addRandomAttackBotDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rAttackBotDrawPCopy + ",CardType.ATTACK,\"Bot\");\n";
                break;
            case addRandomSkillBotDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rSkillBotDrawPCopy + ",CardType.SKILL,\"Bot\");\n";
                break;
            case addRandomPowerBotDrawPileCopy:
                action = "         AddRandomCardDrawPCopy(" + rPowerBotDrawPCopy + ",CardType.POWER,\"Bot\");\n";
                break;
            case addRandomColorlessBotDrawPileCopy:
                action = "         AddRandomColorlessCopy(" + rColorlessBotDrawPCopy + ",\"BotDrawPile\");\n";
                break;*/

   /* public static String rAttackHand = "rAttack2HandQty";
    public static String rSkillHand = "rSkill2HandQty";
    public static String rPowerHand = "rPower2HandQty";
    public static String rColorlessHand = "rColorless2HandQty";

    public static String rAttackDisc = "rAttack2DiscQty";
    public static String rSkillDisc = "rSkill2DiscQty";
    public static String rPowerDisc = "rPower2DiscQty";
    public static String rColorlessDisc = "rColorless2DiscQty";

    public static String rAttackDrawP = "rAttack2DrawPQty";
    public static String rSkillDrawP = "rSkill2DrawPQty";
    public static String rPowerDrawP = "rPower2DrawPQty";
    public static String rColorlessDrawP = "rColorless2DrawPQty";

    public static String rAttackTopDrawP = "rAttack2TopDrawPQty";
    public static String rSkillTopDrawP = "rSkill2TopDrawPQty";
    public static String rPowerTopDrawP = "rPower2DrawTopPQty";
    public static String rColorlessTopDrawP = "rColorless2TopDrawPQty";

    public static String rAttackBotDrawP = "rAttack2BotDrawPQty";
    public static String rSkillBotDrawP = "rSkill2BotDrawPQty";
    public static String rPowerBotDrawP = "rPower2BotDrawPQty";
    public static String rColorlessBotDrawP = "rColorless2BotDrawPQty";*/

     /* case addRandomAttackHand:
                variable = "    private int " + rAttackHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackHand + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillHand:
                variable = "    private int " + rSkillHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillHand + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerHand:
                variable = "    private int " + rPowerHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerHand + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessHand:
                variable = "    private int " + rColorlessHand + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessHand + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackDiscard:
                variable = "    private int " + rAttackDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackDisc + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillDiscard:
                variable = "    private int " + rSkillDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillDisc + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerDiscard:
                variable = "    private int " + rPowerDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_d" + rPowerDisc + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessDiscard:
                variable = "    private int " + rColorlessDisc + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessDisc + " = " + upgradeValue + ";\n";
                break;
            //--------------------------------------------------
            case addRandomAttackDrawPile:
                variable = "    private int " + rAttackDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillDrawPile:
                variable = "    private int " + rSkillDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerDrawPile:
                variable = "    private int " + rPowerDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessDrawPile:
                variable = "    private int " + rColorlessDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessDrawP + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackTopDrawPile:
                variable = "    private int " + rAttackTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackTopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillTopDrawPile:
                variable = "    private int " + rSkillTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillTopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerTopDrawPile:
                variable = "    private int " + rPowerTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerTopDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessTopDrawPile:
                variable = "    private int " + rColorlessTopDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessTopDrawP + " = " + upgradeValue + ";\n";
                break;

            case addRandomAttackBotDrawPile:
                variable = "    private int " + rAttackBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rAttackBotDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomSkillBotDrawPile:
                variable = "    private int " + rSkillBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rSkillBotDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomPowerBotDrawPile:
                variable = "    private int " + rPowerBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rPowerBotDrawP + " = " + upgradeValue + ";\n";
                break;
            case addRandomColorlessBotDrawPile:
                variable = "    private int " + rColorlessBotDrawP + " = " + value + ";\n" +
                        "    private final int UPGRADE_" + rColorlessBotDrawP + " = " + upgradeValue + ";\n";
                break;
*/

    /*  case addRandomAttackHand:
                action = "         AddRandomCardHand(" + rAttackHand + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillHand:
                action = "         AddRandomCardHand(" + rSkillHand + ",CardType.SKILL);\n";
                break;
            case addRandomPowerHand:
                action = "         AddRandomCardHand(" + rPowerHand + ",CardType.POWER);\n";
                break;
            case addRandomColorlessHand:
                action = "         AddRandomColorless(" + rColorlessHand + ",\"Hand\");\n";
                break;

            case addRandomAttackDiscard:
                action = "         AddRandomCardDiscard(" + rAttackDisc + ",CardType.ATTACK);\n";
                break;
            case addRandomSkillDiscard:
                action = "         AddRandomCardDiscard(" + rSkillDisc + ",CardType.SKILL);\n";
                break;
            case addRandomPowerDiscard:
                action = "         AddRandomCardDiscard(" + rPowerDisc + ",CardType.POWER);\n";
                break;
            case addRandomColorlessDiscard:
                action = "         AddRandomColorless(" + rColorlessDisc + ",\"Discard\");\n";
                break;

            //-----------------------------------
            case addRandomAttackDrawPile:
                action = "         AddRandomCardDrawP(" + rAttackDrawP + ",CardType.ATTACK,\"Random\");\n";
                break;
            case addRandomSkillDrawPile:
                action = "         AddRandomCardDrawP(" + rSkillDrawP + ",CardType.SKILL,\"Random\");\n";
                break;
            case addRandomPowerDrawPile:
                action = "         AddRandomCardDrawP(" + rPowerDrawP + ",CardType.POWER,\"Random\");\n";
                break;
            case addRandomColorlessDrawPile:
                action = "         AddRandomColorless(" + rColorlessDrawP + ",\"DrawPile\");\n";
                break;

            case addRandomAttackTopDrawPile:
                action = "         AddRandomCardDrawP(" + rAttackTopDrawP + ",CardType.ATTACK,\"Top\");\n";
                break;
            case addRandomSkillTopDrawPile:
                action = "         AddRandomCardDrawP(" + rSkillTopDrawP + ",CardType.SKILL,\"Top\");\n";
                break;
            case addRandomPowerTopDrawPile:
                action = "         AddRandomCardDrawP(" + rPowerTopDrawP + ",CardType.POWER,\"Top\");\n";
                break;
            case addRandomColorlessTopDrawPile:
                action = "         AddRandomColorless(" + rColorlessTopDrawP + ",\"TopDrawPile\");\n";
                break;

            case addRandomAttackBotDrawPile:
                action = "         AddRandomCardDrawP(" + rAttackBotDrawP + ",CardType.ATTACK,\"Bot\");\n";
                break;
            case addRandomSkillBotDrawPile:
                action = "         AddRandomCardDrawP(" + rSkillBotDrawP + ",CardType.SKILL,\"Bot\");\n";
                break;
            case addRandomPowerBotDrawPile:
                action = "         AddRandomCardDrawP(" + rPowerBotDrawP + ",CardType.POWER,\"Bot\");\n";
                break;
            case addRandomColorlessBotDrawPile:
                action = "         AddRandomColorless(" + rColorlessBotDrawP + ",\"BotDrawPile\");\n";
                break;*/

    //region Add Random
           /* case addRandomAttackHand:
                Upgrade = "            " + rAttackHand + "=UPGRADE_" + rAttackHand + ";\n";
                break;
            case addRandomSkillHand:
                Upgrade = "            " + rSkillHand + "=UPGRADE_" + rSkillHand + ";\n";
                break;
            case addRandomPowerHand:
                Upgrade = "            " + rPowerHand + "=UPGRADE_" + rPowerHand + ";\n";
                break;
            case addRandomColorlessHand:
                Upgrade = "            " + rColorlessHand + "=UPGRADE_" + rColorlessHand + ";\n";
                break;

            case addRandomAttackDiscard:
                Upgrade = "            " + rAttackDisc + "=UPGRADE_" + rAttackDisc + ";\n";
                break;
            case addRandomSkillDiscard:
                Upgrade = "            " + rSkillDisc + "=UPGRADE_" + rSkillDisc + ";\n";
                break;
            case addRandomPowerDiscard:
                Upgrade = "            " + rPowerDisc + "=UPGRADE_d" + rPowerDisc + ";\n";
                break;
            case addRandomColorlessDiscard:
                Upgrade = "            " + rColorlessDisc + "=UPGRADE_" + rColorlessDisc + ";\n";
                break;

            //------------------------------
            case addRandomAttackDrawPile:
                Upgrade = "            " + rAttackDrawP + "=UPGRADE_" + rAttackDrawP + ";\n";
                break;
            case addRandomSkillDrawPile:
                Upgrade = "            " + rSkillDrawP + "=UPGRADE_" + rSkillDrawP + ";\n";
                break;
            case addRandomPowerDrawPile:
                Upgrade = "            " + rPowerDrawP + "=UPGRADE_" + rPowerDrawP + ";\n";
                break;
            case addRandomColorlessDrawPile:
                Upgrade = "            " + rColorlessDrawP + "=UPGRADE_" + rColorlessDrawP + ";\n";
                break;

            case addRandomAttackTopDrawPile:
                Upgrade = "            " + rAttackTopDrawP + "=UPGRADE_" + rAttackTopDrawP + ";\n";
                break;
            case addRandomSkillTopDrawPile:
                Upgrade = "            " + rSkillTopDrawP + "=UPGRADE_" + rSkillTopDrawP + ";\n";
                break;
            case addRandomPowerTopDrawPile:
                Upgrade = "            " + rPowerTopDrawP + "=UPGRADE_" + rPowerTopDrawP + ";\n";
                break;
            case addRandomColorlessTopDrawPile:
                Upgrade = "            " + rColorlessTopDrawP + "=UPGRADE_" + rColorlessTopDrawP + ";\n";
                break;

            case addRandomAttackBotDrawPile:
                Upgrade = "            " + rAttackBotDrawP + "=UPGRADE_" + rAttackBotDrawP + ";\n";
                break;
            case addRandomSkillBotDrawPile:
                Upgrade = "            " + rSkillBotDrawP + "=UPGRADE_" + rSkillBotDrawP + ";\n";
                break;
            case addRandomPowerBotDrawPile:
                Upgrade = "            " + rPowerBotDrawP + "=UPGRADE_" + rPowerBotDrawP + ";\n";
                break;
            case addRandomColorlessBotDrawPile:
                Upgrade = "            " + rColorlessBotDrawP + "=UPGRADE_" + rColorlessBotDrawP + ";\n";
                break;*/

    /* static final String addRandomAttackHandCopy = "AddRandomAttackCopy(Hand)";
    static final String addRandomSkillHandCopy = "AddRandomSkillCopy(Hand)";
    static final String addRandomPowerHandCopy = "AddRandomPowerCopy(Hand)";
    static final String addRandomColorlessHandCopy = "AddRandomColorlessCopy(Hand)";

    static final String addRandomAttackDiscardCopy = "AddRandomAttackCopy(Discard)";
    static final String addRandomSkillDiscardCopy = "AddRandomSkillCopy(Discard)";
    static final String addRandomPowerDiscardCopy = "AddRandomPowerCopy(Discard)";
    static final String addRandomColorlessDiscardCopy = "AddRandomColorlessCopy(Discard)";

    static final String addRandomAttackDrawPileCopy = "AddRandomAttackCopy(DrawPile)";
    static final String addRandomSkillDrawPileCopy = "AddRandomSkillCopy(DrawPile)";
    static final String addRandomPowerDrawPileCopy = "AddRandomPowerCopy(DrawPile)";
    static final String addRandomColorlessDrawPileCopy = "AddRandomColorlessCopy(DrawPile)";

    static final String addRandomAttackTopDrawPileCopy = "AddRandomAttackCopy(TopDrawPile)";
    static final String addRandomSkillTopDrawPileCopy = "AddRandomSkillCopy(TopDrawPile)";
    static final String addRandomPowerTopDrawPileCopy = "AddRandomPowerCopy(TopDrawPile)";
    static final String addRandomColorlessTopDrawPileCopy = "AddRandomColorlessCopy(TopDrawPile)";

    static final String addRandomAttackBotDrawPileCopy = "AddRandomAttackCopy(BotDrawPile)";
    static final String addRandomSkillBotDrawPileCopy = "AddRandomSkillCopy(BotDrawPile)";
    static final String addRandomPowerBotDrawPileCopy = "AddRandomPowerCopy(BotDrawPile)";
    static final String addRandomColorlessBotDrawPileCopy = "AddRandomColorlessCopy(BotDrawPile)";
    //endregion

    //region Add Random
    static final String addRandomAttackHand = "AddRandomAttack(Hand)";
    static final String addRandomSkillHand = "AddRandomSkill(Hand)";
    static final String addRandomPowerHand = "AddRandomPower(Hand)";
    static final String addRandomColorlessHand = "AddRandomColorless(Hand)";

    static final String addRandomAttackDiscard = "AddRandomAttack(Discard)";
    static final String addRandomSkillDiscard = "AddRandomSkill(Discard)";
    static final String addRandomPowerDiscard = "AddRandomPower(Discard)";
    static final String addRandomColorlessDiscard = "AddRandomColorless(Discard)";

    static final String addRandomAttackDrawPile = "AddRandomAttack(DrawPile)";
    static final String addRandomSkillDrawPile = "AddRandomSkill(DrawPile)";
    static final String addRandomPowerDrawPile = "AddRandomPower(DrawPile)";
    static final String addRandomColorlessDrawPile = "AddRandomColorless(DrawPile)";

    static final String addRandomAttackTopDrawPile = "AddRandomAttack(TopDrawPile)";
    static final String addRandomSkillTopDrawPile = "AddRandomSkill(TopDrawPile)";
    static final String addRandomPowerTopDrawPile = "AddRandomPower(TopDrawPile)";
    static final String addRandomColorlessTopDrawPile = "AddRandomColorless(TopDrawPile)";

    static final String addRandomAttackBotDrawPile = "AddRandomAttack(BotDrawPile)";
    static final String addRandomSkillBotDrawPile = "AddRandomSkill(BotDrawPile)";
    static final String addRandomPowerBotDrawPile = "AddRandomPower(BotDrawPile)";
    static final String addRandomColorlessBotDrawPile = "AddRandomColorless(BotDrawPile)";*/

    /*" + "\"" + DESCRIPTION + "\"" + "*/


    //region multiDmg utils
   /* public boolean dmgModified(int baseDmg, float tmp)
    {
        boolean isDmgModified;
        if (baseDmg != (int) tmp)
        {
            isDmgModified = true;
        } else
            isDmgModified = false;
        return isDmgModified;
    }
    public boolean dmgModified(int baseDmg, float tmp[],int i)
    {
        boolean isDmgModified;
        if (baseDmg != (int) tmp[i])
        {
            isDmgModified = true;
        } else
            isDmgModified = false;
        return isDmgModified;
    }

    public boolean RelicDmgModify(float tmp, AbstractRelic r, int baseDmg)
    {
        boolean isDmgModified;
        tmp = r.atDamageModify(tmp, this);
        isDmgModified=dmgModified(baseDmg,tmp);
        return isDmgModified;
    }

    public boolean RelicDmgModify(int i, float tmp[], AbstractRelic r, int baseDmg)
    {
        boolean isDmgModified;
        tmp[i] = r.atDamageModify(tmp[i], this);
        isDmgModified=dmgModified(baseDmg,tmp,i);
        return isDmgModified;
    }

    public void SetDmgZero(float tmp[], int i)
    {
        if (tmp[i] < 0.0F)
        {
            tmp[i] = 0.0F;
        }
    }

    public boolean SetMultiDmg(float tmp[], int i, int baseDmg)
    {
        boolean isDmgModified;
        isDmgModified=dmgModified(baseDmg,tmp,i);
        return isDmgModified;
    }

    public boolean PowerDmgModify(Iterator var3, AbstractPlayer player, float tmp, int baseDmg)
    {
        AbstractPower p;
        boolean isDmgModified;
        for (var3 = player.powers.iterator(); var3.hasNext(); tmp = p.atDamageGive(tmp, this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var3.next();
        }

        tmp = player.stance.atDamageGive(tmp, this.damageTypeForTurn, this);

        isDmgModified=dmgModified(baseDmg,tmp);

        for (var3 = player.powers.iterator(); var3.hasNext(); tmp = p.atDamageFinalGive(tmp, this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var3.next();
        }

        if (tmp < 0.0F)
        {
            tmp = 0.0F;
        }

        if (baseDmg != MathUtils.floor(tmp))
        {
            isDmgModified = true;
        }
        return isDmgModified;
        //return dmg = MathUtils.floor(tmp);

    }

    public boolean PowerDmgModifyCal(Iterator var9, AbstractPlayer player, float tmp, AbstractPower p, AbstractMonster mo, int baseDmg)
    {
        boolean isDmgModified;
        for (var9 = player.powers.iterator(); var9.hasNext(); tmp = p.atDamageGive(tmp, this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var9.next();
        }

        tmp = player.stance.atDamageGive(tmp, this.damageTypeForTurn, this);

        isDmgModified=dmgModified(baseDmg,tmp);

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmp = p.atDamageReceive(tmp, this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var9.next();
        }

        for (var9 = player.powers.iterator(); var9.hasNext(); tmp = p.atDamageFinalGive(tmp, this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var9.next();
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmp = p.atDamageFinalReceive(tmp, this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var9.next();
        }

        if (tmp < 0.0F)
        {
            tmp = 0.0F;
        }

        if (baseDmg != MathUtils.floor(tmp))
        {
            isDmgModified = true;
        }

        return isDmgModified;
        //return dmg = MathUtils.floor(tmp);

    }

    public boolean AtDmgGive(Iterator var, AbstractPlayer player, float tmp[], int i, AbstractPower p, int baseDmg)
    {
        boolean isDmgModified;
        for (var = player.powers.iterator(); var.hasNext(); tmp[i] = p.atDamageGive(tmp[i], this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var.next();
        }

        tmp[i] = player.stance.atDamageGive(tmp[i], this.damageTypeForTurn, this);
        isDmgModified=dmgModified(baseDmg,tmp,i);

        return isDmgModified;
    }

    public void AtFinalDmgGive(Iterator var, AbstractPlayer player, float tmp[], int i, AbstractPower p)
    {
        for (var = player.powers.iterator(); var.hasNext(); tmp[i] = p.atDamageFinalGive(tmp[i], this.damageTypeForTurn, this))
        {
            p = (AbstractPower) var.next();
        }
    }

    //endregion

    public void applyPowers()
    {
        this.applyPowersToBlock();
        AbstractPlayer player = AbstractDungeon.player;
        this.isDPEModified = false;
        this.isVampDmgModified = false;
        this.isDamageModified = false;
        if (!this.isMultiDamage)
        {
            float tmpDmg = (float) this.baseDamage;
            float tmpDPE = (float) this.baseDmgPerEnergy;
            float tmpVampDmg = (float) this.baseVampDmg;

            Iterator var3 = player.relics.iterator();

            while (var3.hasNext())
            {
                AbstractRelic r = (AbstractRelic) var3.next();
                this.isDamageModified = RelicDmgModify(tmpDmg, r, this.baseDamage);
                this.isDPEModified=RelicDmgModify(tmpDPE, r, this.baseDmgPerEnergy);
                this.isVampDmgModified=RelicDmgModify(tmpVampDmg, r, this.baseVampDmg);
            }
            AbstractPower p;
            this.isDamageModified = PowerDmgModify(var3, player, tmpDmg, this.baseDamage);
            this.isDPEModified = PowerDmgModify(var3, player, tmpDPE, this.baseDmgPerEnergy);
            this.isVampDmgModified = PowerDmgModify(var3, player, tmpVampDmg, this.baseVampDmg);

            this.damage = MathUtils.floor(tmpDmg);
            this.dmgPerEnergy = MathUtils.floor(tmpDPE);
            this.vampDmg = MathUtils.floor(tmpVampDmg);
        } else
        {
            ArrayList<AbstractMonster> m = AbstractDungeon.getCurrRoom().monsters.monsters;
            float[] tmpDmg = new float[m.size()];
            float[] tmpDPE = new float[m.size()];
            float[] tmpVampDmg = new float[m.size()];

            int i;
            for (i = 0; i < tmpDPE.length; ++i)
            {
                tmpDmg[i] = (float) this.damage;
                tmpDPE[i] = (float) this.dmgPerEnergy;
                tmpVampDmg[i] = (float) this.vampDmg;
            }

            Iterator var5 = null;
            AbstractPower p = null;
            for (i = 0; i < tmpDPE.length; ++i)
            {
                var5 = player.relics.iterator();

                while (var5.hasNext())
                {
                    AbstractRelic r = (AbstractRelic) var5.next();
                    this.isDamageModified=RelicDmgModify(i, tmpDmg, r, this.baseDamage);
                    this.isDPEModified=RelicDmgModify(i, tmpDPE, r, this.baseDmgPerEnergy);
                    this.isVampDmgModified=RelicDmgModify(i, tmpVampDmg, r, this.baseVampDmg);

                }
                this.isDamageModified=AtDmgGive(var5, player, tmpDmg, i, p, this.baseDamage);
                this.isDPEModified= AtDmgGive(var5, player, tmpDPE, i, p, this.baseDmgPerEnergy);
                this.isVampDmgModified=AtDmgGive(var5, player, tmpVampDmg, i, p, this.baseVampDmg);
            }

            for (i = 0; i < tmpDPE.length; ++i)
            {
                AtFinalDmgGive(var5, player, tmpDmg, i, p);
                AtFinalDmgGive(var5, player, tmpDPE, i, p);
                AtFinalDmgGive(var5, player, tmpVampDmg, i, p);

            }

            for (i = 0; i < tmpDPE.length; ++i)
            {
                SetDmgZero(tmpDmg, i);
                SetDmgZero(tmpDPE, i);
                SetDmgZero(tmpVampDmg, i);
            }
            this.multiDamage = new int[tmpDmg.length];
            this.multiDPE = new int[tmpDPE.length];
            this.multiVampDmg = new int[tmpVampDmg.length];

            for (i = 0; i < tmpDPE.length; ++i)
            {
                this.isDamageModified=SetMultiDmg(tmpDmg, i, this.baseDamage);
                this.isDPEModified=SetMultiDmg(tmpDPE, i, this.baseDmgPerEnergy);
                this.isVampDmgModified=SetMultiDmg(tmpVampDmg, i, this.baseVampDmg);

                this.multiDamage[i] = MathUtils.floor(tmpDmg[i]);
                this.multiDPE[i] = MathUtils.floor(tmpDPE[i]);
                this.multiVampDmg[i] = MathUtils.floor(tmpVampDmg[i]);

            }
            this.damage = this.multiDamage[0];
            this.dmgPerEnergy = this.multiDPE[0];
            this.vampDmg = this.multiVampDmg[0];
        }
    }


    public void calculateCardDamage(AbstractMonster mo)
    {
        this.applyPowersToBlock();
        AbstractPlayer player = AbstractDungeon.player;

        this.isDPEModified = false;
        this.isVampDmgModified = false;
        this.isDamageModified = false;

        if (!this.isMultiDamage && mo != null)
        {
            float tmpDPE = (float) this.baseDmgPerEnergy;
            float tmpVampDmg = (float) this.baseVampDmg;
            float tmpDmg = (float) this.baseDamage;

            Iterator var9 = player.relics.iterator();

            while (var9.hasNext())
            {
                AbstractRelic r = (AbstractRelic) var9.next();
                this.isDPEModified = RelicDmgModify(tmpDPE, r, this.baseDmgPerEnergy);
                this.isVampDmgModified = RelicDmgModify(tmpVampDmg, r, this.baseVampDmg);
                this.isDamageModified = RelicDmgModify(tmpDmg, r, this.baseDamage);

            }

            AbstractPower p = null;
            this.isDPEModified =PowerDmgModifyCal(var9, player, tmpDPE, p, mo, this.baseDmgPerEnergy);
            this.isVampDmgModified =PowerDmgModifyCal(var9, player, tmpVampDmg, p, mo, this.baseVampDmg);
            this.isDamageModified = PowerDmgModifyCal(var9, player, tmpDmg, p, mo, this.baseDamage);

            this.damage = MathUtils.floor(tmpDmg);
            this.dmgPerEnergy = MathUtils.floor(tmpDPE);
            this.vampDmg = MathUtils.floor(tmpVampDmg);
        } else
        {
            ArrayList<AbstractMonster> m = AbstractDungeon.getCurrRoom().monsters.monsters;
            float[] tmpDPE = new float[m.size()];
            float[] tmpVampDmg = new float[m.size()];
            float[] tmpDmg = new float[m.size()];

            int i;
            for (i = 0; i < tmpDPE.length; ++i)
            {
                tmpDPE[i] = (float) this.baseDmgPerEnergy;
                tmpVampDmg[i] = (float) this.baseVampDmg;
                tmpDmg[i] = (float) this.baseDamage;
            }

            Iterator var6 = null;
            AbstractPower p = null;
            for (i = 0; i < tmpDPE.length; ++i)
            {
                var6 = player.relics.iterator();

                while (var6.hasNext())
                {
                    AbstractRelic r = (AbstractRelic) var6.next();

                    this.isDPEModified=RelicDmgModify(i, tmpDPE, r, this.baseDmgPerEnergy);
                    this.isVampDmgModified=RelicDmgModify(i, tmpVampDmg, r, this.baseVampDmg);
                    this.isDamageModified=RelicDmgModify(i, tmpDmg, r, this.baseDamage);

                }

                this.isDPEModified=AtDmgGive(var6, player, tmpDPE, i, p, this.baseDmgPerEnergy);
                this.isVampDmgModified=AtDmgGive(var6, player, tmpVampDmg, i, p, this.baseVampDmg);
                this.isDamageModified=AtDmgGive(var6, player, tmpDmg, i, p, this.baseDamage);

            }

            for (i = 0; i < tmpDPE.length; ++i)
            {
                var6 = ((AbstractMonster) m.get(i)).powers.iterator();

                while (var6.hasNext())
                {
                    p = (AbstractPower) var6.next();
                    if (!((AbstractMonster) m.get(i)).isDying && !((AbstractMonster) m.get(i)).isEscaping)
                    {
                        tmpDPE[i] = p.atDamageReceive(tmpDPE[i], this.damageTypeForTurn, this);
                        tmpVampDmg[i] = p.atDamageReceive(tmpVampDmg[i], this.damageTypeForTurn, this);
                        tmpDmg[i] = p.atDamageReceive(tmpDmg[i], this.damageTypeForTurn, this);
                    }
                }
            }

            for (i = 0; i < tmpDPE.length; ++i)
            {
                AtFinalDmgGive(var6, player, tmpDPE, i, p);
                AtFinalDmgGive(var6, player, tmpVampDmg, i, p);
                AtFinalDmgGive(var6, player, tmpDmg, i, p);

            }

            for (i = 0; i < tmpDPE.length; ++i)
            {
                var6 = ((AbstractMonster) m.get(i)).powers.iterator();

                while (var6.hasNext())
                {
                    p = (AbstractPower) var6.next();
                    if (!((AbstractMonster) m.get(i)).isDying && !((AbstractMonster) m.get(i)).isEscaping)
                    {
                        tmpDPE[i] = p.atDamageFinalReceive(tmpDPE[i], this.damageTypeForTurn, this);
                        tmpVampDmg[i] = p.atDamageFinalReceive(tmpVampDmg[i], this.damageTypeForTurn, this);
                        tmpDmg[i] = p.atDamageFinalReceive(tmpDmg[i], this.damageTypeForTurn, this);
                    }
                }
            }

            for (i = 0; i < tmpDPE.length; ++i)
            {
                SetDmgZero(tmpDPE, i);
                SetDmgZero(tmpVampDmg, i);
                SetDmgZero(tmpDmg, i);


            }

            this.multiDPE = new int[tmpDPE.length];
            this.multiVampDmg = new int[tmpVampDmg.length];
            this.multiDamage = new int[tmpDmg.length];

            for (i = 0; i < tmpDPE.length; ++i)
            {
                this.isDPEModified=SetMultiDmg(tmpDPE, i, this.baseDmgPerEnergy);
                this.isVampDmgModified=SetMultiDmg(tmpVampDmg, i, this.baseVampDmg);
                this.isDamageModified=SetMultiDmg(tmpDmg, i, this.baseDamage);

                this.multiDamage[i] = MathUtils.floor(tmpDmg[i]);
                this.multiDPE[i] = MathUtils.floor(tmpDPE[i]);
                this.multiVampDmg[i] = MathUtils.floor(tmpVampDmg[i]);

            }

            this.dmgPerEnergy = this.multiDPE[0];
            this.vampDmg = this.multiVampDmg[0];
            this.damage = this.multiDamage[0];
        }

    }*/
}
