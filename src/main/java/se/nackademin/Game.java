package se.nackademin;

public class Game implements Items{
    private int releaseYear;
    private String titel;
    private int howLongToBeat;

    @Override
    public boolean setTitel(String newTitel) {
        try{
            if(newTitel.length() <= 0 || newTitel == null){
                return false;
            }
            else{
                titel = newTitel;
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean setReleaseYear(int newYear) {
        try{
            if(newYear <= 0){
                return false;
            }
            else{
                releaseYear = newYear;
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean setHowLongToBeat(int newValue) {
        try{
            if(newValue <= 0){
                return false;
            }
            else{
                howLongToBeat = newValue;
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getTitle(){
        return titel;
    }

    public int getReleaseYear(){
        return releaseYear;
    }

    public int getHowLongToBeat(){
        return howLongToBeat;
    }
}
