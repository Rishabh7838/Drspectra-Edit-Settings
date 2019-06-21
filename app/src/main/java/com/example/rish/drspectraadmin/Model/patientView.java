package com.example.rish.drspectraadmin.Model;

public class patientView {
    String Name;
    String Number;
    String Session;
    String THI_Score;

    public patientView(String name, String number, String sessions, String tHI_Score) {
        this.Name = name;
        this.Number = number;
        this.Session = sessions;
        this.THI_Score = tHI_Score;
    }

    public String getSession() {
        return this.Session;
    }

    public void setSession(String session) {
        this.Session = session;
    }

    public String getTHI_Score() {
        return this.THI_Score;
    }

    public void setTHI_Score(String THI_Score) {
        this.THI_Score = THI_Score;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNumber() {
        return this.Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }
}

