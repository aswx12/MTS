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
public class randompileCopy extends AbstractDynamicCard
{
    public static final String ID = DefaultMod.makeID(randompileCopy.class.getSimpleName());
    public static final String IMG = makeCardPath("Attack.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;
    private static final int UPGRADED_COST = 1;

    private int rAttackCopy2DrawPQty = 2;
    private final int UPGRADE_rAttackCopy2DrawPQty = 1;
    private int rSkillCopy2DrawPQty = 2;
    private final int UPGRADE_rSkillCopy2DrawPQty = 1;
    private int rPowerCopy2DrawPQty = 2;
    private final int UPGRADE_rPowerCopy2DrawPQty = 1;
    private int rColorlessCopy2DrawPQty = 2;
    private final int UPGRADE_rColorlessCopy2DrawPQty = 1;
    private int rAttackCopy2TopDrawPQty = 2;
    private final int UPGRADE_rAttackCopy2TopDrawPQty = 1;
    private int rSkillCopy2TopDrawPQty = 2;
    private final int UPGRADE_rSkillCopy2TopDrawPQty = 1;
    private int rPowerCopy2TopDrawPQty = 2;
    private final int UPGRADE_rPowerCopy2TopDrawPQty = 1;
    private int rColorlessCopy2TopDrawPQty = 2;
    private final int UPGRADE_rColorlessCopy2TopDrawPQty = 1;
    private int rAttackCopy2BotDrawPQty = 2;
    private final int UPGRADE_rAttackCopy2BotDrawPQty = 1;
    private int rSkillCopy2BotDrawPQty = 2;
    private final int UPGRADE_rSkillCopy2BotDrawPQty = 1;
    private int rPowerCopy2BotDrawPQty = 2;
    private final int UPGRADE_rPowerCopy2BotDrawPQty = 1;
    private int rColorlessCopy2BotDrawPQty = 1;
    private final int UPGRADE_rColorlessCopy2BotDrawPQty = 1;

    // /STAT DECLARATION/

    public randompileCopy()
    {
        super(ID, "randompileCopy", IMG, "a", COST, TYPE, COLOR, RARITY, TARGET);

        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTags.STRIKE);

    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        AddRandomCardDrawPCopy(rAttackCopy2DrawPQty, CardType.ATTACK, "Random");
        AddRandomCardDrawPCopy(rSkillCopy2DrawPQty, CardType.SKILL, "Random");
        AddRandomCardDrawPCopy(rPowerCopy2DrawPQty, CardType.POWER, "Random");
        AddRandomColorlessCopy(rColorlessCopy2DrawPQty, "DrawPile");
        AddRandomCardDrawPCopy(rAttackCopy2TopDrawPQty, CardType.ATTACK, "Top");
        AddRandomCardDrawPCopy(rSkillCopy2TopDrawPQty, CardType.SKILL, "Top");
        AddRandomCardDrawPCopy(rPowerCopy2TopDrawPQty, CardType.POWER, "Top");
        AddRandomColorlessCopy(rColorlessCopy2TopDrawPQty, "TopDrawPile");
        AddRandomCardDrawPCopy(rAttackCopy2BotDrawPQty, CardType.ATTACK, "Bot");
        AddRandomCardDrawPCopy(rSkillCopy2BotDrawPQty, CardType.SKILL, "Bot");
        AddRandomCardDrawPCopy(rPowerCopy2BotDrawPQty, CardType.POWER, "Bot");
        AddRandomColorlessCopy(rColorlessCopy2BotDrawPQty, "BotDrawPile");
    }

    // Upgraded stats.
    @Override
    public void upgrade()
    {
        if (!upgraded)
        {
            upgradeName();
            rAttackCopy2DrawPQty = UPGRADE_rAttackCopy2DrawPQty;
            rSkillCopy2DrawPQty = UPGRADE_rSkillCopy2DrawPQty;
            rPowerCopy2DrawPQty = UPGRADE_rPowerCopy2DrawPQty;
            rColorlessCopy2DrawPQty = UPGRADE_rColorlessCopy2DrawPQty;
            rAttackCopy2TopDrawPQty = UPGRADE_rAttackCopy2TopDrawPQty;
            rSkillCopy2TopDrawPQty = UPGRADE_rSkillCopy2TopDrawPQty;
            rPowerCopy2TopDrawPQty = UPGRADE_rPowerCopy2TopDrawPQty;
            rColorlessCopy2TopDrawPQty = UPGRADE_rColorlessCopy2TopDrawPQty;
            rAttackCopy2BotDrawPQty = UPGRADE_rAttackCopy2BotDrawPQty;
            rSkillCopy2BotDrawPQty = UPGRADE_rSkillCopy2BotDrawPQty;
            rPowerCopy2BotDrawPQty = UPGRADE_rPowerCopy2BotDrawPQty;
            rColorlessCopy2BotDrawPQty = UPGRADE_rColorlessCopy2BotDrawPQty;
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}