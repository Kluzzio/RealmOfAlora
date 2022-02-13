package kluzzio.roa.api.interfaces;

public interface IDevotionEntity {
    void increaseDevotion(int amount);

    void decreaseDevotion(int amount);

    int getMaxDevotion();

    int getDevotion();

    void setDevotion(int devotion);
}