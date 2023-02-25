package suikaMod.cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public abstract class AbstractDefaultCard extends CustomCard
{

    // Custom Abstract Cards can be a bit confusing. While this is a simple base for simply adding a second magic number,
    // if you're new to modding I suggest you skip this file until you know what unique things that aren't provided
    // by default, that you need in your own cards.

    // In this example, we use a custom Abstract Card in order to define a new magic number. From here on out, we can
    // simply use that in our cards, so long as we put "extends AbstractDynamicCard" instead of "extends CustomCard" at the start.
    // In simple terms, it's for things that we don't want to define again and again in every single card we make.

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
        if (aUpgradedVulnerableValue)
        { // If we set upgradedDefaultSecondMagicNumber = true in our card.
            aVulnerableValue = aBaseVulnerableValue; // Show how the number changes, as out of combat, the base number of a card is shown.
            aIsVulnerableValueModified = true; // Modified = true, color it green to highlight that the number is being changed.
        }

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

    }

    @Override
    protected void upgradeDamage(int amount)
    {
        this.baseDamage = amount;
        this.upgradedDamage = true;
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
}
