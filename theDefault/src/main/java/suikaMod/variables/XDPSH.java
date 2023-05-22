package suikaMod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import suikaMod.cards.AbstractDefaultCard;

import java.util.Iterator;

import static suikaMod.DefaultMod.makeID;

public class XDPSH extends DynamicVariable
{

    //For in-depth comments, check the other variable(DefaultCustomVariable). It's nearly identical.

    @Override
    public String key()
    {
        return makeID("XDPSH");
        // This is what you put between "!!" in your card strings to actually display the number.
        // You can name this anything (no spaces), but please pre-phase it with your mod name as otherwise mod conflicts can occur.
        // Remember, we're using makeID so it automatically puts "theDefault:" (or, your id) before the name.
    }

    @Override
    public boolean isModified(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).isDPSHModified;

    }
    @Override
    public int value(AbstractCard card)
    {
        int count=0;
        if(AbstractDungeon.isPlayerInDungeon()){
            Iterator var1 = AbstractDungeon.player.hand.group.iterator();
            while(var1.hasNext()) {
                AbstractCard c = (AbstractCard)var1.next();
                if (c.type == AbstractCard.CardType.SKILL) {
                    count++;
                }
            }
        }

        return ((AbstractDefaultCard) card).dmgPerSkillInHand * count;
    }
    public void setIsModified(AbstractCard card, boolean v) {
        ((AbstractDefaultCard) card).isDPSHModified = v;
    }
    @Override
    public int baseValue(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).baseDPSH;
    }

    @Override
    public boolean upgraded(AbstractCard card)
    {
        return ((AbstractDefaultCard) card).upgradedDPSH;
    }
}