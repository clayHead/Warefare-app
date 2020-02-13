package clayHead.warfare.Fort;

public class Tower extends Fort {
    public Tower() {
        this.level = 1;
        this.sizeMax = 4;
        this.moralBonus = 1;
        this.toughness = 18;
        this.sizeCurrent = this.sizeMax;
    }

    public Tower(int level) {
        if (level > 0 && level <= 5) this.level = level;
        else this.level = 1;
        switch (this.level) {
            case 1 : this.sizeMax = 4; this.moralBonus = 1; this.toughness = 18;  break;
            case 2 : this.sizeMax = 6; this.moralBonus = 2; this.toughness = 20;  break;
            case 3 : this.sizeMax = 8; this.moralBonus = 3; this.toughness = 22;  break;
            case 4 : this.sizeMax = 10; this.moralBonus = 4; this.toughness = 24; break;
            case 5 : this.sizeMax = 12; this.moralBonus = 5; this.toughness = 26; break;
            default: System.out.println("Error!");
        }
        this.sizeCurrent = this.sizeMax;
    }

    public String toString() {
        return "Tower";
    }
}