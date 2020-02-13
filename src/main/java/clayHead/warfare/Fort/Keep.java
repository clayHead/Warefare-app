package clayHead.warfare.Fort;

public class Keep extends Fort {
    public Keep() {
        this.level = 1;
        this.sizeMax = 6; 
        this.moralBonus = 2; 
        this.toughness = 22;
        this.sizeCurrent = this.sizeMax;
    }

    public Keep(int level) {
        if (level > 0 && level <= 5) this.level = level;
        else this.level = 1;
        switch (this.level) {
            case 1 : this.sizeMax = 6; this.moralBonus = 2; this.toughness = 22;   break;
            case 2 : this.sizeMax = 8; this.moralBonus = 4; this.toughness = 24;   break;
            case 3 : this.sizeMax = 10; this.moralBonus = 6; this.toughness = 26;  break;
            case 4 : this.sizeMax = 12; this.moralBonus = 8; this.toughness = 28;  break;
            case 5 : this.sizeMax = 20; this.moralBonus = 10; this.toughness = 30; break;
            default: System.out.println("Error!");
        }
        this.sizeCurrent = this.sizeMax;
    }

    public String toString() {
        return "Keep";
    }
}