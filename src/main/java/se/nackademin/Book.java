package se.nackademin;

public class Book implements Items {
    private String titel;
    private int releaseYear;
    private int pageCount;
    
    
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

    public boolean setPageCount(int newPageCount){
        try{
            if(newPageCount <= 0){
                return false;
            }
            else{
                pageCount = newPageCount;
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

    public String getTitle(){
        return titel;
    }

    public int getPageCount(){
        return pageCount;
    }

    public int getReleaseYear(){
        return releaseYear;
    }

}
