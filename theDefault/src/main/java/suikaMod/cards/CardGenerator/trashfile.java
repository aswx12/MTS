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
