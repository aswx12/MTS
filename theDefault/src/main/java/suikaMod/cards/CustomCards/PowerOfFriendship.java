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
public class PowerOfFriendship extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(PowerOfFriendship.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 0;  
    private static final int UPGRADED_COST = 0; 

    private static final int dmgPerEnergyValue = 2;
    private static final int UPGRADE_dmgPerEnergyValue= 4;
    private static final int dmgPerAttPlayedValue = 2;
    private static final int UPGRADE_dmgPerAttPlayedValue= 5;
    private static final int dmgPerSkillHandValue = 2;
    private static final int UPGRADE_dmgPerSkillHandValue= 3;
    private int hpValue = 3;
    private final int UPGRADE_hpValue = 5;
    private static final int gSTR = 2;
    private static final int UPGRADE_gSTR = 6;

    // /STAT DECLARATION/

    private static String desc ="With The Power Of FRIENDSHIP NL Deal !suikaMod:DPE! per Energy( !suikaMod:XDPE! ) NL Deal !suikaMod:DPAP! per attack played( !suikaMod:XDPAP! ) NL Deal !suikaMod:DPSH! per skill in hand( !suikaMod:XDPSH! ) NL Sacrifice 3 HP and Gain 2 Strength  NL Retain";
    private static final String upDesc="With The Power Of FRIENDSHIP NL Deal !suikaMod:DPE! per Energy( !suikaMod:XDPE! ) NL Deal !suikaMod:DPAP! per attack played( !suikaMod:XDPAP! ) NL Deal !suikaMod:DPSH! per skill in hand( !suikaMod:XDPSH! ) NL Sacrifice 5 HP and Gain 6 Strength  NL Retain";
    public PowerOfFriendship ()
    { 
        super(ID, "Power Of Friendship", IMG,desc, COST, TYPE, COLOR, RARITY, TARGET);
        baseDmgPerEnergy = dmgPerEnergyValue;
        baseDPAP = dmgPerAttPlayedValue;
        baseDPSH = dmgPerSkillHandValue;
        gStrValue = gBaseStrValue= gSTR;

            this.retain=true; 
                      //this.tags.add(CardTags.STARTER_STRIKE); 

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(
                new SkewerAction(p, m, dmgPerEnergy, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
         this.addToBot(
                new DamagePerAttackPlayedAction(m, new DamageInfo(p, this.dmgPerAttPlayed, this.damageTypeForTurn), AttackEffect.SLASH_DIAGONAL));
         this.addToBot(new FlechetteAction(m, new DamageInfo(p, this.dmgPerSkillInHand, this.damageTypeForTurn)));
         this.addToBot(new LoseHPAction(p, p, hpValue));
         this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.gStrValue), this.gStrValue));
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDPE(UPGRADE_dmgPerEnergyValue);
            upgradeDPAP(UPGRADE_dmgPerAttPlayedValue);
            upgradeDPSH(UPGRADE_dmgPerSkillHandValue);
            hpValue = UPGRADE_hpValue;
            this.upgradeGStrValue(UPGRADE_gSTR);
            upgradeBaseCost(UPGRADED_COST);
            rawDescription=upDesc;
            initializeDescription();
        }
    }
}