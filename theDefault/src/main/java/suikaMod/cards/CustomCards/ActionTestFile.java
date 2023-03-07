package suikaMod.cards.CustomCards;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.DamageHooks;
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
import javafx.scene.effect.Effect;
import suikaMod.DefaultMod;
import suikaMod.actions.ModifyDmgAction;
import suikaMod.cards.AbstractDynamicCard;
import suikaMod.cards.DefaultCommonPower;
import suikaMod.characters.TheDefault;

import static suikaMod.DefaultMod.makeCardPath;

import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.Iterator;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;


@AutoAdd.Seen
public class ActionTestFile extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(ActionTestFile.class.getSimpleName());
    public static final String IMG = makeCardPath("Attack.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;
    private static final int UPGRADED_COST = 1;



    private static String DESC="Test";
    private static final String upDesc="upTest";


    // /STAT DECLARATION/

    public ActionTestFile()
    {
        super(ID, "ActionTestFile", IMG, DESC, COST, TYPE, COLOR, RARITY, TARGET);
        isMultiDamage = true;
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTags.STRIKE);


    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {


        //new VampireDamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AttackEffect.NONE);
        // this.addToBot(new ApplyPowerAction(p, p, new DarkEmbracePower(p, 1), 1));
        //this.addToBot(new ApplyPowerAction(p, p, new LoseStrengthPower(p, this.magicNumber), this.magicNumber));
        //addToBot(new SwordBoomerangAction(new DamageInfo(p, 5, damageTypeForTurn), 2));
       /* if (this.target != null && m.hasPower("Vulnerable"))
        {
            this.addToTop(new DrawCardAction(AbstractDungeon.player, 1));
            this.addToTop(new GainEnergyAction(1));
        }*/

        //this.addToBot(new ExpertiseAction(p, this.magicNumber));

    }

    public void triggerOnManualDiscard()
    {
        this.addToBot(new DrawCardAction(AbstractDungeon.player, 2));
    }


    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            upgradeBaseCost(UPGRADED_COST);
            rawDescription=upDesc; //dis is da wae
            initializeDescription();
        }

    }

}