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
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.Iterator;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class gasags extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(gasags.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.RARE; 
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY; 
    private static final CardType TYPE = CardType.SKILL;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private static final int aVULNERABLE = 2;
    private static final int UPGRADE_aVULNERABLE = 3;
    private static final int aWEAK = 2;
    private static final int UPGRADE_aWEAK = 3;
    private static final int aPOISON = 2;
    private static final int UPGRADE_aPOISON = 3;
    private static final int aSTR = 2;
    private static final int UPGRADE_aSTR = 3;

    // /STAT DECLARATION/

    public gasags ()
    { 
        super(ID, "gasags", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);

        aVulnerableValue = aBaseVulnerableValue = aVULNERABLE;
        aWeakValue = aBaseWeakValue= aWEAK;
        aPoisonValue = aBasePoisonValue= aPOISON;
        aStrValue = aBaseStrValue= aSTR;


        isMultiDamage = true;
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
            this.addToBot(new ApplyPowerAction(mo, p, new VulnerablePower(mo, this.aVulnerableValue, false), this.aVulnerableValue));
        }
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new WeakPower(mo, this.aWeakValue, false), this.aWeakValue));
        }
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new PoisonPower(mo, p, this.aPoisonValue), this.aPoisonValue, AttackEffect.POISON));
        }
        var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new StrengthPower(mo, this.aStrValue), this.aStrValue));
        }
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            this.upgradeAVulnerableValue(UPGRADE_aVULNERABLE);
            this.upgradeAWeakValue(UPGRADE_aWEAK);
            this.upgradeAPoisonValue(UPGRADE_aPOISON);
            this.upgradeAStrValue(UPGRADE_aSTR);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}