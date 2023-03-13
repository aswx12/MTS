package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class GiveStrengthEnemyAttackIntentAction extends AbstractGameAction
{
    AbstractMonster targetMonster;
    AbstractCreature source;
    AbstractCreature powerToTarget;

    public GiveStrengthEnemyAttackIntentAction(AbstractMonster targetMonster, AbstractCreature powerToTarget, int strAmt)
    {
        this.actionType = ActionType.WAIT;
        this.amount = strAmt;

        this.targetMonster = targetMonster;
        this.powerToTarget = powerToTarget;

    }

    public void update()
    {
        if (this.targetMonster != null && this.targetMonster.getIntentBaseDmg() >= 0)
        {
            this.addToTop(new ApplyPowerAction(this.powerToTarget, AbstractDungeon.player, new StrengthPower(this.powerToTarget, this.amount), this.amount));
        }

        this.isDone = true;
    }
}
