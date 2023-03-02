package suikaMod.cards;

import basemod.abstracts.CustomCard;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractDefaultCard extends CustomCard
{

    // Custom Abstract Cards can be a bit confusing. While this is a simple base for simply adding a second magic number,
    // if you're new to modding I suggest you skip this file until you know what unique things that aren't provided
    // by default, that you need in your own cards.

    // In this example, we use a custom Abstract Card in order to define a new magic number. From here on out, we can
    // simply use that in our cards, so long as we put "extends AbstractDynamicCard" instead of "extends CustomCard" at the start.
    // In simple terms, it's for things that we don't want to define again and again in every single card we make.

    //region dmg
    public int dmgPerEnergy; //DPE
    public int baseDmgPerEnergy;

    public int multiDPE[];

    public boolean upgradedDPE;
    public boolean isDPEModified;

    public int vampDmg;
    public int baseVampDmg;

    public int multiVampDmg[];

    public boolean upgradedVampDmg;
    public boolean isVampDmgModified;

    //endregion


    //region vulnerable
    public int aVulnerableValue;        // Just like magic number, or any number for that matter, we want our regular, modifiable stat
    public int aBaseVulnerableValue;    // And our base stat - the number in it's base state. It will reset to that by default.
    public boolean aUpgradedVulnerableValue; // A boolean to check whether the number has been upgraded or not.
    public boolean aIsVulnerableValueModified; // A boolean to check whether the number has been modified or not, for coloring purposes. (red/green)

    public int gVulnerableValue;
    public int gBaseVulnerableValue;
    public boolean gUpgradedVulnerableValue;
    public boolean gIsVulnerableValueModified;
    //endregion

    //region weak
    public int aWeakValue;
    public int aBaseWeakValue;
    public boolean aUpgradedWeakValue;
    public boolean aIsWeakValueModified;

    public int gWeakValue;
    public int gBaseWeakValue;
    public boolean gUpgradedWeakValue;
    public boolean gIsWeakValueModified;
    //endregion

    //region poison
    public int aPoisonValue;
    public int aBasePoisonValue;
    public boolean aUpgradedPoisonValue;
    public boolean aIsPoisonValueModified;

    public int gPoisonValue;
    public int gBasePoisonValue;
    public boolean gUpgradedPoisonValue;
    public boolean gIsPoisonValueModified;
    //endregion

    //region str
    public int aStrValue;
    public int aBaseStrValue;
    public boolean aUpgradedStrValue;
    public boolean aIsStrValueModified;

    public int gStrValue;
    public int gBaseStrValue;
    public boolean gUpgradedStrValue;
    public boolean gIsStrValueModified;
    //endregion


    public AbstractDefaultCard(final String id,
                               final String name,
                               final String img,
                               final int cost,
                               final String rawDescription,
                               final CardType type,
                               final CardColor color,
                               final CardRarity rarity,
                               final CardTarget target)
    {

        super(id, name, img, cost, rawDescription, type, color, rarity, target);

        // Set all the things to their default values.
        isCostModified = false;
        isCostModifiedForTurn = false;


        isDamageModified = false;

        isDPEModified = false;
        isVampDmgModified = false;

        isBlockModified = false;

        isMagicNumberModified = false;

        aIsVulnerableValueModified = false;
        aIsWeakValueModified = false;
        aIsPoisonValueModified = false;
        aIsStrValueModified = false;

        gIsVulnerableValueModified = false;
        gIsWeakValueModified = false;
        gIsPoisonValueModified = false;
        gIsStrValueModified = false;
    }

    public void displayUpgrades()
    { // Display the upgrade - when you click a card to upgrade it
        super.displayUpgrades();

        if (upgradedDPE)
        {
            dmgPerEnergy = baseDmgPerEnergy;
            isDPEModified = true;
        }

        if (upgradedVampDmg)
        {
            vampDmg = baseVampDmg;
            isVampDmgModified = true;
        }

        if (aUpgradedVulnerableValue)
        { // If we set upgradedDefaultSecondMagicNumber = true in our card.
            aVulnerableValue = aBaseVulnerableValue; // Show how the number changes, as out of combat, the base number of a card is shown.
            aIsVulnerableValueModified = true; // Modified = true, color it green to highlight that the number is being changed.
        }

        //region buff/debuff
        if (aUpgradedWeakValue)
        {
            aWeakValue = aBaseWeakValue;
            aIsWeakValueModified = true;
        }

        if (aUpgradedPoisonValue)
        {
            aPoisonValue = aBasePoisonValue;
            aIsPoisonValueModified = true;
        }

        if (aUpgradedStrValue)
        {
            aStrValue = aBaseStrValue;
            aIsStrValueModified = true;
        }

        if (gUpgradedVulnerableValue)
        {
            gVulnerableValue = gBaseVulnerableValue;
            gIsVulnerableValueModified = true;
        }

        if (gUpgradedWeakValue)
        {
            gWeakValue = gBaseWeakValue;
            gIsWeakValueModified = true;
        }

        if (gUpgradedPoisonValue)
        {
            gPoisonValue = gBasePoisonValue;
            gIsPoisonValueModified = true;
        }

        if (gUpgradedStrValue)
        {
            gStrValue = gBaseStrValue;
            gIsStrValueModified = true;
        }
        //endregion
    }

    //region Upgrade
    @Override
    protected void upgradeDamage(int amount)
    {
        this.baseDamage = amount;
        this.upgradedDamage = true;
    }

    protected void upgradeDPE(int amount)
    {
        this.baseDmgPerEnergy = amount;
        this.upgradedDPE = true;
    }

    protected void upgradeVampDmg(int amount)
    {
        this.baseVampDmg = amount;
        this.upgradedVampDmg = true;
    }

    @Override
    protected void upgradeBlock(int amount)
    {
        this.baseBlock = amount;
        this.upgradedBlock = true;
    }

    @Override
    protected void upgradeMagicNumber(int amount)
    {
        this.baseMagicNumber = amount;
        this.magicNumber = this.baseMagicNumber;
        this.upgradedMagicNumber = true;
    }

    //region Apply
    public void upgradeAVulnerableValue(int amount)
    { // If we're upgrading (read: changing) the number. Note "upgrade" and NOT "upgraded" - 2 different things. One is a boolean, and then this one is what you will usually use - change the integer by how much you want to upgrade.
        aBaseVulnerableValue = amount; // Upgrade the number by the amount you provide in your card.
        aVulnerableValue = aBaseVulnerableValue; // Set the number to be equal to the base value.
        aUpgradedVulnerableValue = true; // Upgraded = true - which does what the above method does.
    }

/*    public void upgradeAValues(int amount, int baseValue, int value, boolean upgradeBool)
    {
        baseValue = amount;
        value = baseValue;
        upgradeBool = true;
    }*/

    public void upgradeAWeakValue(int amount)
    {
        aBaseWeakValue = amount;
        aWeakValue = aBaseWeakValue;
        aUpgradedWeakValue = true;
    }

    public void upgradeAPoisonValue(int amount)
    {
        aBasePoisonValue = amount;
        aPoisonValue = aBasePoisonValue;
        aUpgradedPoisonValue = true;
    }

    public void upgradeAStrValue(int amount)
    {
        aBaseStrValue = amount;
        aStrValue = aBaseStrValue;
        aUpgradedStrValue = true;
    }
    //endregion

    //region Gain

    public void upgradeGVulnerableValue(int amount)
    {
        gBaseVulnerableValue = amount;
        gVulnerableValue = gBaseVulnerableValue;
        gUpgradedVulnerableValue = true;
    }

    public void upgradeGWeakValue(int amount)
    {
        gBaseWeakValue = amount;
        gWeakValue = gBaseWeakValue;
        gUpgradedWeakValue = true;
    }

    public void upgradeGPoisonValue(int amount)
    {
        gBasePoisonValue = amount;
        gPoisonValue = gBasePoisonValue;
        gUpgradedPoisonValue = true;
    }

    public void upgradeGStrValue(int amount)
    {
        gBaseStrValue = amount;
        gStrValue = gBaseStrValue;
        gUpgradedStrValue = true;
    }

    //endregion
    //endregion

    //region Add Cards
    public void AddRandomCardHand(int time, CardType type)
    {
        for (int i = 0; i < time; i++)
        {
            AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();
            this.addToBot(new MakeTempCardInHandAction(c, true));
        }
    }

    public void AddRandomCardDiscard(int time, CardType type)
    {
        for (int i = 0; i < time; i++)
        {
            AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();
            this.addToBot(new MakeTempCardInDiscardAction(c, true));
        }
    }

    public void AddRandomColorless(int time, String where)
    {
        switch (where)
        {
            case "Hand":
                for (int i = 0; i < time; i++)
                {
                    AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();
                    this.addToBot(new MakeTempCardInHandAction(c, true));
                }
                break;
            case "Discard":
                for (int i = 0; i < time; i++)
                {
                    AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();
                    this.addToBot(new MakeTempCardInDiscardAction(c, true));
                }
                break;
            case "DrawPile":
                for (int i = 0; i < time; i++)
                {
                    AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();

                    this.addToBot(new MakeTempCardInDrawPileAction(c, 1, true, true));
                }
                break;
            case "TopDrawPile":
                for (int i = 0; i < time; i++)
                {
                    AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();

                    this.addToBot(new MakeTempCardInDrawPileAction(c, 1, false, false, false));
                }
                break;
            case "BotDrawPile":
                for (int i = 0; i < time; i++)
                {
                    AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();

                    this.addToBot(new MakeTempCardInDrawPileAction(c, 1, false, false, true));
                }
                break;
            default:
                break;
        }
    }

    public void AddRandomCardDrawP(int time, CardType type, String position)
    {
        if (position.equals("Random"))
        {
            for (int i = 0; i < time; i++)
            {
                AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();

                this.addToBot(new MakeTempCardInDrawPileAction(c, 1, true, true));
            }
        } else if (position.equals("Top"))
        {
            for (int i = 0; i < time; i++)
            {
                AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();

                this.addToBot(new MakeTempCardInDrawPileAction(c, 1, false, false, false));
            }
        } else if (position.equals("Bot"))
        {
            for (int i = 0; i < time; i++)
            {
                AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();

                this.addToBot(new MakeTempCardInDrawPileAction(c, 1, false, false, true));
            }
        }
    }


    public void AddRandomCardHandCopy(int time, CardType type)
    {
        AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();
        this.addToBot(new MakeTempCardInHandAction(c.makeStatEquivalentCopy(), time, true));
    }


    public void AddRandomCardDiscardCopy(int time, CardType type)
    {

        AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();
        for (int i = 0; i < time; i++)
        {
            this.addToBot(new MakeTempCardInDiscardAction(c.makeStatEquivalentCopy(), true));
        }

    }

    public void AddRandomCardDrawPCopy(int time, CardType type, String position)
    {
        AbstractCard c = AbstractDungeon.returnTrulyRandomCardInCombat(type).makeCopy();

        if (position.equals("Random"))
        {
            this.addToBot(new MakeTempCardInDrawPileAction(c.makeStatEquivalentCopy(), time, true, true));

        } else if (position.equals("Top"))
        {
            this.addToBot(new MakeTempCardInDrawPileAction(c.makeStatEquivalentCopy(), time, false, false, false));

        } else if (position.equals("Bot"))
        {
            this.addToBot(new MakeTempCardInDrawPileAction(c.makeStatEquivalentCopy(), time, false, false, true));

        }
    }

    public void AddRandomColorlessCopy(int time, String where)
    {
        AbstractCard c = AbstractDungeon.returnTrulyRandomColorlessCardInCombat(AbstractDungeon.cardRandomRng).makeCopy();

        switch (where)
        {
            case "Hand":
                this.addToBot(new MakeTempCardInHandAction(c.makeStatEquivalentCopy(), time, true));
                break;
            case "Discard":
                for (int i = 0; i < time; i++)
                {
                    this.addToBot(new MakeTempCardInDiscardAction(c.makeStatEquivalentCopy(), true));
                }
                break;
            case "DrawPile":
                this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), time, true, true));
                break;
            case "TopDrawPile":
                this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), time, false, false, false));
                break;
            case "BotDrawPile":
                this.addToBot(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), time, false, false, true));
                break;
            default:
                break;
        }
    }

    //endregion

    //region baseMultiDmg

    //region PowerApply
    AbstractPlayer player;

    //region single Apply utils
    float tmpDmg;
    float tmpDPE;
    float tmpVampDmg;
    Iterator var3;
    AbstractPower pApply;

    public void DmgModifySetFalse()
    {
        this.isDamageModified = false;
        this.isDPEModified = false;
        this.isVampDmgModified = false;
    }
    public void SetTmp()
    {
        tmpDmg = (float) this.baseDamage;
        tmpDPE = (float) this.baseDmgPerEnergy;
        tmpVampDmg = (float) this.baseVampDmg;
    }
    public void SetRelicModifier()
    {
        var3 = player.relics.iterator();

        while (var3.hasNext())
        {
            AbstractRelic r = (AbstractRelic) var3.next();

            //region relic dmg modify
            tmpDmg = r.atDamageModify(tmpDmg, this);
            tmpDPE = r.atDamageModify(tmpDPE, this);
            tmpVampDmg = r.atDamageModify(tmpVampDmg, this);
            SetDmgModifierBool();

            //endregion
        }
    }
    public void SetDmgModifierBool()
    {
        if (this.baseDamage != (int) tmpDmg)
        {
            this.isDamageModified = true;
        }
        if (this.baseDmgPerEnergy != (int) tmpDPE)
        {
            this.isDPEModified = true;
        }
        if (this.baseVampDmg != (int) tmpVampDmg)
        {
            this.isVampDmgModified = true;
        }

    }
    public void AtDmgGiveLoop()
    {
        for (var3 = player.powers.iterator(); var3.hasNext(); tmpDmg = pApply.atDamageGive(tmpDmg, this.damageTypeForTurn, this))
        {
            pApply = (AbstractPower) var3.next();
        }
        for (var3 = player.powers.iterator(); var3.hasNext(); tmpDPE = pApply.atDamageGive(tmpDPE, this.damageTypeForTurn, this))
        {
            pApply = (AbstractPower) var3.next();
        }
        for (var3 = player.powers.iterator(); var3.hasNext(); tmpVampDmg = pApply.atDamageGive(tmpVampDmg, this.damageTypeForTurn, this))
        {
            pApply = (AbstractPower) var3.next();
        }
    }
    public void AtDmgGive()
    {
        tmpDmg = player.stance.atDamageGive(tmpDmg, this.damageTypeForTurn, this);
        tmpDPE = player.stance.atDamageGive(tmpDPE, this.damageTypeForTurn, this);
        tmpVampDmg = player.stance.atDamageGive(tmpVampDmg, this.damageTypeForTurn, this);

        SetDmgModifierBool();
    }
    public void AtDmgFinalLoop()
    {
        for (var3 = player.powers.iterator(); var3.hasNext(); tmpDmg = pApply.atDamageFinalGive(tmpDmg, this.damageTypeForTurn, this))
        {
            pApply = (AbstractPower) var3.next();
        }
        for (var3 = player.powers.iterator(); var3.hasNext(); tmpDPE = pApply.atDamageFinalGive(tmpDPE, this.damageTypeForTurn, this))
        {
            pApply = (AbstractPower) var3.next();
        }
        for (var3 = player.powers.iterator(); var3.hasNext(); tmpVampDmg = pApply.atDamageFinalGive(tmpVampDmg, this.damageTypeForTurn, this))
        {
            pApply = (AbstractPower) var3.next();
        }
    }
    public void SetTmpZero()
    {
        if (tmpDmg < 0.0F)
        {
            tmpDmg = 0.0F;
        }
        if (tmpDPE < 0.0F)
        {
            tmpDPE = 0.0F;
        }
        if (tmpVampDmg < 0.0F)
        {
            tmpVampDmg = 0.0F;
        }
    }
    public void SetDmgFinal()
    {
        SetTmpZero();

        if (this.baseDamage != MathUtils.floor(tmpDmg))
        {
            this.isDamageModified = true;
        }
        if (this.baseDmgPerEnergy != MathUtils.floor(tmpDPE))
        {
            this.isDPEModified = true;
        }
        if (this.baseVampDmg != MathUtils.floor(tmpVampDmg))
        {
            this.isVampDmgModified = true;
        }

        this.damage = MathUtils.floor(tmpDmg);
        this.dmgPerEnergy = MathUtils.floor(tmpDPE);
        this.vampDmg = MathUtils.floor(tmpVampDmg);

    }


    //endregion

    //region multi Apply utils
    float tmpMonsterCount[];
    float tmpDmgMulti[];
    float tmpDPEMulti[];
    float tmpVampDmgMulti[];

    ArrayList<AbstractMonster> m;

    Iterator var5;
    AbstractPower pMultiApply;

    public void InitTmpMulti()
    {
        m = AbstractDungeon.getCurrRoom().monsters.monsters;
        tmpMonsterCount = new float[m.size()];
        tmpDmgMulti = new float[m.size()];
        tmpDPEMulti = new float[m.size()];
        tmpVampDmgMulti = new float[m.size()];
    }

    public void SetTmpMulti(int i)
    {
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            tmpDmgMulti[i] = (float) this.baseDamage;
            tmpDPEMulti[i] = (float) this.baseDmgPerEnergy;
            tmpVampDmgMulti[i] = (float) this.baseVampDmg;
        }
    }

    public void SetDmgModifierMultiBool(int i)
    {
        if (this.baseDamage != (int) tmpDmgMulti[i])
        {
            this.isDamageModified = true;
        }
        if (this.baseDmgPerEnergy != (int) tmpDPEMulti[i])
        {
            this.isDPEModified = true;
        }
        if (this.baseVampDmg != (int) tmpVampDmgMulti[i])
        {
            this.isVampDmgModified = true;
        }
    }

    public void SetRelicModifierMulti(int i)
    {
        var5 = player.relics.iterator();

        while (var5.hasNext())
        {
            AbstractRelic r = (AbstractRelic) var5.next();
            tmpDmgMulti[i] = r.atDamageModify(tmpDmgMulti[i], this);
            tmpDPEMulti[i] = r.atDamageModify(tmpDPEMulti[i], this);
            tmpVampDmgMulti[i] = r.atDamageModify(tmpVampDmgMulti[i], this);

            SetDmgModifierMultiBool(i);
        }
    }

    public void AtDmgGiveLoopMulti(int i)
    {
        for (var5 = player.powers.iterator(); var5.hasNext(); tmpDmgMulti[i] = pMultiApply.atDamageGive(tmpDmgMulti[i], this.damageTypeForTurn, this))
        {
            pMultiApply = (AbstractPower) var5.next();
        }
        for (var5 = player.powers.iterator(); var5.hasNext(); tmpDPEMulti[i] = pMultiApply.atDamageGive(tmpDPEMulti[i], this.damageTypeForTurn, this))
        {
            pMultiApply = (AbstractPower) var5.next();
        }
        for (var5 = player.powers.iterator(); var5.hasNext(); tmpVampDmgMulti[i] = pMultiApply.atDamageGive(tmpVampDmgMulti[i], this.damageTypeForTurn, this))
        {
            pMultiApply = (AbstractPower) var5.next();
        }
    }

    public void AtDmgGiveMulti(int i)
    {
        tmpDmgMulti[i] = player.stance.atDamageGive(tmpDmgMulti[i], this.damageTypeForTurn, this);
        tmpDPEMulti[i] = player.stance.atDamageGive(tmpDPEMulti[i], this.damageTypeForTurn, this);
        tmpVampDmgMulti[i] = player.stance.atDamageGive(tmpVampDmgMulti[i], this.damageTypeForTurn, this);

        SetDmgModifierMultiBool(i);
    }

    public void AtDmgFinalLoopMulti(int i)
    {
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            for (var5 = player.powers.iterator(); var5.hasNext(); tmpDmgMulti[i] = pMultiApply.atDamageFinalGive(tmpDmgMulti[i], this.damageTypeForTurn, this))
            {
                pMultiApply = (AbstractPower) var5.next();
            }
            for (var5 = player.powers.iterator(); var5.hasNext(); tmpDPEMulti[i] = pMultiApply.atDamageFinalGive(tmpDPEMulti[i], this.damageTypeForTurn, this))
            {
                pMultiApply = (AbstractPower) var5.next();
            }
            for (var5 = player.powers.iterator(); var5.hasNext(); tmpVampDmgMulti[i] = pMultiApply.atDamageFinalGive(tmpVampDmgMulti[i], this.damageTypeForTurn, this))
            {
                pMultiApply = (AbstractPower) var5.next();
            }
        }
    }

    public void SetTmpZeroMulti(int i)
    {
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            if (tmpDmgMulti[i] < 0.0F)
            {
                tmpDmgMulti[i] = 0.0F;
            }
            if (tmpDPEMulti[i] < 0.0F)
            {
                tmpDPEMulti[i] = 0.0F;
            }
            if (tmpVampDmgMulti[i] < 0.0F)
            {
                tmpVampDmgMulti[i] = 0.0F;
            }
        }
        this.multiDamage = new int[tmpDmgMulti.length];
        this.multiDPE = new int[tmpDPEMulti.length];
        this.multiVampDmg = new int[tmpVampDmgMulti.length];
    }

    public void SetDmgFinalMulti(int i)
    {
        SetTmpZeroMulti(i);

        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            this.multiDamage[i] = MathUtils.floor(tmpDmgMulti[i]);
            this.multiDPE[i] = MathUtils.floor(tmpDPEMulti[i]);
            this.multiVampDmg[i] = MathUtils.floor(tmpVampDmgMulti[i]);

            SetDmgModifierMultiBool(i);
        }

        this.damage = this.multiDamage[0];
        this.dmgPerEnergy = this.multiDPE[0];
        this.vampDmg = this.multiVampDmg[0];
    }

    //endregion
    public void applyPowers()
    {
        this.applyPowersToBlock();
        player = AbstractDungeon.player;

        DmgModifySetFalse();

        if (!this.isMultiDamage)
        {
            SetTmp();

            SetRelicModifier();

            AtDmgGiveLoop();

            AtDmgGive();

            AtDmgFinalLoop();

            SetDmgFinal();
        } else
        {
            InitTmpMulti();
            int i = 0;
            SetTmpMulti(i);

            for (i = 0; i < tmpMonsterCount.length; ++i)
            {
                SetRelicModifierMulti(i);
                AtDmgGiveLoopMulti(i);

                AtDmgGiveMulti(i);

            }
            AtDmgFinalLoopMulti(i);
            SetDmgFinalMulti(i);
        }

    }
    //endregion

    //region DmgCal

    //region dmgCal Single
    AbstractPower pCal;
    Iterator var9;

    public void SetRelicModifierCal()
    {
        var9 = player.relics.iterator();

        while (var9.hasNext())
        {
            AbstractRelic r = (AbstractRelic) var9.next();

            //region setDmgModfiy
            tmpDmg = r.atDamageModify(tmpDmg, this);
            tmpDPE = r.atDamageModify(tmpDPE, this);
            tmpVampDmg = r.atDamageModify(tmpVampDmg, this);
            SetDmgModifierBool();

/*            if (this.baseDamage != (int) tmpDmg)
            {
                this.isDamageModified = true;
            }
            if (this.baseDmgPerEnergy != (int) tmpDPE)
            {
                this.isDPEModified = true;
            }
            if (this.baseVampDmg != (int) tmpVampDmg)
            {
                this.isVampDmgModified = true;
            }*/
            //endregion
        }
    }

    public void AtDmgGiveLoopCal()
    {

        for (var9 = player.powers.iterator(); var9.hasNext(); tmpDmg = pCal.atDamageGive(tmpDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }
        for (var9 = player.powers.iterator(); var9.hasNext(); tmpDPE = pCal.atDamageGive(tmpDPE, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }
        for (var9 = player.powers.iterator(); var9.hasNext(); tmpVampDmg = pCal.atDamageGive(tmpVampDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }
    }

    public void AtDmgCal(AbstractMonster mo)
    {
        //region dmg
        tmpDmg = player.stance.atDamageGive(tmpDmg, this.damageTypeForTurn, this);
        if (this.baseDamage != (int) tmpDmg)
        {
            this.isDamageModified = true;
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmpDmg = pCal.atDamageReceive(tmpDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }

        for (var9 = player.powers.iterator(); var9.hasNext(); tmpDmg = pCal.atDamageFinalGive(tmpDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmpDmg = pCal.atDamageFinalReceive(tmpDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }
        //endregion
        //region DPE
        tmpDPE = player.stance.atDamageGive(tmpDPE, this.damageTypeForTurn, this);
        if (this.baseDamage != (int) tmpDPE)
        {
            this.isDamageModified = true;
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmpDPE = pCal.atDamageReceive(tmpDPE, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }

        for (var9 = player.powers.iterator(); var9.hasNext(); tmpDPE = pCal.atDamageFinalGive(tmpDPE, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmpDPE = pCal.atDamageFinalReceive(tmpDPE, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }
        //endregion
        //region VampDmg
        tmpVampDmg = player.stance.atDamageGive(tmpVampDmg, this.damageTypeForTurn, this);
        if (this.baseDamage != (int) tmpVampDmg)
        {
            this.isDamageModified = true;
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmpVampDmg = pCal.atDamageReceive(tmpVampDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }

        for (var9 = player.powers.iterator(); var9.hasNext(); tmpVampDmg = pCal.atDamageFinalGive(tmpVampDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }

        for (var9 = mo.powers.iterator(); var9.hasNext(); tmpVampDmg = pCal.atDamageFinalReceive(tmpVampDmg, this.damageTypeForTurn, this))
        {
            pCal = (AbstractPower) var9.next();
        }
        //endregion
    }
    //endregion

    //region dmgCal Multi
    Iterator var6;
    AbstractPower pCalMulti;

    public void SetRelicModifierMultiCal(int i)
    {
        var6 = player.relics.iterator();

        while (var6.hasNext())
        {
            AbstractRelic r = (AbstractRelic) var6.next();
            tmpDmgMulti[i] = r.atDamageModify(tmpDmgMulti[i], this);
            tmpDPEMulti[i] = r.atDamageModify(tmpDPEMulti[i], this);
            tmpVampDmgMulti[i] = r.atDamageModify(tmpVampDmgMulti[i], this);

            SetDmgModifierMultiBool(i);
                   /* if (this.baseDamage != (int) tmpDmgMulti[i])
                    {
                        this.isDamageModified = true;
                    }
                    if (this.baseDmgPerEnergy != (int) tmpDPEMulti[i])
                    {
                        this.isDPEModified = true;
                    }
                    if (this.baseVampDmg != (int) tmpVampDmgMulti[i])
                    {
                        this.isVampDmgModified = true;
                    }*/
        }
    }

    public void AtDmgGiveLoopMultiCal(int i)
    {
        for (var6 = player.powers.iterator(); var6.hasNext(); tmpDmgMulti[i] = pCalMulti.atDamageGive(tmpDmgMulti[i], this.damageTypeForTurn, this))
        {
            pCalMulti = (AbstractPower) var6.next();
        }
        for (var6 = player.powers.iterator(); var6.hasNext(); tmpDPEMulti[i] = pCalMulti.atDamageGive(tmpDPEMulti[i], this.damageTypeForTurn, this))
        {
            pCalMulti = (AbstractPower) var6.next();
        }
        for (var6 = player.powers.iterator(); var6.hasNext(); tmpVampDmgMulti[i] = pCalMulti.atDamageGive(tmpVampDmgMulti[i], this.damageTypeForTurn, this))
        {
            pCalMulti = (AbstractPower) var6.next();
        }
    }

    public void AtDmgReceiveLoop(int i)
    {
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            var6 = ((AbstractMonster) m.get(i)).powers.iterator();

            while (var6.hasNext())
            {
                pCalMulti = (AbstractPower) var6.next();
                if (!((AbstractMonster) m.get(i)).isDying && !((AbstractMonster) m.get(i)).isEscaping)
                {
                    tmpDmgMulti[i] = pCalMulti.atDamageReceive(tmpDmgMulti[i], this.damageTypeForTurn, this);
                    tmpDPEMulti[i] = pCalMulti.atDamageReceive(tmpDPEMulti[i], this.damageTypeForTurn, this);
                    tmpVampDmgMulti[i] = pCalMulti.atDamageReceive(tmpVampDmgMulti[i], this.damageTypeForTurn, this);
                }
            }
        }
    }

    public void AtDmgFinalLoopMultiCal(int i)
    {
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            for (var6 = player.powers.iterator(); var6.hasNext(); tmpDmgMulti[i] = pCalMulti.atDamageFinalGive(tmpDmgMulti[i], this.damageTypeForTurn, this))
            {
                pCalMulti = (AbstractPower) var6.next();
            }
            for (var6 = player.powers.iterator(); var6.hasNext(); tmpDPEMulti[i] = pCalMulti.atDamageFinalGive(tmpDPEMulti[i], this.damageTypeForTurn, this))
            {
                pCalMulti = (AbstractPower) var6.next();
            }
            for (var6 = player.powers.iterator(); var6.hasNext(); tmpVampDmgMulti[i] = pCalMulti.atDamageFinalGive(tmpVampDmgMulti[i], this.damageTypeForTurn, this))
            {
                pCalMulti = (AbstractPower) var6.next();
            }
        }
    }

    public void AtDmgFinalReceiveCal(int i)
    {
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            var6 = ((AbstractMonster) m.get(i)).powers.iterator();

            while (var6.hasNext())
            {
                pCalMulti = (AbstractPower) var6.next();
                if (!((AbstractMonster) m.get(i)).isDying && !((AbstractMonster) m.get(i)).isEscaping)
                {
                    tmpDmgMulti[i] = pCalMulti.atDamageFinalReceive(tmpDmgMulti[i], this.damageTypeForTurn, this);
                    tmpDPEMulti[i] = pCalMulti.atDamageFinalReceive(tmpDPEMulti[i], this.damageTypeForTurn, this);
                    tmpVampDmgMulti[i] = pCalMulti.atDamageFinalReceive(tmpVampDmgMulti[i], this.damageTypeForTurn, this);
                }

            }
        }
    }

    public void DmgFloorBool(int i)
    {
        if (this.baseDamage != MathUtils.floor(tmpDmgMulti[i]))
        {
            this.isDamageModified = true;
        }

        if (this.baseDmgPerEnergy != MathUtils.floor(tmpDPEMulti[i]))
        {
            this.isDPEModified = true;
        }

        if (this.baseVampDmg != MathUtils.floor(tmpVampDmgMulti[i]))
        {
            this.isVampDmgModified = true;
        }
    }

    public void SetFinalDmgMultiCal(int i)
    {
        SetTmpZeroMulti(i);
        for (i = 0; i < tmpMonsterCount.length; ++i)
        {
            DmgFloorBool(i);

            this.multiDamage[i] = MathUtils.floor(tmpDmgMulti[i]);
            this.multiDPE[i] = MathUtils.floor(tmpDPEMulti[i]);
            this.multiVampDmg[i] = MathUtils.floor(tmpVampDmgMulti[i]);
        }

        this.damage = this.multiDamage[0];
        this.dmgPerEnergy = this.multiDPE[0];
        this.vampDmg = this.multiVampDmg[0];
    }

    //endregion

    public void calculateCardDamage(AbstractMonster mo)
    {
        this.applyPowersToBlock();
        player = AbstractDungeon.player;

        DmgModifySetFalse();

        if (!this.isMultiDamage && mo != null)
        {
            SetTmp();

            SetRelicModifierCal();

            AtDmgGiveLoopCal();

            AtDmgCal(mo);

            SetDmgFinal();

        } else
        {
            InitTmpMulti();
            int i = 0;

            SetTmpMulti(i);

            for (i = 0; i < tmpMonsterCount.length; ++i)
            {
                SetRelicModifierMultiCal(i);

                AtDmgGiveLoopMultiCal(i);

                AtDmgGiveMulti(i);

                AtDmgReceiveLoop(i);

                AtDmgFinalLoopMultiCal(i);

                AtDmgFinalReceiveCal(i);

                SetFinalDmgMultiCal(i);
            }

        }
    }
    //endregion

    //endregion
}
