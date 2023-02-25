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
public class randompile extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(randompile.class.getSimpleName()); 
    public static final String IMG = makeCardPath("Attack.png"); 
    private static final CardRarity RARITY = CardRarity.UNCOMMON; 
    private static final CardTarget TARGET = CardTarget.ENEMY; 
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  
    private static final int UPGRADED_COST = 1; 

    private int rAttack2DrawPQty = 2;
    private final int UPGRADE_rAttack2DrawPQty = 1;
    private int rSkill2DrawPQty = 2;
    private final int UPGRADE_rSkill2DrawPQty = 2;
    private int rPower2DrawPQty = 2;
    private final int UPGRADE_rPower2DrawPQty = 2;
    private int rColorless2DrawPQty = 2;
    private final int UPGRADE_rColorless2DrawPQty = 2;
    private int rAttack2TopDrawPQty = 2;
    private final int UPGRADE_rAttack2TopDrawPQty = 2;
    private int rSkill2TopDrawPQty = 2;
    private final int UPGRADE_rSkill2TopDrawPQty = 2;
    private int rPower2DrawTopPQty = 2;
    private final int UPGRADE_rPower2DrawTopPQty = 2;
    private int rColorless2TopDrawPQty = 2;
    private final int UPGRADE_rColorless2TopDrawPQty = 2;
    private int rAttack2BotDrawPQty = 2;
    private final int UPGRADE_rAttack2BotDrawPQty = 2;
    private int rSkill2BotDrawPQty = 2;
    private final int UPGRADE_rSkill2BotDrawPQty = 2;
    private int rPower2BotDrawPQty = 2;
    private final int UPGRADE_rPower2BotDrawPQty = 2;
    private int rColorless2BotDrawPQty = 2;
    private final int UPGRADE_rColorless2BotDrawPQty = 2;

    // /STAT DECLARATION/

    public randompile ()
    { 
        super(ID, "randompile", IMG,"a", COST, TYPE, COLOR, RARITY, TARGET);
        
                //this.tags.add(CardTags.STARTER_STRIKE); 
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
         AddRandomCardDrawP(rAttack2DrawPQty,CardType.ATTACK,"Random");
         AddRandomCardDrawP(rSkill2DrawPQty,CardType.SKILL,"Random");
         AddRandomCardDrawP(rPower2DrawPQty,CardType.POWER,"Random");
         AddRandomColorless(rColorless2DrawPQty,"DrawPile");
         AddRandomCardDrawP(rAttack2TopDrawPQty,CardType.ATTACK,"Top");
         AddRandomCardDrawP(rSkill2TopDrawPQty,CardType.SKILL,"Top");
         AddRandomCardDrawP(rPower2DrawTopPQty,CardType.POWER,"Top");
         AddRandomColorless(rColorless2TopDrawPQty,"TopDrawPile");
         AddRandomCardDrawP(rAttack2BotDrawPQty,CardType.ATTACK,"Bot");
         AddRandomCardDrawP(rSkill2BotDrawPQty,CardType.SKILL,"Bot");
         AddRandomCardDrawP(rPower2BotDrawPQty,CardType.POWER,"Bot");
         AddRandomColorless(rColorless2BotDrawPQty,"BotDrawPile");
    }

    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
                        rAttack2DrawPQty=UPGRADE_rAttack2DrawPQty;
            rSkill2DrawPQty=UPGRADE_rSkill2DrawPQty;
            rPower2DrawPQty=UPGRADE_rPower2DrawPQty;
            rColorless2DrawPQty=UPGRADE_rColorless2DrawPQty;
            rAttack2TopDrawPQty=UPGRADE_rAttack2TopDrawPQty;
            rSkill2TopDrawPQty=UPGRADE_rSkill2TopDrawPQty;
            rPower2DrawTopPQty=UPGRADE_rPower2DrawTopPQty;
            rColorless2TopDrawPQty=UPGRADE_rColorless2TopDrawPQty;
            rAttack2BotDrawPQty=UPGRADE_rAttack2BotDrawPQty;
            rSkill2BotDrawPQty=UPGRADE_rSkill2BotDrawPQty;
            rPower2BotDrawPQty=UPGRADE_rPower2BotDrawPQty;
            rColorless2BotDrawPQty=UPGRADE_rColorless2BotDrawPQty;
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}