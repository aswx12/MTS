package suikaMod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import suikaMod.cards.AbstractDefaultCard;

import java.util.Iterator;

import static suikaMod.DefaultMod.makeID;

public class DPAP extends DynamicVariable
{

    //For in-depth comments, check the other variable(DefaultCustomVariable). It's nearly identical.

    @Override
    public String key()
    {
        return makeID("DPAP");
        // This is what you put between "!!" in your card strings to actually display the number.
        // You can name this anything (no spaces), but please pre-phase it with your mod name as otherwise mod conflicts can occur.
        // Remember, we're using makeID so it automatically puts "theDefault:" (or, your id) before the name.
    }

    @Override
    public boolean isModified(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).isDPAPModified;

    }
    @Override
    public int value(AbstractCard card)
    {
        int count = 0;
        Iterator var2 = AbstractDungeon.actionManager.cardsPlayedThisTurn.iterator();

        while(var2.hasNext()) {
            AbstractCard c = (AbstractCard)var2.next();
            if (c.type == AbstractCard.CardType.ATTACK) {
                ++count;
            }
        }
        return ((AbstractDefaultCard) card).dmgPerAttPlayed * count;
    }
    public void setIsModified(AbstractCard card, boolean v) {
        ((AbstractDefaultCard) card).isDPAPModified = v;
    }
    @Override
    public int baseValue(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).baseDPAP;
    }

    @Override
    public boolean upgraded(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).upgradedDPAP;
    }
}