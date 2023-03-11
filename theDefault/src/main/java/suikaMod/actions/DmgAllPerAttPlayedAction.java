package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

public class DmgAllPerAttPlayedAction extends AbstractGameAction
{
    private DamageInfo info;

    public DmgAllPerAttPlayedAction(DamageInfo info, AbstractGameAction.AttackEffect effect)
    {
        this.info = info;
        this.setValues(target, info);
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = effect;
    }

    public DmgAllPerAttPlayedAction( DamageInfo info)
    {
        this(info, AttackEffect.NONE);
    }

    public void update()
    {
        this.isDone = true;
        if (this.target != null && this.target.currentHealth > 0)
        {
            int count = 0;
            Iterator var2 = AbstractDungeon.actionManager.cardsPlayedThisTurn.iterator();

            while (var2.hasNext())
            {
                AbstractCard c = (AbstractCard) var2.next();
                if (c.type == AbstractCard.CardType.ATTACK)
                {
                    ++count;
                }
            }

            --count;

            AbstractMonster mo;
            Iterator var3;
            var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
            while (var3.hasNext())
            {
                mo = (AbstractMonster) var3.next();
                for (int i = 0; i < count; ++i)
                {
                    this.addToTop(new DamageAction(mo, this.info, this.attackEffect));
                }
            }
        }
    }
}