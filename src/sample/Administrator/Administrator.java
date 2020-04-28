package sample.Administrator;

public enum Administrator{
    Administrator1("admin1","admin1");

    private String administratorBrukernavn;
    private String administratorPassord;

    public String getAdministratorBrukernavn(){
        return this.administratorBrukernavn;
    }
    public String getAdministratorPassord(){
        return this.administratorPassord;
    }


    // enum constructor - can not be public or protected
    Administrator(String administratorBrukernavn,String administratorPassord){
        this.administratorBrukernavn = administratorBrukernavn;
        this.administratorPassord=administratorPassord;
    }
}

