package Cricbuzz;

public class ODI implements MatchFormat{
    @Override
    public int getOvers() {
        return 50;
    }

    @Override
    public int getPerBowlerOver() {
        return 10;
    }

    @Override
    public int getInningsCount() {
        return 2;
    }

    @Override
    public int getMaxDurationDays() {
        return 2;
    }
}
