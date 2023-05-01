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
public class allTest extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(allTest.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private static final int DAMAGE = 2;
    private static final int UPGRADE_DAMAGE= 3;
    private static final int dmgPerEnergyValue = 2;
    private static final int UPGRADE_dmgPerEnergyValue= 3;
    private static final int vampDmgValue = 2;
    private static final int UPGRADE_vampDmgValue= 3;
    private static final int dmgIfTargetPsnValue = 2;
    private static final int UPGRADE_dmgIfTargetPsnValue= 3;
    private static final int dmgPerAttPlayedValue = 2;
    private static final int UPGRADE_dmgPerAttPlayedValue= 3;
    private static final int dmgPerSkillHandValue = 2;
    private static final int UPGRADE_dmgPerSkillHandValue= 3;

    // /STAT DECLARATION/

    private static String desc ="dmg !D! NL dpe !suikaMod:DPE! NL vamp !suikaMod:DVAMP! NL psn !suikaMod:DTP! NL att !suikaMod:DPAP! NL skill !suikaMod:DPSH!";
    public allTest ()
    { 
        super(ID, "allTest", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        baseDmgPerEnergy = dmgPerEnergyValue;
        baseVampDmg = vampDmgValue;
        baseDmgPsnCondition = dmgIfTargetPsnValue;
        baseDPAP = dmgPerAttPlayedValue;
        baseDPSH = dmgPerSkillHandValue;

                      //this.tags.add(CardTags.STARTER_STRIKE); 

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(
                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
        this.addToBot(
                new SkewerAction(p, m, dmgPerEnergy, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
        this.addToBot(
                new VampireDamageAction(m, new DamageInfo(p, vampDmg, damageTypeForTurn), AttackEffect.NONE));
         this.addToBot(new BaneAction(m, new DamageInfo(p, this.dmgPsnCondition, this.damageTypeForTurn)));
         this.addToBot(
                new DamagePerAttackPlayedAction(m, new DamageInfo(p, this.dmgPerAttPlayed, this.damageTypeForTurn), AttackEffect.SLASH_DIAGONAL));
         this.addToBot(new FlechetteAction(m, new DamageInfo(p, this.dmgPerSkillInHand, this.damageTypeForTurn)));
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDamage(UPGRADE_DAMAGE);
            upgradeDPE(UPGRADE_dmgPerEnergyValue);
            upgradeVampDmg(UPGRADE_vampDmgValue);
            upgradeDmgPsnCon(UPGRADE_dmgIfTargetPsnValue);
            upgradeDPAP(UPGRADE_dmgPerAttPlayedValue);
            upgradeDPSH(UPGRADE_dmgPerSkillHandValue);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}