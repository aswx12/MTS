/*package myMod.cards.CustomCards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import myMod.DefaultMod;
import myMod.cards.AbstractDynamicCard;
import myMod.characters.TheDefault;

import static myMod.DefaultMod.makeCardPath;

import javax.xml.transform.Templates;
import java.io.File;

public class Test extends AbstractDynamicCard
{

    String cardImage;
    // public static final String ID = DefaultMod.makeID(${NAME}.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String ID = DefaultMod.makeID("Test"); // DELETE THIS ONE.
    public final String IMG = makeCardPath("Attack.png");// "public static final String IMG = makeCardPath("${NAME}.png");
    // This does mean that you will need to have an image with the same NAME as the card in your image folder for it to run correctly.

    // /TEXT DECLARATION/


    // STAT DECLARATION
    int cost;
    int upgradedCost;
    int damage;

    int upgradedDamage;
    private static final CardRarity RARITY = CardRarity.COMMON; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private  final int COST=cost;  // COST = ${COST}
    private  final int UPGRADED_COST = upgradedCost; // UPGRADED_COST = ${UPGRADED_COST}

    private  final int DAMAGE = damage;    // DAMAGE = ${DAMAGE}
    private  final int UPGRADE_PLUS_DMG = upgradedDamage;  // UPGRADE_PLUS_DMG = ${UPGRADED_DAMAGE_INCREASE}

    public Test(String id, String img, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target)
    {
        super(id, img, cost, type, color, rarity, target);
    }

    public void SetStats(int cost,int upgradedCost,int damage,int upgradedDamage)
    {
        this.cost=cost;
        this.upgradedCost=upgradedCost;
        this.damage=damage;
        this.upgradedDamage=upgradedDamage;
    }

    // /STAT DECLARATION/

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
    }
}*/
