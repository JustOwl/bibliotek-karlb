package se.nackademin;

public interface Items {
    public String titel = "No Titel given";
    public int releaseYear = 0;

    boolean setTitel(String newTitel);
    boolean setReleaseYear(int newYear);
}
