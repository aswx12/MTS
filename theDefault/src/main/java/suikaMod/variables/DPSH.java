package suikaMod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.vfx.combat.ThrowDaggerEffect;
import suikaMod.cards.AbstractDefaultCard;

import java.util.Iterator;

import static suikaMod.DefaultMod.makeID;

public class DPSH extends DynamicVariable
{

    //For in-depth comments, check the other variable(DefaultCustomVariable). It's nearly identical.

    @Override
    public String key()
    {
        return makeID("DPSH");
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
        Iterator var1 = AbstractDungeon.player.hand.group.iterator();
        int count=0;
        while(var1.hasNext()) {
            AbstractCard c = (AbstractCard)var1.next();
            if (c.type == AbstractCard.CardType.SKILL) {
                count++;
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