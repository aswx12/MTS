package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class GiveWeakEnemyAttackIntentAction extends AbstractGameAction
{
    AbstractMonster targetMonster;
    AbstractCreature source;
    AbstractCreature powerToTarget;

    public GiveWeakEnemyAttackIntentAction(AbstractMonster targetMonster, AbstractCreature powerToTarget,int wkAmt)
    {
        this.actionType = ActionType.WAIT;
        this.amount = wkAmt;

        this.targetMonster = targetMonster;
        this.powerToTarget =powerToTarget;

    }

    public void update()
    {
        if (this.targetMonster != null && this.targetMonster.getIntentBaseDmg() >= 0)
        {
            this.addToTop(new ApplyPowerAction(this.powerToTarget, AbstractDungeon.player, new WeakPower(this.powerToTarget, this.amount, false), this.amount));
        }

        this.isDone = true;
    }
}