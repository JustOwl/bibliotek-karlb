package se.nackademin;

public class Music implements Items{
    private int releaseYear;
    private String titel;
    private float minutes;

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

    public boolean setMinutes(float newMinute) {
        try{
            if(newMinute <= 0){
                return false;
            }
            else{
                //From Stackoverflow at https://stackoverflow.com/a/34367413
                int y = (int) Math.floor(newMinute % 1d * 100);

                if(y >= 60){
                    return false;
                }
                minutes = newMinute;
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

    public float getMinutes(){
        return minutes;
    }
}
