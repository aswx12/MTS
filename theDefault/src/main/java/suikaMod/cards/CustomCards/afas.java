package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import suikaMod.DefaultMod;
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class afas extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(afas.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private static final int DAMAGE = 1;
    private static final int UPGRADE_PLUS_DMG = 2;
    private static final int BLOCK = 1;
    private static final int UPGRADE_PLUS_BLOCK = 2;
    private static final int ENERGY = 1;
    private static final int UPGRADE_PLUS_ENERGY = 2;
    private int TIME = 2;
    private final int UPGRADE_PLUS_TIME = 4;
    private static final int aVULNERABLE = 1;
    private static final int UPGRADE_PLUS_aVULNERABLE = 2;
    private static final int aWEAK = 1;
    private static final int UPGRADE_PLUS_aWEAK = 2;
    private static final int aPOISON = 1;
    private static final int UPGRADE_PLUS_aPOISON = 2;
    private static final int aSTR = 1;
    private static final int UPGRADE_PLUS_aSTR = 2;
    private static final int gVULNERABLE = 1;
    private static final int UPGRADE_PLUS_gVULNERABLE = 2;
    private static final int gWEAK = 1;
    private static final int UPGRADE_PLUS_gWEAK = 2;
    private static final int gPOISON = 1;
    private static final int UPGRADE_PLUS_gPOISON = 2;
    private static final int gSTR = 1;
    private static final int UPGRADE_PLUS_gSTR = 2;

    // /STAT DECLARATION/

    public afas ()
    { 
        super(ID, "afas", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        baseBlock = BLOCK;
        magicNumber = baseMagicNumber = ENERGY;
        aVulnerableValue = aBaseVulnerableValue = aVULNERABLE;
        aWeakValue = aBaseWeakValue= aWEAK;
        aPoisonValue = aBasePoisonValue= aPOISON;
        aStrValue = aBaseStrValue= aSTR;
        gVulnerableValue = gBaseVulnerableValue = gVULNERABLE;
        gWeakValue = gBaseWeakValue= gWEAK;
        gPoisonValue = gBasePoisonValue= gPOISON;
        gStrValue = gBaseStrValue= gSTR;

                //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        for (int i = 0; i < TIME; i++) {
            this.addToBot(
                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.SLASH_HORIZONTAL));
         this.addToBot(new GainBlockAction(p, p, block));
         this.addToBot(new GainEnergyAction(magicNumber));
         this.addToBot(new ApplyPowerAction(m, p, new VulnerablePower(m, this.aVulnerableValue, false), this.aVulnerableValue));
         this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.aWeakValue, false), this.aWeakValue));
         this.addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));
         this.addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, this.aStrValue), this.aStrValue));
         this.addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, this.gVulnerableValue, false), this.gVulnerableValue));
         this.addToBot(new ApplyPowerAction(p, p, new WeakPower(p, this.gWeakValue, false), this.gWeakValue));
         this.addToBot(new ApplyPowerAction(p, p, new PoisonPower(p, p, this.gPoisonValue), this.gPoisonValue, AttackEffect.POISON));
         this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.gStrValue), this.gStrValue));
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            upgradeBlock(UPGRADE_PLUS_BLOCK);
            this.upgradeMagicNumber(UPGRADE_PLUS_ENERGY);
            TIME = UPGRADE_PLUS_TIME;
            this.upgradeAVulnerableValue(UPGRADE_PLUS_aVULNERABLE);
            this.upgradeAWeakValue(UPGRADE_PLUS_aWEAK);
            this.upgradeAPoisonValue(UPGRADE_PLUS_aPOISON);
            this.upgradeAStrValue(UPGRADE_PLUS_gSTR);
            this.upgradeGVulnerableValue(UPGRADE_PLUS_gVULNERABLE);
            this.upgradeGWeakValue(UPGRADE_PLUS_gWEAK);
            this.upgradeGPoisonValue(UPGRADE_PLUS_gPOISON);
            this.upgradeGStrValue(UPGRADE_PLUS_gSTR);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}