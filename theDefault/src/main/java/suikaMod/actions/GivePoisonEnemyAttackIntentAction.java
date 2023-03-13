package suikaMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class GivePoisonEnemyAttackIntentAction extends AbstractGameAction
{
    AbstractMonster targetMonster;
    AbstractCreature source;
    AbstractCreature powerToTarget;

    public GivePoisonEnemyAttackIntentAction(AbstractMonster targetMonster, AbstractCreature powerToTarget,int psnAmt)
    {
        this.actionType = ActionType.WAIT;
        this.amount = psnAmt;

        this.targetMonster = targetMonster;
        this.powerToTarget =powerToTarget;

    }

    public void update()
    {
        if (this.targetMonster != null && this.targetMonster.getIntentBaseDmg() >= 0)
        {
            this.addToBot(new ApplyPowerAction(this.powerToTarget, AbstractDungeon.player, new PoisonPower(this.powerToTarget, AbstractDungeon.player, amount), amount, AttackEffect.POISON));
        }

        this.isDone = true;
    }
}
