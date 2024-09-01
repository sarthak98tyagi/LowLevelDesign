package Cricbuzz;

public class T20 implements MatchFormat{
    @Override
    public int getOvers() {
        return 20;
    }

    @Override
    public int getPerBowlerOver() {
        return 4;
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
