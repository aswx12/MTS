package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.unique.*;
import com.megacrit.cardcrawl.actions.defect.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import suikaMod.DefaultMod;
import suikaMod.actions.*;
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.Iterator;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class sagasggas extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(sagasggas.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private static final int dmgIfTargetPsnValue = 1;
    private static final int UPGRADE_dmgIfTargetPsnValue= 2;
    private static final int dmgPerAttPlayedValue = 1;
    private static final int UPGRADE_dmgPerAttPlayedValue= 2;
    private static final int dmgPerSkillHandValue = 1;
    private static final int UPGRADE_dmgPerSkillHandValue= 2;

    // /STAT DECLARATION/

    private static String desc ="a";
    public sagasggas ()
    { 
        super(ID, "sagasggas", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);
        baseDmgPsnCondition = dmgIfTargetPsnValue;
        baseDPAP = dmgPerAttPlayedValue;
        baseDPSH = dmgPerSkillHandValue;

        isMultiDamage=true;
        //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        AbstractMonster mo;
        Iterator var3;
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(new BaneAction(mo, new DamageInfo(p, this.dmgPsnCondition, this.damageTypeForTurn)));
        }
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(
                new DamagePerAttackPlayedAction(mo, new DamageInfo(p, this.dmgPerAttPlayed, this.damageTypeForTurn), AttackEffect.SLASH_DIAGONAL));
        }
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(new FlechetteAction(mo, new DamageInfo(p, this.dmgPerSkillInHand, this.damageTypeForTurn)));
        }
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDmgPsnCon(UPGRADE_dmgIfTargetPsnValue);
            upgradeDPAP(UPGRADE_dmgPerAttPlayedValue);
            upgradeDPSH(UPGRADE_dmgPerSkillHandValue);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}