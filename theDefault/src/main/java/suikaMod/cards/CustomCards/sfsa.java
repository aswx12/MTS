package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.unique.*;
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
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class sfsa extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(sfsa.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private static final int DAMAGE = 1;
    private static final int UPGRADE_DAMAGE= 1;
    private static final int BLOCK = 1;
    private static final int UPGRADE_BLOCK = 1;
    private static final int ENERGY = 1;
    private static final int UPGRADE_ENERGY = 1;
    private int TIME = 1;
    private final int UPGRADE_TIME = 1;
    private static final int aVULNERABLE = 1;
    private static final int UPGRADE_aVULNERABLE = 1;
    private static final int aWEAK = 1;
    private static final int UPGRADE_aWEAK = 1;
    private static final int aPOISON = 1;
    private static final int UPGRADE_aPOISON = 1;
    private static final int aSTR = 1;
    private static final int UPGRADE_aSTR = 1;
    private static final int gVULNERABLE = 1;
    private static final int UPGRADE_gVULNERABLE = 1;
    private static final int gWEAK = 1;
    private static final int UPGRADE_gWEAK = 1;
    private static final int gPOISON = 1;
    private static final int UPGRADE_gPOISON = 1;
    private static final int gSTR = 1;
    private static final int UPGRADE_gSTR = 1;
    private int copy2DiscQty = 1;
    private final int UPGRADE_copy2DiscQty = 1;
    private int copy2HandQty = 1;
    private final int UPGRADE_copy2HandQty = 1;
    private int rAttackCopy2HandQty = 1;
    private final int UPGRADE_rAttackCopy2HandQty = 1;
    private int rSkillCopy2HandQty = 1;
    private final int UPGRADE_rSkillCopy2HandQty = 1;
    private int rPowerCopy2HandQty = 1;
    private final int UPGRADE_rPowerCopy2HandQty = 1;
    private int rColorlessCopy2HandQty = 1;
    private final int UPGRADE_rColorlessCopy2HandQty = 1;
    private int rAttackCopy2DiscQty = 1;
    private final int UPGRADE_rAttackCopy2DiscQty = 1;
    private int rSkillCopy2DiscQty = 1;
    private final int UPGRADE_rSkillCopy2DiscQty = 1;
    private int rPowerCopy2DiscQty = 1;
    private final int UPGRADE_rPowerCopy2DiscQty = 1;
    private int rColorlessCopy2DiscQty = 1;
    private final int UPGRADE_rColorlessCopy2DiscQty = 1;
    private int rAttack2HandQty = 1;
    private final int UPGRADE_rAttack2HandQty = 1;
    private int rSkill2HandQty = 1;
    private final int UPGRADE_rSkill2HandQty = 1;
    private int rPower2HandQty = 1;
    private final int UPGRADE_rPower2HandQty = 1;
    private int rColorless2HandQty = 1;
    private final int UPGRADE_rColorless2HandQty = 1;
    private int rAttack2DiscQty = 1;
    private final int UPGRADE_rAttack2DiscQty = 1;
    private int rSkill2DiscQty = 1;
    private final int UPGRADE_rSkill2DiscQty = 1;
    private int rPower2DiscQty = 1;
    private final int UPGRADE_drPower2DiscQty = 1;
    private int rColorless2DiscQty = 1;
    private final int UPGRADE_rColorless2DiscQty = 1;
    private int chooseDrawQty = 1;
    private final int UPGRADE_chooseDrawQty = 1;
    private int chooseAttackDrawQty = 1;
    private final int UPGRADE_chooseAttackDrawQty = 1;
    private int chooseSkillDrawQty = 1;
    private final int UPGRADE_chooseSkillDrawQty = 1;

    // /STAT DECLARATION/

    public sfsa ()
    { 
        super(ID, "sfsa", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);
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
         this.addToBot(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), copy2DiscQty));
         this.addToBot(new MakeTempCardInHandAction(this.makeStatEquivalentCopy(),copy2HandQty));
         AddRandomCardHandCopy(rAttackCopy2HandQty,CardType.ATTACK);
         AddRandomCardHandCopy(rSkillCopy2HandQty,CardType.SKILL);
         AddRandomCardHandCopy(rPowerCopy2HandQty,CardType.POWER);
         AddRandomColorlessCopy(rColorlessCopy2HandQty,"Hand");
         AddRandomCardDiscardCopy(rAttackCopy2DiscQty,CardType.ATTACK);
         AddRandomCardDiscardCopy(rSkillCopy2DiscQty,CardType.SKILL);
         AddRandomCardDiscardCopy(rPowerCopy2DiscQty,CardType.POWER);
         AddRandomColorlessCopy(rColorlessCopy2DiscQty,"Discard");
         AddRandomCardHand(rAttack2HandQty,CardType.ATTACK);
         AddRandomCardHand(rSkill2HandQty,CardType.SKILL);
         AddRandomCardHand(rPower2HandQty,CardType.POWER);
         AddRandomColorless(rColorless2HandQty,"Hand");
         AddRandomCardDiscard(rAttack2DiscQty,CardType.ATTACK);
         AddRandomCardDiscard(rSkill2DiscQty,CardType.SKILL);
         AddRandomCardDiscard(rPower2DiscQty,CardType.POWER);
         AddRandomColorless(rColorless2DiscQty,"Discard");
         this.addToBot(new BetterDrawPileToHandAction(chooseDrawQty));
         this.addToBot(new AttackFromDeckToHandAction(chooseAttackDrawQty));
         this.addToBot(new SkillFromDeckToHandAction(chooseSkillDrawQty));
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeDamage(UPGRADE_DAMAGE);
            upgradeBlock(UPGRADE_BLOCK);
            this.upgradeMagicNumber(UPGRADE_ENERGY);
            TIME = UPGRADE_TIME;
            this.upgradeAVulnerableValue(UPGRADE_aVULNERABLE);
            this.upgradeAWeakValue(UPGRADE_aWEAK);
            this.upgradeAPoisonValue(UPGRADE_aPOISON);
            this.upgradeAStrValue(UPGRADE_aSTR);
            this.upgradeGVulnerableValue(UPGRADE_gVULNERABLE);
            this.upgradeGWeakValue(UPGRADE_gWEAK);
            this.upgradeGPoisonValue(UPGRADE_gPOISON);
            this.upgradeGStrValue(UPGRADE_gSTR);
            copy2DiscQty=UPGRADE_copy2DiscQty;
            copy2HandQty=UPGRADE_copy2HandQty;
            rAttackCopy2HandQty=UPGRADE_rAttackCopy2HandQty;
            rSkillCopy2HandQty=UPGRADE_rSkillCopy2HandQty;
            rPowerCopy2HandQty=UPGRADE_rPowerCopy2HandQty;
            rColorlessCopy2HandQty=UPGRADE_rColorlessCopy2HandQty;
            rAttackCopy2DiscQty=UPGRADE_rAttackCopy2DiscQty;
            rSkillCopy2DiscQty=UPGRADE_rSkillCopy2DiscQty;
            rPowerCopy2DiscQty=UPGRADE_rPowerCopy2DiscQty;
            rColorlessCopy2DiscQty=UPGRADE_rColorlessCopy2DiscQty;
            rAttack2HandQty=UPGRADE_rAttack2HandQty;
            rSkill2HandQty=UPGRADE_rSkill2HandQty;
            rPower2HandQty=UPGRADE_rPower2HandQty;
            rColorless2HandQty=UPGRADE_rColorless2HandQty;
            rAttack2DiscQty=UPGRADE_rAttack2DiscQty;
            rSkill2DiscQty=UPGRADE_rSkill2DiscQty;
            rPower2DiscQty=UPGRADE_drPower2DiscQty;
            rColorless2DiscQty=UPGRADE_rColorless2DiscQty;
            chooseDrawQty=UPGRADE_chooseDrawQty;
            chooseAttackDrawQty=UPGRADE_chooseAttackDrawQty;
            chooseSkillDrawQty=UPGRADE_chooseSkillDrawQty;
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}